<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Forgot Password</title>
    <style>
        body {
            background: #f0f4f8;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .forgot-container {
            background: #fff;
            padding: 30px 40px;
            border-radius: 12px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
            width: 400px;
        }

        .forgot-container h2 {
            text-align: center;
            margin-bottom: 25px;
            color: #333;
        }

        .form-group {
            margin-bottom: 18px;
        }

        label {
            display: block;
            margin-bottom: 6px;
            font-weight: 500;
        }

        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 10px 12px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 14px;
        }

        .btn {
            width: 100%;
            padding: 12px;
            background: #4CAF50;
            color: white;
            font-size: 16px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            transition: background 0.3s ease;
        }

        .btn:hover {
            background: #45a049;
        }

        .message {
            margin-top: 15px;
            text-align: center;
            font-size: 14px;
            color: red;
        }
    </style>
</head>
<body>

<div class="forgot-container">
    <h2>Forgot Password</h2>
     <% if (request.getAttribute("Error") != null) { %>
        <div style="color: red; font-weight: bold; text-align: center; margin-bottom: 15px;">
            <%= request.getAttribute("Error") %>
        </div>
    <% } %>
    <form action="forgot" method="post">
        <div class="form-group">
            <label for="phone">Phone Number</label>
            <input type="text" id="phone" placeholder="Enter phone number"  name="phone" >
        </div>

        <div class="form-group">
            <label for="email">Email Address</label>
            <input type="email" id="email" placeholder="Enter email" name="mail">
        </div>

        <div class="form-group">
            <label for="newPass">New Password</label>
            <input type="password" id="newPass" placeholder="Enter new password" name="pass">
        </div>

        <div class="form-group">
            <label for="confirmPass">Confirm Password</label>
            <input type="password" id="confirmPass" placeholder="Confirm password" name="cofirm">
        </div>

        <button type="submit" class="btn">Update Password</button>
        <div class="message" id="messageBox"></div>
    </form>
</div>

</body>
</html>
    