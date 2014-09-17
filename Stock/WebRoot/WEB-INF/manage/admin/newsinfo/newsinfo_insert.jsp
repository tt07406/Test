<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head><title>增加新闻</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back/edit/themes/default/default.css">
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
</head>
<body>
<script type="text/javascript">
    function addFile(){
    var myTB = document.getElementById("myTB");
    var rowNum = myTB.rows.length-3;
    var newRow = myTB.insertRow(rowNum);
    var cells_0 = newRow.insertCell(0);
    cells_0.innerHTML = "新增附件：";
    var cells_1 = newRow.insertCell(1);
    cells_1.innerHTML = "<input type='file' name='attachment' />";
   
    }
    </script>
	<script language="javascript">
		function changeColor(obj,color){
			obj.bgColor = color ;
		}
	</script>
	<script language="javascript">
		var url = "<%=request.getContextPath()%>/back" ;
	</script>
	<script language="javascript" charset="gb2312" src="<%=request.getContextPath()%>/back/js/newsinfo_validate.js">
	</script>
	
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
				afterBlur: function(){this.sync();},
				afterChange : function() {
					$('#alreadyInput').html(this.count());
					$('#stillInput').html(2000-this.count());
				}
			});
		});

	});
	
</script>
<center> 
<form action="NewsInfo_insert" method="post" onSubmit="return validate(this)" enctype="multipart/form-data">
<table border="1" width="100%" cellpadding="5" cellspacing="0" bgcolor="F2F2F2" id="myTB">
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td colspan="4">
			<h1>增加新闻</h1>		</td>
	</tr>
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td><font size="2">标题：</font></td>
		<td><input type="text" name="name" onBlur="validateName(this.value)"></td>
		<td><span id="name_msg"><font color="RED">*</font></span></td>
	</tr>
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td><font size="2">作者：</font></td>
		<td><input type="text" name="author" onBlur="validateAuthor(this.value)"></td>
		<td><span id="author_msg"><font color="RED">*</font></span></td>
	</tr>
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td><font size="2">描述：</font></td>
		<td><input type="text" name="describe"></td>
		<td><span id="amount_msg"><font color="RED">*</font></span></td>
	</tr>
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td colspan="3"><font size="2">分类：</font></td>
	</tr>
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td colspan="3">
			<table border="0" >				
			<c:forEach items="${types}" var="newstype">
					<tr>
					<td><span class="STYLE6"><input type="checkbox" name="typeid" value="${newstype.newsTypeName}">${newstype.newsTypeName}</span></td>
					</tr>
			</c:forEach>
			</table>
		</td>
	</tr>
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td><font size="2">附件：</font></td>
		<td><input type="file" name="attachment""></td>
		<td><input type="button" value="添加" onclick="addFile()"></td>
	</tr>
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td colspan="2"><font size="2">内容：</font></td>
		<td><span id="file_msg"><font color="RED">*</font></span></td>
	</tr>
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td colspan="4">
			<div class="editor">
				<textarea id="note" name="content" style="width:650px;height:200px;visibility:hidden;">
				</textarea>你已输入<span id="alreadyInput"></span>字，还能输入<span id="stillInput"></span>字<br/>
			</div>
		</td>
	</tr>
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td colspan="4">
		    <input type="hidden" name="cp" value="<%=request.getParameter("cp")%>">
			<input type="hidden" name="ls" value="<%=request.getParameter("ls")%>">
			<input type="hidden" name="pg" value="<%=request.getParameter("pg")%>">
			<input type="submit" value="添加">
			<input type="reset" value="重置">		</td>
	</tr>
</table>
</form>
</center>
</body>
</html>