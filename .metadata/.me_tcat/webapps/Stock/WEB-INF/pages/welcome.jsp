<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<center>
	<br>
	<%
		if(session.getAttribute("id") != null){
	%>
			<h2>欢迎<font color="RED"><%=session.getAttribute("id")%></font>光临！</h2>
			<h3><a href="logout.action">登陆注销</a></h3>
	<%			
		} else {
			request.setAttribute("info","请先登陆！") ;
	%>
			<jsp:forward page="login.action"/>
	<%
		}
	%>
</center>