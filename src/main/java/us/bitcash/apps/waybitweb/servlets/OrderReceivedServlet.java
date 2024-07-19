package us.bitcash.apps.waybitweb.servlets;

import org.apache.commons.lang3.math.NumberUtils;
import us.bitcash.apps.waybitweb.data.WaybitDAO;
import us.bitcash.apps.waybitweb.data.WaybitDAOFactory;
import us.bitcash.apps.waybitweb.domain.Waybitmoji;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet("/orderReceived.html")
public class OrderReceivedServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        WaybitDAO waybitDAO = WaybitDAOFactory.getWaybitDAO();
        ArrayList<Waybitmoji> cart = new ArrayList<>();
        Iterator<String> params = request.getParameterNames().asIterator();

        double price = 0.00;
        while (params.hasNext()) {
            String param = params.next();
            String value = request.getParameter(param);

            Optional<Waybitmoji> wbeOptional = waybitDAO.findById(param);

            if (wbeOptional.isEmpty()) continue;
            Waybitmoji wbe = wbeOptional.get();

            int quantity = NumberUtils.isParsable(value) ? Integer.parseInt(value) : 0;
            price += wbe.getPrice()*quantity;

            cart.add(wbe);

//            System.out.println(param+" : " + "price updated to " + price);
        }

        HttpSession session = request.getSession();
        session.setAttribute("total",price);
        session.setAttribute("cart",cart);

        response.sendRedirect("/thankYou.html");
    }
}
