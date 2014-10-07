<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>关于斯多克</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="斯多克科技，智能投资领导者！">
<meta name="keywords" content="斯多克科技，斯多克，智能投资，股票投资">
<meta name="author" content="斯多克科技">
<meta name="robots" content="index,follow">
<meta name="application-name" content="istocktech.com">
<link rel="icon" href="dist/img/icon_stockii_square.png">
<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" + 
	request.getServerPort() + request.getContextPath() %>/" />
<link href="dist/css/bootstrap.min.css" rel="stylesheet">
<link href="dist/css/common.css" rel="stylesheet">
<style type="text/css">
	.service_process{
		width:1300px;height:700px;margin: 0 auto;
		position: relative;
	}
	.service_process span{
		font: 25px;font-weight: bold;border: 2px solid red;padding:10px;letter-spacing: 2px;
	}
	.service_process img{
		margin:32px 0;
	}
</style>
</head>
<body>
    <s:include value="_header.jsp">
	</s:include>
<div class="service_process">
	<span>斯多克服务流程</span>
	<img alt="service process" src="dist/img/service-process.png">
</div>
	<s:include value="_footer.jsp"></s:include>
<script type="text/javascript" language="javascript" src="dist/js/jquery.min.js" ></script>
<script type="text/javascript" language="javascript" src="dist/js/bootstrap.min.js"></script>	
<script type="text/javascript" language="javascript" src="dist/js/site.effect.js"></script>
</body>
</html>