package us.bitcash.apps.waybitweb.servlets;

import us.bitcash.apps.waybitweb.data.WaybitDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/order.html")
public class OrderServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WaybitDAO waybitDAO = new WaybitDAO();

        request.setAttribute("list",waybitDAO.getAll());

        ServletContext context = request.getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/order.jsp");
        dispatch.forward(request,response);

    }
}
