<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ツイート一覧</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
	
	<c:choose>
		<c:when test="${message == false}">投稿は失敗しまいしました。</c:when>
		<c:when test="${message == true}">投稿は成功しまいしました。</c:when>
		<c:otherwise> </c:otherwise>
	</c:choose>
	
	<div class="container">
		<h1>ツイート一覧</h1>
		<%-- 新規投稿 --%>
		<p>
			<a href="new_tweet.jsp">新規投稿</a>
		</p>

		<%-- ツイート一覧の表示 --%>
		<c:forEach var="tweet" items="${tweets}">
		<ul class="tweet-list">
			<li>
				<div class="tweet-content">
					<p>${tweet.countent}</p><!-- ${tweet.countent} -->
					<p class="tweet-info">投稿者: ${tweet.author} - 投稿日時: ${tweet.posted_at}</p>
				</div> <!-- ${tweet.author} --> <!-- ${tweet.posted_at} -->
			</li>
			<a href="/delete"><button>削除</button></a>
		</ul>
		</c:forEach>
	</div>
</body>
</html>
