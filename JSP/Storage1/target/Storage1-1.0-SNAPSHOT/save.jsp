<%-- 
    Document   : save
    Created on : 15 mar 2025, 15:25:22
    Author     : mysza
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList" %>

<%
    List<String> saved = (List<String>) session.getAttribute("savedTexts");
    if (saved == null){
        saved = new ArrayList<>();
        session.setAttribute("savedTexts", saved);
    }
    String newText = request.getParameter("text");
    if (newText != null && !newText.trim().isEmpty()){
        saved.add(newText);
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Enter Text to Save</h1>
        <form method="post">
            <input type="text" name="text" required>
            <button type="submit">Save</button>
        </form>
        <a href="display.jsp"><button>Go to Display Page</button></a>
    </body>
</html>
