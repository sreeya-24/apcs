﻿$(document).ready(function () {
	$(document).delegate('#validationSummary a[href^="#"]', 'click', function (e) {
		e.preventDefault();
		var target = this.hash;
		var $target = $(target);

		$('html,body').animate({ scrollTop: $target.offset().top - 100 }, 500, function () {
			$target.focus();
		});

		window.location.hash = target;
	});

	var browserVersion = -1;
	var $html = $("html");
    if ($.browser) {  // This Very well may be null in later versions of jquery.
        if ($.browser.msie) {
            $html.addClass("ie");
            browserVersion = $.browser.version;

        }
    }

    if (browserVersion < 8 && browserVersion != -1)
        $html.addClass("ie8").addClass("ie7");
    else if (browserVersion == 8)
        $html.addClass("ie8");
    else if (browserVersion == 9)
        $html.addClass("ie9");
    
    $(".deleteIcon.deleteRow")
		.hover(function () { $(this).closest("tr").addClass("removeOption"); }, function () { $(this).closest("tr").removeClass("removeOption"); })
		.click(function () {
			var icon = $(this);
			$(this).closest("tr").find("input[type=text]").val("").each(function () {
				var $this = $(this);
				setTimeout(function () { $this.change(); }, 0);
			});
			$(this).closest("tr").find("span").filter(function () { return this.id.endsWith("_text"); }).next("input[type=hidden]").andSelf().each(function () {
				$(this).text("").val("");
				icon.hide();
			});
		});

    // Expand and Collapse Fieldset
    $('.toggle').on("click", function (e) {
        $(this).parent().parent().children('.toggleContent').slideToggle(300);
        $(this).toggleClass('toggleOpen');
        e.preventDefault();
    });

});
