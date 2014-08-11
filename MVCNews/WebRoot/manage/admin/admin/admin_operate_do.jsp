<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head><title>新闻发布系统</title></head>
<body>
<script language="javascript">
	alert("<%=request.getAttribute("msg")%>") ;
	window.location = "<%=request.getAttribute("url")%>" ;
</script>
</body>
</html>