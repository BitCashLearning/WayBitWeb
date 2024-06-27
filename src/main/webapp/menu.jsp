<%@ page import = "us.bitcash.apps.waybitweb.domain.MenuItem" %>
<%@ page import = "java.util.List" %>

<html>
    <body>
        <jsp:include page="/header.jsp" />
        <%
        List<MenuItem> menuItems = (List<MenuItem>) request.getAttribute("menuItems");
            for (MenuItem item : menuItems) {
        %>
        <li><%=item%></li>
        <%
        }
        %>
        <jsp:include page="/footer.jsp" />
    </body>
</html>