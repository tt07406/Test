<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="front/img/icon_stockii_square.png">
<title>斯多克-Moto定制版</title>
<link href="front/css/bootstrap.css" rel="stylesheet">
<link href="front/css/global-style.css" rel="stylesheet">
<link href="front/css/index.css" rel="stylesheet">
<link href="front/css/font-awesome.css" rel="stylesheet">
<link href="front/css/weather.css" rel="stylesheet">
<style type="text/css">
iframe{position: absolute;top:60px;left:75%;}
</style>
</head>
<body>
	<s:include value="header.jsp">  
	<s:param name="index">index</s:param>  
	</s:include>
	<div class="container" style="padding: 80px 0px;">
		<div class="row info-list">
			<div class="col-md-2">
				<label>姓名</label>
			</div>
			<div class="col-md-8">
				 <input type="text" class="form-control" id="name" placeholder="您的姓名">
			</div>
		</div>
		<div class="row info-list">
			<div class="col-lg-2">
				<label>身份证号码</label>
			</div>
			<div class="col-lg-8">
				 <input type="text" class="form-control" id="name" placeholder="您的姓名">
			</div>
		</div>
		<div class="row info-list">
			<div class="col-lg-2">
				<label>公司资料</label>
			</div>
		</div>
		
		<div class="row info-list">
			<div class="col-lg-2">
				<label>公司资料</label>
			</div>
			<div class="col-lg-8">
				 <input type="text" class="form-control" id="name" placeholder="填入资料">
			</div>
		</div>
		
		
		<form class="form-horizontal">
					<fieldset>
						<div id="legend" class="">
							<legend class="">欢迎提交新的资料</legend>
						</div>
						<div class="control-group">

							<!-- Text input-->
							<label class="control-label" for="input01">Text input</label>
							<div class="controls">
								<input type="text" placeholder="placeholder"
									class="input-xlarge">
								<p class="help-block">Supporting help text</p>
							</div>
						</div>

						<div class="control-group">

							<!-- Text input-->
							<label class="control-label" for="input01">Text input</label>
							<div class="controls">
								<input type="text" placeholder="placeholder"
									class="input-xlarge">
								<p class="help-block">Supporting help text</p>
							</div>
						</div>
						<div class="control-group">

							<!-- Textarea -->
							<label class="control-label">Textarea</label>
							<div class="controls">
								<div class="textarea">
									<textarea type="" class=""> </textarea>
								</div>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">File Button</label>

							<!-- File Upload -->
							<div class="controls">
								<input class="input-file" id="fileInput" type="file">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Button</label>

							<!-- Button -->
							<div class="controls">
								<button class="btn btn-success">Button</button>
							</div>
						</div>

					</fieldset>
				</form>
		
	</div>
	
	<!-- weather -->
	<iframe allowtransparency="true" frameborder="0" width="410" height="98" scrolling="no" src="http://tianqi.2345.com/plugin/widget/index.htm?s=2&z=1&t=1&v=0&d=2&bd=0&k=000000&f=&q=1&e=1&a=1&c=54511&w=410&h=98&align=center"></iframe>
		
	<s:include value="footer.jsp"></s:include>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="front/js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="front/js/bootstrap.js"></script>
    <!-- weather -->
    <!-- <script src="http://lab.wangyuanwai.com/weather/v3/jquery.weather.build.min.js?parentbox=body&moveArea=all&moveArea=limit&zIndex=10&move=1&move=0&drag=1&drag=0&autoDrop=0&autoDrop=1&styleSize=big&style=cartoon-1&time=1412499016&area=client"></script> -->
 </body>
</html>