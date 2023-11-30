<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String message=(String) request.getAttribute("message"); %>
<%if(message!=null){ %>
<h1><%=message %></h1>
<%} %>

<form action="login" method="post">
Email:<input type="email" name="email" placeholder="Enter the mail">
Password:<input type="password" name="password" placeholder="enter the password">


<input type="submit" value="login">


</form>
</body>
</html>