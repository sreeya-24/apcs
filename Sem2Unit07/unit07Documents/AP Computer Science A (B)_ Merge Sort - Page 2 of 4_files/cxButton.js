//DEPENDENCIES:
//cxOverlay.js
//cxOverlay.css

function enableCxButtonOverlay(id, buttonMessage) {
	if ((typeof Page_IsValid === 'undefined') || (Page_IsValid))
		jQuery("body").cxLoadingCreate({ blockUI: true, message: buttonMessage, timeDelay: 250 });
	
	return;
}