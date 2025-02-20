<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <h2>Welcome to Home Page</h2>

    <%
        // Read cookies
        Cookie[] cookies = request.getCookies();
        String username = "Guest";

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    username = cookie.getValue();
                    break;
                }
            }
        }
    %>

    <h3>Hello, <%= username %>!</h3>

    <form action="Redirect" method="get">
        <input type="hidden" name="page" value="page2">
        <button type="submit">Go to Page 2</button>
    </form>
    
    <br>
    
    <form action="login.jsp" method="get">
        <button type="submit">Change User</button>
    </form>
</body>
</html>
