function validatorSetErrorClass(validator) {
	if (validator.controltovalidate == null || validator.controltovalidate == "")
		return;

	var controlIsValid = true;
	var validators = document.getElementById(validator.controltovalidate).Validators;

	if (validators == null) 
		controlIsValid = validator.isvalid;
	else {
		// If any validator on the control is invalid, then display the control as invalid.
		for (var i = 0; i < validators.length; i++)
			if (!validators[i].isvalid) {	
				controlIsValid = false;
				break;
			}
	}


	var elementToHighlight;
	
	var controlToValidateId = validator.controltovalidate;
	if (document.getElementById(controlToValidateId + "Border") != null)
		elementToHighlight = document.getElementById(controlToValidateId + "Border");

	// Grab the textbox of a formula editor if it is a formula editor
	else if (document.getElementById(controlToValidateId + "_formula") != null)
		elementToHighlight = document.getElementById(controlToValidateId + "_formula");

	// Grab the textbox of a RadDateInput if we are passed a RadDateInput id.  If we are passed an entire DateControl ID, see below.
	else if (controlToValidateId.length >= '_dIn'.length && controlToValidateId.substring(controlToValidateId.length - '_dIn'.length, controlToValidateId.length) == '_dIn')
		elementToHighlight = document.getElementById(controlToValidateId + '_text') || document.getElementById(controlToValidateId);
		
	
	else {

		if (controlToValidateId.indexOf('_dPk') > -1) {
			if (controlToValidateId.indexOf('_dPk_wrapper') > -1)
				controlToValidateId = controlToValidateId.replace('_dPk_wrapper', '_dPk_dIn_text');
			else if (controlToValidateId.indexOf('_dPk_dIn_wrapper') > -1)
				controlToValidateId = controlToValidateId.replace('_dPk_dIn_wrapper', '_dPk_dIn_text');
			else
				controlToValidateId = controlToValidateId.replace('_dPk', '_dPk_dIn_text');
		}

		elementToHighlight = document.getElementById(controlToValidateId);
		
		//Error handling for null element to highlight ID 
		if (elementToHighlight == null) {
			if (controlToValidateId == 'eventDate_finishDate_dPk_dIn_text') {
				controlToValidateId = controlToValidateId.replace('_dPk_dIn_text', '_dPk_wrapper');
			}

			elementToHighlight = document.getElementById(controlToValidateId);
		}


		if (elementToHighlight.childNodes.length > 0 && elementToHighlight.childNodes[0].id != null && elementToHighlight.childNodes[0].id.indexOf('_dPk') > -1) {
			controlToValidateId = elementToHighlight.childNodes[0].id;
			if (controlToValidateId.indexOf('_dPk_wrapper') > -1)
				controlToValidateId = controlToValidateId.replace('_dPk_wrapper', '_dPk_dIn');
			else if (controlToValidateId.indexOf('_dPk_dIn_wrapper') > -1)
				controlToValidateId = controlToValidateId.replace('_dPk_dIn_wrapper', '_dPk_dIn_text');
			else
				controlToValidateId = controlToValidateId.replace('_dPk', '_dPk_dIn_text');
			elementToHighlight = document.getElementById(controlToValidateId);
		}

	}

	//Error handling for null element to highlight ID 
	if (elementToHighlight == null) {
		if (controlToValidateId == 'eventDate_finishDate_dPk_dIn_text') {
			controlToValidateId = controlToValidateId.replace('_dPk_dIn_text', '_dPk_wrapper');
		}

		elementToHighlight = document.getElementById(controlToValidateId);
	}
	
	// Date controls need to use special styles to override Telerik default styles in the RadDateInput.
	var isDateControl = validator.controltovalidate.endsWith('dPk_dIn') || validator.controltovalidate.endsWith('ctl01_dIn');
	
	if (isDateControl)
		elementToHighlight.parentNode.className = '';

	if (controlIsValid)
		
		if (elementToHighlight.className.indexOf('required') > -1) {
			if (isDateControl)
				$(elementToHighlight).parent().removeClass('requiredFieldErrorParent');
			$(elementToHighlight).removeClass('requiredFieldError');
		} else {
			if(isDateControl)
				$(elementToHighlight).removeClass('fieldErrorParent');
			$(elementToHighlight).removeClass('fieldError');
		}
			
	else {
		// Change the box color to indicate an error.
		if (elementToHighlight.className.indexOf('required') > -1) {
			if (isDateControl)
				$(elementToHighlight).parent().addClass('requiredFieldErrorParent');
			$(elementToHighlight).addClass('requiredFieldError');
		}
		else {
			if (isDateControl)
				$(elementToHighlight).parent().addClass('fieldErrorParent');
			$(elementToHighlight).addClass('fieldError');
		}
	}
}

function addClass(element, className) {
	if(!element.className.indexOf(className))
	element.className += ' ' + className;
}

function removeClass(element, className) {
	element.className = element.className.replace(new RegExp('(?: ^|\s)' + className + '(?!\S)'), '');
} 