function setAudioSupportVariables() {
    var audio = document.createElement('audio');
    var audioMpeg = !!(audio.canPlayType && audio.canPlayType('audio/mpeg;').replace(/no/, ''));
    var audioOgg = !!(audio.canPlayType && audio.canPlayType('audio/ogg; codecs="vorbis"').replace(/no/, ''));
    var audioWav = !!(audio.canPlayType && audio.canPlayType('audio/wav; codecs="1"').replace(/no/, ''));

    ((typeof jQueryLatestVersion == "undefined" || jQueryLatestVersion == null) ? $ : jQueryLatestVersion).ajax({
        url: document.URL.substring(0, document.URL.indexOf('?') > -1 ? document.URL.indexOf('?') : document.URL.length).replace(location.hash, '') + "/sendAudioCapability",
        type: "POST",
        async: false,
        contentType: "application/json",
        dataType: "json",
        data: "{'audioMpegAbility' : " + audioMpeg + ", 'audioOggAbility' : " + audioOgg + ", 'audioWavAbility' : " + audioWav + "}",
        success: function (data) {
            // we want to wait to recieve the response but we don't do anything with it
            var response = data;
        }
    });
}