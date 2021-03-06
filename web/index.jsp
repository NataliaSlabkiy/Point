<%@ page import="java.util.*" %>
<%@ page import="Data.ResultData" %>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>WebForm</title>
    <link rel="stylesheet" type="text/css" href="dop/base.css"/>
   <script type="text/javascript" src="dop/area.js"></script>
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
                <input type="radio" name="R" value="1.5"> 1,5<br>
                <input type="radio" name="R" value="2" checked="true"> 2<br>
                <input type="radio" name="R" value="2.5"> 2,5<br>
                <input type="radio" name="R" value="3"> 3<br>
            </div>            
        </div>
        <div id="Y" class="item">
			<label class="small_header">Y: </label>		
            <div id="Y_input">
                <input type="text" id="Yy" name="Y" class="input"/>
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
            <input type="submit" id="btn" value="Check" class="input">
        </div>
    </form>
</div>
<canvas id="area"></canvas>
<div class="results">

    <%
        ArrayList<ResultData> res = (ArrayList<ResultData>)application.getAttribute("result");
        out.print("<table> <caption class=\"small_header\">Results</caption><tr>"+
                    "<td>X</td>"+
                    "<td>Y</td>"+
                    "<td>R</td>"+
                    "<td>Area</td>"+
                    "</tr>"
        );
        for (int i = 1; i < res.size(); i++){
        out.print("<tr><td>"
                + res.get(i).getX() +
                "</td><td>" +
                res.get(i).getY() +
                "</td><td>" +
                res.get(i).getR() +
                "</td><td>" +
                res.get(i).getArea() +
                "</td></tr>");}
        out.print("</table>");
    %>
</div>

</body>
</html>