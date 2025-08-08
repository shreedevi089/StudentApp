<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="in.pentagon.studentapp.dto.Student" %>
<%@ page import="jakarta.servlet.RequestDispatcher" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Account</title>
<style>
body {
    font-family: Arial, sans-serif;
    background: #f2f2f2;
}

.container {
    margin-left: 450px;
    margin-top: 50px;
    background: white;
    padding: 20px 30px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0,0,0,0.2);
    width: 250px;
}

button {
    padding: 10px 15px;
    background: #4CAF50;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
    margin-right: 10px;
}

form .form-group {
    margin-bottom: 15px;
}

input {      
    width: 100%;
    padding: 10px;
    margin: 8px 0;
    border: 1px solid #ccc;
    border-radius: 5px;
}
</style>
</head>
<body>

<%
    Student s = (Student) session.getAttribute("Student");
    if (s != null) {
%>

<div class="container">
    <h1>Pentagon Space</h1>
    <h2>Update your account</h2>
    <form action="UpdateServlet" method="post">
        <div class="form-group">
            <label>Enter your name</label>
            <input type="text" name="name" value="<%= s.getName() %>"><br> <%-- value for display content on ui--%>
        </div>
        <div class="form-group">
            <label>Enter phone no</label>
            <input type="tel" name="phone" value="<%= s.getPhone() %>"><br>
        </div>
        <div class="form-group">
            <label>Enter mail id</label>
            <input type="email" name="mail" value="<%= s.getMail() %>"><br>
        </div>
        <div class="form-group">
            <label>Enter branch</label>
            <input type="text" name="br" value="<%= s.getBranch() %>"><br>
        </div>
        <div class="form-group">
            <label>Enter location</label>
            <input type="text" name="loc" value="<%= s.getLoc() %>">
        </div>
        <button type="submit">Update Account</button>
        <a href="Dash.jsp"><button type="button">Back</button></a>
    </form>
</div>

<%
    } else {
        request.setAttribute("Error", "Session expired");
        RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
        rd.forward(request, response);
    }
%>

</body>
</html>
