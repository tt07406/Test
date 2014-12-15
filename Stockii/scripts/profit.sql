CREATE TABLE `profit_statement` (
`seq_no`  int(11) NOT NULL AUTO_INCREMENT ,
`stock_id`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`statement_date`  date NOT NULL ,
`unit`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`gross_revenue`  bigint(12) NULL DEFAULT NULL ,
`operating_revenue`  bigint(12) NULL DEFAULT NULL ,
`interest_income`  bigint(12) NULL DEFAULT NULL ,
`earned_premium`  bigint(12) NULL DEFAULT NULL ,
`fee_commission_income`  bigint(12) NULL DEFAULT NULL ,
`real_estate_income`  bigint(12) NULL DEFAULT NULL ,
`other_business_income`  bigint(12) NULL DEFAULT NULL ,
`total_operating_cost`  bigint(12) NULL DEFAULT NULL ,
`operating_cost`  bigint(12) NULL DEFAULT NULL ,
`interest_expense`  bigint(12) NULL DEFAULT NULL ,
`fee_commission_expense`  bigint(12) NULL DEFAULT NULL ,
`real_estate_cost`  bigint(12) NULL DEFAULT NULL ,
`research_development_expenditure`  bigint(12) NULL DEFAULT NULL ,
`surrender_value`  bigint(12) NULL DEFAULT NULL ,
`net_payments_insurance_claim`  bigint(12) NULL DEFAULT NULL ,
`insurance_contract_net_reserve`  bigint(12) NULL DEFAULT NULL ,
`bond_insurance_expense`  bigint(12) NULL DEFAULT NULL ,
`reinsurance_expense`  bigint(12) NULL DEFAULT NULL ,
`other_operating_cost`  bigint(12) NULL DEFAULT NULL ,
`business_tariff_annex`  bigint(12) NULL DEFAULT NULL ,
`selling_expense`  bigint(12) NULL DEFAULT NULL ,
`administration_expense`  bigint(12) NULL DEFAULT NULL ,
`financial_expense`  bigint(12) NULL DEFAULT NULL ,
`asset_impairment_loss`  bigint(12) NULL DEFAULT NULL ,
`gain_change_fair_value`  bigint(12) NULL DEFAULT NULL ,
`investment_income`  bigint(12) NULL DEFAULT NULL ,
`joint_venture_investment_income`  bigint(12) NULL DEFAULT NULL ,
`exchange_gain`  bigint(12) NULL DEFAULT NULL ,
`futures_profit_loss`  bigint(12) NULL DEFAULT NULL ,
`managed_earning`  bigint(12) NULL DEFAULT NULL ,
`subsidize_revenue`  bigint(12) NULL DEFAULT NULL ,
`income_other_operation`  bigint(12) NULL DEFAULT NULL ,
`operating_profit`  bigint(12) NULL DEFAULT NULL ,
`nonoperating_income`  bigint(12) NULL DEFAULT NULL ,
`nonoperating_expenditure`  bigint(12) NULL DEFAULT NULL ,
`disposal_loss_noncurrent_liability`  bigint(12) NULL DEFAULT NULL ,
`total_profit`  bigint(12) NULL DEFAULT NULL ,
`income_tax_expense`  bigint(12) NULL DEFAULT NULL ,
`unrealised_investment_loss`  bigint(12) NULL DEFAULT NULL ,
`net_profit`  bigint(12) NULL DEFAULT NULL ,
`net_profit_parent`  bigint(12) NULL DEFAULT NULL ,
`minority_interest_income`  bigint(12) NULL DEFAULT NULL ,
`earning_per_share`  bigint(12) NULL DEFAULT NULL ,
`basic_earning_per_share`  bigint(12) NULL DEFAULT NULL ,
`diluted_earning_per_share`  bigint(12) NULL DEFAULT NULL ,
`other_comprehensive_income`  bigint(12) NULL DEFAULT NULL ,
`total_comprehensive_income`  bigint(12) NULL DEFAULT NULL ,
`total_comprehensive_income_parent`  bigint(12) NULL DEFAULT NULL ,
`total_comprehensive_income_minority`  bigint(12) NULL DEFAULT NULL ,
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
`seq_no`  int(11) NOT NULL AUTO_INCREMENT ,
`stock_id`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`statement_date`  date NOT NULL ,
`unit`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`operating_revenue`  bigint(12) NULL DEFAULT NULL ,
`net_interest_income`  bigint(12) NULL DEFAULT NULL ,
`interest_income`  bigint(12) NULL DEFAULT NULL ,
`interest_expense`  bigint(12) NULL DEFAULT NULL ,
`fee_commission_net_income`  bigint(12) NULL DEFAULT NULL ,
`fee_commission_income`  bigint(12) NULL DEFAULT NULL ,
`fee_commission_expense`  bigint(12) NULL DEFAULT NULL ,
`intermediate_business_net_income`  bigint(12) NULL DEFAULT NULL ,
`intermediate_business_income`  bigint(12) NULL DEFAULT NULL ,
`intermediate_business_expense`  bigint(12) NULL DEFAULT NULL ,
`net_trading_income`  bigint(12) NULL DEFAULT NULL ,
`derivatives_trading_net_income`  bigint(12) NULL DEFAULT NULL ,
`exchange_gain`  bigint(12) NULL DEFAULT NULL ,
`net_investment_income`  bigint(12) NULL DEFAULT NULL ,
`associated_company_investment_income`  bigint(12) NULL DEFAULT NULL ,
`gain_change_fair_value`  bigint(12) NULL DEFAULT NULL ,
`income_other_operation`  bigint(12) NULL DEFAULT NULL ,
`operating_expense`  bigint(12) NULL DEFAULT NULL ,
`business_tariff_annex`  bigint(12) NULL DEFAULT NULL ,
`business_administration_expense`  bigint(12) NULL DEFAULT NULL ,
`asset_impairment_loss`  bigint(12) NULL DEFAULT NULL ,
`depreciation_expense`  bigint(12) NULL DEFAULT NULL ,
`provision_doubtful_debt`  bigint(12) NULL DEFAULT NULL ,
`other_operating_cost`  bigint(12) NULL DEFAULT NULL ,
`operating_profit`  bigint(12) NULL DEFAULT NULL ,
`nonoperating_income`  bigint(12) NULL DEFAULT NULL ,
`nonoperating_expenditure`  bigint(12) NULL DEFAULT NULL ,
`total_profit`  bigint(12) NULL DEFAULT NULL ,
`income_tax`  bigint(12) NULL DEFAULT NULL ,
`minority_interest`  bigint(12) NULL DEFAULT NULL ,
`net_profit_parent`  bigint(12) NULL DEFAULT NULL ,
`beginning_retained_earning`  bigint(12) NULL DEFAULT NULL ,
`profit_available_distribution`  bigint(12) NULL DEFAULT NULL ,
`withdrawal_legal_surplus`  bigint(12) NULL DEFAULT NULL ,
`withdraw_statutory_welfare_reserve`  bigint(12) NULL DEFAULT NULL ,
`allotting_ordinary_risk_reserve`  bigint(12) NULL DEFAULT NULL ,
`allotting_trust_compensation_reserve`  bigint(12) NULL DEFAULT NULL ,
`distribution_profit_shareholder`  bigint(12) NULL DEFAULT NULL ,
`preferred_stock_dividend_payable`  bigint(12) NULL DEFAULT NULL ,
`withdrawal_other_common_accumulation`  bigint(12) NULL DEFAULT NULL ,
`common_stock_dividend_payable`  bigint(12) NULL DEFAULT NULL ,
`dividend_transferred_capital`  bigint(12) NULL DEFAULT NULL ,
`undistributed_profit`  bigint(12) NULL DEFAULT NULL ,
`basic_earning_per_share`  bigint(12) NULL DEFAULT NULL ,
`diluted_earning_per_share`  bigint(12) NULL DEFAULT NULL ,
PRIMARY KEY (`seq_no`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1
CHECKSUM=0
ROW_FORMAT=FIXED
DELAY_KEY_WRITE=0
;