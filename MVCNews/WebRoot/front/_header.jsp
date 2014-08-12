<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<html>
 	<link href="dist/css/bootstrap.min.css" rel="stylesheet">
  	<link href="dist/css/site.min.css" rel="stylesheet">

  	<!-- Favicons -->
  	<link rel="apple-touch-icon-precomposed" href="img/icon.png">
  	<link rel="shortcut icon" href="img/icon.png">
  	<style type="text/css">
	*{
		font-family: "微软雅黑" !important;
		font-size: 16px;
	}
  </style>
  <body>
      <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar">test</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class='${param.index=="index"?"active":"" }'><a href="index.jsp">首页</a></li>
            <li class='${param.index=="product"?"active":"" }'><a href="product.jsp">产品</a></li>
            <li class='${param.index=="service"?"active":"" }'><a href="service.jsp">服务</a></li>
            <li class='${param.index=="project"?"active":"" }'><a href="project.jsp">项目</a></li>
            <li class='${param.index=="account"?"active":"" }'><a href="account.jsp">帐户</a></li>
            <li class='${param.index=="corpration"?"active":"" }'><a href="corpration.jsp">合作</a></li>
            <li class='${param.index=="vip"?"active":"" }'><a href="vip.jsp">VIP</a></li>
            <li class='${param.index=="recruit"?"active":"" }'><a href="recruit.jsp" target="_blank">加入我们</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

</body>
</html>
