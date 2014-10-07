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
<link rel="icon" href="dist/img/icon_stockii_square.png">
<link href="dist/css/bootstrap.min.css" rel="stylesheet">
<link href="dist/css/common.css" rel="stylesheet">
<style type="text/css">
.panle > p,.product-detail h2{	
	margin:0;
	padding: 2px 20px 2px;
	background: #E7E7E7;
	border-top-left-radius:4px;-o-border-top-left-radius:4px;-moz-border-top-left-radius:4px;-webkit-border-top-left-radius:4px;
	border-top-right-radius:4px;-o-border-top-right-radius:4px;-moz-border-top-right-radius:4px;-webkit-border-top-right-radius:4px;
	font-size: 16px;
	font-family: 'Microsoft YaHei', 微软雅黑, 'Microsoft JhengHei', 华文细黑, STHeiti, MingLiu;
	max-width:100%;
	font-weight: bold;
	color:black;
	height: 36px;
	line-height: 36px;
}
.panle .thumbnail{
	width: 95%;
	margin: 20px auto;
	padding: 15px;
	border: 1px solid #ccc;
	background: #E7E7E7;
	font-size: 13px;
	font-family: 'Microsoft YaHei', 微软雅黑, 'Microsoft JhengHei', 华文细黑, STHeiti, MingLiu;		
}
table.product-detail{
	width: 95%;
	margin: 20px auto;
	border: 1px solid #ccc;
	border-radius:4px;-o-border-radius:4px;-moz-border-radius:4px;-webkit-border-radius:4px;
}
table.product-detail h2{
	font-size: 15px;
	font-family: 'Microsoft YaHei', 微软雅黑, 'Microsoft JhengHei', 华文细黑, STHeiti, MingLiu;
	max-width:100%;
	font-weight: bold;
	color:rgb(102,102,102);
	height: 36px;
}
table.product-detail tr{
	height:36px;
}
table.product-detail tr:first-of-type{
	background: #E7E7E7;
}
table.product-detail td{
	height: 36px;
	border:1px solid #ccc;
}
table.product-detail td:nth-child(odd){
	background: #f4f4f4;
	width: 17%;
}
table.product-detail td:nth-child(even){
	width: 33%;
}
</style>
</head>
<body>
<jsp:include page="download_header.jsp" />
<br>
<div id="product_download">
<!-- 投资人群 -->
<div>
<!-- 导航 -->
<div class="container">
	<div class="btn-group" id="btn-nav-crowd">
		<a class="btn btn-default" href="#workers">工薪人群</a>
		<a class="btn btn-default" href="#small_bussiness">小企业主</a>
		<a class="btn btn-default" href="#student">学生人群</a>
		<a class="btn btn-default" href="#daren">投资达人</a>			
	</div><br><br>
</div>
<!-- 工薪 -->
<div class="container text-left">
	<div class="panle" id="workers">
		<p>工薪族投资产品指南</p>
		<div class="thumbnail">
			产品亮点：注册即可使用产品，无额外收费<br>
			推荐人群：初次借款的工薪族、私营业主、学生
		</div>
		<table class="product-detail">
			<tbody>
				<tr><td colspan="4"><h2>产品描述</h2></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
			</tbody>			   
		</table>
		<table class="product-detail">
			<tbody>
				<tr><td colspan="4"><h2>申请须知</h2></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
			</tbody>			   
		</table>
		<table class="product-detail">
			<tbody>
				<tr><td colspan="4"><h2>准备资料</h2></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
			</tbody>			   
		</table>
		<div class="panle text-right" id="download_link">
			<ul class="list-inline">
				<li><a class="btn btn-success" href="#"><img alt="PC" src="dist/img/download_android.png">下载PC客户端</a></li>
				<li><a class="btn btn-success" href="#"><img alt="iphone" src="dist/img/download_iphone.png">下载Iphone端</a></li>
				<li><a class="btn btn-success" href="#btn-nav"><img alt="android" src="dist/img/download_android.png">下载Android端</a></li>
				<li><a class="btn btn-info" href="#btn-nav-crowd"><img alt="android" src="dist/img/download_back.png" style="height: 42px;">返回导航</a></li>
			</ul>				
		</div>
	</div>
</div><!-- 工薪结束 -->	
<!-- 小企业主 -->
<div class="container text-left">
	<div class="panle" id="small_bussiness">
		<p>小企业主投资产品指南</p>
		<div class="thumbnail">
			产品亮点：注册即可使用产品，无额外收费<br>
			推荐人群：初次借款的工薪族、私营业主、学生
		</div>
		<table class="product-detail">
			<tbody>
				<tr><td colspan="4"><h2>产品描述</h2></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
			</tbody>			   
		</table>
		<table class="product-detail">
			<tbody>
				<tr><td colspan="4"><h2>申请须知</h2></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
			</tbody>			   
		</table>
		<table class="product-detail">
			<tbody>
				<tr><td colspan="4"><h2>准备资料</h2></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
			</tbody>			   
		</table>
		<div class="panle text-right" id="download_link">
			<ul class="list-inline">
				<li><a class="btn btn-success" href="#"><img alt="PC" src="dist/img/download_android.png">下载PC客户端</a></li>
				<li><a class="btn btn-success" href="#"><img alt="iphone" src="dist/img/download_iphone.png">下载Iphone端</a></li>
				<li><a class="btn btn-success" href="#"><img alt="android" src="dist/img/download_android.png">下载Android端</a></li>
				<li><a class="btn btn-info" href="#btn-nav-crowd"><img alt="android" src="dist/img/download_back.png" style="height: 42px;">返回导航</a></li>
			</ul>				
		</div>
	</div>
</div><!-- 小企业主结束 -->	
<!-- 学生 -->
<div class="container text-left">
	<div class="panle" id="student">
		<p>学生用户投资产品指南</p>
		<div class="thumbnail">
			产品亮点：注册即可使用产品，无额外收费<br>
			推荐人群：初次借款的工薪族、私营业主、学生
		</div>
		<table class="product-detail">
			<tbody>
				<tr><td colspan="4"><h2>产品描述</h2></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
			</tbody>			   
		</table>
		<table class="product-detail">
			<tbody>
				<tr><td colspan="4"><h2>申请须知</h2></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
			</tbody>			   
		</table>
		<table class="product-detail">
			<tbody>
				<tr><td colspan="4"><h2>准备资料</h2></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
			</tbody>			   
		</table>
		<div class="panle text-right" id="download_link">
			<ul class="list-inline">
				<li><a class="btn btn-success" href="#"><img alt="PC" src="dist/img/download_android.png">下载PC客户端</a></li>
				<li><a class="btn btn-success" href="#"><img alt="iphone" src="dist/img/download_iphone.png">下载Iphone端</a></li>
				<li><a class="btn btn-success" href="#"><img alt="android" src="dist/img/download_android.png">下载Android端</a></li>
				<li><a class="btn btn-info" href="#btn-nav-crowd"><img alt="android" src="dist/img/download_back.png" style="height: 42px;">返回导航</a></li>
			</ul>				
		</div>
	</div>
</div><!-- 学生结束 -->	
<!-- 投资达人 -->
<div class="container text-left">
	<div class="panle" id="daren">
		<p>投资达人产品指南</p>
		<div class="thumbnail">
			产品亮点：注册即可使用产品，无额外收费<br>
			推荐人群：初次借款的工薪族、私营业主、学生
		</div>
		<table class="product-detail">
			<tbody>
				<tr><td colspan="4"><h2>产品描述</h2></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
			</tbody>			   
		</table>
		<table class="product-detail">
			<tbody>
				<tr><td colspan="4"><h2>申请须知</h2></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
			</tbody>			   
		</table>
		<table class="product-detail">
			<tbody>
				<tr><td colspan="4"><h2>准备资料</h2></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
			</tbody>			   
		</table>
		<div class="panle text-right" id="download_link">
			<ul class="list-inline">
				<li><a class="btn btn-success" href="#"><img alt="PC" src="dist/img/download_android.png">下载PC客户端</a></li>
				<li><a class="btn btn-success" href="#"><img alt="iphone" src="dist/img/download_iphone.png">下载Iphone端</a></li>
				<li><a class="btn btn-success" href="#"><img alt="android" src="dist/img/download_android.png">下载Android端</a></li>
				<li><a class="btn btn-info" href="#btn-nav-crowd"><img alt="android" src="dist/img/download_back.png" style="height: 42px;">返回导航</a></li>
			</ul>				
		</div>
	</div>
</div><!-- 投资达人结束 -->	
</div><!-- 投资人群结束 -->

<!-- 投资额度 -->
<div>
<!-- 导航 -->
<div class="container">
	<div class="btn-group" id="btn-nav-amount">
		<a class="btn btn-default" href="#small">小额投资</a>
		<a class="btn btn-default" href="#center">中俄投资</a>
		<a class="btn btn-default" href="#big">大额投资</a>
		<a class="btn btn-default" href="#huge">巨额投资</a>			
	</div><br><br>
</div>
<!-- 小额 -->
<div class="container text-left">
	<div class="panle" id="small">
		<p>小额投资产品指南</p>
		<div class="thumbnail">
			产品亮点：注册即可使用产品，无额外收费<br>
			推荐人群：初次借款的工薪族、私营业主、学生
		</div>
		<table class="product-detail">
			<tbody>
				<tr><td colspan="4"><h2>产品描述</h2></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
			</tbody>			   
		</table>
		<table class="product-detail">
			<tbody>
				<tr><td colspan="4"><h2>申请须知</h2></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
			</tbody>			   
		</table>
		<table class="product-detail">
			<tbody>
				<tr><td colspan="4"><h2>准备资料</h2></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
			</tbody>			   
		</table>
		<div class="panle text-right" id="download_link">
			<ul class="list-inline">
				<li><a class="btn btn-success" href="#"><img alt="PC" src="dist/img/download_android.png">下载PC客户端</a></li>
				<li><a class="btn btn-success" href="#"><img alt="iphone" src="dist/img/download_iphone.png">下载Iphone端</a></li>
				<li><a class="btn btn-success" href="#btn-nav"><img alt="android" src="dist/img/download_android.png">下载Android端</a></li>
				<li><a class="btn btn-info" href="#btn-nav-amount"><img alt="android" src="dist/img/download_back.png" style="height: 42px;">返回导航</a></li>
			</ul>				
		</div>
	</div>
</div><!-- 小额结束 -->	
<!-- 中额投资 -->
<div class="container text-left">
	<div class="panle" id="center">
		<p>中额投资产品指南</p>
		<div class="thumbnail">
			产品亮点：注册即可使用产品，无额外收费<br>
			推荐人群：初次借款的工薪族、私营业主、学生
		</div>
		<table class="product-detail">
			<tbody>
				<tr><td colspan="4"><h2>产品描述</h2></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
			</tbody>			   
		</table>
		<table class="product-detail">
			<tbody>
				<tr><td colspan="4"><h2>申请须知</h2></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
			</tbody>			   
		</table>
		<table class="product-detail">
			<tbody>
				<tr><td colspan="4"><h2>准备资料</h2></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
			</tbody>			   
		</table>
		<div class="panle text-right" id="download_link">
			<ul class="list-inline">
				<li><a class="btn btn-success" href="#"><img alt="PC" src="dist/img/download_android.png">下载PC客户端</a></li>
				<li><a class="btn btn-success" href="#"><img alt="iphone" src="dist/img/download_iphone.png">下载Iphone端</a></li>
				<li><a class="btn btn-success" href="#"><img alt="android" src="dist/img/download_android.png">下载Android端</a></li>
				<li><a class="btn btn-info" href="#btn-nav-amount"><img alt="android" src="dist/img/download_back.png" style="height: 42px;">返回导航</a></li>
			</ul>				
		</div>
	</div>
</div><!-- 中额投资结束 -->	
<!-- 大额投资 -->
<div class="container text-left">
	<div class="panle" id="big">
		<p>大额投资产品指南</p>
		<div class="thumbnail">
			产品亮点：注册即可使用产品，无额外收费<br>
			推荐人群：初次借款的工薪族、私营业主、学生
		</div>
		<table class="product-detail">
			<tbody>
				<tr><td colspan="4"><h2>产品描述</h2></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
			</tbody>			   
		</table>
		<table class="product-detail">
			<tbody>
				<tr><td colspan="4"><h2>申请须知</h2></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
			</tbody>			   
		</table>
		<table class="product-detail">
			<tbody>
				<tr><td colspan="4"><h2>准备资料</h2></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
			</tbody>			   
		</table>
		<div class="panle text-right" id="download_link">
			<ul class="list-inline">
				<li><a class="btn btn-success" href="#"><img alt="PC" src="dist/img/download_android.png">下载PC客户端</a></li>
				<li><a class="btn btn-success" href="#"><img alt="iphone" src="dist/img/download_iphone.png">下载Iphone端</a></li>
				<li><a class="btn btn-success" href="#"><img alt="android" src="dist/img/download_android.png">下载Android端</a></li>
				<li><a class="btn btn-info" href="#btn-nav-amount"><img alt="android" src="dist/img/download_back.png" style="height: 42px;">返回导航</a></li>
			</ul>				
		</div>
	</div>
</div><!-- 大额投资结束 -->	
<!-- 巨额投资 -->
<div class="container text-left">
	<div class="panle" id="huge">
		<p>巨额投资产品指南</p>
		<div class="thumbnail">
			产品亮点：注册即可使用产品，无额外收费<br>
			推荐人群：初次借款的工薪族、私营业主、学生
		</div>
		<table class="product-detail">
			<tbody>
				<tr><td colspan="4"><h2>产品描述</h2></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
			</tbody>			   
		</table>
		<table class="product-detail">
			<tbody>
				<tr><td colspan="4"><h2>申请须知</h2></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
			</tbody>			   
		</table>
		<table class="product-detail">
			<tbody>
				<tr><td colspan="4"><h2>准备资料</h2></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
				<tr><td></td><td></td><td></td><td></td></tr>
			</tbody>			   
		</table>
		<div class="panle text-right" id="download_link">
			<ul class="list-inline">
				<li><a class="btn btn-success" href="#"><img alt="PC" src="dist/img/download_android.png">下载PC客户端</a></li>
				<li><a class="btn btn-success" href="#"><img alt="iphone" src="dist/img/download_iphone.png">下载Iphone端</a></li>
				<li><a class="btn btn-success" href="#"><img alt="android" src="dist/img/download_android.png">下载Android端</a></li>
				<li><a class="btn btn-info" href="#btn-nav-amount"><img alt="android" src="dist/img/download_back.png" style="height: 42px;">返回导航</a></li>
			</ul>				
		</div>
	</div>
</div><!-- 巨额投资结束 -->	
</div><!-- 投资额度结束 -->
</div>
<s:include value="<%=request.getContextPath()%>/_footer.jsp"></s:include>
<script type="text/javascript" src="dist/js/jquery.min.js"></script>
<script type="text/javascript" src="dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="dist/js/site.effect.js"></script>
</body>
</html>