<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html">
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
<link href="dist/css/bootstrap.min.css" rel="stylesheet">
<link href="dist/css/common.css" rel="stylesheet">
<style type="text/css">
	div.panle{
		border:2px solid #fff;
		border-radius:4px;-o-border-radius:4px;-moz-border-radius:4px;-webkitborder-radius:4px;
		
	}
</style>
</head>
<body>
	<s:include value="_header.jsp">  
	<s:param name="index">product</s:param>  
	</s:include>  
<div id="product" style="background: #FAFAFA;">
	<div class="product-topphoto text-center" style="height:200px;background: url('dist/img/product-top-winner.jpg');-webkit-background-size:100% 100%;">
		<h2 style="line-height: 200px;color: #fff;margin: 0;">选择斯多克，投资快人一步</h2>
	</div>
	<br>
	<div class="container">
		<div class="btn-group" id="btn-nav">
			<a class="btn btn-default" href="product.action#crowd">投资人群</a>
			<a class="btn btn-default" href="product.action#amount">投资额度</a>
			<a class="btn btn-default" href="product.action#period">投资周期</a>
			<a class="btn btn-default" href="product.action#application">应用平台</a>			
		</div>
	</div>
	<div class="container text-center" >
		<div class="panle" data-panle="crowd" id="crowd">
			<h3 style="border-bottom: 3px rgb(241, 241, 241) solid;margin: 0;padding:0;">
				<a href="/download/product_download.action#btn-nav-crowd"><img alt="product-crowd" src="dist/img/product-crowd.png" style="margin: 0;padding:0 30px 0;font-size: 24px;position: relative;top:25px;"></a>
			</h3><br><br>
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<ul class="list-inline">
							<li style="">
								<div style="float: left;width: 30%;">
									<a href="#"><img alt="" src="dist/img/product-crowd-01 .png" title="点击下载应用..." style="margin-bottom: 30px;"></a>
									<br><span>适用工薪族</span>
								</div>
								<div style="">
									<p>持中国居民身份证的中国大陆公民21~55周岁</p>
								</div>
							</li>	
						</ul>
					</div>
					<div class="col-md-6">
						<ul class="list-inline">
							<li style="">
								<div style="float: left;width: 30%;">
									<a href="#"><img alt="" src="dist/img/product-crowd-01 .png" title="点击下载应用..." style="margin-bottom: 30px;"></a>
									<br><span>适用工薪族</span>
								</div>
								<div style="">
									<p>持中国居民身份证的中国大陆公民21~55周岁</p>
								</div>
							</li>	
						</ul>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<ul class="list-inline">
							<li style="">
								<div style="float: left;width: 30%;">
									<a href="#"><img alt="" src="dist/img/product-crowd-01 .png" title="点击下载应用..." style="margin-bottom: 30px;"></a>
									<br><span>适用工薪族</span>
								</div>
								<div style="">
									<p>持中国居民身份证的中国大陆公民21~55周岁</p>
								</div>
							</li>	
						</ul>
					</div>
					<div class="col-md-6">
						<ul class="list-inline">
							<li style="">
								<div style="float: left;width: 30%;">
									<a href="#"><img alt="" src="dist/img/product-crowd-01 .png" title="点击下载应用..." style="margin-bottom: 30px;"></a>
									<br><span>适用工薪族</span>
								</div>
								<div style="">
									<p>持中国居民身份证的中国大陆公民21~55周岁</p>
								</div>
							</li>	
						</ul>
					</div>
				</div>
			</div>	
			<a href="product.action#btn-nav" style="color:#ddd;">返回导航</a>		
		</div><br>
		<div class="panle" data-panle="amount" id="amount">
			<h3 style="border-bottom: 3px rgb(241, 241, 241) solid;margin: 0;padding:0;">
				<a href="/download/product_download.action#btn-nav-amount"><img alt="product-crowd" src="dist/img/product-amount.png" style="margin: 0;padding:0 30px 0;font-size: 24px;position: relative;top:25px;"></a>
			</h3><br><br>
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<ul class="list-inline">
							<li style="">
								<div style="float: left;width: 30%;">
									<a href="#"><img alt="" src="dist/img/product-crowd-02.png" title="点击下载应用..." style="margin-bottom: 30px;"></a>
									<br><span>小额投资</span>
								</div>
								<div style="">
									<p>持中国居民身份证的中国大陆公民21~55周岁</p>
								</div>
							</li>	
						</ul>
					</div>
					<div class="col-md-6">
						<ul class="list-inline">
							<li style="">
								<div style="float: left;width: 30%;">
									<a href="#"><img alt="" src="dist/img/product-crowd-02.png" title="点击下载应用..." style="margin-bottom: 30px;"></a>
									<br><span>中额投资</span>
								</div>
								<div style="">
									<p>持中国居民身份证的中国大陆公民21~55周岁</p>
								</div>
							</li>	
						</ul>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<ul class="list-inline">
							<li style="">
								<div style="float: left;width: 30%;">
									<a href="#"><img alt="" src="dist/img/product-crowd-02.png" title="点击下载应用..." style="margin-bottom: 30px;"></a>
									<br><span>大额投资</span>
								</div>
								<div style="">
									<p>持中国居民身份证的中国大陆公民21~55周岁</p>
								</div>
							</li>	
						</ul>
					</div>
					<div class="col-md-6">
						<ul class="list-inline">
							<li style="">
								<div style="float: left;width: 30%;">
									<a href="#"><img alt="" src="dist/img/product-crowd-02.png" title="点击下载应用..." style="margin-bottom: 30px;"></a>
									<br><span>巨额投资</span>
								</div>
								<div style="">
									<p>持中国居民身份证的中国大陆公民21~55周岁</p>
								</div>
							</li>	
						</ul>
					</div>
				</div>
			</div>	
			<a href="product.action#btn-nav" style="color:#ddd;">返回导航</a>			
		</div><br>
		<div class="panle" data-panle="period" id="period">
			<h3 style="border-bottom: 3px rgb(241, 241, 241) solid;margin: 0;padding:0;">
				<a href="/download/product_download.action#btn-nav-period"><img alt="product-crowd" src="dist/img/product-period.png" style="margin: 0;padding:0 30px 0;font-size: 24px;position: relative;top:25px;"></a>
			</h3><br><br>
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<ul class="list-inline">
							<li style="">
								<div style="float: left;width: 30%;">
									<a href="#"><img alt="" src="dist/img/product-crowd-03.png" title="点击下载应用..." style="margin-bottom: 30px;"></a>
									<br><span>短期</span>
								</div>
								<div style="">
									<p>持中国居民身份证的中国大陆公民21~55周岁</p>
								</div>
							</li>	
						</ul>
					</div>
					<div class="col-md-6">
						<ul class="list-inline">
							<li style="">
								<div style="float: left;width: 30%;">
									<a href="#"><img alt="" src="dist/img/product-crowd-03.png" title="点击下载应用..." style="margin-bottom: 30px;"></a>
									<br><span>中期</span>
								</div>
								<div style="">
									<p>持中国居民身份证的中国大陆公民21~55周岁</p>
								</div>
							</li>	
						</ul>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<ul class="list-inline">
							<li style="">
								<div style="float: left;width: 30%;">
									<a href="#"><img alt="" src="dist/img/product-crowd-03.png" title="点击下载应用..." style="margin-bottom: 30px;"></a>
									<br><span>中长期</span>
								</div>
								<div style="">
									<p>持中国居民身份证的中国大陆公民21~55周岁</p>
								</div>
							</li>	
						</ul>
					</div>
					<div class="col-md-6">
						<ul class="list-inline">
							<li style="">
								<div style="float: left;width: 30%;">
									<a href="#"><img alt="" src="dist/img/product-crowd-03.png" title="点击下载应用..." style="margin-bottom: 30px;"></a>
									<br><span>长期</span>
								</div>
								<div style="">
									<p>持中国居民身份证的中国大陆公民21~55周岁</p>
								</div>
							</li>	
						</ul>
					</div>
				</div>
			</div>
			<a href="product.action#btn-nav" style="color:#ddd;">返回导航</a>	
		</div><br>
		<div class="panle" data-panle="application" id="application">
			<h3 style="border-bottom: 3px rgb(241, 241, 241) solid;margin: 0;padding:0;">
				<img alt="product-crowd" src="dist/img/product-platform.png" style="margin: 0;padding:0 30px 0;font-size: 24px;position: relative;top:25px;">
			</h3><br><br>
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<ul class="list-inline">
							<li style="">
								<div style="float: left;width: 30%;">
									<a href="#"><img alt="" src="dist/img/product-crowd-04.png" title="点击下载应用..." style="margin-bottom: 30px;"></a>
									<br><span>PC端</span>
								</div>
								<div style="">
									<p>持中国居民身份证的中国大陆公民21~55周岁</p>
								</div>
							</li>	
						</ul>
					</div>
					<div class="col-md-6">
						<ul class="list-inline">
							<li style="">
								<div style="float: left;width: 30%;">
									<a href="#"><img alt="" src="dist/img/product-crowd-04.png" title="点击下载应用..." style="margin-bottom: 30px;"></a>
									<br><span>适用工薪族</span>
								</div>
								<div style="">
									<p>持中国居民身份证的中国大陆公民21~55周岁</p>
								</div>
							</li>	
						</ul>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<ul class="list-inline">
							<li style="">
								<div style="float: left;width: 30%;">
									<a href="#"><img alt="" src="dist/img/product-crowd-04.png" title="点击下载应用..." style="margin-bottom: 30px;"></a>
									<br><span>适用工薪族</span>
								</div>
								<div style="">
									<p>持中国居民身份证的中国大陆公民21~55周岁</p>
								</div>
							</li>	
						</ul>
					</div>
					<div class="col-md-6">
						<ul class="list-inline">
							<li style="">
								<div style="float: left;width: 30%;">
									<a href="#"><img alt="" src="dist/img/product-crowd-04.png" title="点击下载应用..." style="margin-bottom: 30px;"></a>
									<br><span>适用工薪族</span>
								</div>
								<div style="">
									<p>持中国居民身份证的中国大陆公民21~55周岁</p>
								</div>
							</li>	
						</ul>
					</div>
				</div>
			</div>
			<a href="product.action#btn-nav" style="color:#ddd;">返回导航</a>	
		</div>		
	</div>
	<br>
</div>

<s:include value="_footer.jsp"></s:include>
<script type="text/javascript" language="javascript" src="dist/js/jquery.min.js" ></script>
<script type="text/javascript" language="javascript" src="dist/js/bootstrap.min.js"></script>
<script type="text/javascript" language="javascript" src="dist/js/site.effect.js"></script>
<script type="text/javascript">
/*$(document).ready(function(){
	var panle=$("div[data-panle]");
	panle.each(function(){
		$(this).css("display","none");
	})
	$("div[data-panle='crowd']").css("display","block");
	$("button[data-target='crowd']").attr("class","btn btn-default active");
	$("button[data-target]").on({
		click:function(){
			var target=$(this).attr("data-target");
			$("button[data-target='crowd']").attr("class","btn btn-default");
			panle.each(function(){
				if($(this).attr("data-panle")!=target){
					$(this).css("display","none");
				}else{
					$(this).css("display","block");					
				}
			});
		}
	});
})*/
</script>
</body>
</html>