import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControllerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String R = "", X = "", Y = "";

        R = request.getParameter("R");
        X = request.getParameter("X");
        Y = request.getParameter("Y");

        if(R != null && Y != null && X != null) {
            request.setAttribute("R",R);
            request.setAttribute("X",X);
            request.setAttribute("Y",Y);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/area");
            rd.forward(request,response);
        } else {
            response.sendRedirect("/Point/web");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
