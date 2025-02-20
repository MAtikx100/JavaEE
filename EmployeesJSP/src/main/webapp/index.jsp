<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% if ((ArrayList) session.getAttribute("lista") != null) {%>
        <% ArrayList lista = (ArrayList) session.getAttribute("lista"); %>
        <%} else { %>
        <% ArrayList lista = new ArrayList(); %>
        <% } %>
        <form action="AddServlet" method="post">
        <label>Enter name:</label>
        <input type="text" name="name" required>
        <br>
        <label>Enter surname:</label>
        <input type="text" name="surname" required>
        <label>Enter address:</label>
        <input type="text" name="address" required>
        <br>
        <input type="submit" value="Add">
    </form>
    </body>
</html>
