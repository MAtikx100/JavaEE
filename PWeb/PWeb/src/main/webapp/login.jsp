<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <h2>Please enter your username</h2>
    
    <form action="LoginServlet" method="post">
        <input type="text" name="username" placeholder="Username" />
        <button type="submit">Login</button>
    </form>
</body>
</html>
