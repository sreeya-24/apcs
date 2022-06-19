// JS for cxAlert and cxLightbox
// Requires Jquery 1.7
// cxAlert - Accepts a message string, a message type [optional], and duration [optional], and template [optional] 
"use strict";
(function ($) {
    // Static HTML Template
    $.fn.cxAlert = function (message, type, duration, tpl) {
        // Put passed parameters into one object
        var setOptions = {
            message: message,
            type: type,
            duration: duration,
            tpl: tpl
        };
        // These are the defaults
        var defaults = {
            message: "Success!",
            type: "general",
            duration: 2500,
            tpl: '<div class="cxAlert" role="alert" style="display: none;"><div class="cxaMessage"><p><span class="icon" role="presentation"></span><span class="cxaMessageTxt"></span></p></div></div>'
        };
        // Merge w defaults
        var cxa = $.extend(defaults, setOptions);
        // Remove  any existing overlays
        $(".cxAlert").remove();
        $("body").prepend(cxa.tpl);
        $(".cxaMessageTxt").html(cxa.message);
        $(".cxaMessage").addClass(cxa.type);
        switch (cxa.type) {
            case "saved":
                // Saved messages get a confirmIcon
                $(".cxaMessage .icon").addClass("cxIcon confirmIcon");
                break;
            case "deleted":
                // Deleted messages get a deletedBigIcon
                $(".cxaMessage .icon").addClass("cxIcon deleteBigIcon");
                break;
            case "error":
                // Error messages get a invalidIcon
                $(".cxaMessage .icon").addClass("cxIcon invalidIcon");
                break;
        }
        $(".cxAlert").fadeIn(300, function () {
            // remove alert role so screen readers won't repeat on Fade Out
            $(".cxAlert").removeAttr("role");
        }).addClass("cxAlertVisible").delay(cxa.duration).fadeOut(300, function () {
            $(".cxAlert").remove();
        });
    };
    // cxLitbox - targets an element for binding a click, accepts several options and global defaults	
    $.fn.cxLitbox = function (options) {
        // base variables		
        var cxlHash;
        var cxlId;
        var target = this;
        // default get and template functions
        var defaultGet = function (url) {
            var deferred = $.Deferred();
            var result = "test";
            $.ajax({
                type: "GET",
                url: url
            }).done(function (result) {
                var resultHtml;
                if (!settings.createMethodTarget) {
                	resultHtml = $(result).contents(document).parent();
                } else {
                	resultHtml = $(result).find(settings.createMethodTarget);
                }
                deferred.resolve(resultHtml);
            }).fail(function () {
                deferred.resolve('<div class="error">Sorry, there was an error getting ' + url + '</div>');
            });
            return deferred.promise();
        };
        var defaultTpl = function (id, url) {
            var deferred = $.Deferred(); // create a promise that returns data only after completion
            // your code goes here
            $(id + " h2").load(url + " h2", function () {
                $(this).html("Write a function to populate via cxlTpl option");
                deferred.resolve();
            });
            return deferred.promise();
        };
        // default settings
        var defaults = $.extend({
            className: "",
            tabFocus: ".cxlContent",
            type: "",
            title: false,
            footer: false,
            noHashChange: false,
            createType: false,
            createMethod: defaultGet,
            createMethodTarget: false,
            tplId: "",
            callback: false,
            loadingMessage: 'Loading, Please Wait <a href="javascript:void(0)" class="cxlCancel">Cancel</a>'
        }, $.fn.cxLitbox.defaults);
        // global settings that can be changed for all elements
        $.fn.cxLitbox.ariaHiddenElements = ".mainContent, .header, .pageTitleHeaderText, .submenu";
	    $.fn.cxLitbox.noHashSearch = true;
        // create array of options to maintain for hash storage
        var arrayEntry = {
            cxlHashArray: new Array(),
            settings: options
        };
        if (typeof $.fn.cxLitbox.cxlArray !== "undefined") {
            $.fn.cxLitbox.cxlArray.push(arrayEntry);
        } else if (typeof $.fn.cxLitbox.cxlArray === "undefined") {
            $.fn.cxLitbox.cxlArray = [arrayEntry];
        }
        // set the array index
        var arrayIndex = $.fn.cxLitbox.cxlArray.length - 1;
        // temporary settings
        var settings = defaults;
        // binds click event to passed class
        $.fn.cxLitbox.bindClick = function (target, setOptions) {
            $(target).click(function (event) {
                var hash;
                var href = $(this).attr("href");
                var cxlHref = $(this).attr("data-cxlHref");
                if (typeof href != "undefined") {
                    hash = href;
                }
                if (typeof cxlHref != "undefined") {
                    hash = cxlHref;
                }
                //if href is new, add it to the settings array						
                if ($.inArray(hash, $.fn.cxLitbox.cxlArray[arrayIndex].cxlHashArray) == -1 && $.fn.cxLitbox.noHashSearch !== false) {
                    $.fn.cxLitbox.cxlArray[arrayIndex].cxlHashArray.push(hash);
                }
                var passedSettings = $.extend(defaults, setOptions);
                $.fn.cxLitbox.cxlGetType(hash, passedSettings);
                event.preventDefault();
            });
        };
        // determines what to do based on the hash
        $.fn.cxLitbox.cxlGetType = function (hash, passedSettings) {
            if (typeof hash == "undefined") {
                hash = "";
            }
            cxlHash = "#" + hash.replace("#", ""); //will work if hash is there or not
            var hashSplit = cxlHash.split("/");
            var url = cxlHash.replace("#", "");
            var hashContainsSpecial = cxlHash.indexOf("/");
            // clear settings to defualts
            settings = defaults;
            // if the setting are passed, set them
            if (typeof passedSettings !== "undefined") {
                settings = passedSettings;
            }
            // if they are not, look them up in the array
            if (typeof passedSettings === "undefined") {
                for (var i = 0; i < $.fn.cxLitbox.cxlArray.length; i++) {
                    if ($.inArray(cxlHash, $.fn.cxLitbox.cxlArray[i].cxlHashArray) >= 0) {
                        settings = $.extend({}, defaults, $.fn.cxLitbox.cxlArray[i].settings);
                    }
                }
            }
            // make sure a url is present 
            if (url.length > 0 || settings.noHashChange) {
                if (settings.createType == "get") {
                    cxlCreate(url);
                }
                if (settings.createType == "template") {
                    cxlPopulateTemplate(settings.tplId, url);
                }
            }
            if (settings.createType === false && hashContainsSpecial < 0) {
                cxlId = cxlHash;
                cxlSetPosition();
            }
        };

        function ariaHidden(isHidden) {
	        if (isHidden === true) {
		        $($.fn.cxLitbox.ariaHiddenElements).attr("aria-hidden", isHidden); //other divs TBD	
	        } else {
		        $($.fn.cxLitbox.ariaHiddenElements).removeAttr("aria-hidden");
	        }
        }

		var cxlLoading = function () {
            var loadingTimeout;

            function hideLoading() {
                window.clearTimeout(loadingTimeout);
                $(cxlId + " .cxLoadingMessage").hide().remove();
                $(cxlId).removeClass("loadingContent");
                $(cxlId + " .cxlContent").fadeIn(200);
            }

            function showLoading() {
                $(cxlId + " .cxlContent").hide();
                $(cxlId).addClass("loadingContent");
                loadingTimeout = window.setTimeout(delayedLoading, 250);
            }

            function delayedLoading() {
                var loadingTemplate = '<div class="cxLoadingMessage" style="display: none;"><span class="cxIcon cxLoadingIconSmall" role="presentation"></span><span>' + settings.loadingMessage + '</span></div>';
                $(cxlId).prepend(loadingTemplate);
                $(cxlId + " .cxLoadingMessage").fadeIn(250);
                window.clearTimeout(loadingTimeout);
            }
            return {
                showLoading: showLoading,
                hideLoading: hideLoading
            };
        }();

        function cxlCreate(url) {
            // Markup Templates Templates			
            cxlId = "#cxlAjax";
            var cxlAjaxId = "cxlAjax";
            var cxlTemplate = '<div class="cxlWrapper isAjax" id="' + cxlAjaxId + '"style="display: none;"><div role="dialog" class="cxlContent" tabindex="-1"><a href="javascript:void(0)" class="cxIcon closeIcon cxlClose" title="Close Window">Close Window</a><div class="cxlBody"></div></div><div class="cxlBg" tabindex="0"></div></div>';
            // create loading
            $("body").prepend(cxlTemplate);
            cxlLoading.showLoading();
            cxlSetLoading();
            //create a new loading function
            //return;
            settings.createMethod(url).done(function (result) {
                cxlLoading.hideLoading();
                $("#cxlAjax .cxlBody").append(result);
                if (settings.title !== false) {
                    $(cxlId + " .cxlContent").prepend('<h2 id="cxlHeader" class="cxlHeader">' + settings.title + '</h2>').attr("aria-labelledby", "cxlHeader");
                }
                if (settings.footer !== false) {
                    $(cxlId + " .cxlContent").append('<div class="cxlFooter">' + settings.footer + '</div>');
                }
                cxlSetPosition();
            });
        }

        function cxlPopulateTemplate(id, url) {
            cxlId = id;
            cxlLoading.showLoading();
            cxlSetLoading();
            settings.createMethod(settings.tplId, url).done(function () {
                cxlLoading.hideLoading();
                cxlSetPosition();
            });
        }


        function noJump(fromHash) {
            $.fn.cxLitbox.cxlVisible = cxlHash;
            var goto = $(window).scrollTop(); // prevent scroll change
            if (fromHash !== true && settings.noHashChange !== true) {
                if (cxlHash === "") {
                    window.location.hash = "/";
                } else if (cxlHash !== "") {
                    window.location.hash = cxlHash;
                }
                //$(window).scrollTop();
            }
        }
        // Close Action

        function cxlClose(fromHash) {
            if (fromHash === true) {
                cxlId = ".cxlWrapper";
            }
            $(cxlId + ", #cxlAjax").fadeOut(200, function () {
                $(this).removeClass("completeForm");
                if ($(this).hasClass("isAjax")) {
                    $(this).remove();
                }
            });
            $(cxlId + " .cxlBody").css("max-height", "").removeClass("scrolling"); //remove inner maxHeight
            $('html').removeClass("cxlOn");
            ariaHidden("false");
            cxlHash = "";
            noJump(fromHash);
            settings = defaults;
        }
        // binds close actions based on type selected

        function cxlCloseBtn() {
            $(cxlId).off("click", ".cxlClose");
            $(cxlId).on("click", ".cxlClose", function () {
                cxlClose();
            });
            if (settings.type == "info") {
                $(cxlId + " .cxlBg").click(function bgClick() {
                    cxlClose();
                });
            } else if (settings.type == "dialog") {
                $(cxlId + " .cxlBg").click(function bgClick() {
                    $(cxlId).addClass("completeForm");
                    $.fn.cxAlert("Please save or cancel.", "general", 1500);
                });
            }
        }
        // Set the position of the litbox and fades it in

        function cxlSetLoading() {
            if ($(cxlId).hasClass("cxlWrapper")) {
                ariaHidden(true);
                $(cxlId).prependTo("body");
                $(cxlId + " .cxlContent").removeClass("cxlVisible");
                $(cxlId).fadeIn(300);
                $("html").addClass("cxlOn");
                $(cxlId).on("click", ".cxlCancel", function () {
                    cxlClose();
                });
            }
        }

        function cxlSetPosition() {
            //make sure this is a litbox and run some code
            if ($(cxlId).hasClass("cxlWrapper")) {
                ariaHidden(true);
                $(cxlId).prependTo("body");
                $(cxlId + " .cxlContent").removeClass("cxlVisible");
                $(cxlId).fadeIn(300);
                $("html").addClass("cxlOn");
                $(cxlId + " .cxlBody").css("max-height", "").removeClass("scrolling"); // removes previous max-height
                var pageHeight = $(window).height();
                var pageWidth = $(window).width();
                var contentOuterHeight = $(cxlId + " .cxlContent").outerHeight();
                var contentPosition = Math.round((pageHeight - contentOuterHeight) / 2.20);
                $(cxlId + " .cxlContent").addClass("cxlVisible").css('top', contentPosition);
                //remove top attribute when using a mobile display
                if (pageWidth <= 520) {
                    $(cxlId + " .cxlContent").css("top", "");
                }
                //bind focus on the bg so background elements can  not be focused
                $(cxlId + " .cxlBg").focus(function () {
                    $(cxlId + " .cxlContent").focus();    
                });
                noJump(); // change hash	
                cxlCloseBtn(); // create close buttons
                cxlSetOptions(); // set any options
                var contentHeight = $(cxlId + " .cxlContent").height();
                var headerHeight = $(cxlId + " .cxlContent .cxlHeader").outerHeight(true);
                var footerHeight = $(cxlId + " .cxlContent .cxlFooter").outerHeight(true);
                var maxHeight = (contentHeight - headerHeight - footerHeight);
                //sets the max height of the body
                if ($(cxlId + " .cxlBody").innerHeight() > maxHeight) {
                    $(cxlId + " .cxlBody").addClass("scrolling");
                } else {
                    $(cxlId + " .cxlBody").removeClass("scrolling");
                }
                $(cxlId + " .cxlBody").css("maxHeight", maxHeight);

            	//callback
                if (typeof settings !== 'undefined' && typeof settings.callback !== 'undefined' && settings.callback !== false) {
					settings.callback();
                }
            }
        }
        // Sets options if passed

        function cxlSetOptions() {
            $(cxlId).addClass(settings.className);
            $(cxlId + " " + settings.tabFocus).focus();
        }
        // open on load
        $.fn.cxLitbox.createOnLoad = function () {
            if (window.location.hash.length > 2) {
                $.fn.cxLitbox.cxlGetType(window.location.hash);
            }
        };
        // push to hash array

        function addToHash() {
            $(target).each(function () {
                var cxlHref = $(this).attr("data-cxlHref");
                var href = $(this).attr("href");
                if (typeof href !== "undefined") {
                    if ($.inArray(href, $.fn.cxLitbox.cxlArray[arrayIndex].cxlHashArray) === -1) {
                        $.fn.cxLitbox.cxlArray[arrayIndex].cxlHashArray.push(href);
                    }
                }
                if (typeof cxlHref !== "undefined") {
                    if ($.inArray(cxlHref, $.fn.cxLitbox.cxlArray[arrayIndex].cxlHashArray) === -1) {
                        $.fn.cxLitbox.cxlArray[arrayIndex].cxlHashArray.push(cxlHref);
                    }
                }
            });
        }
        // on page load
        if (typeof $.fn.cxLitbox.cxlArray !== "undefinded") {
            // bind click
            $.fn.cxLitbox.bindClick(target, options);
            if (window.location.hash.length > 2 && $.fn.cxLitbox.noHashSearch !== "true") {
                addToHash();
            }
        }
        // initialize hashChange Listener, but only once
        if ($.fn.cxLitbox.HashChangeListener !== true) {
            $(window).on("hashchange", function () {
                if (typeof $.fn.cxLitbox.cxlArray !== "undefinded") {
                    var newHash = window.location.hash;
                    if (newHash != $.fn.cxLitbox.cxlVisible) {
                        cxlClose(true);
                        if (newHash.length > 2) {
                            $.fn.cxLitbox.cxlGetType(newHash);
                        }
                    }
                }
            });
            $.fn.cxLitbox.HashChangeListener = true;
        }
    };
	// help panel
    $.fn.cxHelpPanel = function (options) {
        $.fn.cxHelpPanel.helpVisible;
        var $target = $(this);
    	var testContent = $("#dummyHelpContent");
    	var helpPanelTpl = '<div class="helpPanel" id="helpPanel" tabindex="-1" aria-labelledby="helpTitle" role="complementary"><div class="helpHeader"><h2 id="helpTitle"></h2><ul class="helpActions"><li><a href="javascript:void(0);" id="expandHelp" class="cxIcon expandIconWhite" title="Expand Help" target="_blank">Expand</a></li><li><a href="javascript:void(0)" class="cxIcon collapseIconWhite helpClose" title="Close Help" id="closeHelpPanel">Collapse</a></li></ul></div><div class="helpContent"><div class="helpSection expandedSection"></div></div></div>';
    	var relatedHelpTpl = '<div class="helpSection"><a href="#" class="relatedHelp" target="_blank"><span role="presentation" class="cxIcon relatedHelpIcon"></span>Related Help Topics</a></div>';
    	var defaultGet = function (url) {
    		var deferred = $.Deferred();
    		$.ajax({
    			type: "GET",
    			url: url
    		}).done(function (result) {
    			var resultHtml;
    			if (!settings.getMethodTarget) {
    				resultHtml = $(result);
    				resultHtml = $('<div class="loadedHelpContent">').html(result);
    			} else {
    			    resultHtml = $(result);
    				resultHtml = $("<div>").html(result).find(settings.getMethodTarget);
    			}
    			deferred.resolve(resultHtml);
    		}).fail(function () {
    			var failMessage = "Sorry, there was an error getting " + url;
    			deferred.resolve(failMessage);
    		});
    		return deferred.promise();
    	};
        var defaults = {
            title: "Page Help",
            position: ".content",
            relatedHelp: false,
            className: false,
            noHashChange: false,
            overlay: false,
            getMethod: defaultGet,
            expandableRegions: false,
            getMethodTarget: false,
            appendHtml: true,
            helpCloseMethod: null,
            showExpandButton: true,
            dynamicallyAddPanelWrapper: true,
            isRefresh: false,
            reFocusClickElement: true
    };
    	var settings = defaults;
    	// run bindClick                         
    	var bindClick = (function () {
    		var passedSettings = $.extend(defaults, options);
    		$target.click(function (event) {
    			var href = $(this).attr("href");
    			if ($.fn.cxHelpPanel.helpVisible == href) {
    				helpClose();
    			} else {
    			    $.fn.cxHelpPanel.getHelpContent(href, passedSettings);
    			}
    			event.preventDefault();
    		});
    	}());

    	$.fn.cxHelpPanel.getHelpContent = function(href, passedSettings) {
    	    settings = $.extend(defaults, passedSettings);

    		$.fn.cxHelpPanel.helpVisible = href;
    		var url = href.replace("#", "");
    		//figure out url
    		// Markup Templates Templates                                  
    		if ($(".helpPanelWrapper").length <= 0) {
    			$(settings.position).wrap('<div class="helpPanelWrapper"></div>');
    			$(".helpPanelWrapper").prepend(helpPanelTpl);
    		} else if (!settings.dynamicallyAddPanelWrapper) {
    			$(".helpPanelWrapper").prepend(helpPanelTpl);
    		}
    		$("#helpTitle").html(settings.title);

    		$("#expandHelp").attr("href", url);
    	    if (!settings.showExpandButton) $("#expandHelp").css("display", "none");
    	    
    		if (settings.className !== false) {
    			$("#helpPanel").addClass(settings.className);
    		}
    		// create loading
    		$(settings.position).addClass("contentPanel");
    		$("#helpPanel").show(function () {
    			$(".helpPanelWrapper").addClass("expanded");
    			if (settings.overlay) {
    				$(".helpPanelWrapper").addClass("overlay");
    			}
    		});
    		$("#helpPanel .helpContent").cxLoadingCreate({
    			blockUI: true
    		});
            // if not a refresh
    		if (!settings.isRefresh) {
		        helpCloseBtn();
		        helpPanelPosition.setPanelPosition("#helpPanel");
		        $(window).on("resize", helpPanelPosition.setPanelPosition);
		        $(window).on("scroll", helpPanelPosition.setPosition);
		        $("#helpPanel").removeAttr("aria-live");
		    } else {
    		    $("#helpPanel").attr("aria-live", "polite");
    		}

	        // add url back                       
    		settings.getMethod(url).done(function (result) {
    			$("#helpPanel .helpContent").cxLoadingRemove();

    		    if (settings.appendHtml) {
    		        // if there is exisiting sections remove the expanded section
    		        if ($(result).find(".helpSection").length >= 1) {
    		            $("#helpPanel .helpContent .helpSection").remove();
    		            $("#helpPanel .helpContent").append(result);
    		        } else {
    		            $("#helpPanel .helpContent .helpSection").append(result);
    		        }
    		        if (settings.relatedHelp !== false) {
    		            $("#helpPanel .helpContent").append(relatedHelpTpl);
    		            $("#helpPanel a.relatedHelp").attr("href", settings.relatedHelp);
    		        }
    		    } else {
    		        $("#helpPanel .helpContent .helpSection").html(result);
    		        if (settings.relatedHelp !== false) {
    		            $("#helpPanel .helpContent").html(relatedHelpTpl);
    		            $("#helpPanel a.relatedHelp").attr("href", settings.relatedHelp);
    		        }
    		    }

    		    //bind the clicks
    		    if (settings.expandableRegions && !settings.isRefresh) {
    				var $toggleHeader = $("#helpPanel").find(".toggleHeader");

    				$toggleHeader.off("click");
    				$toggleHeader.on("click", function () {
    					var $toggleIcon = $(this).children(".cxIcon");
    					var $parent = $(this).parents(".helpItemContent");
    					// toggle display and change class
    					$parent.toggleClass("expanded").children(".helpToggleContent").slideToggle(200);

    					// swap icon
    					if ($parent.hasClass("expanded")) {
    						$toggleIcon.removeClass().addClass("cxIcon expandedIcon");
    					} else {
    						$toggleIcon.removeClass().addClass("cxIcon collapsedIcon");
    					}
    				});
    			}

    			helpPanelPosition.setPanelPosition("#helpPanel");
    		    // focus help panel after content loads
    			if (!settings.isRefresh) {
    			    // small timeout on focus to prevent the browser from jumping around
			        var focusDelay =
			            setTimeout(function() {
			                $("#helpPanel").focus();
			            }, 251);

			    }
    		});

    	}
        // binds close actions based on type selected

    	function helpCloseBtn() {
    		$("#helpPanel .helpClose").click(function () {
    			helpClose();
    		});
    	}

    	function helpClose() {
    	    $(".helpPanelWrapper").removeClass("expanded");
    	    $("#helpPanel").fadeOut(250, function () {
    	    
    			if (settings.dynamicallyAddPanelWrapper) {
    				$(this).unwrap().remove();
    			} else {
    				$(".helpPanel").remove();
    			}

                // if refocus is set, focus element that initiated panel
    			if (settings.reFocusClickElement && typeof $target !== "undefined") {
    			    $target.focus();
    			}
    		});
    		$.fn.cxHelpPanel.helpVisible = "";
    		$(window).off("scroll", helpPanelPosition.setPosition);
    		$(window).off("resize", helpPanelPosition.setPanelPosition);
	        if (settings.helpCloseMethod != null) {
	            settings.helpCloseMethod();
	        }
	    }
    	var helpPanelPosition = (function () {
    		var parentOffset;
    		var panelOffset;
    		var contentOffset;
    		var contentPosition;
    		var pageHeight;
    		var scrollPosition;
    		var belowScroll;
    		var id = "#helpPanel";
    		var detectScroll = function () {
    			scrollPosition = $(window).scrollTop();
    			if (scrollPosition >= parentOffset.top) {
    				return false;
    			}
    			if (scrollPosition < parentOffset.top) {
    				return true;
    			}
    		};

            function updatePositions() {
                parentOffset = $(".helpPanelWrapper").offset();
                panelOffset = $(id).offset();
                contentOffset = $(id + " .helpContent").offset();
                contentPosition = $(id + " .helpContent").position();
                pageHeight = $(window).height();
                scrollPosition = $(window).scrollTop();
                belowScroll = null;
            }

    		function setPanelPosition() {
		        updatePositions();
    			helpPanelPosition.setPosition();
    		}

    		function setPosition() {
    			if (detectScroll() === true && belowScroll !== true) {
    			    $(id).removeClass("helpPanelFixed");
    			    updatePositions();
    				var heightStatic = pageHeight - panelOffset.top - contentPosition.top - 10;
    				if (heightStatic <= $(".helpPanelWrapper").height()) {
    					$(id + " .helpContent").height(heightStatic);
    				} else { $(id + " .helpContent").height($(".helpPanelWrapper").height() - contentPosition.top - 10); }
    				belowScroll = true;
    			} else if (detectScroll() === false && belowScroll !== false) {
    				$(id).addClass("helpPanelFixed");
    				var heightFixed = pageHeight - contentPosition.top - 20;
    				if (heightFixed <= $(".helpPanelWrapper").height()) {
    					$(id + " .helpContent").height(heightFixed);
    				} else { $(id + " .helpContent").height($(".helpPanelWrapper").height() - contentPosition.top - 10); }
    				belowScroll = false;
    			}
    		}
    		return {
    			setPanelPosition: setPanelPosition,
    			setPosition: setPosition
    		};
    	}());
    };
	// end help Panel
    $.fn.cxLoadingCreate = function (options) {
        var parent = $(this);
        cxLoading.createLoading(parent, options);
    };
    $.fn.cxLoadingRemove = function () {
        var parent = $(this);
        cxLoading.removeLoading(parent);
    };

    $.fn.cxTooltip = function (options) {
    	var defaults = {
    		showEvents: "mouseenter focus",
    		hideEvents: "mouseleave blur",
    		forceDirection: '',
            className:""
    	}

        var settings = $.extend(defaults, options);
    	var $this = $(this);
    	var title = $(this).attr("title");
    	var isFocused = false;

        // This is to make sure removeTooltip is not called when no tooltip is displayed
        // This was a problem if the page loads and the mose has already entered the 
        var tooltipDisplayed = false;

    	$this.on(settings.showEvents, initTooltip);
    	$this.on(settings.hideEvents, removeTooltip);

    	function initTooltip(e, rolloverElement) {
	        if (!tooltipDisplayed) {
	            var obj = $(this) || $(rolloverElement); // jquery object passed from 
	            var objOffset = $(obj).offset();
	            title = $(obj).attr("title") || ""; //get title in case it changed

	            if (typeof title !== "undefined") {
	                var rolloverPosition = {
	                    top: objOffset.top,
	                    center: objOffset.left + ($(obj).outerWidth() / 2),
	                    width: $(obj).outerWidth(),
	                    height: $(obj).height()
	                };
	                if (title.length > 0) {
	                    tooltipDisplayed = true;
	                    buildTooltip(title, rolloverPosition, obj);
	                    if (e.type == "mouseenter") {
	                        $(obj).removeAttr("title");
	                    }
	                    if (e.type == "focus") {
	                        isFocused = true;
	                    }
	                }
	            }
	        }
	    }

    	function removeTooltip(e) {
	        if (tooltipDisplayed) {
	            e = e || {};
	            $(".cxTooltip").addClass("cxtRemove").fadeOut(250, function() {
	                $(this).remove();
	            });
	            if (e.type == "mouseleave") {
	                $(this).attr("title", title);
	            }
	            tooltipDisplayed = false;
	        }
	    }

    	function buildTooltip(title, rolloverPosition, obj) {
    		var template = '<div class="cxTooltip"><span class="cxtText">' + title + '</span></div>';
    		var arrowTemplate = '<span class="cxIcon" role="presentation"></span>'; //cxtDownArrowIcon or cxtUpArrowIcon
    		var $tooltip = $(template).addClass(settings.className).hide();
    		var showDelay;
    		obj.append($tooltip);
    		var toolTipPosition = getTooltipPosition($tooltip, rolloverPosition);
    		createArrow(toolTipPosition.isBottom);

    		showDelay = window.setTimeout(showTooltip, 250);

    		function showTooltip() {
    		    window.clearTimeout(showDelay);
    			$tooltip.css({
    			    "top": toolTipPosition.top,
    			    "left": toolTipPosition.left,
                    "display": "block"
    			}).show();

		        
		    }
    		function createArrow(isBottom) {
    			var arrow;
    			if (isBottom) {
    				arrow = $(arrowTemplate).addClass("cxtUpArrowIcon");
    				$($tooltip).prepend(arrow);
    			} else {
    				arrow = $(arrowTemplate).addClass("cxtDownArrowIcon");
    				$($tooltip).append(arrow);
    			}
    		}
    	}

    	function getTooltipPosition(obj, rolloverElement) {
    		var isBottom = false;
    		var top = - (obj.outerHeight() + 10);
    		if (settings.forceDirection !== 'top' && (settings.forceDirection === 'bottom' || top <= 5 || (rolloverElement.top - obj.outerHeight()) <= $(window).scrollTop() + 5)) {
    			top = rolloverElement.height;
    			isBottom = true;
    		}

    		return {
    			top: top,
    			left: (rolloverElement.width - obj.outerWidth()) / 2,
    			isBottom: isBottom
    		};
    	}
    	$.fn.cxTooltip.tooltipOff = function (selector) {
    		$(selector).off("mouseenter focus", initTooltip);
    		$(selector).off("mouseout blur", removeTooltip);
    	};
    };

    // function definition
    var cxLoading = (function () {
        var loadingTimeout;

        function createLoading(parent, options) {
            var settings = $.extend({
                    className: "cxLoadingOverlay",
                    blockUI: false,
                    message: "Loading, please wait",
                    timeDelay: 250,
                    appendTpl: false,
                    icon: '<span class="cxIcon cxLoadingIconSmall" role="presentation"></span>',
                    progess: false,
                    progressUrl: "",
                    progressFormId: "",
                    progressPolling: 0,
                    progressStatus: ""
                }, options);

            var tpl = '<div class="cxLoading ' + settings.className + '" style="display: none;"><div class="cxLoadingMessage">' + settings.icon + '<span class="loadingText">' + settings.message + '</span></div></div>';
            loadingTimeout = window.setTimeout(delayedTimer, settings.timeDelay);

            function delayedTimer() {
                var parentHeight = parent.outerHeight();
                var pageHeight = $(window).height();
                var parentCSSPosition = parent.css("position");
                if (parentCSSPosition != "absolute" && parentCSSPosition != "fixed") {
                    parent.css("position", "relative");
                }
                if (parent.children(".cxLoading").length <= 0) {
	                if (settings.appendTpl) {
		                parent.append(tpl);
	                } else {
		                parent.prepend(tpl);
	                }
                }
                if (settings.blockUI) {
                    parent.children(".cxLoading").addClass("blockUI");
                }
                parent.children(".cxLoading").fadeIn(250).addClass("cxLoadingVisible");
                var elementHeight = parent.find(".cxLoadingMessage").outerHeight();
                var elementPosition = ((parentHeight - elementHeight) / 2.2);
                // if it overlays the entire body
                if ($("body").children(".cxLoading").length >= 1) {
                    parent.find(".cxLoadingMessage").attr("role", "alert").css("margin-top", ($(window).height() / 2.5));
                }
                if (elementPosition <= (pageHeight / 2) && settings.blockUI) {
                    parent.find(".cxLoadingMessage").css("margin-top", (elementPosition) + "px");
                }
                if (settings.progess) {
                    var refreshId = setInterval(function() {
                            setProgressPercentage(refreshId
                            );
                        },
                        settings.progressPolling);
                }
                window.clearTimeout(loadingTimeout);
            }

            // This method to show the progress percentage of fileUpload in checkmywork
            function setProgressPercentage(progressIntervalId) {
                var obj = {};
                obj.sessionKey = settings.progressFormId;
                obj.progressStatus = settings.progressStatus;
                $.ajax({
                    url: settings.progressUrl,
                    data: JSON.stringify(obj),
                    type: "POST",
                    async: false,
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    success: function(response) {
                        var data = $.parseJSON(response.d);
                        $(".loadingText").text(data.ProgressValue);
                        settings.progressStatus = "InProgress";
                        if (data.Status === "Completed") {
                            clearInterval(progressIntervalId);
                        }
                    },
                    error: function(response) {
                        console.log(response);
                    }
                });
            }
        }

        function removeLoading(parent) {
            window.clearTimeout(loadingTimeout);
            parent.children(".cxLoading").fadeOut(250, function () {
                parent.css("position", "");
                $(this).remove();
            });
        }
        return {
            createLoading: createLoading,
            removeLoading: removeLoading
        };
    }());
}(jQuery));