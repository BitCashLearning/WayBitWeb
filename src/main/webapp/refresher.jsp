<%--
  Created by IntelliJ IDEA.
  User: tymourelessawy
  Date: 2024-06-25
  Time: 3:12 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="us.bitcash.apps.waybitweb.domain.MenuItem" %>
<%@ page import="java.util.List" %>

<% List<MenuItem> items = (List<MenuItem>) request.getAttribute("items"); %>
<html>
<body>
<h1>Aggregation of prices:</h1>
<% for (MenuItem item : items) {%>
<li><%=item%></li>
<%}%>
</body>
</html>
