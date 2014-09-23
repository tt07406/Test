<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head><title>增加新的权限</title>
<style type="text/css">
<!--
.STYLE6 {font-size: 12px}
.STYLE10 {font-size: 14px; font-weight: bold; }
-->
</style></head>
<body>
<script type="text/javascript" src="<%=request.getContextPath()%>/back/js/jquery-1.11.1.min.js">
</script>
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
	<script language="javascript" charset="gb2312" src="<%=request.getContextPath()%>/back/js/permission_validate.js">
	</script>
<center> 
<form action="Permission_insert" method="post" onSubmit="return validate(this)">
<table border="1" width="100%" cellpadding="5" cellspacing="0" bgcolor="F2F2F2">
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td colspan="3">
			<h1>增加新的权限</h1>		</td>
	</tr>
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td><font size="2">身份证号：</font></td>
		<td><input type="text" name="idNumber" onBlur="validateID(this.value)"></td>
		<td><span id="id_msg"><font color="RED">*</font></span></td>
	</tr>
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td><font size="2">授权ID：</font></td>
		<td><input type="text" name="authenticationId" onBlur="validateAuthID(this.value)"></td>
		<td><span id="auth_msg"><font color="RED">*</font></span></td>
	</tr>
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td><font size="2">权限等级：</font></td>
		<td><s:set name="selList" value="#{1:'普通会员',2:'钻石会员',3:'白金会员'}"></s:set>
<s:select list="#selList" listKey="key" listValue="value" name="level" headerKey="0" headerValue="--请选择--"></s:select></td>
		<td><span id="level_msg"><font color="RED">*</font></span></td>
	</tr>
	<tr onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td><font size="2">备注：</font></td>
		<td><input type="text" name="cmt"></td>
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