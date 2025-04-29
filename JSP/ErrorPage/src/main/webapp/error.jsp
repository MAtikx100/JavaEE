<%-- 
    Document   : error
    Created on : 29 kwi 2025, 10:57:08
    Author     : mysza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            session.setAttribute("error", true);
        %>
        <a href="/ErrorPage/index.jsp">Przejdz na 1 strone </a>
    </body>
</html>
