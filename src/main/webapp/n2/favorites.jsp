<%@page import="bean.Favorite"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お気に入り登録</title>
</head>
<body>
	<h1>お気に入り登録</h1>

	<form action="favoriteservlet" method="post">
		<input type="text" name="name">
		<input type="url" name="url" placeholder="https://www.example.com">
		<input type="submit" value="追加">
	</form>
	
	<h3>登録一覧</h3>
	
	<% 
		List<Favorite> registration = (List<Favorite>)session.getAttribute("registration"); 
	 	if(registration != null){
	%>
		<ul>
		<% for(Favorite f : registration){ %>
		<li id="favorite">
			<a href="<%=f.getUrl() %>" target="_blank" rel="noopener noreferrer"><%=f.getName() %></a>
		</li>
		<% } %>
		</ul>
	<% } %>
	
	
	<a href="clearservlet">
	<button>クリア</button>
	</a>
	
</body>
</html>