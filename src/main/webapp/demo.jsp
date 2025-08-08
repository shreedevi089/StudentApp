<%@page import="java.util.Random"%>
<%@page import="java.util.Date"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

body{ 
     background-image:url("images/nature.jfif");
     background-size:cover;
}

</style>

</head>

<body>
<%@include file="header.jsp" %><!-- add jsp filevs -->
<h2>print random numbers</h2>
<% Random r=new Random(); %>
<h1><%=r.nextLong() %></h1><!-- printing random numbers-->
<%Date d=new Date(); %>
<h2><%=d %></h2><!-- date object have to print -->
</body>
</html>