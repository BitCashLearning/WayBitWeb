package us.bitcash.apps.waybitweb.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MenuSearchCorrectionRequestWrapper extends HttpServletRequestWrapper {
    public MenuSearchCorrectionRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    private String newSearchTerm;

    public void setNewSearchTerm(String newSearchTerm) {
        this.newSearchTerm = newSearchTerm;
    }

    @Override
    public String getParameter(String key) {
        if (key.equalsIgnoreCase("searchTerm")) {
            return newSearchTerm;
        } else {
            return super.getParameter(key);
        }
    }
}
