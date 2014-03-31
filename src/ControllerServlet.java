import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Formatter;

public class ControllerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*int num=1;

        if(num%2==0){
            response.sendRedirect("/Point/web");
            num++;
        }else{
            response.sendRedirect("/Point/area");
        }*/
        PrintWriter out = response.getWriter();


        String R = "", X = "", Y = "";
        Enumeration paramNames = request.getParameterNames();


        if(paramNames != null) {
            String paramName = (String) paramNames.nextElement();
            if (paramName.equals("R")) {
                String[] paramValues = request.getParameterValues(paramName);
                if (paramValues != null) {
                    if (paramValues.length > 0) R = paramValues[0];
                }
            }
            if (paramName.equals("Y")) {
                String[] paramValues = request.getParameterValues(paramName);
                if (paramValues != null) {
                    if (paramValues.length > 0) Y = paramValues[0];
                }
            }
            if (paramName.equals("X")) {
                String[] paramValues = request.getParameterValues(paramName);
                if (paramValues != null) {
                    if (paramValues.length > 0) X = paramValues[0];
                }
            }
        }else{
            out.println("Nothing");
        }

        out.println(R.toString());
        out.println(X.toString());
        out.println(Y.toString());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
