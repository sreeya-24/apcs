(function () {
    var ID = "UA-91683340-13";
	var ga = document.createElement('script');
	ga.type = 'text/javascript';
	ga.async = true;
	ga.src = 'https://www.googletagmanager.com/gtag/js?id=' + ID;
	var s = document.getElementsByTagName('script')[0];
	s.parentNode.insertBefore(ga, s);

    var ga2 = document.createElement('script');
    ga2.type = 'text/javascript';
    ga2.innerText =
        "window.dataLayer = window.dataLayer || [];" +
        "function gtag() { dataLayer.push(arguments); } " +
        "gtag('js', new Date()); " +
        "gtag('config', '" + ID + "', {'page_title': 'Connexus'});";

    s.parentNode.insertBefore(ga2, s);
})();