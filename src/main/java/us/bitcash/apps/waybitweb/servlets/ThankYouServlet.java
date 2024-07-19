package us.bitcash.apps.waybitweb.servlets;

import us.bitcash.apps.waybitweb.data.WaybitDAO;
import us.bitcash.apps.waybitweb.data.WaybitDAOFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/thankYou.html")
public class ThankYouServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WaybitDAO waybitDAO = WaybitDAOFactory.getWaybitDAO();

        HttpSession session = request.getSession();

        request.setAttribute("total",session.getAttribute("total"));
        request.setAttribute("cart",session.getAttribute("cart"));

        ServletContext context = request.getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/thankYou.jsp");
        dispatch.forward(request,response);
    }
}
