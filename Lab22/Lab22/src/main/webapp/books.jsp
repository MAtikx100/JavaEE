<%-- 
    Document   : books
    Created on : 8 gru 2024, 13:20:39
    Author     : matik
--%>

<%@page import="javaee.lab22.Author"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Book</title>
</head>
<body>
    <h1>Add Book</h1>

    <form action="books" method="POST">
        <label for="title">Book Title:</label>
        <input type="text" id="title" name="title" required />

        <label for="author">Author:</label>
        <select id="author" name="authorId" required>
            <option value="" disabled selected>Select an Author</option>
            <% 
                // Get the list of authors from request attributes
                List<Author> authors = (List<Author>) request.getAttribute("authors");
                
                if (authors != null && !authors.isEmpty()) {
                    // Loop through the authors and create a dropdown option for each one
                    for (Author author : authors) {
            %>
                <option value="<%= author.getId() %>"><%= author.getName() %></option>
            <% 
                    }
                } else {
            %>
                <option value="" disabled>No authors available</option>
            <% 
                }
            %>
        </select>

        <button type="submit">Add Book</button>
    </form>

    <br/>
    <%-- Display an error message if no authors are found --%>
    <% if (request.getAttribute("error") != null) { %>
        <p style="color: red;"><%= request.getAttribute("error") %></p>
    <% } %>

</body>
</html>

