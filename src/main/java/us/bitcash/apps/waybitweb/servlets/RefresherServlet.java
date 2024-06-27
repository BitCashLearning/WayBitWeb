package us.bitcash.apps.waybitweb.servlets;

import us.bitcash.apps.waybitweb.data.MenuDataService;
import us.bitcash.apps.waybitweb.domain.MenuItem;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/refresher.html")
public class RefresherServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        MenuDataService dataService = new MenuDataService();
        Integer maxPrice = Integer.valueOf(req.getParameter("maxPrice"));

        List<MenuItem> items = dataService.findBy(p -> p.getPrice()<=maxPrice);

        req.setAttribute("items",items);

        ServletContext context = req.getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/refresher.jsp");

        /*
        What's happening here is that the req/res objects are being internally moved to another section of the
        webserver. The web server is doing this completely internally without the client seeing
        a difference. it is sending it as if they went to the servlet endpoint not the other.
         */
        dispatch.forward(req,res);


    }
}
