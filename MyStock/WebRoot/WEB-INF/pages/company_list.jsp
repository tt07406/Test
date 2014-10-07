<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>公司信息展示 -- 斯多克个人版</title>
<link href="front/css/bootstrap.css" rel="stylesheet">
<link href="front/css/jquery-ui.min.css" rel="stylesheet">
<link href="front/css/global-style.css" rel="stylesheet">
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
	font-size: 72px;
}

#display > h1 > a{
	color: #CC0033;
}

</style>
</head>
<body>
<s:include value="header.jsp">  
	<s:param name="index">company_list</s:param>  
	</s:include>
	<div id="display" class="container" style="padding-top: 60px;">
		<h1 class="lead text-center">斯多克已收录<a>5128</a>家公司的记录</h1>
		<hr>
		<!-- search -->
		<form action="companySearchController" class="" role="form"
			id="search">
			<div class="row">
				<div class="col-md-4">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="股票代码/公司名称/行业/版块"> <span
							class="input-group-btn">
							<button class="btn btn-default" type="button">
								<span class="glyphicon glyphicon-search"
									style="color: rgb(0, 0, 0); font-size: 20px;"></span>
							</button>
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
					<th>公司代码</th>
					<th>公司名称</th>
					<th>简介</th>
					<th>行业</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>0001</td>
					<td>平安银行</td>
					<td><div>平安银行，
							全称平安银行股份有限公司，是中国平安保险（集团）股份有限公司控股的一家跨区域经营的股份制商业银行，为中国大陆12家全国性股份制商业银行之一。注册资本为人民币51.2335亿元，总资产近1.37万亿元，总部位于广东省深圳市。</div></td>
					<td><a href="http://www.baidu.com">金融</a>/<a href="http://www.baidu.com">银行</a>/<a href="http://www.baidu.com">保险</a></td>
					<td><button class="btn btn-success" data-toggle="modal"
							data-target="#company_detail" onclick="seeDetails()">详情</button>
							<button class="btn btn-danger" data-toggle="modal"
							data-target="#company_detail">关注</button></td>
				</tr>

				<tr>
					<td>0002</td>
					<td>斯多克科技有限公司</td>
					<td><div>斯多克科技有限公司正式成立于2014年4月在北京成立，是一家致力于利用大数据、科学云计算、移动分布式计算等新兴技术进行投资智能化的高新科技公司。斯多克科技的理念是：专注智能投资领域，做智能投资领域的先行者。斯多克科技崇尚客户至上，以人为先的公司文化，努力为客户提供智能可靠的决策，至真至善的服务。</div></td>
					<td><a href="http://www.baidu.com">证券</a>/<a href="http://www.baidu.com">互联网</a>/<a href="http://www.baidu.com">银行</a>/<a href="http://www.baidu.com">保险</a></td>
					<td><button class="btn btn-success" data-toggle="modal"
							data-target="#company_detail" onclick="seeDetails()">详情</button>
							<button class="btn btn-danger" data-toggle="modal"
							data-target="#company_detail">关注</button></td>
				</tr>

				<tr>
					<td>0003</td>
					<td>平安银行</td>
					<td><div>平安银行，
							全称平安银行股份有限公司，是中国平安保险（集团）股份有限公司控股的一家跨区域经营的股份制商业银行，为中国大陆12家全国性股份制商业银行之一。注册资本为人民币51.2335亿元，总资产近1.37万亿元，总部位于广东省深圳市。</div></td>
					<td><a href="http://www.baidu.com">金融</a>/<a href="http://www.baidu.com">银行</a>/<a href="http://www.baidu.com">保险</a></td>
					<td><button class="btn btn-success" data-toggle="modal"
							data-target="#company_detail">详情</button>
							<button class="btn btn-danger" data-toggle="modal"
							data-target="#company_detail">关注</button></td>
				</tr>

				<tr>
					<td>0004</td>
					<td>平安银行</td>
					<td><div>平安银行，
							全称平安银行股份有限公司，是中国平安保险（集团）股份有限公司控股的一家跨区域经营的股份制商业银行，为中国大陆12家全国性股份制商业银行之一。注册资本为人民币51.2335亿元，总资产近1.37万亿元，总部位于广东省深圳市。</div></td>
					<td><a href="http://www.baidu.com">金融</a>/<a href="http://www.baidu.com">银行</a>/<a href="http://www.baidu.com">保险</a></td>
					<td><button class="btn btn-success" data-toggle="modal"
							data-target="#company_detail">详情</button>
							<button class="btn btn-danger" data-toggle="modal"
							data-target="#company_detail">关注</button></td>
				</tr>

				<tr>
					<td>0001</td>
					<td>平安银行</td>
					<td><div>平安银行，
							全称平安银行股份有限公司，是中国平安保险（集团）股份有限公司控股的一家跨区域经营的股份制商业银行，为中国大陆12家全国性股份制商业银行之一。注册资本为人民币51.2335亿元，总资产近1.37万亿元，总部位于广东省深圳市。</div></td>
					<td><a href="http://www.baidu.com">金融</a>/<a href="http://www.baidu.com">银行</a>/<a href="http://www.baidu.com">保险</a></td>
					<td><button class="btn btn-success" data-toggle="modal"
							data-target="#company_detail">详情</button>
							<button class="btn btn-danger" data-toggle="modal"
							data-target="#company_detail">关注</button></td>
				</tr>

				<tr>
					<td>0001</td>
					<td>平安银行</td>
					<td><div>平安银行，
							全称平安银行股份有限公司，是中国平安保险（集团）股份有限公司控股的一家跨区域经营的股份制商业银行，为中国大陆12家全国性股份制商业银行之一。注册资本为人民币51.2335亿元，总资产近1.37万亿元，总部位于广东省深圳市。</div></td>
					<td><a href="http://www.baidu.com">金融</a>/<a href="http://www.baidu.com">银行</a>/<a href="http://www.baidu.com">保险</a></td>
					<td><button class="btn btn-success" data-toggle="modal"
							data-target="#company_detail">详情</button>
							<button class="btn btn-danger" data-toggle="modal"
							data-target="#company_detail">关注</button></td>
				</tr>
				
				<tr>
					<td>0001</td>
					<td>平安银行</td>
					<td><div>平安银行，
							全称平安银行股份有限公司，是中国平安保险（集团）股份有限公司控股的一家跨区域经营的股份制商业银行，为中国大陆12家全国性股份制商业银行之一。注册资本为人民币51.2335亿元，总资产近1.37万亿元，总部位于广东省深圳市。</div></td>
					<td><a href="http://www.baidu.com">金融</a>/<a href="http://www.baidu.com">银行</a>/<a href="http://www.baidu.com">保险</a></td>
					<td><button class="btn btn-success" data-toggle="modal"
							data-target="#company_detail">详情</button>
							<button class="btn btn-danger" data-toggle="modal"
							data-target="#company_detail">关注</button></td>
				</tr>
				
				<tr>
					<td>0001</td>
					<td>平安银行</td>
					<td><div>平安银行，
							全称平安银行股份有限公司，是中国平安保险（集团）股份有限公司控股的一家跨区域经营的股份制商业银行，为中国大陆12家全国性股份制商业银行之一。注册资本为人民币51.2335亿元，总资产近1.37万亿元，总部位于广东省深圳市。</div></td>
					<td><a href="http://www.baidu.com">金融</a>/<a href="http://www.baidu.com">银行</a>/<a href="http://www.baidu.com">保险</a></td>
					<td><button class="btn btn-success" data-toggle="modal"
							data-target="#company_detail">详情</button>
							<button class="btn btn-danger" data-toggle="modal"
							data-target="#company_detail">关注</button></td>
				</tr>
				
				<tr>
					<td>0001</td>
					<td>平安银行</td>
					<td><div>平安银行，
							全称平安银行股份有限公司，是中国平安保险（集团）股份有限公司控股的一家跨区域经营的股份制商业银行，为中国大陆12家全国性股份制商业银行之一。注册资本为人民币51.2335亿元，总资产近1.37万亿元，总部位于广东省深圳市。</div></td>
					<td><a href="http://www.baidu.com">金融</a>/<a href="http://www.baidu.com">银行</a>/<a href="http://www.baidu.com">保险</a></td>
					<td><button class="btn btn-success" data-toggle="modal"
							data-target="#company_detail">详情</button>
							<button class="btn btn-danger" data-toggle="modal"
							data-target="#company_detail">关注</button></td>
				</tr>
				
				<tr>
					<td>0001</td>
					<td>平安银行</td>
					<td><div>平安银行，
							全称平安银行股份有限公司，是中国平安保险（集团）股份有限公司控股的一家跨区域经营的股份制商业银行，为中国大陆12家全国性股份制商业银行之一。注册资本为人民币51.2335亿元，总资产近1.37万亿元，总部位于广东省深圳市。</div></td>
					<td><a href="http://www.baidu.com">金融</a>/<a href="http://www.baidu.com">银行</a>/<a href="http://www.baidu.com">保险</a></td>
					<td><button class="btn btn-success" data-toggle="modal"
							data-target="#company_detail">详情</button>
							<button class="btn btn-danger" data-toggle="modal"
							data-target="#company_detail">关注</button></td>
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
	<s:include value="footer.jsp"></s:include>
	
	<script type="text/javascript">
		function seeDetails() {
			window.location.href='company_details.action';
		}
	</script>
</body>
</html>