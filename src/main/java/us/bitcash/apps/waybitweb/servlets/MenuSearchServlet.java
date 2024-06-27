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

@WebServlet("/searchResults.html")
public class MenuSearchServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        MenuDataService dataService = new MenuDataService();
        String searchTerm = request.getParameter("searchTerm");
        List<MenuItem> menuItems = dataService.find(searchTerm);

        request.setAttribute("menuItems",menuItems);

        //part of the servlet standard
        //its a way to tell our webserver (tomcat) to do something. We can tell tomcat to forward to another servlet
        // or to another jsp page
        ServletContext context = this.getServletContext();
        //handle on the idea of forwarding results to the search page
        RequestDispatcher dispatcher = context.getRequestDispatcher("/searchResults.jsp");
        dispatcher.forward(request,response);



    }
}
