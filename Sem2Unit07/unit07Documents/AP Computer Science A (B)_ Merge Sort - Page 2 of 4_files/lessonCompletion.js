function Permissions() {
	this.canDropAssessments = false;
	this.canDropAssessmentsOnOptionalLessons = false;
	this.canCompleteBeforeAssessmentsAreComplete = false;
}

// You need to set permissions.canDropAssessments and permissions.canDropAssessmentsOnOptionalLessons in your page. Both are booleans.
var permissions = new Permissions();

// action is "completed" or "skipped". unsubmittedAssessments and submittedAssessments are counts. isOptional is a boolean.
// The function will return whether the lesson should stay selected given the confirmations.
function keepLessonSelected(action, unsubmittedAssessments, submittedAssessments, isOptional, lessonName) {
	var response = getLessonSelectionResponse(action, unsubmittedAssessments, submittedAssessments, isOptional, lessonName);
	if (response.message == null)
		return true;
	if (response.isQuestion)
		return confirm(response.message);
	alert(response.message);
	return false;
}

function LessonSelectionResponse(message, isQuestion) {
	this.message = message; // null == no user interaction required
	this.isQuestion = isQuestion; // true == use a confirm(), false = use an alert() and unselect the lesson.
}

function getLessonSelectionResponse(action, unsubmittedAssessments, submittedAssessments, isOptional, lessonName) {
	if (action == "completed" && unsubmittedAssessments > 0) {
		if (permissions.canCompleteBeforeAssessmentsAreComplete)
			return new LessonSelectionResponse(unsubmittedAssessments + " " + pluralize(unsubmittedAssessments, "assessment") + " " + pluralizeHave(unsubmittedAssessments) + " not been submitted for \"" + lessonName + "\". Click OK to mark it complete anyway.", true);
		else
			return new LessonSelectionResponse(unsubmittedAssessments + " " + pluralize(unsubmittedAssessments, "assessment") + " " + pluralizeHave(unsubmittedAssessments) + " not been submitted for \"" + lessonName + "\", so you cannot mark it complete.", false);
	} else if (action == "skipped") {
		if (submittedAssessments > 0) {
			if ((isOptional && permissions.canDropAssessmentsOnOptionalLessons) || permissions.canDropAssessments) {
				return new LessonSelectionResponse(submittedAssessments + " " + pluralize(submittedAssessments, "assessment") + " " + pluralizeHave(submittedAssessments) + " been submitted for \"" + lessonName + "\" and will be dropped from the gradebook. Click OK to skip the lesson and drop the " + pluralize(submittedAssessments, "assessment") + ".", true);
			} else
				return new LessonSelectionResponse(submittedAssessments + " " + pluralize(submittedAssessments, "assessment") + " " + pluralizeHave(submittedAssessments) + " been submitted for \"" + lessonName + "\" and will stay in the gradebook. Click OK to skip the lesson and leave the " + pluralize(submittedAssessments, "assessment") + " in the gradebook.", true);
		}
	}
	return new LessonSelectionResponse();
}

function pluralize(number, noun) {
	var pluralization = noun;
	if (number > 1)
		pluralization += "s";
	return pluralization;
}

function pluralizeHave(number) {
	if (number == 1)
		return "has";
	return "have";
}
