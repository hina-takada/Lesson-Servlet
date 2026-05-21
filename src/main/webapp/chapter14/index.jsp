<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>シンプル掲示板</title>
</head>
<body>
	<h1>掲示板</h1>
	
	<form action="" method="post">
		<p>名前</p>
		<input type="text" name="name" required>
		<p>本文</p>
		<textarea name="content" required></textarea>
		<input type="submit" value="投稿">
	</form>
	
	
	
</body>
</html>