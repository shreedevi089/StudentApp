<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="in.pentagon.studentapp.dto.Student" %>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>DashBoard</title>
<style>
@import url("https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;600&display=swap");
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: "Open Sans", sans-serif;
}

body {
    background: #f4f6f8;
    color: #333;
    min-height: 100vh;
}


header {
    background: green;
    color: #fff;
    padding: 15px 40px;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.2);
}


.header-top {
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.header-top .left {
    font-size: 18px;
    font-weight: 600;
}

.header-top .right a {
    color: #fff;
    text-decoration: none;
    margin-left: 20px;
    font-size: 16px;
    transition: color 0.3s;
}

.header-top .right a:hover {
    color: #00bcd4;
}


.header-bottom {
    text-align: center;
    margin-top: 10px;
    font-size: 26px;
    font-weight: bold;
}


.container {
    max-width: 1200px;
    margin: 30px auto;
    background: #fff;
    padding: 25px 30px;
    border-radius: 10px;
    box-shadow: 0 4px 15px rgba(0,0,0,0.1);
}


.container h2 {
    font-size: 22px;
    margin: 20px 0 10px;
    color: #0f2027;
}


p {
    margin-bottom: 8px;
    font-size: 16px;
}

.search-box {
    display: flex;
    align-items: center;
    gap: 10px;
    margin-bottom: 25px;
}

.search-box input {
    width: 300px;
    padding: 10px 15px;
    border: 1px solid #ccc;
    border-radius: 6px;
    font-size: 16px;
}

.search-box button {
    padding: 10px 18px;
    background: #0f2027;
    color: #fff;
    border: none;
    border-radius: 6px;
    cursor: pointer;
    font-size: 16px;
    transition: 0.3s;
}

.search-box button:hover {
    background: #00bcd4;
}


.table-container {
    overflow-x: auto;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 10px;
    font-size: 16px;
}

table thead {
    background: #0f2027;
    color: #fff;
}

table th, table td {
    padding: 12px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

table tbody td {
    color: #666;
}




.footer-text {
    margin-top: 10px;
    font-size: 16px;
    color: #555;
}
.page-title {
    text-align: center;
    font-size: 28px;
    font-weight: bold;
    color: #0f2027;
    margin: 20px 0;
}

</style>
</head>
<body>
<% if (request.getAttribute("success") != null) { %>
        <div style="color: green; font-weight: bold; text-align: center; margin-bottom: 15px;">
            <%= request.getAttribute("success") %>
        </div>
    <% } %>
<%if(session.getAttribute("Student")!=null) {%>
<%Student S =(Student)session.getAttribute("Student"); %>
<form>
<header>
    <div class="header-top">
        <div class="left">Welcome <%=S.getName() %></div>
        <div class="right">
        <%if(S.getId()==3) {
            <a href="#">View Users</a> 
            }%>
            <a href="#">Reset Password</a>
            <a href="Update.jsp">Update Data</a>
            <a href="#">Logout</a>
        </div>
    
</header>
<div class="header-bottom">Dashboard</div>


<div class="container">
    <h2>View Your Data</h2>
    <div class="table-container">
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Phone</th>
                    <th>Mail ID</th>
                    <th>Branch</th>
                    <th>Location</th>
                </tr>
            </thead>
            
            <tbody>
             <tr>
                    <td><%=S.getId() %></td>
                    <td><%=S.getName() %></td>
                    <td><%=S.getPhone() %></td>
                    <td><%=S.getMail() %></td>
                    <td><%=S.getBranch() %></td>
                     <td><%=S.getLoc() %></td>
                    
                   
                </tr>
                <!-- Empty table as per requirement -->
            </tbody>
        </table>
    </div>

    <h2>Search user</h2>
    <p>Enter the name of the student here:</p>
    <div class="search-box">
        <input type="text" placeholder="Enter name">
        <button type="submit">Search</button>
    </div>

    <div class="table-container">
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Branch</th>
                    <th>Location</th>
                </tr>
            </thead>
            <tbody>
                <!-- Empty table -->
            </tbody>
        </table>
    </div>

    <p class="footer-text">Search for users!</p>
</div>
</form>
<%} 
else {
 request.setAttribute("Error", "session expired");
RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
rd.forward(request, response);	
}%>


</body>
</html>