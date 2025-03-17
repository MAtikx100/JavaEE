<!DOCTYPE html>
<html>
<head>
    <title>Division Input</title>
</head>
<body>
    <form action="ResultServlet" method="post">
        <label>Enter first number:</label>
        <input type="text" name="num1" required>
        <br>
        <label>Enter second number:</label>
        <input type="text" name="num2" required>
        <br>
        <input type="submit" value="Divide">
    </form>

    <% if (request.getAttribute("result") != null) { %>
        <h2>Result: <%= request.getAttribute("result") %></h2>
    <% } %>

    <% if (request.getAttribute("error") != null) { %>
        <h2 style="color:red;"><%= request.getAttribute("error") %></h2>
    <% } %>
</body>
</html>
