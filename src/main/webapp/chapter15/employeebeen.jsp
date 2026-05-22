<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.Employees" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<% Employees e = (Employees)request.getAttribute("list") %>
	<% for(Employees eList: e){ %>
	  <%=eList.getId() %>:<%=eList.getName()() %>:<%=eList.getAge()() %><br>
	<% } %>
	
	
	
</body>
</html>