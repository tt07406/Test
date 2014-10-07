<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<body>
<nav class="nav navbar-inverse" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand nav-logo" href="<%=request.getContextPath()%>/index.jsp"></a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a style="color:white;">产品中心</a></li>
				<li><a href="#btn-nav-crowd">投资人群</a></li>
				<li><a href="#btn-nav-amount">投资额度</a></li>
				<li><a href="#btn-nav-period">投资周期</a></li>
			</ul>
			<div id="account-bar" class="collapse navbar-collapse text-right">
				<ul class="nav navbar-nav" style="float: right;border-left: 2px solid black;height: 50px;">
					<li class='${param.index=="account"?"active":"" }'><a href="<%=request.getContextPath()%>/account.jsp">登录</a></li>
					<li class='${param.index=="account"?"active":"" }'><a href="<%=request.getContextPath()%>/signup.jsp">注册</a></li>
					<li class='${param.index=="account"?"active":"" }'><a href="<%=request.getContextPath()%>/account.jsp">忘记密码</a></li>
				</ul>
			</div>	
		</div>			
	</div>
</nav>
</body>
</html>