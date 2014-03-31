import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.Math;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Formatter;

public class AreaCheckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int rad = 4, xi = 1, yi = 1;
        String res; // Исправить математику для картинки
        if (yi == 0 && xi > 0 && xi < rad/2){
            res = "OX";
        } else if (xi == 0 && yi > 0 && yi < rad/2){
            res = "OY";
        } else if (xi  > 0 && xi < rad  && yi  > 0 && yi  < rad){
            res = "Rectangle";
        } else if(xi > 0 && yi < 0 && Math.sqrt(Math.pow(xi, 2) + Math.pow(yi, 2)) < rad){
            res = "Circle";
        } else if (yi > 0 && xi < 0 && xi >= (((rad*xi)/rad) - rad)) {
            res = "Triangle";
        } else {
            res = "None";
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
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
                            "<label><a href=\"/Point/web\">BAAACK</a></label>"+
                        "</body>"+
                    "</html>"
        );
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
