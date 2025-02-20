<%-- 
    Document   : dashboard
    Created on : 8 gru 2024, 12:57:46
    Author     : matik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
    <h1>Welcome, ${sessionScope.userName}!</h1>
    <a href="authors.jsp">Manage Authors</a><br>
    <a href="books.jsp">Manage Books</a>
    
    <form action="viewDatabase" method="get">
        <h3>View Database</h3>
        <button type="submit">View All Records</button>
    </form>
</body>
</html>
