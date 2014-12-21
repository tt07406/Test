CREATE TABLE `equity_change_statement` (
`seq_no`  int(11) NOT NULL AUTO_INCREMENT , #序列号
`stock_id`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL , #股票代码
`project_equity`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL , #项目股本
`capital_reserve`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL , #资本公积
`surplus_reserve`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL , #盈余公积
`general_risk_preparation`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL , #一般风险准备
`undistributed_profit`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL , #未分配利润
`translation_reserve`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL , #外币报表 折算差额
PRIMARY KEY (`seq_no`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1
CHECKSUM=0
ROW_FORMAT=DYNAMIC
DELAY_KEY_WRITE=0
;