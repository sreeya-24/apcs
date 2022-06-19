// Browser checks
function isGecko() {
	//isGecko should really be looking for the gecko rendering agent used by Firefox.  The commented return line checked for
	//something that the firefox implements, but IE9 now implements as well so it does not give the expected results.  We will check
	//the appName for "Netscape" for the time being which is used by both Firefox and Chrome.  This function should eventually be renamed.
	return navigator.appName == "Netscape";
}

function isIe() {
    var isIe = navigator.appName == "Microsoft Internet Explorer" || !!(navigator.userAgent.match(/Trident/) && !navigator.userAgent.match(/MSIE/));
    return isIe;
}

function isOpera() {
    return navigator.appName == "Opera";
}

// Sets the text attribute of an element
// innerText   - IE
// textContent - Firefox
function setInnerText(elementId, innerText) {
    if (isIe()) // IE
        document.getElementById(elementId).innerText = innerText;
    else
        document.getElementById(elementId).textContent = innerText;
}

function setInnerHTML(elementId, innerText) {
    if (isIe()) // IE
        document.getElementById(elementId).innerHTML = innerText;
    else
        document.getElementById(elementId).innerHTML = innerText;
}

// Get the text value of an element
// innerText	- IE
// textContent	- Firefox
function getInnerText(elementId) {
    if (isIe()) // IE
        return document.getElementById(elementId).innerText;
    else
        return document.getElementById(elementId).textContent;
}

// Sets the text attribute of an element
// innerText   - IE
// textContent - Firefox
function getXmlNodeText(node) {
    if (isIe()) {
        return node.text;
    } else {
        return node.textContent;
    }
}
