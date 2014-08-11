<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<script language="javascript">
	alert("<%=request.getAttribute("msg")%>") ;
	window.location = "<%=request.getContextPath()%>/manage/login.jsp" ;
</script>