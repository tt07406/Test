CREATE TABLE `cash_statement_bank` (
`seq_no`  int(11) NOT NULL AUTO_INCREMENT ,
`stock_id`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`statement_date`  date NOT NULL ,
`unit`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`cash_flow_operating`  double NULL DEFAULT NULL ,
`net_reduction_loan_advance`  double NULL DEFAULT NULL ,
`net_increase_loan_cb`  double NULL DEFAULT NULL ,
`net_increase_deposit_interbank`  double NULL DEFAULT NULL ,
`customer_deposit`  double NULL DEFAULT NULL ,
`interbank_other_financial_deposit`  double NULL DEFAULT NULL ,
`recover_net_interbank_financial`  double NULL DEFAULT NULL ,
`inflow_capital_borrowed_cash`  double NULL DEFAULT NULL ,
`net_lending_capital_withdraw`  double NULL DEFAULT NULL ,
`absorption_repurchase_proceed`  double NULL DEFAULT NULL ,
`back_purchase_resale_proceed`  double NULL DEFAULT NULL ,
`net_increase_disposal_financial`  double NULL DEFAULT NULL ,
`interest_charge_fee_commission`  double NULL DEFAULT NULL ,
`interest_received`  double NULL DEFAULT NULL ,
`fee_received`  double NULL DEFAULT NULL ,
`cash_income_financial_received`  double NULL DEFAULT NULL ,
`cash_intermediate_business_received`  double NULL DEFAULT NULL ,
`cash_exchange_net_received`  double NULL DEFAULT NULL ,
`cash_other_net_received`  double NULL DEFAULT NULL ,
`cash_margin_deposit_received`  double NULL DEFAULT NULL ,
`entrust_fund_received`  double NULL DEFAULT NULL ,
`cash_inflow_precious_metal`  double NULL DEFAULT NULL ,
`cash_discount_received`  double NULL DEFAULT NULL ,
`cash_sale_labour_received`  double NULL DEFAULT NULL ,
`refund_tax_received`  double NULL DEFAULT NULL ,
`cash_other_liability_increase`  double NULL DEFAULT NULL ,
`back_verification_loan_receivable`  double NULL DEFAULT NULL ,
`cash_reduce_other_payable`  double NULL DEFAULT NULL ,
`cash_disposal_asset_received`  double NULL DEFAULT NULL ,
`cash_other_operating_received`  double NULL DEFAULT NULL ,
`subtotal_cash_inflow_operating`  double NULL DEFAULT NULL ,
`net_increase_loan_advance`  double NULL DEFAULT NULL ,
`net_increase_cb_interbank`  double NULL DEFAULT NULL ,
`deposit_centre_bank`  double NULL DEFAULT NULL ,
`saving_interbank_other_institution`  double NULL DEFAULT NULL ,
`net_cash_lending_outflow`  double NULL DEFAULT NULL ,
`central_bank_loan_repayment`  double NULL DEFAULT NULL ,
`deposit_paid`  double NULL DEFAULT NULL ,
`net_deposit_reduce_financial`  double NULL DEFAULT NULL ,
`net_borrowing_repayment_financial`  double NULL DEFAULT NULL ,
`repayment_repurchase_net_proceed`  double NULL DEFAULT NULL ,
`security_investment_spending_cash`  double NULL DEFAULT NULL ,
`payment_resale_proceed_net`  double NULL DEFAULT NULL ,
`disposal_salable_net_decrease`  double NULL DEFAULT NULL ,
`payment_interest_fee_commission`  double NULL DEFAULT NULL ,
`interest_paid`  double NULL DEFAULT NULL ,
`commission_expense_paid_cash`  double NULL DEFAULT NULL ,
`payment_employee_cash`  double NULL DEFAULT NULL ,
`tax_payment`  double NULL DEFAULT NULL ,
`operating_expense_cash_payment`  double NULL DEFAULT NULL ,
`net_cash_transaction_financial`  double NULL DEFAULT NULL ,
`discount_cash_payment`  double NULL DEFAULT NULL ,
`writeoff_loan_interest_withdraw`  double NULL DEFAULT NULL ,
`reduce_principal_agent_busines`  double NULL DEFAULT NULL ,
`cash_outflow_precious_metal`  double NULL DEFAULT NULL ,
`pay_cash_purchase_labour`  double NULL DEFAULT NULL ,
`net_reduction_borrowing_fund`  double NULL DEFAULT NULL ,
`cash_decrease_other_asset`  double NULL DEFAULT NULL ,
`cash_decrease_other_receivable`  double NULL DEFAULT NULL ,
`payment_cash_other_operating`  double NULL DEFAULT NULL ,
`subtotal_cash_outflow_operating`  double NULL DEFAULT NULL ,
`net_cash_flow_operating`  double NULL DEFAULT NULL ,
`cash_flow_investment`  double NULL DEFAULT NULL ,
`cash_received_investment`  double NULL DEFAULT NULL ,
`cash_received_investment_income`  double NULL DEFAULT NULL ,
`dividend_profit_cash_received`  double NULL DEFAULT NULL ,
`cash_bond_interest_income`  double NULL DEFAULT NULL ,
`disposal_asset_cash_received`  double NULL DEFAULT NULL ,
`disposal_equity_investment_cash`  double NULL DEFAULT NULL ,
`net_cash_subsidiaries_received`  double NULL DEFAULT NULL ,
`cash_received_other_investing`  double NULL DEFAULT NULL ,
`subtotal_cash_inflow_investment`  double NULL DEFAULT NULL ,
`cash_payment_investment`  double NULL DEFAULT NULL ,
`equity_investment_increase_cash`  double NULL DEFAULT NULL ,
`cash_paid_bond_investment`  double NULL DEFAULT NULL ,
`net_cash_paid_buying`  double NULL DEFAULT NULL ,
`cash_paid_increase_construction`  double NULL DEFAULT NULL ,
`cash_paid_acquire_asset`  double NULL DEFAULT NULL ,
`net_cash_subsidiaries_payable`  double NULL DEFAULT NULL ,
`cash_received_other_operating`  double NULL DEFAULT NULL ,
`subtotal_cash_outflow_investment`  double NULL DEFAULT NULL ,
`net_cash_outflow_investment`  double NULL DEFAULT NULL ,
`cash_flow_fund_raising`  double NULL DEFAULT NULL ,
`cash_received_capital_contribution`  double NULL DEFAULT NULL ,
`asset_securitization_absorption_cash`  double NULL DEFAULT NULL ,
`cash_received_issuing_bond`  double NULL DEFAULT NULL ,
`cash_received_subordinated_bond`  double NULL DEFAULT NULL ,
`cash_received_increase_equity`  double NULL DEFAULT NULL ,
`cash_received_other_financing`  double NULL DEFAULT NULL ,
`subtotal_cash_inflow_financing`  double NULL DEFAULT NULL ,
`cash_paid_repayments_debt`  double NULL DEFAULT NULL ,
`payment_interest_dividend_profit`  double NULL DEFAULT NULL ,
`cash_payment_interest`  double NULL DEFAULT NULL ,
`payment_new_stock_expense`  double NULL DEFAULT NULL ,
`cash_payment_other_financing`  double NULL DEFAULT NULL ,
`subtotal_cash_outflow_financing`  double NULL DEFAULT NULL ,
`net_cash_flow_financing`  double NULL DEFAULT NULL ,
`cash_influence_fluctuation_exchange`  double NULL DEFAULT NULL ,
`net_increase_cash_equivalent`  double NULL DEFAULT NULL ,
`beginning_balance_cash_equivalent`  double NULL DEFAULT NULL ,
`final_balance_cash_equivalent`  double NULL DEFAULT NULL ,
`footnote`  double NULL DEFAULT NULL ,
`net_profit`  double NULL DEFAULT NULL ,
`minority_shareholder_benefit`  double NULL DEFAULT NULL ,
`provisional_capital_depreciation`  double NULL DEFAULT NULL ,
`provisional_bad_debt`  double NULL DEFAULT NULL ,
`provisional_loan_loss`  double NULL DEFAULT NULL ,
`dashed_back_nostro_impairment`  double NULL DEFAULT NULL ,
`fixed_og_biological_depreciation`  double NULL DEFAULT NULL ,
`investment_real_estate_depreciation`  double NULL DEFAULT NULL ,
`amortization_intangible_deferred_other`  double NULL DEFAULT NULL ,
`amortization_intangible_asset`  double NULL DEFAULT NULL ,
`amortisation_long_deferred_expense`  double NULL DEFAULT NULL ,
`amortization_long_term_asset`  double NULL DEFAULT NULL ,
`loss_disposing_long_asset`  double NULL DEFAULT NULL ,
`loss_disposing_investment_property`  double NULL DEFAULT NULL ,
`loss_retirement_fixed_asset`  double NULL DEFAULT NULL ,
`financial_expense`  double NULL DEFAULT NULL ,
`investment_loss`  double NULL DEFAULT NULL ,
`change_fair_value`  double NULL DEFAULT NULL ,
`exchange_gain_loss`  double NULL DEFAULT NULL ,
`net_gl_derivative_financial`  double NULL DEFAULT NULL ,
`discounted_back_pull`  double NULL DEFAULT NULL ,
`decrease_inventory`  double NULL DEFAULT NULL ,
`decrease_loan`  double NULL DEFAULT NULL ,
`increase_deposit`  double NULL DEFAULT NULL ,
`lending_money_net`  double NULL DEFAULT NULL ,
`reduction_financial_asset`  double NULL DEFAULT NULL ,
`increase_estimated_liability`  double NULL DEFAULT NULL ,
`payment_verification_received`  double NULL DEFAULT NULL ,
`reduction_deferred_tax_asset`  double NULL DEFAULT NULL ,
`increase_deferred_tax_liability`  double NULL DEFAULT NULL ,
`increase_operating_receivable`  double NULL DEFAULT NULL ,
`increase_operating_payable`  double NULL DEFAULT NULL ,
`decrease_operating_other_asset`  double NULL DEFAULT NULL ,
`increase_operating_other_liability`  double NULL DEFAULT NULL ,
`other`  double NULL DEFAULT NULL ,
`net_cash_flow_operating2`  double NULL DEFAULT NULL ,
`fixed_assets_repay_debt`  double NULL DEFAULT NULL ,
`investment_repay_debt`  double NULL DEFAULT NULL ,
`investment_fixed_asset`  double NULL DEFAULT NULL ,
`conversion_debt_capital`  double NULL DEFAULT NULL ,
`conver_tible_bond_ayear`  double NULL DEFAULT NULL ,
`fixed_assets_financing_lease`  double NULL DEFAULT NULL ,
`other_noncash_financing`  double NULL DEFAULT NULL ,
`cash_final_balance`  double NULL DEFAULT NULL ,
`cash_beginning_balance`  double NULL DEFAULT NULL ,
`cash_equivalent_final_balance`  double NULL DEFAULT NULL ,
`cash_equivalent_beginning_balance`  double NULL DEFAULT NULL ,
`net_increase_cash_equivalent2`  double NULL DEFAULT NULL ,
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
`seq_no`  int(11) NOT NULL AUTO_INCREMENT ,
`stock_id`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`statement_date`  date NOT NULL ,
`unit`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`cash_flow_operating`  double NULL DEFAULT NULL ,
`cash_sale_labour_received`  double NULL DEFAULT NULL ,
`net_increase_deposit_interbank`  double NULL DEFAULT NULL ,
`net_increase_loan_cb`  double NULL DEFAULT NULL ,
`net_increase_loan_otherfinan`  double NULL DEFAULT NULL ,
`primary_insurance_premium_received`  double NULL DEFAULT NULL ,
`reinsurance_business_net_received`  double NULL DEFAULT NULL ,
`net_increase_deposit_investment`  double NULL DEFAULT NULL ,
`net_increase_disposal_financial`  double NULL DEFAULT NULL ,
`interest_fee_commission_received`  double NULL DEFAULT NULL ,
`net_increase_capital_borrowed`  double NULL DEFAULT NULL ,
`net_increase_repurchase_capital`  double NULL DEFAULT NULL ,
`refund_tax_received`  double NULL DEFAULT NULL ,
`cash_other_operating_received`  double NULL DEFAULT NULL ,
`subtotal_cash_inflow_operating`  double NULL DEFAULT NULL ,
`cash_sale_labour_payable`  double NULL DEFAULT NULL ,
`net_increase_loan_advance`  double NULL DEFAULT NULL ,
`net_increase_cb_interbank`  double NULL DEFAULT NULL ,
`primary_insurance_premium_payable`  double NULL DEFAULT NULL ,
`interest_fee_commission_payable`  double NULL DEFAULT NULL ,
`cash_policy_dividend_payable`  double NULL DEFAULT NULL ,
`payment_employee_cash`  double NULL DEFAULT NULL ,
`tax_payment`  double NULL DEFAULT NULL ,
`payment_cash_other_operating`  double NULL DEFAULT NULL ,
`subtotal_cash_outflow_operating`  double NULL DEFAULT NULL ,
`net_cash_flow_operating`  double NULL DEFAULT NULL ,
`cash_flow_investment`  double NULL DEFAULT NULL ,
`cash_received_investment`  double NULL DEFAULT NULL ,
`cash_received_investment_income`  double NULL DEFAULT NULL ,
`disposal_asset_cash_received`  double NULL DEFAULT NULL ,
`net_cash_subsidiaries_received`  double NULL DEFAULT NULL ,
`cash_received_other_investing`  double NULL DEFAULT NULL ,
`reduce_deposit_cash_pledge`  double NULL DEFAULT NULL ,
`subtotal_cash_inflow_investment`  double NULL DEFAULT NULL ,
`cash_paid_acquire_asset`  double NULL DEFAULT NULL ,
`cash_payment_investment`  double NULL DEFAULT NULL ,
`net_increase_mortgage_loan`  double NULL DEFAULT NULL ,
`net_cash_subsidiaries_payable`  double NULL DEFAULT NULL ,
`cash_investment_other_payable`  double NULL DEFAULT NULL ,
`increase_pledge_deposit_payable`  double NULL DEFAULT NULL ,
`subtotal_cash_outflow_investment`  double NULL DEFAULT NULL ,
`net_cash_outflow_investment`  double NULL DEFAULT NULL ,
`cash_flow_fund_raising`  double NULL DEFAULT NULL ,
`cash_received_capital_contribution`  double NULL DEFAULT NULL ,
`minority_shareholder_investment_subsidiary`  double NULL DEFAULT NULL ,
`cash_received_loan`  double NULL DEFAULT NULL ,
`cash_received_issuing_bond`  double NULL DEFAULT NULL ,
`cash_received_other_financing`  double NULL DEFAULT NULL ,
`subtotal_cash_inflow_financing`  double NULL DEFAULT NULL ,
`cash_paid_repayments_debt`  double NULL DEFAULT NULL ,
`blank`  double NULL DEFAULT NULL ,
`payment_interest_dividend_profit`  double NULL DEFAULT NULL ,
`cash_payment_other_financing`  double NULL DEFAULT NULL ,
`subtotal_cash_outflow_financing`  double NULL DEFAULT NULL ,
`net_cash_flow_financing`  double NULL DEFAULT NULL ,
`footnote`  double NULL DEFAULT NULL ,
`cash_influence_fluctuation_exchange`  double NULL DEFAULT NULL ,
`net_increase_cash_equivalent`  double NULL DEFAULT NULL ,
`beginning_balance_cash_equivalent`  double NULL DEFAULT NULL ,
`final_balance_cash_equivalent`  double NULL DEFAULT NULL ,
`net_profit`  double NULL DEFAULT NULL ,
`minority_shareholder_benefit`  double NULL DEFAULT NULL ,
`unrecognized_investment_loss`  double NULL DEFAULT NULL ,
`asset_depreciation_reserve`  double NULL DEFAULT NULL ,
`fixed_og_biological_depreciation`  double NULL DEFAULT NULL ,
`amortization_intangible_asset`  double NULL DEFAULT NULL ,
`amortisation_long_deferred_expense`  double NULL DEFAULT NULL ,
`reduction_deferred_expense`  double NULL DEFAULT NULL ,
`increase_accrued_expense`  double NULL DEFAULT NULL ,
`loss_disposing_long_asset`  double NULL DEFAULT NULL ,
`loss_retirement_fixed_asset`  double NULL DEFAULT NULL ,
`change_fair_value`  double NULL DEFAULT NULL ,
`deferred_revenue_increase`  double NULL DEFAULT NULL ,
`anticipation_liability`  double NULL DEFAULT NULL ,
`financial_expense`  double NULL DEFAULT NULL ,
`investment_loss`  double NULL DEFAULT NULL ,
`reduction_deferred_tax_asset`  double NULL DEFAULT NULL ,
`increase_deferred_tax_liability`  double NULL DEFAULT NULL ,
`decrease_inventory`  double NULL DEFAULT NULL ,
`reduction_operating_receivable`  double NULL DEFAULT NULL ,
`increase_operating_payable`  double NULL DEFAULT NULL ,
`paragraph_reduction_completed_yet`  double NULL DEFAULT NULL ,
`settlement_increase_yet_completed`  double NULL DEFAULT NULL ,
`other`  double NULL DEFAULT NULL ,
`net_cash_flow_operating2`  double NULL DEFAULT NULL ,
`conversion_debt_capital`  double NULL DEFAULT NULL ,
`conver_tible_bond_ayear`  double NULL DEFAULT NULL ,
`fixed_assets_financing_lease`  double NULL DEFAULT NULL ,
`cash_final_balance`  double NULL DEFAULT NULL ,
`cash_beginning_balance`  double NULL DEFAULT NULL ,
`cash_equivalent_final_balance`  double NULL DEFAULT NULL ,
`cash_equivalent_beginning_balance`  double NULL DEFAULT NULL ,
`net_increase_cash_equivalent2`  double NULL DEFAULT NULL ,
PRIMARY KEY (`seq_no`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1
CHECKSUM=0
ROW_FORMAT=FIXED
DELAY_KEY_WRITE=0
;
