<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%> 
<html>
<head>
<title></title>
<script language="javascript">
function logout(){
	if (confirm("您确定要退出系统吗？"))
		top.location = "userLogout";
	return false;
}
</script>
</head>
  <body>
	<header class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand navbar-logo" href=""></a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class='${param.index=="index"?"active":"" }'><a
						href="index.action">首页</a></li>
					<li class='${param.index=="myarticles"?"active":"" }'><a
						href="myarticles.action">我的文章</a></li>
					<li class='${param.index=="myimages"?"active":"" }'><a
						href="myimages.action">我的图片</a></li>
					<li class='${param.index=="myforms"?"active":"" }'><a
						href="myforms.action">我的表格</a></li>
					<li class='${param.index=="myfiles"?"active":"" }'><a
						href="myfiles.action">我的文件</a></li>
					<li class='${param.index=="company_list"?"active":"" }'><a
						href="company_list.action">信息展示</a></li>
					<li class='${param.index=="commit_center"?"active":"" }'><a
						href="commit_center.action">信息维护</a></li>
					
					<s:if test="#session.admin != null">
						<li><a href="#" target="_self" onClick="logout();"><img src="<%=request.getContextPath()%>/back/backImages/out.gif" alt="安全退出" width="46" height="20" border="0"></a></li>
					</s:if>
					<s:else>
						<li class='${param.index=="account"?"active":"" }'><a
						href="account.action">登陆</a></li>
					</s:else>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</header>
</body>
</html>
