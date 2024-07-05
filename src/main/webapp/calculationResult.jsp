<%--
  Created by IntelliJ IDEA.
  User: tymourelessawy
  Date: 2024-07-05
  Time: 5:58 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>

<html>
<head>
    <title>Waybit: Web Edition</title>
</head>
<body>

<h1>Your results:</h1>
<h3><%=request.getAttribute("result")%></h3>

</body>
</html>
