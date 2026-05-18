<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		   request.setCharacterEncoding("UTF-8");
		   String username = request.getParameter("username");
		   String ageStr = request.getParameter("age"); 
		  
		   if(username.isEmpty() || username == null ||  ageStr.isEmpty() || ageStr == null){
			   throw new Exception("ユーザー名または年齢が未入力です");
		   }
		   
		   
		   int age = Integer.parseInt(ageStr);
	%>

	<p>ユーザー名：<%= username %></p>
	<p>年齢：<%= age %></p>

</body>
</html>