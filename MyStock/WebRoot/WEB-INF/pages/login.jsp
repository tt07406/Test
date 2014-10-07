<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link href="front/css/bootstrap.css" rel="stylesheet">
<link href="front/css/global-style.css" rel="stylesheet">
<title>登录 -- 斯多克个人版</title>

</head>

<body>
	<s:include value="header.jsp">  
	<s:param name="index">login</s:param>  
	</s:include>
	<div class="container-fluid maxbg">
		<div class="row">
			<div class="col-md-2">
			</div>
			<div id="img-tips" class="col-md-5">
				<img alt="img-tips" src="front/img/account_tips.png">
			</div>
			<div class="col-md-3">
				<div class="panel panel-default">
    			<div class="panel-body">
    				<%=request.getAttribute("info")!=null?request.getAttribute("info"):""%>
      				<form action="UserLoginServlet" method="post" onSubmit="return validate(this);">
      					<div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="✓">
      					<input name="authenticity_token" type="hidden" value="3EliZ07kHTqkHCEcNDJegiCF6qNH3xDxQLU+K8H6+rk="></div>
        				<div class="form-group">
          					<label>登录 <small>(用户名)</small></label>
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
        						<li style="width: 45%;"><a class="btn btn-lg btn-block btn-success" href="front/signup.jsp">立即注册</a></li>
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
	
	
    
    <jsp:include page="footer.jsp" />
    <script type="text/javascript" language="javascript" src="./js/jquery.min.js" ></script>
	<script type="text/javascript" language="javascript" src="./js/bootstrap.min.js"></script>
    <script type="text/javascript">
	  function validate(f){
	  			if (!(/^[a-zA-Z]\w{5,17}$/.test(f.mid.value))){
	  				alert("以字母开头，长度在6-18之间！");
	  				f.mid.focus();
	  				return false;
	  			}
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
