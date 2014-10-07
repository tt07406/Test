<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文本提交</title>
<link href="front/css/bootstrap.css" rel="stylesheet">
<link href="front/css/jquery-ui.min.css" rel="stylesheet">
<link href="front/css/global-style.css" rel="stylesheet">
</head>
<body>
<s:include value="header.jsp">  
	<s:param name="index">myfile</s:param>  
	</s:include> 

<s:include value="footer.jsp"></s:include>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="front/js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="front/js/bootstrap.js"></script>
</body>
</html>