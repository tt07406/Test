/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : stock

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2014-11-10 20:19:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `area_info`
-- ----------------------------
DROP TABLE IF EXISTS `area_info`;
CREATE TABLE `area_info` (
  `area_id` int(11) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(10) NOT NULL,
  PRIMARY KEY (`area_id`)
) ENGINE=MyISAM AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of area_info
-- ----------------------------
INSERT INTO `area_info` VALUES ('1', '上海');
INSERT INTO `area_info` VALUES ('2', '云南');
INSERT INTO `area_info` VALUES ('3', '内蒙');
INSERT INTO `area_info` VALUES ('4', '北京');
INSERT INTO `area_info` VALUES ('5', '吉林');
INSERT INTO `area_info` VALUES ('6', '四川');
INSERT INTO `area_info` VALUES ('7', '天津');
INSERT INTO `area_info` VALUES ('8', '宁夏');
INSERT INTO `area_info` VALUES ('9', '安徽');
INSERT INTO `area_info` VALUES ('10', '山东');
INSERT INTO `area_info` VALUES ('11', '山西');
INSERT INTO `area_info` VALUES ('12', '广东');
INSERT INTO `area_info` VALUES ('13', '广西');
INSERT INTO `area_info` VALUES ('14', '新疆');
INSERT INTO `area_info` VALUES ('15', '江苏');
INSERT INTO `area_info` VALUES ('16', '江西');
INSERT INTO `area_info` VALUES ('17', '河北');
INSERT INTO `area_info` VALUES ('18', '河南');
INSERT INTO `area_info` VALUES ('19', '浙江');
INSERT INTO `area_info` VALUES ('20', '海南');
INSERT INTO `area_info` VALUES ('21', '深圳');
INSERT INTO `area_info` VALUES ('22', '湖北');
INSERT INTO `area_info` VALUES ('23', '湖南');
INSERT INTO `area_info` VALUES ('24', '甘肃');
INSERT INTO `area_info` VALUES ('25', '福建');
INSERT INTO `area_info` VALUES ('26', '西藏');
INSERT INTO `area_info` VALUES ('27', '贵州');
INSERT INTO `area_info` VALUES ('28', '辽宁');
INSERT INTO `area_info` VALUES ('29', '重庆');
INSERT INTO `area_info` VALUES ('30', '陕西');
INSERT INTO `area_info` VALUES ('31', '青海');
INSERT INTO `area_info` VALUES ('32', '黑龙江');
