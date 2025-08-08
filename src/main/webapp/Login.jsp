<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f0f0f0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .login-container {
            background: white;
            padding: 25px 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.2);
            width: 320px;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        input {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        button {
            width: 100%;
            padding: 10px;
            background: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }
        button:hover {
            background: #45a049;
        }
        .register-link {
            text-align: center;
            margin-top: 10px;
        }
        .register-link a {
            text-decoration: none;
            color: #4CAF50;
            font-weight: bold;
        }
        form p a{
        margin-left:80px;
        text-decoration: none;
        font-weight: bold;
        }
    </style>
</head>
<body>

<div class="login-container">
    <h2>Student Login</h2>

    <% if (request.getAttribute("success") != null) { %>
        <div style="color: green; font-weight: bold; text-align: center; margin-bottom: 15px;">
            <%= request.getAttribute("success") %>
        </div>
    <% } %>

    <form  action="login" method="post" >
        <input type="email" id="email" placeholder="Email"  name="mail">
        <input type="password" id="password" placeholder="Password"  name="password" >
        <button type="submit">Login</button>
        <p> <a href="ForgotPass.jsp">Forgot Password</a></p>
    </form>
    <div class="register-link">
        <p>Don't have an account? <a href="Signup.jsp">Register here</a></p>
        
    </div>
    
    <% if (request.getAttribute("Success") != null) { %>
        <div style="color: green; font-weight: bold; text-align: center; margin-bottom: 15px;">
            <%= request.getAttribute("Success") %>
        </div>
    <% } %>
    
</div>



</body>
</html>