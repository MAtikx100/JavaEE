<%-- 
    Document   : index
    Created on : 29 kwi 2025, 10:46:55
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
        <% boolean err;
           if (session.getAttribute("error") != null){
                err = (boolean) session.getAttribute("error");
            } else {
                err = false;
            }
           if (!err){
                response.sendRedirect("/ErrorPage/second.jsp");
            } else {
            %> <h1>Zrobiłeś błąd</h1> <%
            }
        %>
    </body>
</html>
