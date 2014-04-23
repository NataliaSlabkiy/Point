import Data.ResultData;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.Math;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
import javax.servlet.RequestDispatcher;


public class AreaCheckServlet extends HttpServlet {
    public static ArrayList<ResultData> resu;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int xi, yi;
        float rad;
        String res;
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        ResultData resTemp = new ResultData();
        if (resu == null) resu = new ArrayList<ResultData>(10);

        rad = Float.parseFloat(request.getParameter("R"));
        xi = Integer.parseInt(request.getParameter("X"));
        yi = Integer.parseInt(request.getParameter("Y"));

        if (yi == 0){
            res = "OX";
        } else if (xi == 0){
            res = "OY";
        } else if (xi  > 0 && xi < rad  && yi  > 0 && yi  < rad/2){
            res = "Rectangle";
        } else if(xi > 0 && yi < 0 && Math.sqrt(Math.pow(xi, 2) + Math.pow(yi, 2)) < rad){
            res = "Circle";
        } else if (yi > 0 && xi < 0 && xi >= (((rad*xi)/rad) - rad)) {
            res = "Triangle";
        } else {
            res = "None";
        }

        resTemp.setArea(res);
        resTemp.setR(rad);
        resTemp.setX(xi);
        resTemp.setY(yi);
        resu.add(resTemp);
        ServletContext context = getServletContext();
        context.setAttribute("result",resu);
        out.println("<html>"+
                        "<head>"+
                            "<title>Results</title>"+
                        "</head>"+
                        "<body>"+
                            "<table>"+
                                "<tr><td>Var</td><td>Value</td></tr>"+
                                "<tr><td>R</td><td>" + rad + "</td></tr>"+
                                "<tr><td>X</td><td>" + xi + "</td></tr>"+
                                "<tr><td>Y</td><td>" + yi + "</td></tr>"+
                                "<tr><td>Result</td><td>" + res + "</td></tr>"+
                            "</table>"+
                            "<label><a href=\"/Point\">Return back</a></label>"+
                        "</body>"+
                    "</html>"
        );
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
