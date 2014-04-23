/**
 * Created by Natalia on 23.04.2014.
 */
import Data.ResultData;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import java.util.ArrayList;

public class ContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent evt){
        ServletContext cont = evt.getServletContext();
        ArrayList<ResultData> res = new ArrayList<ResultData>();
        ResultData rd = new ResultData();
        res.add(rd);
        cont.setAttribute("result", res);
        System.out.println("Initialized");
    }
    public void contextDestroyed(ServletContextEvent e){
        System.out.println("Destroyed");
    }
}



