﻿//#region cx (Connexus)
var cx;

(function(cx) {
	'use strict';

	//#region cx.systemMessage
	(function(systemMessage, localStorage, logger, $, moment) {

		//#region SystemMessage JSON Format Example
		/* 04/29/15 - SJK: If any object or property is null on the server, it does not get serialized.
		 
			{
			  "systemMessage": {
				"webMailNotification": {
				  "hasRequiredMessages": true,
				  "webMailMessageCount": 0
				},
				"maintenanceModeNotification": {
				+
				  "secondsBeforeNextCheck": 600,
				  "inMaintenanceMode": true,
				  "maintenanceMessage": "We are improving Connexus for you.",
				  "maintenanceModeDirectory": "/somedirectory",
				  "maintenanceAlert": "System maintenance will begin in 5 minutes.\n\nWe are improving Connexus for you.",
				  "maintenanceModeStart": "2015-04-24T12:40:01.628"
				}
			  }
			}
		 
		 */
		//#endregion

		//#region Constants
		var LOG_APPLICATION = 'SystemMessageClient';
		var LOCAL_STORAGE_KEY = 'SystemMessages';
		var DEFAULT_SECONDS_BEFORE_NEXT_SYSTEM_CHECK = 600;		//10 minutes
		var SCHEDULE_BUFFER_MS = 1000; //1s
		var SYSTEM_MESSAGE_SET_TIMEOUT_ID = "SystemMessageSetTimeoutId";
		//#endregion

		//#region Variables
		var suppressAnnouncements = systemMessage.suppressAnnouncements || false;				//default to false as the vast majority of pages need to check announcements 
		var suppressWebMailCountUpdate = systemMessage.suppressWebMailCountUpdate || false;		//default to false as the vast majority of pages should update the WebMail Count / raise the update event
		var suppressUngradedAssessmentCountUpdate = systemMessage.suppressUngradedAssessmentCountUpdate || false;	
		//#endregion

		//#region Methods

		//Private log wrapper
		function log(msg) {
			if (logger) {
				logger.log(msg, LOG_APPLICATION);
			}
		}

		function initSystemMessage(isPageLoad) {
			//Since we are handling the timeout callback now, we need to remove timeoutId from localstorage.
			systemMessageStorage.removeTimeoutId();

			isPageLoad = isPageLoad || false;

			log('************************************************************************************');
			log('Initializing system message. Is page load: [' + isPageLoad + ']');

			//We first check to see if we already have data in localstorage. If so, check whether we need to issue a server call or whether our data is still current.
			if (systemMessageStorage.hasStoredData()) {
				log('Data in localstorage exists.');

				//Parse what's stored in localstorage.
				var savedSystemMessage = systemMessageStorage.getStoredData();

				//Check whether the locally-retrieved systemMessage object is still current or whether we need to contact the server.
				if (needToContactServer(savedSystemMessage)) {
					//Set a lock on the local system message, so that no other tab or window attempts a call at the same time. 
					//04/29/15 - SJK: This seems superfluous to me. We place a lock for a call that's going to take mere milliseconds only to remove it immediately 
					//thereafter. The likelihood of two or more concurrent calls should be near zero. Is this a case of fear and over-engineering or is there validity to this?

					saveSystemMessage(savedSystemMessage, false, true);

					contactServer(isPageLoad);
				} else {
					//If we dont need to contact the server, we still need to process the saved system message
					//to ensure we update pertinant data. This mostly applies to multi tab/window scenarios.
					//DO NOT update last run time as doing so can skew when request are made to the handler.
					processSystemMessage(savedSystemMessage, false);
				}
			} else {
				contactServer(isPageLoad);
			}
		};

		//#region Handler Interaction

		function contactServer(isPageLoad) {

			//#region Build Request Url
			var requestUrl = '/SystemMessage.ashx';

			//TODO: Determine if it makes more sense to look for the referrer when working this request in the handler. 
			//We are providing information that's not needed for the client to have knowledge of.
			var overrideAllowDatabaseAccess = window.location.pathname == '/_locked/maintenance.aspx';
			requestUrl += '?overrideAllowDatabaseAccess=' + overrideAllowDatabaseAccess;

			//Identify whether this request was the initial page load or a request due to the page being idle. 
			//This gives us metrics to further identify potential for tweaks.
			requestUrl += '&type=' + (isPageLoad ? 'pageload' : 'idle');

			log('Contacting server with request Url: [' + requestUrl + ']');
			//#endregion

			//#region Request & Promises
			//The call should always be asynchronous to not block JavaScript. Older verions of IE required async to be false, 
			//but we no longer support those.,
			(cx.systemMessage.jQueryLatestObject || $).ajax({
				type: "POST",
				url: requestUrl,
				contentType: "application/json; charset=utf-8",
				dataType: "json",
				async: true
				//jQuery promises only work on jQuery v1.5.1+
			}).done(function(result) {
				log("Entered 'done' promise event handler.");
				systemMessageSuccessHandler(result);
			}).fail(function() {
				log("Entered 'fail' promise event handler.");
				//Server request failed. Schedule the next check as that's all we can do.
				scheduleNextCheck();
			});
			//#endregion
		}

		function needToContactServer(systemMessage) {
			//If we don't have a systemMessage object, we must contact the server.
			if (systemMessage == null || systemMessage === undefined) {
				log('systemMessage is null or undefined. Returning true.');
				return true;
			}

			//Determine the last run time of the passed systemMessage object. If we can't extract a value, we must contact the server.
			var lastRunTime = moment(systemMessage.lastRunTime);

			if (isNaN(lastRunTime.valueOf())) {
				log('lastRunTime is not a number. Returning true');
				return true;
			} else {
				log('lastRunTime: [' + lastRunTime + '] as parsed by MomentJS from [' + systemMessage.lastRunTime + ']');
			}

			//Determine the length of the check interval until the next system check. If we cannot obtain this from the passed systemMessage, we assign the default.
			var secondsBeforeNextCheck = DEFAULT_SECONDS_BEFORE_NEXT_SYSTEM_CHECK;

			//If we have a secondsBeforeNextCheck property on maintenanceModeNotification, it should always be quicker than DEFAULT_SECONDS_BEFORE_NEXT_SYSTEM_CHECK.
			if ((systemMessage.maintenanceModeNotification != null) && (systemMessage.maintenanceModeNotification.secondsBeforeNextCheck != null)) {
				secondsBeforeNextCheck = systemMessage.maintenanceModeNotification.secondsBeforeNextCheck;
			}

			var now = new Date();
			var delta = now - lastRunTime;

			//If we exceed the check interval (~10 min) AND are not locked, we must contact the server.
			if ((delta) >= (secondsBeforeNextCheck * 1000) && (systemMessage.lockStorage === false)) {
				log('Past check interval ([' + delta + '] >= [' + secondsBeforeNextCheck * 1000 + ']). Lock storage is false. Returning true.');
				return true;
			}

			//If we exceed the check interval (~10 min) twice (~20 min) AND are locked, we must contact the server. This gives us a fail-safe in case a lock did not get removed.
			if ((delta) >= (secondsBeforeNextCheck * 2000) && (systemMessage.lockStorage === true)) {
				log('Past check interval ([' + delta + '] >= [' + secondsBeforeNextCheck * 2000 + ']). Lock storage is true. Returning true.');
				return true;
			}

			log('No need to contact server at this time. Last runtime was [' + delta + '] ms ago. Returning false.');
			return false;
		};

		function processSystemMessage(systemMessage, setLastRunTime) {
			log('systemMessage.lastRunTime : [' + systemMessage.lastRunTime + ']');

			//Schedule the next check. If there is a secondsBeforeNextCheck in the payload, we used that over the default.
			scheduleNextCheck(systemMessage);

			//Store the system message in localstorage and remove the lock.
			saveSystemMessage(systemMessage, setLastRunTime, false);

			//Raise all appropriate alerts.
			callAlertsForSystemMessage(systemMessage);
		}

		function systemMessageSuccessHandler(result) {
			if (result && result.systemMessage) {
				log('Server result contains systemMessage object.');
				//we must set the last runtime as we are working with a fresh response from the handler.
				processSystemMessage(result.systemMessage, true);
			} else {
				log('Unable to extract systemMessage object from response.');

				//The data was bad. This should only occur if somehow the handler is issuing a bad response. 
				//Schedule the next check as that's all we can do.
				scheduleNextCheck();
			}
		}

		function scheduleNextCheck(systemMessage) {
			//systemMessage or any of its needed properties below can be null in which case we simply default secondsBeforeNextCheck.
			//If the payload from the server does not contain a value for the duration until the next check, apply our default.

			//#region Determine msBeforeNextCheck
			var msBeforeNextCheck = DEFAULT_SECONDS_BEFORE_NEXT_SYSTEM_CHECK * 1000;

			//If we have a systemMessage, check whether we have a secondsBeforeNextCheck in maintenanceMode or whether we can identify 
			//the last run time and check the next call to the server accordingly.
			if (systemMessage != null) {
				//If the message has a maintenance mode notification, use the time till next check from that. This should always have priority over anything else.
				if ((systemMessage.maintenanceModeNotification != null) && (systemMessage.maintenanceModeNotification.secondsBeforeNextCheck != null)) {
					log('systemMessage.maintenanceModeNotification.secondsBeforeNextCheck exists with value [' + systemMessage.maintenanceModeNotification.secondsBeforeNextCheck + '].');
					msBeforeNextCheck = systemMessage.maintenanceModeNotification.secondsBeforeNextCheck * 1000;
				} else if (systemMessage.lastRunTime) {
					//If there is a lastRunTime (this is in ms) in the systemMessage, identify how long ago that was. Schedule the next check accordingly.
					var msSinceLastRun = new Date() - moment(systemMessage.lastRunTime);
					log('msSinceLastRun   : [' + msSinceLastRun + '] ms');
					msBeforeNextCheck = msBeforeNextCheck - msSinceLastRun;
					log('msBeforeNextCheck: [' + msBeforeNextCheck + '] ms');
				}
			}
			//#endregion

			//#region msBeforeNextCheck Buffer
			//Adding a small buffer to the timeout as we've seen rare instances where our scheduling fell just short of the next interval boundary (e.g. 23ms delta, etc. but all less than 1000ms/1s). 
			//In order to mitigate that difference, we add a modest 1 second buffer.

			//When multiple tabs/windows are open, we ABSOLUTELY MUST ENSURE that we are not working on synchronized timers. Doing so would result in concurrent requests to
			//the handler for every open tab/window as the locking mechanism would occur concurrently (i.e. all set to lock but no process sees the other's lock in time).
			//We randomize a number between 0 and 1, then multiply by 10,000 to get a random number between 0 and 10,000 ms / 10s. We add SCHEDULE_BUFFER_MS to this as 
			//we still need to account for the above explained timing glitch.
			var randomNumber = Math.floor(Math.random() * 10000) + SCHEDULE_BUFFER_MS;
			log('randomized ms to be added to check interval: [' + randomNumber + '] ms');
			msBeforeNextCheck += randomNumber;
			//#endregion

			//#region Fail-safe for Negative msBeforeNextCheck
			//05/01/15 - SJK: Sanity check to ensure we never go negative. If we did, we could be in an infinite loop as it would schedule an immediate timeout (-X timeout is 
			//essentially a "run immediate"), turn the delay more negative, and never make a request. I have seen this occur in integration just once (yesterday).
			if (msBeforeNextCheck < 0) {
				log('********* msBeforeNextCheck is negative! [' + msBeforeNextCheck + '] ms *********');
				//We are in a condition we should never be in. Better safe than sorry to whack the old systemMessage object from localstorage and initiate a fresh check shortly.
				log('********* Removing systemMessage from localstorage to initiate fresh check. *********');
				systemMessageStorage.removeStoredData();
				msBeforeNextCheck = SCHEDULE_BUFFER_MS;
				log('********* Set msBeforeNextCheck to SCHEDULE_BUFFER_MS: [' + msBeforeNextCheck + '] ms *********');
			}
			//#endregion

			//#region Set Timeout for Next Check
			//Check to ensure a next timeout is not already scheduled. There are cases where this could have been the case previously (error conditions, mostly).
			if (systemMessageStorage.hasTimeoutId()) {
				log('SetTimeout already exists. We need to cancel the current one and replace it with the new one.');

				var timeoutId = systemMessageStorage.getTimeoutId();

				//Cancel the old timeout.
				window.clearTimeout(timeoutId);
			}

			log('Set next occurence of initSystemMessage to occur in [' + msBeforeNextCheck + '] ms (includes [' + randomNumber + '] ms buffer).');
			var timeoutId = window.setTimeout(function() { cx.systemMessage.initSystemMessage(false); }, msBeforeNextCheck);
			log('New timeoutId: [' + timeoutId + ']');

			//Store the new timeoutId in localstorage.
			systemMessageStorage.setTimeoutId(timeoutId);

			//#endregion
		}

		//#endregion

		//#region Local System Storage

		function saveSystemMessage(systemMessage, setLastRunTime, setLock) {
			//Add locking properties and time of last run.
			systemMessage.lockStorage = setLock;

			//Only set the last runtime if explicitly set to do so.
			if (setLastRunTime) {
				systemMessage.lastRunTime = new Date();
			}

			log('Saving system message to localstorage with lock [' + systemMessage.lockStorage + '] and last runtime [' + systemMessage.lastRunTime + '].');

			//Save system message to localstorage.
			var serializedSystemMessage = JSON.stringify(systemMessage);
			systemMessageStorage.setStoredData(serializedSystemMessage);
		};

		//#region systemMessageStorage

		var systemMessageStorage = {
			getTimeoutId: function() {
				if (localStorage.isStorageEnabled()) {
					return localStorage.getItem(SYSTEM_MESSAGE_SET_TIMEOUT_ID);
				}

				return null;
			},

			getStoredData: function() {
				if (localStorage.isStorageEnabled()) {
					return localStorage.getItem(LOCAL_STORAGE_KEY);
				}

				return null;
			},

			hasTimeoutId: function() {
				if (localStorage.isStorageEnabled()) {
					return localStorage.hasItem(SYSTEM_MESSAGE_SET_TIMEOUT_ID);
				}

				return false;
			},

			hasStoredData: function() {
				if (localStorage.isStorageEnabled()) {
					return localStorage.hasItem(LOCAL_STORAGE_KEY);
				}

				return false;
			},

			removeTimeoutId: function() {
				if (localStorage.isStorageEnabled()) {
					localStorage.removeItem(SYSTEM_MESSAGE_SET_TIMEOUT_ID);
				}
			},

			removeStoredData: function() {
				if (localStorage.isStorageEnabled()) {
					localStorage.removeItem(LOCAL_STORAGE_KEY);
				}
			},

			setTimeoutId: function(value) {
				if (localStorage.isStorageEnabled()) {
					localStorage.setItem(SYSTEM_MESSAGE_SET_TIMEOUT_ID, value);
				}
			},

			setStoredData: function(value) {
				if (localStorage.isStorageEnabled()) {
					localStorage.setItem(LOCAL_STORAGE_KEY, value);
				}
			}
		};

		//#endregion

		//#endregion

		//#region Alert Callers
		function callAlertsForSystemMessage(systemMessage) {

			raiseAlert.webMail(systemMessage);
			raiseAlert.ungradedAssessment(systemMessage);
			raiseAlert.announcement(systemMessage);

			if (systemMessage.maintenanceModeNotification) {
				raiseAlert.maintenanceMode(systemMessage.maintenanceModeNotification);
			}
		};

		var raiseAlert = {
			webMail: function(systemMessage) {
				log("suppressWebMailCountUpdate [" + suppressWebMailCountUpdate + "]");

				if (!suppressWebMailCountUpdate) {
					//Continue only if the whether the webMail count exists in the payload.
					if (systemMessage && systemMessage.webMailNotification && typeof(systemMessage.webMailNotification.webMailMessageCount) !== 'undefined') {
						//Extract the message count from the payload.
						var webMailCount = systemMessage.webMailNotification.webMailMessageCount;

						//#region Raise webMailCountUpdate Event
						log('Raising event webMailCountUpdate with count [' + webMailCount + '].');

						//Trigger the webMailCountUpdate event with the count as the payload.
						$.event.trigger('webMailCountUpdate', { count: webMailCount });

						log('Raised webMailCountUpdate event.');
						//#endregion

						//#region Legacy Header WebMail Notification (to be deprecated mid-2015)
						//Unfortunately, we still need to support the old header until the new header completely replaces it.
						//*** This entire region should be removed later on as part of a clean-up effort. ***
						try {
							if (webMailCount > 0) {
								//#region newWebmailIndicator Function
								if (parent && parent.IconBar) {
									log('OLD HEADER: parent.IconBar exists. Proceeding with showing new webmail indicator.');
									parent.IconBar.showNewWebmailIcon();
								}

								if (opener && opener.IconBar) {
									log('OLD HEADER: opener.IconBar exists. Proceeding with showing new webmail indicator.');
									opener.IconBar.showNewWebmailIcon();
								}

								if (IconBar) {
									log('OLD HEADER: IconBar exists. Proceeding with showing new webmail indicator.');
									IconBar.showNewWebmailIcon();
								}
								//#endregion
							} else {
								//04/29/15 - SJK: Why doesn't systemMessageClient.js update all applicable IconBar WebMail icons 
								//like we do when we have a count above?
								if (IconBar) {
									log('OLD HEADER: IconBar exists. Proceeding with showing regular webmail indicator.');
									IconBar.showRegularWebmailIcon();
								}
							}
						} catch (e) {
						}

					}
					//#endregion
				}
			},

			ungradedAssessment: function(systemMessage) {
				if (!suppressUngradedAssessmentCountUpdate && systemMessage && systemMessage.ungradedAssessmentCount) {

					log('Raising event ungradedAssessmentCountUpdate with count [' + systemMessage.ungradedAssessmentCount + '].');

					$.event.trigger('ungradedAssessmentCountUpdate', { count: systemMessage.ungradedAssessmentCount });

					log('Raised ungradedAssessmentCountUpdate event.');
				}
			},

			announcement: function(systemMessage) {
				//announcement alert event call
				log('suppressAnnouncements: [' + suppressAnnouncements + ']');

				//04/30/15 - SJK: The original systemMessageClient.js has code in line 162 that looks for the webmail path to suppress showing the announcement overlay when in WebMail.
				//We no longer do this as we now set cx.systemMessage.suppressAnnouncements in WebMail (only focusing on new WebMail, not classic here).

				//Only continue if we are not suppressing any announcements.
				if (!suppressAnnouncements) {
					//Check whether we have any read required webmail messages.
				    if (systemMessage && systemMessage.webMailNotification && systemMessage.webMailNotification.hasRequiredMessages && systemMessage.webMailNotification.hasRequiredWebmailPermission) {
						log('A required message was found.');

						//05/29/15 - SJK: Added comments from Nick Kurlick's changeset 60566:
						//Set the hasRequiredMessages property to false for the systemMessage and saving it to the localStorage whenever the announcement popup is displayed. 
						//This ensures that the announcement popup is only displayed once for a mustread/announcement message and then won't be displayed again for those same ones until a new must read / announcement is sent.
						systemMessage.webMailNotification.hasRequiredMessages = false;
						saveSystemMessage(systemMessage, false, false);

						//#region Announcement Overlay
						//If the announcements overlay does not yet exist, create and show it.
						setTimeout(function() {
							if ($('.systemAnnouncementsOverlay').length === 0) {
								$.fn.cxLitbox.cxlGetType("#cxlAnnouncement", {
									createType: "get",
									className: "systemAnnouncementsOverlay",
									noHashChange: true,
									tabFocus: ".cxlContent",
									loadingMessage: "Loading...",
									title: "Message Alert",
									footer: '<a href="/webmail/" class="cxBtn cxPrimaryBtn"><span class="btnContent">Go To WebMail</span></a>',
									createMethod: function() {
										var newHtml = '<p>You have messages that require reading.</p>';
										var deferred = $.Deferred();
										deferred.resolve(newHtml);
										return deferred.promise();
									}
								});
							} else {
								log('The announcements overlay is still open. No action necessary.');
							}
						}, 500);
						//#endregion
					}
				}
			},

			maintenanceMode: function(notification) {
				//maintenance mode alert event call

				//TODO: Look at systemMessageClient.js (line 130) for historic implementation. We need to see what this should look going forward.
				if (notification && !notification.inMaintenanceMode && notification.maintenanceAlert) {
					log('maintenance mode is active');

					//Determine in how many minutes maintenance mode will start.
					var minsToStart = Math.round((moment(notification.maintenanceModeStart) - new Date()) / 60000);
					log('maintenance mode will start in [' + minsToStart + '] min(s).');

					if (minsToStart >= 0) {
						//If a directory is put into maintenance mode, then the alert should only happen in that directory.
						if (notification.maintenanceModeDirectory) {
							log('maintenanceModeDirectory: [' + notification.maintenanceModeDirectory + ']');

							//Get current directory in URL.
							var url = location.href.toLowerCase();
							url = url.substr(url.indexOf("//") + 2);
							url = url.substr(url.indexOf("/"));

							//There may be multiple directories being protected.
							var directories = notification.maintenanceModeDirectory.split(",");

							for (var i = 0; i < directories.length; i++) {
								//Trim any whitespace.
								var directory = directories[i].replace(/^\s+/, '').replace(/\s+$/, '');

								if ((url.indexOf('/errors/') === -1) && (url.indexOf('/_locked/') === -1) && (url.substr(0, directory.length) === directory.toLowerCase())) {

									//#region Maintenance Mode Overlay
									//If the Maintenance Mode overlay does not yet exist, create and show it.
									setTimeout(function() {
										if ($('.maintenanceModeOverlay').length === 0) {
											$.fn.cxLitbox.cxlGetType("#cxlMaintenance", {
												createType: "get",
												className: "maintenanceModeOverlay",
												noHashChange: true,
												tabFocus: ".cxlContent",
												loadingMessage: "Loading...",
												title: "Maintenance Mode Notification",
												footer: '<a href="javascript:void(0)" class="cxBtn cxPrimaryBtn"><span class="btnContent">Close</span></a>',
												createMethod: function() {
													var newHtml = '<p>' + notification.maintenanceAlert + '</p>';
													var deferred = $.Deferred();
													deferred.resolve(newHtml);
													setTimeout(function() {
														$('.maintenanceModeOverlay .cxPrimaryBtn').click(function() {
															$('.maintenanceModeOverlay .cxlClose').click();
														});
													});
													return deferred.promise();
												}
											});
										} else {
											log('The maintenance mode overlay is still open. No action necessary.');
										}
									}, 500);
									//#endregion

								}
							}
						}
					}
				}
			}
		};
		//#endregion

		//#endregion

		//#region Public Methods
		systemMessage.initSystemMessage = initSystemMessage;
		//#endregion

		//#region Public Properties
		systemMessage.suppressAnnouncements = suppressAnnouncements;
		systemMessage.suppressWebMailCountUpdate = suppressWebMailCountUpdate;
		//#endregion

	})(cx.systemMessage || (cx.systemMessage = {}), cx.utils.localStorage || (cx.utils.localStorage = {}), cx.utils.logger || (cx.utils.logger = {}), jQuery, moment);
	//#endregion
})(cx || (cx = {}));
//#endregion


/*
 * This systemMessageClient.js will be bound to every page of v2.
 * The ajax in this js should be updated with latest jQuery version 3.5.1 or above.
 * We are checking the latest jQuery version number and conclude whether to load jQuery version 3.5.1 or not. If the latest jQuery version number is 3.5.1 or above, we use the existing jQuery object, otherwise we are loading jQuery 3.5.1.
 * while upgrading the latest jQuery in V2, we are using the jQueryLatestVersion object to refer to the latest jQuery object in the no-conflict scenarios.
 * So, to get the jQuery version number is every pages, the both "jQueryLatestVersion" and "$" object is used in the following codes.
 */
var jQueryLatestVersion = jQueryLatestVersion || undefined;

$(function() {

    const jQueryLatestVersionNumber = "3.5.1";

	var cdnJqueryScript;
	var localJqueryScript;
    var jQueryLatestObject;
    var jQueryVersionNumber;

    if (jQueryLatestVersion != undefined) {
        jQueryVersionNumber = jQueryLatestVersion.fn.jquery;
        jQueryLatestObject = jQueryLatestVersion;
    } else {
        jQueryVersionNumber = $.fn.jquery;
        jQueryLatestObject = $;
    }

    var parsedVersion = parseVersionString(jQueryVersionNumber);
    //Prerequisite is to verify jQuery version.
    if (parsedVersion == false ||
        !(parsedVersion.major >= 3 ||
            (parsedVersion.major == 3 && parsedVersion.minor >= 5 && parsedVersion.patch >= 1))) {
        jQueryVersionNumber = jQueryLatestVersionNumber;

        //Both "$" and "jQueryLatestVersion" objects refer to the jQuery object.
        //"$" refers to any jQuery version object.
        //"jQueryLatestVersion" refers to jQuery 3.5.1 object.
        //In the above if ..else .. statement, if any page containing this "systemMessageClient.js" having "jQueryLatestVersion object, this object is assigned to jQueryLatestObject variable. 
        //Otherwise, "$" is assigned to jQueryLatestObject variable.
        //the current if condition will be executed, if the "jQueryLatestObject" object version is lesser than 3.5.1.
        //if the "jQueryLatestObject" is pointing out lesser than 3.5.1, we are making that variable as "undefined" as below.
        jQueryLatestObject = undefined;
    }

    if (jQueryLatestObject == undefined) {
        cdnJqueryScript = document.createElement('script');
        cdnJqueryScript.src = "https://ajax.googleapis.com/ajax/libs/jquery/" +
            jQueryVersionNumber +
            "/jquery.min.js";
        document.getElementsByTagName('head')[0].appendChild(cdnJqueryScript);
        cdnJqueryScript.onload = onLoadScriptHandler;
        cdnJqueryScript.onerror = onErrorScriptHandler;
	} else {
        //jQueryLatestObject property is created in cx.systemMessage object and the latest jQuery Object is assigned as below.
        //We will make use of this jQueryLatestObject property in cx.systemMessage's ajax calls.
        cx.systemMessage.jQueryLatestObject = jQueryLatestObject;
        cx.systemMessage.initSystemMessage(true);
    }

	/**
	 * Once the jQuery version as mentioned in jQueryLatestVersionNumber constant variable is loaded, this handler will be executed.
	 */
    function onLoadScriptHandler() {
		jQueryLatestObject = jQuery.noConflict(true);
		//jQueryLatestObject property is created in cx.systemMessage object and the latest jQuery Object is assigned as below.
        //We will make use of this jQueryLatestObject property in cx.systemMessage's ajax calls.
        cx.systemMessage.jQueryLatestObject = jQueryLatestObject;
        cx.systemMessage.initSystemMessage(true);
    }

	/**
	 * If any errors on loading jQuery from CDN, this handler tries to load the jQuery from the local server.
	 */
    function onErrorScriptHandler() {
        localJqueryScript = document.createElement('script');
        localJqueryScript.src = "/js/jQuery/" + jQueryVersionNumber + "/jquery.min.js";
        document.getElementsByTagName('head')[0].appendChild(localJqueryScript);
        localJqueryScript.onload = onLoadScriptHandler;
        localJqueryScript.onerror = function() {
            jQueryLatestObject = $;
            cx.systemMessage.jQueryLatestObject = jQueryLatestObject;
            cx.systemMessage.initSystemMessage(true);
        };
    }

	/**
	 * It will create a version object on the given string.
	 * @param {any} jQueryVersion
	 */
	function parseVersionString(jQueryVersion) {
		if (typeof (jQueryVersion) != 'string') {
            return false;
        }
		var x = jQueryVersion.split('.');
        // parse from string or default to 0 if can't parse
        var maj = parseInt(x[0]) || 0;
        var min = parseInt(x[1]) || 0;
        var pat = parseInt(x[2]) || 0;
        return {
            major: maj,
            minor: min,
            patch: pat
        };
    }

});