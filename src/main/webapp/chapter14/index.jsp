<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="javax.naming.InitialContext" %>
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
	
	<form action="bbs" method="post">
		<p>名前</p>
		<input type="text" name="name" required>
		<p>本文</p>
		<textarea name="content" required></textarea>
		<input type="submit" value="投稿">
	</form>
	
	<%
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
try {
	//DB接続
	InitialContext ic = new InitialContext();
	DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/chapter14");
	con = ds.getConnection();
	
	//取得
	ps = con.prepareStatement("SELECT * FROM posts order by post_date DESC");
	rs = ps.executeQuery();
	
	
	while(rs.next()){
		
		String name = rs.getString("name");
		String content = rs.getString("content");
		Timestamp postDate = rs.getTimestamp("post_date");
	%>
	
	<div class="post">
		<div class="meta">
			<strong><%=name %></strong>
			<%=postDate %>
		</div>
		<div class="content"><%=content %></div>
	</div> 
	
	<%
	 }
     }catch(Exception e){
    	 e.printStackTrace();
     }finally{
    	 if(ps != null)
    		 try{
    			 ps.close();
    		 }catch(Exception e){
    		 }
    	 if(rs != null)
    		 try{
    			 rs.close();
    		 }catch(Exception e){
    		 }
    	 if(con != null)
    		 try{
    			con.close();
    		 }catch(Exception e){
    		 }
     }
	%>
</body>
</html>