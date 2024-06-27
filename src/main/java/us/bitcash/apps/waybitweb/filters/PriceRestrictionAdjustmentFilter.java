package us.bitcash.apps.waybitweb.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Comparator;

@WebFilter("/refresher.html")
public class PriceRestrictionAdjustmentFilter implements Filter {

    Comparator<Object> test;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        PriceCorrectionRequestWrapper requestWrapper = new PriceCorrectionRequestWrapper((HttpServletRequest) request);

        chain.doFilter(requestWrapper,response);

    }

    @Override
    public void destroy() {

    }
}
