CREATE TABLE `stock_avg_price` (
  `seq_no` int(11) NOT NULL AUTO_INCREMENT,
  `stock_id` char(6) CHARACTER SET latin1 NOT NULL,
  `stock_name` varchar(10) NOT NULL,
  `start_date` datetime NOT NULL,
  `start_price` double DEFAULT NULL,
  `end_date` datetime NOT NULL,
  `end_price` double DEFAULT NULL,
  `avg_value` double DEFAULT NULL,
  `section_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`seq_no`)
) ENGINE=MyISAM AUTO_INCREMENT=601 DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED

