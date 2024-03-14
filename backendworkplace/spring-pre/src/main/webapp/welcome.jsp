<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello JSP</h1>
<%
	Random r = new Random();
	int number = r.nextInt(45)+1;
	System.out.println(number);
	out.print("<h1>"+number+"</h1>");
%>	
<h1><%= number %></h1>
</body>
</html>