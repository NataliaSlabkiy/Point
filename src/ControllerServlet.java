import Data.ResultData;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ControllerServlet extends HttpServlet {
    public static ArrayList<ResultData> resu;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String R = "", X = "", Y = "";
        if (resu == null) resu = new ArrayList<ResultData>(10);

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
            request.setAttribute("result",resu);
            RequestDispatcher v = request.getRequestDispatcher("/Point");
            v.forward(request,response);
            //response.sendRedirect("./index.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
