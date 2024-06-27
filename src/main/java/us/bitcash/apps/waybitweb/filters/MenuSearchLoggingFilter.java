package us.bitcash.apps.waybitweb.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/searchResults.html")
public class MenuSearchLoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        String searchTerm = request.getParameter("searchTerm");

        System.out.println("User searched for : " + searchTerm);

        chain.doFilter(request,response);




    }

    @Override
    public void destroy() {}
}
