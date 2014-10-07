<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<base
	href="<%=request.getScheme() + "://" + request.getServerName()
					+ ":" + request.getServerPort() + request.getContextPath()%>/" />
<link rel="icon" href="dist/img/icon_stockii_square.png">
<link href="dist/css/bootstrap.min.css" rel="stylesheet">
<link href="dist/css/common.css" rel="stylesheet">
</head>
<body>
	<s:include value="_header.jsp">  
	<s:param name="index">project</s:param>  
	</s:include>  
<div id="project">
	<div class="product-topphoto text-center" style="height:200px;background: url('dist/img/project-top.jpg');-webkit-background-size:100% 100%;">
		<h2 style="line-height: 200px;color: #fff;margin: 0;">斯多克，海量用户的投资选择</h2>
	</div>
	<br>
	<div class="container">
		<div class="btn-group">
			<a class="btn btn-default" href="project.action#personal">个人用户项目</a>
			<a class="btn btn-default" href="project.action#company">公司/集团用户项目</a>
		</div>
	</div>
	<br>
	<div class="container text-center">
		<div class="panle" data-panle="personal" id="personal">
			<h3 style="border-bottom: 3px rgb(241, 241, 241) solid;margin: 0;padding:0;">
				<img alt="product-crowd" src="dist/img/project-personal.png" style="margin: 0;padding:0 30px 0;font-size: 24px;position: relative;top:25px;">
			</h3><br><br>
		</div>
		<div class="panle" data-panle="company" id="company">
			<h3 style="border-bottom: 3px rgb(241, 241, 241) solid;margin: 0;padding:0;">
				<img alt="product-crowd" src="dist/img/project-company.png" style="margin: 0;padding:0 30px 0;font-size: 24px;position: relative;top:25px;">
			</h3><br><br>
		</div>		
	</div>
</div>
<br>
<s:include value="_footer.jsp"></s:include>
<script src="dist/js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
/*$(document).ready(function(){
	$("button[data-target='personal']").attr("class","btn btn-default active");
	$("div[data-panle='company']").css("display","none");
	$("button[data-target='personal']").click(function(){		
		$("div[data-panle='personal']").css("display","block");
		$("div[data-panle='company']").css("display","none");		
	});
	$("button[data-target='company']").click(function(){
		$("button[data-target='personal']").attr("class","btn btn-default");
		$("div[data-panle='personal']").css("display","none");
		$("div[data-panle='company']").css("display","block");
	});
})*/
</script>
</body>
</html>