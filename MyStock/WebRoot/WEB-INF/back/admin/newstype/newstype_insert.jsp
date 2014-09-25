<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head><title>增加新的频道</title>
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
  </style></head>
<body>
<script type="text/javascript" src="<%=request.getContextPath()%>/back/js/jquery-1.11.1.min.js">
</script>
	<script language="javascript">
		function changeColor(obj,color){
			obj.bgColor = color ;
		}
	</script>
	<script language="javascript">
		var url = "<%=request.getContextPath()%>/back" ;
	</script>
	<script language="javascript" charset="gb2312" src="<%=request.getContextPath()%>/back/js/newstype_validate.js">
	</script>
<script type="text/javascript">
	function validateAccount(value){
		validateName(value);
		$("#result").load("<%=request.getContextPath()%>/back/validateName.action",{userName:value,type:2});
	}
</script>
<center> 
<form action="NewsType_insert" method="post" onSubmit="return validate(this)" enctype="multipart/form-data">
<table border="1" width="100%" cellpadding="5" cellspacing="0" bgcolor="F2F2F2">
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td colspan="3">
			<h1>增加新的频道</h1>		</td>
	</tr>
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td><font size="2">名称：</font></td>
		<td><input type="text" name="name" onBlur="validateAccount(this.value)"><div id="result"></div></td>
		<td><span id="name_msg"><font color="RED">*</font></span></td>
	</tr>
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td><font size="2">描述：</font></td>
		<td><input type="text" name="note" onBlur="validateNote(this.value)"></td>
		<td><span id="note_msg"><font color="RED">*</font></span></td>
	</tr>
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td colspan="4">
			<input type="submit" value="添加" />
			<input type="reset" value="重置" />		</td>
	</tr>
</table>
</form>
</center>
</body>
</html>