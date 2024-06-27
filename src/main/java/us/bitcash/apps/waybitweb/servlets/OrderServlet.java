package us.bitcash.apps.waybitweb.servlets;

import us.bitcash.apps.waybitweb.data.MenuDataService;
import us.bitcash.apps.waybitweb.domain.MenuItem;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/order.html")
@ServletSecurity(@HttpConstraint(rolesAllowed = {"user"}))
public class OrderServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        MenuDataService dataService = new MenuDataService();
        List<MenuItem> menuItems = dataService.getFullMenu();
        
        request.setAttribute("menuItems", menuItems);
        
        ServletContext context = this.getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/order.jsp");
        
        dispatch.forward(request, response);

    }
}
