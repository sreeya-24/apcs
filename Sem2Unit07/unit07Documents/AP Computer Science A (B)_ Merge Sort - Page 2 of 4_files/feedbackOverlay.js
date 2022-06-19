//#region cx (Connexus)
var cx;
(function (cx) {
    'use strict';

    //#region cx.feedback
	(function (feedback) {
        function docReady() {
            $('.cxlLarge').cxLitbox({ className: 'cxlLarge', type: 'info' });

            var $feedbackLink = $('a.feedback');

            $feedbackLink.on('click', function (e) {
                e.preventDefault();
                displayFeedbackOverlay($(this).attr("href"));
            });

            // Some browsers (iOS Safari right now) still open feedback in a new window
            // We want to make sure they don't do that, but we're leaving the target in the
            // markup in case there's been a script error or js is disabled
            $feedbackLink.removeAttr('target');
        };

        function displayFeedbackOverlay(navigateUrl) {
            $.fn.cxLitbox.cxlGetType("#cxlAjax", {
                createType: "get",
                className: "feedbackOverlay",
                noHashChange: true,
                tabFocus: ".cxlContent",
                loadingMessage: "Loading...",
                title: "Feedback",
                footer: '<a href="javascript:void(0)" class="cxBtn cxPrimaryBtn" id="sendFeedback"><span class="btnContent">Send Feedback</span></a>',
                createMethod: function (id, url) {
                    var newHtml = '<iframe id="feedbackFrame" src="' + navigateUrl + '"></iframe>';
                    var deferred = $.Deferred();
                    deferred.resolve(newHtml);

                    setTimeout(function () {
                        var $feedbackFrame = $('#feedbackFrame');

                        $feedbackFrame.on('load',function () {
                        	var iFrameWindow = $feedbackFrame[0].contentWindow;

                            if (iFrameWindow.IsPostBack) {
                                $('.feedbackOverlay .cxlClose').click();
                                $.fn.cxAlert("<strong>Sent!</strong> Thanks for your feedback!", "saved", 3000);
                            }

                            $('a#sendFeedback').on('click', function () {
                                $feedbackFrame.contents().find('a.submit')[0].click();
                            });
                        });
                    }, 1);

                    return deferred.promise();
                }
            });
        };

		//Public
        feedback.displayFeedbackOverlay = displayFeedbackOverlay;
        feedback.docReady = docReady;
    })(cx.feedback || (cx.feedback = {}));
})(cx || (cx = {}));
 //#endregion

$(function() { cx.feedback.docReady(); });