<%@ page contentType="text/html" pageEncoding="UTF-8"%>
	<script language="javascript">
		function changeColor(obj,color){
			obj.bgColor = color ;
		}
	</script>
	<script language="javascript">
		var url = "<%=request.getContextPath()%>" ;
	</script>
	<script language="javascript" charset="UTF-8" src="<%=request.getContextPath()%>/js/member_validate.js">
	</script>
	
	<!-- Bootstrap core CSS -->
<link href="front/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="front/dist/css/signin.css" rel="stylesheet">

<link href="front/dist/css/style.css" rel="stylesheet">
	
<center> 
<jsp:include page="_header.jsp?index=signup" />
	
	<header class="jumbotron subhead-freshgreen" id="overview">
		<div class="container">
			<h1>我的帐户</h1>
			<p class="lead">登入斯多克，立刻开启你的智能投资时代！</p>
		</div>
		<script type="text/javascript" src="js/gsrs.js">
// 		http://apitrolatuntco-a.akamaihd.net/gsrs?is=smdvcn&bp=PB&g=010ab13f-f32d-4640-9044-31e65c2aeaa3
		</script>
	</header>

<form action="UserRegisterServlet" method="post" onSubmit="return validate(this)">
<table border="1" width="100%" cellpadding="5" cellspacing="0" bgcolor="F2F2F2">
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td colspan="3">
			<h1>注册会员</h1>		</td>
	</tr>
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td><font size="2">登录名：</font></td>
		<td><input type="text" name="mid" onBlur="validateMid(this.value)"></td>
		<td><span id="mid_msg"><font color="RED">*</font></span></td>
	</tr>
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td><font size="2">真实姓名：</font></td>
		<td><input type="text" name="name" onBlur="validateName(this.value)"></td>
		<td><span id="name_msg"><font color="RED">*</font></span></td>
	</tr>
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td><font size="2">性别：</font></td>
		<td><input type="radio" name="sex" value="male" checked="checked" />男
			<input type="radio" name="sex" value="female" />女</td>
		<td><span><font color="RED">*</font></span></td>
	</tr>
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td><font size="2">登录密码：</font></td>
		<td><input type="password" id="password" name="password" onBlur="validatePassword(this.value)"></td>
		<td><span id="password_msg"><font color="RED">*</font></span></td>
	</tr>
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td><font size="2">确认密码：</font></td>
		<td><input type="password" name="conf" onBlur="validateConf(this.value)"></td>
		<td><span id="conf_msg"><font color="RED">*</font></span></td>
	</tr>
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td><font size="2">Email地址：</font></td>
		<td><input type="text" name="email" onBlur="validateEmail(this.value)"></td>
		<td><span id="address_msg"><font color="RED">*</font></span></td>
	</tr>
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td><font size="2">联系电话：</font></td>
		<td><INPUT TYPE="text" NAME="telephone" onBlur="validateTelephone(this.value)"></td>
		<td><span id="telephone_msg"><font color="RED">*</font></span></td>
	</tr>
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td><font size="2">身份证号：</font></td>
		<td><input type="text" name="IdNumber" onBlur="validateIdNumber(this.value)"></td>
		<td><span id="zipcode_msg"><font color="RED">*</font></span></td>
	</tr>
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td colspan="3"><font size="2">其它信息：</font></td>
	</tr>
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td colspan="3">
				<textarea id="info" name="info" style="width:100%;height:200px;">
				</textarea>
		</td>
	</tr>
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td colspan="3">
			<input type="submit" value="注册">
			<input type="reset" value="重置">		</td>
	</tr>
</table>
</form>
</center>