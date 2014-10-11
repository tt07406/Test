<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf--">
<title>个人定制版 -- 资料</title>
<link href="front/css/bootstrap.css" rel="stylesheet">
<link href="front/css/jquery-ui.min.css" rel="stylesheet">
<link href="front/css/global-style.css" rel="stylesheet">
<link href="front/css/infoedit.css" rel="stylesheet">
</head>
<body>
<s:include value="header.jsp"></s:include>
<div class="bd">
<!-- 基本信息 -->
<div class="infoblock">
	<form action="" class="info_title" id="baseinfo_block">
		<div class="s_line2">
			<hr>
			<div class="title">基本信息</div>
			<div class="btn" data-target="baseinfo"><a href="javascript:sendinfo('baseinfo_block');">编辑</a></div>
		</div>		
	</form>
	<div data-info="baseinfo">
		<div class="pf_item">
			<div class="lable">登录名</div>
			<div class="con">huaj****nian@sina.cn</div>
		</div>
		<div class="pf_item">
			<div class="lable">昵称</div>
			<div class="con">spell</div>
		</div>
		<div class="pf_item">
			<div class="lable">真实姓名</div>
			<div class="con">尚未编辑<a href=""><span>马上填写</span></a></div>			
		</div>		
		<div class="pf_item">
			<div class="lable">性别</div>
			<div class="con">女<a href=""><span>马上填写</span></a></div>
		</div>
		<div class="pf_item">
			<div class="lable">性取向</div>
			<div class="con">尚未编辑<a href=""><span>马上填写</span></a></div>
		</div>
		<div class="pf_item">
			<div class="lable">感情状况</div>
			<div class="con">单身</div>
		</div>
		<div class="pf_item">
			<div class="lable">生日</div>
			<div class="con">尚未编辑<a href=""><span>马上填写</span></a></div>
		</div>
		<div class="pf_item">
			<div class="lable">血型</div>
			<div class="con">尚未编辑<a href=""><span>马上填写</span></a></div>
		</div>
		<div class="pf_item">
			<div class="lable">博客地址</div>
			<div class="con">尚未编辑<a href=""><span>马上填写</span></a></div>
		</div>
		<div class="pf_item">
			<div class="lable">个性域名</div>
			<div class="con">尚未编辑<a href=""><span>马上填写</span></a></div>
		</div>
		<div class="pf_item">
			<div class="lable">简介</div>
			<div class="con">尚未编辑<a href=""><span>马上填写</span></a></div>
		</div>
		<div class="pf_item">
			<div class="lable">注册时间</div>
			<div class="con">2014-10-06</div>
		</div>
	</div>
</div><!-- ./ 基本信息 -->

<!-- 联系方式 -->
<div class="infoblock">
	<form action="" class="info_title">
		<div class="s_line2">
			<hr>
			<div class="title">联系信息</div>
			<div class="btn" data-target="concatinfo"><a href="javascript:sendinfo('concatinfo_block');">编辑</a></div>
		</div>		
	</form>
	<div data-info="concatinfo">
		<div class="pf_item">
			<div class="lable">邮箱</div>
			<div class="con">huaj****nian@sina.cn</div>
		</div>
		<div class="pf_item">
			<div class="lable">QQ</div>
			<div class="con">01234567</div>
		</div>
		<div class="pf_item">
			<div class="lable">MSN</div>
			<div class="con">尚未编辑<a href=""><span>马上填写</span></a></div>			
		</div>
		<div class="pf_item">
			<div class="lable">所在地</div>
			<div class="con">尚未编辑<a href=""><span>马上填写</span></a></div>	
			<div id="city" style="display: none;position: relative;left:77px;top:-28px;"> 
			    <select class="prov"></select>  
			    <select class="city" disabled="disabled"></select> 
			    <select class="dist" disabled="disabled"></select> 
			</div> 	 
		</div>
	</div>
</div><!-- ./联系方式 -->

<!-- 职业 -->
<div class="infoblock">
	<form action="" class="info_title">
		<div class="s_line2">
			<hr>
			<div class="title">职业信息</div>
			<div class="btn" data-target="careerinfo"><a href="javascript:sendinfo('careerinfo_block');">编辑</a></div>
		</div>		
	</form>
	<div data-info="careerinfo">
		<div class="tag_panel" style="display: none;">
				<div class="pf_item lable">标签</div>
				<div class="tag_area"><span></span></div>
				<div class="like">你可能喜欢的标签:
					<div class="tag tag_add"><em class="left">&#9670;</em><span class="right">&#9670;</span><span class="icon-plus">+</span>硬件设计师</div>
					<div class="tag tag_add"><em class="left">&#9670;</em><span class="right">&#9670;</span><span class="icon-plus">+</span>架构师</div>
					<div class="tag tag_add"><em class="left">&#9670;</em><span class="right">&#9670;</span><span class="icon-plus">+</span>交互式设计</div>
				</div>
			</div>	
		<div class="pf_item">				
			<div class="tag"><em class="left">&#9670;</em><span class="right">&#9670;</span>软件工程师</div>
		</div>		
	</div>
</div><!-- ./ 职业 -->

<!-- 教育 -->
<div class="infoblock">
	<form action="" class="info_title">
		<div class="s_line2">
			<hr>
			<div class="title">教育信息</div>
			<div class="btn" data-target="educationinfo"><a href="javascript:sendinfo('educationinfo_block');">编辑</a></div>
		</div>		
	</form>
	<div data-info="educationinfo">
		<div class="pf_item">
			<div class="lable">大学</div>
			<div class="con">北京邮电大学</div>
		</div>
	</div>	
</div><!-- ./ 教育 -->
</div>
<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript" src="front/js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="front/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="front/js/bootstrap.js"></script>
<script type="text/javascript" src="front/js/jquery.cityselect.js"></script> 
<script type="text/javascript">
//全局变量
var GLOBAL={};
//全局变量的命名空间函数
GLOBAL.namespace=function(str){
	var arr=str.split("."),o=GLOBAL;
	for(var i=(arr[0]="GLOBAL")?1:0;1<arr.length;i++){
		o[arr[i]]=o[arr[i]] || {};
		o=o[arr[i]];
	}
};
GLOBAL.namespace("FORM");
//GLOBAL.namespace("INDEX");
GLOBAL.index_btn=0;
GLOBAL.baseinfo={
		login_name:"",
		nick_name:"",
		real_name:"",
		sex:"",
		sex_dir:"",
		emotion:"",
		birthday:"",
		blood:"",
		blog_address:"",
		domain:"",
		profile:"",
		sign_date:""
};
GLOBAL.concatinfo={
		email:"",
		QQ:"",
		MSN:"",
		address:""
};
GLOBAL.careerinfo=[];//tagSet
GLOBAL.educationinfo={
		school:""
};

/*页面编辑和保存*/
$("div.btn").on({
	"click":function(){
		var data_target=$(this).attr("data-target");
		var infoObj=$("div[data-info="+data_target+"]");
		var pf_itemObjs=$("div[data-info="+data_target+"]").children();		
		if(GLOBAL.index_btn==0){
			$(this).children().html("保存");			
			if(data_target.match("baseinfo")){
				baseinfo_edit(infoObj,pf_itemObjs);
			}else if(data_target.match("careerinfo")){
				//alert("career");
			}else if(data_target.match("educationinfo")){
				//alert("education");
			}else if(data_target.match("concatinfo")){
				//alert("concat");
				concatinfo_edit(infoObj,pf_itemObjs);
			}
			
			//针对职业信息--标签的编辑形式  
			if(data_target.match("careerinfo")){				
				infoObj.children(".tag_panel").css({"display":"block"});
				var defaultTag=infoObj.children(".pf_item").children(".tag");
				defaultTag.each(function(){
					$(this).append("<span class='icon-plus'>x</span>");
					$(this).addClass("tag_cut");
				});
				infoObj.children(".tag_panel").children(".tag_area").append(defaultTag);
				
				//增加标签
				$(".tag_add").one("click",function(){
					var $thisObj=$(this).clone();
					$thisObj.children(".icon-plus").remove();
					$thisObj.addClass("tag_cut");
					$thisObj.append("<span class='icon-plus'>x</span>");
					infoObj.children(".tag_panel").children(".tag_area").append($thisObj);
					$(this).css({"background":"#F9F9F9"});
					//删除新增加的标签
					$(".tag_cut").on("click",function(){
						$(this).remove();
						return false;
					});
				});
				//删除原始的标签
				$(".tag_cut").on("click",function(){
					$(this).remove();
					return false;
				});
				
			}
			GLOBAL.index_btn=1;
		}else{
			$(this).children().html("编辑");			
			if(data_target.match("baseinfo")){
				baseinfo_save(infoObj,pf_itemObjs);
			}else if(data_target.match("careerinfo")){
				//alert("career");
			}else if(data_target.match("educationinfo")){
				//alert("education");
			}else if(data_target.match("concatinfo")){
				//alert("concat");
				concatinfo_save(infoObj,pf_itemObjs);
			}
			// 针对职业信息--标签的改动 
			if(data_target.match("careerinfo")){
				var tagSet=infoObj.children(".tag_panel").children(".tag_area").children(".tag");
				if(tagSet.length==0){
					infoObj.children(".pf_item").html("你没有选择相应的标签。快来<a>添加</a>吧~~");
					infoObj.children(".pf_item").children("a").on("click",function(){
						alert("aaa");
					});
					infoObj.children(".tag_panel").css({"display":"none"});
				}else{
					tagSet.each(function(){
						$($(this).children(".icon-plus")).remove();
					});
					infoObj.children(".pf_item").append(tagSet);
					infoObj.children(".tag_panel").css({"display":"none"});
				}				
			}
			
			//浮动显示“保存成功”提示
			var imgObj = $("<img alt='save success' src='front/img/tip_save_success.png'>").css("position", "absolute")
                				.css("top", parseInt($(this).offset().top)+30+"px").css("left", parseInt($(this).offset().left)-30+"px"); 
			$("body").append(imgObj);
			setTimeout(function(){				
				$(imgObj).remove();
			}, 1000);			
			GLOBAL.index_btn=0;
		}
		
	}
});
/* ./end 页面编辑和保存*/


/* base info edit  */
function baseinfo_edit(self,children){
	var $this=self;
	var pf_item_set=children;
	pf_item_set.each(function(){
		/* 创建新元素 */
		var txt=$(this).children(".con").text();		
		var inputObj = $("<input data-name='aa' type='text'>").css({"width":"200px","height":"28px","line-height":"13.5px","padding":"0 5px 0","margin-left":"0"}).val(txt); 
		if(txt.match("马上填写")){
			inputObj.val("");
		}	
		var index=$(this).index();
		switch(index){
			case 0:/*登录名*/break;
			case 1:	/*昵称*/
				$(this).children(".con").html("");
				$(this).children(".con").append(inputObj);
				break;
			case 2:/*真实姓名*/
				$(this).children(".con").html("");
				$(this).children(".con").append(inputObj);
				break;
			case 3:/*性别*/
				$(this).children(".con").html("");
				var sexchoiceObj=$("<select><option value='man'>男</option><option value='woman'>女</option></select>").css({"width":"50px","height":"28px","text-align":"center"});				
				$(this).children(".con").append(sexchoiceObj);
				break;
			case 4:/*性取向*/
				$(this).children(".con").html("");
				var sexdirObj=[$("<input type=\"checkbox\" value=\"man\">男<span></span>").css({"height":"28px","font-size":"12px","color":"#333"}),$("<input type=\"checkbox\" value=\"woman\">女<span></span>").css({"height":"28px","font-size":"12px","color":"#333"})];				
				$(this).children(".con").append(sexdirObj);		
				break;
			case 5:/*感情状况*/
				$(this).children(".con").html("");
				var emotionObj=$("<select><option value='single'>单身</option><option value='married'>已婚</option><option value='divorce'>离婚</option></select>").css({"width":"70px","height":"28px","text-align":"center"});	
				$(this).children(".con").append(emotionObj);		
				break;
			case 6:/*生日*/
				$(this).children(".con").html("");
				var dataObj=$("<input type='text' id='datepicker'>").css({"width":"200px","height":"28px","line-height":"13.5px","padding":"0 5px 0","margin-left":"0"});
				$(this).children(".con").append(dataObj);	
				$( "#datepicker" ).datepicker({
				      changeMonth: true,
				      changeYear: true
				    });
				break;
			case 7:/*血型*/
				$(this).children(".con").html("");
				var bloodObj=$("<select><option value='single'></option><option value='A'>A型</option><option value='B'>B型</option><option value='AB'>AB型</option><option value='O'>O型</option></select>").css({"width":"70px","height":"28px","text-align":"center"});	
				$(this).children(".con").append(bloodObj);	
				break;
			case 8:/*博客地址*/
				$(this).children(".con").html("");
				$(this).children(".con").append(inputObj);
				break;
			case 9:/*个性域名*/
				$(this).children(".con").html("");
				$(this).children(".con").append(inputObj);
				$(this).children(".con").append($("<span style='display:none;'>请填写正确的域名</span>")
												.css({"font-size":"12px","color":"#666666","height":"28px","width":"300px","line-height":"13.5px","padding":"6px 5px 6px","background":"#F7F9FF","border":"1px solid #BED2ED","margin-left":"20px"}));
				$(inputObj).focus(function(){
					$(this).next().css("display","inline");
				});
				$(inputObj).blur(function(){
					$(this).next().css("display","none");
				});
				break;
			case 10:/*简介*/
				var textareaObj=$("<textarea rows='1' cols='20'></textarea>").css({"height":"28px","line-height":"13.5px","padding":"5px 5px 5px","margin":"0"}); 
				$(this).children(".con").html("");
				$(this).children(".con").append(textareaObj);
				break;
			case 11:/*注册时间*/
				break;
		}		
	});
}/* ./end base info edit  */

/* base info save  */
function baseinfo_save(self,children){
	var $this=self;
	var pf_item_set=children;
	pf_item_set.each(function(){
		var index=$(this).index();
		switch(index){
			case 0:/*登录名*/
				break;
			case 1:/*昵称*/
				var inputTxt=$(this).children(".con").children("input").val();
				GLOBAL.baseinfo.nick_name=inputTxt;
				$(this).children(".con").html(inputTxt);
				if(inputTxt==""){
					$(this).children(".con").html("尚未编辑<a href='javascript:void(0)'><span>马上填写</span></a>");
				}				
				$(this).children(".con").children("input").remove();
				break;
			case 2:/*真实姓名*/
				var inputTxt=$(this).children(".con").children("input").val();
				GLOBAL.baseinfo.real_name=inputTxt;
				$(this).children(".con").html(inputTxt);
				if(inputTxt==""){
					$(this).children(".con").html("尚未编辑<a href='javascript:void(0)'><span>马上填写</span></a>");
				}				
				$(this).children(".con").children("input").remove();
				break;
			case 3:/*性别*/
				var selectObj=$(this).children(".con").children("select");				
				var inputTxt=selectObj[0].options[selectObj[0].selectedIndex].text;
				GLOBAL.baseinfo.sex=inputTxt;
				$(this).children(".con").html(inputTxt);
				if(inputTxt==""){
					$(this).children(".con").html("尚未编辑<a href='javascript:void(0)'><span>马上填写</span></a>");
				}				
				$(this).children(".con").children("select").remove();
				break;
			case 4:/*性取向*/
				var checkboxObj=$(this).children(".con").children("input[type='checkbox']");
				var inputTxt="";
				for(var i=0;i<checkboxObj.length;i++){
					if(checkboxObj[i].checked){
						if($(checkboxObj[i]).val().match("woman")){
							inputTxt=inputTxt+" 女 ";
						}else{
							inputTxt=inputTxt+" 男 ";
						}				
					}
				}
				GLOBAL.baseinfo.sex_dir=inputTxt;
				$(this).children(".con").html(inputTxt);
				if(inputTxt==""){
					$(this).children(".con").html("尚未编辑<a href='javascript:void(0)'><span>马上填写</span></a>");
				}				
				$(this).children(".con").children("select").remove();
				break;
			case 5:/*感情状态*/
				var selectObj=$(this).children(".con").children("select");
				var inputTxt=selectObj[0].options[selectObj[0].selectedIndex].text;
				GLOBAL.baseinfo.emotion=inputTxt;
				$(this).children(".con").html(inputTxt);
				if(inputTxt==""){
					$(this).children(".con").html("尚未编辑<a href='javascript:void(0)'><span>马上填写</span></a>");
				}				
				$(this).children(".con").children("select").remove();
				break;
			case 6:/*生日*/
				var inputTxt=$(this).children(".con").children("input").val();
				GLOBAL.baseinfo.birthday=inputTxt;
				$(this).children(".con").html(inputTxt);
				if(inputTxt==""){
					$(this).children(".con").html("尚未编辑<a href='javascript:void(0)'><span>马上填写</span></a>");
				}				
				$(this).children(".con").children("input").remove();
				break;
			case 7:/*血型*/
				var selectObj=$(this).children(".con").children("select");
				var inputTxt=selectObj[0].options[selectObj[0].selectedIndex].text;
				GLOBAL.baseinfo.blood=inputTxt;
				$(this).children(".con").html(inputTxt);
				if(inputTxt==""){
					$(this).children(".con").html("尚未编辑<a href='javascript:void(0)'><span>马上填写</span></a>");
				}				
				$(this).children(".con").children("select").remove();
				break;
			case 8:/*博客地址*/
				var inputTxt=$(this).children(".con").children("input").val();
				GLOBAL.baseinfo.blog_address=inputTxt;
				$(this).children(".con").html(inputTxt);
				if(inputTxt==""){
					$(this).children(".con").html("尚未编辑<a href='javascript:void(0)'><span>马上填写</span></a>");
				}				
				$(this).children(".con").children("input").remove();
				break;
			case 9:/*个性域名*/
				var inputTxt=$(this).children(".con").children("input").val();
				GLOBAL.baseinfo.blog_address=inputTxt;
				$(this).children(".con").html(inputTxt);
				if(inputTxt==""){
					$(this).children(".con").html("尚未编辑<a href='javascript:void(0)'><span>马上填写</span></a>");
				}				
				$(this).children(".con").children("input").remove();
				break;
			case 10:/*简介*/
				var inputTxt=$(this).children(".con").children("textarea").val();
				GLOBAL.baseinfo.profile=inputTxt;
				$(this).children(".con").html(inputTxt);
				if(inputTxt==""){
					$(this).children(".con").html("尚未编辑<a href='javascript:void(0)'><span>马上填写</span></a>");
				}				
				$(this).children(".con").children("textarea").remove();
				break;
			case 11:/*注册时间*/
				break;
		}
	});
}/* ./end base info save*/


/* concat info edit */
function concatinfo_edit(self,children){
	var $this=self;
	var pf_item_set=children;
	var $this=self;
	var pf_item_set=children;
	pf_item_set.each(function(){
		var txt=$(this).children(".con").text();		
		var inputObj = $("<input data-name='aa' type='text'>").css({"width":"200px","height":"28px","line-height":"13.5px","padding":"0 5px 0","margin-left":"0"}).val(txt); 
		if(txt.match("马上填写")){
			inputObj.val("");
		}	
		var index=$(this).index();
		switch(index){
			case 0:/*邮箱*/
				$(this).children(".con").html("");
				$(this).children(".con").append(inputObj);
				break;
			case 1:/*QQ*/
				$(this).children(".con").html("");
				$(this).children(".con").append(inputObj);
				break;
			case 2:/*MSN*/
				$(this).children(".con").html("");
				$(this).children(".con").append(inputObj);
				break;
			case 3:/*地址*/		
				$("#city").css("display","inline-block");
				$("#city").citySelect({  
				    url:"front/js/city.min.js",  
				    prov:"北京", //省份 
				    city:"东城区", //城市 
				    //dist:"岳麓区", //区县 
				    nodata:"none" //当子集无数据时，隐藏select 
				});
				$(this).children(".con").html("");
				break;
		}
	});
}/* ./end concat info edit */

/* concat info save */
function concatinfo_save(self,children){
	var $this=self;
	var pf_item_set=children;
	pf_item_set.each(function(){
		var index=$(this).index();
		switch(index){
			case 0:/*邮箱*/
				var inputTxt=$(this).children(".con").children("input").val();
				GLOBAL.concatinfo.email=inputTxt;
				$(this).children(".con").html(inputTxt);
				if(inputTxt==""){
					$(this).children(".con").html("尚未编辑<a href='javascript:void(0)'><span>马上填写</span></a>");
				}				
				$(this).children(".con").children("input").remove();
				break;
			case 1:/*QQ*/
				var inputTxt=$(this).children(".con").children("input").val();
				GLOBAL.concatinfo.QQ=inputTxt;
				$(this).children(".con").html(inputTxt);
				if(inputTxt==""){
					$(this).children(".con").html("尚未编辑<a href='javascript:void(0)'><span>马上填写</span></a>");
				}				
				$(this).children(".con").children("input").remove();
				break;
			case 2:/*MSN*/
				var inputTxt=$(this).children(".con").children("input").val();
				GLOBAL.concatinfo.MSN=inputTxt;
				$(this).children(".con").html(inputTxt);
				if(inputTxt==""){
					$(this).children(".con").html("尚未编辑<a href='javascript:void(0)'><span>马上填写</span></a>");
				}				
				$(this).children(".con").children("input").remove();
				break;
			case 3:/*地址*/
				var inputTxt="";				
				var selectObj=$(this).children("#city").children("select");
				$(selectObj).each(function(){
					if($(this).attr("disabled")=="disabled"){
						inputTxt+="";
					}else{
						inputTxt+=$(this)[0].options[$(this)[0].selectedIndex].text+"　";
					}
				});
				GLOBAL.concatinfo.address=inputTxt;
				$(this).children(".con").html(inputTxt);
				$("#city").css("display","none");
				break;
		}
	});
}/* ./end concat info save */

/* career info edit */


/* global edit */
function global_edit(){
	var txt=$(this).children(".con").text();
	$(this).children(".con").html("");
	var inputObj = $("<input data-name='aa' type='text'>").css("width", "200px").css("height","28px").css("line-height","13.5px").
											css("padding","0 5px 0").css("margin-left","10px").val(txt); 
	if(txt.match("马上填写")){
		inputObj.val("");
	}
	$(this).children(".con").append(inputObj);
}/*./end global edit */
</script>

<script type="text/javascript">
function sendinfo(id){	

	if(id.match("baseinfo")){		
		//send message
		ajaxSend(GLOBAL.baseinfo);
	}else if(id.match("concatinfo")){
		//console.log("concat");
		ajaxSend(GLOBAL.concatinfo);
	}else if(id.match("careerinfo")){
		//console.log("career");
		ajaxSend(GLOBAL.careerinfo);
	}else if(id.match("educationinfo")){
		//console.log("education");
		ajaxSend(GLOBAL.educationinfo);
	}
}

function ajaxSend(info){

	if(GLOBAL.index_btn==1){
		return;
	}
	var str = JSON.stringify(info);

	$.ajax({
  			type: "post",//使用get方法访问后台
            dataType: "json",//返回json格式的数据
            url: "interface/saveInfo.action",//要访问的后台地址
            data: "content="+str,//要发送的数据
            success: function(data){//msg为返回的数据，在这里做数据绑定
                //alert(data.msg);
			},
			error: function(data){//msg为返回的数据，在这里做数据绑定
                alert(data.msg);
			}
		});
}

function XMLHttpRequestCreat(){
	var xmlhttp;
	if (window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	}else{// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xmlhttp;
}
</script>
</body>
</html>