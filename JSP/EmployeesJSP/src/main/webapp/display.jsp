<%-- 
    Document   : display
    Created on : 20 lut 2025, 16:16:37
    Author     : mysza
--%>

<%@page import="javaee.employeesjsp.Person"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% ArrayList<Person> lista; %>
        <% if ((ArrayList) session.getAttribute("lista") != null) {%>
        <% lista = (ArrayList) session.getAttribute("lista"); %>
        <%} else { %>
        <% lista = new ArrayList(); %>
        <% } %>
        
        <% for (Person p : lista){ %>
            <%=p.name%>
            <%=p.surname%>
            <%=p.address%>    
            <br>
        <% } %>
        <br>
        <a href="index.jsp">dupa</a>
    </body>
</html>
