<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head><title>权限列表</title>
<style type="text/css">
<!--
.STYLE6 {font-size: 12px}
.STYLE10 {font-size: 14px; font-weight: bold; }
-->
</style>
</head>
	<script language="javascript">
		function changeColor(obj,color){
			obj.bgColor = color ;
		}
		function doDelete(){
			if(window.confirm("确认删除？")){
				return true ;
			} else {
				return false ;
			}
		}
		function show(thisurl){
			window.open(thisurl,"新闻发布系统","widht=500,height=370,scrollbars=yes,resizeable=no") ;
		}
	</script>
<body>

<center>
	<h1>权限列表</h1>
<TABLE BORDER="1" cellpadding="5" cellspacing="0" bgcolor="F2F2F2" width="100%">
	<TR onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td align="center" valign="middle"><span class="STYLE10">编号</span></td>
		<td align="center" valign="middle"><span class="STYLE10">身份证号</span></td>
		<td align="center" valign="middle"><span class="STYLE10">授权ID</span></td>
		<td align="center" valign="middle"><span class="STYLE10">权限等级</span></td>
		<td align="center" valign="middle" colspan="2"><span class="STYLE10">操作</span></td>
	</TR>
<s:iterator value="all" var="item">
	<TR onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td align="center" valign="middle"><span class="STYLE6">${item.permissionId}</span></td>
		<td align="center" valign="middle"><span class="STYLE6"><a href="#" onclick="show('Permission_show.action?permissionid=${item.permissionId}')">${item.idNumber}</a></span></td>
		<td align="center" valign="middle"><span class="STYLE6">${item.authenticationId}</span></td>
		<td align="center" valign="middle"><span class="STYLE6">${item.permissionLevel}</span></td>
		<td align="center" valign="middle"><span class="STYLE6">
			<a href="Permission_updatepre.action?permissionid=${item.permissionId}">修改</a>
		</span></td>
		<td align="center" valign="middle"><span class="STYLE6">
			<a href="Permission_delete.action?permissionid=${item.permissionId}" onclick="return doDelete()">删除</a>
		</span></td>
	</TR>
</s:iterator>
</table>
</center>
</body>
</html>