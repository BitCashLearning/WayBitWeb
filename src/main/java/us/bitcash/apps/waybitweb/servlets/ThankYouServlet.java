package us.bitcash.apps.waybitweb.servlets;

import us.bitcash.apps.waybitweb.domain.Waybitmoji;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Optional;

@WebServlet("/thankYou.html")
public class ThankYouServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        Map<String, String[]> itemsMap = request.getParameterMap();

        
    }
}
