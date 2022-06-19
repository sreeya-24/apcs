'use strict';
var lessonInformation;
let courseOutline;
var queryStringHelper = queryStringHelper || {};
var assessmentTypeCssClasses = getAssessmentTypeCssClasses();
const completionStatusData = {
    'pendingComplete': {
        title: 'Lesson is complete pending approval',
        text: 'Pending Complete',
        icon: 'history',
        link: 'Pending Complete'
    },
    'completed': {
        title: 'Lesson is complete',
        text: 'Complete',
        icon: 'check_circle_outline',
        link: 'Lesson complete'
    },
    'skipped': {
        title: 'Skip this lesson',
        text: 'Skip this lesson',
        icon: 'hide_source',
        link: 'Lesson is skipped'
    },
    'incomplete': {
        title: 'Lesson is not complete',
        text: 'Mark as Complete',
        icon: 'check_circle_outline',
        link: 'Mark lesson as complete'
    }
};
const editorConfig = {
    toolbar: {
        items: [
            'heading',
            '|',
            'bold',
            'italic',
            'underline',
            'fontColor',
            '|',
            'bulletedList',
            'numberedList',
            '|',
            'alignment',
            'outdent',
            'indent',
            '|',
            'link',
            'insertTable',
            'mediaEmbed',
            'removeFormat',
            'undo',
            'redo'
        ]
    },
    plugins: ['Alignment',
        'Autoformat',
        'AutoImage',
        'Bold',
        'Essentials',
        'FontColor',
        'Heading',
        'Image',
        'ImageInsert',
        'ImageStyle',
        'ImageToolbar',
        'ImageResize',
        'Indent',
        'Italic',
        'Link',
        'List',
        'MediaEmbed',
        'MediaEmbedToolbar',
        'Paragraph',
        'RemoveFormat',
        'Table',
        'TableToolbar',
        'Underline'],
    language: 'en',
    image: {
        toolbar: [
            'imageTextAlternative',
            'imageStyle:inline',
            'imageStyle:block',
            'imageStyle:side'
        ]
    },
    table: {
        contentToolbar: [
            'tableColumn',
            'tableRow',
            'mergeTableCells'
        ]
    },
    mediaEmbed: {
        previewsInData: true
    },
    link: {
        defaultProtocol: 'https://',
        addTargetToExternalLinks: true
    }
};

function iOS() {
    return [
        'iPad Simulator',
        'iPhone Simulator',
        'iPod Simulator',
        'iPad',
        'iPhone',
        'iPod'
    ].includes(navigator.platform)
        // iPad on iOS 13 detection
        || (navigator.userAgent.includes("Mac") && "ontouchend" in document)
}

(function () {
    $(window).resize(function () {
        setIframeSize();
    });
})();

function setIframeSize() {
    // iOS and webkit browsers (Safari and Chrome on mac) don't support iframes with height: 100%.
    // Of course every other browser on the planet handles it just fine.
    // While setting the iframe height to 100vh might work if the page was structured in a very specific way
    // there are still issues with how the sticky footer interacts with the page and the extra safari elements
    // that take up space on the UI (URL bar and Nav bar on bottom).
    // The only good way to know if there is some Safari junk taking up real estate
    // is the body height will be different than the window.innerHeight.
    // So when we detect this dumb scenario, we need to calculate the height of several elements to make things
    // not overlap or not expand to the correct height.
    var body = $("body");
    if (iOS() && body.height() > window.innerHeight) {
        var footer = $("footer");
        var header = $("header");
        var wrapper = $(".absolute-content-wrapper");
        var contentItemsTop = $('.content-items-top');
        var notifications = document.getElementById('notifications'); // This is intentionally not using jquery. offsetHeight is different than .height().
        var offset = body.height() - window.innerHeight;
        var iframeSize = window.innerHeight - header.height() - footer.height() - notifications.offsetHeight - contentItemsTop.height() - offset - 60;

        $("#lessonContentIFrame").css({ 'height': iframeSize, 'min-height': '-webkit-fill-available' });
        $(".iframe-container").css({ 'height': iframeSize });
        $('.content-items').css({'height': 'calc(100% - ' + (footer.height()) + 'px)'});
        wrapper.css({ 'height': 'calc(100vh - ' + (footer.height() + offset) + 'px)'});
    }

}

(function ($, window, queryStringHelper) {

    var getQueryString = function () {
        var query = window.location.search;

        if (!query) {
            query = window.location.href.split('?')[1];
        }

        return query;
    };

    queryStringHelper.MakeQueryStringCollection = function (qs) {
        var query = qs ? qs : getQueryString();
        var params = query.split('&');

        var searchParams = {};
        for (var i = 0; i < params.length; i++) {
            var arr = params[i].split('=');
            searchParams[arr[0]] = arr[1];
        }

        return searchParams;
    }

    queryStringHelper.Request = {
        QueryString: function (key, query) {
            var searchParams;
            try {
                searchParams = new URLSearchParams(query ? query : getQueryString());
            } catch (err) {
                searchParams = null
            }

            if (searchParams != null) {
                return searchParams.get(key);
            }
            searchParams = queryStringHelper.MakeQueryStringCollection();
            return searchParams[key];
        }
    }
})($, window, queryStringHelper);

let idSlate = "";
let slateType = "";
let hasAssessmentOnly = false;

$(document).ready(function () {
    $('.hidden-on-load').removeClass('hidden-on-load');
    $('.modal').modal();
    var jsonData = $("#ctl00_lessonInformation").val();
    if (jsonData != null && jsonData != "") {
        lessonInformation = JSON.parse(jsonData);
    } else {
        lessonInformation = { idCourse: 0, idUnit: 0, idLesson: 0, idSection: 0, headerText: "", subHeaderText: "", pageCount: 1, browserTitle: "", hasModification: "", canModify: "", lessonCompletionStatus: "", docTypes: [], externalContentUrls: [], lessonRating: 0, isPolarisCourse: false, loggedInWebuser: 0 };
    }
    courseOutline = getCourseOutline();
    lessonInformation.pageNumber = parseInt($("#ctl00_page").val(), 10) || 1;
    lessonInformation.idWebuser = $("#ctl00_idWebuser").val();
    lessonInformation.canModify = $("#ctl00_canModify").val().toLowerCase() == "true";
    lessonInformation.canCreateIntroPage = $("#ctl00_canCreateIntroPage").val().toLowerCase() == "true";
    lessonInformation.hasCustomLessonContent = hasCustomLessonContent();
    lessonInformation.lessonStarted = !lessonInformation.hasCustomLessonContent;
    openLesson(queryString());
    setCompletionIcon(lessonInformation, completionStatusData);
    setCompletionLink(lessonInformation, completionStatusData);
    $('.sidenav').sidenav();
    $('#slideOutMenu button').on('click', () => {
        M.Sidenav.getInstance($('#slideOutMenu')).close();
    });
    setLessonTitle(lessonInformation);
    createBreadcrumbs(lessonInformation, queryString());
    setPolarisOptions(lessonInformation.isPolarisCourse, lessonInformation.pageCount);
    if (courseOutline) {
        getCourseOutlineHtml(courseOutline);
        setNotifications(lessonInformation, courseOutline, queryString());
    }
    setContentHeightForDocumentTypeHeader();
    setLinks(true);
    showHideLessonModifications();
    initializeOutlineModal();
    $(".dropdown-trigger").dropdown({ hover: false, coverTrigger: false });
    ClassicEditor
        .create(document.querySelector('.editor'), editorConfig)
        .then(editor => {
            window.editor = editor;
        })
        .catch(error => {
            console.error('Error occured with ClassicEditor.create()');
            console.error('Please, report the following error on https://github.com/ckeditor/ckeditor5/issues with the build id and the error stack trace:');
            console.warn('Build id: nsn3rwiqyubh-hzop3ajauhi1');
            console.error(error);
        });
    window.addEventListener('message', function (e) {
        idSlate = e.data.id;
        slateType = e.data.type;
        hasAssessmentOnly = (e.data.hasAssessmentOnly != undefined) ? e.data.hasAssessmentOnly : hasAssessmentOnly;
    });
});

document.addEventListener('DOMContentLoaded', () => {
    const modal = document.querySelector('#addPageModal');

    // Make sure the modal does not steal the input focus (e.g. when editing a link).
    // https://github.com/ckeditor/ckeditor5/issues/1147
    M.Modal.init(modal, { dismissible: false });
});

function openModal(trigger, modalId) {
    const modalElement = document.getElementById(modalId);
    const instance = M.Modal.getInstance(modalElement);
    if (modalId === 'addPageModal') {
        if (trigger.id === 'addPageViaHeader') {
            instance.options.onCloseEnd = () => focusElement(document.querySelector('.dropdown-trigger'));
        } else {
            instance.options.onCloseEnd = () => focusElement(document.querySelector('#' + trigger.id));
        }
    } else if (modalId !== 'outlineModal') {
        
        instance.options.onCloseEnd = () => focusElement(trigger);
    }
    if (modalId !== 'outlineModal') {
        instance.options.onOpenEnd = () => focusElement(modalElement.querySelector('.focus-on-open'));
    }
    instance._handleKeydown = modalhandleKeydownPatch;
    instance.open();
}

// This is necessary to allow a modal to be closed by escape while the initial page load is loading the iframe.
// Without prevent default, the iframe will cancel loading.
function modalhandleKeydownPatch(e) {
    // ESC key
    if (e.keyCode === 27 && this.options.dismissible) {
        e.preventDefault();
        this.close();
    }
}

function openFeedbackFromCourseTools(trigger, modalId) {
    // Get instance of coursetools
    const courseToolsInstance = M.Modal.getInstance($('#courseToolsModal'));
    courseToolsInstance.close();
    const modalElement = document.getElementById(modalId);
    const modalFocusElement = modalElement.querySelector('.focus-on-open');
    const instance = M.Modal.getInstance(modalElement);
    instance.options.onOpenEnd = () => focusElement(modalFocusElement);
    instance.options.onCloseEnd = () => closeFeedbackFromCourseTools(trigger);
    instance.open();
}

function closeFeedbackFromCourseTools(trigger) {
    const courseToolsInstance = M.Modal.getInstance($('#courseToolsModal'));
    courseToolsInstance.open();
    focusElement(trigger);
}

function focusElement(elementToFocus) {
    if (elementToFocus != null) {
        elementToFocus.focus();
    }
}

function focusOnModalOpen() {
    const modals = $('.modal');

    modals.each((index, element) => {
        const elementToFocus = $(element).find('.focus-on-open');
        if ($(element).is(':visible') && elementToFocus != null) {
            elementToFocus.focus();
            return false;
        }
    });
}

function countChar(val) {
    if (val.value.length > 2000) {
        val.value = val.value.substring(0, 2000);
    } else {
        $('#feedbackModal .character-count').text(`${val.value.length}/2000`);
    }
}

function setLessonTitle(lessonInformation) {
    $('#headerTitle').html(lessonInformation.displayName);
}

function createBreadcrumbs(lessonInformation, queryString) {
    const baseUrl = 'default.aspx';
    const unitQueryString = queryString.replace(`&idLesson=${lessonInformation.idLesson}`, '');

    const unitUrl = `${baseUrl}${unitQueryString}`;
    const lessonUrl = `${baseUrl}${queryString}`;

    const unitHtml = getBreadcrumb(unitUrl, 'Unit', lessonInformation.unitNumber, lessonInformation.unitName);
    const lessonHtml = getBreadcrumb(lessonUrl, 'Lesson', lessonInformation.lessonNumber, lessonInformation.lessonName);

    $('#breadcrumbs').html(`${unitHtml}${lessonHtml}`);
}

function getBreadcrumb(url, type, number, name) {
    if (number === 0 && isNullOrWhitespace(name)) {
        return '';
    }

    const title = number === 0 ? '' : `<div class="breadcrumb-title">${type} ${number}</div>`;
    const subtitle = isNullOrWhitespace(name) ? '' : `<div class="breadcrumb-subtitle">${name}</div>`;

    return `<a href="${url}" class="breadcrumb">` +
       `    <div class="breadcrumb-text-wrapper">` +
       `        ${title}` +
       `        ${subtitle}` +
       `    </div>` +
       `</a>`;
}

function setPolarisOptions(isPolarisCourse, pageCount) {
    if (isPolarisCourse) {
        $('#pageNumbers').hide();  // Hide the page numbers ex. 1 of 2
        $('.next-btn,.prev-btn').hide(); // Hide the nav buttons at the bottom
        $('.progress').hide(); // Vega viewer has it's own progress bar so don't show this one.
        $('#lessonFooter').hide();
        $('#notifications').addClass('polaris');

        // If there is only one document (page), then we don't display the assessment buttons.
        // It is either just an assessment or the lesson doesn't have an assessment.
        const hasMultipleDocuments = pageCount > 1;

        // Show/hide the CourseTools polaris assessment link (regular assemssment link is always hidden.)
        $('.course-tools-item.polaris-assessment').toggleClass('hidden', !hasMultipleDocuments);
        $('.course-tools-item.assessment').addClass('hidden');

        // Show/hide the assessment menu button
        $('#menuAssessment').toggleClass('hidden', !hasMultipleDocuments);

        // Show/hide the assessment mobile top bar button
        $('#headerAssessment').toggleClass('hidden', !hasMultipleDocuments);

        // Show/hide the slide out menu assessment menu button
        $('#slideOutMenuAssessment').toggleClass('hidden', !hasMultipleDocuments);
    }
}

function isNullOrWhitespace(str) {
    return str === null || str === undefined || str.trim().length === 0;
}

function getCourseOutline() {
    const courseOutlineData = $("#ctl00_courseOutline").val();
    if (isNullOrWhitespace(courseOutlineData)) {
        console.error('Invalid outline data. courseOutline is null or whitespace.');
        return undefined;
    } else {
        return JSON.parse(courseOutlineData);
    }
}

function setNotifications(lessonInformation, courseOutline) {
    if (lessonInformation.canModify || !courseOutline) {
        return;
    }

    const lesson = findCurrentLesson(courseOutline);

    if (!lesson) {
        $('#lessonNoteButton').addClass('hidden'); // Don't Show the lesson note button
        $('#notifications').addClass('hidden'); // Don't Show the skipped note
        return;
    }

    if (lesson.skipped !== '0001-01-01T00:00:00') {

        $('#notifications').removeClass('hidden'); // Show the skipped note
        $('#lessonNoteButton').addClass('hidden'); // Don't show the lesson note button

    } else if (lesson.duration > 1 || lessonInformation.hasModification) {

        if (lessonInformation.hasModification) {
            $('.modification-note').removeClass('hidden');
        } else {
            $('.modification-note').addClass('hidden');
        }

        if (lesson.duration > 1) {
            $('#lesson-duration').html(lesson.duration);
            $('.multiday-note').removeClass('hidden');
        } else {
            $('.multiday-note').addClass('hidden');
        }

        $('#lessonNoteButton').removeClass('hidden'); // Show the lesson note button
        $('#notifications').addClass('hidden'); // Don't Show the skipped note

        openModal(document.getElementById('lessonNoteButton'), 'lessonNoteModal'); // Auto open the note modal

    } else {
        $('#lessonNoteButton').addClass('hidden'); // Don't Show the lesson note button
        $('#notifications').addClass('hidden'); // Don't Show the skipped note
    }
}

function findCurrentLesson(courseOutline) {
    let lessons = [];
    if (courseOutline.lessons && courseOutline.lessons.length > 0) {
        //The course has lessons as direct descendents
        lessons = courseOutline.lessons;
    } else if (courseOutline.units && courseOutline.units.length > 0) {
        //The course has units as direct descendents
        lessons = courseOutline.units.reduce((acc, cur) => {
            return [...acc, ...cur.lessons];
        }, []);
    } else {
        console.warn('Invalid outline data. Neither Units nor Lessons found.');
        return;
    }

    if (courseOutline.datedLessons) {
        lessons = [...lessons, ...courseOutline.datedLessons];
    }

    return lessons.find(lesson =>
        lesson.idUnit == lessonInformation.idUnit && lesson.idLesson == lessonInformation.idLesson
    );
}

function showLessonIntro() {
    M.Modal.getInstance($('#courseToolsModal')).close();
    lessonInformation.lessonStarted = false;
    lessonInformation.pageNumber = 1;
    if (lessonInformation.hasCustomLessonContent && lessonInformation.canCreateIntroPage) {
        $("#modifyCustomLessonContent").show();
    }
    openLesson(queryString());
}

function startLesson() {
    lessonInformation.lessonStarted = true;
    $("#modifyCustomLessonContent").hide();
    openLesson(queryString());
}

function openLesson(queryString) {
    const hasExternalContent = lessonInformation.externalContentUrls.length >= lessonInformation.pageNumber &&
        lessonInformation.externalContentUrls[lessonInformation.pageNumber - 1].externalContentUrl != undefined &&
        lessonInformation.externalContentUrls[lessonInformation.pageNumber - 1].externalContentUrl != null &&
        lessonInformation.externalContentUrls[lessonInformation.pageNumber - 1].externalContentUrl != "";

    const showCustomLessonContent = lessonInformation.pageNumber === 1 && lessonInformation.hasCustomLessonContent && !lessonInformation.lessonStarted;
    const idCustomLessonContentQueryParam = showCustomLessonContent ? `&idCustomLessonContent=${getIdCustomLessonContent()}` : '';

    const newLocation = hasExternalContent && !showCustomLessonContent ?
        lessonInformation.externalContentUrls[lessonInformation.pageNumber - 1].externalContentUrl :
        `/content/render.aspx${queryString}&mobileViewer=true${idCustomLessonContentQueryParam}`;

    const iFrameParent = $("#lessonContentIFrame").parent();
    const iFrame = "<iframe id=\"lessonContentIFrame\"  src=\"" + newLocation + "\" class=\"lessonViewerIFrame lessonContentIframe\" title=\"Lesson Content\" allowfullscreen aria-live=\"polite\">Your browser does not support frames or is not currently configured to view frames.  Please change your browser or enable frame support in order to view lesson content.</iframe>";
    $("#lessonContentIFrame").remove();
    iFrameParent.append(iFrame);

    if (hasExternalContent) {
        const url = "/content/render.aspx";
        $.ajax({
            url: "lessonViewer.aspx/recordPageTrackingForExternalLesson",
            type: "POST",
            data: "{ 'url': '" + url + "', 'queryString': '" + queryString + "' }",
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        });
        $.ajax({
            url: "lessonViewer.aspx/recordLessonActivityForExternalLesson",
            type: "POST",
            data: "{ 'idWebuserFor': '" + lessonInformation.idWebuser + "', 'idCourse': '" + lessonInformation.idCourse + "', 'idSection': '" + lessonInformation.idSection + "', 'idLesson': '" + lessonInformation.idLesson + "'}",
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        });
    }

    $("#lessonContentIFrame").load(function () {
        $("#lmuLoadingImageContainer").removeAttr("aria-live").fadeOut(200);
        $("#lessonContentIFrame").contents().find("#bodyWrapper").css({ "-webkit-overflow-scrolling": "touch;", "-webkit-transform": "translate3d(0, 0, 0)" });
        $("#lessonContent")
            .scrollTop(0)
            .scrollLeft(0);

        verifyWorkPadQuestions();
        setIframeSize();

        // This is some very specific jank to handle closing the add intro page dropdown when a user clicks on the iframe of content instead of the body of the page.
        // We take the normal materialize dropdown handleDocumentClick function and bind it to the click event on the iframe content document.
        const addContentDropdownTrigger = document.querySelector('a.dropdown-trigger').M_Dropdown;
        if (addContentDropdownTrigger != null) {
            $($('#lessonContentIFrame')[0].contentDocument).on('click', addContentDropdownTrigger._handleDocumentClickBound);
        }
    });

    setPageNavigation();
    setCurrentPageDocType();
    setClassicViewerLink();
    blockLesson();
    setSelectedTreeNode();
    setLink("/content/chrome/printed/options.aspx", queryString, "printLink", false);
    setLink("/content/chrome/printed/options.aspx", queryString, "printButton", false);
    feedbackStarSelector.savedRating(lessonInformation.lessonRating);
    setAssessmentLinks();
    toggleElementVisibilityForIntroPage(lessonInformation.lessonStarted);
    idSlate = "";
    return false;
}

function saveLessonCompletionStatus(confirmCompletionWithOutstandingAssessments) {

    // Get the image button
    var idLesson = parseInt(lessonInformation.idLesson, 10) || 0;
    var idSection = parseInt(lessonInformation.idSection, 10) || 0;
    var idUnit = parseInt(lessonInformation.idUnit, 10) || 0;
    var idWebuser = lessonInformation.idWebuser;
    var currentStatus = lessonInformation.lessonCompletionStatus;
    var idCourse = lessonInformation.idCourse;

    $.ajax({
        url: "lessonViewer.aspx/saveCompletionStatus",
        type: "POST",
        data: "{ 'idCourse': '" + idCourse + "', 'idUnit': '" + idUnit + "', 'idLesson' : '" + idLesson + "', 'idSection' : '" + idSection + "', 'idWebuser': '" + idWebuser + "', 'lessonCompletionStatus': '" + currentStatus + "', 'confirmCompletionWithOutstandingAssessments': " + confirmCompletionWithOutstandingAssessments + " }",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data) {
            var newStatus = data.d.newStatus;
            var javascriptAlert = data.d.alertStatement;
            var mustConfirmCompletion = data.d.mustConfirmCompletion;
            var cssClass = data.d.lessonCompletionCssClass;
            var tooltip = data.d.lessonCompletionToolTip;
            lessonInformation.lessonCompletionStatus = newStatus;
            setCompletionIcon(lessonInformation, completionStatusData);
            setCompletionLink(lessonInformation, completionStatusData);
            $("span.completionStatus[data-idlesson=\"" + idLesson + "\"][data-idunit=\"" + idUnit + "\"]")
                .html(tooltip)
                .removeClass()
                .addClass(cssClass)
                .addClass("smallLessonViewerIcon completionStatus");

            if (javascriptAlert.length > 0) {
                if (mustConfirmCompletion) {
                    if (window.confirm(javascriptAlert)) {
                        saveLessonCompletionStatus(true);
                        updateOutlineOnLessonComplete();
                    }
                } else {
                    window.alert(javascriptAlert);
                }
            } else {
                updateOutlineOnLessonComplete();
            }

        },
        error: function () {
            $.fn.cxAlert(`<strong>Error!</strong> There was an error while trying to update the lesson completion status.`, `error`, 3000);
        }
    });
}

function submitFeedback() {
    let newRating = $('.star-rating input:radio[name="rating"]:checked').val();
    if (newRating === undefined) {
        newRating = "0";
    }
    const newComments = $('.feedback-content textarea').val().trim();
    const idLesson = lessonInformation.idLesson;
    const idSection = lessonInformation.idSection;
    const idWebuser = lessonInformation.idWebuser;
    $.ajax({
        url: '/content/chrome/online/webservices/lessonViewerService.aspx/saveLessonFeedback',
        type: 'POST',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        data: JSON.stringify({
            idLesson: idLesson,
            idSection: idSection,
            idWebuser: idWebuser,
            idLoggedInWebuser: '0',
            rating: newRating,
            comments: newComments
        }),
        success: function () {
            lessonInformation.lessonRating = newRating;
            lessonInformation.comments = newComments;
            $.fn.cxAlert(`<strong>Success!</strong> Your feedback has been submitted.`, `saved`, 3000);
        },
        error: function (jqxhr) {
            if (jqxhr.responseText.indexOf('Invalid Lesson Rating.') >= 0) {
                $.fn.cxAlert(`<strong>Error!</strong> The submitted rating is invalid. It must be between 1 and 5 stars.`, `error`, 3000);
            } else if (jqxhr.responseText.indexOf('Invalid Lesson Comments.') >= 0) {
                $.fn.cxAlert(`<strong>Error!</strong> The submitted comment exceeds the maximum character length. It must not exceed 2,000 characters.`, `error`, 3000);
            } else {
                $.fn.cxAlert(`<strong>Error!</strong> Could not save the feedback.`, `error`, 3000);
            }
        }
    });
}

var feedbackStarSelector = (function () {
    var savedRating;

    // function returned to provide access to rating

    function setSavedRating(newRating) {
        savedRating = newRating;

        // show or hide the feedback control
        if (lessonInformation.idLesson > 0 && lessonInformation.idWebuser > 0 && lessonInformation.idSection > 0) {
            $('#menuLessonFeedback').show();
            $('#courseToolsFeedback').show();
            $('#slideOutMenuLessonFeedback').show();
            if (savedRating >= 1 && savedRating <= 5) {
                $(`#${savedRating}-stars`).attr('checked', true);
            } else {
                $('.star-rating input:checked').removeAttr('checked');
            }
            $('.feedback-content textarea').val(lessonInformation.comments);
            if (lessonInformation.comments) {
                $('.feedback-content .character-count').text(`${lessonInformation.comments.length}/2000`);
            } else {
                $('.feedback-content .character-count').text('0/2000');
            }
        } else {
            $('#menuLessonFeedback').hide();
            $('#courseToolsFeedback').hide();
            $('#slideOutMenuLessonFeedback').hide();
        }
    }

    //document ready shorthand, elements need to be in the DOM before handlers are created
    $(function () {
        var optionCount = $('.star-rating input').length;

        $(`.star-rating input[value="${savedRating}"]`).attr('checked', true);

        // Prevent scrolling with the Up/Down/Left/Right keys while focused on the star ratings.
        $('#feedbackModal div.star-rating').on('scroll', (e) => e.preventDefault());

        // New accessibility key functionality
        $('#feedbackModal div.star-rating').on('keydown', (e) => {
            let key = e.which;

            if (key < 37 || key > 40) {
                return;
            }

            if (key === 39 || key === 38) {
                // right or up increases
                e.preventDefault();
                if (savedRating < optionCount) {
                    savedRating = savedRating + 1;
                }
            }
            if (key === 37 || key === 40) {
                // left or down decreases
                e.preventDefault();
                if (savedRating > 1) {
                    savedRating = savedRating - 1;
                } else {
                    // If no stars are selected yet then pressing down should set it to the minimum.
                    savedRating = 1
                }
            }

            if (savedRating > 0) {
                $('.star-rating input:checked').removeAttr('checked');
                $('.star-rating label')[5 - savedRating].click();
                $(`.star-rating input[value="${savedRating}"]`).attr('checked', true);
            }
        });

        document.querySelectorAll('.star-rating > input[type=radio]').forEach((radio) => {
            radio.addEventListener('click', () => {
                const rating = document.querySelector('.star-rating > input[type=radio]:checked').value;
                const suffix = rating === '1' ? 'star' : 'stars';
                document.querySelector('#ratingValue').innerHTML = `${rating} ${suffix}`;
            });
        });
    });

    // return the savedRating function so it can be accessed globally global
    return {
        savedRating: setSavedRating
    };
})();

function blockLesson() {
    const pageDetails = !lessonInformation.lessonStarted ? 'Loading intro page' :
        !lessonInformation.isPolarisCourse && lessonInformation.pageNumber > 0 && lessonInformation.pageCount > 1 ?
        `Loading page ${lessonInformation.pageNumber} of ${lessonInformation.pageCount}` :
        `Loading page`;
    $("#loadImageDetails").html(pageDetails);
    $("#lmuLoadingImageContainer").attr("aria-live", "assertive").fadeIn(300);
}

function isScrolledIntoView(elem) {
    var docViewTop = $(window).scrollTop();
    var docViewBottom = docViewTop + $(window).height();

    var elemTop = $(elem).offset().top;
    var elemBottom = elemTop + $(elem).height();

    return ((elemBottom <= docViewBottom) && (elemTop >= docViewTop));
}

function setPageNavigation() {
    const totalPages = lessonInformation.pageCount;
    const firstPage = lessonInformation.pageNumber === 1;
    const lastPage = lessonInformation.pageNumber === lessonInformation.pageCount;
    const prevPage = $('.prev-btn');
    const nextPage = $('.next-btn');
    const footerPrevPage = $('#btnFooterPrevPage');
    const footerNextPage = $('#btnFooterNextPage');

    document.title = lessonInformation.idLesson === '0' || lessonInformation.isPolarisCourse ?
        lessonInformation.browserTitle :
        `${lessonInformation.browserTitle} - Page ${lessonInformation.pageNumber} of ${totalPages}`;

    prevPage.toggleClass('hidden-from-screen', firstPage).removeProp('tabindex');
    nextPage.toggleClass('hidden-from-screen', lastPage).removeProp('tabindex');

    if (lessonInformation.isPolarisCourse) {
        return;
    }

    footerPrevPage.toggleClass('disabled', firstPage).attr('aria-disabled', firstPage).removeProp('tabindex');
    footerNextPage.toggleClass('disabled', lastPage).attr('aria-disabled', lastPage).removeProp('tabindex');

    if (firstPage) {
        prevPage.prop('tabindex', -1);
        footerPrevPage.prop('tabindex', -1);
        if (isActiveElement(prevPage[0])) {
            nextPage.focus();
        } else if (isActiveElement(footerPrevPage[0])) {
            footerNextPage.focus();
        }
    } else if (lastPage) {
        nextPage.prop('tabindex', -1);
        footerNextPage.prop('tabindex', -1);
        if (isActiveElement(nextPage[0])) {
            prevPage.focus();
        } else if (isActiveElement(footerNextPage[0])) {
            footerPrevPage.focus();
        }
    }

    $('.current-page').text(lessonInformation.pageNumber);
    $('.max-pages').text(lessonInformation.pageCount);
    const completed = (100 / lessonInformation.pageCount) * lessonInformation.pageNumber;
    $('.progress > .determinate').css('width', `${completed}%`);
    $('.bread-crumb').toggleClass('hide-on-med-and-down', lessonInformation.idLesson === '0');
}

function isActiveElement(element) {
    return element === document.activeElement;
}

function setPageInformation() {
    $("#ctl00_name .lmuCourseTitle").html(lessonInformation.headerText);
    if (lessonInformation.subHeaderText != null && lessonInformation.subHeaderText.length > 0) {
        if ($("#ctl00_subname").length) {
            $("#ctl00_subname")
                .html(lessonInformation.subHeaderText)
                .show();
        } else {
            if ($("#ctl00_name").length)
                $("#ctl00_name").after("<h2 id=\"ctl00_subname\" class=\"subheader\">" + lessonInformation.subHeaderText + "</h2>");
        }
    } else {
        $("#ctl00_subname").remove();
    }
    if (lessonInformation.docTypes.length < 1) {
        $("#lessonDocumentType").hide();
        $("#documentTypeBanner").hide();
    } else {
        $("#lessonDocumentType").show();
        $("#documentTypeBanner").show();
    }
    var lessonDocumentTypeContainer = $("#lessonDocumentType");
    lessonDocumentTypeContainer.empty();
    var existingDocTypes = new Array();
    for (var i = 0; i < lessonInformation.docTypes.length; i++) {
        var append;
        var currentDocType = lessonInformation.docTypes[i].docType;

        if (existingDocTypes.indexOf) {
            append = existingDocTypes.indexOf(currentDocType) < 0;
        } else {
            append = $.inArray(currentDocType, existingDocTypes) < 0;
        }
        if (append) {
            existingDocTypes[existingDocTypes.length] = currentDocType;
            lessonDocumentTypeContainer.append("<div id=\"" + currentDocType + "\" class=\"documentTypeIcon docType" + currentDocType + " \">" + documentTypeNameForDisplay(currentDocType) + "</div>");
        }
    }
}

function setCurrentPageDocType() {
    if (lessonInformation.docTypes != undefined) {
        const docTypeHtml =
            `<div class="CLASS_NAME">
                <span>DISPLAY_TEXT</span>
                <div class="arrow-down"></div>
            </div >`;

        let innerHTML = '';
        let uniqueDocTypes = [];

        for (let i = 0; i < lessonInformation.docTypes.length; i++) {
            if (lessonInformation.docTypes[0].docType.includes('IEXCEL') && lessonInformation.docTypes[i].page === lessonInformation.pageNumber) {
                innerHTML = docTypeHtml
                    .replace('CLASS_NAME', lessonInformation.docTypes[i].docType)
                    .replace('DISPLAY_TEXT', getDocTypeDisplayText(lessonInformation.docTypes[i].docType));
                break;
            } else if (!lessonInformation.docTypes[0].docType.includes('IEXCEL') && !uniqueDocTypes.includes(lessonInformation.docTypes[i].docType)) {
                innerHTML += docTypeHtml
                    .replace('CLASS_NAME', lessonInformation.docTypes[i].docType)
                    .replace('DISPLAY_TEXT', getDocTypeDisplayText(lessonInformation.docTypes[i].docType));
                uniqueDocTypes.push(lessonInformation.docTypes[i].docType);
            }
        }

        $('.doc-types').html(innerHTML);

        const docTypeDivs = $('.doc-types').find('div:not(.arrow-down)');

        for (let i = 0; i < docTypeDivs.length; i++) {
            for (let x = 0; x < lessonInformation.docTypes.length; x++) {
                if (docTypeDivs.length > 1 && docTypeDivs[i].className === lessonInformation.docTypes[x].docType && lessonInformation.docTypes[x].page === lessonInformation.pageNumber) {
                    docTypeDivs[i].classList.add('active');
                }
            }
        }
    }
}

function getDocTypeDisplayText(docType) {
    switch (docType) {
        case 'TimetoTalk':
            return 'Time to Talk';
        case 'GettingStarted':
            return 'Getting Started';
        case 'IEXCEL-Inquire':
        case 'IEXCEL-Explore':
        case 'IEXCEL-Communicate_Collaborate_Connect':
        case 'IEXCEL-Evaluate':
        case 'IEXCEL-Link':
            return docType.replace('IEXCEL-', '').replaceAll('_', ', ');
        case 'Instruction':
        case 'Activity':
        case 'Review':
        case 'Assessment':
        default:
            return docType;
    }
}

function getLessonDetails(idCourse, idUnit, idLesson, idSection, idWebuser) {
    $.ajax({
        url: "lessonViewer_responsive.aspx/getLessonDetails",
        async: false,
        type: "GET",
        processData: true,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: { idCourse: idCourse, idUnit: idUnit, idLesson: idLesson, idSection: idSection, idWebuser: idWebuser },
        success: function (innerData) {
            lessonInformation = innerData.d;
            setPageInformation();
        },
        error: function () {
            $.fn.cxAlert(`<strong>Error!</strong> There was a problem getting lesson details.`, `error`, 3000);
        }
    });
}

function queryStringValues(queryStringName) {
    var returnValue = RegExp('[?&]' + queryStringName + '=([^&]*)').exec(window.location.search);
    return returnValue;
}

function setContentHeightForDocumentTypeHeader() {
    var lessonDocumentType = $("#lessonDocumentType");
    var lessonViewer = $("#ctl00_lessonViewer");

    if ($.trim(lessonDocumentType.html()) == "") {
        lessonViewer.addClass("noDocumentType");
        lessonDocumentType.addClass("noDocumentType");
    }
}

function treeSelect(e, selectedNode) {
    var keycode;
    if (e) {
        keycode = (e.which) ? e.which : e.keyCode;
    } else {
        keycode = 13;
    }
    if (keycode == 13) {
        var elem = document.getElementById('outlineModal');
        var instance = M.Modal.getInstance(elem);
        instance.close();
        var idUnit = parseInt($(selectedNode).attr("data-idUnit"), 10) || 0;
        var idLesson = parseInt($(selectedNode).attr("data-idLesson"), 10) || 0;
        lessonInformation.idUnit = idUnit;
        lessonInformation.idLesson = idLesson;
        $("#ctl00_lessonInformation").val(JSON.stringify(lessonInformation));
        getLessonDetails(lessonInformation.idCourse, idUnit, idLesson, lessonInformation.idSection, lessonInformation.idWebuser);
        lessonInformation.pageNumber = 1;
        lessonInformation.idWebuser = $("#ctl00_idWebuser").val();
        lessonInformation.canModify = $("#ctl00_canModify").val().toLowerCase() == "true";
        lessonInformation.canCreateIntroPage = $("#ctl00_canCreateIntroPage").val().toLowerCase() == "true";
        lessonInformation.hasCustomLessonContent = hasCustomLessonContent();
        lessonInformation.lessonStarted = !lessonInformation.hasCustomLessonContent;
        setLinks(false);
        setFeedbackMenuItemVisibility();
        setCompletionIcon(lessonInformation, completionStatusData);
        setCompletionLink(lessonInformation, completionStatusData);
        openLesson(queryString());
        createBreadcrumbs(lessonInformation, queryString());
        setNotifications(lessonInformation, getCourseOutline(), queryString());
        setPolarisOptions(lessonInformation.isPolarisCourse, lessonInformation.pageCount);
    }
    return false;
}

function toggleElementVisibilityForIntroPage(visible) {
    $('.bread-crumb').toggle(visible);
    $('.progress').toggle(visible);
    $('.doc-types-wrapper').toggle(visible);
    $('.iframe-container > .next-btn').toggle(visible);
    $('.back-to-intro').toggle(lessonInformation.hasCustomLessonContent && visible);

    $('.content-items').toggleClass('lesson-footer-visible', visible);
    $('#lessonFooter').toggle(visible && !lessonInformation.isPolarisCourse);
    $('#lessonContentIFrame').toggleClass('showing-intro', !visible)
    $('#introPageFooter').toggle(!visible);
}

function hasCustomLessonContent() {
    return getIdCustomLessonContent() !== 0;
}

function getIdCustomLessonContent() {
    const lesson = findCurrentLesson(courseOutline);
    if (lesson) {
        return lesson.idCustomLessonContent;
    }

    return 0;
}

function newPage(changeValue) {
    lessonInformation.pageNumber += changeValue;

    if ((lessonInformation.pageNumber <= lessonInformation.pageCount && changeValue > 0) || (lessonInformation.pageNumber > 0 && changeValue < 0)) {
        var queryStringValue = queryString();
        if (typeof (isLessonGuideWindowOpen) == "function" && isLessonGuideWindowOpen()) {
            queryStringValue += getLessonGuidePageChangeParameter();
        }
        openLesson(queryStringValue);
    }
}

function checkKeyPress(event) {
    var keycode;
    if (window.event)
        keycode = window.event.keyCode;
    else if (event)
        keycode = (event.which) ? event.which : event.keyCode;

    //When the space bar or Enter key was pressed
    if (keycode == 32 || keycode == 13) {
        event.preventDefault ? event.preventDefault() : event.returnValue = false;
    }
}

function nextPage() {
    if (lessonInformation.pageNumber === lessonInformation.pageCount) {
        return;
    }
    newPage(1);
}

function previousPage() {
    if (lessonInformation.pageNumber === 1) {
        return;
    }
    newPage(-1);
}


function setLinks(includeEvents) {
    var queryStringValue = queryString();

    setLink("/library/default.aspx", null, "libraryLink", includeEvents);
    setLink("resources.aspx", queryStringValue, "resourcesLink", includeEvents);
    setLink("assessment.aspx", queryStringValue, "assessmentLink", includeEvents);
    setLink("modification.aspx", queryStringValue, "modificationHeader", includeEvents);
    setLink("modification.aspx", queryString, "addLessonNotes", includeEvents);
    setLink("modification.aspx", queryStringValue, "modificationCourseTool", includeEvents);
    setLink("objectives.aspx", queryStringValue, "objectivesLink", includeEvents);
    setLink("/communication/discussions/default.aspx", queryStringValue, "discussionsLink", includeEvents);
    setLink("/forum/default.aspx", queryStringValue, "forumLink", includeEvents);
    if (includeEvents) {//This is set on each page page of the lesson since it's the only link that is page number specific.
        setLink("/content/chrome/printed/options.aspx", queryStringValue, "printLink", includeEvents);
        setLink("/content/chrome/printed/options.aspx", queryStringValue, "printButton", includeEvents);
    }
}

function setFeedbackMenuItemVisibility() {
    //Lesson Feedback
    if (lessonInformation.idLesson == 0 || lessonInformation.idSection == 0 || lessonInformation.idWebuser == 0) {
        $("#menuLessonFeedback").hide();
    } else {
        $("#menuLessonFeedback").show();
    }

    //Lesson Modification
    showHideLessonModifications();
}

function showHideLessonModifications() {
    $("#modifyCustomLessonContent").hide();
    if (lessonInformation.canModify && !lessonInformation.canCreateIntroPage &&
        lessonInformation.idSection != 0 && lessonInformation.idLesson != 0) {
        //show status quo add note button in the header and course tools
        $("#ctl00_modificationHeader").parent().show();
        $("#ctl00_modificationCourseTool").parent().show();
        $("#multiModificationSelectionContainer").hide();
        $("#addPageCourseTool").parent().hide();
        $("#modifyCustomLessonContent").hide();
    } else if (lessonInformation.canModify && lessonInformation.canCreateIntroPage &&
        lessonInformation.idSection != 0 && lessonInformation.idLesson != 0) {
        //show add note AND add intro page buttons in the header and course tools
        $("#multiModificationSelectionContainer").show();
        $("#ctl00_modificationCourseTool").parent().show();
        $("#addPageCourseTool").parent().show();
        $("#ctl00_modificationHeader").parent().hide();
        if (lessonInformation.hasCustomLessonContent) {
            $("#modifyCustomLessonContent").show();
        }
    } else {
        $("#ctl00_modificationHeader").parent().hide();
        $("#ctl00_modificationCourseTool").parent().hide();
        $("#multiModificationSelectionContainer").hide();
        $("#addPageCourseTool").parent().hide();
        $("#modifyCustomLessonContent").hide();
    }
}
function getCompletionIconName(status, data) {
    return (data[status] || data['incomplete'])?.icon;
}

function getCompletionIconClass(data) {
    var classes = {
        'completed': 'complete',
        'default': 'default'
    };
    return [
        'material-icons',
        ...(classes[data] ? [classes[data]] : [classes['default']])
    ].join(' ');
}

function completionIcon(status, data) {
    var icon = $('#completionStatusIconIcon');
    var iconName = getCompletionIconName(status, data);
    var iconClass = getCompletionIconClass(status, data);
    icon.removeClass();
    icon.addClass(iconClass);
    icon.html(iconName);
}

function completionText(status, data) {
    var text = $('#completionStatusIconText');
    text.removeClass();
    text.html(getCompletionText(status, data));
}

function getCompletionLinkText(status, data) {
    return (data[status] || data['incomplete'])?.link;
}

function getCompletionText(status, data) {
    return (data[status] || data['incomplete'])?.text;
}

function getCompletionLinkTitle(status, data) {
    return (data[status] || data['incomplete'])?.title;
}

function isLesson() {
    if (lessonInformation.idLesson == 0 || lessonInformation.idSection == 0) {
        return false;
    }

    return true;
}

function setCompletionIcon(info, data) {
    var link = $("#ctl00_completionStatusIcon");

    var title = getCompletionLinkTitle(info.lessonCompletionStatus, data);
    link.prop("title", title);
    link.prop("alt", title);
    completionText(info.lessonCompletionStatus, data);

    link.removeClass();
    link.addClass('lesson-completion');
    completionIcon(info.lessonCompletionStatus, data);
    link.toggle(isLesson());
}

function setCompletionLink(info, data) {
    var link = $("#ctl00_completionLink");
    var text = getCompletionLinkText(info.lessonCompletionStatus, data);
    link.prop("title", text);
    link.prop("alt", text);
    link.html(text);
    link.toggle(isLesson());
}

function setButtonAttributes(linkId, toolTip, cssClass, visible) {
    var link = $("#" + linkId);
    if (visible) {
        link.removeClass();
        link.attr("title", toolTip);
        link.addClass("lvIcon");
        link.addClass(cssClass);
        link.show();
    } else {
        link.hide();
    }
}

function setLink(uri, queryStringValue, linkId, includeEvents) {
    var href = uri + (queryStringValue != null ? queryStringValue : "");
    var link = $("#ctl00_" + linkId);
    if (includeEvents) {//Since these events call functions, they don't need to be reset each time a new lesson is open, only once per page load.
        link
            .click(function () { return openPopupWindowForLessons(uri); });
    }
    link.prop("href", href);
}

function setClassicViewerLink() {
    $("#classicLessonViewer").prop("href", "default.aspx" + queryString() + "&returnToFramedVersion=true");
}

function openPopupWindowForLessons(url) {
    window.open(url + queryString() + "&popup=true", "", "location=no,resizable=yes,scrollbars=yes,toolbar=no,menubar=no,width=570,height=450,top=10,left=10");
    return false;
}

function queryString() {
    var self = $("#ctl00_self").val(),
        idCourseString = lessonInformation.idCourse == 0 ? "" : lessonInformation.idCourse.toString(),
        idUnitString = lessonInformation.idUnit == 0 ? "" : lessonInformation.idUnit.toString(),
        idLessonString = lessonInformation.idLesson == 0 ? "" : lessonInformation.idLesson.toString(),
        idWebuserString = lessonInformation.idWebuser == 0 ? "" : lessonInformation.idWebuser.toString(),
        idSectionString = lessonInformation.idSection == 0 ? "" : lessonInformation.idSection.toString();

    return "?idCourse=" + idCourseString + "&idUnit=" + idUnitString + "&idLesson=" + idLessonString + "&page=" + lessonInformation.pageNumber + "&idWebuser=" + idWebuserString + "&idSection=" + idSectionString + "&self=" + self + "&header=true" + "&idSlate=" + idSlate + "&slateType=" + slateType + "&hasAssessmentOnly=" + hasAssessmentOnly;
}

function documentTypeNameForDisplay(documentType) {
    if (documentType.indexOf("IEXCEL") > -1) {
        var documentTypeTextForDisplay = documentType.replace("IEXCEL-", "");
        while (documentTypeTextForDisplay.indexOf("_") > 0) {
            documentTypeTextForDisplay = documentTypeTextForDisplay.replace("_", ", ");
        }
        return documentTypeTextForDisplay;
    } else if (documentType.indexOf("CEMusic-") > -1)
        return documentType.replace("CEMusic-", "");


    return documentType;
}

// Workpad questions are not getting loaded in latest version of Chrome and Firefox browsers. This is a work around to load the workpad questions.
function verifyWorkPadQuestions() {
    var iFrame = document.getElementById('lessonContentIFrame');
    if (iFrame != null) {
        var embedElements = iFrame.contentWindow.document.getElementsByTagName('embed');
        for (var i=0; i < embedElements.length; i++) {
            embedElements[i].height = embedElements[i].height - 1; //Firefox 59
            var spanName = "span" + embedElements[i].name;
            if(document.getElementById('#' + spanName) == null){
                $("<span id='" + spanName + "' style='visibility:hidden'>~</span>").insertBefore(embedElements[i]); //Chrome 66
            }
        }
    }
}

function buildCourseOutline(outlineData) {
    if (!outlineData || outlineData == undefined) {
        console.error('Invalid buildCourseOutline data.');
        return;
    }
    // This is the container we will add everything to.
    let container = document.getElementById('outlineContainer');

    container.innerHTML = '';

    // Build Course html
    if (outlineData.name != '') {
        let courseElement = document.createElement('div');
        courseElement.innerHTML = buildCourseElement(outlineData.name);
        container.appendChild(courseElement);
    }

    // Build 'indicates lesson notes' element
    let indicatesLessonNotesElement = document.createElement('div');
    indicatesLessonNotesElement.innerHTML = `
        <i class="material-icons tiny indicates-lesson-notes-icon" role="img" aria-label="indicates lesson notes">star</i>
        indicates lesson notes`;
    indicatesLessonNotesElement.className = 'indicates-lesson-notes-container';
    container.appendChild(indicatesLessonNotesElement);

    // Build dated lessons html
    if (outlineData.datedLessons && outlineData.datedLessons.length > 0) {
        let datedLessonWrapperList = buildDatedLessonList(outlineData);
        container.appendChild(datedLessonWrapperList);
    }

    // Build either just lessons or units and lessons
    if (outlineData.units && outlineData.units.length > 0) {
        let unitList = buildUnitList(outlineData);
        container.appendChild(unitList);
    } else if (outlineData.lessons && outlineData.lessons.length > 0) {
        //Only build lessons html as long as not all lessons are dated
        //Some courses only have dated lessons.
        //However outlineData.lessons is still populated in this case.
        //This check prevents dupe dated lesson nodes
        if (!isAllLessonsDated(outlineData.lessons)) {
            let lessonData = outlineData.lessons;
            let wrapperDiv = buildLessonWrapperDiv(lessonData);
            container.appendChild(wrapperDiv);
        }
    }

    setAssessmentLinks();
}

function buildCourseElement(courseName) {
    if (isNullOrWhitespace(courseName)) {
        return '';
    }
    return `<button class="outline-button" onclick="treeSelect(null, this);"
                data-idunit="0" data-idlesson="0">
                <div class="node-content-container">
                    <div class="course-name">
                        ${courseName}
                    </div>
                </div>
            </button>`;
}

function getNodeLinkHtml(jsonData) {
    if (!jsonData || jsonData == undefined) {
        console.warn('Invalid getNodeLinkHtml data.');
        return "";
    }
    if (!jsonData.name || jsonData.name == null) {
        console.warn('jsonData.name invalid.');
        return "";
    }
    return `<button class="outline-button ${getSkippableClassHtml(jsonData)}" onclick="treeSelect(null, this);"
                data-idunit="${jsonData.idUnit}" data-idlesson="${jsonData.idLesson}">
                <div class="node-content-container">
                    <div class="icon-container">
                        ${getNodeIconHtml(jsonData)}
                    </div>
                    <div id="${jsonData.idUnit}_${jsonData.idLesson}_name" class="node-name-container">
                        ${jsonData.name}
                    </div>
                    ${getCustomLessonContentIndicatorHtml(jsonData.idCustomLessonContent)}
                    ${getAssessmentTypesHtml(jsonData.assessmentTypes)}
                    ${getModificationAlertHtml(jsonData)}
                </div>
            </button>`;
}

function buildDatedLessonList(outlineData) {
    if (!outlineData || outlineData == undefined) {
        console.warn('Invalid buildDatedLessonList data.');
        return;
    }
    let datedLessonWrapperList = document.createElement('ol');
    datedLessonWrapperList.classList.add('course-outline-list');
    let datedLessonLi = document.createElement('li');
    let datedLessonText = document.createElement('div');
    datedLessonText.textContent = 'Dated Lessons';
    datedLessonLi.appendChild(datedLessonText);
    let datedLessonList = document.createElement('ol');
    for (let dlIndex = 0; dlIndex < outlineData.datedLessons.length; dlIndex++) {
        // Build the LI for a lesson
        let li = document.createElement('li');
        li.innerHTML = getNodeLinkHtml(outlineData.datedLessons[dlIndex]);
        datedLessonList.appendChild(li);
    }

    datedLessonLi.appendChild(datedLessonList);
    datedLessonWrapperList.appendChild(datedLessonLi);
    return datedLessonWrapperList;
}

function buildUnitList(outlineData) {
    if (!outlineData || outlineData == undefined) {
        console.warn('Invalid buildUnitList data.');
        return;
    }
    let unitList = document.createElement('ol');
    unitList.classList.add('course-outline-list');

    for (let unitIndex = 0; unitIndex < outlineData.units.length; unitIndex++) {
        const unitData = outlineData.units[unitIndex];
        let unitLi = document.createElement('li');
        let wrapperDiv = document.createElement('div');
        let linkHtml = getNodeLinkHtml(unitData);
        let lessonsList = buildLessonList(unitData.lessons);

        wrapperDiv.innerHTML = linkHtml;
        wrapperDiv.appendChild(lessonsList);

        unitLi.appendChild(wrapperDiv);
        unitList.appendChild(unitLi);
    }
    return unitList;
}

function buildLessonList(lessonData) {
    if (!lessonData || lessonData == undefined) {
        console.warn('Invalid buildLessonList data.');
        return;
    }
    let lessonsList = document.createElement('ol');
    lessonsList.classList.add('course-outline-lessons');

    for (let lessonIndex = 0; lessonIndex < lessonData.length; lessonIndex++) {
        let lessonLi = document.createElement('li');
        lessonLi.innerHTML = getNodeLinkHtml(lessonData[lessonIndex]);
        lessonsList.appendChild(lessonLi);
    }
    return lessonsList;
}

function buildLessonWrapperDiv(lessonData) {
    if (!lessonData || lessonData == undefined) {
        console.warn('Invalid buildLessonWrapperDiv data.');
        return;
    }
    let wrapperDiv = document.createElement('div');
    let linkHtml = getNodeLinkHtml(lessonData);
    let lessonsList = buildLessonList(lessonData);

    wrapperDiv.innerHTML = linkHtml;
    wrapperDiv.appendChild(lessonsList);
    return wrapperDiv;
}

function getCourseOutlineHtml(jsonData) {
    buildCourseOutline(jsonData);
}

function getNodeIconHtml(jsonData) {
    let returnString = "";
    if (!jsonData || jsonData == undefined) {
        console.warn('Invalid getNodeIconHtml data.');
        return returnString;
    }

    if (jsonData.nodeType && jsonData.nodeType == "lesson") {
        if (jsonData.completed && jsonData.completed !== '0001-01-01T00:00:00') {
            returnString += `<i class="material-icons tiny lesson-complete-icon" role="img" aria-label="lesson complete" >check_circle</i>`;
        }
        if (jsonData.skipped && jsonData.skipped !== '0001-01-01T00:00:00') {
            returnString += `<i class="material-icons tiny lesson-skipped-icon" role="img" aria-label="lesson skipped">hide_source</i>`;
        }
    }

    return returnString;
}

function getSkippableClassHtml(jsonData) {
    let returnString = "";
    if (!jsonData || jsonData == undefined) {
        console.warn('Invalid getSkippableClassHtml data.');
        return returnString;
    }
    if (jsonData.skipped && jsonData.skipped !== '0001-01-01T00:00:00') {
        returnString = `lesson-skipped-node`;
    }
    return returnString;
}

function getCustomLessonContentIndicatorHtml(IdCustomLessonContent) {
    let returnString = "";
    if (!IdCustomLessonContent || IdCustomLessonContent == undefined) {
        return returnString;
    }

    returnString += `<div class="has-custom-content-icon-container">
                    <i class="material-icons has-custom-content-icon" role="img" aria-label="has custom lesson content">post_add</i>
                 </div>`;

    return returnString;
}


function getAssessmentTypesHtml(assessmentTypes) {
    let returnString = "";
    if (!assessmentTypes || assessmentTypes == undefined) {
        return returnString;
    }
    if (assessmentTypes && assessmentTypes.length > 0) {
        for (let i = 0; i < assessmentTypes.length; i++) {
            let assessmentTypeName = assessmentTypes[i].name;
            let assessmentTypeCssClass = assessmentTypeCssClasses[assessmentTypeName];
            if (!assessmentTypeCssClass) {
                //Use default css if given assessmentType not found in the dictionary
                assessmentTypeCssClass = assessmentTypeCssClasses['Default']
            }
            returnString += `<div class="assessment-type ${assessmentTypeCssClass}">
                ${assessmentTypeName}
            </div>`;
        }
    }

    return returnString;
}

function getModificationAlertHtml(jsonData) {
    let returnString = "";
    if (!jsonData) {
        console.warn('Invalid getModificationAlertHtml data.');
        return returnString;
    }
    if (jsonData.hasModification) {
        returnString = `<div class="lesson-notes-alert">
                <i class="material-icons tiny" role="img" aria-label="has lesson note">star</i>
            </div>`;
    }
    return returnString;
}

function getAssessmentTypeCssClasses() {
    let returnObject = {};

    returnObject['Default'] = "assessment-type-default";
    returnObject['Sample Work'] = "assessment-type-sample-work";
    returnObject['Quiz'] = "assessment-type-quiz";
    returnObject['Discussion'] = "assessment-type-discussion";
    returnObject['Portfolio Item'] = "assessment-type-portfolio";
    returnObject['Final Exam'] = "assessment-type-final-exam";
    returnObject['Quick Check'] = "assessment-type-quick-check";
    returnObject['Reflection'] = "assessment-type-reflection";
    returnObject['End of Course Exam'] = "assessment-type-end-of-course-exam";
    returnObject['Course Survey'] = "assessment-type-course-survey";
    returnObject['Participation'] = "assessment-type-participation";
    returnObject['Pretest'] = "assessment-type-pretest";
    returnObject['Skills Check'] = "assessment-type-skills-check";
    returnObject['Test'] = "assessment-type-test";
    returnObject['Practice'] = "assessment-type-practice";

    return returnObject;
}

function initializeOutlineModal() {
    const options = {
        onOpenEnd: function (modal, trigger) {
            //when modal is opened, refresh the current lesson indication
            setSelectedTreeNode();
        },
    }
    const outlineModalElem = document.getElementById('outlineModal');
    M.Modal.init(outlineModalElem, options);
}

function setSelectedTreeNode() {
    $(".lesson-current-icon").remove();

    let currentNode = $("[data-idUnit='" + lessonInformation.idUnit + "'][data-idLesson='" + lessonInformation.idLesson + "']");

    //If unit & lesson both equal 0 then we are at course summary node
    //Don't add current lesson icon in this case
    if (lessonInformation.idUnit && lessonInformation.idUnit !== '0' ||
        lessonInformation.idLesson && lessonInformation.idLesson !== '0') {
        //Select the second nested div of the parent anchor tag that matches the attribute values
        currentNode
            .find('div:eq(1)')
            .prepend(`<i class='material-icons tiny lesson-current-icon' role='img' aria-label='current lesson' aria-live='polite'>play_arrow</i>`);
    }

    // Remove the previously selected lesson link's aria-current attribute and put it on the new selected lesson's link.
    let outlineContainer = $('#outlineContainer');

    outlineContainer.find('a[aria-current]').removeAttr('aria-current');
    outlineContainer.find('.active').removeClass('active');
    currentNode.attr('aria-current', 'true');
    currentNode.addClass('active');
    currentNode.focus();
}

function updateOutlineOnLessonComplete() {
    if (!courseOutline || courseOutline == undefined) {
        console.error('Invalid updateOutlineOnLessonComplete data.');
        return;
    }
    if (courseOutline.lessons && courseOutline.lessons.length > 0) {
        //The course has lessons as direct descendents
        let lessons = courseOutline.lessons;
        let lessonIndex = lessons.findIndex((l => l.idLesson == lessonInformation.idLesson))
        //Update the completed property which causes completed icon to display
        courseOutline.lessons[lessonIndex].completed = setOutlineLessonCompletionDate(lessonInformation.lessonCompletionStatus);
    } else if (courseOutline.units && courseOutline.units.length > 0) {
        //The course has units as direct descendents
        let units = courseOutline.units;
        let unitIndex = units.findIndex((u => u.idUnit == lessonInformation.idUnit))
        let unit = units[unitIndex];
        let lessons = unit.lessons;
        let lessonIndex = lessons.findIndex((l => l.idLesson == lessonInformation.idLesson))
        courseOutline.units[unitIndex].lessons[lessonIndex].completed = setOutlineLessonCompletionDate(lessonInformation.lessonCompletionStatus);
    } else {
        console.error('Invalid updateOutlineOnLessonComplete data. Neither Units nor Lessons found.');
        return;
    }

    $('#outlineContainer').html(getCourseOutlineHtml(courseOutline));
}

function setOutlineLessonCompletionDate(status) {
    if (status === 'incomplete') {
        // Some existing logic depends on this being a string of an empty date for incomplete status.
        return '0001-01-01T00:00:00';
    }
    // While other existing logic depends on there being a real date object for a complete status.
    return new Date();
}

function isAllLessonsDated(lessons) {
    //Look for any instances where a lesson is not dated
    //If none found then all lessons are dated so return true
    if (lessons && lessons.length > 0) {
        return lessons.findIndex((l => l.isDated == false)) < 0
    } else {
        return false;
    }
}

function setAssessmentLinks() {
    if (!lessonInformation.isPolarisCourse || lessonInformation.pageCount < 2 || !courseOutline) {
        return;
    }

    const lesson = courseOutline?.units[lessonInformation.unitNumber - 1]?.lessons[lessonInformation.lessonNumber - 1];
    if (!lesson) {
        console.warn('Lesson not found. Assessment links not loaded.');
        return;
    }

    const assessmentModalEl = document.getElementById('assessmentsModal');
    const headerEl = assessmentModalEl.querySelector('#assessmentCountMessage');
    const assessmentCount = lesson?.assessmentTypes.length || 0;
    headerEl.innerHTML = `This lesson has ${assessmentCount} assessment${assessmentCount > 1 ? 's' : ''}`;

    const containerEl = assessmentModalEl.querySelector('#assessmentsContainer');
    containerEl.innerHTML = '';

    for (let i = 2; i <= lessonInformation.pageCount; i++) {
        createAssessmentPlaceholder(containerEl, i, lesson.assessmentTypes[i - 2]?.name || 'Assessment');

        const renderUrl = '/content/render.aspx' + queryStringByPageNumber(i) + '&mobileViewer=true';
        const content = $('#assessmentItem_' + i + ' div.assessment-content');

        $.get(renderUrl).then(function (result) {
            const dom = new DOMParser().parseFromString(result, 'text/html');
            const assessmentLink = dom.querySelector('#lmuContent a');
            const message = dom.querySelector('#lmuContent .messageText');

            if (assessmentLink) {
                assessmentLink.innerHTML = 'Open Assessment';
                content.html(assessmentLink);
            } else if (message) {
                content.html(message.innerHTML);
                content.addClass('assessment-item-message');
            } else {
                content.html('Assessment link not found. Please contact your teacher.');
                content.addClass('assessment-item-message');
            }
        },
            function (err) {
                console.error(err);
                content.html('An error occurred while retrieving the assessment link.');
                content.addClass('assessment-item-message');
            });
    }
}

function createAssessmentPlaceholder(containerEl, pageNumber, labelText) {
    const assessmentItem = document.querySelector('#assessmentItemTemplate').cloneNode(true);
    assessmentItem.id = 'assessmentItem_' + pageNumber;
    assessmentItem.querySelector('label').innerHTML = labelText;
    containerEl.appendChild(assessmentItem);
}

function queryStringByPageNumber(pageNumber) {
    const self = $('#ctl00_self').val(),
        idCourseString = lessonInformation.idCourse == 0 ? '' : lessonInformation.idCourse.toString(),
        idUnitString = lessonInformation.idUnit == 0 ? '' : lessonInformation.idUnit.toString(),
        idLessonString = lessonInformation.idLesson == 0 ? '' : lessonInformation.idLesson.toString(),
        idWebuserString = lessonInformation.idWebuser == 0 ? '' : lessonInformation.idWebuser.toString(),
        idSectionString = lessonInformation.idSection == 0 ? '' : lessonInformation.idSection.toString();

    return '?idCourse=' + idCourseString + '&idUnit=' + idUnitString + '&idLesson=' + idLessonString + '&page=' + pageNumber + '&idWebuser=' + idWebuserString + '&idSection=' + idSectionString + '&self=' + self + '&header=true';
}

function deleteCustomContent() {
    const deletePageModal = $('#deletePageModal');
    deletePageModal.cxLoadingCreate({ blockUI: true, message: 'Deleting Intro Page' });
    $.ajax({
        url: "lessonViewer_responsive.aspx/deleteCustomContent",
        type: "POST",
        data: "{ 'id': '" + getIdCustomLessonContent() + "'}",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data) {
            if (data && data.d) {
                const lesson = findCurrentLesson(courseOutline);
                lesson.idCustomLessonContent = 0;
                lessonInformation.hasCustomLessonContent = false;
                lessonInformation.lessonStarted = true;
                lessonInformation.pageNumber = 1;
                openLesson(queryString());
                $('#outlineContainer').html(getCourseOutlineHtml(courseOutline));
                $("#modifyCustomLessonContent").hide();
                $.fn.cxAlert("Lesson Intro Page has been deleted.", "Deleted", 3000);
            } else {
                $.fn.cxAlert(`<strong>Error!</strong> There was a problem deleting Lesson Intro Page.`, `error`, 3000);
                console.error('data or data.d is invalid');
            }
        },
        error: function () {
            $.fn.cxAlert(`<strong>Error!</strong> There was a problem deleting Lesson Intro Page.`, `error`, 3000);
            console.error('Error deleting Lesson Intro Page');
        },
        complete: function () {
            deletePageModal.cxLoadingRemove();
            M.Modal.getInstance(deletePageModal).close();
        }
    });
}

function updateCustomContent() {
    const content = window.editor.data.get();
    const addPageModal = $('#addPageModal');
    addPageModal.cxLoadingCreate({ blockUI: true, message: 'Saving Intro Page' });
    const payload = {
        id: getIdCustomLessonContent(),
        content: content,
        idWebuser: lessonInformation.loggedInWebuser,
        idSection: lessonInformation.idSection,
        idLesson: lessonInformation.idLesson,
        idWebuserIntroTeacher: $('#introHeaderTeacherSelect').val()
    };
    $.ajax({
        url: "lessonViewer_responsive.aspx/updateCustomContent",
        type: "POST",
        data: JSON.stringify(payload),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data) {
            if (data && data.d) {        
                lessonInformation.pageNumber = 1;
                openLesson(queryString());
                $("#modifyCustomLessonContent").show();
                $.fn.cxAlert("Lesson Intro Page has been saved.", "Updated", 3000);
            } else {
                $.fn.cxAlert(`<strong>Error!</strong> There was a problem editing Lesson Intro Page.`, `error`, 3000);
                console.error('data or data.d is invalid');
            }
        },
        error: function () {
            $.fn.cxAlert(`<strong>Error!</strong> There was a problem editing Lesson Intro Page.`, `error`, 3000);
            console.error('Error editing Lesson Intro Page');
        },
        complete: function () {
            addPageModal.cxLoadingRemove();
            M.Modal.getInstance(addPageModal).close();
        }
    });
}

function validateCustomContent(content) {
    let isValid = true;
    let invalidMessageElement = document.querySelector('.invalid-intro-content');
    invalidMessageElement.textContent = '';

    if (!content || content.trim() === '') {
        // This setTimeout forces the execution of setting the textContent on the next
        // execution cycle. This is needed to allow screen readers to recognize a change to the
        // error text. This accounts for the scenario where a user clicks save multiple times without
        // adding any content. The screen reader will repeat the validation message.
        setTimeout(() => {
            invalidMessageElement.classList.remove('visually-hidden');
            invalidMessageElement.textContent = 'Please enter content.';

        });
        isValid = false;
        window.editor.editing.view.focus();
    }
    else {
        document.querySelector('.invalid-intro-content').classList.add('visually-hidden');
    }
    return isValid;
}

function saveCustomContent() {
    const content = window.editor.data.get();

    if (validateCustomContent(content) === false) {
        return;
    }

    if (lessonInformation.hasCustomLessonContent) {
        updateCustomContent();
        return;
    }

    const addPageModal = $('#addPageModal');
    addPageModal.cxLoadingCreate({ blockUI: true, message: 'Saving Intro Page' });
    const payload = {
        content: content,
        idWebuser: lessonInformation.loggedInWebuser,
        idSection: lessonInformation.idSection,
        idLesson: lessonInformation.idLesson,
        idWebuserIntroTeacher: $('#introHeaderTeacherSelect').val()
    };
    $.ajax({
        url: "lessonViewer_responsive.aspx/saveCustomContent",
        type: "POST",
        data: JSON.stringify(payload),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data) {
            if (data && data.d) {
                const lesson = findCurrentLesson(courseOutline);
                lesson.idCustomLessonContent = data.d;
                lessonInformation.hasCustomLessonContent = true;
                lessonInformation.lessonStarted = false;
                lessonInformation.pageNumber = 1;
                openLesson(queryString());
                //update outline for custom lesson icon
                $('#outlineContainer').html(getCourseOutlineHtml(courseOutline));
                $("#modifyCustomLessonContent").show();
                $.fn.cxAlert("Lesson Intro Page has been saved.", "Saved", 3000);
            } else {
                $.fn.cxAlert(`<strong>Error!</strong> There was a problem saving Lesson Intro Page.`, `error`, 3000);
                console.error('data or data.d is invalid');
            }
        },
        error: function () {
            $.fn.cxAlert(`<strong>Error!</strong> There was a problem saving Lesson Intro Page.`, `error`, 3000);
            console.error('Error saving Lesson Intro Page');
        },
        complete: function () {
            addPageModal.cxLoadingRemove();
            M.Modal.getInstance(addPageModal).close();
        }
    });
}

async function openIntroPageModal(trigger) {
    // Reset modal and editor
    initIntroPageEditor();

    // Open the modal
    const addPageModal = $('#addPageModal');
    addPageModal.cxLoadingCreate({ blockUI: true, message: 'Loading Content' });
    openModal(trigger, 'addPageModal');

    // Get all the data for the modal
    const result = await Promise.all([getSectionTeachers(), getIntroPageContent()]);

    // bail if we didn't get all the data
    if (result == null || result.length < 2) {
        addPageModal.cxLoadingRemove();
        return false;
    }

    const teachers = result[0];
    const introPageContent = result[1];
    const idWebuserSelectedIntroTeacher = introPageContent != null ? introPageContent.IdWebuserSelectedIntroTeacher : 0;


    // Wire up data to modal elements
    
    setTeacherSelect(teachers, idWebuserSelectedIntroTeacher);
    setEditContentData(introPageContent); // Intentionally setting this after the teacher select is populated in initTeacherSelect
    setSelectedIntroTeacherElements();

    addPageModal.cxLoadingRemove();

    return false;
}

function initIntroPageEditor() {
    // Need to reset the height of the editor in case text was removed previously.
    $('#addPageModal .ck.ck-editor, #addPageModal.ck.ck-editor__editable').removeClass('editor-dynamic-height');
    window.editor.data.set('');
    let invalidMessageElement = document.querySelector('.invalid-intro-content');
    invalidMessageElement.classList.add('visually-hidden');
    invalidMessageElement.textContent = '';
    initializeEditorResize();
    $('#introHeaderTeacherSelect').empty();
    $(".save-custom-button").prop("disabled", false);
    $('#introHeaderTeacherSelect').removeClass('inactive-teacher-border');
    const autoAssignedElements = $('.auto-assigned-msg i, .auto-assigned-msg span');
    const inactiveTeacherElements = $('.inactive-teacher-msg i, .inactive-teacher-msg span');
    setMessageVisibility(autoAssignedElements, false);
    setMessageVisibility(inactiveTeacherElements, false);
    $('.intro-header-teacher').hide();
}

async function setTeacherSelect(teachers, IdWebuserSelectedIntroTeacher) {
    if (teachers.length > 0) {
        const $teacherSelectElement = $('#introHeaderTeacherSelect');
        $teacherSelectElement.empty();
        setSectionTeachers(teachers, IdWebuserSelectedIntroTeacher);
        $teacherSelectElement.on('change', setSelectedIntroTeacherElements);
    }
}

async function getSectionTeachers() {
    let result;
    try {
        result = await $.ajax({
            url: 'lessonViewer_responsive.aspx/getSectionTeachers',
            type: "POST",
            data: JSON.stringify({ idSection: lessonInformation.idSection }),
            contentType: 'application/json; charset=utf-8',
            dataType: 'json'            
        });
    }
    catch (error) {
        console.log(JSON.stringify(error));
        console.log('Error getting section teachers');
        $.fn.cxAlert('<strong>Error!</strong> There was a problem getting section teachers.', 'error', 3000);
    }

    if (result == null || result.d == null) {
        return [];
    }

    return result.d;
}

async function getIntroPageContent() {
    let result;
    try {
        result = await $.ajax({
            url: "lessonViewer_responsive.aspx/getCustomContent",
            type: "POST",
            data: "{ 'idSection': '" + lessonInformation.idSection + "', 'idLesson': '" + lessonInformation.idLesson + "'}",
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        });
    }
    catch (error) {
        $.fn.cxAlert(`<strong>Error!</strong> There was a problem getting Lesson Intro Page.`, `error`, 3000);
        console.error('Error getting Lesson Intro Page');
    }
    if (result == null || result.d == null) {
        return null;
    }

    return result.d;
}

async function setEditContentData(data) {
    if (data != null && lessonInformation.hasCustomLessonContent) {
        window.editor.setData(data.Content);
        $('#introHeaderTeacherSelect').val(data.IdWebuserSelectedIntroTeacher);
    }
}    

function setSectionTeachers(teachers, IdWebuserSelectedIntroTeacher) {
    const $introHeaderSelect = $('#introHeaderTeacherSelect');
    $introHeaderSelect.children().remove();
    $introHeaderSelect.append('<option value="">Automatically Assigned</option>');
    $introHeaderSelect.prop('selectedIndex', 0);

    // Get all active, pre-active, or previously selected teachers that have since become inactive.
    const availTeachers = teachers.filter((t) => (t.Status !== 'Inactive') || (t.Status === 'Inactive' && t.IdWebuser === IdWebuserSelectedIntroTeacher));

    // Only bother populating the select element and showing it if there are more than one active/pre-active teacher.
    if (availTeachers.length > 1) {
        availTeachers.forEach((teacher) => {
            const disabledAttr = teacher.Status === 'Inactive' ? 'disabled="disabled"' : '';
            $introHeaderSelect.append(`<option value=${teacher.IdWebuser} ${disabledAttr}>${teacher.Name} - ${teacher.Status}</option>`);
        });
        $introHeaderSelect.formSelect();
        $('.intro-header-teacher').show();
    }
}

function setSelectedIntroTeacherElements() {
    const selSelectedIntroTeacher = $('#introHeaderTeacherSelect');
    const selectedTeacherOption = selSelectedIntroTeacher.val();
    const selectedTeacherOptionText = $("#introHeaderTeacherSelect option:selected").text();
    const autoAssignedElements = $('.auto-assigned-msg i, .auto-assigned-msg span');
    const inactiveTeacherElements = $('.inactive-teacher-msg i, .inactive-teacher-msg span');

    const saveButton = $(".save-custom-button");
    
    if (selectedTeacherOption != null) {
        if (selectedTeacherOption === '') {
            setMessageVisibility(autoAssignedElements, true);
            setMessageVisibility(inactiveTeacherElements, false);
            saveButton.prop("disabled", false);
            selSelectedIntroTeacher.removeClass('inactive-teacher-border');
        } else if (selectedTeacherOptionText && selectedTeacherOptionText.indexOf('Inactive') >= 0) {
            setMessageVisibility(inactiveTeacherElements, true);
            setMessageVisibility(autoAssignedElements, false);
            saveButton.prop("disabled", true);
            selSelectedIntroTeacher.addClass('inactive-teacher-border');
        } else {
            setMessageVisibility(autoAssignedElements, false);
            setMessageVisibility(inactiveTeacherElements, false);
            saveButton.prop("disabled", false);
            selSelectedIntroTeacher.removeClass('inactive-teacher-border');
        }
    }
}

function setMessageVisibility(elements, isVisible) {
    if (isVisible) {
        elements.slideDown({ duration: 100, easing: 'linear' })
            .css('overflow', 'visible'); // This keeps the error icon from being truncated on mobile
    } else {
        elements.slideUp({ duration: 100, easing: 'linear' });
    }
}

/*
 * There is some hassle with how the editor sizes itself. If a height is not specified, then the default
 * height of the editor is just one line. If you set the height, then it honors the height but has a scrollbar
 * when the entered text exceeds the set height. This causes 2 scrollbars in the modal. To prevent this, we start
 * with a fixed height, then if we detect that enough text was added to the editor to cause a scrollbar.
 * When a scrollbar is detected, then we apply the 'editor-dynamic-height' class to remove the set height.
 * With the height set to auto, then the editor expands to height of content and the only scroll is the body
 * content on the modal.
 * If there is a ton of text and the user deletes it, we just let the editor shrink to 1 line. Then when the
 * modal is re-opened, we remove the 'editor-dynamic-height' class to reset things.
 */
function initializeEditorResize() {
    if (window.ResizeObserver) {
        const editorElement = document.querySelector('#addPageModal .ck.ck-editor__editable');
        const resizeObserver = new ResizeObserver(entries => {
            for (let entry of entries) {
                var hasVerticalScrollbar = entry.target.scrollHeight > entry.target.clientHeight;
                const editorEditablesElements = $('#addPageModal .ck.ck-editor, #addPageModal.ck.ck-editor__editable');
                if (hasVerticalScrollbar && !editorEditablesElements.hasClass('editor-dynamic-height')) {
                    editorEditablesElements.addClass('editor-dynamic-height');
                }
            }
        });
        resizeObserver.observe(editorElement);
    }
     else {
        console.log('Resize observer not supported!');
    }
}