<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<% 
		String name = (String)session.getAttribute("name"); 
		if(name != null){
	%>
	<h3>こんにちは、「<%=name %>」さん</h3>
	<% } %>
	<a href="input.jsp">戻る</a>
	
</body>
</html>