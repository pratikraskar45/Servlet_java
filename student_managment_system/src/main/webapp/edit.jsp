<%@page import="student_managment_system.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Student student=(Student) request.getAttribute("student"); %>
<form action="edit" method="post">
Id:<input type="number" name="id" readonly="true" placeholder="enter the id">
Name:<input type="text" name="name" placeholder="Enter the name">
Address:<input type="text" name="address" placeholder="Enter the Address">
Email:<input type="email" name="email" placeholder="Enter the email">
Password:<input type="password" name="password"  placeholder="Enter the password">


<input type="submit" value="signup">






</form>
</body>
</html>