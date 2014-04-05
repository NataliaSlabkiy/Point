<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>WebForm</title>
    <link rel="stylesheet" type="text/css" href="dop/base.css"/>
    <link rel="stylesheet" type="text/JavaScript" href="dop/check.js"/>
    <script type="text/javascript">
        function validRad(tempR) {
            var resuR = 0;
            if (tempR == "") {
                resuR = 1;
            }
            if (isNaN(tempR)) {
                resuR = 1;
            }
            if (tempR > 5 || tempR < 0) {
                resuR = 1;
            }
            if (resuR == 1) {
                document.getElementById('errorR').style.display = "inline";
                document.getElementById('btn').setAttribute('disabled',true);
            } else {
                document.getElementById('errorR').style.display = "none";
                document.getElementById('btn').removeAttribute('disabled');
            }
        }
    </script>
</head>
<body>
<header>
    <div class="info">
        Variant #10030<br>
        students from #2100<br>
        Natalia & Ekaterina<br>
    </div>

</header>
<div class="form">
    <form action="/Point/controller" method="POST" id="form">
        <div id="R" class="item">
            <div class="input">
                <label>R: </label><input type="text" name="R" id="rad" onchange="validRad(this.value)"/>
                <span id="errorR" class="err">incorrectly</span>
            </div>
        </div>
        <div id="X" class="item">
            <div class="input">
                <label>X: </label>
                <select name="X">
                    <option value="-4">-4</option>
                    <option value="-3">-3</option>
                    <option value="-2">-2</option>
                    <option value="-1">-1</option>
                    <option selected="selected" value="0">0</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                </select>
            </div>
        </div>

        <div id="Y" class="item">
            <label>Y:</label>

            <div id="Y_input" class="input">
                <input type="radio" name="Y" value="-5"> -5<br>
                <input type="radio" name="Y" value="-4"> -4<br>
                <input type="radio" name="Y" value="-3"> -3<br>
                <input type="radio" name="Y" value="-2"> -2<br>
                <input type="radio" name="Y" value="-1"> -1<br>
                <input type="radio" name="Y" value="0" checked="true"> 0<br>
                <input type="radio" name="Y" value="1"> 1<br>
                <input type="radio" name="Y" value="2"> 2<br>
                <input type="radio" name="Y" value="3"> 3<br>
            </div>
        </div>

        <div class="item">
            <input type="submit" id="btn" disabled>
        </div>
    </form>
</div>
<div id="area">
</div>
</body>
</html>