<%@page import="javaee.lab22.Author"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Authors Management</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        #notifications {
            margin: 20px 0;
            padding: 10px;
            border: 1px solid #ccc;
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>
    <h1>Authors Management</h1>

    <!-- Notifications Section -->
    <h2>Recent Notifications</h2>
    <div id="notifications">
        <p>No recent notifications</p>
    </div>

    <!-- Add Author Form -->
    <h2>Add Author</h2>
    <form action="authors" method="post">
        <input type="hidden" name="action" value="add">
        <label for="name">Author Name:</label>
        <input type="text" id="name" name="name" required>
        <button type="submit">Add Author</button>
    </form>

    <!-- List of Authors -->
    <h2>Authors</h2>
    <ul>
        <%
            List<Author> authors = (List<Author>) request.getAttribute("authors");
            if (authors != null && !authors.isEmpty()) {
                for (Author author : authors) {
        %>
            <li>
                <%= author.getName() %>
                <form action="authors" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="<%= author.getId() %>">
                    <button type="submit">Delete</button>
                </form>
            </li>
        <%
                }
            } else {
        %>
            <li>No authors available.</li>
        <%
            }
        %>
    </ul>

    <script>
        const socket = new WebSocket("ws://localhost:8080/Lab22/notifications");

        socket.onmessage = function(event) {
            const notificationsDiv = document.getElementById("notifications");
            const message = document.createElement("p");
            message.textContent = event.data;
            notificationsDiv.appendChild(message);
        };

        socket.onerror = function(event) {
            console.error("WebSocket error:", event);
        };

        socket.onclose = function() {
            console.log("WebSocket connection closed.");
        };
    </script>

    <div id="notifications">
        <h2>Recent Notifications:</h2>
</div>

</body>
</html>
