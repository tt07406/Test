CREATE TABLE `profit_statement` (
`seq_no`  int(11) NOT NULL AUTO_INCREMENT , #序列号
`stock_id`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL , #股票代码
`statement_date`  date NOT NULL , #报表日期
`unit`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL , #单位
`gross_revenue`  double NULL DEFAULT NULL , #营业总收入
`operating_revenue`  double NULL DEFAULT NULL , #营业收入
`interest_income`  double NULL DEFAULT NULL , #利息收入
`earned_premium`  double NULL DEFAULT NULL , #已赚保费
`fee_commission_income`  double NULL DEFAULT NULL , #手续费及佣金收入
`real_estate_income`  double NULL DEFAULT NULL , #房地产销售收入
`other_business_income`  double NULL DEFAULT NULL , #其他业务收入
`total_operating_cost`  double NULL DEFAULT NULL , #营业总成本
`operating_cost`  double NULL DEFAULT NULL , #营业成本
`interest_expense`  double NULL DEFAULT NULL , #利息支出
`fee_commission_expense`  double NULL DEFAULT NULL , #手续费及佣金支出
`real_estate_cost`  double NULL DEFAULT NULL , #房地产销售成本
`research_development_expenditure`  double NULL DEFAULT NULL , #研发费用
`surrender_value`  double NULL DEFAULT NULL , #退保金
`net_payments_insurance_claim`  double NULL DEFAULT NULL , #赔付支出净额
`insurance_contract_net_reserve`  double NULL DEFAULT NULL , #提取保险合同准备金净额
`bond_insurance_expense`  double NULL DEFAULT NULL , #保单红利支出
`reinsurance_expense`  double NULL DEFAULT NULL , #分保费用
`other_operating_cost`  double NULL DEFAULT NULL , #其他业务成本
`business_tariff_annex`  double NULL DEFAULT NULL , #营业税金及附加
`selling_expense`  double NULL DEFAULT NULL , #销售费用
`administration_expense`  double NULL DEFAULT NULL , #管理费用
`financial_expense`  double NULL DEFAULT NULL , #财务费用
`asset_impairment_loss`  double NULL DEFAULT NULL , #资产减值损失
`gain_change_fair_value`  double NULL DEFAULT NULL , #公允价值变动收益
`investment_income`  double NULL DEFAULT NULL , #投资收益
`joint_venture_investment_income`  double NULL DEFAULT NULL ,  #其中:对联营企业和合营企业的投资收益
`exchange_gain`  double NULL DEFAULT NULL , #汇兑收益
`futures_profit_loss`  double NULL DEFAULT NULL , #期货损益
`managed_earning`  double NULL DEFAULT NULL , #托管收益
`subsidize_revenue`  double NULL DEFAULT NULL , #补贴收入
`income_other_operation`  double NULL DEFAULT NULL , #其他业务利润
`operating_profit`  double NULL DEFAULT NULL , #营业利润
`nonoperating_income`  double NULL DEFAULT NULL , #营业外收入
`nonoperating_expenditure`  double NULL DEFAULT NULL , #营业外支出
`disposal_loss_noncurrent_liability`  double NULL DEFAULT NULL , #非流动资产处置损失
`total_profit`  double NULL DEFAULT NULL , #利润总额
`income_tax_expense`  double NULL DEFAULT NULL , #所得税费用
`unrealised_investment_loss`  double NULL DEFAULT NULL , #未确认投资损失
`net_profit`  double NULL DEFAULT NULL , #净利润
`net_profit_parent`  double NULL DEFAULT NULL , #归属于母公司所有者的净利润
`minority_interest_income`  double NULL DEFAULT NULL , #少数股东损益
`earning_per_share`  double NULL DEFAULT NULL , #每股收益
`basic_earning_per_share`  double NULL DEFAULT NULL , #基本每股收益
`diluted_earning_per_share`  double NULL DEFAULT NULL , #稀释每股收益
`other_comprehensive_income`  double NULL DEFAULT NULL , #其他综合收益
`total_comprehensive_income`  double NULL DEFAULT NULL , #综合收益总额
`total_comprehensive_income_parent`  double NULL DEFAULT NULL , #归属于母公司所有者的综合收益总额
`total_comprehensive_income_minority`  double NULL DEFAULT NULL , #归属于少数股东的综合收益总额
PRIMARY KEY (`seq_no`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1
CHECKSUM=0
ROW_FORMAT=FIXED
DELAY_KEY_WRITE=0
;

CREATE TABLE `profit_statement_bank` (
`seq_no`  int(11) NOT NULL AUTO_INCREMENT , #序列号
`stock_id`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL , #股票代码
`statement_date`  date NOT NULL , #报表日期
`unit`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL , #单位
`operating_revenue`  double NULL DEFAULT NULL , #营业收入
`net_interest_income`  double NULL DEFAULT NULL , #其中:净利息收入
`interest_income`  double NULL DEFAULT NULL , #其中:利息收入
`interest_expense`  double NULL DEFAULT NULL , #利息支出
`fee_commission_net_income`  double NULL DEFAULT NULL , #手续费及佣金净收入
`fee_commission_income`  double NULL DEFAULT NULL , #其中:手续费及佣金收入
`fee_commission_expense`  double NULL DEFAULT NULL , #手续费及佣金支出
`intermediate_business_net_income`  double NULL DEFAULT NULL , #中间业务净收入
`intermediate_business_income`  double NULL DEFAULT NULL , #其中:中间业务收入
`intermediate_business_expense`  double NULL DEFAULT NULL , #中间业务支出
`net_trading_income`  double NULL DEFAULT NULL , #净交易收入
`derivatives_trading_net_income`  double NULL DEFAULT NULL , #其中:衍生金融工具交易净收入
`exchange_gain`  double NULL DEFAULT NULL , #汇兑收益
`net_investment_income`  double NULL DEFAULT NULL , #投资净收益
`associated_company_investment_income`  double NULL DEFAULT NULL , #其中:对联营公司的投资收益
`gain_change_fair_value`  double NULL DEFAULT NULL , #公允价值变动收益
`income_other_operation`  double NULL DEFAULT NULL , #其他业务收入
`operating_expense`  double NULL DEFAULT NULL , #营业支出
`business_tariff_annex`  double NULL DEFAULT NULL , #营业税金及附加
`business_administration_expense`  double NULL DEFAULT NULL , #业务及管理费用
`asset_impairment_loss`  double NULL DEFAULT NULL , #资产减值损失
`depreciation_expense`  double NULL DEFAULT NULL , #折旧费
`provision_doubtful_debt`  double NULL DEFAULT NULL , #提取呆账准备
`other_operating_cost`  double NULL DEFAULT NULL , #其他业务支出
`operating_profit`  double NULL DEFAULT NULL , #营业利润 
`nonoperating_income`  double NULL DEFAULT NULL , #加:营业外收入
`nonoperating_expenditure`  double NULL DEFAULT NULL , #减:营业外支出
`total_profit`  double NULL DEFAULT NULL , #利润总额
`income_tax`  double NULL DEFAULT NULL , #减:所得税
`minority_interest`  double NULL DEFAULT NULL , #少数股东权益
`net_profit_parent`  double NULL DEFAULT NULL , #归属于母公司的净利润
`beginning_retained_earning`  double NULL DEFAULT NULL , #加:年初未分配利润
`profit_available_distribution`  double NULL DEFAULT NULL , #可供分配的利润
`withdrawal_legal_surplus`  double NULL DEFAULT NULL , #减:提取法定盈余公积
`withdraw_statutory_welfare_reserve`  double NULL DEFAULT NULL , #提取法定公益金
`allotting_ordinary_risk_reserve`  double NULL DEFAULT NULL , #提取一般风险准备
`allotting_trust_compensation_reserve`  double NULL DEFAULT NULL , #提取信托赔偿准备金
`distribution_profit_shareholder`  double NULL DEFAULT NULL , #可供股东分配的利润
`preferred_stock_dividend_payable`  double NULL DEFAULT NULL , #减:应付优先股股利
`withdrawal_other_common_accumulation`  double NULL DEFAULT NULL , #提取任意盈余公积
`common_stock_dividend_payable`  double NULL DEFAULT NULL , #应付普通股股利
`dividend_transferred_capital`  double NULL DEFAULT NULL , #转作股本的普通股股利
`undistributed_profit`  double NULL DEFAULT NULL , #未分配利润
`basic_earning_per_share`  double NULL DEFAULT NULL , #基本每股收益
`diluted_earning_per_share`  double NULL DEFAULT NULL , #稀释每股收益
PRIMARY KEY (`seq_no`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1
CHECKSUM=0
ROW_FORMAT=FIXED
DELAY_KEY_WRITE=0
;