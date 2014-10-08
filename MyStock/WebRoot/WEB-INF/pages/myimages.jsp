<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文本提交</title>
<link href="front/css/bootstrap.css" rel="stylesheet">
<link href="front/css/jquery-ui.min.css" rel="stylesheet">
<link href="front/css/global-style.css" rel="stylesheet">
<link href="front/css/myimage.css" rel="stylesheet">
<style type="text/css">
#img-pool .thumbnail {
	width: 360px;
	height: 240px;
}

#img-pool .thumbnail > img {
	height: 233px;
}

.fileUpload
{ 
position: absolute;
margin-left:-130px;
top:8px;
opacity: 0; /*For Firefox*/ 
filter: alpha(opacity=0); /*for IE*/ 
}

</style>
<script src="front/js/ajaxfileupload.js"></script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="front/js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script type="text/javascript">
	function imgUpload(){
		$("#upfile").click();
	}
	function startUpload(value){

	   		$.ajaxFileUpload
		   (
			{
			    url: 'back/Image_upload.action',
			    secureuri: false,
			    fileElementId: 'upfile',
			    dataType: 'html',
			    beforeSend: function() {
			    	alert(value);
			        $("#loading").show();
			    },
			    complete: function() {
			        $("#loading").hide();
			    },
			    success: function(data, status) {
			        if (typeof (data.error) != 'undefined') {
			            if (data.error != '') {
			                alert(data.error);
			            } else {
			                alert(data.msg);
			            }
			        }
			    },
			    error: function(data, status, e) {
			        alert(e);
			    }
			}
			)
			return false;           
		}
</script>
</head>
<body>
<s:include value="header.jsp">  
	<s:param name="index">myimages</s:param>  
	</s:include> 	
<!-- 	
<div class="col-sm-6 col-md-4">
	<a href="#" class="thumbnail"> 
		<img src="img/icon_plus.png" alt="通用的占位符缩略图">
	</a>
</div>
-->
<div id="waterfall">
    <div class="cell"><a href="#"><img src="front/img/icon_plus.png" /></a><p><a href="javascript:void(0)" onclick="imgUpload()">图片名称</a></p></div>
    <div class="cell"><a href="#"><img src="front/img/waterfall/001.jpg" /></a><p><a href="#">图片名称</a></p></div>
    <div class="cell"><a href="#"><img src="front/img/waterfall/002.jpg" /></a><p><a href="#">图片名称</a></p></div>
    <div class="cell"><a href="#"><img src="front/img/waterfall/003.jpg" /></a><p><a href="#">图片名称</a></p></div>
    <div class="cell"><a href="#"><img src="front/img/waterfall/004.jpg" /></a><p><a href="#">图片名称</a></p></div>
    <div class="cell"><a href="#"><img src="front/img/waterfall/005.jpg" /></a><p><a href="#">图片名称</a></p></div>
    <div class="cell"><a href="#"><img src="front/img/waterfall/006.jpg" /></a><p><a href="#">图片名称</a></p></div>
    <div class="cell"><a href="#"><img src="front/img/waterfall/007.jpg" /></a><p><a href="#">图片名称</a></p></div>
    <div class="cell"><a href="#"><img src="front/img/waterfall/008.jpg" /></a><p><a href="#">图片名称</a></p></div>
    <div class="cell"><a href="#"><img src="front/img/waterfall/009.jpg" /></a><p><a href="#">图片名称</a></p></div>
    <div class="cell"><a href="#"><img src="front/img/waterfall/010.jpg" /></a><p><a href="#">图片名称</a></p></div>
    <div class="cell"><a href="#"><img src="front/img/waterfall/011.jpg" /></a><p><a href="#">图片名称</a></p></div>
    <div class="cell"><a href="#"><img src="front/img/waterfall/012.jpg" /></a><p><a href="#">图片名称</a></p></div>
    <div class="cell"><a href="#"><img src="front/img/waterfall/013.jpg" /></a><p><a href="#">图片名称</a></p></div>
    <div class="cell"><a href="#"><img src="front/img/waterfall/014.jpg" /></a><p><a href="#">图片名称</a></p></div>
    <div class="cell"><a href="#"><img src="front/img/waterfall/015.jpg" /></a><p><a href="#">图片名称</a></p></div>
    <div class="cell"><a href="#"><img src="front/img/waterfall/016.jpg" /></a><p><a href="#">图片名称</a></p></div>
    <div class="cell"><a href="#"><img src="front/img/waterfall/017.jpg" /></a><p><a href="#">图片名称</a></p></div>
    <div class="cell"><a href="#"><img src="front/img/waterfall/018.jpg" /></a><p><a href="#">图片名称</a></p></div>
    <div class="cell"><a href="#"><img src="front/img/waterfall/019.jpg" /></a><p><a href="#">图片名称</a></p></div>
    <div class="cell"><a href="#"><img src="front/img/waterfall/020.jpg" /></a><p><a href="#">图片名称</a></p></div>
</div>
<input id="upfile" type="file" size="45" name="file" onchange="return startUpload(this.value);" class="fileUpload">  
<s:include value="footer.jsp"></s:include>

<script src="front/js/bootstrap.js"></script>
<!-- waterfall flow -->
<script type="text/javascript" src="front/js/jquery.waterfall.js"></script>
<script>
//无限加载演示，可删除
var opt={
  getResource:function(index,render){//index为已加载次数,render为渲染接口函数,接受一个dom集合或jquery对象作为参数。通过ajax等异步方法得到的数据可以传入该接口进行渲染，如 render(elem)
	  /*if(index>=7) index=index%7+1;
	  var html='';
	  for(var i=20*(index-1);i<20*(index-1)+20;i++){
		 var k='';
		 for(var ii=0;ii<3-i.toString().length;ii++){
	        k+='0';
		 }
		 k+=i;
	     var src="./images/"+k+".jpg";
		 html+='<div class="cell"><a href="#"><img src="'+src+'" /></a><p>'+'duoruiao'+k+'</p></div>';
	  }*/
	  var html='';
	  var limit=20;
	  for(var i=0;i<limit;i++){
	     var src="./img/waterfall/0"+i+".jpg";
		 html+='<div class="cell"><a href="#"><img src="'+src+'" /></a><p>'+'load Picture 0'+i+'</p></div>';
	  }
	  return $(html);
  },
  auto_imgHeight:true,
  insert_type:1
}
//不可删除，里面的‘opt’参数可删除
$('#waterfall').waterfall(opt);
</script>
<script>
$(document).ready(function(){
  		$.ajax({
  			type: "post",//使用get方法访问后台
            dataType: "json",//返回json格式的数据
            url: "interface/acquireImagelist.action",//要访问的后台地址
            data: "cp=1&ls=20",//要发送的数据
            complete :function(){$("#load").hide();},//AJAX请求完成时隐藏loading提示
            success: function(msg){//msg为返回的数据，在这里做数据绑定
                var data = msg.filenames;
                var html='<div class="cell"><a href="#"><img src="front/img/icon_plus.png" /></a><p><a href="javascript:void(0)" onclick="return imgUpload();">图片名称</a></p></div>';
                $.each(data, function(i, n){
                    html+='<div class="cell"><a href="#"><img src="images/'+n+'" /></a><p>'+n+'</p></div>';
                    
                });
                $('#waterfall').html(html);
                $('#waterfall').waterfall();
			}
		});

});
</script>

</body>
</html>