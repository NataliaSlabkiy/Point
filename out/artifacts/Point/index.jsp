<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>WebForm</title>
    <link rel="stylesheet" type="text/css" href="dop/base.css"/>
    <script type="text/javascript" src="dop/area.js"></script>
    <script type="text/javascript">
        function validRad(tempR) {
            if (tempR == ""||isNaN(tempR)|| tempR > 3 || tempR < -3 || parseInt(tempR)!= tempR) {
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
        Variant #10032<br>
        students from #2100<br>
        Natalia & Ekaterina<br>
    </div>

</header>
<div class="form">
    <form action="/Point/controller" method="POST" id="form">
        <div id="R" class="item">
			<label class="small_header">R:</label>
            <div id="R_input">
                <input type="radio" name="R" value="1"> 1<br>
                <input type="radio" name="R" value="1,5"> 1,5<br>
                <input type="radio" name="R" value="2" checked="true"> 2<br>
                <input type="radio" name="R" value="2,5"> 2,5<br>
                <input type="radio" name="R" value="3"> 3<br>
            </div>            
        </div>
        <div id="Y" class="item">
			<label class="small_header">Y: </label>		
            <div id="Y_input">
                <input type="text" name="Y" onchange="validRad(this.value)" class="input"/>
                <span id="errorR" class="err">incorrectly</span>
            </div>
        </div>
		<div id="X" class="item">
		<label class="small_header">X: </label>
            <div class="input">                
                <select name="X" id="X_input">
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
        <div >
            <input type="submit" id="btn" disabled value="Submit" class="input">
        </div>
    </form>
</div>

    <canvas id="area">Canvas does not supported!</canvas>

</body>
</html>