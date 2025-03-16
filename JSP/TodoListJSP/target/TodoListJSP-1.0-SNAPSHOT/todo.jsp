<%-- 
    Document   : todo
    Created on : 16 mar 2025, 14:21:16
    Author     : mysza
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List<String> tasks = (List<String>) session.getAttribute("tasks");
    if (tasks == null){
        tasks = new ArrayList<>();
        session.setAttribute("tasks", tasks);
    }
    List<String> completed = (List<String>) session.getAttribute("completed");
    if (completed == null){
        completed = new ArrayList<>();
        session.setAttribute("completed", completed);
    }
    String newTask = request.getParameter("task");
    if (newTask != null && !newTask.trim().isEmpty()){
        tasks.add(newTask);
    }
    
    String removeTask = request.getParameter("remove");
    if (removeTask != null && !removeTask.trim().isEmpty()){
        tasks.remove(removeTask);
        completed.add(removeTask);
    }  

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post">
            <input type="text" name="task" required>
            <button type="submit">Add</button>
        </form>
        <ul>
            <% for (String t : tasks){ %>
            <li>
                <%= t %>
                <a href="todo.jsp?remove=<%=t%>"><button>Complete</button></a>
            </li>
            <% } %>
        </ul>
        <a href="completed.jsp"><button>Show Completed</button></a>
    </body>
</html>
