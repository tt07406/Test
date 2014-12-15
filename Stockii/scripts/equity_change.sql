CREATE TABLE `equity_change_statement` (
`seq_no`  int(11) NOT NULL AUTO_INCREMENT ,
`stock_id`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`project_equity`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`capital_reserve`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`surplus_reserve`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`general_risk_preparation`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`undistributed_profit`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`translation_reserve`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`seq_no`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1
CHECKSUM=0
ROW_FORMAT=DYNAMIC
DELAY_KEY_WRITE=0
;