package us.bitcash.apps.waybitweb.servlets;

import us.bitcash.apps.waybitweb.data.WaybitUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet("/computeCalculation.html")
public class CalculatorServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WaybitUtils waybitUtils = new WaybitUtils();

        Optional<String> aOptional = Optional.ofNullable(request.getParameter("a"));
        Optional<String> bOptional = Optional.ofNullable(request.getParameter("b"));

        if (aOptional.isEmpty() || bOptional.isEmpty()) {
            System.out.println("Failure");
        };

        int a = Integer.parseInt(aOptional.orElseGet(()->"0"));
        int b = Integer.parseInt(bOptional.orElseGet(()->"0"));

        Integer result = waybitUtils.multiply(a,b);
        request.setAttribute("result",result);

        ServletContext context = request.getServletContext();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/calculationResult.jsp");
        dispatcher.forward(request,response);

    }
}
