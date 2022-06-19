(function (iconBar) {

	iconBar.showNewWebmailIcon = iconBar.prototype.showNewWebmailIcon = function () {
		setWebMailIconClass("animated");
	};

	iconBar.showRegularWebmailIcon = iconBar.prototype.showRegularWebmailIcon = function () {
		setWebMailIconClass("");
	};

	iconBar.showNewAnnouncementOrRequiredAlert = iconBar.prototype.showNewAnnouncementOrRequiredAlert = function () {
		if (window.newAnnouncementOrRequiredAlert == null) {
			var params = {
				StatusBarText: 'Message Alert&nbsp;',
				TitleBarText: 'New Messages',
				Width: 300,
				Height: 100,
				ContentHTML: 'You have <a href="/communication/webmail">new announcements or messages</a> that require reading.',
				Id: 'newAnnouncementOrRequiredAlert'
			};
			window.newAnnouncementOrRequiredAlert = new FerantDHTMLWindow(params);
		}
		window.newAnnouncementOrRequiredAlert.OpenWindow();
	};

	function setWebMailIconClass(className) {
		if (document.getElementById("regularHeader_webmailLink"))
			document.getElementById("regularHeader_webmailLink").className = className;
	}

})(window.IconBar || (window.IconBar = function () { }));