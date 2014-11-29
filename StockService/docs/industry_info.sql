/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : stock

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2014-11-10 20:20:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `industry_info`
-- ----------------------------
DROP TABLE IF EXISTS `industry_info`;
CREATE TABLE `industry_info` (
  `industry_id` int(11) NOT NULL AUTO_INCREMENT,
  `industry_name` varchar(10) NOT NULL,
  PRIMARY KEY (`industry_id`)
) ENGINE=MyISAM AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of industry_info
-- ----------------------------
INSERT INTO `industry_info` VALUES ('1', '金融行业');
INSERT INTO `industry_info` VALUES ('2', '房地产');
INSERT INTO `industry_info` VALUES ('3', '生物制药');
INSERT INTO `industry_info` VALUES ('4', '酒店旅游');
INSERT INTO `industry_info` VALUES ('5', '综合行业');
INSERT INTO `industry_info` VALUES ('6', '建筑建材');
INSERT INTO `industry_info` VALUES ('7', '玻璃行业');
INSERT INTO `industry_info` VALUES ('8', '家电行业');
INSERT INTO `industry_info` VALUES ('9', '自行车');
INSERT INTO `industry_info` VALUES ('10', '纺织行业');
INSERT INTO `industry_info` VALUES ('11', '食品行业');
INSERT INTO `industry_info` VALUES ('12', '电子器件');
INSERT INTO `industry_info` VALUES ('13', '电子信息');
INSERT INTO `industry_info` VALUES ('14', '交通运输');
INSERT INTO `industry_info` VALUES ('15', '汽车类');
INSERT INTO `industry_info` VALUES ('16', '商业百货');
INSERT INTO `industry_info` VALUES ('17', '电力行业');
INSERT INTO `industry_info` VALUES ('18', '煤炭行业');
INSERT INTO `industry_info` VALUES ('19', '机械行业');
INSERT INTO `industry_info` VALUES ('20', '农林牧渔');
INSERT INTO `industry_info` VALUES ('21', '电器行业');
INSERT INTO `industry_info` VALUES ('22', '石油行业');
INSERT INTO `industry_info` VALUES ('23', '有色金属');
INSERT INTO `industry_info` VALUES ('24', '物资外贸');
INSERT INTO `industry_info` VALUES ('25', '农药化肥');
INSERT INTO `industry_info` VALUES ('26', '传媒娱乐');
INSERT INTO `industry_info` VALUES ('27', '发电设备');
INSERT INTO `industry_info` VALUES ('28', '水泥行业');
INSERT INTO `industry_info` VALUES ('29', '塑料制品');
INSERT INTO `industry_info` VALUES ('30', '钢铁行业');
INSERT INTO `industry_info` VALUES ('31', '化纤行业');
INSERT INTO `industry_info` VALUES ('32', '公路桥梁');
INSERT INTO `industry_info` VALUES ('33', '造纸行业');
INSERT INTO `industry_info` VALUES ('34', '化工行业');
INSERT INTO `industry_info` VALUES ('35', '非金属品');
INSERT INTO `industry_info` VALUES ('36', '环保行业');
INSERT INTO `industry_info` VALUES ('37', '酿酒行业');
INSERT INTO `industry_info` VALUES ('38', '供水供气');
INSERT INTO `industry_info` VALUES ('39', '仪器仪表');
INSERT INTO `industry_info` VALUES ('40', '开发区');
INSERT INTO `industry_info` VALUES ('41', '印刷包装');
INSERT INTO `industry_info` VALUES ('42', '纺织机械');
INSERT INTO `industry_info` VALUES ('43', '飞机制造');
INSERT INTO `industry_info` VALUES ('44', '家具行业');
INSERT INTO `industry_info` VALUES ('45', '摩托车');
INSERT INTO `industry_info` VALUES ('46', '服装鞋类');
INSERT INTO `industry_info` VALUES ('47', '陶瓷行业');
INSERT INTO `industry_info` VALUES ('48', '其它制造');
INSERT INTO `industry_info` VALUES ('49', '医疗器械');
INSERT INTO `industry_info` VALUES ('50', '船舶制造');
