<%--
  Created by IntelliJ IDEA.
  User: tymourelessawy
  Date: 2024-07-10
  Time: 12:31 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="us.bitcash.apps.waybitweb.domain.Waybitmoji"%>
<html>
<head>
    <title>Waybit: Web Edition</title>
</head>
<body>

<h1>Results:</h1>

<%
    ArrayList<Waybitmoji> list = (ArrayList<Waybitmoji>) request.getAttribute("searchResults");

    for (Waybitmoji w : list) {
%>

<li><%=w.getName()%></li>

<%
    }
%>

</body>
</html>
