<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%@page isErrorPage="true" %>
	
	<p>入力エラー:ユーザー名または年齢が正しくありません。</p>
	<p><%= exception.getMessage() %></p>
</body>
</html>