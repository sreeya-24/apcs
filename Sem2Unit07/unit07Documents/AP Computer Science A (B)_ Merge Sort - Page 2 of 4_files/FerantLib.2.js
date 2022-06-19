//-------------This page contains code that is Copyright Ferant.com 2003-----------------------
var _912	= '';
var _911 = '';
var zIndexStart = 100;
var isDragging = false;
var isResizing = false;
var _907 = false;
var _906 = new Object();
var _905	= new Object();
var _904	= new Object();
var _903	= new Object();
var _902	= new Object();

var isNetscape = (navigator.appName=="Netscape")?'isNetscape':'isNotNetscape';

popupLeft = 0;
popupTop = 0;
popupWidth = 0;
popupHeight = 0;	

function _892(){	
	
	for(x in parameters)
		eval('this.' + parameters[x] + ' = this.' + _890[x]);
}
	
function FerantDHTMLWindow(params){

	this._889 = 'FerantDHTMLWindow1'; 
	
	this.StatusLeftMargin = 10; //StatusLeftMargin: sets status bar left margin width
	this.TitleLeftMargin = 10;	//TitleLeftMargin: sets title bar left margin width
	this.TitleFontSize = 11; //TitleFontSize: sets TitleBar font-size
	this.TitleFontFamily = 'verdana,arial'; //TitleFontFamily: sets TitleBar font-family
	this.TitleFontWeight = 'Bold'; //TitleFontWeight: sets TitleBar font-weight
	this.TitleFontColor = 'white'; //TitleFontColor: sets TitleBar font-color
	this.TitleFontStyle = 'Normal'; //TitleFontStyle: sets TitleBar font-style
	this.ContentFontSize = 11; //ContentFontSize: sets Content font-size
	this.ContentFontFamily = 'verdana,arial'; //ContentFontFamily: sets Content font-family
	this.ContentFontWeight = 'Normal'; //ContentFontWeight: sets Content font-weight
	this.ContentFontColor = 'black'; //ContentFontColor: sets Content font-color
	this.ContentFontStyle = 'Normal'; //ContentFontStyle: sets Content font-style
	this.StatusFontSize = 10; //StatusFontSize: sets StatusBar font-size
	this.StatusFontFamily = 'verdana,arial'; //StatusFontFamily: sets StatusBar font-family
	this.StatusFontWeight = 'Normal'; //StatusFontWeight: sets StatusBar font-weight
	this.StatusFontColor = 'black'; //StatusFontColor: StatusBar font-color
	this.StatusFontStyle = 'Normal'; //StatusFontStyle: StatusBar font-style
	this.BorderColor  = 'white'; //BorderColor: sets border color of popup
	this.BorderInactiveColor  = 'Transparent'; //BorderInactiveColor: 
	this.BorderWidth  = 0; //BorderWidth: sets border width of popup
	this.CloseBoxHeight  = 16; //CloseBoxHeight: sets image height of close box icon
	this.CloseBoxSrc  = '/images/Closebox.gif'; //CloseBoxSrc: sets image src of close box icon
	this.CloseBoxWidth  = 16; //CloseBoxWidth: sets image width of close box icon
	this.ContentColor  = '#ffffcc'; //ContentColor: sets background color of content area
	this.ContentInactiveColor  = 'Transparent'; //ContentInactiveColor
	this.ContentBottomBorderColor  = 'Navy'; //ContentBottomBorderColor: sets border-bottom color of content area
	this.ContentBottomBorderWidth  = 0; //ContentBottomBorderWidth: sets border-bottom size of content area
	this.ContentHTML  = ''; //ContentHTML: sets default text in content area
	this.ContentLeftBorderColor  = 'Navy'; //ContentLeftBorderColor: sets border-left color of content area
	this.ContentLeftBorderWidth  = 0; //ContentLeftBorderWidth: sets border-left size of content area
	this.ContentPadding  = 10; //ContentPadding: sets padding around content
	this.ContentRightBorderColor  = 'Navy'; //ContentRightBorderColor: sets border-right color of content area
	this.ContentRightBorderWidth  = 0; //ContentRightBorderWidth: sets border-right size of content area
	this.ContentTopBorderColor  = 'Navy'; //ContentTopBorderColor: sets border-top color of content area
	this.ContentTopBorderWidth  = 0; //ContentTopBorderWidth: sets border-top size of content area
	this.Dragable  = 'Both'; //Dragable: Controls if the popup window can be dragged
	this.Height  = '300px'; //Height: Popup window default height
	this.InnerBorderColor  = '#003399'; //InnerBorderColor: sets the outlining border color
	this.InnerBorderStyle  = 'solid'; //InnerBorderStyle: sets the outlining border style
	this.InnerBorderWidth  = 2; //InnerBorderWidth: sets the outline border width
	this.Left  = -1; //Left: Sets left position of popup window
	this.MaxHeight  = 0; //MaxHeight
	this.MaxWidth  = 0; //MaxWidth
	this.MinHeight  = 0; //MinHeight
	this.MinWidth  = 0; //MinWidth
	this.OuterBorderColor  = 'Gray'; //OuterBorderColor: sets outer border color
	this.OuterBorderInactiveColor  = 'Transparent'; //OuterBorderInactiveColor
	this.OuterBorderStyle  = 'Solid'; //OuterBorderStyle: sets outside border style of popup 
	this.OuterBorderWidth  = 0; //OuterBorderWidth: sets outside border width of popup
	this.Resizable  = 'Both'; //Resizable: sets if popup can be resized
	this.ResizeBoxHeight  = 15; //ResizeBoxHeight: sets image height of resize box icon
	this.ResizeBoxSrc  = '/images/resize_blue.gif'; //ResizeBoxSrc: sets image src of resize box icon
	this.ResizeBoxWidth  = 15; //ResizeBoxWidth: sets image width of resize box icon
	this.Shadow  = 0; //Shadow: sets the drop shadow size for the popup
	this.StatusBarHeight  = 20; //StatusBarHeight: sets the height of the status bar
	this.StatusBarHTML  = ''; //StatusBarHTML: sets the default html for the status bar
	this.StatusBarInactiveColor  = 'Transparent'; //StatusBarInactiveColor
	this.StatusBarText  = ''; //StatusBarText: sets the text content for the status bar
	this.StatusBarTextMargin  = 50; //StatusBarTextMargin: function?
	this.StatusBarAlign  = 'Left'; //StatusBarAlign: sets alignment of status bar text
	this.StatusColor  = '#cccccc'; //StatusColor: sets background color of status bar
	this.TitleBarHeight  = 18; //TitleBarHeight: sets the height of the title bar
	this.TitleBarHTML  = ''; //TitleBarHTML
	this.TitleBarText  = ''; //TitleBarText: sets default text in title bar
	this.ContentNoWrap  = 'Normal'; //ContentNoWrap: sets if the content text wraps
	this.TitleBarAlign  = 'Left'; //TitleBarAlign: sets alignment of title bar text
	this.TitleColor  = '#003399'; //TitleColor: sets background color of title bar
	this.TitleBarInactiveColor  = 'Transparent'; //TitleBarInactiveColor
	this.Top  = -1; //Top: sets top position of popup window
	this.Width  = '380px'; //Width: sets default width of popup window
	this._892 = _892;		
	
	this._892();

	for(x in params)
		this[parameters[x]] = params[x];	
	
	this._818	= parseInt(this.TitleBarHeight - this.CloseBoxHeight)/2;
	
	this._815  = true;
	if (this.ResizeBoxHeight == 0 || this.ResizeBoxWidth == 0 || this.ResizeBoxHeight == '' || this.StatusBarHeight == 0) {
		this._815 = false;
	}

	this._811  = true;
	if (this.CloseBoxHeight == 0 || this.CloseBoxWidth == 0 || this.CloseBoxHeight == '' || this.TitleBarHeight == 0) {
		this._811 = false;
	}

	if(String(this.Height).indexOf('px') < 0) {
		this.Height += 'px';
	}

	if (String(this.Width).indexOf('px') < 0) {
		this.Width += 'px';
	}
	
	if(typeof(_906[this.DhtmlID])=='string'){
		alert("Error! \n\nTwo Ferant DHTM windows found with the same id: '" + this.DhtmlID + "'. Each window must have a unique id.");
		return;
	}
	
	_906[this.DhtmlID] = this.DhtmlID;
		
	// Put an iFrame if we are using IE to handle rendering problems with dropdowns/divs.
	if (document.all) {
		this.ieDivUnderlayFrame = document.createElement("IFRAME");
		this.ieDivUnderlayFrame.setAttribute("id","ieDivUnderlayFrame2" + this.DhtmlID);
		this.ieDivUnderlayFrame.setAttribute("frameBorder","0");
		this.ieDivUnderlayFrame.setAttribute("scrolling","no");
		this.ieDivUnderlayFrame.style.backgroundColor = 'transparent';
		this.ieDivUnderlayFrame.style.visibilty = "hidden";  
		this.ieDivUnderlayFrame.style.display = "none";
		this.ieDivUnderlayFrame.style.position = "absolute";
		this.ieDivUnderlayFrame.style.left = "-1";
		this.ieDivUnderlayFrame.style.top = "-1";
		this.ieDivUnderlayFrame.style.width = "0px";
		this.ieDivUnderlayFrame.style.height = "0px";
		this.ieDivUnderlayFrame.style.zIndex = -1; /* IE hack, for transparency z-Index of IFrame should be less than that one of the element it is displayed above */
		this.ieDivUnderlayFrame.src = '/blank.html';
		this.ieDivUnderlayFrame.setAttribute('allowtransparency', 'true');
		document.body.appendChild(this.ieDivUnderlayFrame);
	}

	this.divContainer  = document.createElement("div");
	this.divContainer.setAttribute("id","_807" + this.DhtmlID); 
	this.divContainer.style.position = "absolute";  
	this.divContainer.style.display = "none";
	this.divContainer.style.overflow = "hidden";
	this.divContainer.style.borderStyle = this.OuterBorderStyle;
	this.divContainer.style.borderWidth = this.OuterBorderWidth + 'px';
	this.divContainer.style.borderColor = this.OuterBorderColor;
	this.divContainer.style.backgroundColor = this.BorderColor;

	this.TitleBar = document.createElement("span");
	this.TitleBar.setAttribute("id","_801f_Title_"); 
	this.TitleBar.style.position = "absolute";  
	this.TitleBar.style.left = this.BorderWidth +  "px"; 
	this.TitleBar.style.top = this.BorderWidth + "px"; 
	this.TitleBar.style.display = "none"; 
	this.TitleBar.style.backgroundColor=this.TitleColor;
	this.TitleBar.style.cursor='default';
	this.TitleBar.style.borderColor = this.InnerBorderColor;
	this.TitleBar.style.borderStyle='solid';
	this.TitleBar.style.borderWidth=this.InnerBorderWidth  + 'px';
	this.TitleBar.style.overflow="hidden";	
	this.TitleBar.style.fontSize = this.TitleFontSize  + 'px';
	this.TitleBar.style.fontFamily = this.TitleFontFamily;
	this.TitleBar.style.fontWeight = this.TitleFontWeight;
	this.TitleBar.style.color = this.TitleFontColor;
	this.TitleBar.style.fontStyle = this.TitleFontStyle; 
	if(isNetscape=='isNotNetscape')
		this.TitleBar.style.height = this.TitleBarHeight   + 2 * this.InnerBorderWidth  + 'px';
	else
		this.TitleBar.style.height = this.TitleBarHeight  + 'px';
	this.TitleBar.innerHTML = this.TitleBarText.replace(/</g,'&lt;').replace(/>/g,'&gt;');
	this.TitleBar.style.textAlign  = this.TitleBarAlign;
	this.TitleBar.style.whiteSpace = 'nowrap';
	this.TitleBar.style.paddingTop = Math.max(0,parseInt((this.TitleBarHeight - this.TitleFontSize )/2) - 1) + 'px';


	this.CloseBox = document.createElement("a"); //Must be an anchor rather than span tag to allow screen readers to focus and click.
	this.CloseBox.style.position = "absolute";  
	this.CloseBox.style.left = "0px";
	this.CloseBox.style.display = "none";  
	this.CloseBox.style.top = "0px";
	this.CloseBox.style.height = this.CloseBoxHeight + "px";
	this.CloseBox.style.width = this.CloseBoxWidth + "px";
	this.CloseBox.style.cursor = "hand";
	this.CloseBox.style.overflow = "hidden";
	this.CloseBox.innerHTML = "<img src='" + this.CloseBoxSrc + "' height = " +
							this.CloseBox.style.height + " width = " + this.CloseBox.style.width + " id='_787'>";

	this.divContent = document.createElement("div");
	this.divContent.setAttribute("id","_785" + this.DhtmlID); 
	this.divContent.style.backgroundColor = this.ContentColor; 
	this.divContent.style.position = "absolute"; 
	this.divContent.style.display = "none"; 
	this.divContent.innerHTML = this.ContentHTML;
	this.divContent.style.left = this.BorderWidth  + 'px';
	this.divContent.style.top = parseInt(this.BorderWidth) + parseInt(this.TitleBarHeight) + parseInt(this.InnerBorderWidth)  + 'px';
	this.divContent.style.borderColor = this.InnerBorderColor; 	
	this.divContent.style.borderStyle = this.InnerBorderStyle;
	this.divContent.style.borderWidth = this.InnerBorderWidth  + 'px';
	this.divContent.style.whiteSpace = this.ContentNoWrap; 
	this.divContent.style.overflow='auto';
	this.divContent.style.padding = this.ContentPadding + 'px ' + this.ContentPadding + 'px ' +
										this.ContentPadding + 'px ' + this.ContentPadding + 'px';
										
	if(this.ContentTopBorderWidth != 0){ 
		this.divContent.style.borderTopColor = this.ContentTopBorderColor;
		this.divContent.style.borderTopWidth = this.ContentTopBorderWidth  + 'px';
	}
		
	if(this.ContentRightBorderWidth != 0){
		this.divContent.style.borderRightColor = this.ContentRightBorderColor;
		this.divContent.style.borderRightWidth = this.ContentRightBorderWidth  + 'px';
	}
		
	if(this.ContentBottomBorderWidth != 0){
		this.divContent.style.borderBottomColor = this.ContentBottomBorderColor;
		this.divContent.style.borderBottomWidth = this.ContentBottomBorderWidth  + 'px';
	}

		
	if(this.ContentLeftBorderWidth != 0){
		this.divContent.style.borderLeftColor = this.ContentLeftBorderColor;
		this.divContent.style.borderLeftWidth = this.ContentLeftBorderWidth  + 'px';
	}
										
	this.divContent.style.fontSize = this.ContentFontSize  + 'px';
	this.divContent.style.fontFamily = this.ContentFontFamily;
	this.divContent.style.fontWeight = this.ContentFontWeight;
	this.divContent.style.color = this.ContentFontColor;
	this.divContent.style.fontStyle = this.ContentFontStyle; 

	this.StatusBar = document.createElement("div"); 
	this.StatusBar.setAttribute("id","statusBarId"); 
	this.StatusBar.style.display = "none"; 
	this.StatusBar.style.position = "absolute"; 
	this.StatusBar.style.overflow = "hidden"; 
	this.StatusBar.style.left=this.BorderWidth  + 'px';
	this.StatusBar.style.backgroundColor=this.StatusColor;
	if (this.StatusBarHeight > 0) {
		this.StatusBar.style.paddingTop = Math.max(0, parseInt((this.StatusBarHeight - this.StatusFontSize) / 2) - 1) + 'px';
	}

	this.StatusBar.style.borderColor = this.InnerBorderColor; 	
	this.StatusBar.style.borderStyle='solid';
	this.StatusBar.style.borderWidth=this.InnerBorderWidth  + 'px';	
	this.StatusBar.style.fontSize = this.StatusFontSize + 'px';
	this.StatusBar.style.fontFamily = this.StatusFontFamily;
	this.StatusBar.style.fontWeight = this.StatusFontWeight;
	this.StatusBar.style.color = this.StatusFontColor;
	this.StatusBar.style.fontStyle = this.StatusFontStyle; 
	this.StatusBar.innerHTML = this.StatusBarText.replace(/</g,'&lt;').replace(/>/g,'&gt;');
	this.StatusBar.style.textAlign  = this.StatusBarAlign;
	this.StatusBar.style.whiteSpace = 'nowrap';
	
	if(this.TitleBarHTML != '') 
		this.TitleBar.innerHTML = this.TitleBarHTML; 
	else 
		this.TitleBar.innerHTML = this.TitleBarText.replace(/</g,'&lt;').replace(/>/g,'&gt;');
		
	if(this.StatusBarHTML != '') 
		this.StatusBar.innerHTML = this.StatusBarHTML; 
	else 
		this.StatusBar.innerHTML = this.StatusBarText.replace(/</g,'&lt;').replace(/>/g,'&gt;');	

	this.ResizeButton = document.createElement("span");
	this.ResizeButton.style.position = "absolute";  
	this.ResizeButton.style.left = "0px"; 
	this.ResizeButton.style.height = this.ResizeBoxHeight + "px";
	this.ResizeButton.style.width = this.ResizeBoxWidth + "px";
	this.ResizeButton.style.cursor = "nw-resize";
	this.ResizeButton.style.display = "none";
	this.ResizeButton.innerHTML = "<img src='" + this.ResizeBoxSrc + "' height = " + this.ResizeButton.style.height +
									" width=" + this.ResizeButton.style.width + " id='_753'>";

	this.divKey = document.createElement("div"); 
	this.divKey.setAttribute("id","_divKeyID"); 
	this.divKey.style.position = "absolute";  
	this.divKey.style.display = "none";
	this.divKey.style.overflow = "hidden";
	this.divKey.style.backgroundColor='gray';
	if(isNetscape=='isNotNetscape')
		this.divKey.style.filter="alpha(opacity=50)";
	else	
		this.divKey.style.MozOpacity=.5;

	this.ResizeCorner = document.createElement("div");
	this.ResizeCorner.setAttribute("id","ResizeCornerID"); 
	this.ResizeCorner.style.backgroundColor = "transparent";  
	this.ResizeCorner.style.position = "absolute"; 
	this.ResizeCorner.style.cursor = "nw-resize"; 
	this.ResizeCorner.style.width = "11px"; 
	this.ResizeCorner.style.height = "11px"; 
	this.ResizeCorner.style.overflow = "hidden";  
	this.ResizeCorner.innerHTML = "&nbsp;";
	this.ResizeCorner.style.display = "none";

	this.divContainer.appendChild(this.TitleBar);
	this.divContainer.appendChild(this.divContent);
	document.body.appendChild(this.ResizeButton);
	this.divContainer.appendChild(this.StatusBar);

	document.body.appendChild(this.divKey);
	document.body.appendChild(this.ResizeCorner);
	document.body.appendChild(this.divContainer);
	document.body.appendChild(this.CloseBox);

	this.ResizeWindow = ResizeWindow;
	this.DragWindow = DragWindow;
	this.PositionIFrame = PositionIFrame;
	this._748 = _748;
	this._747 = _747;
	this.EndDrag = EndDrag;
	this._745 = _745;
	this._744 = _744;
	
	this.UpdateTitleBarText = UpdateTitleBarText;
	this.UpdateTitleBarHTML = UpdateTitleBarHTML;
	this.UpdateContentHTML = UpdateContentHTML;
	this.UpdateStatusBarText = UpdateStatusBarText;
	this.UpdateStatusBarHTML = UpdateStatusBarHTML;
	this.OpenWindow = OpenWindow; 
	this.CloseWindow = CloseWindow;
	
	this._743 = false;
}

var parameters = new Object();

	parameters.Id = 'DhtmlID';
	parameters.StatusLeftMargin = 'StatusLeftMargin';
	parameters.TitleLeftMargin = 'TitleLeftMargin';
	parameters.BorderColor  = 'BorderColor';
	parameters.BorderInactiveColor  = 'BorderInactiveColor' ;
	parameters.BorderWidth  = 'BorderWidth';
	parameters.CloseBoxHeight  = 'CloseBoxHeight' ;
	parameters.CloseBoxSrc  = 'CloseBoxSrc' ;
	parameters.CloseBoxWidth  = 'CloseBoxWidth';
	parameters.ContentColor  = 'ContentColor';
	parameters.ContentInactiveColor  = 'ContentInactiveColor' ;
	parameters.ContentBottomBorderColor  = 'ContentBottomBorderColor' ;
	parameters.ContentBottomBorderWidth  = 'ContentBottomBorderWidth' ;
	parameters.ContentHTML  =  'ContentHTML';
	parameters.ContentLeftBorderColor  = 'ContentLeftBorderColor';
	parameters.ContentLeftBorderWidth  = 'ContentLeftBorderWidth' ;
	parameters.ContentPadding  = 'ContentPadding';
	parameters.ContentRightBorderColor  = 'ContentRightBorderColor' ;
	parameters.ContentRightBorderWidth  = 'ContentRightBorderWidth' ;
	parameters.ContentTopBorderColor  = 'ContentTopBorderColor' ;
	parameters.ContentTopBorderWidth  = 'ContentTopBorderWidth' ;
	parameters.Dragable  = 'Dragable';
	parameters.Height  = 'Height' ;
	parameters.InnerBorderColor  = 'InnerBorderColor' ;
	parameters.InnerBorderStyle  = 'InnerBorderStyle' ;
	parameters.InnerBorderWidth  = 'InnerBorderWidth' ;
	parameters.Left  = 'Left' ;
	parameters.MaxHeight  = 'MaxHeight' ;
	parameters.MaxWidth  = 'MaxWidth' ;
	parameters.MinHeight  = 'MinHeight' ;
	parameters.MinWidth  = 'MinWidth' ;
	parameters.OuterBorderColor  = 'OuterBorderColor' ;
	parameters.OuterBorderInactiveColor  = 'OuterBorderInactiveColor' ;
	parameters.OuterBorderStyle  = 'OuterBorderStyle' ;
	parameters.OuterBorderWidth  = 'OuterBorderWidth' ;
	parameters.Resizable  = 'Resizable' ;
	parameters.ResizeBoxHeight  = 'ResizeBoxHeight' ;
	parameters.ResizeBoxSrc = 'ResizeBoxSrc' ;
	parameters.ResizeBoxWidth  = 'ResizeBoxWidth' ;
	parameters.Shadow  = 'Shadow' ;
	parameters.StatusBarHeight  = 'StatusBarHeight' ;
	parameters.StatusBarHTML  = 'StatusBarHTML' ;
	parameters.StatusBarInactiveColor  = 'StatusBarInactiveColor' ;
	parameters.StatusBarText  = 'StatusBarText' ;
	parameters.StatusBarTextMargin  = 'StatusBarTextMargin' ;
	parameters.StatusBarAlign  = 'StatusBarAlign' ;
	parameters.StatusColor  = 'StatusColor' ;
	parameters.TitleBarHeight  = 'TitleBarHeight' ;
	parameters.TitleBarHTML  = 'TitleBarHTML' ;
	parameters.TitleBarText  = 'TitleBarText' ;
	parameters.ContentNoWrap  = 'ContentNoWrap' ;
	parameters.TitleBarAlign  = 'TitleBarAlign' ;
	parameters.TitleColor  = 'TitleColor' ;
	parameters.TitleBarInactiveColor  = 'TitleBarInactiveColor' ;
	parameters.Top  = 'Top' ;
	parameters.Width  = 'Width' ;	
	parameters.TitleFontSize  = 'TitleFontSize' ;
	parameters.TitleFontFamily  = 'TitleFontFamily' ;
	parameters.TitleFontWeight  = 'TitleFontWeight' ;
	parameters.TitleFontColor  = 'TitleFontColor' ;
	parameters.TitleFontStyle   = 'TitleFontStyle' ;
	parameters.ContentFontSize  = 'ContentFontSize' ;
	parameters.ContentFontFamily  = 'ContentFontFamily' ;
	parameters.ContentFontWeight  = 'ContentFontWeight' ;
	parameters.ContentFontColor  = 'ContentFontColor' ;
	parameters.ContentFontStyle   = 'ContentFontStyle' ;
	parameters.StatusFontSize  = 'StatusFontSize' ;
	parameters.StatusFontFamily  = 'StatusFontFamily' ;
	parameters.StatusFontWeight  = 'StatusFontWeight' ;
	parameters.StatusFontColor  = 'StatusFontColor' ;
	parameters.StatusFontStyle   = 'StatusFontStyle' ;
	
	var _890 = new Object();

	_890.Id = '_889';
	_890.StatusLeftMargin = 'StatusLeftMargin';
	_890.TitleLeftMargin = 'TitleLeftMargin';
	_890.BorderColor  = 'BorderColor';
	_890.BorderInactiveColor  = 'BorderInactiveColor' ;
	_890.BorderWidth  = 'BorderWidth';
	_890.CloseBoxHeight  = 'CloseBoxHeight' ;
	_890.CloseBoxSrc  = 'CloseBoxSrc' ;
	_890.CloseBoxWidth  = 'CloseBoxWidth';
	_890.ContentColor  = 'ContentColor';
	_890.ContentInactiveColor  = 'ContentInactiveColor' ;
	_890.ContentBottomBorderColor  = 'ContentBottomBorderColor' ;
	_890.ContentBottomBorderWidth  = 'ContentBottomBorderWidth' ;
	_890.ContentHTML  =  'ContentHTML';
	_890.ContentLeftBorderColor  = 'ContentLeftBorderColor';
	_890.ContentLeftBorderWidth  = 'ContentLeftBorderWidth' ;
	_890.ContentPadding  = 'ContentPadding';
	_890.ContentRightBorderColor  = 'ContentRightBorderColor' ;
	_890.ContentRightBorderWidth  = 'ContentRightBorderWidth' ;
	_890.ContentTopBorderColor  = 'ContentTopBorderColor' ;
	_890.ContentTopBorderWidth  = 'ContentTopBorderWidth' ;
	_890.Dragable  = 'Dragable';
	_890.Height  = 'Height' ;
	_890.InnerBorderColor  = 'InnerBorderColor' ;
	_890.InnerBorderStyle  = 'InnerBorderStyle' ;
	_890.InnerBorderWidth  = 'InnerBorderWidth' ;
	_890.Left  = 'Left' ;
	_890.MaxHeight  = 'MaxHeight' ;
	_890.MaxWidth  = 'MaxWidth' ;
	_890.MinHeight  = 'MinHeight' ;
	_890.MinWidth  = 'MinWidth' ;
	_890.OuterBorderColor  = 'OuterBorderColor' ;
	_890.OuterBorderInactiveColor  = 'OuterBorderInactiveColor' ;
	_890.OuterBorderStyle  = 'OuterBorderStyle' ;
	_890.OuterBorderWidth  = 'OuterBorderWidth' ;
	_890.Resizable  = 'Resizable' ;
	_890.ResizeBoxHeight  = 'ResizeBoxHeight' ;
	_890.ResizeBoxSrc = 'ResizeBoxSrc' ;
	_890.ResizeBoxWidth  = 'ResizeBoxWidth' ;
	_890.Shadow  = 'Shadow' ;
	_890.StatusBarHeight  = 'StatusBarHeight' ;
	_890.StatusBarHTML  = 'StatusBarHTML' ;
	_890.StatusBarInactiveColor  = 'StatusBarInactiveColor' ;
	_890.StatusBarText  = 'StatusBarText' ;
	_890.StatusBarTextMargin  = 'StatusBarTextMargin' ;
	_890.StatusBarAlign  = 'StatusBarAlign' ;
	_890.StatusColor  = 'StatusColor' ;
	_890.TitleBarHeight  = 'TitleBarHeight' ;
	_890.TitleBarHTML  = 'TitleBarHTML' ;
	_890.TitleBarText  = 'TitleBarText' ;
	_890.ContentNoWrap  = 'ContentNoWrap' ;
	_890.TitleBarAlign  = 'TitleBarAlign' ;
	_890.TitleColor  = 'TitleColor' ;
	_890.TitleBarInactiveColor  = 'TitleBarInactiveColor' ;
	_890.Top  = 'Top' ;
	_890.Width  = 'Width' ;	
	_890.TitleFontSize  = 'TitleFontSize' ;
	_890.TitleFontFamily  = 'TitleFontFamily' ;
	_890.TitleFontWeight  = 'TitleFontWeight' ;
	_890.TitleFontColor  = 'TitleFontColor' ;
	_890.TitleFontStyle   = 'TitleFontStyle' ;
	_890.ContentFontSize  = 'ContentFontSize' ;
	_890.ContentFontFamily  = 'ContentFontFamily' ;
	_890.ContentFontWeight  = 'ContentFontWeight' ;
	_890.ContentFontColor  = 'ContentFontColor' ;
	_890.ContentFontStyle   = 'ContentFontStyle' ;
	_890.StatusFontSize  = 'StatusFontSize' ;
	_890.StatusFontFamily  = 'StatusFontFamily' ;
	_890.StatusFontWeight  = 'StatusFontWeight' ;
	_890.StatusFontColor  = 'StatusFontColor' ;
	_890.StatusFontStyle   = 'StatusFontStyle' ;

	var _723 = new Object();
	
	_723.StatusLeftMargin = false;
	_723.TitleLeftMargin = false;
	_723.BorderColor  = true;
	_723.BorderInactiveColor  = true ;
	_723.BorderWidth  = false;
	_723.CloseBoxHeight  = false ;
	_723.CloseBoxSrc  = true ;
	_723.CloseBoxWidth  = false;
	_723.ContentColor  = true;
	_723.ContentInactiveColor  = true ;
	_723.ContentBottomBorderColor  = true ;
	_723.ContentBottomBorderWidth  = false ;
	_723.ContentHTML  =  true;
	_723.ContentLeftBorderColor  = true;
	_723.ContentLeftBorderWidth  = false ;
	_723.ContentPadding  = false;
	_723.ContentRightBorderColor  = true ;
	_723.ContentRightBorderWidth  = false ;
	_723.ContentTopBorderColor  = true ;
	_723.ContentTopBorderWidth  = false ;
	_723.Dragable  = true;
	_723.Height  = false ;
	_723.InnerBorderColor  = true ;
	_723.InnerBorderStyle  = true ;
	_723.InnerBorderWidth  = false ;
	_723.Left  = false ;
	_723.MaxHeight  = false ;
	_723.MaxWidth  = false ;
	_723.MinHeight  = false ;
	_723.MinWidth  = false ;
	_723.OuterBorderColor  = true ;
	_723.OuterBorderInactiveColor  = true ;
	_723.OuterBorderStyle  = true ;
	_723.OuterBorderWidth  = false ;
	_723.Resizable  = true ;
	_723.ResizeBoxHeight  = false ;
	_723.ResizeBoxSrc  = true ;
	_723.ResizeBoxWidth  = false ;
	_723.Shadow  = false ;
	_723.StatusBarHeight  = false ;
	_723.StatusBarHTML  = true ;
	_723.StatusBarInactiveColor  = true ;
	_723.StatusBarText  = true ;
	_723.StatusBarTextMargin  = false ;
	_723.StatusBarAlign  = true ;
	_723.StatusColor  = true ;
	_723.TitleBarHeight  = false ;
	_723.TitleBarHTML  = true ;
	_723.TitleBarText  = true ;
	_723.ContentNoWrap  = true ;
	_723.TitleBarAlign  = true ;
	_723.TitleColor  = true ;
	_723.TitleBarInactiveColor  = true ;
	_723.Top  = false ;
	_723.Width  = false ;	
	_723.TitleFontSize  = false ;
	_723.TitleFontFamily  = true ;
	_723.TitleFontWeight  = true ;
	_723.TitleFontColor  = true ;
	_723.TitleFontStyle   = true ;
	_723.ContentFontSize  = false ;
	_723.ContentFontFamily  = true ;
	_723.ContentFontWeight  = true ;
	_723.ContentFontColor  = true ;
	_723.ContentFontStyle   = true ;
	_723.StatusFontSize  = false ;
	_723.StatusFontFamily  = true ;
	_723.StatusFontWeight  = true ;
	_723.StatusFontColor  = true ;
	_723.StatusFontStyle   = true ;	
	
	var originalHeight;
	var originalWidth;

function OpenWindow() {
    $.fn.showFerantWindow(this);
	isDragging = false;
	isResizing = false;

	if ( this.DhtmlID != _912){
		if(_912 != '') {
			_911 = _912;
			eval(_911 + '._744();');
		}
		_912 = this.DhtmlID;
	}

	if (!this._743) {
		this._748();
	}

	if (this.ResizeBoxHeight == 0 || this.ResizeBoxWidth == 0 || this.ResizeBoxSrc == '' ||
									this.StatusBarHeight == 0 || this.Resizable == 'None') {
		this._815 = false;
	} else {
		this._815 = true;
	}

	if(this.CloseBoxHeight == 0 || this.CloseBoxWidth == 0 || this.CloseBoxSrc == '' || this.TitleBarHeight == 0) 
		this._811  = false;
  else
		this._811  = true;		

	var x=0; 
	var y=0;

	if (originalHeight == null) {
		originalHeight = this.Height.replace('px', '');
	}
	if (originalWidth == null) {
		originalWidth = this.Width.replace('px', '');
	}

	/* determine the current width & height of the browser window, so we can setup the maximum height and width values */
	var winWidth, winHeight, d=document;
	if (typeof window.innerWidth != 'undefined') { //  Where supported in NN: (>NN4.0)
		winWidth = window.innerWidth;
		winHeight = window.innerHeight;
	} else {
		if (d.documentElement && typeof d.documentElement.clientWidth != 'undefined' &&  d.documentElement.clientWidth != 0) { // Where supported in IE: (>IE4.0)
			winWidth = d.documentElement.clientWidth;
			winHeight = d.documentElement.clientHeight;
		} else {
			if (d.body && typeof d.body.clientWidth != 'undefined') { // When using IE6 with in CSS1Compat mode (i.e. with a Formal DOCTYPE):
				winWidth = d.body.clientWidth;
				winHeight = d.body.clientHeight;
			}
		}
	}

	// don't set the MaxHeight because that causes the user not to be able to make it bigger than that if they want to
	// we just want to set the initial height to something reasonable if what it is currently set to is bigger than a certain percentage of the screen
	var preferredHeight = winHeight * 0.80; 
	var preferredWidth = winWidth * 0.80; 
	/* end setting preferrend height & width */

	if (originalHeight > preferredHeight) {
		this.Height = preferredHeight + 'px';
	} else {
		this.Height = originalHeight + 'px';
	}

	if (originalWidth > preferredWidth) {
		this.Width = preferredWidth + 'px';
	} else {
		this.Width = originalWidth + 'px';
	}
	var h = this.Height.replace('px', '');
	var w = this.Width.replace('px', '');

	if (this.Top == -1) {
	    y = window.innerHeight / 2 - h / 2 + window.pageYOffset;
		if(y < 0) {
			y = 0;
		} else {
			y = window.innerHeight / 2 - h / 2 + window.pageYOffset;
		}
	} else {
		if (isNetscape == 'isNotNetscape') {
			y = this.Top + document.body.scrollTop;
		} else {
			y = this.Top + window.pageYOffset;
		}
	}

	if (this.Left == -1) {
		if (isNetscape == 'isNotNetscape') {
			x = document.body.offsetWidth / 2 - w / 2 + document.body.scrollLeft;
		} else {
			x = window.innerWidth / 2 - w / 2 + window.pageXOffset;
		}
	} else {
		if (isNetscape == 'isNotNetscape') {
			x = this.Left + document.body.scrollLeft;
		} else {
			x = this.Left + window.pageXOffset;
		}
	}

	this.divContent.style.display = 'block'; 
	this.TitleBar.style.display = 'block';
	if(this._811){	
			this.CloseBox.style.display='block';
	} else { 
		this.CloseBox.style.display='none';
	}
	
	if (this.Resizable  != 'none' && this._815)	
		this.ResizeButton.style.display='block';
	else
		this.ResizeButton.style.display='none';
	
	this.ResizeCorner.style.display = (this.Resizable.toLowerCase() == 'none' || this._815 )? "none" : "block";

	if (this.StatusBarHeight > 0) {
		this.StatusBar.style.display = 'block';
	}

	this.divContainer.style.display = 'block';

	if (this.Shadow) {
		this.divKey.style.display = 'block';
	} else {
		this.divKey.style.display = 'none';
	}

	this.divKey.style.zIndex=++zIndexStart;
	this.divContainer.style.zIndex=++zIndexStart;
	this.ResizeButton.style.zIndex=++zIndexStart;
	this.ResizeCorner.style.zIndex=++zIndexStart;
	this.CloseBox.style.zIndex=++zIndexStart;	
	
	var paddingTitleTop = Math.max(0,parseInt((this.TitleBarHeight - this.TitleFontSize - 1)/2));
	if (this.TitleBarHTML != '') {
		this.TitleBar.style.padding = '0px 0px 0px 0px';
		paddingTitleTop = 0;
	} else {
		this.TitleBar.style.padding = paddingTitleTop + 'px 0px 0px ' + this.TitleLeftMargin + 'px';
	}
	if (isNetscape == 'isNotNetscape') {
		this.TitleBar.style.height = this.TitleBarHeight + 2 * this.InnerBorderWidth;
	} else {
		this.TitleBar.style.height = this.TitleBarHeight - paddingTitleTop;
	}
	if (this.StatusBarHeight >0){
		var paddingStatusTop = Math.max(0,parseInt((this.StatusBarHeight - this.StatusFontSize - 1)/2));

		if (this.StatusBarHTML != '') {
			this.StatusBar.style.padding = '0px 0px 0px 0px';
			paddingStatusTop = 0;
		} else {
			this.StatusBar.style.padding = paddingStatusTop + 'px 0px 0px ' + this.StatusLeftMargin + 'px';
		}
		if (isNetscape == 'isNotNetscape') {
			this.StatusBar.style.height = this.StatusBarHeight + 2 * this.InnerBorderWidth;
		} else {
			this.StatusBar.style.height = this.StatusBarHeight - paddingStatusTop;
		}
	}		
	
	if(!_907){		 
		_905[this.DhtmlID] = x;
		_904[this.DhtmlID] = y;
		_903[this.DhtmlID] = h;
		_902[this.DhtmlID] = w;		
			
		this.ResizeWindow(w,h,true);
		this.DragWindow(x,y,true);
		
	} else {
	
		this.ResizeWindow(_902[this.DhtmlID],_903[this.DhtmlID],true);
		this.DragWindow(_905[this.DhtmlID] ,_904[this.DhtmlID],true);	
	}		
	this._745();	
} 

function _748(){ 
	this._743 = true;	
	
	_722 = this.DhtmlID;
	
	this.TitleBar.onmousedown = new Function("_721", "if(_912 != '" + _722 + "' && _911 != '') {" +
	"_911 = _912; _912 = '" + _722 + "'; eval(_912 + '._745();'); eval(_911 + '._744();')} else" +
	"{ _912 = '" + _722 + "';} _720(_721); return false;");


	if (this._811) {
		this.CloseBox.onmousedown = new Function("if(_912 != '" + _722 + "' && _912 != '') " +
			"_911 = _912; _912 = '" + _722 + "'; " +
			"  if(_911!='') eval(_911 + '._745();'); " +
			"eval('" + _722 + "' + '.CloseWindow();'); if(_911 != '') _912 = _911; _911 = '';");
	}

	if (this.Resizable != 'none') {
		this.ResizeButton.onmousedown = new Function("_721", "if(_912 != '" + _722 +
			"' && _911 != '') {" + "_911 = _912; _912 = '" + _722 +
				"'; eval(_912 + '._745();'); eval(_911 + '._744();')} else" +
					"{ _912 = '" + _722 + "';} _718(_721); return false;");
	}

	if (this.Resizable != 'none') {
		this.ResizeCorner.onmousedown = new Function("_721", "if(_912 != '" +
			_722 + "' && _911 != '') {" + "_911 = _912; _912 = '" + _722 +
				"'; eval(_912 + '._745();');_719(); eval(_911 + '._744();')} else" +
					"{ _912 = '" + _722 + "';} _718(_721); return false;");
	}
}
 
document.onmousemove = DoDrag;
document.onmouseup = new Function("if (isDragging || isResizing) eval(_912 + '.EndDrag();');  isResizing = false; isDragging = false;");

function DoDrag(_721) {
	if (isResizing == false && isDragging == false) {
		return true;
	}
	if(_912!=''){
		if(isNetscape=='isNotNetscape'){
			if(event.button !=1 ) {
				isResizing = false; 
				isDragging = false; 
				return true;
			}
		}
		
		_716 = (isNetscape=='isNotNetscape')?event.clientX + document.body.scrollLeft:_721.pageX;
		_715= (isNetscape=='isNotNetscape')?event.clientY + document.body.scrollTop:_721.pageY;	
		window.setTimeout("_714()",10);
		
		if(isResizing || isDragging ) {
			if (isNetscape == 'isNotNetscape') {
				event.returnValue = false;
			}
			return false;
		} 
	}
	
	return false;
}

function UpdateTitleBarText(titleBarText){
	this.TitleBar.innerHTML = titleBarText.replace(/</g,'&lt;').replace(/>/g,'&gt;');	
}
 
 function UpdateTitleBarHTML(titleHtml){
	this.TitleBar.innerHTML = titleHtml;	
 }
 
 function UpdateContentHTML(contentHtml){
	this.divContent.innerHTML = contentHtml;	
}
 
 function UpdateStatusBarText(statusBarText){
	this.StatusBar.innerHTML = statusBarText.replace(/</g,'&lt;').replace(/>/g,'&gt;');	
}
 
 function UpdateStatusBarHTML(statusBarHtml){
	this.StatusBar.innerHTML = statusBarHtml;
}
 
 
 function _747(){
 	if (!this.Shadow) {
 		return;
 	}

 	this.divContainer.style.left = parseInt(this.divContainer.style.left) + 2  + 'px';
	this.divContainer.style.top = parseInt(this.divContainer.style.top) + 2 + 'px';
	this.divKey.style.left = parseInt(this.divKey.style.left) + 2 +'px';
	this.divKey.style.top =  parseInt(this.divKey.style.top) + 2 + 'px';
	this.divKey.style.display='none';

	if (this._815) {
		this.ResizeButton.style.left = parseInt(this.ResizeButton.style.left) + 2 + 'px';
	}
 	this.CloseBox.style.left = parseInt(this.CloseBox.style.left) + 2  + 'px';
 	if (this._815) {
 		this.ResizeButton.style.top = parseInt(this.ResizeButton.style.top) + 2 + 'px';
 	}
 	this.CloseBox.style.top = parseInt(this.CloseBox.style.top) + 2  + 'px';
	
	_905[this.DhtmlID] += 2;
	_904[this.DhtmlID] += 2;
 }
	
 function EndDrag(){ 
 
	isResizing = false;
	isDragging = false;

	if (!this.Shadow) {
		return;
	}
 	if (this.divContainer.style.display != 'block') {
 		return;
 	}
	
	this.divContainer.style.left = parseInt(this.divContainer.style.left) - 2  + 'px';
	this.divContainer.style.top = parseInt(this.divContainer.style.top) - 2 + 'px';
	this.divKey.style.left = parseInt(this.divKey.style.left) - 2 +'px';
	this.divKey.style.top = parseInt(this.divKey.style.top) - 2 + 'px';
	this.divKey.style.display='block';

	if (this._815) {
		this.ResizeButton.style.left = parseInt(this.ResizeButton.style.left) - 2 + 'px';
	}
 	this.CloseBox.style.left = parseInt(this.CloseBox.style.left) - 2  + 'px';
 	if (this._815) {
 		this.ResizeButton.style.top = parseInt(this.ResizeButton.style.top) - 2 + 'px';
 	}
 	this.CloseBox.style.top = parseInt(this.CloseBox.style.top) - 2  + 'px';
	
	_905[this.DhtmlID] -= 2;
	_904[this.DhtmlID] -= 2;
} 	
	
function _745(){ 		
	this.TitleBar.style.backgroundColor = this.TitleColor;
	this.divContainer.style.borderColor= this.OuterBorderColor;
	this.divContainer.style.backgroundColor = this.BorderColor;

	this.StatusBar.style.backgroundColor = this.StatusColor; 
	this.divContent.style.backgroundColor = this.ContentColor;
 } 
 
 function _744(){ 	
 
	if(this.TitleBarInactiveColor != 'Transparent')
		this.TitleBar.style.backgroundColor = this.TitleBarInactiveColor;		
 
	if(this.OuterBorderInactiveColor != 'Transparent') 
		this.divContainer.style.borderColor = this.OuterBorderInactiveColor;
		
	if(this.BorderWidth > 0 && this.BorderInactiveColor !='Transparent') 
		this.divContainer.style.backgroundColor = this.BorderInactiveColor;		

	
		
	if(this.StatusBarInactiveColor != 'Transparent')	
		this.StatusBar.style.backgroundColor = this.StatusBarInactiveColor;
			
		
	if(this.ContentInactiveColor != 'Transparent')
		 this.divContent.style.backgroundColor = this.ContentInactiveColor;
 } 
 
 function CloseWindow() { 	
	this.divContainer.style.display='none';
	this.divContent.style.display='none';
	this.TitleBar.style.display='none';
	this.ResizeButton.style.display='none';
	this.ResizeCorner.style.display='none';
	this.divKey.style.display='none';
	this.StatusBar.style.display='none';
	this.CloseBox.style.display='none';
	
	this.PositionIFrame(-1,-1,-1,-1,'None');
 } 

 function DragWindow(x,y,doDrag){ 
	x=parseInt(x);
	y=parseInt(y); 
	
	var resizeX = doDrag;
	if(this.Dragable == 'VerticalOnly' || this.Dragable == 'Both') {
		resizeX = true;
	}
	
	var resizeY = doDrag;
	if(this.Dragable == 'HorizontalOnly' || this.Dragable == 'Both') {
		resizeY = true;
	}

	if(resizeY) {
		this.divContainer.style.left = x + 'px';
		_905[this.DhtmlID] = x;
	}
	if(resizeX) {
		this.divContainer.style.top = y + 'px';
		_904[this.DhtmlID] = y;
	}

	if(typeof(x)!='number') {
		x = parseInt(x);
	}
	if(typeof(y)!='number') {
		y = parseInt(y);
	}

	if(this.Shadow  && resizeY) {
		this.divKey.style.left = (x + 3) + 'px';
	}
 	
	if(this.Shadow  && resizeX) {
		this.divKey.style.top = (y + 3) + 'px';
	}

	if(resizeY) {
		this.ResizeCorner.style.left = (x - 9 + parseInt(this.divContainer.style.width)) + 'px';
	}
	if(resizeX) {
		this.ResizeCorner.style.top = (y - 9 + parseInt(this.divContainer.style.height)) + 'px';
	}

	if(resizeY && this._811) {
		this.CloseBox.style.left = (x + _902[this.DhtmlID] - 2 * this.OuterBorderWidth - 2 * this.BorderWidth - 2 * this.InnerBorderWidth - this.CloseBoxWidth -
			this._818 + this.BorderWidth + this.OuterBorderWidth + this.InnerBorderWidth) + 'px';
	}
	if(resizeX && this._811) {
		this.CloseBox.style.top = (y + this._818 + this.BorderWidth + this.OuterBorderWidth + this.InnerBorderWidth) + 'px';
	}

	if(resizeY && this._815) {
		this.ResizeButton.style.left = (_905[this.DhtmlID] + _902[this.DhtmlID] -
			this.OuterBorderWidth - this.BorderWidth - this.InnerBorderWidth - this.ResizeBoxHeight) + 'px';
	}

	if (resizeX && this._815) {
		var resizeButtonTop = (_904[this.DhtmlID] + _903[this.DhtmlID] -
			this.OuterBorderWidth - this.BorderWidth - this.InnerBorderWidth - this.ResizeBoxWidth);
		if(isNetscape != 'isNotNetscape' && document.doctype != null) {
			resizeButtonTop -= 4;
		}
		this.ResizeButton.style.top = resizeButtonTop + 'px';
	}

	if (resizeY && resizeX) {
		this.PositionIFrame(y, x, -1, -1, 'Position');
	}
 }

 function ResizeWindow(w, h, doResize) {
	w = Math.max(w, 2 * this.OuterBorderWidth + 2 * this.BorderWidth + 2 * this.InnerBorderWidth + this._818 + this.CloseBoxWidth);

	h = Math.max(h, this.StatusBarHeight + 2 * this.OuterBorderWidth + 2 * this.BorderWidth + 3 * this.InnerBorderWidth + parseInt(this.TitleBarHeight));

	if (this.MaxHeight > 0) {
		h = Math.min(h, this.MaxHeight);
	}
	if (this.MinHeight > 0) {
		h = Math.max(h, this.MinHeight);
	}
	if (this.MaxWidth > 0) {
		w = Math.min(w, this.MaxWidth);
	}
	if (this.MinWidth > 0) {
		w = Math.max(w, this.MinWidth);
	}
	var resizeHeight = doResize;
	if(this.Resizable  == 'Both' || this.Resizable  == 'VerticalOnly') {
		resizeHeight = true;
	}
	var resizeWidth = doResize;
	if(this.Resizable  == 'Both' || this.Resizable  == 'HorizontalOnly') {
		resizeWidth = true;
	}

	if(isNetscape=='isNotNetscape'){
		if (resizeWidth) {
			this.divContainer.style.width = w + 'px';
		}
		if (resizeHeight) {
			this.divContainer.style.height = h + 'px';
		}
	} else {
		if(resizeWidth) {
			this.divContainer.style.width = (w - 2 * this.OuterBorderWidth) + 'px';
		}
		if(resizeHeight) {
			this.divContainer.style.height = (h - 2 * this.OuterBorderWidth) + 'px';
		}
	}     

	if(resizeWidth) {
		_902[this.DhtmlID] = w;
	}
	if(resizeHeight) {
		_903[this.DhtmlID] = h;
	}

	if(resizeWidth && this._811) {
		this.CloseBox.style.left = (_905[this.DhtmlID] + w - 2 * this.OuterBorderWidth - 2 * this.BorderWidth -
			2 * this.InnerBorderWidth - this.CloseBoxWidth -
				this._818 + this.BorderWidth + this.OuterBorderWidth + this.InnerBorderWidth) + 'px';
	}
	if(resizeHeight && this._811) {
		this.CloseBox.style.top = (_904[this.DhtmlID] + this._818 +
			this.BorderWidth + this.OuterBorderWidth + this.InnerBorderWidth) + 'px';
	}

	if(resizeWidth && isNetscape=='isNotNetscape') {
		this.TitleBar.style.width = (w - 2 * this.OuterBorderWidth - 2 * this.BorderWidth) + 'px';
	}
	if(resizeWidth && isNetscape!='isNotNetscape') {
		this.TitleBar.style.width = (w - 2 * this.OuterBorderWidth
			- 2 * this.BorderWidth - 2 * this.InnerBorderWidth -
				parseInt((this.TitleBarHTML == '') ? this.TitleLeftMargin : 0)) + 'px';
	}

	if(this.Shadow && resizeWidth) {
		this.divKey.style.width = w + 'px';
	}
	if(this.Shadow && resizeHeight) {
		this.divKey.style.height = w + 'px';
	}

	if(isNetscape=='isNotNetscape'){
		if (resizeWidth) {
			var contentWidth = w - 2 * this.OuterBorderWidth - 2 * this.BorderWidth;
			if(document.doctype != null) {
				contentWidth -= 24;
			}
			this.divContent.style.width = contentWidth + 'px';
		}
	}else{
		if(resizeWidth) {
			this.divContent.style.width = (w - this.ContentRightBorderWidth - this.ContentLeftBorderWidth -
				2 * this.ContentPadding - 2 * this.OuterBorderWidth - 2 * this.BorderWidth - 2 * this.InnerBorderWidth) + "px";
		}
	}

	if (resizeHeight) {
		if (this.StatusBarHeight > 0) {
			if (isNetscape == 'isNotNetscape') {
				this.divContent.style.height = (h - this.StatusBarHeight - this.TitleBarHeight - 2 * this.BorderWidth -
					2 * this.OuterBorderWidth - 2 * this.InnerBorderWidth) + 'px';
			} else {
				this.divContent.style.height = (h - this.ContentTopBorderWidth - this.ContentBottomBorderWidth -
					this.StatusBarHeight - 2 * this.ContentPadding - this.TitleBarHeight - 2 * this.BorderWidth -
						2 * this.OuterBorderWidth - 4 * this.InnerBorderWidth) + 'px';
			}
		} else {
			if (isNetscape == 'isNotNetscape') {
				this.divContent.style.height = (h - this.StatusBarHeight - this.TitleBarHeight - 2 * this.BorderWidth - 2 * this.OuterBorderWidth - this.InnerBorderWidth) + 'px';
			} else {
				this.divContent.style.height = (h - this.ContentTopBorderWidth - this.ContentBottomBorderWidth -
					this.StatusBarHeight - 2 * this.ContentPadding - this.TitleBarHeight - 2 * this.BorderWidth -
						2 * this.OuterBorderWidth - 3 * this.InnerBorderWidth) + 'px';
			}
		}
	}

	if (resizeWidth && this.StatusBarHeight > 0 && isNetscape == 'isNotNetscape') {
		var statusWidth = w - 2 * this.OuterBorderWidth - 2 * this.BorderWidth;
		if(document.doctype != null) {
			statusWidth -= 14;
		}
		this.StatusBar.style.width = statusWidth + 'px';
	}
	if(resizeWidth && this.StatusBarHeight > 0 && isNetscape!='isNotNetscape') {
		this.StatusBar.style.width = (w -
			2 * this.OuterBorderWidth - 2 * this.BorderWidth - 2 * this.InnerBorderWidth -
				parseInt((this.StatusBarHTML == '') ? this.StatusLeftMargin : 0)) + 'px';
	}

	if (resizeHeight && this.StatusBarHeight > 0) {
		var statusBarTop = h - 2 * this.OuterBorderWidth - this.BorderWidth - 2 * this.InnerBorderWidth - this.StatusBarHeight;
		if (isNetscape == 'isNotNetscape' && document.doctype != null) {
			statusBarTop += 4;
		}  
		this.StatusBar.style.top = statusBarTop + 'px';
	}

 	if(resizeWidth && this._815) {
		this.ResizeButton.style.left = (_905[this.DhtmlID] + _902[this.DhtmlID] -
			this.OuterBorderWidth - this.BorderWidth - this.InnerBorderWidth - this.ResizeBoxHeight) + 'px';
	}

	if (resizeHeight && this._815) {
		var resizeButtonTop = _904[this.DhtmlID] + _903[this.DhtmlID] - this.OuterBorderWidth - this.BorderWidth - this.InnerBorderWidth - this.ResizeBoxWidth;
		if (isNetscape != 'isNotNetscape' && document.doctype != null) {
			resizeButtonTop -= 4;
		}
		this.ResizeButton.style.top = resizeButtonTop + 'px';
	}

	if(resizeWidth && !doResize && !this._815 && this.Resizable  != 'none') {
		this.ResizeCorner.style.left = (parseInt(this.divContainer.style.left) - 9 + w) + 'px';
	}
	;
	if(resizeHeight && !doResize && !this._815 && this.Resizable  != 'none') {
		this.ResizeCorner.style.top = (parseInt(this.divContainer.style.top) - 9 + h) + 'px';
	}

	if (resizeWidth && resizeHeight) {
		this.PositionIFrame(-1, -1, h, w, 'Size');
	}
 }
  
 function _714(){   

	if(isDragging){		
		var x= _716 + popupLeft;
		var y = _715+ popupTop;			
		eval(_912 + ".DragWindow('" + x + "','" + y + "',false);");		
	}	
		
	if(isResizing){	 			
		var _708=_716 + popupWidth;
		var _707=_715 + popupHeight;
		eval(_912 + ".ResizeWindow('" + _708 + "','" + _707 + "',false);");
	}

	if (isResizing || isDragging) {
		return false;
	}
 }
 
 function _718(_721){	
	if(isNetscape=='isNotNetscape'){
		popupWidth = parseInt(eval(_912 + ".divContainer.style.width")) - event.clientX - document.body.scrollLeft;
		popupHeight = parseInt(eval(_912 + ".divContainer.style.height")) - event.clientY - document.body.scrollTop; 
	}else{ 	
		popupWidth = parseInt(eval(_912 + ".divContainer.style.width")) - _721.pageX;
		popupHeight = parseInt(eval(_912 + ".divContainer.style.height")) - _721.pageY; 
	}
	if (eval(_912 + ".Shadow") && !isResizing) {
		eval(_912 + "._747();");
	}

 	_719();

	isResizing = true; 	
 }
 
 function _720(_721){
 	if (eval(_912 + ".Shadow") && !isDragging) {
 		eval(_912 + "._747();");
 	}

 	if(isNetscape=='isNotNetscape'){	
		popupLeft = parseInt(eval(_912 + ".divContainer.style.left;")) - event.clientX - document.body.scrollLeft;
		popupTop = parseInt(eval(_912 + ".divContainer.style.top;")) - event.clientY - document.body.scrollTop; 
	}else{
		popupLeft = parseInt(eval(_912 + ".divContainer.style.left;")) - _721.pageX;
		popupTop = parseInt(eval(_912 + ".divContainer.style.top;")) - _721.pageY; 
	}
		
	isDragging = true;
 }
 
 function _719(){
 	if (document.all) {
 		eval(_912 + ".ieDivUnderlayFrame.style.zIndex=++zIndexStart;");
 	}
 	eval(_912 + ".divKey.style.zIndex=++zIndexStart;");
	eval(_912 + ".divContainer.style.zIndex=++zIndexStart;");
	eval(_912 + ".ResizeCorner.style.zIndex=++zIndexStart;");
	eval(_912 + ".CloseBox.style.zIndex=++zIndexStart;");
	eval(_912 + ".ResizeButton.style.zIndex=++zIndexStart;"); 		
			
}

  function _139(_138){ 
	var _137 = "_785";
	if (_138.indexOf(_137) != 0) {
		return "";
	}
  	return _138.substring(_137.length);  
 }

 function _136(_135, _134, _133, _132, _131) {
 	for (_130 in _906)  //"_807" + this.DhtmlID
 	{

 		if (document.getElementById('_807' + _906[_130]).style.display != 'none' &&
	 		((_135 <= _905[_130] && _905[_130] <= _135 + _133) || (_905[_130] <= _135 && _135 <= _905[_130] + _902[_130])) &&
		 		((_134 <= _904[_130] && _904[_130] <= _134 + _132) || (_904[_130] <= _134 && _134 <= _904[_130] + _903[_130]))) {
 			if (_131 == '') {
 				return true;
 			}

 			if (document.getElementById('_807' + _131).style.zIndex < document.getElementById('_807' + _906[_130]).style.zIndex) {
 				return true;
 			}
 		}
 	}
 	return false;
 }

 function GetAbsoluteLeft(id){
	var left = 0;
	if (id.offsetParent){
		while (id.offsetParent){
			left += id.offsetLeft;
			id = id.offsetParent;
		}
	}else if(id.x){ 
		left += id.x;
	}
	
	return left;
 }
 
 function GetAbsoluteTop(id){
	var top  = 0;
	if (id.offsetParent){
		while (id.offsetParent){
			top += id.offsetTop;
			id = id.offsetParent;
		}
	}else if (id.y){ 
		top += id.y;
	}
	
	return top;
 }

 function PositionIFrame(top, left, height, width, mode) {
 	// The iframe only needs to be used for IE.
 	if (document.all) {
 		if (mode != 'None') {
 			if (mode == 'Position') {
 				this.ieDivUnderlayFrame.style.left = left + 'px';
 			}
 			if (mode == 'Position') {
 				this.ieDivUnderlayFrame.style.top = top + 'px';
 			}
 			if (mode == 'Size') {
 				this.ieDivUnderlayFrame.style.width = width;
 			}
 			if (mode == 'Size') {
 				this.ieDivUnderlayFrame.style.height = height;
 			}
 			this.ieDivUnderlayFrame.style.display = "block";
 			this.ieDivUnderlayFrame.style.visibility = "visible";
 		} else {
 			this.ieDivUnderlayFrame.style.display = "none";
 			this.ieDivUnderlayFrame.style.visibility = "hidden";
 			this.ieDivUnderlayFrame.style.left = '-1px';
 			this.ieDivUnderlayFrame.style.top = '-1px';
 			this.ieDivUnderlayFrame.style.width = '0px';
 			this.ieDivUnderlayFrame.style.height = '0px';
 		}
 	}
 }

//-----------------------------------------------------------------------------------------------
//Javascript modifications to make Ferant DHTML Windows keyboard and screen reader accessible!
//-----------------------------------------------------------------------------------------------

 $(document).ready(function () {
     var selectedHelp; //Stores currently selected help icon.

     //Add tabindex attributes to Ferant HTML help window contents.
     var ferantHelpWindows = $("[id*='_807'],[id='_807']");
     var closeButtons = $("[src='/images/Closebox.gif']").parent();
     if (ferantHelpWindows.length > 0) {
         for (var i = 0; i < ferantHelpWindows.length; i++) {
             //Combine window title and content into aria-label.
             var helpContentScreenReader = $($(ferantHelpWindows[i]).children()[0]).text() + ". " + $(ferantHelpWindows[i]).find(".popOverWindow").text();
             $(ferantHelpWindows).attr("aria-label", helpContentScreenReader); //Popover windows are tab index 1.
         }       
         $(ferantHelpWindows).prop("tabIndex", 1); //Popover windows are tab index 1.
         $(closeButtons).prop("tabIndex", 2); //Close buttons are tab index 2.
         $(closeButtons).attr("role", "button"); //Close buttons are tab index 2.
         $(closeButtons).attr("aria-label", "Close Button. Select to close help window!"); //Close buttons are tab index 2.
         $(closeButtons).on("keyup", function() {
             $.fn.giveSelectedFocusElementOutline($(this), true);
             $.fn.giveSelectedFocusElementOutline($(this).prev(), false);
         });

         //Add keydown event for enter key if user tabs to close button and chooses to close ferant window - OR - if user tabs passed close buttom and choose to return to help window content
         $(closeButtons).on("keydown", (function (e) {
            var code = e.keyCode || e.which;
            //Enter key code 13. Escape key code 27. Space button key code 32.
            if (code === 13 || code === 27 || code === 32) {
                 $.fn.closeFerantWindow();
             }
             //Tab key code 9.
            if (code === 9) {
                //Only focus on popover if we are tabbing FROM the close button, rather than tabbing TO.
                $(this).prev().focus(); //Focus on first index item in this Ferant window.
            }
            $.fn.giveSelectedFocusElementOutline($(this).prev(), true);
            $.fn.giveSelectedFocusElementOutline($(this), false);
            e.preventDefault(); //Prevent further actions.
         }));

         //Many screen readers turn key events into click events while active. Add a click event to each button as well.
         for (var x = 0; x < closeButtons.length; x++) {
             closeButtons[x].addEventListener("click", function() {
                 $.fn.closeFerantWindow();
             });
         }
     }

     //Add on-click content focus event to help icon for a page.
     $("[src='/images/help.gif']").parent().click(function () {
         selectedHelp = this;
         $.fn.giveSelectedFocusElementOutline($(closeButtons), false); //Give close button transparent border and border blur.
     });

     //Add onkeypress focus event if user is opening ferant help on page.
     $("[src='/images/help.gif']").parent().keydown(function () {
         selectedHelp = this;
         $.fn.giveSelectedFocusElementOutline($(closeButtons), false); //Give close button transparent border and border blur.
     });

     //Open Ferant help window and begin accessible tabbing.
     $.fn.showFerantWindow = function (el) {
        var index = el._889.replace("FerantDHTMLWindow", "");
        index = parseInt(index) - 1; //Parse numerical id value and subtract by one to get index.
        $(closeButtons).attr("aria-hidden", false);

        $("[id*='_753']").show(); //Show window expanders.
        $("[id*='_807']").attr("aria-hidden", false).show(); //Show window close button.
        $("[id*='_787']").show(); //Show window contents buttons.
        $("#_753").show();
        $("#_807").attr("aria-hidden", false).show();
        $("#_787").show();
        //Requires imperceptably short timeout to allow window to be visible before focusing on first tabindex element.
        setTimeout(function () {
            $.fn.giveSelectedFocusElementOutline($(ferantHelpWindows[index]), true);
            $(ferantHelpWindows[index]).focus();
        }, 10);
     }

     //Close opened Ferant help window.
     $.fn.closeFerantWindow = function () {
         //Make close buttons no longer part of tab order when the help is hidden.
         $(closeButtons).attr("aria-hidden", true).css("display", "none");
         $.fn.giveSelectedFocusElementOutline($(closeButtons), false); //Remove focus css from close buttons.

         //Find index of Ferant window, and return focus to same index of help icons.
         var helpIcons = $("[src='/images/help.gif']");
         for (var x = 0; x < helpIcons.length; x++) {
             //Compare nodes for equality.
             if ($(selectedHelp)[0] === $(helpIcons[x]).parent()[0]) {
                 $(selectedHelp).focus(); //Return focus to anchor tag of element that opened help window.
                 break;
             }
         }

         //Ferant window does not launch default onClick events for close button when using click event, so hide each parent tag associated with ferant help window.
         $("[id*='_753']").hide(); //Show window expanders.
         $("[id*='_807']").attr("aria-hidden", true).hide(); //Show window close button.
         $("[id*='_787']").hide(); //Show window contents buttons.
         $("#_753").hide();
         $("#_807").attr("aria-hidden", true).hide();
         $("#_787").hide();
     }

     //Add focus blurred outline to currently selected elements. The close icon does not have a visible focus blur on its own, making accessibility iffy.
     $.fn.giveSelectedFocusElementOutline = function (el, addCss) {
         if (addCss) {
             el.css("outline", "none");
             el.css("border", "2px solid #e6e6e6");
             el.css("box-shadow", "0 0 10px #e6e6e6");
         } else {
             el.css("border", "2px solid transparent");
             el.css("box-shadow", "0 0 10px transparent");
         }
     }

 });