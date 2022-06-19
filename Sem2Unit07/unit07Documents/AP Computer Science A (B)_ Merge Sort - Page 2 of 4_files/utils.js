﻿//#region cx (Connexus)
var cx;
(function (cx) {
	'use strict';

	//#region cx.utils
	(function (utils) {
		//#region Constants
		var LOG_APPLICATION = 'Utils';
		//#endregion

		//#region Variables
		utils.isConsoleLoggingEnabled;
		//#endregion

		//#region utils
		function docReady(isLoggingEnabled) {
			if (typeof isLoggingEnabled === "undefined") {
				isLoggingEnabled = false;
			}

			if (utils.isConsoleLoggingEnabled)
				utils.logger.log('Console logging is enabled.', LOG_APPLICATION);

			//Public
			utils.isConsoleLoggingEnabled = isLoggingEnabled;
		}

		function throttle(func, delay) {
			var timeoutHasExpired = true;
			return function () {
				if (timeoutHasExpired) {
					timeoutHasExpired = false;
					setTimeout(function () { timeoutHasExpired = true; }, delay);
					func.apply(this, arguments);
				}
			};
		}

		//Public
		utils.throttle = throttle;
		utils.docReady = docReady;
		//#endregion

		//#region utils.browser
		(function (browser) {
			function isIE() {
				//Taken from compliantFunction.2.js and placed into namespace.
				var isInternetExplorer = navigator.appName === "Microsoft Internet Explorer" || !!(navigator.userAgent.match(/Trident/) && !navigator.userAgent.match(/MSIE/));
				return isInternetExplorer;
			}

			//Public
			browser.isIE = isIE;
		})(utils.browser || (utils.browser = {}));
		//#endregion

		//#region utils.cookie
		(function (cookie) {
			//09/26/14 - SJK: Sourced from: http://stackoverflow.com/questions/19189785/is-there-a-good-cookie-library-for-javascript

			function clearCookie(cookieName) {
				setCookie(cookieName, '');
			}

			function deleteCookie(cookieName) {
				//Delete by setting the expiration to the past.
				document.cookie = cookieName + '=;expires=Thu, 01 Jan 1970 00:00:01 GMT' + ';path=/';
			}

			function getCookie(cookieName) {
				cookieName = cookieName.toLowerCase();
				var oCrumbles = document.cookie.split(';');

				for (var i = 0; i < oCrumbles.length; i++) {
					var oPair = oCrumbles[i].split('=');
					var sKey = decodeURIComponent(oPair[0].trim().toLowerCase());
					var sValue = oPair.length > 1 ? oPair[1] : '';

					if (sKey == cookieName)
						return decodeURIComponent(sValue);
				}

				return '';
			}

			function setSessionCookie(cookieName, cookieValue) {
				//Create the cookie.
				var sCookie = encodeURIComponent(cookieName) + '=' + encodeURIComponent(cookieValue) + ';expires=0 ' + ';path=/';

				//Set the cookie.
				document.cookie = sCookie;
			}

			function setCookie(cookieName, cookieValue) {
				//Cookie is good for a year by default. If we needed this altered, we should allow for an additional parameter to be passed in (and OR'ed with null).
				var oDate = new Date();
				oDate.setYear(oDate.getFullYear() + 1);

				//Create the cookie.
				var sCookie = encodeURIComponent(cookieName) + '=' + encodeURIComponent(cookieValue) + ';expires=' + oDate.toGMTString() + ';path=/';

				//Set the cookie.
				document.cookie = sCookie;
			}

			//Public
			cookie.deleteCookie = deleteCookie;
			cookie.getCookie = getCookie;
			cookie.setCookie = setCookie;
			cookie.setSessionCookie = setSessionCookie;
		})(utils.cookie || (utils.cookie = {}));
		//#endregion

		//#region utils.debug
		(function (debug) {
			function drawDot(x, y, color) {
				var dot = $('<div/>');
				color = color || 'green';

				dot.css({
					'position': 'fixed',
					'top': y + 'px',
					'left': x + 'px',
					'background': color,
					'opacity': '0.4',
					'border-radius': '100px',
					'width': '10px',
					'height': '10px',
					'z-index': '999999'
				});

				$('body').prepend(dot);
			}

			//Public
			debug.drawDot = drawDot;
		})(utils.debug || (utils.debug = {}));
		//#endregion

		//#region utils.logger
		(function (logger) {
			function log(msg, application, useTimeStamp) {
				try {
					if ((utils.isConsoleLoggingEnabled === true) && (console)) {
						//Application is the current application or component we are logging in. If defined, we prefix our log entry with this.
						if (typeof (application) !== "undefined") {
							msg = application.toUpperCase() + ' - ' + msg;
						}

						//Use the timestamp by default.
						if (typeof (useTimeStamp) === "undefined") {
							useTimeStamp = true;
						}

						if (useTimeStamp) {
							//07/23/14 - SJK: Zero-pad values to two digits.
							var myDate = new Date();
							var myDateString =
								('0' + myDate.getHours()).slice(-2) + ":" +
								('0' + myDate.getMinutes()).slice(-2) + ":" +
								('0' + myDate.getSeconds()).slice(-2) + ":" +
								('00' + myDate.getMilliseconds()).slice(-3);

							console.log(myDateString + ': ' + msg);
						} else
							console.log(msg);
					}
				} catch (err) {
				}
			}

			//Public
			logger.log = log;
		})(utils.logger || (utils.logger = {}));
		//#endregion

		//#region utils.storage
		(function (storage) {
			var _isStorageEnabled = null;

			function clear(provider) {
				provider.clear();
			}

			function hasItem(provider, key) {
				//Pre-checks
				//The key must be a string. If it's not, throw an error.
				if (!utils.type.isString(key)) {
					throw 'key must be a string.';
				}

				if (provider) {
					var value = provider.getItem(key);

					if (value) {
						return (true);
					}
					return false;
				}
				return false;
			}

			function getItem(provider, key) {
				//Pre-checks
				//The key must be a string. If it's not, throw an error.
				if (!utils.type.isString(key))
					throw 'key must be a string.';

				if (provider) {
					var value = provider.getItem(key);

					//Everything is stored as a string, but some are pure strings, some are serialized JSON objects, etc. We need to check what we have
					//before parsing as parsing a non-JSON string causes an exception.
					if (value)
						return (utils.type.isJson(value)) ? JSON.parse(value) : value;
				}

				return null;
			}

			function getItemCount(provider) {
				return (provider) ? provider.length : 0;
			}

			function isStorageEnabled(provider, invalidatePreviousCheck) {
				try {
					//Logically, one check per page load should be enough to identify the state of storage as it's not going to change during the course
					//of that page lifecycle. Therfore, we keep track of the first check by way of isStorageEnabled. Unless isStorageEnabled is called 
					//with invalidatePreviousCheck set to true, we always default to the first time we ran the check.
					if (!invalidatePreviousCheck && _isStorageEnabled) {
						return _isStorageEnabled;
					} else {
						var testKey = 'lsTestKey';
						var testValue = 'lsTestValue';

						//Set the item, retrieve the value, then remove the item. We'll test the value below.
						provider.setItem(testKey, testValue);
						var value = provider.getItem(testKey);
						provider.removeItem(testKey); //clean-up

						//Store the result locally, then return true if the retrieved value is the same as the stored; otherwise, return false.
						_isStorageEnabled = ((value !== null) && (value === testValue));
						return _isStorageEnabled;
					}
				} catch (e) {
					//We are conservative here and call any error as local storage being disabled as it most likely is that case.
					return false;
				}
			}

			function removeItem(provider, key) {
				if (key && utils.type.isString(key)) {
					provider.removeItem(key);
				}
			}

			function setItem(provider, key, value) {
				//Pre-checks
				//The key must be a string. If it's not, throw an error.
				if (!utils.type.isString(key))
					throw 'key must be a string.';

				if (provider) {
					//Strings serialize easily but anything else does not and needs to be stringified.
					if (utils.type.isString(value))
						provider.setItem(key, value);
					else
						provider.setItem(key, JSON.stringify(value));
				}
			}

			//Public
			storage.clear = clear;
			storage.getItem = getItem;
			storage.getItemCount = getItemCount;
			storage.hasItem = hasItem;
			storage.isStorageEnabled = isStorageEnabled;
			storage.removeItem = removeItem;
			storage.setItem = setItem;
		})(utils.storage || (utils.storage = {}));
		//#endregion

		//#region utils.localStorage
		//We should be able to wrap storage a bit better rather than using pass-through methods, but this works for now.

		/*
		 * localStorage is persistent beyond closing the browser tab/window and can be accessed across tabs/windows.
		 * http://www.w3.org/TR/webstorage/#the-localstorage-attribute
		 */
		(function (localStorage) {
			var provider = window.localStorage;

			function clear() {
				utils.storage.clear(provider);
			}

			function hasItem(key) {
				return utils.storage.hasItem(provider, key);
			}

			function getItem(key) {
				return utils.storage.getItem(provider, key);
			}

			function getItemCount() {
				return utils.storage.getItemCount(provider);
			}

			function isStorageEnabled() {
				return utils.storage.isStorageEnabled(provider);
			}

			function removeItem(key) {
				utils.storage.removeItem(provider, key);
			}

			function setItem(key, value) {
				utils.storage.setItem(provider, key, value);
			}

			//Public
			localStorage.clear = clear;
			localStorage.hasItem = hasItem;
			localStorage.getItem = getItem;
			localStorage.getItemCount = getItemCount;
			localStorage.isStorageEnabled = isStorageEnabled;
			localStorage.removeItem = removeItem;
			localStorage.setItem = setItem;
		})(utils.localStorage || (utils.localStorage = {}));
		//#endregion

		//#region utils.sessionStorage
		//We should be able to wrap storage a bit better rather than using pass-through methods, but this works for now.

		/* sessionStorage is only valid for the current tab/window. It is inaccessible in another tab. It is non-persistent and expires when the tab/window closes.
		 * http://www.w3.org/TR/webstorage/#the-sessionstorage-attribute
		 */
		(function (sessionStorage) {
			var provider = window.sessionStorage;

			function clear() {
				utils.storage.clear(provider);
			}

			function getItem(key) {
				return utils.storage.getItem(provider, key);
			}

			function getItemCount() {
				return utils.storage.getItemCount(provider);
			}

			function isStorageEnabled() {
				return utils.storage.isStorageEnabled(provider);
			}

			function removeItem(key) {
				utils.storage.removeItem(provider, key);
			}

			function setItem(key, value) {
				utils.storage.setItem(provider, key, value);
			}

			//Public
			sessionStorage.clear = clear;
			sessionStorage.getItem = getItem;
			sessionStorage.getItemCount = getItemCount;
			sessionStorage.isStorageEnabled = isStorageEnabled;
			sessionStorage.removeItem = removeItem;
			sessionStorage.setItem = setItem;
		})(utils.sessionStorage || (utils.sessionStorage = {}));
		//#endregion

		//#region utils.string
		(function (string) {
			function localize(key) {
				//Convert any arguments to a real array.
				var args = Array.prototype.slice.call(arguments);

				//Get the localized string value at the specified key. If not found, return an empty value.
				var value = $('div#localizedstrings [data-key="' + key + '"]').attr('data-value') || '';

				//Shift the key argument out, so that all we have are arguments we need to replace (think String.Format in .NET using {0}, {1}, etc.)
				args.shift();

				//If we have arguments, replace them in the string.
				if (args.length > 0)
					value = value.replace(/\{(\d+)\}/g, function (full, idx) {
						return args[idx];
					});

				return value;
			}

			function getBaseUrl() {
				if (!window.location.origin) {
					return window.location.protocol + "//" + window.location.hostname + (window.location.port ? ':' + window.location.port : '');
				} else {
					return window.location.origin;
				}
			}

			//Public
			string.localize = localize;
			string.getBaseUrl = getBaseUrl;
		})(utils.string || (utils.string = {}));
		//#endregion

		//#region utils.type
		(function (type) {
			function isArray(value) {
				///<summary>Checks whether the input is an array.</summary>
				if (value)
					return (value instanceof Array);

				return false;
			}

			function isBoolean(value) {
				///<summary>Checks whether the input is a boolean.</summary>
				return isType(value, 'boolean');
			}

			function isJson(value) {
				//03/11/14 - SJK: Check Mic's answer: http://stackoverflow.com/questions/3710204/how-to-check-if-a-string-is-a-valid-json-string-in-javascript-without-using-try
				var isJson = (/^[\],:{}\s]*$/.test(value.replace(/\\["\\\/bfnrtu]/g, '@').replace(/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g, ']').replace(/(?:^|:|,)(?:\s*\[)+/g, '')));

				return isJson;
			}

			function isNumber(value) {
				///<summary>Checks whether the input is a number.</summary>
				//TODO: 03/27/14 - SJK: This needs a bit more shaping up. I'm not trusting this yet.
				return isType(value, 'number');
			}

			function isString(value) {
				///<summary>Checks whether the input is a string.</summary>
				return isType(value, 'string');
			}

			function isType(value, type) {
				///<summary>Checks whether the value is of type.</summary>
				return (value && typeof value === type);
			}

			//Public
			type.isArray = isArray;
			type.isBoolean = isBoolean;
			type.isJson = isJson;
			type.isNumber = isNumber;
			type.isString = isString;
			type.isType = isType;
		})(utils.type || (utils.type = {}));
		//#endregion
	}(cx.utils || (cx.utils = {})));
	//#endregion
})(cx || (cx = {}));
//#endregion


//Invoke the utils start-up upon DOM being ready.
$(function () {
	//04/29/15 - SJK: Ideally, this should be passed in from the outside, but this works for now and doesn't require changes to cx.utils. 
	//Check if the host is a development or integration environment to enable logging.
	isLoggingEnabled = (/^(mydevelopment.connexus.com||integration.connexus.com||localhost)$/.test(window.location.host));

	cx.utils.docReady(isLoggingEnabled);
});