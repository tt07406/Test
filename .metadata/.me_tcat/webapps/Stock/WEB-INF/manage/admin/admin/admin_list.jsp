<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head><title>管理员列表界面</title>
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
	<script language="javascript">
		var url = "<%=request.getContextPath()%>" ;
	</script>
	<script language="javascript" src="<%=request.getContextPath()%>/js/privilege_validate.js">
	</script>
<body>
<center>
	<h1>管理员列表</h1>
<TABLE BORDER="1" cellpadding="5" cellspacing="0" bgcolor="F2F2F2" width="100%">
	<TR onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td align="center" valign="middle"><span class="STYLE10">编号</span></td>
		<td align="center" valign="middle"><span class="STYLE10">名称</span></td>
		<td align="center" valign="middle"><span class="STYLE10">信息</span></td>
		<td align="center" valign="middle" colspan="2"><span class="STYLE10">操作</span></td>
	</TR>
<s:iterator value="all" id="admin">
	<TR onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td align="center" valign="middle"><span class="STYLE6"><a href="#" onclick="show('Admin_show.action?adminid=${admin.adminId}')">${admin.adminId}</a></span></td>
		<td align="center" valign="middle"><span class="STYLE6">${admin.adminName}</span></td>
		<td align="center" valign="middle"><span class="STYLE6">${admin.adminInfo}</span></td>
		<td align="center" valign="middle"><span class="STYLE6">
			<a href="Admin_updatepre.action?adminid=${admin.adminId}">修改</a>
		</span></td>
		<td align="center" valign="middle"><span class="STYLE6">
			<a href="Admin_delete?adminid=${admin.adminId}" onclick="return doDelete()">删除</a>
		</span></td>
	</TR>
</s:iterator>
</table>
</center>
</body>
</html>