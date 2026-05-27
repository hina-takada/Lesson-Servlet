<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.Employees"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員フォーム</title>
</head>
<body>
	
	<h2>従業員一覧</h2>
	<% List<Employees> e = (List<Employees>)request.getAttribute("list"); %>
	<% for(Employees eList: e){ %>
	  <%=eList.getId() %>:<%=eList.getName()%>:<%=eList.getAge() %><br>
	<% } %>
	
	<h3>追加フォーム</h3>
	<form action="add" method="post">
		名前：<input type="text" name="name" required><br>
		年齢：<input type="number" name="age" min="18" required><br>
		<input type="submit" value="追加">
	</form>
	
	<h3>編集フォーム</h3>
	
	<h5>従業員情報更新</h5>
	<form action="update" method="post">
		従業員ID:<input type="number" name="id" min="1"><br>
		名前:<input type="text" name="name" ><br>
		年齢:<input type="number" name="age" min="18" ><br>
		<input type="submit" value="変換">
	</form>
	
	<h5>従業員の削除</h5>
	<form action="delete" method="post">
		従業員ID:<input type="number" name="id" name="id">
		<input type="submit" value="削除">
	</form>
	
</body>
</html>