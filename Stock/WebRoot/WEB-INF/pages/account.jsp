<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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
<link href="dist/css/account.css" rel="stylesheet">
<title>登录斯多克</title>

</head>

<body>
	<s:include value="_header.jsp">  
	<s:param name="index">account</s:param>  
	</s:include> 
	<div class="container-fluid maxbg">
		<div class="row">
			<div class="col-md-2">
<!-- 				<img alt="img-left" src="front/dist/img/account.png"> -->
			</div>
			<div id="img-tips" class="col-md-5">
				<img alt="img-tips" src="dist/img/account_tips.png">
			</div>
			<div class="col-md-3">
				<div class="panel panel-default">
    			<div class="panel-body">
    				<%=request.getAttribute("info")!=null?request.getAttribute("info"):""%>
      				<form action="userLogin" method="post" onSubmit="return validate(this);">
      					<div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="✓">
      					<input name="authenticity_token" type="hidden" value="3EliZ07kHTqkHCEcNDJegiCF6qNH3xDxQLU+K8H6+rk="></div>
        				<div class="form-group">
          					<label>登录 <small>(用户名或邮箱)</small></label>
          					<input autofocus="autofocus" class="form-control" id="user_login" name="mid" type="text">
        				</div>
        				<div class="form-group">
          					<label for="user_password">密码</label>
          					<input class="form-control" id="user_password" name="password" type="password">
        				</div>
          				<div class="form-group">
          					<label for="user_code">验证码</label>
          					<input class="" id="user_password" name="code" type="text" maxlength="4" size="4"><img src="image.jsp">
        				</div>
        				<div>
        					<ul class="list-inline" style="width: 100%;">
        						<li style="width: 45%;"><input class="btn btn-lg btn-block btn-success" name="commit" type="submit" value="登录"/></li>
        						<li style="width: 45%;"><a class="btn btn-lg btn-block btn-success" href="signup.action">立即注册</a></li>
        					</ul>        					        					
        				</div>
					</form>    
				</div>
			</div>
			</div>
			<div class="col-md-2">
			</div>
		</div>	
	</div>
	
	
    
    <s:include value="_footer.jsp"></s:include>
    <script type="text/javascript" language="javascript" src="dist/js/jquery.min.js" ></script>
	<script type="text/javascript" language="javascript" src="dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" language="javascript" src="dist/js/site.effect.js"></script>
    <script type="text/javascript">
	  function validate(f){
	  			/*if (!(/^[a-zA-Z]\w{5,17}$/.test(f.mid.value))){
	  				alert("以字母开头，长度在6-18之间！");
	  				f.mid.focus();
	  				return false;
	  			}*/
	  			if (!(/^\w{5,15}$/.test(f.password.value))){
	  				alert("密码必须是5~15位！");
	  				f.password.focus();
	  				return false;
	  			}
	  			return true;
	  } 
	</script>
  </body>
</html>
