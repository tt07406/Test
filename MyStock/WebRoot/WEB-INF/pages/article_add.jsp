<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建文章</title>
<link href="front/css/bootstrap.css" rel="stylesheet">
<link href="front/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
<link href="front/css/jquery-ui.min.css" rel="stylesheet">
<link href="front/css/global-style.css" rel="stylesheet">
<link href="front/css/font-awesome.css" rel="stylesheet">
<style type="text/css">
#add_bd{width:70%;margin: 60px auto;border: 2px solid #A9BDCE;background: #FBFBFC;}
div.title{width: 90%;margin: 15px auto;}
div.title label{margin-right:20px;margin-bottom:0;display: inline-block;}
div.title input{width: 50%;margin-bottom:0;}
.btn-toolbar{width: 90%;margin: 0 auto;border: 1px solid #333;}
#editor{height: 500px;width: 90%;margin: 0 auto;border: 1px solid #333;}
#add_bd button{margin: 5px 45%;padding: 8px 15px 8px;}
</style>
<style type="text/css" rel="stylesheet">
    .source {
    width: 700px;
    font-size: 12px;
    font-family:Courier New;
    border: 1px solid #AAAAAA;
    background-color: #F0F0EE;
    padding: 5px;
    }
    .source pre {
    margin: 0;
    }
    form {
    margin: 0;
    }
    .editor {
    margin-top: 5px;
    margin-bottom: 5px;
    }
  </style>
  <script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/back/edit/lang/zh_CN.js"></script>
	<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/back/edit/kindeditor.js"></script>
	<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/back/js/jquery-1.11.1.min.js"></script>
	<script>
	var editor;
	$(document).ready(function (){
		//渲染编辑器
		KindEditor.ready(function(K) {
			editor = K.create('#note',{
				items:[
					'preview','fontname','fontsize','forecolor','hilitecolor','bold','italic','underline','strikethrough','justifyleft','justifycenter','justifyright','hr','image','emoticons','fullscreen'
				],
				uploadJson : '<%=request.getContextPath()%>/uploadAction.action',
				filterMode: true,
				resizeMode: 0,
				afterBlur: function(){this.sync();},
				afterChange : function() {
					$('#alreadyInput').html(this.count());
					$('#stillInput').html(2000-this.count());
				}
			});
		});

	});
	
</script>
</head>
<body>
<s:include value="header.jsp"></s:include> 	
<div id="add_bd">
<p>发布文章</p>
<div class="title"><label>标题</label><input type="text" id="title"></div>
<div class="title"><label>作者</label><input type="text" id="author"></div>

<div id="editor" contenteditable="true"><textarea id="note" name="content" style="width:100%;height:450px;visibility:hidden;">
				</textarea>你已输入<span id="alreadyInput"></span>字，还能输入<span id="stillInput"></span>字<br/></div>
<button onclick="creatArt()">发布文章</button>
</div><!-- ./end eidt body -->

<s:include value="footer.jsp"></s:include>
<script type="text/javascript" src="front/js/jquery.min.js"></script>
<script type="text/javascript" src="front/js/jquery.hotkeys.js"></script>
<script type="text/javascript" src="front/js/bootstrap.js"></script>
<script type="text/javascript" src="front/js/bootstrap-wysiwyg.js"></script>
<script type="text/javascript">
/* 发布文章 */
function creatArt(){
	var title = document.getElementById("title").value; 
	var author = document.getElementById("author").value;
	var content = document.getElementById("note").value;
	
	$.ajax({
  			type: "post",//使用get方法访问后台
            dataType: "json",//返回json格式的数据
            url: "interface/Article_add.action",//要访问的后台地址
            data: "name="+title+"&author="+author+"&content="+content,//要发送的数据
            success: function (data)  //服务器成功响应处理函数
            {
                    alert(data.msg);
                    window.location= "<%=request.getContextPath()%>/myarticles.action";
             },
             error: function (data)//服务器响应失败处理函数
                {
                    alert(data.msg);
                }
		});
	//alert("fgdgf");
	
	/*var href=window.location.href.split("/");
	href=href.splice(4, 1, "demo");
	href=href.join("/");*/
}

</script>
</body>
</html>