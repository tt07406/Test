<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head><title>更新频道</title></head>
<body>
<script language="javascript">
	alert("<%=request.getAttribute("msg")%>") ;
	window.location = "<%=request.getAttribute("url")%>" ;
</script>
</body>
</html>