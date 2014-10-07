<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>关于斯多克</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="斯多克科技，智能投资领导者！">
<meta name="keywords" content="斯多克科技，斯多克，智能投资，股票投资">
<meta name="author" content="斯多克科技">
<meta name="robots" content="index,follow">
<meta name="application-name" content="istocktech.com">
<link rel="icon" href="dist/img/icon_stockii_square.png">
<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" + 
	request.getServerPort() + request.getContextPath() %>/" />
<link href="dist/css/bootstrap.min.css" rel="stylesheet">
<link href="dist/css/common.css" rel="stylesheet">
<style type="text/css">
    /* Custom Styles */
    ul.nav-tabs{
        width: 160px;
        margin-top: 20px;
        border-radius: 4px;
        border: 1px solid #222;
        box-shadow: 0 1px 4px rgba(0, 0, 0, 0.067);
    }
    ul.nav-tabs li{
        margin: 0;
        border-top: 1px solid #222;
    }
    ul.nav-tabs li:first-child{
        border-top: none;
    }
    ul.nav-tabs li a{
        margin: 0;
        padding: 8px 16px;
        border-radius: 0;
        color:#222;
    }
    ul.nav-tabs li.active a, ul.nav-tabs li.active a:hover{
        color: #fff;
        background: #222;
        border: 1px solid #222;
    }
    ul.nav-tabs li:first-child a{
        border-radius: 4px 4px 0 0;
    }
    ul.nav-tabs li:last-child a{
        border-radius: 0 0 4px 4px;
    }
    ul.nav-tabs.affix{
        top: 30px; /* Set the top position of pinned element */
    }
    
    div.col-xs-9 h2{
    	font-size: 20px;
    	padding: 8px 16px;
    	text-decoration: none solid rgb(34, 34, 34);
    	font-weight: bold;
    }
    div.col-xs-9 h3{
    	font-size: 18px;
    }
    div.col-xs-9 p{
    	font-size: 16px;
    	text-decoration: none solid rgb(34, 34, 34);
    }
    div.col-xs-9 img{
    	float: left;
    	margin-right: 30px;
    	margin-bottom: 30px;
    	
    	border: 1px solid #EEE;
    }
    div.col-xs-9 img:first-child{
    	margin-top: 20px;
    }
</style>
</head>

<body data-spy="scroll" data-target="#myScrollspy">
    <s:include value="_header.jsp">
	</s:include>
<div class="container">
    <div class="row">
        <div class="col-xs-3" id="myScrollspy">
            <ul class="nav nav-tabs nav-stacked" id="myNav">
                <li class="active"><a href="recruit.action#about">公司简介</a></li>
                <li><a href="recruit.action#team">团队建设</a></li>
                <li><a href="recruit.action#join">加入斯多克</a></li>
                <li><a href="recruit.action#position">在招职位</a></li>
                <li><a href="recruit.action#contact">联系我们</a></li>               
            </ul>
        </div>
        <div class="col-xs-9">           
            <img alt="about" style="width:150px;height:150px;"  src="dist/img/recruit-about.png">   
            <h2 id="about">公司简介</h2>         
            <p class="lead">　　斯多克科技有限公司正式成立于2014年4月在北京成立，是一家致力于利用大数据、科学云计算、移动分布式计算等新兴技术进行投资智能化的高新科技公司。斯多克科技的理念是：专注智能投资领域，做智能投资领域的先行者。斯多克科技崇尚客户至上，以人为先的公司文化，努力为客户提供智能可靠的决策，至真至善的服务。	</p>           
            <div class="clear"></div>
            <hr>           
            <img alt="team" style="width:150px;height:150px;" src="dist/img/recruit-team.png">
            <h2 id="team">团队建设</h2>
            <p class="lead">　　我们是一支在股票投资领域和科技研发领域均具有丰富经验的成熟团队，聚集了来自国内外知名高等学府和公司的精英人才。公司虽然正处在起步阶段，但在创立后这短短的时间内，已成功获得了众多风险投资的青睐。</p>
			<div class="clear"></div>
			<hr>
            
            <img alt="join" style="width:150px;height:150px;" src="dist/img/recruit-join.jpg">
            <h2 id="join">加入斯多克</h2>
            <p class="lead">　　斯多克科技只选择在金融和科技领域<span style="color:#EE4000;">~~最杰出~~</span>的人才。欢迎有志于在互联网金融大潮中有所作为的朋友加入斯多克。</p>
            <div class="clear"></div>
	          <h3 >我们向您提供的：</h3>
	          <p >　短期回报：业内极具竞争力的薪水，使你可以体面地生活着</p>
	          <p >　长期回报：有诚意的期权股票，使你可以分享公司的成长</p>
	          <p >　短期回报：业内极具竞争力的薪水</p>
	          <p >　短期回报：业内极具竞争力的薪水</p>
	          <p >　短期回报：业内极具竞争力的薪水</p>
	          <p >　短期回报：业内极具竞争力的薪水</p>
	          
	          <h3 >我们希望您具有的：</h3>
	          <p >　无限的激情：我们希望你是一个充满梦想，满怀激情的好搭档</p>
	          <p >　强大的实力：对于我们的团队而言，我们希望你可以雪中送炭，而非锦上添花</p>
	          <p >　开阔的视野：我们希望你具有开阔的视野，对专业领域有较为深刻的见解，能够让工作具有预见性</p>
	          <p >　可怕的执行力：我们非常欣赏具有超强行动力的人，因为我们就是这种人</p>
	          
	          <p class="lead">如果您有意加入我们，请发邮件到下面的邮箱，并在邮件标题上注明应聘方向</p>
	          <p class="lead">Mail： <a href="mailto:istocktech@163.com" target="_blank">istocktech@163.com</a></p>
            <div class="clear"></div>
            <hr>
            
            <img alt="position" style="width:150px;height:150px;" src="dist/img/recruit-position.png">
            <h2 id="position">在招职位</h2>
            <p>文案文案文案~~~斯多克欢迎你的加入</p>
            <table class="table table-striped">			   
			   <tbody>
			      <tr>
			         <td>类别</td>
			         <td>财务</td>
			         <td>Web研发</td>
			      </tr>
			      <tr>
			         <td>1</td>
			         <td>高级财务经理</td>
			         <td>Web前端工程师</td>
			      </tr>
			      <tr>
			         <td>2</td>
			         <td>财务总监</td>
			         <td>高级Web工程师</td>
			      </tr>
			   </tbody>
			</table>
			<br><br>
	        <div class="clear"></div>
	        <hr>
            
            <img alt="contact" style="width:150px;height:150px;" src="dist/img/recruit-contact.png">
            <h2 id="contact">联系我们</h2>
            <p class="lead">　　斯多克致力于投资智能化，旨在为广大客户提供智能化的决策，最贴心的服务，如果你相信科技的力量，并愿意为未来投资，我们乐意一起携手前行。</p>
          	<ul class="list-unstyled">
		    	<li>QQ: xxxxxxx</li>
		        <li>Mail: <a href="mailto:istocktech@163.com" target="_blank">istocktech@163.com</a></li>
		    </ul>
		    <div class="clear"></div>
		    <br><br>
        </div>
    </div>
</div>
<s:include value="_footer.jsp"></s:include>
<script type="text/javascript" language="javascript" src="dist/js/jquery.min.js" ></script>
<script type="text/javascript" language="javascript" src="dist/js/bootstrap.min.js"></script>	
<script type="text/javascript" language="javascript" src="dist/js/site.effect.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    $("#myNav").affix({
        offset: { 
            top: 125 
     	}
    });
});
</script>
</body>
</html>

