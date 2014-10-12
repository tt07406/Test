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
<!--<link href="front/css/infoedit.css" rel="stylesheet">-->
</head>
<style type="text/css">
#company_detail caption{
	font-size: 25px;
	font-weight: bold;
	padding: 5px;
}
#company_detail caption >span{
	font-weight: normal;
}
#company_detail tr:nth-child(odd){
	background: #DFF0D8;
}

#company_detail tr > td:first-child {
	width: 100px;
}

#news-list .row{
	margin: 15px;
}

#company_list tr > td:first-child {
	width: 100px;
}

#company_list tr > td:nth-child(2) {
	width: 200px;
}

#company_list tr > td:nth-child(3) {
}

#company_list tr > td:nth-child(4) {
	width: 200px;
}

#company_list tr > td:nth-child(4) > a {
	margin: 5px;
}

#company_list tr > td:nth-child(5) {
	width: 70px;
}

#company_list tr > td:nth-child(5) > button {
	margin: 5px 0px;
}

#display > h1{
	font-size: 36px;
}

#display > h1 > a{
	color: #CC0033;
}

.article-item {
    height: 300px;
}

.article-item > div > img {
    width: 120px;
    height: 120px;
}

.article-item > div > img {
    width: 120px;
    height: 120px;
}

.article-item row {
    margin: 0px 20px;
}

.article-item .article-substract {
    height: 120px;
    overflow: hidden;
}

</style>
<body>
<s:include value="header.jsp">  
	<s:param name="index">myforms</s:param>  
	</s:include> 	
<div class="container"> 

<div id="display" class="container" style="padding-top: 60px;">
		<h1 class="lead text-left">我的表格</h1>
		<hr>
		<!-- search -->
		<form action="companySearchController" class="" role="form"
			id="search">
			<div class="row">
				<div class="col-md-2"><button class="btn btn-default btn-warning"><a href="myforms_new.action">创建新表格</a></button></div>
				<div class="col-md-6"></div>
				<div class="col-md-4" style="text-align: right;">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="表格标题/表格标签"> <span
							class="input-group-btn">
							<button class="btn btn-default">查询</button>
<!--							<button class="btn btn-default" type="button">-->
<!--								<span class="glyphicon glyphicon-search"-->
<!--									style="color: rgb(0, 0, 0); font-size: 20px;"></span>-->
<!--							</button>-->
						</span>
					</div>
					<!-- /input-group -->
				</div>
				<!-- /.col-lg-6 -->
			</div>
			<!-- /.row -->
		</form>
		<!-- ./ search -->
        
        <table id="company_list" class="table">
			<thead>
				<tr class="success">
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
                        <div class="row article-item">
                            <div class="col-md-2">
                                <img src="" alt="the head picture" />
                                
                            </div>
                            <div class="col-md-8">
                                <div class="row">
                                    <div class="col-md-12">
                                        <h4><a href="myforms_new.action">平安银行2014年度盈利报表</a></h4>
                                    </div>
                                    <div class="col-md-12">
                                        <p class="article-substract">平安银行2014年度盈利报表</p>
                                    </div>
                                    
                                </div>
                                
                            </div>
                            <div class="col-md-1">
<!--                                <button class="btn btn-success">编辑</button>-->
                            </div>
                        </div>
                    </td>
				</tr>
			</tbody>
		</table>
        
		<hr>
		<div class="row">
			<div class="col-lg-8">
				<ul class="pagination">
					<li><a href="#">上一页</a></li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">下一页</a></li>
				</ul>
			</div>
			<div class="col-lg-4">
			</div>
		</div>
	</div>
<p id="p-test"></p>
<ul id="table_list"></ul>
<ul class="pagination" id="pagination1"></ul>
<br>
</div>

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