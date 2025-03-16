<%-- 
    Document   : display
    Created on : 15 mar 2025, 15:31:58
    Author     : mysza
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%
  List<String> saved = (List<String>)session.getAttribute("savedTexts");
%>    

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Saved Data</h1>
        <ul>
            <%
                if (saved != null && !saved.isEmpty()) {
                    for (String text : saved) {
            %>
                        <li><%= text %></li>
            <%
                    }
                } else {
            %>
                    <p>No data saved yet.</p>
            <%
                }
            %>
        </ul>
        <a href="save.jsp"><button>Back to Save Page</button></a>
    </body>
</html>
