CREATE TABLE `cash_statement_bank` (
`seq_no`  int(11) NOT NULL AUTO_INCREMENT , #���к�
`stock_id`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL , #��Ʊ����
`statement_date`  date NOT NULL , #��������
`unit`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL , #��λ
`cash_flow_operating`  double NULL DEFAULT NULL ,  #һ����Ӫ��������ֽ�����
`net_reduction_loan_advance`  double NULL DEFAULT NULL , #�ͻ���������ٶ�
`net_increase_loan_cb`  double NULL DEFAULT NULL , #�����н����Ӷ�
`net_increase_deposit_interbank`  double NULL DEFAULT NULL , #�ͻ�����ͬҵ��ſ�����Ӷ�
`customer_deposit`  double NULL DEFAULT NULL , #����:�ͻ����
`interbank_other_financial_deposit`  double NULL DEFAULT NULL , #ͬҵ���������ڻ�����ſ�
`recover_net_interbank_financial`  double NULL DEFAULT NULL , #�ջش��ͬҵ���������ڻ�������
`inflow_capital_borrowed_cash`  double NULL DEFAULT NULL , #�����ʽ��ֽ�����
`net_lending_capital_withdraw`  double NULL DEFAULT NULL , #�ջصĲ���ʽ𾻶�
`absorption_repurchase_proceed`  double NULL DEFAULT NULL , #���յ������ع����
`back_purchase_resale_proceed`  double NULL DEFAULT NULL , #�ջص����뷵�����
`net_increase_disposal_financial`  double NULL DEFAULT NULL , #���ý����Խ����ʲ������Ӷ�
`interest_charge_fee_commission`  double NULL DEFAULT NULL , #��ȡ��Ϣ�������Ѽ�Ӷ����ֽ�
`interest_received`  double NULL DEFAULT NULL , #����:�յ���Ϣ
`fee_received`  double NULL DEFAULT NULL , #�յ���������
`cash_income_financial_received`  double NULL DEFAULT NULL , #������ҵ���������յ����ֽ�
`cash_intermediate_business_received`  double NULL DEFAULT NULL , #�м�ҵ�������յ����ֽ�
`cash_exchange_net_received`  double NULL DEFAULT NULL , #��Ҿ������յ����ֽ�
`cash_other_net_received`  double NULL DEFAULT NULL , #����Ӫҵ��Ӫҵ�⾻�����յ����ֽ�
`cash_margin_deposit_received`  double NULL DEFAULT NULL , #���뱣֤���յ����ֽ�
`entrust_fund_received`  double NULL DEFAULT NULL , #�յ���ί���ʽ�
`cash_inflow_precious_metal`  double NULL DEFAULT NULL , #������ֽ�����
`cash_discount_received`  double NULL DEFAULT NULL , #�����յ����ֽ�
`cash_sale_labour_received`  double NULL DEFAULT NULL , #������Ʒ���ṩ�����յ����ֽ�
`refund_tax_received`  double NULL DEFAULT NULL , #�յ���˰�ѷ���
`cash_other_liability_increase`  double NULL DEFAULT NULL , #������ծ����������ֽ�
`back_verification_loan_receivable`  double NULL DEFAULT NULL , #�ջص�������ǰ��Ⱥ����Ĵ��Ӧ�տ���
`cash_reduce_other_payable`  double NULL DEFAULT NULL , #����Ӧ�����տ�����������ֽ�
`cash_disposal_asset_received`  double NULL DEFAULT NULL , #���õ�ծ�ʲ��յ����ֽ�
`cash_other_operating_received`  double NULL DEFAULT NULL , #�յ������뾭Ӫ��йص��ֽ�
`subtotal_cash_inflow_operating`  double NULL DEFAULT NULL , #��Ӫ��ֽ�����С��
`net_increase_loan_advance`  double NULL DEFAULT NULL , #�ͻ���������Ӷ�
`net_increase_cb_interbank`  double NULL DEFAULT NULL , #����������к�ͬҵ������Ӷ�
`deposit_centre_bank`  double NULL DEFAULT NULL , #����:�����������
`saving_interbank_other_institution`  double NULL DEFAULT NULL , #���ͬҵ�������������
`net_cash_lending_outflow`  double NULL DEFAULT NULL , #����ʽ��ֽ�����
`central_bank_loan_repayment`  double NULL DEFAULT NULL , #�����������н��(���������н����ٶ�)
`deposit_paid`  double NULL DEFAULT NULL , #֧���Ĵ��
`net_deposit_reduce_financial`  double NULL DEFAULT NULL , #����ͬҵ���������ڻ�����ž���
`net_borrowing_repayment_financial`  double NULL DEFAULT NULL , #����ͬҵ���������ڻ������뾻��
`repayment_repurchase_net_proceed`  double NULL DEFAULT NULL , #���������ع������
`security_investment_spending_cash`  double NULL DEFAULT NULL , #֤ȯͶ��֧�����ֽ�
`payment_resale_proceed_net`  double NULL DEFAULT NULL , #֧�����뷵�ۿ����
`disposal_salable_net_decrease`  double NULL DEFAULT NULL , #���ÿɹ����۽����ʲ������ٶ�
`payment_interest_fee_commission`  double NULL DEFAULT NULL ,  #֧����Ϣ�������Ѽ�Ӷ����ֽ�
`interest_paid`  double NULL DEFAULT NULL , #����:֧������Ϣ
`commission_expense_paid_cash`  double NULL DEFAULT NULL , #������֧��֧�����ֽ�
`payment_employee_cash`  double NULL DEFAULT NULL , #֧����ְ���Լ�Ϊְ��֧�����ֽ�
`tax_payment`  double NULL DEFAULT NULL , #֧���ĸ���˰��
`operating_expense_cash_payment`  double NULL DEFAULT NULL , #���ֽ�֧����Ӫҵ����
`net_cash_transaction_financial`  double NULL DEFAULT NULL , #����ڻ�������֧�����ֽ𾻶�
`discount_cash_payment`  double NULL DEFAULT NULL , #����֧�����ֽ�
`writeoff_loan_interest_withdraw`  double NULL DEFAULT NULL , #�Ѻ������˴����Ϣ�ջ�
`reduce_principal_agent_busines`  double NULL DEFAULT NULL , #ί�м�����ҵ����ٶ�
`cash_outflow_precious_metal`  double NULL DEFAULT NULL , #������ֽ�����
`pay_cash_purchase_labour`  double NULL DEFAULT NULL , #������Ʒ����������֧�����ֽ�
`net_reduction_borrowing_fund`  double NULL DEFAULT NULL , #���������ʽ𾻼��ٶ�
`cash_decrease_other_asset`  double NULL DEFAULT NULL , #�����ʲ�����֧�����ֽ�
`cash_decrease_other_receivable`  double NULL DEFAULT NULL , #����Ӧ���ݸ�������ջص��ֽ�
`payment_cash_other_operating`  double NULL DEFAULT NULL , #֧�������뾭Ӫ��йص��ֽ�
`subtotal_cash_outflow_operating`  double NULL DEFAULT NULL , #��Ӫ��ֽ�����С��
`net_cash_flow_operating`  double NULL DEFAULT NULL , #��Ӫ��������ֽ���������
`cash_flow_investment`  double NULL DEFAULT NULL , #����Ͷ�ʻ�������ֽ�������
`cash_received_investment`  double NULL DEFAULT NULL , #�ջ�Ͷ���յ����ֽ�
`cash_received_investment_income`  double NULL DEFAULT NULL , #ȡ��Ͷ�������յ����ֽ�
`dividend_profit_cash_received`  double NULL DEFAULT NULL , #����:�ֵù������������յ����ֽ�
`cash_bond_interest_income`  double NULL DEFAULT NULL , #ȡ��ծȯ��Ϣ�����յ����ֽ�
`disposal_asset_cash_received`  double NULL DEFAULT NULL , #���ù̶��ʲ��������ʲ��������ʲ����յ����ֽ�
`disposal_equity_investment_cash`  double NULL DEFAULT NULL , #���ù�ȨͶ�����յ����ֽ�
`net_cash_subsidiaries_received`  double NULL DEFAULT NULL , #ȡ���ӹ�˾������Ӫҵ��λ���յ����ֽ𾻶�
`cash_received_other_investing`  double NULL DEFAULT NULL , #�յ�������Ͷ�ʻ�йص��ֽ�
`subtotal_cash_inflow_investment`  double NULL DEFAULT NULL , #Ͷ�ʻ�ֽ�����С��
`cash_payment_investment`  double NULL DEFAULT NULL , #Ͷ��֧�����ֽ�
`equity_investment_increase_cash`  double NULL DEFAULT NULL , #����:Ȩ����Ͷ������֧�����ֽ�
`cash_paid_bond_investment`  double NULL DEFAULT NULL , #ծȯͶ����֧�����ֽ�
`net_cash_paid_buying`  double NULL DEFAULT NULL , #�����ӹ�˾����Ӫ��ҵ����Ӫ��ҵͶ����֧�����ֽ𾻶�
`cash_paid_increase_construction`  double NULL DEFAULT NULL , #�����ڽ�������֧�����ֽ�
`cash_paid_acquire_asset`  double NULL DEFAULT NULL , #�����̶��ʲ��������ʲ������������ʲ�֧�����ֽ�
`net_cash_subsidiaries_payable`  double NULL DEFAULT NULL , #ȡ���ӹ�˾������Ӫҵ��λ֧�����ֽ𾻶�
`cash_received_other_operating`  double NULL DEFAULT NULL , #֧����������Ͷ�ʻ�йص��ֽ�
`subtotal_cash_outflow_investment`  double NULL DEFAULT NULL , #Ͷ�ʻ�ֽ�����С��
`net_cash_outflow_investment`  double NULL DEFAULT NULL , #Ͷ�ʻ�������ֽ���������
`cash_flow_fund_raising`  double NULL DEFAULT NULL , #�������ʻ�������ֽ�������
`cash_received_capital_contribution`  double NULL DEFAULT NULL , #����Ͷ�����յ����ֽ�
`asset_securitization_absorption_cash`  double NULL DEFAULT NULL , #����֤ȯ���ʲ������յ��ֽ�
`cash_received_issuing_bond`  double NULL DEFAULT NULL , #����ծȯ�յ����ֽ�
`cash_received_subordinated_bond`  double NULL DEFAULT NULL , #����:���дμ�ծȯ�յ����ֽ�
`cash_received_increase_equity`  double NULL DEFAULT NULL , #���ӹɱ����յ����ֽ�
`cash_received_other_financing`  double NULL DEFAULT NULL , #�յ���������ʻ�йص��ֽ�
`subtotal_cash_inflow_financing`  double NULL DEFAULT NULL , #���ʻ�ֽ�����С��
`cash_paid_repayments_debt`  double NULL DEFAULT NULL , #����ծ����֧�����ֽ�
`payment_interest_dividend_profit`  double NULL DEFAULT NULL , #�������������򳥸���Ϣ֧�����ֽ�
`cash_payment_interest`  double NULL DEFAULT NULL , #����:������Ϣ��֧�����ֽ�
`payment_new_stock_expense`  double NULL DEFAULT NULL , #֧���¹ɷ��з���
`cash_payment_other_financing`  double NULL DEFAULT NULL , #֧����������ʻ�йص��ֽ�
`subtotal_cash_outflow_financing`  double NULL DEFAULT NULL , #���ʻ�ֽ�����С��
`net_cash_flow_financing`  double NULL DEFAULT NULL , #���ʻ�������ֽ���������
`cash_influence_fluctuation_exchange`  double NULL DEFAULT NULL , #�ġ����ʱ䶯���ֽ��ֽ�ȼ����Ӱ��
`net_increase_cash_equivalent`  double NULL DEFAULT NULL , #�塢�ֽ��ֽ�ȼ��ﾻ���Ӷ�
`beginning_balance_cash_equivalent`  double NULL DEFAULT NULL , #��:�ڳ��ֽ��ֽ�ȼ������
`final_balance_cash_equivalent`  double NULL DEFAULT NULL , #������ĩ�ֽ��ֽ�ȼ������
`footnote`  double NULL DEFAULT NULL , #��ע
`net_profit`  double NULL DEFAULT NULL , #������
`minority_shareholder_benefit`  double NULL DEFAULT NULL , #��:�����ɶ�����
`provisional_capital_depreciation`  double NULL DEFAULT NULL , #������ʲ���ֵ׼��
`provisional_bad_debt`  double NULL DEFAULT NULL , #���У�����Ļ���׼��
`provisional_loan_loss`  double NULL DEFAULT NULL , #����Ĵ�����ʧ׼��
`dashed_back_nostro_impairment`  double NULL DEFAULT NULL , #��ش��ͬҵ��ֵ׼��
`fixed_og_biological_depreciation`  double NULL DEFAULT NULL , #�̶��ʲ��۾ɡ������ʲ��ۺġ������������ʲ��۾�
`investment_real_estate_depreciation`  double NULL DEFAULT NULL , #Ͷ���Է��ز��۾�
`amortization_intangible_deferred_other`  double NULL DEFAULT NULL , #�����ʲ��������ʲ��������ʲ���̯��
`amortization_intangible_asset`  double NULL DEFAULT NULL , #����:�����ʲ�̯��
`amortisation_long_deferred_expense`  double NULL DEFAULT NULL , #���ڴ�̯����̯��
`amortization_long_term_asset`  double NULL DEFAULT NULL , #�����ʲ�̯��
`loss_disposing_long_asset`  double NULL DEFAULT NULL , #���ù̶��ʲ��������ʲ����������ڲ�����ʧ/(����)
`loss_disposing_investment_property`  double NULL DEFAULT NULL , #����Ͷ���Է��ز�����ʧ/(����)
`loss_retirement_fixed_asset`  double NULL DEFAULT NULL , #�̶��ʲ�������ʧ
`financial_expense`  double NULL DEFAULT NULL , #�������
`investment_loss`  double NULL DEFAULT NULL , #Ͷ����ʧ(��:����)
`change_fair_value`  double NULL DEFAULT NULL , #���ʼ�ֵ�䶯(����)/��ʧ
`exchange_gain_loss`  double NULL DEFAULT NULL , #�������
`net_gl_derivative_financial`  double NULL DEFAULT NULL , #�������ڹ��߽��׾�����
`discounted_back_pull`  double NULL DEFAULT NULL , #���ֻذ�(��ֵ�ʲ���Ϣ��ת)
`decrease_inventory`  double NULL DEFAULT NULL , #����ļ���
`decrease_loan`  double NULL DEFAULT NULL , #����ļ���
`increase_deposit`  double NULL DEFAULT NULL , #��������
`lending_money_net`  double NULL DEFAULT NULL , #������ľ���
`reduction_financial_asset`  double NULL DEFAULT NULL , #�������ʲ��ļ���
`increase_estimated_liability`  double NULL DEFAULT NULL , #Ԥ�Ƹ�ծ������
`payment_verification_received`  double NULL DEFAULT NULL , #�յ��Ѻ�������
`reduction_deferred_tax_asset`  double NULL DEFAULT NULL , #��������˰�ʲ��ļ���
`increase_deferred_tax_liability`  double NULL DEFAULT NULL , #��������˰��ծ������
`increase_operating_receivable`  double NULL DEFAULT NULL , #��Ӫ��Ӧ����Ŀ������
`increase_operating_payable`  double NULL DEFAULT NULL , #��Ӫ��Ӧ����Ŀ������
`decrease_operating_other_asset`  double NULL DEFAULT NULL , #��Ӫ�������ʲ��ļ���
`increase_operating_other_liability`  double NULL DEFAULT NULL , #��Ӫ��������ծ������
`other`  double NULL DEFAULT NULL , #����
`net_cash_flow_operating2`  double NULL DEFAULT NULL , #��Ӫ��ֽ���������
`fixed_assets_repay_debt`  double NULL DEFAULT NULL , #�Թ̶��ʲ�����ծ��
`investment_repay_debt`  double NULL DEFAULT NULL , #��Ͷ�ʳ���ծ��
`investment_fixed_asset`  double NULL DEFAULT NULL , #�Թ̶��ʲ�����Ͷ��
`conversion_debt_capital`  double NULL DEFAULT NULL , #ծ��תΪ�ʱ�
`conver_tible_bond_ayear`  double NULL DEFAULT NULL , #һ���ڵ��ڵĿ�ת����˾ծȯ
`fixed_assets_financing_lease`  double NULL DEFAULT NULL , #��������̶��ʲ�
`other_noncash_financing`  double NULL DEFAULT NULL , #�������漰�ֽ���֧��Ͷ�ʺͳ��ʻ���
`cash_final_balance`  double NULL DEFAULT NULL , #�ֽ����ĩ���
`cash_beginning_balance`  double NULL DEFAULT NULL , #��:�ֽ���ڳ����
`cash_equivalent_final_balance`  double NULL DEFAULT NULL , #�ֽ�ȼ������ĩ���
`cash_equivalent_beginning_balance`  double NULL DEFAULT NULL , #�����ֽ�ȼ�����ڳ����
`net_increase_cash_equivalent2`  double NULL DEFAULT NULL , #�ֽ��ֽ�ȼ��ﾻ���Ӷ�
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
`seq_no`  int(11) NOT NULL AUTO_INCREMENT , #���к�
`stock_id`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL , #��Ʊ����
`statement_date`  date NOT NULL , #��������
`unit`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL , #��λ
`cash_flow_operating`  double NULL DEFAULT NULL , #һ����Ӫ��������ֽ�����
`cash_sale_labour_received`  double NULL DEFAULT NULL , #������Ʒ���ṩ�����յ����ֽ�
`net_increase_deposit_interbank`  double NULL DEFAULT NULL , #�ͻ�����ͬҵ��ſ�����Ӷ�
`net_increase_loan_cb`  double NULL DEFAULT NULL , #���������н����Ӷ�
`net_increase_loan_otherfinan`  double NULL DEFAULT NULL , #���������ڻ��������ʽ����Ӷ�
`primary_insurance_premium_received`  double NULL DEFAULT NULL , #�յ�ԭ���պ�ͬ����ȡ�õ��ֽ�
`reinsurance_business_net_received`  double NULL DEFAULT NULL , #�յ��ٱ���ҵ���ֽ𾻶�
`net_increase_deposit_investment`  double NULL DEFAULT NULL , #��������Ͷ�ʿ���Ӷ�
`net_increase_disposal_financial`  double NULL DEFAULT NULL , #���ý����Խ����ʲ������Ӷ�
`interest_fee_commission_received`  double NULL DEFAULT NULL , #��ȡ��Ϣ�������Ѽ�Ӷ����ֽ�
`net_increase_capital_borrowed`  double NULL DEFAULT NULL , #�����ʽ����Ӷ�
`net_increase_repurchase_capital`  double NULL DEFAULT NULL , #�ع�ҵ���ʽ����Ӷ�
`refund_tax_received`  double NULL DEFAULT NULL , #�յ���˰�ѷ���
`cash_other_operating_received`  double NULL DEFAULT NULL , #�յ��������뾭Ӫ��йص��ֽ�
`subtotal_cash_inflow_operating`  double NULL DEFAULT NULL , #��Ӫ��ֽ�����С��
`cash_sale_labour_payable`  double NULL DEFAULT NULL , #������Ʒ����������֧�����ֽ�
`net_increase_loan_advance`  double NULL DEFAULT NULL , #�ͻ���������Ӷ�
`net_increase_cb_interbank`  double NULL DEFAULT NULL , #����������к�ͬҵ������Ӷ�
`primary_insurance_premium_payable`  double NULL DEFAULT NULL , #֧��ԭ���պ�ͬ�⸶������ֽ�
`interest_fee_commission_payable`  double NULL DEFAULT NULL , #֧����Ϣ�������Ѽ�Ӷ����ֽ�
`cash_policy_dividend_payable`  double NULL DEFAULT NULL , #֧�������������ֽ�
`payment_employee_cash`  double NULL DEFAULT NULL , #֧����ְ���Լ�Ϊְ��֧�����ֽ�
`tax_payment`  double NULL DEFAULT NULL , #֧���ĸ���˰��
`payment_cash_other_operating`  double NULL DEFAULT NULL , #֧���������뾭Ӫ��йص��ֽ�
`subtotal_cash_outflow_operating`  double NULL DEFAULT NULL , #��Ӫ��ֽ�����С��
`net_cash_flow_operating`  double NULL DEFAULT NULL , #��Ӫ��������ֽ���������
`cash_flow_investment`  double NULL DEFAULT NULL , #����Ͷ�ʻ�������ֽ�������
`cash_received_investment`  double NULL DEFAULT NULL , #�ջ�Ͷ�����յ����ֽ�
`cash_received_investment_income`  double NULL DEFAULT NULL , #ȡ��Ͷ���������յ����ֽ�
`disposal_asset_cash_received`  double NULL DEFAULT NULL , #���ù̶��ʲ��������ʲ������������ʲ����ջص��ֽ𾻶�
`net_cash_subsidiaries_received`  double NULL DEFAULT NULL , #�����ӹ�˾������Ӫҵ��λ�յ����ֽ𾻶�
`cash_received_other_investing`  double NULL DEFAULT NULL , #�յ���������Ͷ�ʻ�йص��ֽ�
`reduce_deposit_cash_pledge`  double NULL DEFAULT NULL , #������Ѻ�Ͷ��ڴ�����յ����ֽ�
`subtotal_cash_inflow_investment`  double NULL DEFAULT NULL , #Ͷ�ʻ�ֽ�����С��
`cash_paid_acquire_asset`  double NULL DEFAULT NULL , #�����̶��ʲ��������ʲ������������ʲ���֧�����ֽ�
`cash_payment_investment`  double NULL DEFAULT NULL , #Ͷ����֧�����ֽ�
`net_increase_mortgage_loan`  double NULL DEFAULT NULL , #��Ѻ������Ӷ�
`net_cash_subsidiaries_payable`  double NULL DEFAULT NULL , #ȡ���ӹ�˾������Ӫҵ��λ֧�����ֽ𾻶�
`cash_investment_other_payable`  double NULL DEFAULT NULL , #֧����������Ͷ�ʻ�йص��ֽ�
`increase_pledge_deposit_payable`  double NULL DEFAULT NULL , #������Ѻ�Ͷ��ڴ����֧�����ֽ�
`subtotal_cash_outflow_investment`  double NULL DEFAULT NULL , #Ͷ�ʻ�ֽ�����С��
`net_cash_outflow_investment`  double NULL DEFAULT NULL , #Ͷ�ʻ�������ֽ���������
`cash_flow_fund_raising`  double NULL DEFAULT NULL , #�������ʻ�������ֽ�������
`cash_received_capital_contribution`  double NULL DEFAULT NULL , #����Ͷ���յ����ֽ�
`minority_shareholder_investment_subsidiary`  double NULL DEFAULT NULL , #���У��ӹ�˾���������ɶ�Ͷ���յ����ֽ�
`cash_received_loan`  double NULL DEFAULT NULL , #ȡ�ý���յ����ֽ�
`cash_received_issuing_bond`  double NULL DEFAULT NULL , #����ծȯ�յ����ֽ�
`cash_received_other_financing`  double NULL DEFAULT NULL , #�յ���������ʻ�йص��ֽ�
`subtotal_cash_inflow_financing`  double NULL DEFAULT NULL , #���ʻ�ֽ�����С��
`cash_paid_repayments_debt`  double NULL DEFAULT NULL , #����ծ��֧�����ֽ�
`payment_interest_dividend_profit`  double NULL DEFAULT NULL , #�������������򳥸���Ϣ��֧�����ֽ�
`blank`  double NULL DEFAULT NULL , #�հ�
`cash_payment_other_financing`  double NULL DEFAULT NULL , #֧����������ʻ�йص��ֽ�
`subtotal_cash_outflow_financing`  double NULL DEFAULT NULL , #���ʻ�ֽ�����С��
`net_cash_flow_financing`  double NULL DEFAULT NULL , #���ʻ�������ֽ���������
`footnote`  double NULL DEFAULT NULL , #��ע
`cash_influence_fluctuation_exchange`  double NULL DEFAULT NULL , #���ʱ䶯���ֽ��ֽ�ȼ����Ӱ��
`net_increase_cash_equivalent`  double NULL DEFAULT NULL , #�ֽ��ֽ�ȼ��ﾻ���Ӷ�
`beginning_balance_cash_equivalent`  double NULL DEFAULT NULL , #�ڳ��ֽ��ֽ�ȼ������
`final_balance_cash_equivalent`  double NULL DEFAULT NULL , #��ĩ�ֽ��ֽ�ȼ������
`net_profit`  double NULL DEFAULT NULL , #������
`minority_shareholder_benefit`  double NULL DEFAULT NULL , #�����ɶ�Ȩ��
`unrecognized_investment_loss`  double NULL DEFAULT NULL , #δȷ�ϵ�Ͷ����ʧ
`asset_depreciation_reserve`  double NULL DEFAULT NULL , #�ʲ���ֵ׼��
`fixed_og_biological_depreciation`  double NULL DEFAULT NULL , #�̶��ʲ��۾ɡ������ʲ��ۺġ������������۾�
`amortization_intangible_asset`  double NULL DEFAULT NULL , #�����ʲ�̯��
`amortisation_long_deferred_expense`  double NULL DEFAULT NULL , #���ڴ�̯����̯��
`reduction_deferred_expense`  double NULL DEFAULT NULL , #��̯���õļ���
`increase_accrued_expense`  double NULL DEFAULT NULL , #Ԥ����õ�����
`loss_disposing_long_asset`  double NULL DEFAULT NULL , #���ù̶��ʲ��������ʲ������������ʲ�����ʧ
`loss_retirement_fixed_asset`  double NULL DEFAULT NULL , #�̶��ʲ�������ʧ
`change_fair_value`  double NULL DEFAULT NULL , #���ʼ�ֵ�䶯��ʧ
`deferred_revenue_increase`  double NULL DEFAULT NULL , #�����������ӣ��������٣�
`anticipation_liability`  double NULL DEFAULT NULL , #Ԥ�Ƹ�ծ
`financial_expense`  double NULL DEFAULT NULL , #�������
`investment_loss`  double NULL DEFAULT NULL , #Ͷ����ʧ
`reduction_deferred_tax_asset`  double NULL DEFAULT NULL , #��������˰�ʲ�����
`increase_deferred_tax_liability`  double NULL DEFAULT NULL ,  #��������˰��ծ����
`decrease_inventory`  double NULL DEFAULT NULL , #����ļ���
`reduction_operating_receivable`  double NULL DEFAULT NULL , #��Ӫ��Ӧ����Ŀ�ļ���
`increase_operating_payable`  double NULL DEFAULT NULL , #��Ӫ��Ӧ����Ŀ������
`paragraph_reduction_completed_yet`  double NULL DEFAULT NULL , #���깤��δ�����ļ���(��:����)
`settlement_increase_yet_completed`  double NULL DEFAULT NULL , #�ѽ�����δ�깤�������(��:����)
`other`  double NULL DEFAULT NULL , #����
`net_cash_flow_operating2`  double NULL DEFAULT NULL , #��Ӫ������ֽ���������
`conversion_debt_capital`  double NULL DEFAULT NULL , #ծ��תΪ�ʱ�
`conver_tible_bond_ayear`  double NULL DEFAULT NULL , #һ���ڵ��ڵĿ�ת����˾ծȯ
`fixed_assets_financing_lease`  double NULL DEFAULT NULL , #��������̶��ʲ�
`cash_final_balance`  double NULL DEFAULT NULL , #�ֽ����ĩ���
`cash_beginning_balance`  double NULL DEFAULT NULL , #�ֽ���ڳ���� 
`cash_equivalent_final_balance`  double NULL DEFAULT NULL , #�ֽ�ȼ������ĩ���
`cash_equivalent_beginning_balance`  double NULL DEFAULT NULL , #�ֽ�ȼ�����ڳ����
`net_increase_cash_equivalent2`  double NULL DEFAULT NULL , #�ֽ��ֽ�ȼ���ľ����Ӷ�
PRIMARY KEY (`seq_no`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1
CHECKSUM=0
ROW_FORMAT=FIXED
DELAY_KEY_WRITE=0
;
