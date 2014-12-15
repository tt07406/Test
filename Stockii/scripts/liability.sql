CREATE TABLE `liability_statement` (
`seq_no`  int(11) NOT NULL AUTO_INCREMENT ,
`stock_id`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`statement_date`  date NOT NULL ,
`unit`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`current_asset`  bigint(12) NULL DEFAULT NULL ,
`monetary_fund`  bigint(12) NULL DEFAULT NULL ,
`settlement_fund`  bigint(12) NULL DEFAULT NULL ,
`lending_fund`  bigint(12) NULL DEFAULT NULL ,
`trading_financial_asset`  bigint(12) NULL DEFAULT NULL ,
`derivative_financial_asset`  bigint(12) NULL DEFAULT NULL ,
`note_receivable`  bigint(12) NULL DEFAULT NULL ,
`account_receivable`  bigint(12) NULL DEFAULT NULL ,
`advance_payment`  bigint(12) NULL DEFAULT NULL ,
`premium_receivable`  bigint(12) NULL DEFAULT NULL ,
`reinsurance_account_receivable`  bigint(12) NULL DEFAULT NULL ,
`provision_cession_receivable`  bigint(12) NULL DEFAULT NULL ,
`interest_receivable`  bigint(12) NULL DEFAULT NULL ,
`dividend_receivable`  bigint(12) NULL DEFAULT NULL ,
`other_receivable`  bigint(12) NULL DEFAULT NULL ,
`export_drawback_receivable`  bigint(12) NULL DEFAULT NULL ,
`allowance_receivable`  bigint(12) NULL DEFAULT NULL ,
`margin_receivable`  bigint(12) NULL DEFAULT NULL ,
`internal_receivable`  bigint(12) NULL DEFAULT NULL ,
`redemptory_monetary_capital`  bigint(12) NULL DEFAULT NULL ,
`inventory`  bigint(12) NULL DEFAULT NULL ,
`unamortized_expense`  bigint(12) NULL DEFAULT NULL ,
`unsettled_current_gl`  bigint(12) NULL DEFAULT NULL ,
`noncurrent_asset_ayear`  bigint(12) NULL DEFAULT NULL ,
`other_current_asset`  bigint(12) NULL DEFAULT NULL ,
`total_current_asset`  bigint(12) NULL DEFAULT NULL ,
`noncurrent_asset`  bigint(12) NULL DEFAULT NULL ,
`loans_and_advances`  bigint(12) NULL DEFAULT NULL ,
`salable_finanical_asset`  bigint(12) NULL DEFAULT NULL ,
`heldtomaturity_investment`  bigint(12) NULL DEFAULT NULL ,
`long_term_receivable`  bigint(12) NULL DEFAULT NULL ,
`longterm_equity_investment`  bigint(12) NULL DEFAULT NULL ,
`other_longterm_investment`  bigint(12) NULL DEFAULT NULL ,
`investment_property`  bigint(12) NULL DEFAULT NULL ,
`original_value_fixed_asset`  bigint(12) NULL DEFAULT NULL ,
`accumulated_depreciation`  bigint(12) NULL DEFAULT NULL ,
`net_value_fixed_asset`  bigint(12) NULL DEFAULT NULL ,
`fixed_asset_depreciation_reserve`  bigint(12) NULL DEFAULT NULL ,
`net_fixed_asset`  bigint(12) NULL DEFAULT NULL ,
`construction_in_process`  bigint(12) NULL DEFAULT NULL ,
`construction_material`  bigint(12) NULL DEFAULT NULL ,
`fixed_asset_liquidation`  bigint(12) NULL DEFAULT NULL ,
`productive_biological_asset`  bigint(12) NULL DEFAULT NULL ,
`welfare_biological_asset`  bigint(12) NULL DEFAULT NULL ,
`oil_gas_asset`  bigint(12) NULL DEFAULT NULL ,
`intangible_asset`  bigint(12) NULL DEFAULT NULL ,
`development_expenditure`  bigint(12) NULL DEFAULT NULL ,
`goodwill`  bigint(12) NULL DEFAULT NULL ,
`longterm_deferred_expenditure`  bigint(12) NULL DEFAULT NULL ,
`circulation_right_equity_separation`  bigint(12) NULL DEFAULT NULL ,
`deferred_tax_asset`  bigint(12) NULL DEFAULT NULL ,
`other_noncurrent_asset`  bigint(12) NULL DEFAULT NULL ,
`total_noncurrent_asset`  bigint(12) NULL DEFAULT NULL ,
`total_asset`  bigint(12) NULL DEFAULT NULL ,
`current_liability`  bigint(12) NULL DEFAULT NULL ,
`short_loan`  bigint(12) NULL DEFAULT NULL ,
`central_bank_loan`  bigint(12) NULL DEFAULT NULL ,
`customers_interbank_deposit`  bigint(12) NULL DEFAULT NULL ,
`borrowing_fund`  bigint(12) NULL DEFAULT NULL ,
`transaction_financial_liability`  bigint(12) NULL DEFAULT NULL ,
`derivative_financial_liability`  bigint(12) NULL DEFAULT NULL ,
`note_payable`  bigint(12) NULL DEFAULT NULL ,
`account_payable`  bigint(12) NULL DEFAULT NULL ,
`advance_receipt`  bigint(12) NULL DEFAULT NULL ,
`financial_asset_sold_repurchase`  bigint(12) NULL DEFAULT NULL ,
`fee_commission_payable`  bigint(12) NULL DEFAULT NULL ,
`employee_pay_payable`  bigint(12) NULL DEFAULT NULL ,
`tax_payable`  bigint(12) NULL DEFAULT NULL ,
`interest_payable`  bigint(12) NULL DEFAULT NULL ,
`dividend_payable`  bigint(12) NULL DEFAULT NULL ,
`other_fee_payable`  bigint(12) NULL DEFAULT NULL ,
`margin_requirement`  bigint(12) NULL DEFAULT NULL ,
`internal_account_receivable`  bigint(12) NULL DEFAULT NULL ,
`other_payable`  bigint(12) NULL DEFAULT NULL ,
`accrued_expense`  bigint(12) NULL DEFAULT NULL ,
`expected_current_liability`  bigint(12) NULL DEFAULT NULL ,
`reinsurance_payable`  bigint(12) NULL DEFAULT NULL ,
`insurance_contract_provision`  bigint(12) NULL DEFAULT NULL ,
`acting_trading_security`  bigint(12) NULL DEFAULT NULL ,
`acting_underwriting_security`  bigint(12) NULL DEFAULT NULL ,
`international_ticket_settlement`  bigint(12) NULL DEFAULT NULL ,
`domestic_ticket_settlement`  bigint(12) NULL DEFAULT NULL ,
`deferred_income`  bigint(12) NULL DEFAULT NULL ,
`short_term_bond`  bigint(12) NULL DEFAULT NULL ,
`noncurrent_liability_ayear`  bigint(12) NULL DEFAULT NULL ,
`other_current_liability`  bigint(12) NULL DEFAULT NULL ,
`total_current_liability`  bigint(12) NULL DEFAULT NULL ,
`noncurrent_liability`  bigint(12) NULL DEFAULT NULL ,
`long_term_loan`  bigint(12) NULL DEFAULT NULL ,
`bond_payable`  bigint(12) NULL DEFAULT NULL ,
`long_term_payable`  bigint(12) NULL DEFAULT NULL ,
`special_payable`  bigint(12) NULL DEFAULT NULL ,
`expect_noncurrent_liability`  bigint(12) NULL DEFAULT NULL ,
`deferred_tax_liability`  bigint(12) NULL DEFAULT NULL ,
`other_noncurrent_liability`  bigint(12) NULL DEFAULT NULL ,
`total_noncurrent_liability`  bigint(12) NULL DEFAULT NULL ,
`total_liability`  bigint(12) NULL DEFAULT NULL ,
`ownership`  bigint(12) NULL DEFAULT NULL ,
`paid_up_capital`  bigint(12) NULL DEFAULT NULL ,
`capital_reserve`  bigint(12) NULL DEFAULT NULL ,
`treasury_stock`  bigint(12) NULL DEFAULT NULL ,
`special_reserve`  bigint(12) NULL DEFAULT NULL ,
`surplus_reserve`  bigint(12) NULL DEFAULT NULL ,
`ordinary_risk_reserve`  bigint(12) NULL DEFAULT NULL ,
`uncertain_investment_loss`  bigint(12) NULL DEFAULT NULL ,
`undistributed_profit`  bigint(12) NULL DEFAULT NULL ,
`distribution_cash_dividend`  bigint(12) NULL DEFAULT NULL ,
`translation_reserve`  bigint(12) NULL DEFAULT NULL ,
`total_equity_attributable_parent`  bigint(12) NULL DEFAULT NULL ,
`minority_equity`  bigint(12) NULL DEFAULT NULL ,
`total_owners_equity`  bigint(12) NULL DEFAULT NULL ,
`liability_total_owners_equity`  bigint(12) NULL DEFAULT NULL ,
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
`seq_no`  int(11) NOT NULL AUTO_INCREMENT ,
`stock_id`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`statement_date`  date NOT NULL ,
`unit`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`asset`  bigint(12) NULL DEFAULT NULL ,
`monetary_fund`  bigint(12) NULL DEFAULT NULL ,
`among1`  bigint(12) NULL DEFAULT NULL ,
`storage_central_bank`  bigint(12) NULL DEFAULT NULL ,
`balance_deposit`  bigint(12) NULL DEFAULT NULL ,
`precious_metal`  bigint(12) NULL DEFAULT NULL ,
`interbank_deposit`  bigint(12) NULL DEFAULT NULL ,
`lending_fund`  bigint(12) NULL DEFAULT NULL ,
`inter_lending`  bigint(12) NULL DEFAULT NULL ,
`interbank_financial_corporation`  bigint(12) NULL DEFAULT NULL ,
`loan_fellow_bank`  bigint(12) NULL DEFAULT NULL ,
`note_issuing_fund`  bigint(12) NULL DEFAULT NULL ,
`derivative_financial_asset`  bigint(12) NULL DEFAULT NULL ,
`trading_financial_asset`  bigint(12) NULL DEFAULT NULL ,
`redemptory_monetary_capital`  bigint(12) NULL DEFAULT NULL ,
`discount`  bigint(12) NULL DEFAULT NULL ,
`bill_purchased`  bigint(12) NULL DEFAULT NULL ,
`account_receivable`  bigint(12) NULL DEFAULT NULL ,
`advance_payment`  bigint(12) NULL DEFAULT NULL ,
`interest_receivable`  bigint(12) NULL DEFAULT NULL ,
`loans_and_advances`  bigint(12) NULL DEFAULT NULL ,
`loan_loss_reserve`  bigint(12) NULL DEFAULT NULL ,
`capital_vicarious_business`  bigint(12) NULL DEFAULT NULL ,
`salable_finanical_asset`  bigint(12) NULL DEFAULT NULL ,
`heldtomaturity_investment`  bigint(12) NULL DEFAULT NULL ,
`other_receivable`  bigint(12) NULL DEFAULT NULL ,
`long_term_receivable`  bigint(12) NULL DEFAULT NULL ,
`longterm_equity_investment`  bigint(12) NULL DEFAULT NULL ,
`investment_subsidiary`  bigint(12) NULL DEFAULT NULL ,
`investment_property`  bigint(12) NULL DEFAULT NULL ,
`investment_fund_receivable`  bigint(12) NULL DEFAULT NULL ,
`deferred_expense`  bigint(12) NULL DEFAULT NULL ,
`net_value_fixed_asset`  bigint(12) NULL DEFAULT NULL ,
`construction_in_process`  bigint(12) NULL DEFAULT NULL ,
`fixed_asset_liquidation`  bigint(12) NULL DEFAULT NULL ,
`intangible_asset`  bigint(12) NULL DEFAULT NULL ,
`goodwill`  bigint(12) NULL DEFAULT NULL ,
`longterm_deferred_expenditure`  bigint(12) NULL DEFAULT NULL ,
`pending_insolvent_asset`  bigint(12) NULL DEFAULT NULL ,
`insolvent_asset_depreciation_reserve`  bigint(12) NULL DEFAULT NULL ,
`net_pending_insolvent_asset`  bigint(12) NULL DEFAULT NULL ,
`deferred_tax_asset`  bigint(12) NULL DEFAULT NULL ,
`bad_loss_special_preparation`  bigint(12) NULL DEFAULT NULL ,
`other_asset`  bigint(12) NULL DEFAULT NULL ,
`total_asset`  bigint(12) NULL DEFAULT NULL ,
`liability`  bigint(12) NULL DEFAULT NULL ,
`money_debt`  bigint(12) NULL DEFAULT NULL ,
`loan_central_bank`  bigint(12) NULL DEFAULT NULL ,
`interbank_deposit_borrowing`  bigint(12) NULL DEFAULT NULL ,
`interbank_deposit2`  bigint(12) NULL DEFAULT NULL ,
`borrowing_money`  bigint(12) NULL DEFAULT NULL ,
`loan_fellow_bank2`  bigint(12) NULL DEFAULT NULL ,
`foreign_government_loan`  bigint(12) NULL DEFAULT NULL ,
`derivative_financial_liability`  bigint(12) NULL DEFAULT NULL ,
`transaction_financial_liability`  bigint(12) NULL DEFAULT NULL ,
`financial_asset_sold_repurchase`  bigint(12) NULL DEFAULT NULL ,
`customer_deposit`  bigint(12) NULL DEFAULT NULL ,
`bill_financing`  bigint(12) NULL DEFAULT NULL ,
`remittance_temporary_deposit`  bigint(12) NULL DEFAULT NULL ,
`accrued_expense`  bigint(12) NULL DEFAULT NULL ,
`issuance_certificate_deposit`  bigint(12) NULL DEFAULT NULL ,
`outward_remittance`  bigint(12) NULL DEFAULT NULL ,
`among2`  bigint(12) NULL DEFAULT NULL ,
`welfare_payable`  bigint(12) NULL DEFAULT NULL ,
`tax_payable`  bigint(12) NULL DEFAULT NULL ,
`interest_payable`  bigint(12) NULL DEFAULT NULL ,
`account_payable`  bigint(12) NULL DEFAULT NULL ,
`special_payable`  bigint(12) NULL DEFAULT NULL ,
`dividend_payable`  bigint(12) NULL DEFAULT NULL ,
`other_fee_payable`  bigint(12) NULL DEFAULT NULL ,
`liability_vicarious_business`  bigint(12) NULL DEFAULT NULL ,
`expected_liability`  bigint(12) NULL DEFAULT NULL ,
`deferred_income`  bigint(12) NULL DEFAULT NULL ,
`long_term_payable`  bigint(12) NULL DEFAULT NULL ,
`bond_payable`  bigint(12) NULL DEFAULT NULL ,
`subprime_bond_payable`  bigint(12) NULL DEFAULT NULL ,
`deferred_tax_liability`  bigint(12) NULL DEFAULT NULL ,
`other_liability`  bigint(12) NULL DEFAULT NULL ,
`total_liability`  bigint(12) NULL DEFAULT NULL ,
`ownership`  bigint(12) NULL DEFAULT NULL ,
`paid_up_capital`  bigint(12) NULL DEFAULT NULL ,
`capital_reserve`  bigint(12) NULL DEFAULT NULL ,
`salable_investment unrealized_gl`  bigint(12) NULL DEFAULT NULL ,
`heldtomaturity_investment_gl`  bigint(12) NULL DEFAULT NULL ,
`treasury_stock`  bigint(12) NULL DEFAULT NULL ,
`surplus_reserve`  bigint(12) NULL DEFAULT NULL ,
`ordinary_risk_reserve`  bigint(12) NULL DEFAULT NULL ,
`trust_compensation_reserve`  bigint(12) NULL DEFAULT NULL ,
`undistributed_profit`  bigint(12) NULL DEFAULT NULL ,
`distribution_cash_dividend`  bigint(12) NULL DEFAULT NULL ,
`translation_reserve`  bigint(12) NULL DEFAULT NULL ,
`other_reserve`  bigint(12) NULL DEFAULT NULL ,
`total_equity_attributable_parent`  bigint(12) NULL DEFAULT NULL ,
`minority_equity`  bigint(12) NULL DEFAULT NULL ,
`total_owners_equity`  bigint(12) NULL DEFAULT NULL ,
`liability_total_owners_equity`  bigint(12) NULL DEFAULT NULL ,
PRIMARY KEY (`seq_no`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1
CHECKSUM=0
ROW_FORMAT=FIXED
DELAY_KEY_WRITE=0
;