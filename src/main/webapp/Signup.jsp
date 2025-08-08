<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student Sign-In</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f0f0f0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .form-container {
            background: white;
            padding: 20px 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.2);
            width: 350px;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        input, select {
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
            cursor: pointer;
            font-size: 16px;
        }
        button:hover {
            background: #45a049;
        }
    </style>
</head>
<body>

<div class="form-container">
    <h2>Student Sign-In</h2>
    <% if (request.getAttribute("error") != null) { %>
        <div style="color: red; font-weight: bold; text-align: center; margin-bottom: 15px;">
            <%= request.getAttribute("error") %>
        </div>
    <% } %>
    
    <form action="signup" method="post">
      
        <input type="text" placeholder="Full Name" required name="name">
        <input type="tel" placeholder="Phone Number" name="phone"  required>
        <input type="email" placeholder="Email" required name="mail">
        <select required  name="branch">
            <option value="">Select Branch</option>
            <option value="CSE">CSE</option>
            <option value="ECE">ECE</option>
            <option value="MECH">MECH</option>
            <option value="CIVIL">CIVIL</option>
            <option value="EEE">EEE</option>
        </select>
        <input type="text" placeholder="Location" required name="loc">
        <input type="password" placeholder="Password" required name="pass">
         <input type="password" placeholder="Confirm Password" required name="confirm">
         <% if (request.getAttribute("passmis") != null) { %>
        <div style="color: red; font-weight: bold; text-align: center; margin-bottom: 15px;">
            <%= request.getAttribute("passmis") %>
        </div>
    <% } %>
        <button type="submit">Sign In</button>
    </form>
</div>

</body>
</html>