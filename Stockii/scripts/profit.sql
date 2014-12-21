CREATE TABLE `profit_statement` (
`seq_no`  int(11) NOT NULL AUTO_INCREMENT , #���к�
`stock_id`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL , #��Ʊ����
`statement_date`  date NOT NULL , #��������
`unit`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL , #��λ
`gross_revenue`  double NULL DEFAULT NULL , #Ӫҵ������
`operating_revenue`  double NULL DEFAULT NULL , #Ӫҵ����
`interest_income`  double NULL DEFAULT NULL , #��Ϣ����
`earned_premium`  double NULL DEFAULT NULL , #��׬����
`fee_commission_income`  double NULL DEFAULT NULL , #�����Ѽ�Ӷ������
`real_estate_income`  double NULL DEFAULT NULL , #���ز���������
`other_business_income`  double NULL DEFAULT NULL , #����ҵ������
`total_operating_cost`  double NULL DEFAULT NULL , #Ӫҵ�ܳɱ�
`operating_cost`  double NULL DEFAULT NULL , #Ӫҵ�ɱ�
`interest_expense`  double NULL DEFAULT NULL , #��Ϣ֧��
`fee_commission_expense`  double NULL DEFAULT NULL , #�����Ѽ�Ӷ��֧��
`real_estate_cost`  double NULL DEFAULT NULL , #���ز����۳ɱ�
`research_development_expenditure`  double NULL DEFAULT NULL , #�з�����
`surrender_value`  double NULL DEFAULT NULL , #�˱���
`net_payments_insurance_claim`  double NULL DEFAULT NULL , #�⸶֧������
`insurance_contract_net_reserve`  double NULL DEFAULT NULL , #��ȡ���պ�ͬ׼���𾻶�
`bond_insurance_expense`  double NULL DEFAULT NULL , #��������֧��
`reinsurance_expense`  double NULL DEFAULT NULL , #�ֱ�����
`other_operating_cost`  double NULL DEFAULT NULL , #����ҵ��ɱ�
`business_tariff_annex`  double NULL DEFAULT NULL , #Ӫҵ˰�𼰸���
`selling_expense`  double NULL DEFAULT NULL , #���۷���
`administration_expense`  double NULL DEFAULT NULL , #�������
`financial_expense`  double NULL DEFAULT NULL , #�������
`asset_impairment_loss`  double NULL DEFAULT NULL , #�ʲ���ֵ��ʧ
`gain_change_fair_value`  double NULL DEFAULT NULL , #���ʼ�ֵ�䶯����
`investment_income`  double NULL DEFAULT NULL , #Ͷ������
`joint_venture_investment_income`  double NULL DEFAULT NULL ,  #����:����Ӫ��ҵ�ͺ�Ӫ��ҵ��Ͷ������
`exchange_gain`  double NULL DEFAULT NULL , #�������
`futures_profit_loss`  double NULL DEFAULT NULL , #�ڻ�����
`managed_earning`  double NULL DEFAULT NULL , #�й�����
`subsidize_revenue`  double NULL DEFAULT NULL , #��������
`income_other_operation`  double NULL DEFAULT NULL , #����ҵ������
`operating_profit`  double NULL DEFAULT NULL , #Ӫҵ����
`nonoperating_income`  double NULL DEFAULT NULL , #Ӫҵ������
`nonoperating_expenditure`  double NULL DEFAULT NULL , #Ӫҵ��֧��
`disposal_loss_noncurrent_liability`  double NULL DEFAULT NULL , #�������ʲ�������ʧ
`total_profit`  double NULL DEFAULT NULL , #�����ܶ�
`income_tax_expense`  double NULL DEFAULT NULL , #����˰����
`unrealised_investment_loss`  double NULL DEFAULT NULL , #δȷ��Ͷ����ʧ
`net_profit`  double NULL DEFAULT NULL , #������
`net_profit_parent`  double NULL DEFAULT NULL , #������ĸ��˾�����ߵľ�����
`minority_interest_income`  double NULL DEFAULT NULL , #�����ɶ�����
`earning_per_share`  double NULL DEFAULT NULL , #ÿ������
`basic_earning_per_share`  double NULL DEFAULT NULL , #����ÿ������
`diluted_earning_per_share`  double NULL DEFAULT NULL , #ϡ��ÿ������
`other_comprehensive_income`  double NULL DEFAULT NULL , #�����ۺ�����
`total_comprehensive_income`  double NULL DEFAULT NULL , #�ۺ������ܶ�
`total_comprehensive_income_parent`  double NULL DEFAULT NULL , #������ĸ��˾�����ߵ��ۺ������ܶ�
`total_comprehensive_income_minority`  double NULL DEFAULT NULL , #�����������ɶ����ۺ������ܶ�
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
`seq_no`  int(11) NOT NULL AUTO_INCREMENT , #���к�
`stock_id`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL , #��Ʊ����
`statement_date`  date NOT NULL , #��������
`unit`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL , #��λ
`operating_revenue`  double NULL DEFAULT NULL , #Ӫҵ����
`net_interest_income`  double NULL DEFAULT NULL , #����:����Ϣ����
`interest_income`  double NULL DEFAULT NULL , #����:��Ϣ����
`interest_expense`  double NULL DEFAULT NULL , #��Ϣ֧��
`fee_commission_net_income`  double NULL DEFAULT NULL , #�����Ѽ�Ӷ������
`fee_commission_income`  double NULL DEFAULT NULL , #����:�����Ѽ�Ӷ������
`fee_commission_expense`  double NULL DEFAULT NULL , #�����Ѽ�Ӷ��֧��
`intermediate_business_net_income`  double NULL DEFAULT NULL , #�м�ҵ������
`intermediate_business_income`  double NULL DEFAULT NULL , #����:�м�ҵ������
`intermediate_business_expense`  double NULL DEFAULT NULL , #�м�ҵ��֧��
`net_trading_income`  double NULL DEFAULT NULL , #����������
`derivatives_trading_net_income`  double NULL DEFAULT NULL , #����:�������ڹ��߽��׾�����
`exchange_gain`  double NULL DEFAULT NULL , #�������
`net_investment_income`  double NULL DEFAULT NULL , #Ͷ�ʾ�����
`associated_company_investment_income`  double NULL DEFAULT NULL , #����:����Ӫ��˾��Ͷ������
`gain_change_fair_value`  double NULL DEFAULT NULL , #���ʼ�ֵ�䶯����
`income_other_operation`  double NULL DEFAULT NULL , #����ҵ������
`operating_expense`  double NULL DEFAULT NULL , #Ӫҵ֧��
`business_tariff_annex`  double NULL DEFAULT NULL , #Ӫҵ˰�𼰸���
`business_administration_expense`  double NULL DEFAULT NULL , #ҵ�񼰹������
`asset_impairment_loss`  double NULL DEFAULT NULL , #�ʲ���ֵ��ʧ
`depreciation_expense`  double NULL DEFAULT NULL , #�۾ɷ�
`provision_doubtful_debt`  double NULL DEFAULT NULL , #��ȡ����׼��
`other_operating_cost`  double NULL DEFAULT NULL , #����ҵ��֧��
`operating_profit`  double NULL DEFAULT NULL , #Ӫҵ���� 
`nonoperating_income`  double NULL DEFAULT NULL , #��:Ӫҵ������
`nonoperating_expenditure`  double NULL DEFAULT NULL , #��:Ӫҵ��֧��
`total_profit`  double NULL DEFAULT NULL , #�����ܶ�
`income_tax`  double NULL DEFAULT NULL , #��:����˰
`minority_interest`  double NULL DEFAULT NULL , #�����ɶ�Ȩ��
`net_profit_parent`  double NULL DEFAULT NULL , #������ĸ��˾�ľ�����
`beginning_retained_earning`  double NULL DEFAULT NULL , #��:���δ��������
`profit_available_distribution`  double NULL DEFAULT NULL , #�ɹ����������
`withdrawal_legal_surplus`  double NULL DEFAULT NULL , #��:��ȡ����ӯ�๫��
`withdraw_statutory_welfare_reserve`  double NULL DEFAULT NULL , #��ȡ���������
`allotting_ordinary_risk_reserve`  double NULL DEFAULT NULL , #��ȡһ�����׼��
`allotting_trust_compensation_reserve`  double NULL DEFAULT NULL , #��ȡ�����⳥׼����
`distribution_profit_shareholder`  double NULL DEFAULT NULL , #�ɹ��ɶ����������
`preferred_stock_dividend_payable`  double NULL DEFAULT NULL , #��:Ӧ�����ȹɹ���
`withdrawal_other_common_accumulation`  double NULL DEFAULT NULL , #��ȡ����ӯ�๫��
`common_stock_dividend_payable`  double NULL DEFAULT NULL , #Ӧ����ͨ�ɹ���
`dividend_transferred_capital`  double NULL DEFAULT NULL , #ת���ɱ�����ͨ�ɹ���
`undistributed_profit`  double NULL DEFAULT NULL , #δ��������
`basic_earning_per_share`  double NULL DEFAULT NULL , #����ÿ������
`diluted_earning_per_share`  double NULL DEFAULT NULL , #ϡ��ÿ������
PRIMARY KEY (`seq_no`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1
CHECKSUM=0
ROW_FORMAT=FIXED
DELAY_KEY_WRITE=0
;