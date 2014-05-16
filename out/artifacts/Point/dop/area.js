/**
 * Created by Natalia on 19.04.2014.
 */
var c, r, currentRad;

function getMousePos(canvas, evt) {
    var rect = canvas.getBoundingClientRect();
    return {
        x: evt.clientX - rect.left,
        y: evt.clientY - rect.top
    };
}

window.onload = function() {
    c = document.getElementById("area");
    r = document.getElementsByName("R");
    txtY = document.getElementById("Yy");
    butn = document.getElementById('btn');
    redraw(2);

    c.addEventListener("mousedown", function(evt) {
        var pos = getMousePos(c, evt);
        var xx=(pos.x-165)/(110/currentRad);
        var yy=-(pos.y-165)/(110/currentRad);
        document.getElementById("Yy").value = Math.round(yy);
        document.getElementById("X_input").value = Math.round(xx);
    }, false);

    for (var i = 0; i < r.length; ++ i) {
        r[i].onchange = function(e){
            redraw(e.target.value);
        };
    }

    butn.onmouseover = function (e) {
            var tempR = document.getElementById("Yy").value;
            if (tempR == ""||isNaN(tempR)|| tempR > 3 || tempR < -3 || parseInt(tempR) != tempR) {
                document.getElementById('errorR').style.display = "inline";
                alert("error");
            } else {
                document.getElementById('errorR').style.display = "none";
            }
        };

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

function setRadius(radi){
    var ctx = c.getContext("2d");

    ctx.fillStyle = "#000000";
    ctx.font = "12pt Arial";

    ctx.fillText(-radi, c.width/6 - 10, c.height/2 - 10);
    ctx.fillText(-radi/2, c.width/3 - 10, c.height/2 - 10);
    ctx.fillText(radi/2, 2 * c.width/3 - 10, c.height/2 - 10);
    ctx.fillText(radi, 5 * c.width/6 - 10, c.height/2 - 10);

    ctx.fillText(radi, c.width/2 + 10, c.height/6 + 5);
    ctx.fillText(radi/2, c.width/2 + 10, c.height/3 + 5);
    ctx.fillText(-radi/2, c.width/2 + 10, 2 * c.height/3 + 5);
    ctx.fillText(-radi, c.width/2 + 10, 5 * c.height/6 + 5);
}

function redraw(currRad){
    currentRad=currRad;
    drawGraph();
    setRadius(parseFloat(currRad));
}



