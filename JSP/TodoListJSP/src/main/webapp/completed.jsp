<%-- 
    Document   : completed
    Created on : 16 mar 2025, 14:21:21
    Author     : mysza
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<String> completed = (List<String>) session.getAttribute("completed");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <ul>
            <%
                if (completed != null && !completed.isEmpty()){
            %>
                <% for (String t : completed){ %>
                <li>
                    <%= t %>
                    <a href="todo.jsp?remove=<%=t%>"><button>Undo</button>
                </li>
                <% } 
                }else{
                %>
                <p>No tasks</p>
                <%}%>
        </ul>
        <a href="todo.jsp"><button>Show Completed</button></a>

    </body>
</html>
