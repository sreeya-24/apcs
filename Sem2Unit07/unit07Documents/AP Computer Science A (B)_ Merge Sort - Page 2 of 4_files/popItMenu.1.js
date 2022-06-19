//Pop-it menu- By Dynamic Drive
//For full source code and more DHTML scripts, visit http://www.dynamicdrive.com
//This credit MUST stay intact for use
//Modified by your favorite Wallace to be smarter.

var linkset=new Object()
//SPECIFY MENU SETS AND THEIR LINKS. FOLLOW SYNTAX LAID OUT

////No need to edit beyond here

var ie4=document.all&&navigator.userAgent.indexOf("Opera")==-1
var ns6=document.getElementById&&!document.all

function showmenu(e, which) {
	showMenu(e, which, null, null);
}

function showmenu(e, which, xPos, yPos) {
	if (!document.all && !document.getElementById && !document.layers)
		return

	clearhidemenu()

	menuobj = ie4 ? document.all.popmenu : ns6 ? document.getElementById("popmenu") : ""
	menuobj.thestyle = (ie4||ns6) ? menuobj.style : menuobj
				
	if (ie4||ns6)
		menuobj.innerHTML = which


	menuobj.contentwidth = (ie4||ns6) ? menuobj.offsetWidth : menuobj.document.gui.document.width
	menuobj.contentheight = (ie4||ns6) ? menuobj.offsetHeight : menuobj.document.gui.document.height
		
	if (xPos == null) {
		// no fixed position was passed in, so use a "relative to the click event" position
	
		// find out where the click event occured
		eventX = ie4 ? event.clientX : ns6? e.clientX : e.x
		eventY = ie4 ? event.clientY : ns6? e.clientY : e.y

		//Find out how close the mouse is to the corner of the window
		var rightedge=ie4? document.body.clientWidth-eventX : window.innerWidth-eventX
		var bottomedge=ie4? document.body.clientHeight-eventY : window.innerHeight-eventY
		
		//if the horizontal distance isn't enough to accomodate the width of the context menu
		if (rightedge<menuobj.contentwidth)
			//move the horizontal position of the menu to the left by it's width
			menuobj.thestyle.left=(ie4? document.body.scrollLeft+eventX-menuobj.contentwidth : ns6? window.pageXOffset+eventX-menuobj.contentwidth : eventX-menuobj.contentwidth) + "px"
		else
			//position the horizontal position of the menu where the mouse was clicked
			menuobj.thestyle.left=(ie4? document.body.scrollLeft+eventX : ns6? window.pageXOffset+eventX : eventX) + "px"

		//same concept with the vertical position
		if (bottomedge<menuobj.contentheight)
			menuobj.thestyle.top=(ie4? document.body.scrollTop+eventY-menuobj.contentheight : ns6? window.pageYOffset+eventY-menuobj.contentheight : eventY-menuobj.contentheight) + "px"
		else
			menuobj.thestyle.top=(ie4? document.body.scrollTop+event.clientY : ns6? window.pageYOffset+eventY : eventY) + "px"

	} else {
		menuobj.thestyle.top=yPos;
		menuobj.thestyle.left=xPos;
	}
	
	menuobj.style.zIndex = 999;
	
	// Put an iFrame if we are using IE to handle rendering problems with dropdowns/divs.
	if (ie4) {
		var ieDivUnderlayFrame = document.getElementById('ieDivUnderlayFrame');	
		if (ieDivUnderlayFrame) {
			ieDivUnderlayFrame.style.left = menuobj.thestyle.left;
			ieDivUnderlayFrame.style.top = menuobj.thestyle.top;		
			ieDivUnderlayFrame.style.width = menuobj.contentwidth;
			ieDivUnderlayFrame.style.height = menuobj.contentheight;
			ieDivUnderlayFrame.style.display = "block";
			ieDivUnderlayFrame.style.visibility = "visible";
		}
	}	

	menuobj.thestyle.visibility="visible"
	return false
}

function contains_ns6(a, b) {
	//Determines if 1 element in contained in another- by Brainjar.com
	if (b != null) {
		while (b.parentNode)
			if ((b = b.parentNode) == a)
				return true;
	}

	return false;
}

function hidemenu(){
	if (window.menuobj) {
		menuobj.thestyle.visibility = (ie4||ns6)? "hidden" : "hide";
		if (ie4 && menuobj.document) {
			var ieDivUnderlayFrame = menuobj.document.getElementById('ieDivUnderlayFrame');
			if (ieDivUnderlayFrame) {
				ieDivUnderlayFrame.style.display = "none";
				ieDivUnderlayFrame.style.visibility = "hidden";
			}
		}
	}
}

function dynamichide(e){
if (ie4&&!menuobj.contains(e.toElement))
hidemenu()
else if (ns6&&e.currentTarget!= e.relatedTarget&& !contains_ns6(e.currentTarget, e.relatedTarget))
hidemenu()
}

function delayhidemenu(){
if (ie4||ns6)
delayhide=setTimeout("hidemenu()",500)
}

function clearhidemenu(){
if (window.delayhide)
clearTimeout(delayhide)
}

if (ie4||ns6)
document.onclick=hidemenu
