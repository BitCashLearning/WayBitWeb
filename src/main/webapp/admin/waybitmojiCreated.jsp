<%--
  Created by IntelliJ IDEA.
  User: tymourelessawy
  Date: 2024-07-21
  Time: 9:14 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Waybit: Web Edition -- Admin Panel</h1>
<h3>waybitmoji created successfully:</h3>
<h2>name:</h2>
<h4><%=request.getParameter("name")%></h4>
<h2>price:</h2>
<h4><%=request.getParameter("price")%></h4>
</body>
</html>
