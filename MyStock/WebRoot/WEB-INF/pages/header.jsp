<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<html>
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
				<a class="navbar-brand navbar-logo" href="/"></a>
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
					<li class='${param.index=="news"?"active":"" }'><a
						href="service-2.action">今日动态</a></li>
					<li class='${param.index=="account"?"active":"" }'><a
						href="account.action">登陆</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</header>
</body>
</html>
