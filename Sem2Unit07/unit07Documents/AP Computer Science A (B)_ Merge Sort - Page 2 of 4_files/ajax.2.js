// Ajax requests will work only for synchronous GET requests.
// Tested in IE6 and Firefox with Firebug on and off.

// Constants
var REQUEST_IS_COMPLETE = 4;

// XMLHttpRequest object is supported in Internet Explorer 5.0+, Safari 1.2, 
// Mozilla 1.0 / Firefox, Opera 8+, and Netscape 7.
function AjaxRequest() {
	var remoteRequest = getAjaxObject();

	this.readyState = function () { return remoteRequest.readyState; };
	this.responseText = function () { return remoteRequest.responseText; };
	this.responseXML = function () { return remoteRequest.responseXML; };
	this.status = function () { return remoteRequest.status; };

	// GET Request
	// url: the URL of the server-side script
	// asyc: true - the request should be handled asynchronously
	this.sendGetRequest = function (url, async, handler) {
		remoteRequest.open("GET", url, async);
		remoteRequest.onreadystatechange = handler;

		//Fix for IE10 to be able to use MSXML functionality
		if ("ActiveXObject" in window) {
			try {
				// If we can create the following object, then the subsequent responseType is needed because IE doesn't have native document.evalute/XPath support.
				var testObject = new ActiveXObject("Msxml2.XMLHTTP");
				remoteRequest.responseType = "msxml-document";
			} catch (e) {

			}
		}

		// if the header is not set this way, the browser will cache the response and never re-submit the request
		remoteRequest.setRequestHeader('Cache-Control', 'no-cache');
		remoteRequest.setRequestHeader('Pragma', 'no-cache');
		remoteRequest.send('');

		// Firefox <= 2.0.0 doesn't fire onreadystatechange for synchronous requests.
		// If so, force it.
		try {
			if (!async && isGecko() && remoteRequest.onreadystatechange == null) {
				handler();
			}
		} catch (e) {
		}
	};

	// XPATH functions on AJAX response
	this.selectSingleNode = function (xPath) { return selectSingleNode(remoteRequest.responseXML, xPath); };
	this.selectNodes = function (xPath) { return selectNodes(remoteRequest.responseXML, xPath); };
}

function getAjaxObject() {
	var remoteRequest;

	if (window.XMLHttpRequest) {     // code for all new browsers
		remoteRequest = new XMLHttpRequest();

		if (isGecko())
			remoteRequest.overrideMimeType('text/xml'); // for some Mozilla browsers
	}
	else if (window.ActiveXObject) { // code for IE5 and IE6
		try {
			remoteRequest = new ActiveXObject("Microsoft.XMLHTTP");
		} catch (e) {
			remoteRequest = new ActiveXObject("Msxml2.XMLHTTP");
		}
	}
	return remoteRequest;
}

// if IE or Opera, DOM functions are available, otherwise do some workaround
function selectSingleNode(xmlDoc, elementPath) {

	if ("XPathEvaluator" in window) {
		var xpe = new XPathEvaluator();
		var nsResolver = xpe.createNSResolver(xmlDoc.ownerDocument == null ? xmlDoc.documentElement : xmlDoc.ownerDocument.documentElement);
		var results = xpe.evaluate(elementPath, xmlDoc, nsResolver, XPathResult.FIRST_ORDERED_NODE_TYPE, null);
		return results.singleNodeValue;
	} else {
		return xmlDoc.selectSingleNode(elementPath);
	}
}

function selectNodes(xmlDoc, elementPath) {

	if ("XPathEvaluator" in window) {
		var xpe = new XPathEvaluator();
		var nsResolver = xpe.createNSResolver(xmlDoc.ownerDocument == null ? xmlDoc.documentElement : xmlDoc.ownerDocument.documentElement);
		var results = xpe.evaluate(elementPath, xmlDoc, nsResolver, XPathResult.ORDERED_NODE_ITERATOR_TYPE, null);

		var nodes = new Array();
		if (results != null) {
			var element = results.iterateNext();
			while (element) {
				nodes.push(element);
				element = results.iterateNext();
			}
		}
		return nodes;
	} else {
		return xmlDoc.selectNodes(elementPath);
	}
}
