<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<! DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>斯多克，互联网金融领导者</title>
<link rel="stylesheet" href="dist/css/jquery.fullPage.css">
<link rel="stylesheet" href="dist/css/flexslide.css">
<link rel="stylesheet" href="dist/css/introduction.css">
<style>
#menu { margin: 0; padding: 0; position: fixed; right:0; top: 0; list-style-type: none; z-index: 70;}
#menu li {  margin:  0; font-size: 14px;}
#menu a { float: right; padding: 10px 10px; background-color: #463E3E; color: #fff; text-decoration: none;width:60px;height:50px;line-height: 50px;border-bottom: 1px solid #fff;}
#menu .active a { color: #fff; background-color: #E78941;}

#bt-login{position: fixed;top:10px;list-style-type: none;z-index: 2;}
#bt-login li {float:left;  margin:  0; font-size: 14px;}
#bt-login a { float:left; padding: 0 10px; text-align:center;text-decoration: none;width:60px;height:50px;line-height: 50px;}
.section { text-align: center; font: "Microsoft Yahei"; color: #fff;}
</style>
<script src="dist/js/jquery-1.11.1.js"></script>
<script src="dist/js/jquery-ui.min.js"></script>
<script src="dist/js/jquery.fullPage.min.js"></script>
<script src="dist/js/jquery.flexslider-2.2.2.js"></script>
<script>
$(document).ready(function() {
	$.fn.fullpage({
		slidesColor: ['#1FA67A', '#37A8D7', '#474747'],
		anchors: ['page1', 'page2', 'page3'],
		menu: '#menu',
		loopBottom: true,
		loopTop:true,
	});
});
</script>
</head>
<body>
<div id="part_menu">
<ul id="menu" style="height: 1000px;background: #463E3E;">
	<li><a href="index.jsp">Home</a></li>
	<li data-menuanchor="page1" class="active"><a href="#page1">About</a></li>
	<li data-menuanchor="page2"><a href="#page2">Investment</a></li>
	<li data-menuanchor="page3"><a href="#page3">Advantage</a></li>	
</ul>
</div>

<div id="index-main">

<!-- about -->
<div class="section">
	<img alt="introduction-provide" src="dist/img/introduction-provide.png"><br><br>
	<div class="container">		
		<div class="left"><img alt="" src="dist/img/index_intro1.jpg" class="intro"> </div>
		<div class="right">
			<ul class="list-unstyled">
				<li>智能化投资
					<p>利用大数据、科学云计算、移动分布式计算等新兴技术进行投资智能化</p>
				</li>
				<li>一对一式服务
					<p>斯多克为每个客户量身打造不同的投资方案，提供本息安全、回报丰厚、操作便捷的互联网金融投资产品。</p>
				</li>
			</ul>		
		</div>					
	</div>
</div><!-- ./ end about -->

<!-- smarty investment -->
<div class="section">
	<img alt="introduction-investment" src="dist/img/introduction-invest.png"><br><br>
	<div class="container">		
		<div class="left"><img alt="" src="dist/img/index_intro2.jpg" class="intro"> </div>
		<div class="right">			
			<ul class="list-unstyled">
				<li>大数据
					<p>大数据(big data)，或称巨量资料，指的是所涉及的资料量规模巨大到无法透过目前主流软件工具，在合理时间内达到撷取、管理、处理、并整理成为帮助企业经营决策更积极目的的资讯</p>
				</li>
				<li>智能分析
					<p>根据实时动态的投资报告分析，通过不同参数指标预设不同的预播规则，一旦投资在场景中触发了预定义参数指标的边界，斯多克产品会向您发出投资提示，用户可以通过实时提示采取相关措施</p>
				</li> 
				<li>科学云计算
					<p></p>
				</li>
				<li>移动分布式计算
					<p></p>
				</li>
			</ul>							
		</div>					
	</div>
</div><!-- ./ end smarty investment -->

<!-- Advantage -->
<div class="section">
	<img alt="introduction-advantage" src="dist/img/introduction-advantage.png"><br><br>
	<div class="container">		
		<div class="left"><img alt="" src="dist/img/index_intro3.jpg" class="intro"> </div>
		<div class="right">
			<ul class="list-unstyled">
				<li>好收益</li>
				<li>低门栏</li>
				<li>更方便</li>
			</ul>		
		</div>					
	</div>
</div><!-- ./ end advantage -->

<!-- 
<div class="section">
	<h1>斯多克产品使用流程</h1>
	<div class="usage">
	    <ul class="slides">
	        <li><a href="###"><img src="img/img-usage-1.jpg" alt="pic1"></a></li>
	        <li><a href="###"><img src="img/img-usage-2.jpg" alt="pic2"></a></li>
	        <li><a href="###"><img src="img/img-usage-3.jpg" alt="pic3"></a></li>
	        <li><a href="###"><img src="img/img-usage-4.jpg" alt="pic4"></a></li>
	        <li><a href="###"><img src="img/img-usage-5.jpg" alt="pic5"></a></li>
	    </ul>
	</div>
</div> -->

</div>
<!-- ./ end index-main -->
<script>
$(function(){
	$('.usage').flexslider({
		animation: 'slide',
		pauseOnHover: true,
		prevText: '上一个',
		nextText: '下一个'
	});
});
</script>
</body>
</html>