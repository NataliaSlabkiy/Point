import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Formatter;

/**
 * Created by Natalia on 21.03.14.
 */
public class ControllerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String userName="";
        Enumeration paramNames = request.getParameterNames();
        if(paramNames != null){
            while (paramNames.hasMoreElements()){
                String paramName = (String) paramNames.nextElement();
                if (paramName.equals("userName")){
                    String[] paramValues = request.getParameterValues(paramName);
                    if(paramValues != null){
                        if(paramValues.length > 0) userName = paramValues[0];
                    }
                }
            }
        }

        userName = (userName.length() > 0) ? userName : "Anonymous";
        Formatter UserNameFormatter = new Formatter();
        String greetingString = "Hello, %s!";
        out.println(UserNameFormatter.format(greetingString,userName).toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
