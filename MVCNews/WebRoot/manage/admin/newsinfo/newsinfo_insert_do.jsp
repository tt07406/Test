<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<script language="javascript">
	alert("<%=request.getAttribute("msg")%>") ;
	window.location = "newsinfo_insert.jsp" ;
</script>