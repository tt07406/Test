CREATE TABLE `cash_statement_bank` (
`seq_no`  int(11) NOT NULL AUTO_INCREMENT , #序列号
`stock_id`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL , #股票代码
`statement_date`  date NOT NULL , #报表日期
`unit`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL , #单位
`cash_flow_operating`  double NULL DEFAULT NULL ,  #一、经营活动产生的现金流量
`net_reduction_loan_advance`  double NULL DEFAULT NULL , #客户贷款及垫款净减少额
`net_increase_loan_cb`  double NULL DEFAULT NULL , #向央行借款净增加额
`net_increase_deposit_interbank`  double NULL DEFAULT NULL , #客户存款和同业存放款项净增加额
`customer_deposit`  double NULL DEFAULT NULL , #其中:客户存款
`interbank_other_financial_deposit`  double NULL DEFAULT NULL , #同业及其他金融机构存放款
`recover_net_interbank_financial`  double NULL DEFAULT NULL , #收回存放同业及其他金融机构净额
`inflow_capital_borrowed_cash`  double NULL DEFAULT NULL , #拆入资金现金流入
`net_lending_capital_withdraw`  double NULL DEFAULT NULL , #收回的拆出资金净额
`absorption_repurchase_proceed`  double NULL DEFAULT NULL , #吸收的卖出回购项净额
`back_purchase_resale_proceed`  double NULL DEFAULT NULL , #收回的买入返售项净额
`net_increase_disposal_financial`  double NULL DEFAULT NULL , #处置交易性金融资产净增加额
`interest_charge_fee_commission`  double NULL DEFAULT NULL , #收取利息、手续费及佣金的现金
`interest_received`  double NULL DEFAULT NULL , #其中:收到利息
`fee_received`  double NULL DEFAULT NULL , #收到的手续费
`cash_income_financial_received`  double NULL DEFAULT NULL , #金融企业往来收入收到的现金
`cash_intermediate_business_received`  double NULL DEFAULT NULL , #中间业务收入收到的现金
`cash_exchange_net_received`  double NULL DEFAULT NULL , #汇兑净收益收到的现金
`cash_other_net_received`  double NULL DEFAULT NULL , #其他营业及营业外净收入收到的现金
`cash_margin_deposit_received`  double NULL DEFAULT NULL , #存入保证金收到的现金
`entrust_fund_received`  double NULL DEFAULT NULL , #收到的委托资金
`cash_inflow_precious_metal`  double NULL DEFAULT NULL , #贵金属现金流入
`cash_discount_received`  double NULL DEFAULT NULL , #贴现收到的现金
`cash_sale_labour_received`  double NULL DEFAULT NULL , #销售商品、提供劳务收到的现金
`refund_tax_received`  double NULL DEFAULT NULL , #收到的税费返还
`cash_other_liability_increase`  double NULL DEFAULT NULL , #其他负债增加流入的现金
`back_verification_loan_receivable`  double NULL DEFAULT NULL , #收回的已于以前年度核销的贷款及应收款项
`cash_reduce_other_payable`  double NULL DEFAULT NULL , #其他应付暂收款减少流出的现金
`cash_disposal_asset_received`  double NULL DEFAULT NULL , #处置抵债资产收到的现金
`cash_other_operating_received`  double NULL DEFAULT NULL , #收到其他与经营活动有关的现金
`subtotal_cash_inflow_operating`  double NULL DEFAULT NULL , #经营活动现金流入小计
`net_increase_loan_advance`  double NULL DEFAULT NULL , #客户贷款及垫款净增加额
`net_increase_cb_interbank`  double NULL DEFAULT NULL , #存放中央银行和同业款项净增加额
`deposit_centre_bank`  double NULL DEFAULT NULL , #其中:存放中央银行
`saving_interbank_other_institution`  double NULL DEFAULT NULL , #存放同业及其他机构存款
`net_cash_lending_outflow`  double NULL DEFAULT NULL , #拆出资金净现金流出
`central_bank_loan_repayment`  double NULL DEFAULT NULL , #偿还中央银行借款(向中央银行借款净减少额)
`deposit_paid`  double NULL DEFAULT NULL , #支付的存款
`net_deposit_reduce_financial`  double NULL DEFAULT NULL , #减少同业及其他金融机构存放净额
`net_borrowing_repayment_financial`  double NULL DEFAULT NULL , #偿还同业及其他金融机构拆入净额
`repayment_repurchase_net_proceed`  double NULL DEFAULT NULL , #偿还卖出回购款项净额
`security_investment_spending_cash`  double NULL DEFAULT NULL , #证券投资支出的现金
`payment_resale_proceed_net`  double NULL DEFAULT NULL , #支付买入返售款项净额
`disposal_salable_net_decrease`  double NULL DEFAULT NULL , #处置可供出售金融资产净减少额
`payment_interest_fee_commission`  double NULL DEFAULT NULL ,  #支付利息、手续费及佣金的现金
`interest_paid`  double NULL DEFAULT NULL , #其中:支付的利息
`commission_expense_paid_cash`  double NULL DEFAULT NULL , #手续费支出支付的现金
`payment_employee_cash`  double NULL DEFAULT NULL , #支付给职工以及为职工支付的现金
`tax_payment`  double NULL DEFAULT NULL , #支付的各项税费
`operating_expense_cash_payment`  double NULL DEFAULT NULL , #以现金支付的营业费用
`net_cash_transaction_financial`  double NULL DEFAULT NULL , #与金融机构往来支出的现金净额
`discount_cash_payment`  double NULL DEFAULT NULL , #贴现支付的现金
`writeoff_loan_interest_withdraw`  double NULL DEFAULT NULL , #已核销呆账贷款及利息收回
`reduce_principal_agent_busines`  double NULL DEFAULT NULL , #委托及代理业务减少额
`cash_outflow_precious_metal`  double NULL DEFAULT NULL , #贵金属现金流出
`pay_cash_purchase_labour`  double NULL DEFAULT NULL , #购买商品、接受劳务支付的现金
`net_reduction_borrowing_fund`  double NULL DEFAULT NULL , #借入其他资金净减少额
`cash_decrease_other_asset`  double NULL DEFAULT NULL , #其他资产减少支出的现金
`cash_decrease_other_receivable`  double NULL DEFAULT NULL , #其他应收暂付款减少收回的现金
`payment_cash_other_operating`  double NULL DEFAULT NULL , #支付其他与经营活动有关的现金
`subtotal_cash_outflow_operating`  double NULL DEFAULT NULL , #经营活动现金流出小计
`net_cash_flow_operating`  double NULL DEFAULT NULL , #经营活动产生的现金流量净额
`cash_flow_investment`  double NULL DEFAULT NULL , #二、投资活动产生的现金流量：
`cash_received_investment`  double NULL DEFAULT NULL , #收回投资收到的现金
`cash_received_investment_income`  double NULL DEFAULT NULL , #取得投资收益收到的现金
`dividend_profit_cash_received`  double NULL DEFAULT NULL , #其中:分得股利或利润所收到的现金
`cash_bond_interest_income`  double NULL DEFAULT NULL , #取得债券利息收入收到的现金
`disposal_asset_cash_received`  double NULL DEFAULT NULL , #处置固定资产、无形资产及其他资产而收到的现金
`disposal_equity_investment_cash`  double NULL DEFAULT NULL , #处置股权投资所收到的现金
`net_cash_subsidiaries_received`  double NULL DEFAULT NULL , #取得子公司及其他营业单位所收到的现金净额
`cash_received_other_investing`  double NULL DEFAULT NULL , #收到其他与投资活动有关的现金
`subtotal_cash_inflow_investment`  double NULL DEFAULT NULL , #投资活动现金流入小计
`cash_payment_investment`  double NULL DEFAULT NULL , #投资支付的现金
`equity_investment_increase_cash`  double NULL DEFAULT NULL , #其中:权益性投资增加支付的现金
`cash_paid_bond_investment`  double NULL DEFAULT NULL , #债券投资所支付的现金
`net_cash_paid_buying`  double NULL DEFAULT NULL , #购买子公司、联营企业及合营企业投资所支付的现金净额
`cash_paid_increase_construction`  double NULL DEFAULT NULL , #增加在建工程所支付的现金
`cash_paid_acquire_asset`  double NULL DEFAULT NULL , #购建固定资产、无形资产和其他长期资产支付的现金
`net_cash_subsidiaries_payable`  double NULL DEFAULT NULL , #取得子公司及其他营业单位支付的现金净额
`cash_received_other_operating`  double NULL DEFAULT NULL , #支付的其他与投资活动有关的现金
`subtotal_cash_outflow_investment`  double NULL DEFAULT NULL , #投资活动现金流出小计
`net_cash_outflow_investment`  double NULL DEFAULT NULL , #投资活动产生的现金流量净额
`cash_flow_fund_raising`  double NULL DEFAULT NULL , #三、筹资活动产生的现金流量：
`cash_received_capital_contribution`  double NULL DEFAULT NULL , #吸收投资所收到的现金
`asset_securitization_absorption_cash`  double NULL DEFAULT NULL , #发行证券化资产所吸收的现金
`cash_received_issuing_bond`  double NULL DEFAULT NULL , #发行债券收到的现金
`cash_received_subordinated_bond`  double NULL DEFAULT NULL , #其中:发行次级债券收到的现金
`cash_received_increase_equity`  double NULL DEFAULT NULL , #增加股本所收到的现金
`cash_received_other_financing`  double NULL DEFAULT NULL , #收到其他与筹资活动有关的现金
`subtotal_cash_inflow_financing`  double NULL DEFAULT NULL , #筹资活动现金流入小计
`cash_paid_repayments_debt`  double NULL DEFAULT NULL , #偿还债务所支付的现金
`payment_interest_dividend_profit`  double NULL DEFAULT NULL , #分配股利、利润或偿付利息支付的现金
`cash_payment_interest`  double NULL DEFAULT NULL , #其中:偿付利息所支付的现金
`payment_new_stock_expense`  double NULL DEFAULT NULL , #支付新股发行费用
`cash_payment_other_financing`  double NULL DEFAULT NULL , #支付其他与筹资活动有关的现金
`subtotal_cash_outflow_financing`  double NULL DEFAULT NULL , #筹资活动现金流出小计
`net_cash_flow_financing`  double NULL DEFAULT NULL , #筹资活动产生的现金流量净额
`cash_influence_fluctuation_exchange`  double NULL DEFAULT NULL , #四、汇率变动对现金及现金等价物的影响
`net_increase_cash_equivalent`  double NULL DEFAULT NULL , #五、现金及现金等价物净增加额
`beginning_balance_cash_equivalent`  double NULL DEFAULT NULL , #加:期初现金及现金等价物余额
`final_balance_cash_equivalent`  double NULL DEFAULT NULL , #六、期末现金及现金等价物余额
`footnote`  double NULL DEFAULT NULL , #附注
`net_profit`  double NULL DEFAULT NULL , #净利润
`minority_shareholder_benefit`  double NULL DEFAULT NULL , #加:少数股东收益
`provisional_capital_depreciation`  double NULL DEFAULT NULL , #计提的资产减值准备
`provisional_bad_debt`  double NULL DEFAULT NULL , #其中：计提的坏账准备
`provisional_loan_loss`  double NULL DEFAULT NULL , #计提的贷款损失准备
`dashed_back_nostro_impairment`  double NULL DEFAULT NULL , #冲回存放同业减值准备
`fixed_og_biological_depreciation`  double NULL DEFAULT NULL , #固定资产折旧、油气资产折耗、生产性生物资产折旧
`investment_real_estate_depreciation`  double NULL DEFAULT NULL , #投资性房地产折旧
`amortization_intangible_deferred_other`  double NULL DEFAULT NULL , #无形资产、递延资产及其他资产的摊销
`amortization_intangible_asset`  double NULL DEFAULT NULL , #其中:无形资产摊销
`amortisation_long_deferred_expense`  double NULL DEFAULT NULL , #长期待摊费用摊销
`amortization_long_term_asset`  double NULL DEFAULT NULL , #长期资产摊销
`loss_disposing_long_asset`  double NULL DEFAULT NULL , #处置固定资产、无形资产和其他长期产的损失/(收益)
`loss_disposing_investment_property`  double NULL DEFAULT NULL , #处置投资性房地产的损失/(收益)
`loss_retirement_fixed_asset`  double NULL DEFAULT NULL , #固定资产报废损失
`financial_expense`  double NULL DEFAULT NULL , #财务费用
`investment_loss`  double NULL DEFAULT NULL , #投资损失(减:收益)
`change_fair_value`  double NULL DEFAULT NULL , #公允价值变动(收益)/损失
`exchange_gain_loss`  double NULL DEFAULT NULL , #汇兑损益
`net_gl_derivative_financial`  double NULL DEFAULT NULL , #衍生金融工具交易净损益
`discounted_back_pull`  double NULL DEFAULT NULL , #折现回拔(减值资产利息冲转)
`decrease_inventory`  double NULL DEFAULT NULL , #存货的减少
`decrease_loan`  double NULL DEFAULT NULL , #贷款的减少
`increase_deposit`  double NULL DEFAULT NULL , #存款的增加
`lending_money_net`  double NULL DEFAULT NULL , #拆借款项的净增
`reduction_financial_asset`  double NULL DEFAULT NULL , #金融性资产的减少
`increase_estimated_liability`  double NULL DEFAULT NULL , #预计负债的增加
`payment_verification_received`  double NULL DEFAULT NULL , #收到已核销款项
`reduction_deferred_tax_asset`  double NULL DEFAULT NULL , #递延所得税资产的减少
`increase_deferred_tax_liability`  double NULL DEFAULT NULL , #递延所得税负债的增加
`increase_operating_receivable`  double NULL DEFAULT NULL , #经营性应收项目的增加
`increase_operating_payable`  double NULL DEFAULT NULL , #经营性应付项目的增加
`decrease_operating_other_asset`  double NULL DEFAULT NULL , #经营性其他资产的减少
`increase_operating_other_liability`  double NULL DEFAULT NULL , #经营性其他负债的增加
`other`  double NULL DEFAULT NULL , #其他
`net_cash_flow_operating2`  double NULL DEFAULT NULL , #经营活动现金流量净额
`fixed_assets_repay_debt`  double NULL DEFAULT NULL , #以固定资产偿还债务
`investment_repay_debt`  double NULL DEFAULT NULL , #以投资偿还债务
`investment_fixed_asset`  double NULL DEFAULT NULL , #以固定资产进行投资
`conversion_debt_capital`  double NULL DEFAULT NULL , #债务转为资本
`conver_tible_bond_ayear`  double NULL DEFAULT NULL , #一年内到期的可转换公司债券
`fixed_assets_financing_lease`  double NULL DEFAULT NULL , #融资租入固定资产
`other_noncash_financing`  double NULL DEFAULT NULL , #其他不涉及现金收支的投资和筹资活动金额
`cash_final_balance`  double NULL DEFAULT NULL , #现金的期末余额
`cash_beginning_balance`  double NULL DEFAULT NULL , #减:现金的期初余额
`cash_equivalent_final_balance`  double NULL DEFAULT NULL , #现金等价物的期末余额
`cash_equivalent_beginning_balance`  double NULL DEFAULT NULL , #减：现金等价物的期初余额
`net_increase_cash_equivalent2`  double NULL DEFAULT NULL , #现金及现金等价物净增加额
PRIMARY KEY (`seq_no`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1
CHECKSUM=0
ROW_FORMAT=FIXED
DELAY_KEY_WRITE=0
;

CREATE TABLE `cash_statement` (
`seq_no`  int(11) NOT NULL AUTO_INCREMENT , #序列号
`stock_id`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL , #股票代码
`statement_date`  date NOT NULL , #报表日期
`unit`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL , #单位
`cash_flow_operating`  double NULL DEFAULT NULL , #一、经营活动产生的现金流量
`cash_sale_labour_received`  double NULL DEFAULT NULL , #销售商品、提供劳务收到的现金
`net_increase_deposit_interbank`  double NULL DEFAULT NULL , #客户存款和同业存放款项净增加额
`net_increase_loan_cb`  double NULL DEFAULT NULL , #向中央银行借款净增加额
`net_increase_loan_otherfinan`  double NULL DEFAULT NULL , #向其他金融机构拆入资金净增加额
`primary_insurance_premium_received`  double NULL DEFAULT NULL , #收到原保险合同保费取得的现金
`reinsurance_business_net_received`  double NULL DEFAULT NULL , #收到再保险业务现金净额
`net_increase_deposit_investment`  double NULL DEFAULT NULL , #保户储金及投资款净增加额
`net_increase_disposal_financial`  double NULL DEFAULT NULL , #处置交易性金融资产净增加额
`interest_fee_commission_received`  double NULL DEFAULT NULL , #收取利息、手续费及佣金的现金
`net_increase_capital_borrowed`  double NULL DEFAULT NULL , #拆入资金净增加额
`net_increase_repurchase_capital`  double NULL DEFAULT NULL , #回购业务资金净增加额
`refund_tax_received`  double NULL DEFAULT NULL , #收到的税费返还
`cash_other_operating_received`  double NULL DEFAULT NULL , #收到的其他与经营活动有关的现金
`subtotal_cash_inflow_operating`  double NULL DEFAULT NULL , #经营活动现金流入小计
`cash_sale_labour_payable`  double NULL DEFAULT NULL , #购买商品、接受劳务支付的现金
`net_increase_loan_advance`  double NULL DEFAULT NULL , #客户贷款及垫款净增加额
`net_increase_cb_interbank`  double NULL DEFAULT NULL , #存放中央银行和同业款项净增加额
`primary_insurance_premium_payable`  double NULL DEFAULT NULL , #支付原保险合同赔付款项的现金
`interest_fee_commission_payable`  double NULL DEFAULT NULL , #支付利息、手续费及佣金的现金
`cash_policy_dividend_payable`  double NULL DEFAULT NULL , #支付保单红利的现金
`payment_employee_cash`  double NULL DEFAULT NULL , #支付给职工以及为职工支付的现金
`tax_payment`  double NULL DEFAULT NULL , #支付的各项税费
`payment_cash_other_operating`  double NULL DEFAULT NULL , #支付的其他与经营活动有关的现金
`subtotal_cash_outflow_operating`  double NULL DEFAULT NULL , #经营活动现金流出小计
`net_cash_flow_operating`  double NULL DEFAULT NULL , #经营活动产生的现金流量净额
`cash_flow_investment`  double NULL DEFAULT NULL , #二、投资活动产生的现金流量：
`cash_received_investment`  double NULL DEFAULT NULL , #收回投资所收到的现金
`cash_received_investment_income`  double NULL DEFAULT NULL , #取得投资收益所收到的现金
`disposal_asset_cash_received`  double NULL DEFAULT NULL , #处置固定资产、无形资产和其他长期资产所收回的现金净额
`net_cash_subsidiaries_received`  double NULL DEFAULT NULL , #处置子公司及其他营业单位收到的现金净额
`cash_received_other_investing`  double NULL DEFAULT NULL , #收到的其他与投资活动有关的现金
`reduce_deposit_cash_pledge`  double NULL DEFAULT NULL , #减少质押和定期存款所收到的现金
`subtotal_cash_inflow_investment`  double NULL DEFAULT NULL , #投资活动现金流入小计
`cash_paid_acquire_asset`  double NULL DEFAULT NULL , #购建固定资产、无形资产和其他长期资产所支付的现金
`cash_payment_investment`  double NULL DEFAULT NULL , #投资所支付的现金
`net_increase_mortgage_loan`  double NULL DEFAULT NULL , #质押贷款净增加额
`net_cash_subsidiaries_payable`  double NULL DEFAULT NULL , #取得子公司及其他营业单位支付的现金净额
`cash_investment_other_payable`  double NULL DEFAULT NULL , #支付的其他与投资活动有关的现金
`increase_pledge_deposit_payable`  double NULL DEFAULT NULL , #增加质押和定期存款所支付的现金
`subtotal_cash_outflow_investment`  double NULL DEFAULT NULL , #投资活动现金流出小计
`net_cash_outflow_investment`  double NULL DEFAULT NULL , #投资活动产生的现金流量净额
`cash_flow_fund_raising`  double NULL DEFAULT NULL , #三、筹资活动产生的现金流量：
`cash_received_capital_contribution`  double NULL DEFAULT NULL , #吸收投资收到的现金
`minority_shareholder_investment_subsidiary`  double NULL DEFAULT NULL , #其中：子公司吸收少数股东投资收到的现金
`cash_received_loan`  double NULL DEFAULT NULL , #取得借款收到的现金
`cash_received_issuing_bond`  double NULL DEFAULT NULL , #发行债券收到的现金
`cash_received_other_financing`  double NULL DEFAULT NULL , #收到其他与筹资活动有关的现金
`subtotal_cash_inflow_financing`  double NULL DEFAULT NULL , #筹资活动现金流入小计
`cash_paid_repayments_debt`  double NULL DEFAULT NULL , #偿还债务支付的现金
`payment_interest_dividend_profit`  double NULL DEFAULT NULL , #分配股利、利润或偿付利息所支付的现金
`blank`  double NULL DEFAULT NULL , #空白
`cash_payment_other_financing`  double NULL DEFAULT NULL , #支付其他与筹资活动有关的现金
`subtotal_cash_outflow_financing`  double NULL DEFAULT NULL , #筹资活动现金流出小计
`net_cash_flow_financing`  double NULL DEFAULT NULL , #筹资活动产生的现金流量净额
`footnote`  double NULL DEFAULT NULL , #附注
`cash_influence_fluctuation_exchange`  double NULL DEFAULT NULL , #汇率变动对现金及现金等价物的影响
`net_increase_cash_equivalent`  double NULL DEFAULT NULL , #现金及现金等价物净增加额
`beginning_balance_cash_equivalent`  double NULL DEFAULT NULL , #期初现金及现金等价物余额
`final_balance_cash_equivalent`  double NULL DEFAULT NULL , #期末现金及现金等价物余额
`net_profit`  double NULL DEFAULT NULL , #净利润
`minority_shareholder_benefit`  double NULL DEFAULT NULL , #少数股东权益
`unrecognized_investment_loss`  double NULL DEFAULT NULL , #未确认的投资损失
`asset_depreciation_reserve`  double NULL DEFAULT NULL , #资产减值准备
`fixed_og_biological_depreciation`  double NULL DEFAULT NULL , #固定资产折旧、油气资产折耗、生产性物资折旧
`amortization_intangible_asset`  double NULL DEFAULT NULL , #无形资产摊销
`amortisation_long_deferred_expense`  double NULL DEFAULT NULL , #长期待摊费用摊销
`reduction_deferred_expense`  double NULL DEFAULT NULL , #待摊费用的减少
`increase_accrued_expense`  double NULL DEFAULT NULL , #预提费用的增加
`loss_disposing_long_asset`  double NULL DEFAULT NULL , #处置固定资产、无形资产和其他长期资产的损失
`loss_retirement_fixed_asset`  double NULL DEFAULT NULL , #固定资产报废损失
`change_fair_value`  double NULL DEFAULT NULL , #公允价值变动损失
`deferred_revenue_increase`  double NULL DEFAULT NULL , #递延收益增加（减：减少）
`anticipation_liability`  double NULL DEFAULT NULL , #预计负债
`financial_expense`  double NULL DEFAULT NULL , #财务费用
`investment_loss`  double NULL DEFAULT NULL , #投资损失
`reduction_deferred_tax_asset`  double NULL DEFAULT NULL , #递延所得税资产减少
`increase_deferred_tax_liability`  double NULL DEFAULT NULL ,  #递延所得税负债增加
`decrease_inventory`  double NULL DEFAULT NULL , #存货的减少
`reduction_operating_receivable`  double NULL DEFAULT NULL , #经营性应收项目的减少
`increase_operating_payable`  double NULL DEFAULT NULL , #经营性应付项目的增加
`paragraph_reduction_completed_yet`  double NULL DEFAULT NULL , #已完工尚未结算款的减少(减:增加)
`settlement_increase_yet_completed`  double NULL DEFAULT NULL , #已结算尚未完工款的增加(减:减少)
`other`  double NULL DEFAULT NULL , #其他
`net_cash_flow_operating2`  double NULL DEFAULT NULL , #经营活动产生现金流量净额
`conversion_debt_capital`  double NULL DEFAULT NULL , #债务转为资本
`conver_tible_bond_ayear`  double NULL DEFAULT NULL , #一年内到期的可转换公司债券
`fixed_assets_financing_lease`  double NULL DEFAULT NULL , #融资租入固定资产
`cash_final_balance`  double NULL DEFAULT NULL , #现金的期末余额
`cash_beginning_balance`  double NULL DEFAULT NULL , #现金的期初余额 
`cash_equivalent_final_balance`  double NULL DEFAULT NULL , #现金等价物的期末余额
`cash_equivalent_beginning_balance`  double NULL DEFAULT NULL , #现金等价物的期初余额
`net_increase_cash_equivalent2`  double NULL DEFAULT NULL , #现金及现金等价物的净增加额
PRIMARY KEY (`seq_no`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1
CHECKSUM=0
ROW_FORMAT=FIXED
DELAY_KEY_WRITE=0
;
