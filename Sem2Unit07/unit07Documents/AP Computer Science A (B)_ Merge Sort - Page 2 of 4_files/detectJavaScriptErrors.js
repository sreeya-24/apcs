var javaScriptErrors = "";
var errorCount = 0;

window.onerror = function (message, url, linenumber) {
	errorCount++;
	javaScriptErrors = javaScriptErrors.concat('<tr><td>' + errorCount + '</td><td>' + linenumber + '</td><td>' + message + '</td>' +
	'<td><div style="width=1000px; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">' + url + '</div></td></tr>');
	return false;
};

function displayJsErrors() {
	if (javaScriptErrors != "") {
		var errorbox = document.createElement("div");
		errorbox.className = 'jsErrors';
		errorbox.innerHTML = '<table border="1" bgcolor="#FFCCFF">\
			<tr><th colspan="100%">Javascript Errors</th><tr>\
				<th>#</th><th>Line Number</th><th>Error Message</th><th>Located</th></tr>' +
				javaScriptErrors + 
			'</table>';
		document.body.appendChild(errorbox);
		return true;
	}
	return false;
};