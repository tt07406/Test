<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的文章</title>
<link href="front/css/bootstrap.css" rel="stylesheet">
<link href="front/css/jquery-ui.min.css" rel="stylesheet">
<link href="front/css/global-style.css" rel="stylesheet">
<link href="front/css/myarticle.css" rel="stylesheet">
</head>
<body onload="FF0010();">
<s:include value="header.jsp">  
	<s:param name="index">myarticles</s:param>  
	</s:include>

<div id="article_bd">
	<div class="list">
		<div class="list_blog">
			<span class="list_blog_title">博文</span>
			<span class="list_blog_fun"><a href="article_add.action">[发布文章]</a></span>
			<ul id="article_list">
			<!-- 
				<li class="lsit_item"><a href="javascript:void(0)" onclick="readArticle(0)">测试测试测试</a></li>				
				<li class="lsit_item"><a href="javascript:void(0)" onclick="readArticle(0)">诗水蛇山神庙</a></li>
				<li class="lsit_item"><a href="javascript:void(0)" onclick="readArticle(0)">诗水蛇山神庙</a></li>
			 -->			 	
			</ul>
		</div>
		<div class="list_search"></div>
	</div>
	<div class="con">
		<article>
			<h2 class="con_title">测试测试测试</h2>
			<p class="con_bd">答案是Profile。Maven的Profile用于在不同的环境下应用不同的配置。一套配置即称为一个Profile。这里的“环境”可以是操作系统版本，JDK版本或某些文件是否存在这样的物理环境，也可以是你自己定义的一套逻辑环境。比如上面的A中所说的Linux和Mac OS X便是一种物理环境，而B中讲的开发环境和部署环境则为逻辑环境。Maven提供了Activation机制来激活某个Profile，它既允许自动激活（即在某些条件满足时自动使某个Profile生效），也可以手动激活。答案是Profile。Maven的Profile用于在不同的环境下应用不同的配置。一套配置即称为一个Profile。这里的“环境”可以是操作系统版本，JDK版本或某些文件是否存在这样的物理环境，也可以是你自己定义的一套逻辑环境。比如上面的A中所说的Linux和Mac OS X便是一种物理环境，而B中讲的开发环境和部署环境则为逻辑环境。Maven提供了Activation机制来激活某个Profile，它既允许自动激活（即在某些条件满足时自动使某个Profile生效），也可以手动激活。答案是Profile。Maven的Profile用于在不同的环境下应用不同的配置。一套配置即称为一个Profile。这里的“环境”可以是操作系统版本，JDK版本或某些文件是否存在这样的物理环境，也可以是你自己定义的一套逻辑环境。比如上面的A中所说的Linux和Mac OS X便是一种物理环境，而B中讲的开发环境和部署环境则为逻辑环境。Maven提供了Activation机制来激活某个Profile，它既允许自动激活（即在某些条件满足时自动使某个Profile生效），也可以手动激活。</p>
		</article>
	</div>  
</div>
<s:include value="footer.jsp"></s:include>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="front/js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="front/js/bootstrap.js"></script>
<!-- station function -->
<script type="text/javascript" src="front/js/article.js"></script>
<!-- ajax -->
<script type="text/javascript" src="front/js/ajax.get.js"></script>
</body>
</html>