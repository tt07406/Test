<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="front/img/icon_stockii_square.png">
<title>斯多克-Moto定制版</title>
<link href="front/css/bootstrap.css" rel="stylesheet">
<link href="front/css/global-style.css" rel="stylesheet">
<link href="front/css/index.css" rel="stylesheet">
<link href="front/css/font-awesome.css" rel="stylesheet">
<link href="front/css/weather.css" rel="stylesheet">
<style type="text/css">
iframe{position: absolute;top:60px;left:75%;}
</style>
</head>
<body>
	<s:include value="header.jsp">  
	<s:param name="index">index</s:param>  
	</s:include>
	<div class="container container-content" style="padding: 80px 0px;">
		<!-- weather -->
		<iframe allowtransparency="true" frameborder="0" width="410" height="98" scrolling="no" src="http://tianqi.2345.com/plugin/widget/index.htm?s=2&z=1&t=1&v=0&d=2&bd=0&k=000000&f=&q=1&e=1&a=1&c=54511&w=410&h=98&align=center"></iframe>
		
		<div class="row info-list">
			<div class="col-md-2">
				<label>姓名</label>
			</div>
			<div class="col-md-8">
				 <input type="text" class="form-control" id="config.name" placeholder="您的姓名">
			</div>
		</div>
		<div class="row info-list">
			<div class="col-lg-2">
				<label>身份证号码/护照</label>
			</div>
			<div class="col-lg-8">
				 <input type="text" class="form-control" id="config.id" placeholder="您的身份信息">
			</div>
		</div>
		
		<div class="row info-list">
			<div class="col-lg-2">
				<label>域名</label>
			</div>
			<div class="col-lg-8">
				 <input type="text" class="form-control" id="config.doName" placeholder="您的域名是？">
			</div>
		</div>
		
		<div class="row info-list">
			<div class="col-lg-2">
				<label>我的SSID</label>
			</div>
			<div class="col-lg-8">
				 <input type="text" class="form-control" id="config.ssid" placeholder="" readonly="readonly">
			</div>
		</div>
		
		<div class="row info-list">
			<button class="btn btn-success" onclick="saveInfo();">提交</button>
		</div>
		
	</div>
	
	<s:include value="footer.jsp"></s:include>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="front/js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="front/js/bootstrap.js"></script>
    <!-- weather -->
    <!-- <script src="http://lab.wangyuanwai.com/weather/v3/jquery.weather.build.min.js?parentbox=body&moveArea=all&moveArea=limit&zIndex=10&move=1&move=0&drag=1&drag=0&autoDrop=0&autoDrop=1&styleSize=big&style=cartoon-1&time=1412499016&area=client"></script> -->
<script type="text/javascript">
       function saveInfo(){
       		var id = document.getElementById("config.id").value; 
       		var name =document.getElementById("config.name").value; 
       		var doName = document.getElementById("config.doName").value; 
			var str = "{\"config.id\":\""+id+"\",\"config.name\":\""+name+"\",\"config.doName\":\""+doName+"\"}";

			
		$.ajax({
	  			type: "post",//使用get方法访问后台
	            dataType: "json",//返回json格式的数据
	            url: "interface/saveInfo.action",//要访问的后台地址
	            data: "content="+str,//要发送的数据
	            success: function(data){//msg为返回的数据，在这里做数据绑定
	                alert(data.msg);
				},
				error: function(data){//msg为返回的数据，在这里做数据绑定
	                alert(data.msg);
				}
			});
       }   
       function loadInfo(){
		$.ajax({
  			type: "post",//使用get方法访问后台
            dataType: "json",//返回json格式的数据
            url: "interface/readConfig.action",//要访问的后台地址
            success: function(data){//msg为返回的数据，在这里做数据绑定
                document.getElementById("config.id").value = data.configId;
				document.getElementById("config.name").value = data.configName; 
				document.getElementById("config.doName").value = data.configDoName;
				document.getElementById("config.ssid").value = data.configSSID;
			}
		});
		
	}
$(document).ready(function(){
  		loadInfo();
});
</script>
 </body>
 
</html>