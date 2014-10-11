<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>我的表格 -- 首页</title>
<link href="front/css/bootstrap.css" rel="stylesheet">
<link href="front/css/jquery-ui.min.css" rel="stylesheet">
<link href="front/css/global-style.css" rel="stylesheet">
<link href="front/css/infoedit.css" rel="stylesheet">
</head>
<body>
<s:include value="header.jsp">  
	<s:param name="index">myforms</s:param>  
	</s:include> 	
<div class="container" style="margin-top: 100px;"> 
<p id="p-test"></p>
<ul id="table_list"></ul>
<ul class="pagination" id="pagination1"></ul>
<br>
<a href="myforms_new.action">[创建新表格]</a>
</div>
<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript" src="front/js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="front/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="front/js/bootstrap.js"></script>
<script type="text/javascript" src="front/js/ajax.article.js"></script>
<script type="text/javascript" src="front/js/article.js"></script>
<script type="text/javascript" src="front/js/jqPaginator.js"></script>
<script type="text/javascript">
$.jqPaginator('#pagination1', {
    /*totalPages: 100,*/ /*总页数*/
    totalCounts:50,	/*总条目数*/
    pageSize:10,	/*每页条目数*/
    visiblePages: 10,
    currentPage: 1,
    onPageChange: function (num, type) {    
    	$("#p-test").text("currentPage : "+num);
    	FF0030(num, 10);
    }
});
</script>
<s:include value="footer.jsp"></s:include>
</body>
</html>