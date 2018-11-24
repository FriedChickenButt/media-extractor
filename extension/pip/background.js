window.onload = function () { 

  var pipButton = document.createElement("button");
  var svg = document.createElement("svg");
  var path = document.createElement("path");
  path.setAttribute("d", "M19 11h-8v6h8v-6zm4 8V4.98C23 3.88 22.1 3 21 3H3c-1.1 0-2 .88-2 1.98V19c0 1.1.9 2 2 2h18c1.1 0 2-.9 2-2zm-2 .02H3V4.97h18v14.05z");

  svg.setAttribute("fill", "#ffffff");
  svg.setAttribute("height", "100%");
  svg.setAttribute("viewBox", "-6 -6 38 36");
  svg.setAttribute("width", "100%");

  pipButton.setAttribute("class", "ytp-subtitles-button ytp-button");
  pipButton.setAttribute("style", "");
  pipButton.setAttribute("id", "pipButton");
  pipButton.setAttribute("aria-pressed", "false");
  pipButton.setAttribute("title", "Picture in picture mode");

  svg.appendChild(path);
  pipButton.appendChild(svg);

  var rcontrol = document.getElementsByClassName("ytp-right-controls")[0];

  rcontrol.appendChild(pipButton);

  var video = document.getElementsByClassName('ytp-right-controls')[0];

  var content = video.innerHTML;
  video.innerHTML = content + "\n";

  console.log("reloaded");

  var pipButton = document.getElementById("pipButton");

  var curwindow = window;

  pipButton.addEventListener('click', function() {
    pip();
  });

  document.onkeypress = function (e) {
    e = e || window.event;
    if (e.keyCode == 112) {
      pip();
    }
  };  
};

function pip() {
  var video = document.getElementsByTagName('video')[0];
  if (!document.pictureInPictureElement) {
    video.requestPictureInPicture()
    .catch(error => {
      // Video failed to enter Picture-in-Picture mode.
    });
  } else {
    document.exitPictureInPicture()
    .catch(error => {
      // Video failed to leave Picture-in-Picture mode.
    });
  }

}