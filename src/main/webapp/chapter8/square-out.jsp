<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="square-error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("UTF-8");
	   int number = Integer.parseInt(request.getParameter("number"));
	%>
	
	<p>入力した数値：<%=number %></p>
	<p>結果：<%= number * number %></p>
</body>
</html>