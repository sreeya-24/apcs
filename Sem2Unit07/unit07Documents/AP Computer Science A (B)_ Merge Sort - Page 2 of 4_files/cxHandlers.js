/*jslint browser: true, devel: true, plusplus: true, white: true*/
/*global $*/

(function () {
    "use strict";

    var scrollTimeoutExpired = true,
        scrollHandlers = [],
        resizeTimeoutExpired = true,
        resizeHandlers = [];

    $(window)
        .scroll(function (e) {
            if (scrollTimeoutExpired) {
                scrollTimeoutExpired = false;
                setTimeout(function () {
                    var i;
                    for (i = 0; i < scrollHandlers.length; i++) {
                        scrollHandlers[i].call(this, e);
                    }
                    scrollTimeoutExpired = true;
                }.bind(this), 100);
            }
        })
        .resize(function (e) {
            if (resizeTimeoutExpired) {
                resizeTimeoutExpired = false;
                setTimeout(function () {
                    var i;
                    for (i = 0; i < resizeHandlers.length; i++) {
                        resizeHandlers[i].call(this, e);
                    }
                    resizeTimeoutExpired = true;
                }.bind(this), 200);
            }
        });

    $.fn.cxScrollHandler = function (handler) {
        scrollHandlers.push(handler);
    };

    $.fn.cxResizeHandler = function (handler) {
        resizeHandlers.push(handler);
    };
})();