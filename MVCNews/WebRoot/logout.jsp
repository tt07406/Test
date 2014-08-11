<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head><title>注销程序</title></head>
<body>
<center>
	<h1>注销程序</h1>
	<br>
	<%
		session.invalidate() ;	// 让session失效
		response.sendRedirect("login.jsp") ;
	%>
</center>
</body>
</html>