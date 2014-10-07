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
</head>
<body>
<s:include value="header.jsp"></s:include> 	
<div id="add_bd">
<p>发布文章</p>
<div class="title"><label>标题</label><input type="text"></div>
<!-- toolbar -->
<div class="btn-toolbar" data-role="editor-toolbar" data-target="#editor">
      <div class="btn-group">
        <a class="btn dropdown-toggle" data-toggle="dropdown" title="" data-original-title="Font"><i class="icon-font"></i><b class="caret"></b></a>
          <ul class="dropdown-menu">
          <li><a data-edit="fontName Serif" style="font-family:&#39;Serif&#39;">Serif</a></li><li><a data-edit="fontName Sans" style="font-family:&#39;Sans&#39;">Sans</a></li><li><a data-edit="fontName Arial" style="font-family:&#39;Arial&#39;">Arial</a></li><li><a data-edit="fontName Arial Black" style="font-family:&#39;Arial Black&#39;">Arial Black</a></li><li><a data-edit="fontName Courier" style="font-family:&#39;Courier&#39;">Courier</a></li><li><a data-edit="fontName Courier New" style="font-family:&#39;Courier New&#39;">Courier New</a></li><li><a data-edit="fontName Comic Sans MS" style="font-family:&#39;Comic Sans MS&#39;">Comic Sans MS</a></li><li><a data-edit="fontName Helvetica" style="font-family:&#39;Helvetica&#39;">Helvetica</a></li><li><a data-edit="fontName Impact" style="font-family:&#39;Impact&#39;">Impact</a></li><li><a data-edit="fontName Lucida Grande" style="font-family:&#39;Lucida Grande&#39;">Lucida Grande</a></li><li><a data-edit="fontName Lucida Sans" style="font-family:&#39;Lucida Sans&#39;">Lucida Sans</a></li><li><a data-edit="fontName Tahoma" style="font-family:&#39;Tahoma&#39;">Tahoma</a></li><li><a data-edit="fontName Times" style="font-family:&#39;Times&#39;">Times</a></li><li><a data-edit="fontName Times New Roman" style="font-family:&#39;Times New Roman&#39;">Times New Roman</a></li><li><a data-edit="fontName Verdana" style="font-family:&#39;Verdana&#39;">Verdana</a></li></ul>
        </div>
      <div class="btn-group">
        <a class="btn dropdown-toggle" data-toggle="dropdown" title="" data-original-title="Font Size"><i class="icon-text-height"></i>&nbsp;<b class="caret"></b></a>
          <ul class="dropdown-menu">
          <li><a data-edit="fontSize 5"><font size="5">大号字体</font></a></li>
          <li><a data-edit="fontSize 3"><font size="3">中号字体</font></a></li>
          <li><a data-edit="fontSize 1"><font size="1">小号字体</font></a></li>
          </ul>
      </div>
      <div class="btn-group">
        <a class="btn" data-edit="bold" title="" data-original-title="Bold (Ctrl/Cmd+B)"><i class="icon-bold"></i></a>
        <a class="btn" data-edit="italic" title="" data-original-title="Italic (Ctrl/Cmd+I)"><i class="icon-italic"></i></a>
        <a class="btn" data-edit="strikethrough" title="" data-original-title="Strikethrough"><i class="icon-strikethrough"></i></a>
        <a class="btn" data-edit="underline" title="" data-original-title="Underline (Ctrl/Cmd+U)"><i class="icon-underline"></i></a>
      </div>
      <div class="btn-group">
        <a class="btn" data-edit="insertunorderedlist" title="" data-original-title="Bullet list"><i class="icon-list-ul"></i></a>
        <a class="btn" data-edit="insertorderedlist" title="" data-original-title="Number list"><i class="icon-list-ol"></i></a>
        <a class="btn" data-edit="outdent" title="" data-original-title="Reduce indent (Shift+Tab)"><i class="icon-indent-left"></i></a>
        <a class="btn" data-edit="indent" title="" data-original-title="Indent (Tab)"><i class="icon-indent-right"></i></a>
      </div>
      <div class="btn-group">
        <a class="btn btn-info" data-edit="justifyleft" title="" data-original-title="Align Left (Ctrl/Cmd+L)"><i class="icon-align-left"></i></a>
        <a class="btn" data-edit="justifycenter" title="" data-original-title="Center (Ctrl/Cmd+E)"><i class="icon-align-center"></i></a>
        <a class="btn" data-edit="justifyright" title="" data-original-title="Align Right (Ctrl/Cmd+R)"><i class="icon-align-right"></i></a>
        <a class="btn" data-edit="justifyfull" title="" data-original-title="Justify (Ctrl/Cmd+J)"><i class="icon-align-justify"></i></a>
      </div>
      <div class="btn-group">
		  <a class="btn dropdown-toggle" data-toggle="dropdown" title="" data-original-title="Hyperlink"><i class="icon-link"></i></a>
		    <div class="dropdown-menu input-append">
			    <input class="span2" placeholder="URL" type="text" data-edit="createLink">
			    <button class="btn" type="button">Add</button>
        </div>
        <a class="btn" data-edit="unlink" title="" data-original-title="Remove Hyperlink"><i class="icon-cut"></i></a>

      </div>
      
      <div class="btn-group">
        <a class="btn" title="" id="pictureBtn" data-original-title="Insert picture (or just drag &amp; drop)"><i class="icon-picture"></i></a>
        <input type="file" data-role="magic-overlay" data-target="#pictureBtn" data-edit="insertImage" style="opacity: 0; position: absolute; top: 0px; left: 0px; width: 37px; height: 30px;">
      </div>
      <div class="btn-group">
        <a class="btn" data-edit="undo" title="" data-original-title="Undo (Ctrl/Cmd+Z)"><i class="icon-undo"></i></a>
        <a class="btn" data-edit="redo" title="" data-original-title="Redo (Ctrl/Cmd+Y)"><i class="icon-repeat"></i></a>
      </div>
      <input type="text" data-edit="inserttext" id="voiceBtn" x-webkit-speech="" style="display: none;">
</div><!-- ./ end toolbar -->
<div id="editor" contenteditable="true">sdfdsf</div>
<button onclick="creatArt()">发布文章</button>
</div><!-- ./end eidt body -->

<s:include value="footer.jsp"></s:include>
<script type="text/javascript" src="front/js/jquery.min.js"></script>
<script type="text/javascript" src="front/js/jquery.hotkeys.js"></script>
<script type="text/javascript" src="front/js/bootstrap.js"></script>
<script type="text/javascript" src="front/js/bootstrap-wysiwyg.js"></script>
<script type="text/javascript">
$(function() {
	$('#editor').wysiwyg();	
});
/* 发布文章 */
function creatArt(){
	//alert("fgdgf");
	window.open("http://localhost:8080/Stockii%20Personal%20Temp/myarticles.jsp");
	/*var href=window.location.href.split("/");
	href=href.splice(4, 1, "demo");
	href=href.join("/");*/
}

</script>
</body>
</html>