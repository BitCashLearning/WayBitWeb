package us.bitcash.apps.waybitweb.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/refresher.html")
public class PriceRestrictionLoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String param = request.getParameter("maxPrice");
        System.out.println("User selected a max price of: " + param);

        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
