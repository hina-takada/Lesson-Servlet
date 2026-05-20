<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>送信フォーム</title>
</head>
<body>
	<form action="contact" method="post">
		<p>氏名(必須)：<input type="text" name="name" ></p>
		<p>会社：<input type="text" name="kaisy"></p>
		<p>メールアドレス(必須)：<input type="text" name="mail"></p>
		<p>お問い合わせ内容(必須)：<textarea name="toiawas"></textarea></p>
		
		<p>メルマガ（複数可）</p>
		<p><input type="checkbox" name="check" value="総合案内">総合案内</p>
		<p><input type="checkbox" name="check" value="セミナー案内">セミナー案内</p>
		<p><input type="checkbox" name="check" value="求人採用情報">求人採用情報</p>
		
		<p>資料請求希望</p>
		<p><input type="radio" name="anser" value="Yes">Yes</p>
		<p><input type="radio" name="anser" value="No">No</p>
		<input type="submit" value="送信">
	</form>
</body>
</html>