<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head><title>增加管理员界面</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/back/js/jquery-1.11.1.min.js">
</script>
<script type="text/javascript">
	function validateAccount(value){
		validateAdminName(value);
		$("#result").load("<%=request.getContextPath()%>/manage/validateName.action",{userName:value,type:1});
	}
</script>
<style type="text/css">
<!--
.STYLE6 {font-size: 12px}
.STYLE10 {font-size: 14px; font-weight: bold; }
-->
</style></head>
<body>
	<script language="javascript">
		function changeColor(obj,color){
			obj.bgColor = color ;
		}
		function show(thisurl){
			window.open(thisurl,"新闻发布系统","widht=500,height=200,scrollbars=yes,resizeable=no") ;
		}
	</script>
	<script language="javascript">
		var url = "<%=request.getContextPath()%>/back" ;
	</script>
	<script language="javascript" charset="gb2312" src="<%=request.getContextPath()%>/back/js/admin_validate.js">
	</script>

<center> 
<form action="Admin_insert" method="post" onSubmit="return validate(this)">
<table border="1" width="100%" cellpadding="5" cellspacing="0" bgcolor="F2F2F2">
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td colspan="3">
			<h1>增加新的管理员</h1>		</td>
	</tr>
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td><font size="2">名称：</font></td>
		<td><input type="text" name="adminName" onBlur="validateAccount(this.value)"><div id="result"></div></td>
		<td><span id="adminid_msg"><font color="RED">*</font></span></td>
	</tr>
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td><font size="2">简介：</font></td>
		<td><input type="text" name="note" onBlur="validateNote(this.value)"></td>
		<td><span id="note_msg"><font color="RED">*</font></span></td>
	</tr>
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td><font size="2">密码：</font></td>
		<td><input type="password" name="password" onBlur="validatePassword(this.value)"></td>
		<td><span id="password_msg"><font color="RED">*</font></span></td>
	</tr>
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td colspan="4">
			<input type="submit" value="添加">
			<input type="reset" value="重置">		</td>
	</tr>
</table>
</form>
</center>
</body>
</html>