<%--
  Created by IntelliJ IDEA.
  User: tymourelessawy
  Date: 2024-07-10
  Time: 6:07 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="us.bitcash.apps.waybitweb.domain.Waybitmoji" %>

<html>
<head>
    <title>Waybit: Web Edition</title>
</head>
<body>

<h1>Choose items to add to cart:</h1>

<%
    ArrayList<Waybitmoji> list = (ArrayList<Waybitmoji>) request.getAttribute("list");
%>

<form action="/thankYou.html" method="POST">

    <%
        for (Waybitmoji e : list) {
    %>

    <li>
        <label for="<%="item_"+e.getUuid()%>"> <%=e.getName() + " : " + e.getPrice()%></label><br>
        <input type="text" id="<%="item_"+e.getUuid()%>" name="<%="item_"+e.getUuid()%>">
    </li>
    <%
        }
    %>

    <input type="submit" value="checkout">
</form>

</body>
</html>
