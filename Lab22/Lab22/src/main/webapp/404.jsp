<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>404 - Page Not Found</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            color: #333;
            text-align: center;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 600px;
            margin: 100px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .error-code {
            font-size: 100px;
            color: #e74c3c;
            font-weight: bold;
        }

        h1 {
            font-size: 36px;
            color: #333;
        }

        p {
            font-size: 18px;
            color: #555;
        }

        .button {
            display: inline-block;
            padding: 10px 20px;
            margin-top: 20px;
            background-color: #3498db;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-size: 18px;
            transition: background-color 0.3s ease;
        }

        .button:hover {
            background-color: #2980b9;
        }

        .error-image {
            max-width: 80%;  /* Set maximum width of the image */
            height: auto;    /* Ensure the aspect ratio is maintained */
            margin: 20px auto; /* Center the image */
            display: block;
        }
    </style>
</head>
<body>

    <div class="container">
        
        <img src="<%= request.getContextPath() %>/images/meme2.jpeg" alt="404 Not Found" class="error-image">

        A jednak
    </div>

</body>
</html>
