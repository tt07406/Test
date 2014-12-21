CREATE TABLE `liability_statement` (
`seq_no`  int(11) NOT NULL AUTO_INCREMENT , #���к�
`stock_id`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL , #��Ʊ����
`statement_date`  date NOT NULL , #��������
`unit`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL , #��λ
`current_asset`   double NULL DEFAULT NULL , #�����ʲ�
`monetary_fund`   double NULL DEFAULT NULL , #�����ʽ�
`settlement_fund`  double NULL DEFAULT NULL , #���㱸����
`lending_fund`  double NULL DEFAULT NULL , #����ʽ�
`trading_financial_asset` double NULL DEFAULT NULL , #�����Խ����ʲ�
`derivative_financial_asset`  double NULL DEFAULT NULL , #���������ʲ�
`note_receivable`  double NULL DEFAULT NULL , #Ӧ��Ʊ��
`account_receivable`  double NULL DEFAULT NULL , #Ӧ���˿�
`advance_payment`  double NULL DEFAULT NULL , #Ԥ������
`premium_receivable`  double NULL DEFAULT NULL , #Ӧ�ձ���
`reinsurance_account_receivable`  double NULL DEFAULT NULL , #Ӧ�շֱ��˿�
`provision_cession_receivable`  double NULL DEFAULT NULL , #Ӧ�շֱ���ͬ׼����
`interest_receivable`  double NULL DEFAULT NULL , #Ӧ����Ϣ
`dividend_receivable`  double NULL DEFAULT NULL , #Ӧ�չ���
`other_receivable`  double NULL DEFAULT NULL , #����Ӧ�տ�
`export_drawback_receivable`  double NULL DEFAULT NULL , #Ӧ�ճ�����˰
`allowance_receivable`  double NULL DEFAULT NULL , #Ӧ�ղ�����
`margin_receivable`  double NULL DEFAULT NULL , #Ӧ�ձ�֤��
`internal_receivable`  double NULL DEFAULT NULL , #�ڲ�Ӧ�տ�
`redemptory_monetary_capital`  double NULL DEFAULT NULL , #���뷵�۽����ʲ�
`inventory`  double NULL DEFAULT NULL , #���
`unamortized_expense`  double NULL DEFAULT NULL , #��̯����
`unsettled_current_gl`  double NULL DEFAULT NULL , #�����������ʲ�����
`noncurrent_asset_ayear`  double NULL DEFAULT NULL , #һ���ڵ��ڵķ������ʲ�
`other_current_asset`  double NULL DEFAULT NULL , #���������ʲ�
`total_current_asset`  double NULL DEFAULT NULL , #�����ʲ��ϼ�
`noncurrent_asset`  double NULL DEFAULT NULL , #�������ʲ�
`loans_and_advances`  double NULL DEFAULT NULL , #���Ŵ�����
`salable_finanical_asset`  double NULL DEFAULT NULL , #�ɹ����۽����ʲ�
`heldtomaturity_investment`  double NULL DEFAULT NULL , #����������Ͷ��
`long_term_receivable`  double NULL DEFAULT NULL , #����Ӧ�տ�
`longterm_equity_investment`  double NULL DEFAULT NULL , #���ڹ�ȨͶ��
`other_longterm_investment`  double NULL DEFAULT NULL , #��������Ͷ��
`investment_property`  double NULL DEFAULT NULL , #Ͷ���Է��ز�
`original_value_fixed_asset`  double NULL DEFAULT NULL , #�̶��ʲ�ԭֵ
`accumulated_depreciation`  double NULL DEFAULT NULL , #�ۼ��۾�
`net_value_fixed_asset`  double NULL DEFAULT NULL , #�̶��ʲ���ֵ
`fixed_asset_depreciation_reserve`  double NULL DEFAULT NULL , #�̶��ʲ���ֵ׼��
`net_fixed_asset`  double NULL DEFAULT NULL , #�̶��ʲ�����
`construction_in_process`  double NULL DEFAULT NULL , #�ڽ�����
`construction_material`  double NULL DEFAULT NULL , #��������
`fixed_asset_liquidation`  double NULL DEFAULT NULL , #�̶��ʲ�����
`productive_biological_asset`  double NULL DEFAULT NULL , #�����������ʲ�
`welfare_biological_asset`  double NULL DEFAULT NULL , #�����������ʲ�
`oil_gas_asset`  double NULL DEFAULT NULL , #�����ʲ�
`intangible_asset`  double NULL DEFAULT NULL , #�����ʲ�
`development_expenditure`  double NULL DEFAULT NULL , #����֧��
`goodwill`  double NULL DEFAULT NULL , #����
`longterm_deferred_expenditure`  double NULL DEFAULT NULL , #���ڴ�̯����
`circulation_right_equity_separation`  double NULL DEFAULT NULL , #��Ȩ������ͨȨ
`deferred_tax_asset`  double NULL DEFAULT NULL , #��������˰�ʲ�
`other_noncurrent_asset`  double NULL DEFAULT NULL , #�����������ʲ�
`total_noncurrent_asset`  double NULL DEFAULT NULL , #�������ʲ��ϼ�
`total_asset`  double NULL DEFAULT NULL , #�ʲ��ܼ�
`current_liability`  double NULL DEFAULT NULL , #������ծ
`short_loan`  double NULL DEFAULT NULL , #���ڽ��
`central_bank_loan`  double NULL DEFAULT NULL , #���������н��
`customers_interbank_deposit`  double NULL DEFAULT NULL , #���մ�ͬҵ���
`borrowing_fund`  double NULL DEFAULT NULL , #�����ʽ�
`transaction_financial_liability`  double NULL DEFAULT NULL , #�����Խ��ڸ�ծ
`derivative_financial_liability`  double NULL DEFAULT NULL , #�������ڸ�ծ
`note_payable`  double NULL DEFAULT NULL , #Ӧ��Ʊ��
`account_payable`  double NULL DEFAULT NULL , #Ӧ���˿�
`advance_receipt`  double NULL DEFAULT NULL , #Ԥ�տ���
`financial_asset_sold_repurchase`  double NULL DEFAULT NULL , #�����ع������ʲ���
`fee_commission_payable`  double NULL DEFAULT NULL , #Ӧ�������Ѽ�Ӷ��
`employee_pay_payable`  double NULL DEFAULT NULL , #Ӧ��ְ��н��
`tax_payable`  double NULL DEFAULT NULL , #Ӧ��˰��
`interest_payable`  double NULL DEFAULT NULL , #Ӧ����Ϣ
`dividend_payable`  double NULL DEFAULT NULL , #Ӧ������
`other_fee_payable`  double NULL DEFAULT NULL , #����Ӧ����
`margin_requirement`  double NULL DEFAULT NULL , #Ӧ����֤��
`internal_account_receivable`  double NULL DEFAULT NULL , #�ڲ�Ӧ����
`other_payable`  double NULL DEFAULT NULL , #����Ӧ����
`accrued_expense`  double NULL DEFAULT NULL , #Ԥ�����
`expected_current_liability`  double NULL DEFAULT NULL , #Ԥ��������ծ
`reinsurance_payable`  double NULL DEFAULT NULL , #Ӧ���ֱ��˿�
`insurance_contract_provision`  double NULL DEFAULT NULL , #���պ�ͬ׼����
`acting_trading_security`  double NULL DEFAULT NULL , #��������֤ȯ��
`acting_underwriting_security`  double NULL DEFAULT NULL , #�������֤ȯ��
`international_ticket_settlement`  double NULL DEFAULT NULL , #����Ʊ֤����
`domestic_ticket_settlement`  double NULL DEFAULT NULL , #����Ʊ֤����
`deferred_income`  double NULL DEFAULT NULL , #��������
`short_term_bond`  double NULL DEFAULT NULL , #Ӧ������ծȯ
`noncurrent_liability_ayear`  double NULL DEFAULT NULL , #һ���ڵ��ڵķ�������ծ
`other_current_liability`  double NULL DEFAULT NULL , #����������ծ
`total_current_liability`  double NULL DEFAULT NULL , #������ծ�ϼ�
`noncurrent_liability`  double NULL DEFAULT NULL , #��������ծ
`long_term_loan`  double NULL DEFAULT NULL , #���ڽ��
`bond_payable`  double NULL DEFAULT NULL , #Ӧ��ծȯ
`long_term_payable`  double NULL DEFAULT NULL , #����Ӧ����
`special_payable`  double NULL DEFAULT NULL , #ר��Ӧ����
`expect_noncurrent_liability`  double NULL DEFAULT NULL , #Ԥ�Ʒ�������ծ
`deferred_tax_liability`  double NULL DEFAULT NULL , #��������˰��ծ
`other_noncurrent_liability`  double NULL DEFAULT NULL , #������������ծ
`total_noncurrent_liability`  double NULL DEFAULT NULL , #��������ծ�ϼ�
`total_liability`  double NULL DEFAULT NULL , #��ծ�ϼ�
`ownership`  double NULL DEFAULT NULL , #������Ȩ��
`paid_up_capital`  double NULL DEFAULT NULL , #ʵ���ʱ�(��ɱ�)
`capital_reserve`  double NULL DEFAULT NULL , #�ʱ�����
`treasury_stock`  double NULL DEFAULT NULL , #����
`special_reserve`  double NULL DEFAULT NULL , #ר���
`surplus_reserve`  double NULL DEFAULT NULL , #ӯ�๫��
`ordinary_risk_reserve`  double NULL DEFAULT NULL , #һ�����׼��
`uncertain_investment_loss`  double NULL DEFAULT NULL , #δȷ����Ͷ����ʧ
`undistributed_profit`  double NULL DEFAULT NULL , #δ��������
`distribution_cash_dividend`  double NULL DEFAULT NULL , #������ֽ����
`translation_reserve`  double NULL DEFAULT NULL , #��ұ���������
`total_equity_attributable_parent`  double NULL DEFAULT NULL , #������ĸ��˾�ɶ�Ȩ��ϼ�
`minority_equity`  double NULL DEFAULT NULL , #�����ɶ�Ȩ��
`total_owners_equity`  double NULL DEFAULT NULL , #������Ȩ��(��ɶ�Ȩ��)�ϼ�
`liability_total_owners_equity`  double NULL DEFAULT NULL , #��ծ��������Ȩ��(��ɶ�Ȩ��)�ܼ�
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
`seq_no`  int(11) NOT NULL AUTO_INCREMENT , #���к�
`stock_id`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL , #��Ʊ����
`statement_date`  date NOT NULL , #��������
`unit`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL , #��λ
`asset`  double NULL DEFAULT NULL , #�ʲ�
`monetary_fund`  double NULL DEFAULT NULL , #�����ʽ�
`among1`  double NULL DEFAULT NULL , #����:
`storage_central_bank`  double NULL DEFAULT NULL , #����������п�
`balance_deposit`  double NULL DEFAULT NULL , #����׼����
`precious_metal`  double NULL DEFAULT NULL , #�����
`interbank_deposit`  double NULL DEFAULT NULL , #���ͬҵ����
`lending_fund`  double NULL DEFAULT NULL , #����ʽ�
`inter_lending`  double NULL DEFAULT NULL , #����:���ͬҵ
`interbank_financial_corporation`  double NULL DEFAULT NULL , #��Ž����Թ�˾
`loan_fellow_bank`  double NULL DEFAULT NULL , #������п���
`note_issuing_fund`  double NULL DEFAULT NULL , #�����������
`derivative_financial_asset`  double NULL DEFAULT NULL , #�������ڹ����ʲ�
`trading_financial_asset`  double NULL DEFAULT NULL , #�����Խ����ʲ�
`redemptory_monetary_capital`  double NULL DEFAULT NULL , #���뷵�۽����ʲ�
`discount`  double NULL DEFAULT NULL , #����
`bill_purchased`  double NULL DEFAULT NULL , #������Ѻ��
`account_receivable`  double NULL DEFAULT NULL , #Ӧ���˿�
`advance_payment`  double NULL DEFAULT NULL , #Ԥ���˿�
`interest_receivable`  double NULL DEFAULT NULL , #Ӧ����Ϣ
`loans_and_advances`  double NULL DEFAULT NULL , #���Ŵ�����<�ͻ�����>
`loan_loss_reserve`  double NULL DEFAULT NULL , #��:������ʧ׼��
`capital_vicarious_business`  double NULL DEFAULT NULL , #����ҵ���ʲ�
`salable_finanical_asset`  double NULL DEFAULT NULL , #�ɹ����۽����ʲ�
`heldtomaturity_investment`  double NULL DEFAULT NULL , #����������Ͷ��
`other_receivable`  double NULL DEFAULT NULL , #����Ӧ�տ�
`long_term_receivable`  double NULL DEFAULT NULL , #����Ӧ�տ�
`longterm_equity_investment`  double NULL DEFAULT NULL , #���ڹ�ȨͶ��
`investment_subsidiary`  double NULL DEFAULT NULL , #����:Ͷ���ӹ�˾
`investment_property`  double NULL DEFAULT NULL , #Ͷ���Է��ز�
`investment_fund_receivable`  double NULL DEFAULT NULL , #Ӧ��Ͷ�ʿ���
`deferred_expense`  double NULL DEFAULT NULL , #��̯����
`net_value_fixed_asset`  double NULL DEFAULT NULL , #�̶��ʲ����� 
`construction_in_process`  double NULL DEFAULT NULL , #�ڽ�����
`fixed_asset_liquidation`  double NULL DEFAULT NULL , #�̶��ʲ�����
`intangible_asset`  double NULL DEFAULT NULL , #�����ʲ�
`goodwill`  double NULL DEFAULT NULL , #����
`longterm_deferred_expenditure`  double NULL DEFAULT NULL , #���ڴ�̯����
`pending_insolvent_asset`  double NULL DEFAULT NULL , #�������ծ�ʲ�
`insolvent_asset_depreciation_reserve`  double NULL DEFAULT NULL , #��:��ծ�ʲ���ֵ׼��
`net_pending_insolvent_asset`  double NULL DEFAULT NULL , #�������ծ�ʲ�����
`deferred_tax_asset`  double NULL DEFAULT NULL , #����˰�����
`bad_loss_special_preparation`  double NULL DEFAULT NULL , #�����ʲ�
`other_asset`  double NULL DEFAULT NULL , #��:�����ʲ�������ʧר��׼��
`total_asset`  double NULL DEFAULT NULL , #�ʲ��ܼ�
`liability`  double NULL DEFAULT NULL , #��ծ
`money_debt`  double NULL DEFAULT NULL , #���������н��
`loan_central_bank`  double NULL DEFAULT NULL , #���л���ծ��
`interbank_deposit_borrowing`  double NULL DEFAULT NULL , #ͬҵ���뼰����
`interbank_deposit2`  double NULL DEFAULT NULL , #����:ͬҵ��ſ���
`borrowing_money`  double NULL DEFAULT NULL , #�����ʽ�
`loan_fellow_bank2`  double NULL DEFAULT NULL , #���д�ſ���
`foreign_government_loan`  double NULL DEFAULT NULL , #����������
`derivative_financial_liability`  double NULL DEFAULT NULL , #�������ڹ��߸�ծ
`transaction_financial_liability`  double NULL DEFAULT NULL , #�����Խ��ڸ�ծ
`financial_asset_sold_repurchase`  double NULL DEFAULT NULL , #�����ع������ʲ���
`customer_deposit`  double NULL DEFAULT NULL , #�ͻ����<���մ��>
`bill_financing`  double NULL DEFAULT NULL , #Ʊ������
`remittance_temporary_deposit`  double NULL DEFAULT NULL , #Ӧ�����ʱ���
`accrued_expense`  double NULL DEFAULT NULL , #Ԥ�����
`issuance_certificate_deposit`  double NULL DEFAULT NULL , #���д��֤
`outward_remittance`  double NULL DEFAULT NULL , #������
`among2`  double NULL DEFAULT NULL , #����:
`welfare_payable`  double NULL DEFAULT NULL , #Ӧ��������
`tax_payable`  double NULL DEFAULT NULL , #Ӧ��˰��
`interest_payable`  double NULL DEFAULT NULL , #Ӧ����Ϣ
`account_payable`  double NULL DEFAULT NULL , #Ӧ���˿�
`special_payable`  double NULL DEFAULT NULL , #ר��Ӧ����
`dividend_payable`  double NULL DEFAULT NULL , #Ӧ������
`other_fee_payable`  double NULL DEFAULT NULL , #����Ӧ����
`liability_vicarious_business`  double NULL DEFAULT NULL , #����ҵ��ծ
`expected_liability`  double NULL DEFAULT NULL , #Ԥ�Ƹ�ծ
`deferred_income`  double NULL DEFAULT NULL , #��������
`long_term_payable`  double NULL DEFAULT NULL , #����Ӧ����
`bond_payable`  double NULL DEFAULT NULL , #Ӧ��ծȯ
`subprime_bond_payable`  double NULL DEFAULT NULL , #����:Ӧ���μ�ծȯ
`deferred_tax_liability`  double NULL DEFAULT NULL , #��������˰��ծ
`other_liability`  double NULL DEFAULT NULL , #������ծ
`total_liability`  double NULL DEFAULT NULL , #��ծ�ϼ�
`ownership`  double NULL DEFAULT NULL , #������Ȩ��
`paid_up_capital`  double NULL DEFAULT NULL , #�ɱ�
`capital_reserve`  double NULL DEFAULT NULL , #�ʱ�����
`salable_investment unrealized_gl`  double NULL DEFAULT NULL , #�ɹ�������Ͷ��δʵ������(���ʼ�ֵ�䶯����)
`heldtomaturity_investment_gl`  double NULL DEFAULT NULL , #����������Ͷ��δ��ת����
`treasury_stock`  double NULL DEFAULT NULL , #��:��ع�
`surplus_reserve`  double NULL DEFAULT NULL , #ӯ�๫��
`ordinary_risk_reserve`  double NULL DEFAULT NULL , #һ�����׼��
`trust_compensation_reserve`  double NULL DEFAULT NULL , #�����⳥׼����
`undistributed_profit`  double NULL DEFAULT NULL , #δ��������
`distribution_cash_dividend`  double NULL DEFAULT NULL , #����:������ֽ����
`translation_reserve`  double NULL DEFAULT NULL , #��ұ���������
`other_reserve`  double NULL DEFAULT NULL , #��������
`total_equity_attributable_parent`  double NULL DEFAULT NULL , #������ĸ��˾�ɶ���Ȩ��
`minority_equity`  double NULL DEFAULT NULL , #�����ɶ�Ȩ��
`total_owners_equity`  double NULL DEFAULT NULL , #�ɶ�Ȩ��ϼ�
`liability_total_owners_equity`  double NULL DEFAULT NULL , #��ծ���ɶ�Ȩ���ܼ�
PRIMARY KEY (`seq_no`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1
CHECKSUM=0
ROW_FORMAT=FIXED
DELAY_KEY_WRITE=0
;