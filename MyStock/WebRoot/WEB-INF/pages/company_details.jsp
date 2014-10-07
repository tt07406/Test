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
</style>
</head>
<body>
<s:include value="header.jsp">  
	<s:param name="index">company_details</s:param>  
	</s:include>
<div style="padding: 100px 100px 10px;" class="container text-center" id="display" >
   <!-- company detail -->
   <table class="table table-bordered" id="company_detail">
	   <caption>XXX 公司信息一览表</caption>
	   <tbody>
	      <tr>
	         <td>公司全称</td>
	         <td>南方基金管理公司</td>
	         <td>注册地址</td>
	         <td>深圳市福田区福华一路6号免税商务大厦32楼</td>
	      </tr>	      
	      <tr>
	      	<td>当前市值</td>
	      	<td>xxx</td>
	      	<td>当前股价</td>
	      	<td>xxxxx</td>
	      </tr>
	      <tr><td>所属行业</td><td colspan="3">互联网商务</td></tr>
	      <tr>
	         <td>总经理</td>
	         <td>李XX</td>
	         <td>联系人</td>
	      	 <td>赵XX</td>
	      </tr>
	      <tr>
	      	<td>联系电话</td>
	      	<td>010-xxxxxxxx</td>
	      	<td>联系传真</td>
	      	<td>010-1111 1111</td>
	      </tr>
	      <tr>
	      	<td>公司简介</td>
	      	<td colspan=3>平安银行， 全称平安银行股份有限公司，是中国平安保险（集团）股份有限公司控股的一家跨区域经营的股份制商业银行，为中国大陆12家全国性股份制商业银行之一。注册资本为人民币51.2335亿元，总资产近1.37万亿元，总部位于广东省深圳市。
中国平安保险（集团）股份有限公司（以下简称“中国平安”）及其控股子公司持有平安银行股份共计约26.84亿股，占比约52.38%，为平安银行的控股股东。
在全中国各地设有34家分行，在香港设有代表处。2012年1月，现平安银行的前身深圳发展银行收购平安保险集团旗下的深圳平安银行，收购完成后，深圳发展银行更名为新的平安银行，组建新的平安银行正式对外营业。2013年5月24日内部正式发文宣布调整总行组织架构，总行一级部门由原来的79个精简至52个， 新建或整合形成了3个行业事业部、11个产品事业部和1个平台事业部。
截至2013年6月底，平安银行资产总额18,269.98亿元，存款总额11,753.61亿元，贷款总额（含贴现）7,864.84亿元。
2013年12月30日晚，平安银行发布公告称，收到了中国证券监督管理委员会的批复，核准公司非公开发行不超过13.23亿股新股，平安银行将于6个月内完成本次定向增发。</td>
	      </tr>
	      <tr>
	      	<td>最新动态</td>
	      	<td colspan=3 id="news-list">
	      		<div class="row">
	      			<div class="col-lg-9"><a href="http://www.baidu.com">平安银行获得来自高盛超过100亿美元的注资</a></div>
	      			<div class="col-lg-3">2014年9月24日22:24:58</div>
	      		</div>
	      		<div class="row">
	      			<div class="col-lg-9"><a href="http://www.baidu.com">平安银行获得来自高盛超过100亿美元的注资</a></div>
	      			<div class="col-lg-3">2014年9月24日22:24:58</div>
	      		</div>
	      		<div class="row">
	      			<div class="col-lg-9"><a href="http://www.baidu.com">平安银行获得来自高盛超过100亿美元的注资</a></div>
	      			<div class="col-lg-3">2014年9月24日22:24:58</div>
	      		</div>
	      		<div class="row">
	      			<div class="col-lg-9"><a href="http://www.baidu.com">平安银行获得来自高盛超过100亿美元的注资</a></div>
	      			<div class="col-lg-3">2014年9月24日22:24:58</div>
	      		</div>
	      	</td>
	      </tr>
	   </tbody>
	</table>
</div>
<s:include value="footer.jsp"></s:include>
</body>
</html>