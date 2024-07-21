package us.bitcash.apps.waybitweb.servlets.admin;

import org.apache.commons.lang3.math.NumberUtils;
import us.bitcash.apps.waybitweb.data.WaybitDAO;
import us.bitcash.apps.waybitweb.data.WaybitDAOFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/admin/waybitmojiCreated.html")
public class WaybitmojiCreatedServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WaybitDAO dao = WaybitDAOFactory.getWaybitDAO();
        String name = request.getParameter("name");
        String price = request.getParameter("price");

        if (name.isEmpty() || !NumberUtils.isParsable(price)) {
            //do things
            System.err.println("Fuck you for making things difficult");
            return;
        }

        dao.createWaybitmoji(name,Double.parseDouble(price));

        ServletContext context = request.getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/admin/waybitmojiCreated.jsp");
        dispatch.forward(request,response);
    }
}
