<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>信息维护 -- 斯多克个人版</title>
<link href="front/css/bootstrap.css" rel="stylesheet">
<link href="front/css/jquery-ui.min.css" rel="stylesheet">
<link href="front/css/global-style.css" rel="stylesheet">
</head>
<body>
<s:include value="header.jsp">  
	<s:param name="index">commit_center</s:param>  
	</s:include> 

<br>
<div id="information" style="padding: 100px 100px 10px;">
<div class="container">
	<legend>我维护的公司列表</legend>
			<table class="table">
				<thead>
					<tr>
						<th>公司代码</th>
						<th>公司名称</th>
						<th>简介</th>
						<th>详细信息</th>
						<th>资料库</th>
						<th>上次修改时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>0001</td>
						<td>平安银行</td>
						<td><div style="max-width: 300px;">平安银行， 全称平安银行股份有限公司，是中国平安保险（集团）股份有限公司控股的一家跨区域经营的股份制商业银行，为中国大陆12家全国性股份制商业银行之一。注册资本为人民币51.2335亿元，总资产近1.37万亿元，总部位于广东省深圳市。</div></td>
						<td><div style="max-width: 300px;">平安银行致力于为客户提供全方位的银行服务。您可以了解投资理财、贷款、个人通知存款、银行缴费、公司业务等平安银行业务,可以方便快捷的登录网上银行,办理转账汇款、...</div></td>
						<td><a href="www.baidu.com">进入</a></td>
						<td><a style="max-width: 100px;" href="www.baidu.com">2014年9月24日22:05:49</a></td>
						<td><button class="btn btn-success" data-toggle="modal" data-target="#company_detail" onclick="editItem()">编辑</button></td>
					</tr>
					
					<tr>
						<td>0002</td>
						<td>斯多克科技有限公司</td>
						<td><div style="max-width: 300px;">斯多克科技有限公司正式成立于2014年4月在北京成立，是一家致力于利用大数据、科学云计算、移动分布式计算等新兴技术进行投资智能化的高新科技公司。斯多克科技的理念是：专注智能投资领域，做智能投资领域的先行者。斯多克科技崇尚客户至上，以人为先的公司文化，努力为客户提供智能可靠的决策，至真至善的服务。</div></td>
						<td><div style="max-width: 300px;">我们是一支在股票投资领域和科技研发领域均具有丰富经验的成熟团队，聚集了来自国内外知名高等学府和公司的精英人才。公司虽然正处在起步阶段，但在创立后这短短的时间内，已成功获得了众多风险投资的青睐。</div></td>
						<td><a href="www.baidu.com">进入</a></td>
						<td><a style="max-width: 100px;" href="www.baidu.com">2014年9月24日22:05:49</a></td>
						<td><button class="btn btn-success" data-toggle="modal" data-target="#company_detail">编辑</button></td>
					</tr>
					
					<tr>
						<td>0003</td>
						<td>平安银行</td>
						<td><div style="max-width: 300px;">平安银行， 全称平安银行股份有限公司，是中国平安保险（集团）股份有限公司控股的一家跨区域经营的股份制商业银行，为中国大陆12家全国性股份制商业银行之一。注册资本为人民币51.2335亿元，总资产近1.37万亿元，总部位于广东省深圳市。</div></td>
						<td><div style="max-width: 300px;">平安银行致力于为客户提供全方位的银行服务。您可以了解投资理财、贷款、个人通知存款、银行缴费、公司业务等平安银行业务,可以方便快捷的登录网上银行,办理转账汇款、...</div></td>
						<td><a href="www.baidu.com">进入</a></td>
						<td><a style="max-width: 100px;" href="www.baidu.com">2014年9月24日22:05:49</a></td>
						<td><button class="btn btn-success" data-toggle="modal" data-target="#company_detail">编辑</button></td>
					</tr>
					
					<tr>
						<td>0004</td>
						<td>平安银行</td>
						<td><div style="max-width: 300px;">平安银行， 全称平安银行股份有限公司，是中国平安保险（集团）股份有限公司控股的一家跨区域经营的股份制商业银行，为中国大陆12家全国性股份制商业银行之一。注册资本为人民币51.2335亿元，总资产近1.37万亿元，总部位于广东省深圳市。</div></td>
						<td><div style="max-width: 300px;">平安银行致力于为客户提供全方位的银行服务。您可以了解投资理财、贷款、个人通知存款、银行缴费、公司业务等平安银行业务,可以方便快捷的登录网上银行,办理转账汇款、...</div></td>
						<td><a href="www.baidu.com">进入</a></td>
						<td><a style="max-width: 100px;" href="www.baidu.com">2014年9月24日22:05:49</a></td>
						<td><button class="btn btn-success" data-toggle="modal" data-target="#company_detail">编辑</button></td>
					</tr>
					
					<tr>
						<td>0001</td>
						<td>平安银行</td>
						<td><div style="max-width: 300px;">平安银行， 全称平安银行股份有限公司，是中国平安保险（集团）股份有限公司控股的一家跨区域经营的股份制商业银行，为中国大陆12家全国性股份制商业银行之一。注册资本为人民币51.2335亿元，总资产近1.37万亿元，总部位于广东省深圳市。</div></td>
						<td><div style="max-width: 300px;">平安银行致力于为客户提供全方位的银行服务。您可以了解投资理财、贷款、个人通知存款、银行缴费、公司业务等平安银行业务,可以方便快捷的登录网上银行,办理转账汇款、...</div></td>
						<td><a href="www.baidu.com">进入</a></td>
						<td><a style="max-width: 100px;" href="www.baidu.com">2014年9月24日22:05:49</a></td>
						<td><button class="btn btn-success" data-toggle="modal" data-target="#company_detail">编辑</button></td>
					</tr>
					
					<tr>
						<td>0001</td>
						<td>平安银行</td>
						<td><div style="max-width: 300px;">平安银行， 全称平安银行股份有限公司，是中国平安保险（集团）股份有限公司控股的一家跨区域经营的股份制商业银行，为中国大陆12家全国性股份制商业银行之一。注册资本为人民币51.2335亿元，总资产近1.37万亿元，总部位于广东省深圳市。</div></td>
						<td><div style="max-width: 300px;">平安银行致力于为客户提供全方位的银行服务。您可以了解投资理财、贷款、个人通知存款、银行缴费、公司业务等平安银行业务,可以方便快捷的登录网上银行,办理转账汇款、...</div></td>
						<td><a href="www.baidu.com">进入</a></td>
						<td><a style="max-width: 100px;" href="www.baidu.com">2014年9月24日22:05:49</a></td>
						<td><button class="btn btn-success" data-toggle="modal" data-target="#company_detail">编辑</button></td>
					</tr>
				</tbody>
			</table>
</div>
</div>
<jsp:include page="footer.jsp" />

<!-- 模态框（Modal） -->
<div class="modal fade" id="company_detail" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title" id="myModalLabel">斯多克科技 -- 详细信息编辑</h4>
         </div>
         <div class="modal-body">
		          公司序号：<input type="text"><br><br>
		          公司名称：<input type="text"><br><br>
		          图片上传：<form action="upLoadFile.action" method="post" enctype="multipart/form-data">
						<input type="file" name="file" size="50" />
						<br />
						<input type="submit" value="Upload File" />
				  </form>
         <div class="modal-footer">
            <button type="button" class="btn btn-default"  data-dismiss="modal">关闭</button>
            <button type="button" class="btn btn-primary">提交更改</button>
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
<script type="text/javascript" src="front/js/jquery.min.js"></script>
<script type="text/javascript" src="front/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="front/js/bootstrap.js"></script>
<script>
$(function() {
	(function (){
		$( "#datepicker" ).datepicker();
	})();
	(function (){
		$("#company_detail").on({
			click:function(){
				//alert("company_detail edit");
			}
		})
	})();
});

function editItem() {
	window.location.href='company_edit.action';
}

</script>
</body>
</html>