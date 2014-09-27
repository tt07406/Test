<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<%
int lsData[] = {1,3,5,7,9,10,15,20,25,30,50,100} ; 
int lineSize = 10 ;		// 每次显示的记录数
try{
		lineSize = Integer.parseInt(request.getParameter("pagesize")) ;
	} catch(Exception e) {}
%>
<html>
<head><title>资料列表</title>
<style type="text/css">
<!--
.STYLE6 {font-size: 12px}
.STYLE10 {font-size: 14px; font-weight: bold; }
-->
</style>
</head>
<script type="text/javascript">
	function changeItem(pagesize) {
		var i = document.getElementById("pagesize").value;
		var k = document.getElementById("keyword").value;
		window.location.href ="Table_list.action?keyword="+ k +"&pagesize="+ i;
	}
</script>
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
			window.open(thisurl,"斯多克个人网站自助系统","widht=500,height=370,scrollbars=yes,resizeable=no") ;
		}
	</script>
<body>
<center>
	<h1>资料列表</h1>
<TABLE BORDER="1" cellpadding="5" cellspacing="0" bgcolor="F2F2F2" width="100%">
	<TR onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td align="center" valign="middle"><span class="STYLE10">表格名</span></td>
		<s:if test="#session.admin.adminLevel==10">
		<td align="center" valign="middle" colspan="2"><span class="STYLE10">操作</span></td>
		</s:if>
	</TR>
	<c:if test="${!empty pm.datas}"> 
	<c:forEach items="${pm.datas}" var="table">
	<TR onMouseOver="changeColor(this,'white')" onMouseOut="changeColor(this,'F2F2F2')">
		<td align="center" valign="middle"><span class="STYLE6"><a href="Table_download.action?filename=${table}">${table}</a></span></td>
		<s:if test="#session.admin.adminLevel==10">
		<td align="center" valign="middle"><span class="STYLE6"><a href="Table_delete.action?filename=${table}" onclick="return doDelete()">删除</a></span></td>
		</s:if>
	</TR>
	</c:forEach>
	</c:if>
</table>

			<TABLE width="778" border=0 align=center cellPadding=0 cellSpacing=0
				borderColor=#ffffff style="FONT-SIZE: 10pt">
				<TBODY>
					<TR>
						<TD><form name="spform" action="Table_list.action" method="post">关键字：
						<input type="text" id="keyword" name="keyword" value="${keyword}">

						<input type="submit" value="查询"></form></TD>
						<TD height=28 align=center vAlign=center noWrap>
							<!-- 可以在这里插入分页导航条 -->
							<pg:pager url="Table_list.action" items="${pm.total}" maxPageItems = "${pagesize}"
								export="currentPageNumber=pageNumber">
								<pg:param name="keyword" value="${keyword}"/>
								<pg:param name="pagesize" value="${pagesize}"/>
								<pg:first>
									<a href="${pageUrl}">首页</a>
								</pg:first>
								<pg:prev>
									<a href="${pageUrl}">前页</a>
								</pg:prev>
								<pg:pages>
									<c:choose>
										<c:when test="${pageNumber eq currentPageNumber }">
											<font color="red">${pageNumber }</font>
										</c:when>
										<c:otherwise>
											<a href="${pageUrl }">${pageNumber}</a>
										</c:otherwise>
									</c:choose>
								</pg:pages>
								<pg:next>
									<a href="${pageUrl}">下页</a>
								</pg:next>
								<pg:last>
									<a href="${pageUrl}">尾页</a>
								</pg:last>
								每页显示:
								<select id="pagesize"  onchange="javascript:changeItem(this)">
								<%
									for(int x=0;x<lsData.length;x++){
								%>
									<option value="<%=lsData[x]%>" <%=lsData[x]==lineSize?"SELECTED":""%>><%=lsData[x]%></option>
								<%
									}
								%>
								</select>
								条
							</pg:pager>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
		</center>
</body>
</html>