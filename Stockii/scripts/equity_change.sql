CREATE TABLE `equity_change_statement` (
`seq_no`  int(11) NOT NULL AUTO_INCREMENT , #���к�
`stock_id`  char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL , #��Ʊ����
`project_equity`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL , #��Ŀ�ɱ�
`capital_reserve`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL , #�ʱ�����
`surplus_reserve`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL , #ӯ�๫��
`general_risk_preparation`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL , #һ�����׼��
`undistributed_profit`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL , #δ��������
`translation_reserve`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL , #��ұ��� ������
PRIMARY KEY (`seq_no`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1
CHECKSUM=0
ROW_FORMAT=DYNAMIC
DELAY_KEY_WRITE=0
;