<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" + 
	request.getServerPort() + request.getContextPath() %>/" />
<link rel="icon" href="dist/img/icon_stockii_square.png">

<title>VIP服务--斯多克科技</title>

<!-- Bootstrap core CSS -->
<link href="dist/css/bootstrap.min.css" rel="stylesheet">

<style type="text/css">
*{
	font-family: "微软雅黑" !important;
	font-size: 16px;
}
</style>
</head>
<!-- NAVBAR
================================================== -->
  <body>
    <s:include value="_header.jsp">  
	<s:param name="index">vip</s:param>  
	</s:include>
	<header class="jumbotron " id="overview">
		<div class="container">	
		    <h1>VIP服务 <small>享受斯多克更多个性化服务</small></h1>
		</div>
	</header>
	<div class="container">
		
	</div>
	
	<s:include value="_footer.jsp"></s:include>

</body>
</html>