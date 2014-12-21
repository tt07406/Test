CREATE TABLE `liability_statement` (
`seq_no`  int(11) NOT NULL AUTO_INCREMENT , #序列号
`stock_id`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL , #股票代码
`statement_date`  date NOT NULL , #报表日期
`unit`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL , #单位
`current_asset`   double NULL DEFAULT NULL , #流动资产
`monetary_fund`   double NULL DEFAULT NULL , #货币资金
`settlement_fund`  double NULL DEFAULT NULL , #结算备付金
`lending_fund`  double NULL DEFAULT NULL , #拆出资金
`trading_financial_asset` double NULL DEFAULT NULL , #交易性金融资产
`derivative_financial_asset`  double NULL DEFAULT NULL , #衍生金融资产
`note_receivable`  double NULL DEFAULT NULL , #应收票据
`account_receivable`  double NULL DEFAULT NULL , #应收账款
`advance_payment`  double NULL DEFAULT NULL , #预付款项
`premium_receivable`  double NULL DEFAULT NULL , #应收保费
`reinsurance_account_receivable`  double NULL DEFAULT NULL , #应收分保账款
`provision_cession_receivable`  double NULL DEFAULT NULL , #应收分保合同准备金
`interest_receivable`  double NULL DEFAULT NULL , #应收利息
`dividend_receivable`  double NULL DEFAULT NULL , #应收股利
`other_receivable`  double NULL DEFAULT NULL , #其他应收款
`export_drawback_receivable`  double NULL DEFAULT NULL , #应收出口退税
`allowance_receivable`  double NULL DEFAULT NULL , #应收补贴款
`margin_receivable`  double NULL DEFAULT NULL , #应收保证金
`internal_receivable`  double NULL DEFAULT NULL , #内部应收款
`redemptory_monetary_capital`  double NULL DEFAULT NULL , #买入返售金融资产
`inventory`  double NULL DEFAULT NULL , #存货
`unamortized_expense`  double NULL DEFAULT NULL , #待摊费用
`unsettled_current_gl`  double NULL DEFAULT NULL , #待处理流动资产损益
`noncurrent_asset_ayear`  double NULL DEFAULT NULL , #一年内到期的非流动资产
`other_current_asset`  double NULL DEFAULT NULL , #其他流动资产
`total_current_asset`  double NULL DEFAULT NULL , #流动资产合计
`noncurrent_asset`  double NULL DEFAULT NULL , #非流动资产
`loans_and_advances`  double NULL DEFAULT NULL , #发放贷款及垫款
`salable_finanical_asset`  double NULL DEFAULT NULL , #可供出售金融资产
`heldtomaturity_investment`  double NULL DEFAULT NULL , #持有至到期投资
`long_term_receivable`  double NULL DEFAULT NULL , #长期应收款
`longterm_equity_investment`  double NULL DEFAULT NULL , #长期股权投资
`other_longterm_investment`  double NULL DEFAULT NULL , #其他长期投资
`investment_property`  double NULL DEFAULT NULL , #投资性房地产
`original_value_fixed_asset`  double NULL DEFAULT NULL , #固定资产原值
`accumulated_depreciation`  double NULL DEFAULT NULL , #累计折旧
`net_value_fixed_asset`  double NULL DEFAULT NULL , #固定资产净值
`fixed_asset_depreciation_reserve`  double NULL DEFAULT NULL , #固定资产减值准备
`net_fixed_asset`  double NULL DEFAULT NULL , #固定资产净额
`construction_in_process`  double NULL DEFAULT NULL , #在建工程
`construction_material`  double NULL DEFAULT NULL , #工程物资
`fixed_asset_liquidation`  double NULL DEFAULT NULL , #固定资产清理
`productive_biological_asset`  double NULL DEFAULT NULL , #生产性生物资产
`welfare_biological_asset`  double NULL DEFAULT NULL , #公益性生物资产
`oil_gas_asset`  double NULL DEFAULT NULL , #油气资产
`intangible_asset`  double NULL DEFAULT NULL , #无形资产
`development_expenditure`  double NULL DEFAULT NULL , #开发支出
`goodwill`  double NULL DEFAULT NULL , #商誉
`longterm_deferred_expenditure`  double NULL DEFAULT NULL , #长期待摊费用
`circulation_right_equity_separation`  double NULL DEFAULT NULL , #股权分置流通权
`deferred_tax_asset`  double NULL DEFAULT NULL , #递延所得税资产
`other_noncurrent_asset`  double NULL DEFAULT NULL , #其他非流动资产
`total_noncurrent_asset`  double NULL DEFAULT NULL , #非流动资产合计
`total_asset`  double NULL DEFAULT NULL , #资产总计
`current_liability`  double NULL DEFAULT NULL , #流动负债
`short_loan`  double NULL DEFAULT NULL , #短期借款
`central_bank_loan`  double NULL DEFAULT NULL , #向中央银行借款
`customers_interbank_deposit`  double NULL DEFAULT NULL , #吸收存款及同业存放
`borrowing_fund`  double NULL DEFAULT NULL , #拆入资金
`transaction_financial_liability`  double NULL DEFAULT NULL , #交易性金融负债
`derivative_financial_liability`  double NULL DEFAULT NULL , #衍生金融负债
`note_payable`  double NULL DEFAULT NULL , #应付票据
`account_payable`  double NULL DEFAULT NULL , #应付账款
`advance_receipt`  double NULL DEFAULT NULL , #预收款项
`financial_asset_sold_repurchase`  double NULL DEFAULT NULL , #卖出回购金融资产款
`fee_commission_payable`  double NULL DEFAULT NULL , #应付手续费及佣金
`employee_pay_payable`  double NULL DEFAULT NULL , #应付职工薪酬
`tax_payable`  double NULL DEFAULT NULL , #应交税费
`interest_payable`  double NULL DEFAULT NULL , #应付利息
`dividend_payable`  double NULL DEFAULT NULL , #应付股利
`other_fee_payable`  double NULL DEFAULT NULL , #其他应交款
`margin_requirement`  double NULL DEFAULT NULL , #应付保证金
`internal_account_receivable`  double NULL DEFAULT NULL , #内部应付款
`other_payable`  double NULL DEFAULT NULL , #其他应付款
`accrued_expense`  double NULL DEFAULT NULL , #预提费用
`expected_current_liability`  double NULL DEFAULT NULL , #预计流动负债
`reinsurance_payable`  double NULL DEFAULT NULL , #应付分保账款
`insurance_contract_provision`  double NULL DEFAULT NULL , #保险合同准备金
`acting_trading_security`  double NULL DEFAULT NULL , #代理买卖证券款
`acting_underwriting_security`  double NULL DEFAULT NULL , #代理承销证券款
`international_ticket_settlement`  double NULL DEFAULT NULL , #国际票证结算
`domestic_ticket_settlement`  double NULL DEFAULT NULL , #国内票证结算
`deferred_income`  double NULL DEFAULT NULL , #递延收益
`short_term_bond`  double NULL DEFAULT NULL , #应付短期债券
`noncurrent_liability_ayear`  double NULL DEFAULT NULL , #一年内到期的非流动负债
`other_current_liability`  double NULL DEFAULT NULL , #其他流动负债
`total_current_liability`  double NULL DEFAULT NULL , #流动负债合计
`noncurrent_liability`  double NULL DEFAULT NULL , #非流动负债
`long_term_loan`  double NULL DEFAULT NULL , #长期借款
`bond_payable`  double NULL DEFAULT NULL , #应付债券
`long_term_payable`  double NULL DEFAULT NULL , #长期应付款
`special_payable`  double NULL DEFAULT NULL , #专项应付款
`expect_noncurrent_liability`  double NULL DEFAULT NULL , #预计非流动负债
`deferred_tax_liability`  double NULL DEFAULT NULL , #递延所得税负债
`other_noncurrent_liability`  double NULL DEFAULT NULL , #其他非流动负债
`total_noncurrent_liability`  double NULL DEFAULT NULL , #非流动负债合计
`total_liability`  double NULL DEFAULT NULL , #负债合计
`ownership`  double NULL DEFAULT NULL , #所有者权益
`paid_up_capital`  double NULL DEFAULT NULL , #实收资本(或股本)
`capital_reserve`  double NULL DEFAULT NULL , #资本公积
`treasury_stock`  double NULL DEFAULT NULL , #库存股
`special_reserve`  double NULL DEFAULT NULL , #专项储备
`surplus_reserve`  double NULL DEFAULT NULL , #盈余公积
`ordinary_risk_reserve`  double NULL DEFAULT NULL , #一般风险准备
`uncertain_investment_loss`  double NULL DEFAULT NULL , #未确定的投资损失
`undistributed_profit`  double NULL DEFAULT NULL , #未分配利润
`distribution_cash_dividend`  double NULL DEFAULT NULL , #拟分配现金股利
`translation_reserve`  double NULL DEFAULT NULL , #外币报表折算差额
`total_equity_attributable_parent`  double NULL DEFAULT NULL , #归属于母公司股东权益合计
`minority_equity`  double NULL DEFAULT NULL , #少数股东权益
`total_owners_equity`  double NULL DEFAULT NULL , #所有者权益(或股东权益)合计
`liability_total_owners_equity`  double NULL DEFAULT NULL , #负债和所有者权益(或股东权益)总计
PRIMARY KEY (`seq_no`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1
CHECKSUM=0
ROW_FORMAT=FIXED
DELAY_KEY_WRITE=0
;

CREATE TABLE `liability_statement_bank` (
`seq_no`  int(11) NOT NULL AUTO_INCREMENT , #序列号
`stock_id`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL , #股票代码
`statement_date`  date NOT NULL , #报表日期
`unit`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL , #单位
`asset`  double NULL DEFAULT NULL , #资产
`monetary_fund`  double NULL DEFAULT NULL , #货币资金
`among1`  double NULL DEFAULT NULL , #其中:
`storage_central_bank`  double NULL DEFAULT NULL , #存放中央银行款
`balance_deposit`  double NULL DEFAULT NULL , #结算准备金
`precious_metal`  double NULL DEFAULT NULL , #贵金属
`interbank_deposit`  double NULL DEFAULT NULL , #存放同业款项
`lending_fund`  double NULL DEFAULT NULL , #拆出资金
`inter_lending`  double NULL DEFAULT NULL , #其中:拆放同业
`interbank_financial_corporation`  double NULL DEFAULT NULL , #拆放金融性公司
`loan_fellow_bank`  double NULL DEFAULT NULL , #存放联行款项
`note_issuing_fund`  double NULL DEFAULT NULL , #存出发钞基金
`derivative_financial_asset`  double NULL DEFAULT NULL , #衍生金融工具资产
`trading_financial_asset`  double NULL DEFAULT NULL , #交易性金融资产
`redemptory_monetary_capital`  double NULL DEFAULT NULL , #买入返售金融资产
`discount`  double NULL DEFAULT NULL , #贴现
`bill_purchased`  double NULL DEFAULT NULL , #进出口押汇
`account_receivable`  double NULL DEFAULT NULL , #应收账款
`advance_payment`  double NULL DEFAULT NULL , #预付账款
`interest_receivable`  double NULL DEFAULT NULL , #应收利息
`loans_and_advances`  double NULL DEFAULT NULL , #发放贷款及垫款<客户贷款>
`loan_loss_reserve`  double NULL DEFAULT NULL , #减:贷款损失准备
`capital_vicarious_business`  double NULL DEFAULT NULL , #代理业务资产
`salable_finanical_asset`  double NULL DEFAULT NULL , #可供出售金融资产
`heldtomaturity_investment`  double NULL DEFAULT NULL , #持有至到期投资
`other_receivable`  double NULL DEFAULT NULL , #其他应收款
`long_term_receivable`  double NULL DEFAULT NULL , #长期应收款
`longterm_equity_investment`  double NULL DEFAULT NULL , #长期股权投资
`investment_subsidiary`  double NULL DEFAULT NULL , #其中:投资子公司
`investment_property`  double NULL DEFAULT NULL , #投资性房地产
`investment_fund_receivable`  double NULL DEFAULT NULL , #应收投资款项
`deferred_expense`  double NULL DEFAULT NULL , #待摊费用
`net_value_fixed_asset`  double NULL DEFAULT NULL , #固定资产净额 
`construction_in_process`  double NULL DEFAULT NULL , #在建工程
`fixed_asset_liquidation`  double NULL DEFAULT NULL , #固定资产清理
`intangible_asset`  double NULL DEFAULT NULL , #无形资产
`goodwill`  double NULL DEFAULT NULL , #商誉
`longterm_deferred_expenditure`  double NULL DEFAULT NULL , #长期待摊费用
`pending_insolvent_asset`  double NULL DEFAULT NULL , #待处理抵债资产
`insolvent_asset_depreciation_reserve`  double NULL DEFAULT NULL , #减:抵债资产减值准备
`net_pending_insolvent_asset`  double NULL DEFAULT NULL , #待处理抵债资产净额
`deferred_tax_asset`  double NULL DEFAULT NULL , #递延税款借项
`bad_loss_special_preparation`  double NULL DEFAULT NULL , #其他资产
`other_asset`  double NULL DEFAULT NULL , #减:不良资产处置损失专项准备
`total_asset`  double NULL DEFAULT NULL , #资产总计
`liability`  double NULL DEFAULT NULL , #负债
`money_debt`  double NULL DEFAULT NULL , #向中央银行借款
`loan_central_bank`  double NULL DEFAULT NULL , #发行货币债务
`interbank_deposit_borrowing`  double NULL DEFAULT NULL , #同业存入及拆入
`interbank_deposit2`  double NULL DEFAULT NULL , #其中:同业存放款项
`borrowing_money`  double NULL DEFAULT NULL , #拆入资金
`loan_fellow_bank2`  double NULL DEFAULT NULL , #联行存放款项
`foreign_government_loan`  double NULL DEFAULT NULL , #外国政府借款
`derivative_financial_liability`  double NULL DEFAULT NULL , #衍生金融工具负债
`transaction_financial_liability`  double NULL DEFAULT NULL , #交易性金融负债
`financial_asset_sold_repurchase`  double NULL DEFAULT NULL , #卖出回购金融资产款
`customer_deposit`  double NULL DEFAULT NULL , #客户存款<吸收存款>
`bill_financing`  double NULL DEFAULT NULL , #票据融资
`remittance_temporary_deposit`  double NULL DEFAULT NULL , #应解汇款及临时存款
`accrued_expense`  double NULL DEFAULT NULL , #预提费用
`issuance_certificate_deposit`  double NULL DEFAULT NULL , #发行存款证
`outward_remittance`  double NULL DEFAULT NULL , #汇出汇款
`among2`  double NULL DEFAULT NULL , #其中:
`welfare_payable`  double NULL DEFAULT NULL , #应付福利费
`tax_payable`  double NULL DEFAULT NULL , #应交税费
`interest_payable`  double NULL DEFAULT NULL , #应付利息
`account_payable`  double NULL DEFAULT NULL , #应付账款
`special_payable`  double NULL DEFAULT NULL , #专项应付款
`dividend_payable`  double NULL DEFAULT NULL , #应付股利
`other_fee_payable`  double NULL DEFAULT NULL , #其他应付款
`liability_vicarious_business`  double NULL DEFAULT NULL , #代理业务负债
`expected_liability`  double NULL DEFAULT NULL , #预计负债
`deferred_income`  double NULL DEFAULT NULL , #递延收益
`long_term_payable`  double NULL DEFAULT NULL , #长期应付款
`bond_payable`  double NULL DEFAULT NULL , #应付债券
`subprime_bond_payable`  double NULL DEFAULT NULL , #其中:应付次级债券
`deferred_tax_liability`  double NULL DEFAULT NULL , #递延所得税负债
`other_liability`  double NULL DEFAULT NULL , #其他负债
`total_liability`  double NULL DEFAULT NULL , #负债合计
`ownership`  double NULL DEFAULT NULL , #所有者权益
`paid_up_capital`  double NULL DEFAULT NULL , #股本
`capital_reserve`  double NULL DEFAULT NULL , #资本公积
`salable_investment unrealized_gl`  double NULL DEFAULT NULL , #可供出售类投资未实现损益(公允价值变动储备)
`heldtomaturity_investment_gl`  double NULL DEFAULT NULL , #持有至到期投资未结转损益
`treasury_stock`  double NULL DEFAULT NULL , #减:库藏股
`surplus_reserve`  double NULL DEFAULT NULL , #盈余公积
`ordinary_risk_reserve`  double NULL DEFAULT NULL , #一般风险准备
`trust_compensation_reserve`  double NULL DEFAULT NULL , #信托赔偿准备金
`undistributed_profit`  double NULL DEFAULT NULL , #未分配利润
`distribution_cash_dividend`  double NULL DEFAULT NULL , #其中:拟分配现金股利
`translation_reserve`  double NULL DEFAULT NULL , #外币报表折算差额
`other_reserve`  double NULL DEFAULT NULL , #其他储备
`total_equity_attributable_parent`  double NULL DEFAULT NULL , #归属于母公司股东的权益
`minority_equity`  double NULL DEFAULT NULL , #少数股东权益
`total_owners_equity`  double NULL DEFAULT NULL , #股东权益合计
`liability_total_owners_equity`  double NULL DEFAULT NULL , #负债及股东权益总计
PRIMARY KEY (`seq_no`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1
CHECKSUM=0
ROW_FORMAT=FIXED
DELAY_KEY_WRITE=0
;