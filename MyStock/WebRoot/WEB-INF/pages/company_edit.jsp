<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>公司信息展示 -- 斯多克个人版</title>
<link href="front/css/bootstrap.css" rel="stylesheet">
<link href="front/css/jquery-ui.min.css" rel="stylesheet">
<link href="front/css/global-style.css" rel="stylesheet">
<link href="front/css/company_edit.css" rel="stylesheet">
<style type="text/css">
#edit > h1{
	font-size: 36px;
}

#img-pool {
	
}
</style>
</head>
<body>
<s:include value="header.jsp">  
	<s:param name="index">company_list</s:param>  
	</s:include>
	<div id="edit" class="container" style="padding: 80px 0px;">
		<h1 class="lead text-left">斯多克科技有限公司</h1>

		<div class="row">
			<div class="col-lg-5">
				<form class="form-horizontal" role="form">
					<div class="form-group">
						<label for="exampleInputEmail1">公司代码</label> 
						<input type="email" class="form-control" id="exampleInputEmail1"
							placeholder="上交所/深交所股票代码" value="0128" disabled="disabled">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">公司名称</label> 
						<input type="email" class="form-control" id="exampleInputEmail1"
							placeholder="请输入公司全名" value="斯多克科技有限公司" disabled="disabled">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">注册地址</label> 
						<input type="email" class="form-control" id="exampleInputEmail1" placeholder="公司详细地址"
							value="北京市海淀区中关村东路8号东升大厦C座">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">公司简介</label> 
						<textarea class="form-control" id="company-details" placeholder="公司详细信息"></textarea>
					</div>
				</form>
				
				<button id="commit" class="btn btn-success">提交</button>
				
			</div>
			
			<div class="col-lg-2"></div>
			
			<div id="img-pool" class="col-lg-5">
				<div class="row">
					<div class="col-sm-6 col-md-4">
						<a href="#" class="thumbnail"> <img
							src="front/img/0128_1.jpg" alt="通用的占位符缩略图">
						</a>
					</div>
					<div class="col-sm-6 col-md-4">
						<a href="#" class="thumbnail"> <img
							src="front/img/0128_2.jpg" alt="通用的占位符缩略图">
						</a>
					</div>
					<div class="col-sm-6 col-md-4">
						<a href="#" class="thumbnail"> <img
							src="front/img/0128_1.jpg" alt="通用的占位符缩略图">
						</a>
					</div>
					<div class="col-sm-6 col-md-4">
						<a href="#" class="thumbnail"> <img
							src="front/img/0128_2.jpg" alt="通用的占位符缩略图">
						</a>
					</div>
					<div class="col-sm-6 col-md-4">
						<a href="#" class="thumbnail"> <img
							src="front/img/0128_1.jpg" alt="通用的占位符缩略图">
						</a>
					</div>
					<div class="col-sm-6 col-md-4">
						<a href="#" class="thumbnail"> <img
							src="front/img/0128_2.jpg" alt="通用的占位符缩略图">
						</a>
					</div>
					<div class="col-sm-6 col-md-4">
						<a href="#" class="thumbnail"> <img
							src="front/img/0128_1.jpg" alt="通用的占位符缩略图">
						</a>
					</div>
					<div class="col-sm-6 col-md-4">
						<a href="#" class="thumbnail"> <img
							src="front/img/0128_2.jpg" alt="通用的占位符缩略图">
						</a>
					</div>
					<div class="col-sm-6 col-md-4">
						<a href="#" class="thumbnail"> <img
							src="front/img/0128_1.jpg" alt="通用的占位符缩略图">
						</a>
					</div>
					<div class="col-sm-6 col-md-4">
						<a href="#" class="thumbnail"> <img
							src="front/img/0128_2.jpg" alt="通用的占位符缩略图">
						</a>
					</div>
					<div class="col-sm-6 col-md-4">
						<a href="#" class="thumbnail"> <img
							src="front/img/0128_1.jpg" alt="通用的占位符缩略图">
						</a>
					</div>
					<div class="col-sm-6 col-md-4">
						<a href="#" class="thumbnail"> <img
							src="front/img/0128_2.jpg" alt="通用的占位符缩略图">
						</a>
					</div>
				</div>

			</div>
		</div>
	</div>
	<s:include value="footer.jsp"></s:include>
	
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="front/js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="front/js/bootstrap.js"></script>
	<script type="text/javascript">
	
	</script>
</body>
</html>