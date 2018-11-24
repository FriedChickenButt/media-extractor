class YTResult {
    constructor(width, height, type, format, link) {
        this.width = width;
        this.height = height;
        this.type = type;
        this.format = format;
        this.link = link;
    }

    getData() {
        var str = "{" + this.width + ", " + this.height + ", " + this.type + ", " + this.format + ", " + this.link + "}";
        return str;
    }
}

window.onload = function () { 
    // Download current webpage
    var htmlpage = document.getElementById("player-wrap").innerHTML;
    //

    // Adjusting the string for <script></script>
    var script = htmlpage.substring(htmlpage.indexOf("<script>") + 8, );
    script = script.substring(script.indexOf("<script>") + 8, );
    script = script.substring(0, script.indexOf("</script>"));
    //

    // Removing new lines
    script.replace(/\r?\n|\r/, "");
    //

    // Decoding html encoding
    script = decodeURIComponent(script);
    //

    script = script.replace(/\\u0026/g,"&");
    script = script.replace(/\\/g, '');

    // Array to store YTResult objects
    var ytResults = [];
    //

    // // Extracting the video/audio/thumbnail details
    // for(var i = script.indexOf("\"url\":\""); i > 0; i = script.indexOf("\"url\":\"", i + 1)) {
    //     if(script.charAt(i + 7) != 'h') // Elimiating non-urls
    //         continue;
    //     var widthIndex = script.indexOf("\"width\"", i) + 8;
    //     var heightIndex = script.indexOf("\"height\"", i) + 9;
    //     var heightEndIndex = Math.min(script.indexOf('\"', heightIndex) - 1 , script.indexOf('}', heightIndex));
    //     var typeIndex = script.indexOf("mime=", i) + 5;
    //     var typeEndIndex = script.indexOf("/", typeIndex);
    //     var formatIndex = typeEndIndex + 1;
    //     var formatEndIndex = script.indexOf("&", formatIndex);

    //     var width = parseInt(script.substring(widthIndex, script.indexOf('\"', widthIndex) - 1));
    //     var height = parseInt(script.substring(heightIndex, heightEndIndex));
    //     var type = script.substring(typeIndex, typeEndIndex);
    //     var format = script.substring(formatIndex, formatEndIndex);
    //     var link = script.substring(i + 7, script.indexOf('\"', i + 10));
    //     if(type.length > 5) {
    //         type = "thumbnail";
    //         format = "image";
    //     }

    //     // if(!link.includes("keepalive")) {
    //         var newResult = new YTResult(width, height, type, format, link);
    //         ytResults.push(newResult);
    //     // }
    // }
    // //   
    
    ytResults = urlify

    console.log(ytResults);

};