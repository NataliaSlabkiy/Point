/**
 * Created by Natalia on 19.04.2014.
 */
var c, r, currentRad;

window.onload = function() {
    c = document.getElementById("area");
    r = document.getElementsByName("R");
    r.value = 2;

    redraw();

    c.addEventListener("mousedown", function(evt) {
        var pos = getMousePos(c, evt);
        var originalXPercent = Math.round(pos.x / c.width * 100);
        var originalYPercent = Math.round(pos.y / c.height * 100);
        var finalX = currentRad / 10 * (originalXPercent - 50) * 0.3;
        var finalY = currentRad / 10 * (50 - originalYPercent) * 0.3;
        finalY = Math.round(finalY * 10) / 10;
        document.getElementsByName("Y").value = finalY;

        var elements = document.getElementsByClassName('xbut');

        alert("Actual X value is " + Math.round(finalX * 10) / 10 + "\nRounded to " + Math.round(finalX));
        for (var i = 0; i < elements.length; i++)
            if (elements[i].value == Math.round(finalX))
                setPushed(elements[i]);
    }, false);
};

function drawGraph(){
    var ctx = c.getContext("2d");
    ctx.clearRect(0, 0, c.width, c.height);

    //rectangle
    ctx.fillStyle = "#8470FF";
    ctx.beginPath();
    ctx.fillRect (c.width/2, c.height/3, c.width/3, c.height/6);
    ctx.closePath();
    ctx.fill();

    //sector of circle
    ctx.fillStyle = "#66CDAA";
    ctx.beginPath();
    ctx.moveTo(c.width/2, c.height/2);
    ctx.lineTo(5*c.width/6, c.height/2);
    ctx.quadraticCurveTo(5*c.width/6,5*c.height/6,c.width/2, 5*c.height/6);
    ctx.lineTo(c.width/2, c.height/2);
    ctx.closePath();
    ctx.fill();

    //triangle
    ctx.fillStyle = "#F08080";
    ctx.beginPath();
    ctx.moveTo(c.width/3, c.height/2);
    ctx.lineTo(c.width/2, c.height/6);
    ctx.lineTo(c.width/2, c.height/2);
    ctx.lineTo(c.width/3, c.height/2);
    ctx.closePath();
    ctx.fill();

    //axes
    ctx.strokeStyle = "#000000";
    ctx.beginPath();
    ctx.moveTo(c.width/2, 0);
    ctx.lineTo(c.width/2, c.height);
    ctx.moveTo(0, c.height/2);
    ctx.lineTo(c.width, c.height/2);
    ctx.closePath();
    ctx.stroke();

    ctx.beginPath();
    for (var i = 1; i <= 5; i++)
    {
        if (i === 3) continue;
        ctx.moveTo(i * c.width/6, c.height/2 - 5);
        ctx.lineTo(i * c.width/6, c.height/2 + 5);
        ctx.moveTo(c.width/2 - 5, i * c.height/6);
        ctx.lineTo(c.width/2 + 5, i * c.height/6);
    }
    ctx.closePath();
    ctx.stroke();
}

function setRadius(value){
    var ctx = c.getContext("2d");

    ctx.fillStyle = "#000000";
    ctx.font = "12pt Arial";

    ctx.fillText(-value, c.width/6 - 10, c.height/2 - 10);
    ctx.fillText(-value/2, c.width/3 - 10, c.height/2 - 10);
    ctx.fillText(value/2, 2 * c.width/3 - 10, c.height/2 - 10);
    ctx.fillText(value, 5 * c.width/6 - 10, c.height/2 - 10);

    ctx.fillText(value, c.width/2 + 10, c.height/6 + 5);
    ctx.fillText(value/2, c.width/2 + 10, c.height/3 + 5);
    ctx.fillText(-value/2, c.width/2 + 10, 2 * c.height/3 + 5);
    ctx.fillText(-value, c.width/2 + 10, 5 * c.height/6 + 5);
}

function redraw(){
    currentRad = r.value;
    drawGraph();
    setRadius(currentRad);
}

function getMousePos(canvas, evt) {
    var rect = canvas.getBoundingClientRect();
    return {
        x: evt.clientX - rect.left,
        y: evt.clientY - rect.top
    };
}

