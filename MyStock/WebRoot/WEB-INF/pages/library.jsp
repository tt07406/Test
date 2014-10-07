<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="./css/bootstrap.css" rel="stylesheet">
<link href="./css/global-style.css" rel="stylesheet">
<link href="./css/font-awesome.css" rel="stylesheet">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="img/icon_stockii_square.png">
<title>斯多克-Moto定制版</title>
</head>
<body>
	<jsp:include page="header.jsp?index=index" />
	
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
	<jsp:include page="footer.jsp" />
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.js"></script>
</body>
</html>