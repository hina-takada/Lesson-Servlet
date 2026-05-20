<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認画面</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String kaisy = request.getParameter("kaisy");
	String mail = request.getParameter("mail");
	String toiawas = request.getParameter("toiawas");
	String[] checks = request.getParameterValues("check");
	String anser = request.getParameter("anser");
	
	%>
	
	<p>氏名：<%=name %></p>
	<p>会社：<%=kaisy %></p>
	<p>メールアドレス：<%=mail %></p>
	<p>お問い合わせ内容：<%=toiawas %></p>
	<p>メルマガ：<%= checks%></p>
	<p>資料請求：<%=anser%></p>
	
</body>
</html>
	