<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="img/icon.png">
<title>斯多克科技，互联网金融引导者</title>

<!-- Bootstrap core CSS -->
<link href="dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="dist/css/carousel.css" rel="stylesheet">
<style type="text/css">
*{
	font-family: "微软雅黑" !important;
	font-size: 16px;
}
</style>
</head>
<!-- NAVBAR
================================================== -->
<body>
<jsp:include page="_header.jsp?index=index" />
<!-- Carousel
    ================================================== -->
<div id="myCarousel" class="carousel slide" data-ride="carousel" > 
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner" >
    <div class="item active slide_middle"> 
    <img src="dist/vagrant_header_background.png" alt="First slide">
      <div class="container">
        <div class="carousel-caption">
          <h1 class="carousel-title">斯多克如何改变股票投资行业？</h1>
          <p>开创智能投资行业，为您做出智能化的决策，是的，一切就像去超市购物那样自然。</p>
          <p><a class="btn btn-lg btn-primary" href="#" role="button">什么是智能投资？</a></p>
        </div>
      </div>
    </div>
    <div class="item"> <img src="dist/vagrant_header_background.png" alt="Second slide">
      <div class="container">
        <div class="carousel-caption">
          <h1>如何把钱用在正确的地方</h1>
          <p>股票投资，唯快不破！斯多克，让您抢尽先机！</p>
          <p><a class="btn btn-lg btn-primary" href="#" role="button">与我们合作</a></p>
        </div>
      </div>
    </div>
    <div class="item"> <img src="dist/vagrant_header_background.png" alt="Third slide">
      <div class="container">
        <div class="carousel-caption">
          <h1>斯多克VIP套餐，最专业的服务，最高效的决策</h1>
          <p>只需要1280/月，就可以享受到业界最先进的决策服务！(8月份前10个客户，可额外享用最高级VIP服务一个月！)</p>
          <p><a class="btn btn-lg btn-primary" href="#" role="button">注册会员</a></p>
        </div>
      </div>
    </div>
  </div>
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> 
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a> </div>
<!-- /.carousel --> 


<!-- Marketing messaging and featurettes
    ================================================== --> 
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container marketing"> 
  
  <!-- Three columns of text below the carousel -->
  <div class="row">
    <div class="col-lg-4"> <a href="http://www.baidu.com" target="_blank" style="width: 300px; height: 220px;"> <img src="img/news_pic1.jpg" alt="Generic placeholder image" style="width: 300px; height: 220px;"> </a>
      <p class="lead" style="color: green;">斯多克致力于投资智能化，旨在为广大客户提供智能化的决策。</p>
      <p><a class="btn btn-default" href="#" role="button">产品与套餐 &raquo;</a></p>
    </div>
    <!-- /.col-lg-4 -->
    <div class="col-lg-4"> <img class="img-rounded" src="img/news_pic1.jpg" alt="Generic placeholder image" style="width: 300px; height: 220px;">
      <p class="lead" style="color: red;">斯多克致力于投资智能化，旨在为广大客户提供智能。</p>
      <p><a class="btn btn-default" href="#" role="button">资产管理 &raquo;</a></p>
    </div>
    <!-- /.col-lg-4 -->
    <div class="col-lg-4"> <img class="img-rounded" src="img/news_pic1.jpg" alt="Generic placeholder image" style="width: 300px; height: 220px;">
      <p class="lead" style="color: blue;">斯多克致力于投资智能化，旨在为广大客户提供贴心的服务.</p>
      <p><a class="btn btn-default" href="#" role="button">网上开户 &raquo;</a></p>
    </div>
    <!-- /.col-lg-4 --> 
  </div>
  <!-- /.row --> 
  
  <!-- START THE FEATURETTES -->
  
  <hr class="featurette-divider">
  <div class="row featurette">
    <div class="col-md-7">
      <h2 class="featurette-heading">斯多克科技提供什么：</br>
        </br>
        <span class="text-muted">让投资智能起来。</span></h2>
      <p class="lead">利用大数据、科学云计算、移动分布式计算等新兴技术进行投资智能化</p>
    </div>
    <div class="col-md-5"> <img class="featurette-image img-responsive" src="img/test.png" alt="Generic placeholder image"> </div>
  </div>
  <hr class="featurette-divider">
  <div class="row featurette">
    <div class="col-md-5"> <img class="featurette-image img-responsive" src="img/test.png" alt="Generic placeholder image"> </div>
    <div class="col-md-7">
      <h2 class="featurette-heading">所谓的智能是指什么呢？</br>
        </br>
        <span class="text-muted">大数据和云计算</span></h2>
      <p class="lead">大数据(big data)，或称巨量资料，指的是所涉及的资料量规模巨大到无法透过目前主流软件工具，在合理时间内达到撷取、管理、处理、并整理成为帮助企业经营决策更积极目的的资讯</p>
    </div>
  </div>
  <hr class="featurette-divider">
  <div class="row featurette">
    <div class="col-md-7">
      <h2 class="featurette-heading">智能决策有多少是可靠的？</br>
        </br>
        <span class="text-muted">我们提供差异化的服务.</span></h2>
      <p class="lead">毫无疑问，最尊贵的客人会赢得最佳的服务，斯多克具有“再次光临的顾客可为公司带来25%-85%的利润，而吸引它们再次光临的因素首先是服务质量的好坏，其次是产品本身，最后才是价格”，因此，做好服务工作，以真诚和温情打动消费者的心，培养“永久顾客”，刺激重复购买，才是谋求企业长远利益的上策。.</p>
    </div>
    <div class="col-md-5"> <img class="featurette-image img-responsive" src="img/test.png" alt="" style="width:500px; height: 500px;"> </div>
  </div>
  <hr class="featurette-divider">
  
  <!-- /END THE FEATURETTES -->
  
  
</div>
<!-- /.container -->

	<jsp:include page="_footer.jsp" />

</body>
</html>
