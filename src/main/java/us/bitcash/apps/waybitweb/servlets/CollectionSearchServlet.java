package us.bitcash.apps.waybitweb.servlets;

import us.bitcash.apps.waybitweb.data.WaybitDAO;
import us.bitcash.apps.waybitweb.domain.Waybitmoji;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/searchResults.html")
public class CollectionSearchServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Optional<String> queryOptional = Optional.ofNullable(request.getParameter("searchTerm"));

        if (queryOptional.isEmpty()) {
            //do stuff
            System.err.println("Error");
            return;
        }

        WaybitDAO waybitDAO = new WaybitDAO();

        List<Waybitmoji> results = waybitDAO.findBy(
                p->p.getName().contains(queryOptional.get()));

        request.setAttribute("searchResults",results);

        ServletContext context = request.getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/searchResults.jsp");
        dispatch.forward(request,response);
    }
}
