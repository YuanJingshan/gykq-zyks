/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : gykq_zyks

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-02-19 12:39:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin_info
-- ----------------------------
DROP TABLE IF EXISTS `t_admin_info`;
CREATE TABLE `t_admin_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) DEFAULT NULL,
  `real_name` varchar(20) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `authority` tinyint(4) DEFAULT NULL,
  `insert_dt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1030 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_admin_info
-- ----------------------------
INSERT INTO `t_admin_info` VALUES ('1001', '周海峡', '周海峡', 'e10adc3949ba59abbe56e057f20f883e', '', '', '2', '2015-01-27 21:08:11');
INSERT INTO `t_admin_info` VALUES ('1003', '周思言', '周思言', 'e10adc3949ba59abbe56e057f20f883e', '', '', '3', '2015-01-28 16:40:15');
INSERT INTO `t_admin_info` VALUES ('1004', '周维', '周维', 'e10adc3949ba59abbe56e057f20f883e', '', '', '4', '2015-06-15 23:41:13');
INSERT INTO `t_admin_info` VALUES ('1005', '杨蓉', '杨蓉', 'e10adc3949ba59abbe56e057f20f883e', '', '', '9', '2015-06-16 21:50:22');
INSERT INTO `t_admin_info` VALUES ('1029', '陈黎明', '陈黎明', 'e10adc3949ba59abbe56e057f20f883e', '', '', '1', '2018-07-09 18:29:57');
INSERT INTO `t_admin_info` VALUES ('1008', '蒋岚', '蒋岚', 'e10adc3949ba59abbe56e057f20f883e', '', '', '5', '2015-06-24 15:43:01');
INSERT INTO `t_admin_info` VALUES ('1009', '周龙', '周龙', 'e10adc3949ba59abbe56e057f20f883e', '', '', '6', '2015-06-24 15:43:41');
INSERT INTO `t_admin_info` VALUES ('1010', '侯超', '侯超', 'e10adc3949ba59abbe56e057f20f883e', '', '', '8', '2015-06-24 22:00:05');
INSERT INTO `t_admin_info` VALUES ('1011', '钟卫兰', '钟卫兰', 'e10adc3949ba59abbe56e057f20f883e', '', '', '7', '2015-06-24 22:00:38');
INSERT INTO `t_admin_info` VALUES ('1012', '丁危', '丁危', 'e10adc3949ba59abbe56e057f20f883e', '', '', '11', '2018-04-15 14:31:12');
INSERT INTO `t_admin_info` VALUES ('1013', '刘钰', '刘钰', 'e10adc3949ba59abbe56e057f20f883e', '', '', '12', '2018-04-17 21:30:26');
INSERT INTO `t_admin_info` VALUES ('1014', '黄钧一', '黄钧一', 'e10adc3949ba59abbe56e057f20f883e', '', '', '13', '2018-04-26 22:38:37');
INSERT INTO `t_admin_info` VALUES ('1015', '刘凰', '刘凰', 'e10adc3949ba59abbe56e057f20f883e', '', '', '14', '2018-04-26 22:39:30');
INSERT INTO `t_admin_info` VALUES ('1016', '张海', '张海', 'e10adc3949ba59abbe56e057f20f883e', '', '', '15', '2018-04-26 22:40:14');
INSERT INTO `t_admin_info` VALUES ('1017', '邓建红', '邓建红', 'e10adc3949ba59abbe56e057f20f883e', '', '', '16', '2018-04-26 22:40:53');
INSERT INTO `t_admin_info` VALUES ('1018', 'admin', 'admin', '202cb962ac59075b964b07152d234b70', '', '', '1', '2018-04-27 18:40:48');
INSERT INTO `t_admin_info` VALUES ('1019', '周思言1', '周思言1', 'e10adc3949ba59abbe56e057f20f883e', '', '', '17', '2018-04-29 19:59:14');
INSERT INTO `t_admin_info` VALUES ('1020', '蒋岚1', '蒋岚1', 'e10adc3949ba59abbe56e057f20f883e', '', '', '18', '2018-04-29 21:22:17');
INSERT INTO `t_admin_info` VALUES ('1028', '钟卫兰1', '钟卫兰1', 'e10adc3949ba59abbe56e057f20f883e', '', '', '19', '2018-07-09 15:42:02');
INSERT INTO `t_admin_info` VALUES ('1022', '丁危1', '丁危1', 'e10adc3949ba59abbe56e057f20f883e', '', '', '20', '2018-04-29 21:27:18');
INSERT INTO `t_admin_info` VALUES ('1023', '刘凰1', '刘凰1', 'e10adc3949ba59abbe56e057f20f883e', '', '', '21', '2018-04-29 21:27:33');
INSERT INTO `t_admin_info` VALUES ('1025', '邓建红1', '邓建红1', 'e10adc3949ba59abbe56e057f20f883e', '', '', '22', '2018-04-29 22:08:19');
INSERT INTO `t_admin_info` VALUES ('1026', 'admin', '', '0fefb246f94ce4b4e3d513c9ac386e92', '', '', '1', '2018-06-03 20:50:48');

-- ----------------------------
-- Table structure for t_doctor_info
-- ----------------------------
DROP TABLE IF EXISTS `t_doctor_info`;
CREATE TABLE `t_doctor_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `nation` varchar(20) DEFAULT NULL,
  `birthday` varchar(12) DEFAULT NULL,
  `card` varchar(18) DEFAULT NULL,
  `ksh` varchar(20) DEFAULT NULL,
  `exam_area` varchar(100) DEFAULT NULL,
  `exam_type` int(11) DEFAULT NULL,
  `area` varchar(100) DEFAULT NULL,
  `unit` varchar(100) DEFAULT NULL,
  `graduate_school` varchar(100) DEFAULT NULL,
  `graduate_major` varchar(100) DEFAULT NULL,
  `graduate_date` varchar(30) DEFAULT NULL,
  `education` varchar(20) DEFAULT NULL,
  `education_type` varchar(20) DEFAULT NULL,
  `assistant_dt` varchar(30) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `check_result` varchar(20) DEFAULT NULL,
  `check_people` varchar(20) DEFAULT NULL,
  `check_date` varchar(30) DEFAULT NULL,
  `check_not_yy` varchar(200) DEFAULT NULL,
  `check_bak` varchar(200) DEFAULT NULL,
  `check_area_result` varchar(20) DEFAULT NULL,
  `check_area_people` varchar(20) DEFAULT NULL,
  `check_area_date` varchar(30) DEFAULT NULL,
  `check_area_not_yy` varchar(200) DEFAULT NULL,
  `check_area_bak` varchar(200) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `home_tel` varchar(20) DEFAULT NULL,
  `unit_tel` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1536 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_doctor_info
-- ----------------------------
INSERT INTO `t_doctor_info` VALUES ('1534', '魏国琴', '女', '汉族', '1992-07-24', '522225198906067817', '520112000014', '贵州省-贵阳', '120', '南明区', '贵阳求恩百姓综合医院', '长沙医学院', '口腔医学', '41794.0', '本科', '普通全日制', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `t_doctor_info` VALUES ('1531', '刘兴沄', '女', '汉族', '1992-05-01', '520113199205010027', '520112000011', '贵州省-贵阳', '120', '南明区', '贵阳求恩百姓综合医院', '长沙医学院', '口腔医学', '41791.0', '本科', '普通全日制', '', '', '审核通过', '周欢', '2015-03-26', '', '', '审核通过', '贵州管理员', '2015-05-07', ' ', ' ', ' ', ' ', ' ');
INSERT INTO `t_doctor_info` VALUES ('1533', '杨柳', '女', '汉族', '1993-12-06', '652301199312060843', '520112000013', '贵州省-贵阳', '120', '南明区', '贵阳求恩百姓综合医院', '长沙医学院', '口腔医学', '41793.0', '本科', '普通全日制', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `t_doctor_info` VALUES ('1532', '马佳丽', '女', '汉族', '1994-03-01', '220722199403011440', '520112000012', '贵州省-贵阳', '120', '南明区', '贵阳求恩百姓综合医院', '长沙医学院', '口腔医学', '41792.0', '本科', '普通全日制', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `t_doctor_info` VALUES ('1535', '周海峡', '男', '汉族', '1985-08-07', '340826198508071419', '520112000011', '贵州省-贵阳', '120', '南明区', '贵阳求恩百姓综合医院', '长沙医学院', '口腔医学', '41791.0', '本科', '普通全日制', '', '', '审核通过', '周欢', '2015-03-26', '', '', '审核通过', '贵州管理员', '2015-05-07', ' ', ' ', ' ', ' ', ' ');

-- ----------------------------
-- Table structure for t_doctor_score
-- ----------------------------
DROP TABLE IF EXISTS `t_doctor_score`;
CREATE TABLE `t_doctor_score` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `serial_number` varchar(5) DEFAULT NULL COMMENT '序号',
  `score_1` float DEFAULT NULL COMMENT '第一考站成绩',
  `score_2` float DEFAULT NULL COMMENT '第二考站成绩',
  `score_3` float DEFAULT NULL COMMENT '第三考站成绩',
  `score_4` float DEFAULT NULL COMMENT '第四考站成绩',
  `score_5` float DEFAULT NULL COMMENT '第五考站成绩',
  `score_6` float DEFAULT NULL COMMENT '第六考站成绩',
  `score_count` float DEFAULT NULL,
  `entry_dt` datetime DEFAULT NULL COMMENT '检录时间',
  `insert_dt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_doctor_score
-- ----------------------------

-- ----------------------------
-- Table structure for t_exit_verify
-- ----------------------------
DROP TABLE IF EXISTS `t_exit_verify`;
CREATE TABLE `t_exit_verify` (
  `id` int(11) NOT NULL DEFAULT '0',
  `flag` tinyint(4) DEFAULT '0',
  `serial_number` varchar(5) DEFAULT NULL,
  `insert_dt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_exit_verify
-- ----------------------------

-- ----------------------------
-- Table structure for t_inspect
-- ----------------------------
DROP TABLE IF EXISTS `t_inspect`;
CREATE TABLE `t_inspect` (
  `id` int(11) NOT NULL DEFAULT '0',
  `flag` tinyint(4) DEFAULT '0',
  `topic1` varchar(5) DEFAULT NULL COMMENT '一考站题组号',
  `topic2` varchar(5) DEFAULT NULL COMMENT '二考站题组号',
  `topic3` varchar(5) DEFAULT NULL COMMENT '三考站题组号',
  `topic4` varchar(5) DEFAULT NULL COMMENT '四考站题组号',
  `topic5` varchar(5) DEFAULT NULL COMMENT '五考站题组号',
  `topic6` varchar(5) DEFAULT NULL COMMENT '六考站题组号',
  `serial_number` varchar(5) DEFAULT NULL,
  `insert_dt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_inspect
-- ----------------------------
INSERT INTO `t_inspect` VALUES ('1534', '2', '011', '121', '084', '061', '091', '078', '001', '2018-09-03 23:07:53');

-- ----------------------------
-- Table structure for t_station_1
-- ----------------------------
DROP TABLE IF EXISTS `t_station_1`;
CREATE TABLE `t_station_1` (
  `id` int(11) NOT NULL DEFAULT '0',
  `flag` tinyint(4) DEFAULT '0',
  `topic` varchar(5) DEFAULT NULL,
  `serial_number` varchar(5) DEFAULT NULL,
  `exam_group` varchar(20) DEFAULT NULL,
  `insert_dt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_station_1
-- ----------------------------

-- ----------------------------
-- Table structure for t_station_1_score
-- ----------------------------
DROP TABLE IF EXISTS `t_station_1_score`;
CREATE TABLE `t_station_1_score` (
  `id` int(11) NOT NULL DEFAULT '0',
  `topic` varchar(5) DEFAULT NULL,
  `serial_number` varchar(5) DEFAULT NULL,
  `score` float DEFAULT NULL,
  `count_1` float DEFAULT NULL,
  `topic_1_1` float DEFAULT NULL,
  `topic_1_2` float DEFAULT NULL,
  `topic_1_3` float DEFAULT NULL,
  `topic_1_4` float DEFAULT NULL,
  `topic_1_5` float DEFAULT NULL,
  `topic_1_6` float DEFAULT NULL,
  `topic_1_7` float DEFAULT NULL,
  `topic_1_8` float DEFAULT NULL,
  `count_2` float DEFAULT NULL,
  `topic_2_1` float DEFAULT NULL,
  `topic_2_2` float DEFAULT NULL,
  `topic_2_3` float DEFAULT NULL,
  `topic_2_4` float DEFAULT NULL,
  `topic_2_5` float DEFAULT NULL,
  `topic_2_6` float DEFAULT NULL,
  `topic_2_7` float DEFAULT NULL,
  `topic_2_8` float DEFAULT NULL,
  `count_3` float DEFAULT NULL,
  `topic_3_1` float DEFAULT NULL,
  `topic_3_2` float DEFAULT NULL,
  `topic_3_3` float DEFAULT NULL,
  `topic_3_4` float DEFAULT NULL,
  `topic_3_5` float DEFAULT NULL,
  `topic_3_6` float DEFAULT NULL,
  `topic_3_7` float DEFAULT NULL,
  `topic_3_8` float DEFAULT NULL,
  `count_4` float DEFAULT NULL,
  `topic_4_1` float DEFAULT NULL,
  `topic_4_2` float DEFAULT NULL,
  `topic_4_3` float DEFAULT NULL,
  `topic_4_4` float DEFAULT NULL,
  `topic_4_5` float DEFAULT NULL,
  `topic_4_6` float DEFAULT NULL,
  `topic_4_7` float DEFAULT NULL,
  `topic_4_8` float DEFAULT NULL,
  `count_5` float DEFAULT NULL,
  `topic_5_1` float DEFAULT NULL,
  `topic_5_2` float DEFAULT NULL,
  `topic_5_3` float DEFAULT NULL,
  `topic_5_4` float DEFAULT NULL,
  `topic_5_5` float DEFAULT NULL,
  `topic_5_6` float DEFAULT NULL,
  `topic_5_7` float DEFAULT NULL,
  `topic_5_8` float DEFAULT NULL,
  `count_6` float DEFAULT NULL,
  `topic_6_1` float DEFAULT NULL,
  `topic_6_2` float DEFAULT NULL,
  `topic_6_3` float DEFAULT NULL,
  `topic_6_4` float DEFAULT NULL,
  `topic_6_5` float DEFAULT NULL,
  `topic_6_6` float DEFAULT NULL,
  `topic_6_7` float DEFAULT NULL,
  `topic_6_8` float DEFAULT NULL,
  `entry_dt` datetime DEFAULT NULL,
  `insert_dt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_station_1_score
-- ----------------------------

-- ----------------------------
-- Table structure for t_station_2
-- ----------------------------
DROP TABLE IF EXISTS `t_station_2`;
CREATE TABLE `t_station_2` (
  `id` int(11) NOT NULL DEFAULT '0',
  `flag` tinyint(4) DEFAULT '0',
  `topic` varchar(5) DEFAULT NULL,
  `serial_number` varchar(5) DEFAULT NULL,
  `exam_group` varchar(20) DEFAULT NULL,
  `insert_dt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_station_2
-- ----------------------------

-- ----------------------------
-- Table structure for t_station_2_score
-- ----------------------------
DROP TABLE IF EXISTS `t_station_2_score`;
CREATE TABLE `t_station_2_score` (
  `id` int(11) NOT NULL DEFAULT '0',
  `topic` varchar(5) DEFAULT NULL,
  `serial_number` varchar(5) DEFAULT NULL,
  `score` float DEFAULT NULL,
  `count_1` float DEFAULT NULL,
  `topic_1_1` float DEFAULT NULL,
  `topic_1_2` float DEFAULT NULL,
  `topic_1_3` float DEFAULT NULL,
  `topic_1_4` float DEFAULT NULL,
  `topic_1_5` float DEFAULT NULL,
  `topic_1_6` float DEFAULT NULL,
  `topic_1_7` float DEFAULT NULL,
  `topic_1_8` float DEFAULT NULL,
  `count_2` float DEFAULT NULL,
  `topic_2_1` float DEFAULT NULL,
  `topic_2_2` float DEFAULT NULL,
  `topic_2_3` float DEFAULT NULL,
  `topic_2_4` float DEFAULT NULL,
  `topic_2_5` float DEFAULT NULL,
  `topic_2_6` float DEFAULT NULL,
  `topic_2_7` float DEFAULT NULL,
  `topic_2_8` float DEFAULT NULL,
  `count_3` float DEFAULT NULL,
  `topic_3_1` float DEFAULT NULL,
  `topic_3_2` float DEFAULT NULL,
  `topic_3_3` float DEFAULT NULL,
  `topic_3_4` float DEFAULT NULL,
  `topic_3_5` float DEFAULT NULL,
  `topic_3_6` float DEFAULT NULL,
  `topic_3_7` float DEFAULT NULL,
  `topic_3_8` float DEFAULT NULL,
  `count_4` float DEFAULT NULL,
  `topic_4_1` float DEFAULT NULL,
  `topic_4_2` float DEFAULT NULL,
  `topic_4_3` float DEFAULT NULL,
  `topic_4_4` float DEFAULT NULL,
  `topic_4_5` float DEFAULT NULL,
  `topic_4_6` float DEFAULT NULL,
  `topic_4_7` float DEFAULT NULL,
  `topic_4_8` float DEFAULT NULL,
  `count_5` float DEFAULT NULL,
  `topic_5_1` float DEFAULT NULL,
  `topic_5_2` float DEFAULT NULL,
  `topic_5_3` float DEFAULT NULL,
  `topic_5_4` float DEFAULT NULL,
  `topic_5_5` float DEFAULT NULL,
  `topic_5_6` float DEFAULT NULL,
  `topic_5_7` float DEFAULT NULL,
  `topic_5_8` float DEFAULT NULL,
  `count_6` float DEFAULT NULL,
  `topic_6_1` float DEFAULT NULL,
  `topic_6_2` float DEFAULT NULL,
  `topic_6_3` float DEFAULT NULL,
  `topic_6_4` float DEFAULT NULL,
  `topic_6_5` float DEFAULT NULL,
  `topic_6_6` float DEFAULT NULL,
  `topic_6_7` float DEFAULT NULL,
  `topic_6_8` float DEFAULT NULL,
  `entry_dt` datetime DEFAULT NULL,
  `insert_dt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_station_2_score
-- ----------------------------

-- ----------------------------
-- Table structure for t_station_3
-- ----------------------------
DROP TABLE IF EXISTS `t_station_3`;
CREATE TABLE `t_station_3` (
  `id` int(11) NOT NULL DEFAULT '0',
  `flag` tinyint(4) DEFAULT '0',
  `topic` varchar(5) DEFAULT NULL,
  `serial_number` varchar(5) DEFAULT NULL,
  `exam_group` varchar(20) DEFAULT NULL,
  `insert_dt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_station_3
-- ----------------------------

-- ----------------------------
-- Table structure for t_station_3_score
-- ----------------------------
DROP TABLE IF EXISTS `t_station_3_score`;
CREATE TABLE `t_station_3_score` (
  `id` int(11) NOT NULL DEFAULT '0',
  `topic` varchar(5) DEFAULT NULL,
  `serial_number` varchar(5) DEFAULT NULL,
  `score` float DEFAULT NULL,
  `count_1` float DEFAULT NULL,
  `topic_1_1` float DEFAULT NULL,
  `topic_1_2` float DEFAULT NULL,
  `topic_1_3` float DEFAULT NULL,
  `topic_1_4` float DEFAULT NULL,
  `topic_1_5` float DEFAULT NULL,
  `topic_1_6` float DEFAULT NULL,
  `topic_1_7` float DEFAULT NULL,
  `topic_1_8` float DEFAULT NULL,
  `count_2` float DEFAULT NULL,
  `topic_2_1` float DEFAULT NULL,
  `topic_2_2` float DEFAULT NULL,
  `topic_2_3` float DEFAULT NULL,
  `topic_2_4` float DEFAULT NULL,
  `topic_2_5` float DEFAULT NULL,
  `topic_2_6` float DEFAULT NULL,
  `topic_2_7` float DEFAULT NULL,
  `topic_2_8` float DEFAULT NULL,
  `count_3` float DEFAULT NULL,
  `topic_3_1` float DEFAULT NULL,
  `topic_3_2` float DEFAULT NULL,
  `topic_3_3` float DEFAULT NULL,
  `topic_3_4` float DEFAULT NULL,
  `topic_3_5` float DEFAULT NULL,
  `topic_3_6` float DEFAULT NULL,
  `topic_3_7` float DEFAULT NULL,
  `topic_3_8` float DEFAULT NULL,
  `count_4` float DEFAULT NULL,
  `topic_4_1` float DEFAULT NULL,
  `topic_4_2` float DEFAULT NULL,
  `topic_4_3` float DEFAULT NULL,
  `topic_4_4` float DEFAULT NULL,
  `topic_4_5` float DEFAULT NULL,
  `topic_4_6` float DEFAULT NULL,
  `topic_4_7` float DEFAULT NULL,
  `topic_4_8` float DEFAULT NULL,
  `count_5` float DEFAULT NULL,
  `topic_5_1` float DEFAULT NULL,
  `topic_5_2` float DEFAULT NULL,
  `topic_5_3` float DEFAULT NULL,
  `topic_5_4` float DEFAULT NULL,
  `topic_5_5` float DEFAULT NULL,
  `topic_5_6` float DEFAULT NULL,
  `topic_5_7` float DEFAULT NULL,
  `topic_5_8` float DEFAULT NULL,
  `count_6` float DEFAULT NULL,
  `topic_6_1` float DEFAULT NULL,
  `topic_6_2` float DEFAULT NULL,
  `topic_6_3` float DEFAULT NULL,
  `topic_6_4` float DEFAULT NULL,
  `topic_6_5` float DEFAULT NULL,
  `topic_6_6` float DEFAULT NULL,
  `topic_6_7` float DEFAULT NULL,
  `topic_6_8` float DEFAULT NULL,
  `entry_dt` datetime DEFAULT NULL,
  `insert_dt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_station_3_score
-- ----------------------------

-- ----------------------------
-- Table structure for t_station_info
-- ----------------------------
DROP TABLE IF EXISTS `t_station_info`;
CREATE TABLE `t_station_info` (
  `id` int(11) NOT NULL DEFAULT '0' COMMENT 'ID',
  `flag` tinyint(4) DEFAULT '0' COMMENT '状态信息',
  `topic` varchar(5) DEFAULT NULL COMMENT '题组号',
  `serial_number` varchar(5) DEFAULT NULL COMMENT '序号',
  `exam_group` varchar(20) DEFAULT NULL COMMENT '考组',
  `station` tinyint(4) DEFAULT NULL COMMENT '考站',
  `insert_dt` datetime DEFAULT NULL COMMENT '插入时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_station_info
-- ----------------------------
INSERT INTO `t_station_info` VALUES ('1534', '0', '061', '001', '', '4', '2018-09-03 23:08:35');

-- ----------------------------
-- Table structure for t_station_jgx
-- ----------------------------
DROP TABLE IF EXISTS `t_station_jgx`;
CREATE TABLE `t_station_jgx` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sta_1_jg` float DEFAULT NULL COMMENT '一站及格线',
  `sta_2_jg` float DEFAULT NULL COMMENT '二站及格线',
  `sta_3_jg` float DEFAULT NULL COMMENT '三站及格线',
  `sta_4_jg` float DEFAULT NULL COMMENT '四站及格线',
  `sta_5_jg` float DEFAULT NULL COMMENT '五站及格线',
  `sta_6_jg` float DEFAULT NULL COMMENT '六站及格线',
  `topic1` int(11) DEFAULT NULL COMMENT '一站题组号数量',
  `topic2` int(11) DEFAULT NULL COMMENT '二站题组号数量',
  `topic3` int(11) DEFAULT NULL COMMENT '三站题组号数量',
  `topic4` int(11) DEFAULT NULL COMMENT '四站题组号数量',
  `topic5` int(11) DEFAULT NULL COMMENT '五站题组号数量',
  `topic6` int(11) DEFAULT NULL COMMENT '六站题组号数量',
  `serial_number` int(11) DEFAULT NULL COMMENT '随机抽取序号',
  `insert_dt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_station_jgx
-- ----------------------------
INSERT INTO `t_station_jgx` VALUES ('1', '13', '25', '15', '9', '13', '14', '50', '150', '150', '150', '150', '150', '500', '2017-06-03 11:53:15');

-- ----------------------------
-- Table structure for t_station_score
-- ----------------------------
DROP TABLE IF EXISTS `t_station_score`;
CREATE TABLE `t_station_score` (
  `id` int(11) NOT NULL DEFAULT '0',
  `topic` varchar(5) DEFAULT NULL,
  `serial_number` varchar(5) DEFAULT NULL,
  `score` float DEFAULT NULL,
  `count_1` float DEFAULT NULL,
  `topic_1_1` float DEFAULT NULL,
  `topic_1_2` float DEFAULT NULL,
  `topic_1_3` float DEFAULT NULL,
  `topic_1_4` float DEFAULT NULL,
  `topic_1_5` float DEFAULT NULL,
  `topic_1_6` float DEFAULT NULL,
  `topic_1_7` float DEFAULT NULL,
  `topic_1_8` float DEFAULT NULL,
  `count_2` float DEFAULT NULL,
  `topic_2_1` float DEFAULT NULL,
  `topic_2_2` float DEFAULT NULL,
  `topic_2_3` float DEFAULT NULL,
  `topic_2_4` float DEFAULT NULL,
  `topic_2_5` float DEFAULT NULL,
  `topic_2_6` float DEFAULT NULL,
  `topic_2_7` float DEFAULT NULL,
  `topic_2_8` float DEFAULT NULL,
  `count_3` float DEFAULT NULL,
  `topic_3_1` float DEFAULT NULL,
  `topic_3_2` float DEFAULT NULL,
  `topic_3_3` float DEFAULT NULL,
  `topic_3_4` float DEFAULT NULL,
  `topic_3_5` float DEFAULT NULL,
  `topic_3_6` float DEFAULT NULL,
  `topic_3_7` float DEFAULT NULL,
  `topic_3_8` float DEFAULT NULL,
  `count_4` float DEFAULT NULL,
  `topic_4_1` float DEFAULT NULL,
  `topic_4_2` float DEFAULT NULL,
  `topic_4_3` float DEFAULT NULL,
  `topic_4_4` float DEFAULT NULL,
  `topic_4_5` float DEFAULT NULL,
  `topic_4_6` float DEFAULT NULL,
  `topic_4_7` float DEFAULT NULL,
  `topic_4_8` float DEFAULT NULL,
  `count_5` float DEFAULT NULL,
  `topic_5_1` float DEFAULT NULL,
  `topic_5_2` float DEFAULT NULL,
  `topic_5_3` float DEFAULT NULL,
  `topic_5_4` float DEFAULT NULL,
  `topic_5_5` float DEFAULT NULL,
  `topic_5_6` float DEFAULT NULL,
  `topic_5_7` float DEFAULT NULL,
  `topic_5_8` float DEFAULT NULL,
  `count_6` float DEFAULT NULL,
  `topic_6_1` float DEFAULT NULL,
  `topic_6_2` float DEFAULT NULL,
  `topic_6_3` float DEFAULT NULL,
  `topic_6_4` float DEFAULT NULL,
  `topic_6_5` float DEFAULT NULL,
  `topic_6_6` float DEFAULT NULL,
  `topic_6_7` float DEFAULT NULL,
  `topic_6_8` float DEFAULT NULL,
  `entry_dt` datetime DEFAULT NULL,
  `insert_dt` datetime DEFAULT NULL,
  `station` tinyint(4) DEFAULT NULL COMMENT '考站'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_station_score
-- ----------------------------

-- ----------------------------
-- Table structure for t_sys_log
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_log`;
CREATE TABLE `t_sys_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `real_name` varchar(20) DEFAULT NULL,
  `op_desc` varchar(100) DEFAULT NULL,
  `op_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=337 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_log
-- ----------------------------
INSERT INTO `t_sys_log` VALUES ('2', '1006', 'gly1', 'gly1', '登录系统', '2017-05-06 20:20:23');
INSERT INTO `t_sys_log` VALUES ('3', '1006', 'gly1', 'gly1', '修改考务人员：gly1', '2017-05-06 21:16:30');
INSERT INTO `t_sys_log` VALUES ('4', '1006', 'gly1', 'gly1', '初始化系统', '2017-05-06 22:16:11');
INSERT INTO `t_sys_log` VALUES ('5', '1006', 'gly1', 'gly1', '登录系统', '2017-05-07 22:26:34');
INSERT INTO `t_sys_log` VALUES ('6', '1006', 'gly1', 'gly1', '登录系统', '2017-05-07 22:26:42');
INSERT INTO `t_sys_log` VALUES ('7', '1006', 'gly1', 'gly1', '修改考务人员：shy', '2017-05-07 22:29:50');
INSERT INTO `t_sys_log` VALUES ('8', '1006', 'gly1', 'gly1', '修改考务人员：admin', '2017-05-07 22:30:10');
INSERT INTO `t_sys_log` VALUES ('9', '1006', 'gly1', 'gly1', '修改考务人员：gly', '2017-05-07 22:30:20');
INSERT INTO `t_sys_log` VALUES ('10', '1006', 'gly1', 'gly1', '修改系统参数', '2017-05-07 22:30:44');
INSERT INTO `t_sys_log` VALUES ('11', '1006', 'gly1', 'gly1', '修改系统参数', '2017-05-07 22:35:28');
INSERT INTO `t_sys_log` VALUES ('12', '1006', 'gly', 'gly1', '修改系统参数', '2017-05-07 22:47:18');
INSERT INTO `t_sys_log` VALUES ('13', '1001', 'jly', 'jly', '检录考生：956', '2017-05-07 22:48:58');
INSERT INTO `t_sys_log` VALUES ('14', '1001', 'jly', 'jly', '检录考生：956', '2017-05-07 22:53:10');
INSERT INTO `t_sys_log` VALUES ('15', '1001', 'jly', 'jly', '检录考生：956', '2017-05-07 22:54:41');
INSERT INTO `t_sys_log` VALUES ('16', '1003', 'fhy1', 'fhy1', '第一考站考生检录：956', '2017-05-07 22:56:26');
INSERT INTO `t_sys_log` VALUES ('17', '1003', 'fhy1', 'fhy1', '第一考站考生进入考试：956', '2017-05-07 22:58:21');
INSERT INTO `t_sys_log` VALUES ('18', '1003', 'fhy1', 'fhy1', '第一考站取消考生进入考试：956', '2017-05-07 23:00:54');
INSERT INTO `t_sys_log` VALUES ('19', '1003', 'fhy1', 'fhy1', '第一考站考生进入考试：956', '2017-05-07 23:01:03');
INSERT INTO `t_sys_log` VALUES ('20', '1003', 'fhy1', 'fhy1', '第一考站取消考生进入考试：956', '2017-05-07 23:01:12');
INSERT INTO `t_sys_log` VALUES ('21', '1003', 'fhy1', 'fhy1', '第一考站考生进入考试：956', '2017-05-07 23:02:56');
INSERT INTO `t_sys_log` VALUES ('22', '1001', 'jly', 'jly', '检录考生进站：956', '2017-05-07 23:04:53');
INSERT INTO `t_sys_log` VALUES ('23', '1004', 'dfy1', 'dfy1', '第一考站考生登分出站：956', '2017-05-07 23:17:03');
INSERT INTO `t_sys_log` VALUES ('24', '1008', 'fhy2', 'fhy2', '第二考站考生检录：956', '2017-05-07 23:18:05');
INSERT INTO `t_sys_log` VALUES ('25', '1008', 'fhy2', 'fhy2', '第二考站考生检录：956', '2017-05-07 23:20:05');
INSERT INTO `t_sys_log` VALUES ('26', '1008', 'fhy2', 'fhy2', '第二考站考生进入考试：956', '2017-05-07 23:20:13');
INSERT INTO `t_sys_log` VALUES ('27', '1009', 'dfy2', 'dfy2', '第二考站登分出站：956', '2017-05-07 23:22:02');
INSERT INTO `t_sys_log` VALUES ('28', '1011', 'fhy3', 'fhy3', '第三考站考生检录：956', '2017-05-07 23:23:29');
INSERT INTO `t_sys_log` VALUES ('29', '1011', 'fhy3', 'fhy3', '第三考站考生进入考生：956', '2017-05-07 23:23:31');
INSERT INTO `t_sys_log` VALUES ('30', '1010', 'dfy3', 'dfy3', '第三考站考生登分出站：956', '2017-05-07 23:24:10');
INSERT INTO `t_sys_log` VALUES ('31', '1005', 'shy', 'shy', '出口审核956', '2017-05-07 23:24:39');
INSERT INTO `t_sys_log` VALUES ('32', '1006', 'gly', 'gly1', '添加考务人员：gly', '2017-05-20 11:55:13');
INSERT INTO `t_sys_log` VALUES ('33', '1006', 'gly', 'gly1', '修改考务人员：yjs', '2017-05-20 11:55:39');
INSERT INTO `t_sys_log` VALUES ('34', '1035', 'yjs', '管理员', '修改考务人员：yjs', '2017-05-20 12:42:42');
INSERT INTO `t_sys_log` VALUES ('35', '1035', 'yjs', '管理员', '修改考务人员：yjs', '2017-05-20 12:42:48');
INSERT INTO `t_sys_log` VALUES ('36', '1035', 'yjs', '管理员', '删除考务人员：undefined', '2017-05-20 12:43:55');
INSERT INTO `t_sys_log` VALUES ('37', '1035', 'yjs', '管理员', '删除考务人员：undefined', '2017-05-20 12:44:00');
INSERT INTO `t_sys_log` VALUES ('38', '1035', 'yjs', '管理员', '删除考务人员：1006', '2017-05-20 12:45:50');
INSERT INTO `t_sys_log` VALUES ('39', '1034', 'admin', '袁景山', '修改考务人员：yjs', '2017-05-20 12:48:48');
INSERT INTO `t_sys_log` VALUES ('40', '1035', 'yjs', '管理员', '登录系统', '2017-05-20 13:02:39');
INSERT INTO `t_sys_log` VALUES ('41', '1001', 'jly', 'jly', '检录考生：955', '2017-05-20 13:03:22');
INSERT INTO `t_sys_log` VALUES ('42', '1001', 'jly', 'jly', '检录考生进站：955', '2017-05-20 13:06:04');
INSERT INTO `t_sys_log` VALUES ('43', '1003', 'fhy1', 'fhy1', '第一考站考生检录：955', '2017-05-20 13:16:15');
INSERT INTO `t_sys_log` VALUES ('44', '1003', 'fhy1', 'fhy1', '第一考站考生进入考试：955', '2017-05-20 13:18:07');
INSERT INTO `t_sys_log` VALUES ('45', '1004', 'dfy1', 'dfy1', '第一考站考生登分出站：955', '2017-05-20 13:20:34');
INSERT INTO `t_sys_log` VALUES ('46', '1008', 'fhy2', 'fhy2', '第二考站考生检录：955', '2017-05-20 13:21:56');
INSERT INTO `t_sys_log` VALUES ('47', '1008', 'fhy2', 'fhy2', '第二考站考生进入考试：955', '2017-05-20 13:21:57');
INSERT INTO `t_sys_log` VALUES ('48', '1009', 'dfy2', 'dfy2', '第二考站登分出站：955', '2017-05-20 13:22:24');
INSERT INTO `t_sys_log` VALUES ('49', '1011', 'fhy3', 'fhy3', '第三考站考生检录：955', '2017-05-20 13:22:51');
INSERT INTO `t_sys_log` VALUES ('50', '1011', 'fhy3', 'fhy3', '第三考站考生进入考生：955', '2017-05-20 13:22:52');
INSERT INTO `t_sys_log` VALUES ('51', '1010', 'dfy3', 'dfy3', '第三考站考生登分出站：955', '2017-05-20 13:23:10');
INSERT INTO `t_sys_log` VALUES ('52', '1005', 'shy', 'shy', '出口审核955', '2017-05-20 13:23:44');
INSERT INTO `t_sys_log` VALUES ('53', '1035', 'yjs', '管理员', '导出考生成绩', '2017-05-20 13:29:31');
INSERT INTO `t_sys_log` VALUES ('54', '1035', 'yjs', '管理员', '导出正在考试考生信息', '2017-05-20 13:43:39');
INSERT INTO `t_sys_log` VALUES ('55', '1035', 'yjs', '管理员', '导入考生信息', '2017-05-23 10:16:13');
INSERT INTO `t_sys_log` VALUES ('56', '1035', 'yjs', '管理员', '导入考生信息', '2017-05-23 10:19:17');
INSERT INTO `t_sys_log` VALUES ('57', '1035', 'yjs', '管理员', '导入考生信息', '2017-05-23 10:41:56');
INSERT INTO `t_sys_log` VALUES ('58', '1035', 'yjs', '管理员', '导入考生信息', '2017-05-23 10:44:37');
INSERT INTO `t_sys_log` VALUES ('59', '1035', 'yjs', '管理员', '导入考生信息', '2017-05-23 10:45:44');
INSERT INTO `t_sys_log` VALUES ('60', '1035', 'yjs', '管理员', '删除考生undefined', '2017-05-23 10:45:52');
INSERT INTO `t_sys_log` VALUES ('61', '1035', 'yjs', '管理员', '导入考生信息', '2017-05-23 10:52:03');
INSERT INTO `t_sys_log` VALUES ('62', '1035', 'yjs', '管理员', '删除考生981', '2017-05-23 10:52:14');
INSERT INTO `t_sys_log` VALUES ('63', '1035', 'yjs', '管理员', '删除考生992', '2017-05-23 10:52:18');
INSERT INTO `t_sys_log` VALUES ('64', '1034', 'admin', '袁景山', '删除考生966', '2017-05-23 10:53:32');
INSERT INTO `t_sys_log` VALUES ('65', '1034', 'admin', '袁景山', '删除考生965', '2017-05-23 10:53:33');
INSERT INTO `t_sys_log` VALUES ('66', '1034', 'admin', '袁景山', '删除考生964', '2017-05-23 10:53:34');
INSERT INTO `t_sys_log` VALUES ('67', '1034', 'admin', '袁景山', '删除考生967', '2017-05-23 10:53:34');
INSERT INTO `t_sys_log` VALUES ('68', '1034', 'admin', '袁景山', '删除考生968', '2017-05-23 10:53:35');
INSERT INTO `t_sys_log` VALUES ('69', '1034', 'admin', '袁景山', '删除考生969', '2017-05-23 10:53:35');
INSERT INTO `t_sys_log` VALUES ('70', '1034', 'admin', '袁景山', '删除考生970', '2017-05-23 10:53:35');
INSERT INTO `t_sys_log` VALUES ('71', '1034', 'admin', '袁景山', '删除考生971', '2017-05-23 10:53:35');
INSERT INTO `t_sys_log` VALUES ('72', '1034', 'admin', '袁景山', '删除考生972', '2017-05-23 10:53:35');
INSERT INTO `t_sys_log` VALUES ('73', '1034', 'admin', '袁景山', '删除考生973', '2017-05-23 10:53:36');
INSERT INTO `t_sys_log` VALUES ('74', '1034', 'admin', '袁景山', '删除考生975', '2017-05-23 10:53:38');
INSERT INTO `t_sys_log` VALUES ('75', '1034', 'admin', '袁景山', '删除考生976', '2017-05-23 10:53:38');
INSERT INTO `t_sys_log` VALUES ('76', '1034', 'admin', '袁景山', '删除考生978', '2017-05-23 10:53:39');
INSERT INTO `t_sys_log` VALUES ('77', '1034', 'admin', '袁景山', '删除考生979', '2017-05-23 10:53:41');
INSERT INTO `t_sys_log` VALUES ('78', '1034', 'admin', '袁景山', '删除考生980', '2017-05-23 10:53:41');
INSERT INTO `t_sys_log` VALUES ('79', '1034', 'admin', '袁景山', '删除考生982', '2017-05-23 10:53:41');
INSERT INTO `t_sys_log` VALUES ('80', '1034', 'admin', '袁景山', '删除考生983', '2017-05-23 10:53:42');
INSERT INTO `t_sys_log` VALUES ('81', '1034', 'admin', '袁景山', '删除考生984', '2017-05-23 10:53:42');
INSERT INTO `t_sys_log` VALUES ('82', '1034', 'admin', '袁景山', '删除考生985', '2017-05-23 10:53:44');
INSERT INTO `t_sys_log` VALUES ('83', '1034', 'admin', '袁景山', '删除考生986', '2017-05-23 10:53:45');
INSERT INTO `t_sys_log` VALUES ('84', '1034', 'admin', '袁景山', '删除考生987', '2017-05-23 10:53:45');
INSERT INTO `t_sys_log` VALUES ('85', '1034', 'admin', '袁景山', '删除考生988', '2017-05-23 10:53:45');
INSERT INTO `t_sys_log` VALUES ('86', '1034', 'admin', '袁景山', '删除考生989', '2017-05-23 10:53:46');
INSERT INTO `t_sys_log` VALUES ('87', '1034', 'admin', '袁景山', '删除考生990', '2017-05-23 10:53:46');
INSERT INTO `t_sys_log` VALUES ('88', '1034', 'admin', '袁景山', '删除考生991', '2017-05-23 10:53:48');
INSERT INTO `t_sys_log` VALUES ('89', '1034', 'admin', '袁景山', '删除考生993', '2017-05-23 10:53:48');
INSERT INTO `t_sys_log` VALUES ('90', '1034', 'admin', '袁景山', '删除考生994', '2017-05-23 10:53:48');
INSERT INTO `t_sys_log` VALUES ('91', '1034', 'admin', '袁景山', '删除考生995', '2017-05-23 10:53:48');
INSERT INTO `t_sys_log` VALUES ('92', '1034', 'admin', '袁景山', '删除考生996', '2017-05-23 10:53:48');
INSERT INTO `t_sys_log` VALUES ('93', '1034', 'admin', '袁景山', '删除考生962', '2017-05-23 10:53:56');
INSERT INTO `t_sys_log` VALUES ('94', '1034', 'admin', '袁景山', '删除考生955', '2017-05-23 10:53:56');
INSERT INTO `t_sys_log` VALUES ('95', '1034', 'admin', '袁景山', '删除考生956', '2017-05-23 10:53:57');
INSERT INTO `t_sys_log` VALUES ('96', '1034', 'admin', '袁景山', '删除考生961', '2017-05-23 10:53:57');
INSERT INTO `t_sys_log` VALUES ('97', '1034', 'admin', '袁景山', '删除考生959', '2017-05-23 10:53:57');
INSERT INTO `t_sys_log` VALUES ('98', '1034', 'admin', '袁景山', '删除考生960', '2017-05-23 10:53:57');
INSERT INTO `t_sys_log` VALUES ('99', '1034', 'admin', '袁景山', '删除考生963', '2017-05-23 10:53:57');
INSERT INTO `t_sys_log` VALUES ('100', '1034', 'admin', '袁景山', '删除考生974', '2017-05-23 10:53:58');
INSERT INTO `t_sys_log` VALUES ('101', '1034', 'admin', '袁景山', '删除考生977', '2017-05-23 10:53:58');
INSERT INTO `t_sys_log` VALUES ('102', '1034', 'admin', '袁景山', '删除考生1001', '2017-05-23 10:54:01');
INSERT INTO `t_sys_log` VALUES ('103', '1034', 'admin', '袁景山', '删除考生1000', '2017-05-23 10:54:02');
INSERT INTO `t_sys_log` VALUES ('104', '1034', 'admin', '袁景山', '删除考生999', '2017-05-23 10:54:04');
INSERT INTO `t_sys_log` VALUES ('105', '1034', 'admin', '袁景山', '删除考生998', '2017-05-23 10:54:04');
INSERT INTO `t_sys_log` VALUES ('106', '1034', 'admin', '袁景山', '删除考生997', '2017-05-23 10:54:05');
INSERT INTO `t_sys_log` VALUES ('107', '1034', 'admin', '袁景山', '导入考生信息', '2017-05-23 10:54:23');
INSERT INTO `t_sys_log` VALUES ('108', '1001', 'jly', 'jly', '登录系统', '2017-05-31 10:33:13');
INSERT INTO `t_sys_log` VALUES ('109', '1001', 'jly', 'jly', '登录系统', '2017-05-31 10:45:51');
INSERT INTO `t_sys_log` VALUES ('110', '1001', 'jly', 'jly', '登录系统', '2017-05-31 11:33:17');
INSERT INTO `t_sys_log` VALUES ('111', '1034', 'admin', '袁景山', '添加考务人员：yjs', '2017-05-31 13:37:15');
INSERT INTO `t_sys_log` VALUES ('112', '1034', 'admin', '袁景山', '删除考务人员：1036', '2017-05-31 13:37:26');
INSERT INTO `t_sys_log` VALUES ('113', '1034', 'admin', '袁景山', '删除考生1006', '2017-05-31 13:37:41');
INSERT INTO `t_sys_log` VALUES ('114', '1034', 'admin', '袁景山', '导入考生信息', '2017-05-31 15:26:17');
INSERT INTO `t_sys_log` VALUES ('115', '1034', 'admin', '袁景山', '导入考生信息', '2017-05-31 15:26:36');
INSERT INTO `t_sys_log` VALUES ('116', '0', 'poomoo', null, '登录系统', '2017-06-03 11:13:29');
INSERT INTO `t_sys_log` VALUES ('117', '1035', 'yjs', '管理员', '初始化系统', '2017-06-03 20:19:51');
INSERT INTO `t_sys_log` VALUES ('118', '1035', 'yjs', '管理员', '删除考生1012', '2017-06-03 20:20:27');
INSERT INTO `t_sys_log` VALUES ('119', '1001', 'jly', 'jly', '检录考生：1011', '2017-06-03 20:20:59');
INSERT INTO `t_sys_log` VALUES ('120', '1001', 'jly', 'jly', '检录考生进站：1011', '2017-06-03 20:21:01');
INSERT INTO `t_sys_log` VALUES ('121', '1003', 'fhy1', 'fhy1', '第一考站考生检录：1011', '2017-06-03 20:22:15');
INSERT INTO `t_sys_log` VALUES ('122', '1003', 'fhy1', 'fhy1', '第一考站考生进入考试：1011', '2017-06-03 20:22:26');
INSERT INTO `t_sys_log` VALUES ('123', '1004', 'dfy1', 'dfy1', '第一考站考生登分出站：1011', '2017-06-03 22:01:53');
INSERT INTO `t_sys_log` VALUES ('124', '1035', 'yjs', '管理员', '添加考务人员：sfy1', '2017-06-03 22:15:15');
INSERT INTO `t_sys_log` VALUES ('125', '1035', 'yjs', '管理员', '添加考务人员：sfy2', '2017-06-03 22:18:22');
INSERT INTO `t_sys_log` VALUES ('126', '1035', 'yjs', '管理员', '添加考务人员：sfy3', '2017-06-03 22:19:16');
INSERT INTO `t_sys_log` VALUES ('127', '1035', 'yjs', '管理员', '修改考务人员：sfy3', '2017-06-03 22:19:30');
INSERT INTO `t_sys_log` VALUES ('128', '1035', 'yjs', '管理员', '修改考务人员：sfy3', '2017-06-03 22:20:25');
INSERT INTO `t_sys_log` VALUES ('129', '1035', 'yjs', '管理员', '修改考务人员：sfy3', '2017-06-03 22:26:18');
INSERT INTO `t_sys_log` VALUES ('130', '1037', 'sfy1', '审分员', '第一考站审核考生成绩：1011', '2017-06-04 08:41:07');
INSERT INTO `t_sys_log` VALUES ('131', '1003', 'fhy1', 'fhy1', '第一考站考生进入考试：1011', '2017-06-04 08:48:12');
INSERT INTO `t_sys_log` VALUES ('132', '1008', 'fhy2', 'fhy2', '第二考站考生检录：1011', '2017-06-04 08:50:11');
INSERT INTO `t_sys_log` VALUES ('133', '1008', 'fhy2', 'fhy2', '第二考站考生检录：1011', '2017-06-04 08:54:02');
INSERT INTO `t_sys_log` VALUES ('134', '1008', 'fhy2', 'fhy2', '第二考站考生进入考试：1011', '2017-06-04 08:54:09');
INSERT INTO `t_sys_log` VALUES ('135', '1009', 'dfy2', 'dfy2', '第二考站登分出站：1011', '2017-06-04 09:35:26');
INSERT INTO `t_sys_log` VALUES ('136', '1038', 'sfy2', '审分员', '第二考站审核考生成绩：1011', '2017-06-04 09:57:29');
INSERT INTO `t_sys_log` VALUES ('137', '1011', 'fhy3', 'fhy3', '第三考站考生检录：1011', '2017-06-04 09:59:41');
INSERT INTO `t_sys_log` VALUES ('138', '1011', 'fhy3', 'fhy3', '第三考站考生检录：1011', '2017-06-04 10:02:10');
INSERT INTO `t_sys_log` VALUES ('139', '1011', 'fhy3', 'fhy3', '第三考站考生进入考生：1011', '2017-06-04 10:02:12');
INSERT INTO `t_sys_log` VALUES ('140', '1010', 'dfy3', 'dfy3', '第三考站考生登分出站：1011', '2017-06-04 10:04:50');
INSERT INTO `t_sys_log` VALUES ('141', '0', 'poomoo', null, '修改考务人员：sfy3', '2017-06-04 10:07:19');
INSERT INTO `t_sys_log` VALUES ('142', '1039', 'sfy3', '审分员', '第三考站审核考生成绩：1011', '2017-06-04 10:09:00');
INSERT INTO `t_sys_log` VALUES ('143', '1039', 'sfy3', '审分员', '第三考站审核考生成绩：1011', '2017-06-04 10:09:19');
INSERT INTO `t_sys_log` VALUES ('144', '1039', 'sfy3', '审分员', '第三考站审核考生成绩：1011', '2017-06-04 10:10:26');
INSERT INTO `t_sys_log` VALUES ('145', '1039', 'sfy3', '审分员', '第三考站审核考生成绩：1011', '2017-06-04 10:11:46');
INSERT INTO `t_sys_log` VALUES ('146', '1005', 'shy', 'shy', '出口审核1011', '2017-06-04 10:15:04');
INSERT INTO `t_sys_log` VALUES ('147', '1005', 'shy', 'shy', '出口审核1011', '2017-06-04 10:19:00');
INSERT INTO `t_sys_log` VALUES ('148', '0', 'poomoo', null, '第二考站修改考生成绩：1011', '2017-06-04 10:57:04');
INSERT INTO `t_sys_log` VALUES ('149', '0', 'poomoo', null, '第二考站修改考生成绩：1011', '2017-06-04 10:57:45');
INSERT INTO `t_sys_log` VALUES ('150', '0', 'poomoo', null, '第二考站修改考生成绩：1011', '2017-06-04 11:00:18');
INSERT INTO `t_sys_log` VALUES ('151', '0', 'poomoo', null, '登录系统', '2017-06-04 11:32:09');
INSERT INTO `t_sys_log` VALUES ('152', '0', 'poomoo', null, '第三考站导出考生成绩', '2017-06-04 12:11:17');
INSERT INTO `t_sys_log` VALUES ('153', '0', 'poomoo', null, '第二考站导出考生成绩', '2017-06-04 12:11:32');
INSERT INTO `t_sys_log` VALUES ('154', '0', 'poomoo', null, '登录系统', '2017-06-04 12:17:55');
INSERT INTO `t_sys_log` VALUES ('155', '0', 'poomoo', null, '第二考站导出考生成绩', '2017-06-04 12:18:03');
INSERT INTO `t_sys_log` VALUES ('156', '1001', 'jly', 'jly', '检录考生：1011', '2017-06-04 12:24:49');
INSERT INTO `t_sys_log` VALUES ('157', '1001', 'jly', 'jly', '检录考生进站：1011', '2017-06-04 12:24:56');
INSERT INTO `t_sys_log` VALUES ('158', '1003', 'fhy1', 'fhy1', '第一考站考生检录：1011', '2017-06-04 12:25:49');
INSERT INTO `t_sys_log` VALUES ('159', '1003', 'fhy1', 'fhy1', '第一考站考生进入考试：1011', '2017-06-04 12:25:58');
INSERT INTO `t_sys_log` VALUES ('160', '1008', 'fhy2', 'fhy2', '第二考站考生检录：1011', '2017-06-04 12:26:43');
INSERT INTO `t_sys_log` VALUES ('161', '1008', 'fhy2', 'fhy2', '第二考站考生进入考试：1011', '2017-06-04 12:26:56');
INSERT INTO `t_sys_log` VALUES ('162', '1011', 'fhy3', 'fhy3', '第三考站考生检录：1011', '2017-06-04 12:27:26');
INSERT INTO `t_sys_log` VALUES ('163', '1011', 'fhy3', 'fhy3', '第三考站考生进入考生：1011', '2017-06-04 12:27:36');
INSERT INTO `t_sys_log` VALUES ('164', '1004', 'dfy1', 'dfy1', '第一考站考生登分出站：1011', '2017-06-04 12:28:17');
INSERT INTO `t_sys_log` VALUES ('165', '1009', 'dfy2', 'dfy2', '第二考站登分出站：1011', '2017-06-04 12:29:03');
INSERT INTO `t_sys_log` VALUES ('166', '1010', 'dfy3', 'dfy3', '第三考站考生登分出站：1011', '2017-06-04 12:30:16');
INSERT INTO `t_sys_log` VALUES ('167', '1037', 'sfy1', '审分员', '第一考站审核考生成绩：1011', '2017-06-04 12:31:46');
INSERT INTO `t_sys_log` VALUES ('168', '1038', 'sfy2', '审分员', '第二考站审核考生成绩：1011', '2017-06-04 12:32:22');
INSERT INTO `t_sys_log` VALUES ('169', '1039', 'sfy3', '审分员', '第三考站审核考生成绩：1011', '2017-06-04 12:33:03');
INSERT INTO `t_sys_log` VALUES ('170', '1005', 'shy', 'shy', '出口审核1011', '2017-06-04 12:36:04');
INSERT INTO `t_sys_log` VALUES ('171', '1035', 'yjs', '管理员', '修改系统参数', '2017-06-07 14:06:57');
INSERT INTO `t_sys_log` VALUES ('172', '1035', 'yjs', '管理员', '修改系统参数', '2017-06-07 14:07:47');
INSERT INTO `t_sys_log` VALUES ('173', '1035', 'yjs', '管理员', '修改系统参数', '2017-06-07 14:08:39');
INSERT INTO `t_sys_log` VALUES ('174', '1035', 'yjs', '管理员', '修改系统参数', '2017-06-07 14:09:40');
INSERT INTO `t_sys_log` VALUES ('175', '1035', 'yjs', '管理员', '修改系统参数', '2017-06-07 14:10:11');
INSERT INTO `t_sys_log` VALUES ('176', '1035', 'yjs', '管理员', '修改系统参数', '2017-06-07 14:10:27');
INSERT INTO `t_sys_log` VALUES ('177', '1001', 'jly', 'jly', '取消检录考生进站：1011', '2017-06-07 14:24:22');
INSERT INTO `t_sys_log` VALUES ('178', '1001', 'jly', 'jly', '检录考生进站：1011', '2017-06-07 14:25:12');
INSERT INTO `t_sys_log` VALUES ('179', '1003', 'fhy1', 'fhy1', '第一考站考生检录：1011', '2017-06-07 14:27:33');
INSERT INTO `t_sys_log` VALUES ('180', '1035', 'yjs', '管理员', '初始化系统', '2017-06-07 14:27:50');
INSERT INTO `t_sys_log` VALUES ('181', '1003', 'fhy1', 'fhy1', '第一考站考生检录：1011', '2017-06-07 14:28:35');
INSERT INTO `t_sys_log` VALUES ('182', '1003', 'fhy1', 'fhy1', '第一考站考生检录：1011', '2017-06-07 14:30:52');
INSERT INTO `t_sys_log` VALUES ('183', '1003', 'fhy1', 'fhy1', '第一考站考生进入考试：1011', '2017-06-07 14:38:53');
INSERT INTO `t_sys_log` VALUES ('184', '1004', 'dfy1', 'dfy1', '第一考站考生登分出站：1011', '2017-06-07 14:40:44');
INSERT INTO `t_sys_log` VALUES ('185', '1037', 'sfy1', '审分员', '第一考站审核考生成绩：1011', '2017-06-07 14:42:56');
INSERT INTO `t_sys_log` VALUES ('186', '1001', 'jly', 'jly', '检录考生：1011', '2017-06-07 14:48:22');
INSERT INTO `t_sys_log` VALUES ('187', '1008', 'fhy2', 'fhy2', '第二考站考生检录：1011', '2017-06-07 14:49:01');
INSERT INTO `t_sys_log` VALUES ('188', '1008', 'fhy2', 'fhy2', '第二考站考生进入考试：1011', '2017-06-07 14:52:52');
INSERT INTO `t_sys_log` VALUES ('189', '1009', 'dfy2', 'dfy2', '第二考站登分出站：1011', '2017-06-07 14:53:14');
INSERT INTO `t_sys_log` VALUES ('190', '1038', 'sfy2', '审分员', '第二考站审核考生成绩：1011', '2017-06-07 14:54:18');
INSERT INTO `t_sys_log` VALUES ('191', '1011', 'fhy3', 'fhy3', '第三考站考生检录：1011', '2017-06-07 15:14:06');
INSERT INTO `t_sys_log` VALUES ('192', '1011', 'fhy3', 'fhy3', '第三考站考生进入考生：1011', '2017-06-07 15:17:12');
INSERT INTO `t_sys_log` VALUES ('193', '1010', 'dfy3', 'dfy3', '第三考站考生登分出站：1011', '2017-06-07 15:28:47');
INSERT INTO `t_sys_log` VALUES ('194', '1039', 'sfy3', '审分员', '第三考站审核考生成绩：1011', '2017-06-07 15:32:48');
INSERT INTO `t_sys_log` VALUES ('195', '1003', 'fhy1', 'fhy1', '第一考站考生检录：1011', '2017-06-07 15:38:41');
INSERT INTO `t_sys_log` VALUES ('196', '1003', 'fhy1', 'fhy1', '第一考站考生进入考试：1011', '2017-06-07 15:40:35');
INSERT INTO `t_sys_log` VALUES ('197', '1004', 'dfy1', 'dfy1', '第一考站考生登分出站：1011', '2017-06-07 15:41:15');
INSERT INTO `t_sys_log` VALUES ('198', '1037', 'sfy1', '审分员', '第一考站审核考生成绩：1011', '2017-06-07 15:41:54');
INSERT INTO `t_sys_log` VALUES ('199', '1001', 'jly', 'jly', '检录考生：1011', '2017-06-07 17:53:20');
INSERT INTO `t_sys_log` VALUES ('200', '1001', 'jly', 'jly', '检录考生进站：1011', '2017-06-07 17:53:59');
INSERT INTO `t_sys_log` VALUES ('201', '1003', 'fhy1', 'fhy1', '第一考站考生检录：1011', '2017-06-07 17:55:22');
INSERT INTO `t_sys_log` VALUES ('202', '1003', 'fhy1', 'fhy1', '第一考站考生进入考试：1011', '2017-06-07 17:55:37');
INSERT INTO `t_sys_log` VALUES ('203', '1004', 'dfy1', 'dfy1', '第一考站考生登分出站：1011', '2017-06-07 17:56:11');
INSERT INTO `t_sys_log` VALUES ('204', '1004', 'dfy1', 'dfy1', '第一考站考生登分出站：1011', '2017-06-07 17:59:57');
INSERT INTO `t_sys_log` VALUES ('205', '1004', 'dfy1', 'dfy1', '第一考站考生登分出站：1011', '2017-06-07 18:00:12');
INSERT INTO `t_sys_log` VALUES ('206', '1037', 'sfy1', '审分员', '第一考站审核考生成绩：1011', '2017-06-07 19:09:16');
INSERT INTO `t_sys_log` VALUES ('207', '1008', 'fhy2', 'fhy2', '第二考站考生检录：1011', '2017-06-07 19:11:31');
INSERT INTO `t_sys_log` VALUES ('208', '1008', 'fhy2', 'fhy2', '第二考站考生进入考试：1011', '2017-06-07 19:11:33');
INSERT INTO `t_sys_log` VALUES ('209', '1009', 'dfy2', 'dfy2', '第二考站登分出站：1011', '2017-06-07 19:12:11');
INSERT INTO `t_sys_log` VALUES ('210', '1009', 'dfy2', 'dfy2', '第二考站登分出站：1011', '2017-06-07 19:12:57');
INSERT INTO `t_sys_log` VALUES ('211', '1038', 'sfy2', '审分员', '第二考站审核考生成绩：1011', '2017-06-07 19:21:03');
INSERT INTO `t_sys_log` VALUES ('212', '1035', 'yjs', '管理员', '第二考站导出考生成绩', '2017-06-07 19:21:12');
INSERT INTO `t_sys_log` VALUES ('213', '1035', 'yjs', '管理员', '第二考站导出考生成绩', '2017-06-07 19:23:45');
INSERT INTO `t_sys_log` VALUES ('214', '1035', 'yjs', '管理员', '第二考站导出考生成绩', '2017-06-07 19:29:27');
INSERT INTO `t_sys_log` VALUES ('215', '1035', 'yjs', '管理员', '第二考站导出考生成绩', '2017-06-07 19:29:30');
INSERT INTO `t_sys_log` VALUES ('216', '1035', 'yjs', '管理员', '第二考站导出考生成绩', '2017-06-07 19:29:32');
INSERT INTO `t_sys_log` VALUES ('217', '1035', 'yjs', '管理员', '第二考站导出考生成绩', '2017-06-07 19:32:45');
INSERT INTO `t_sys_log` VALUES ('218', '1035', 'yjs', '管理员', '第一考站导出考生成绩', '2017-06-07 19:34:40');
INSERT INTO `t_sys_log` VALUES ('219', '1035', 'yjs', '管理员', '第二考站导出考生成绩', '2017-06-07 19:35:22');
INSERT INTO `t_sys_log` VALUES ('220', '1035', 'yjs', '管理员', '第二考站导出考生成绩', '2017-06-07 19:37:15');
INSERT INTO `t_sys_log` VALUES ('221', '1035', 'yjs', '管理员', '第二考站导出考生成绩', '2017-06-07 19:41:27');
INSERT INTO `t_sys_log` VALUES ('222', '1035', 'yjs', '管理员', '第一考站导出考生成绩', '2017-06-07 19:41:38');
INSERT INTO `t_sys_log` VALUES ('223', '1011', 'fhy3', 'fhy3', '第三考站考生检录：1011', '2017-06-07 19:42:49');
INSERT INTO `t_sys_log` VALUES ('224', '1011', 'fhy3', 'fhy3', '第三考站考生进入考生：1011', '2017-06-07 19:42:49');
INSERT INTO `t_sys_log` VALUES ('225', '1010', 'dfy3', 'dfy3', '第三考站考生登分出站：1011', '2017-06-07 19:43:11');
INSERT INTO `t_sys_log` VALUES ('226', '1039', 'sfy3', '审分员', '第三考站审核考生成绩：1011', '2017-06-07 19:43:30');
INSERT INTO `t_sys_log` VALUES ('227', '1035', 'yjs', '管理员', '第三考站导出考生成绩', '2017-06-07 19:43:39');
INSERT INTO `t_sys_log` VALUES ('228', '1005', 'shy', 'shy', '出口审核1011', '2017-06-07 19:44:22');
INSERT INTO `t_sys_log` VALUES ('229', '1005', 'shy', 'shy', '出口审核1011', '2017-06-07 19:45:34');
INSERT INTO `t_sys_log` VALUES ('230', '1005', 'shy', 'shy', '出口审核1011', '2017-06-07 21:54:57');
INSERT INTO `t_sys_log` VALUES ('231', '1005', 'shy', 'shy', '出口审核1011', '2017-06-07 21:55:27');
INSERT INTO `t_sys_log` VALUES ('232', '1005', 'shy', 'shy', '出口审核1011', '2017-06-07 21:55:38');
INSERT INTO `t_sys_log` VALUES ('233', '1035', 'yjs', '管理员', '修改系统参数', '2017-06-07 22:16:17');
INSERT INTO `t_sys_log` VALUES ('234', '1001', 'jly', 'jly', '检录考生：1011', '2017-06-07 23:12:38');
INSERT INTO `t_sys_log` VALUES ('235', '1001', 'jly', 'jly', '检录考生进站：1011', '2017-06-07 23:12:45');
INSERT INTO `t_sys_log` VALUES ('236', '1008', 'fhy2', 'fhy2', '第二考站考生检录：1011', '2017-06-07 23:26:12');
INSERT INTO `t_sys_log` VALUES ('237', '1008', 'fhy2', 'fhy2', '第二考站考生检录：1011', '2017-06-07 23:27:20');
INSERT INTO `t_sys_log` VALUES ('238', '1008', 'fhy2', 'fhy2', '第二考站考生进入考试：1011', '2017-06-07 23:28:42');
INSERT INTO `t_sys_log` VALUES ('239', '1009', 'dfy2', 'dfy2', '第二考站登分出站：1011', '2017-06-07 23:31:25');
INSERT INTO `t_sys_log` VALUES ('240', '1009', 'dfy2', 'dfy2', '第二考站登分出站：1011', '2017-06-07 23:35:55');
INSERT INTO `t_sys_log` VALUES ('241', '1009', 'dfy2', 'dfy2', '第二考站登分出站：1011', '2017-06-07 23:36:56');
INSERT INTO `t_sys_log` VALUES ('242', '1038', 'sfy2', '审分员', '第二考站审核考生成绩：1011', '2017-06-07 23:43:14');
INSERT INTO `t_sys_log` VALUES ('243', '1011', 'fhy3', 'fhy3', '第三考站考生检录：1011', '2017-06-07 23:43:42');
INSERT INTO `t_sys_log` VALUES ('244', '1035', 'yjs', '管理员', '第二考站导出考生成绩', '2017-06-07 23:43:53');
INSERT INTO `t_sys_log` VALUES ('245', '1011', 'fhy3', 'fhy3', '第三考站考生进入考生：1011', '2017-06-07 23:44:05');
INSERT INTO `t_sys_log` VALUES ('246', '1010', 'dfy3', 'dfy3', '第三考站考生登分出站：1011', '2017-06-07 23:44:20');
INSERT INTO `t_sys_log` VALUES ('247', '1039', 'sfy3', '审分员', '第三考站审核考生成绩：1011', '2017-06-07 23:44:49');
INSERT INTO `t_sys_log` VALUES ('248', '1003', 'fhy1', 'fhy1', '第一考站考生检录：1011', '2017-06-07 23:47:26');
INSERT INTO `t_sys_log` VALUES ('249', '1003', 'fhy1', 'fhy1', '第一考站考生进入考试：1011', '2017-06-07 23:47:27');
INSERT INTO `t_sys_log` VALUES ('250', '1004', 'dfy1', 'dfy1', '第一考站考生登分出站：1011', '2017-06-07 23:47:44');
INSERT INTO `t_sys_log` VALUES ('251', '1037', 'sfy1', '审分员', '第一考站审核考生成绩：1011', '2017-06-07 23:47:59');
INSERT INTO `t_sys_log` VALUES ('252', '1005', 'shy', 'shy', '出口审核1011', '2017-06-07 23:48:34');
INSERT INTO `t_sys_log` VALUES ('253', '1005', 'shy', 'shy', '出口审核1011', '2017-06-07 23:50:11');
INSERT INTO `t_sys_log` VALUES ('254', '1035', 'yjs', '管理员', '第三考站导出考生成绩', '2017-06-07 23:50:21');
INSERT INTO `t_sys_log` VALUES ('255', '1035', 'yjs', '管理员', '导出考生成绩', '2017-06-07 23:50:43');
INSERT INTO `t_sys_log` VALUES ('256', '1035', 'yjs', '管理员', '导出考生成绩', '2017-06-08 00:00:47');
INSERT INTO `t_sys_log` VALUES ('257', '1001', 'jly', 'jly', '检录考生：1011', '2017-06-08 07:53:44');
INSERT INTO `t_sys_log` VALUES ('258', '1001', 'jly', 'jly', '检录考生进站：1011', '2017-06-08 07:53:46');
INSERT INTO `t_sys_log` VALUES ('259', '1003', 'fhy1', 'fhy1', '第一考站考生检录：1011', '2017-06-08 07:54:03');
INSERT INTO `t_sys_log` VALUES ('260', '1003', 'fhy1', 'fhy1', '第一考站考生进入考试：1011', '2017-06-08 07:54:06');
INSERT INTO `t_sys_log` VALUES ('261', '1004', 'dfy1', 'dfy1', '第一考站考生登分出站：1011', '2017-06-08 07:54:32');
INSERT INTO `t_sys_log` VALUES ('262', '1037', 'sfy1', '审分员', '第一考站审核考生成绩：1011', '2017-06-08 07:54:53');
INSERT INTO `t_sys_log` VALUES ('263', '1008', 'fhy2', 'fhy2', '第二考站考生检录：1011', '2017-06-08 07:55:33');
INSERT INTO `t_sys_log` VALUES ('264', '1008', 'fhy2', 'fhy2', '第二考站考生进入考试：1011', '2017-06-08 07:55:35');
INSERT INTO `t_sys_log` VALUES ('265', '1009', 'dfy2', 'dfy2', '第二考站登分出站：1011', '2017-06-08 07:55:53');
INSERT INTO `t_sys_log` VALUES ('266', '1038', 'sfy2', '审分员', '第二考站审核考生成绩：1011', '2017-06-08 07:56:28');
INSERT INTO `t_sys_log` VALUES ('267', '1011', 'fhy3', 'fhy3', '第三考站考生检录：1011', '2017-06-08 07:56:58');
INSERT INTO `t_sys_log` VALUES ('268', '1011', 'fhy3', 'fhy3', '第三考站考生进入考生：1011', '2017-06-08 07:57:00');
INSERT INTO `t_sys_log` VALUES ('269', '1010', 'dfy3', 'dfy3', '第三考站考生登分出站：1011', '2017-06-08 07:57:20');
INSERT INTO `t_sys_log` VALUES ('270', '1039', 'sfy3', '审分员', '第三考站审核考生成绩：1011', '2017-06-08 07:57:49');
INSERT INTO `t_sys_log` VALUES ('271', '1005', 'shy', 'shy', '出口审核1011', '2017-06-08 07:58:17');
INSERT INTO `t_sys_log` VALUES ('272', '1035', 'yjs', '管理员', '导入考生信息', '2017-06-13 17:16:39');
INSERT INTO `t_sys_log` VALUES ('273', '1035', 'yjs', '管理员', '导入考生信息', '2017-06-13 17:59:12');
INSERT INTO `t_sys_log` VALUES ('274', '1034', 'admin', '袁景山', '修改系统参数', '2017-06-14 22:51:05');
INSERT INTO `t_sys_log` VALUES ('275', '1035', 'yjs', '管理员', '导入考生信息', '2017-06-14 23:32:03');
INSERT INTO `t_sys_log` VALUES ('276', '1001', 'jly', 'jly', '检录考生：1081', '2017-06-14 23:32:10');
INSERT INTO `t_sys_log` VALUES ('277', '1001', 'jly', 'jly', '检录考生进站：1081', '2017-06-14 23:32:13');
INSERT INTO `t_sys_log` VALUES ('278', '1003', 'fhy1', 'fhy1', '第一考站考生检录：1081', '2017-06-14 23:33:18');
INSERT INTO `t_sys_log` VALUES ('279', '1003', 'fhy1', 'fhy1', '第一考站考生进入考试：1081', '2017-06-14 23:34:08');
INSERT INTO `t_sys_log` VALUES ('280', '1008', 'fhy2', 'fhy2', '第二考站考生检录：1081', '2017-06-14 23:40:21');
INSERT INTO `t_sys_log` VALUES ('281', '1008', 'fhy2', 'fhy2', '第二考站考生检录：1081', '2017-06-14 23:40:38');
INSERT INTO `t_sys_log` VALUES ('282', '1008', 'fhy2', 'fhy2', '第二考站考生检录：1081', '2017-06-14 23:45:45');
INSERT INTO `t_sys_log` VALUES ('283', '1008', 'fhy2', 'fhy2', '第二考站考生进入考试：1081', '2017-06-14 23:45:59');
INSERT INTO `t_sys_log` VALUES ('284', '1011', 'fhy3', 'fhy3', '第三考站考生检录：1081', '2017-06-14 23:49:34');
INSERT INTO `t_sys_log` VALUES ('285', '1011', 'fhy3', 'fhy3', '第三考站考生检录：1081', '2017-06-14 23:50:03');
INSERT INTO `t_sys_log` VALUES ('286', '1011', 'fhy3', 'fhy3', '第三考站考生进入考生：1081', '2017-06-14 23:50:04');
INSERT INTO `t_sys_log` VALUES ('287', '1005', 'shy', 'shy', '出口审核1081', '2017-06-14 23:51:50');
INSERT INTO `t_sys_log` VALUES ('288', '1005', 'shy', 'shy', '出口审核1081', '2017-06-15 00:00:23');
INSERT INTO `t_sys_log` VALUES ('289', '1005', 'shy', 'shy', '出口审核1081', '2017-06-15 00:02:13');
INSERT INTO `t_sys_log` VALUES ('290', '1035', 'yjs', '管理员', '修改系统参数', '2017-06-15 00:02:41');
INSERT INTO `t_sys_log` VALUES ('291', '1034', 'admin', '袁景山', '初始化系统', '2017-06-15 00:07:06');
INSERT INTO `t_sys_log` VALUES ('292', '1035', 'yjs', '管理员', '修改系统参数', '2017-06-15 16:50:07');
INSERT INTO `t_sys_log` VALUES ('293', '1035', 'yjs', '管理员', '导入考生信息', '2017-06-15 17:35:58');
INSERT INTO `t_sys_log` VALUES ('294', '1035', 'yjs', '管理员', '修改系统参数', '2017-06-15 20:11:29');
INSERT INTO `t_sys_log` VALUES ('295', '1034', 'admin', '袁景山', '登录系统', '2017-06-15 20:17:18');
INSERT INTO `t_sys_log` VALUES ('296', '1035', 'yjs', '管理员', '修改系统参数', '2017-06-15 20:20:29');
INSERT INTO `t_sys_log` VALUES ('297', '1001', 'jly', 'jly', '检录考生：1149', '2017-06-15 20:21:06');
INSERT INTO `t_sys_log` VALUES ('298', '1001', 'jly', 'jly', '检录考生进站：1149', '2017-06-15 20:21:11');
INSERT INTO `t_sys_log` VALUES ('299', '1003', 'fhy1', 'fhy1', '第一考站考生检录：1149', '2017-06-15 20:21:27');
INSERT INTO `t_sys_log` VALUES ('300', '1003', 'fhy1', 'fhy1', '第一考站考生进入考试：1149', '2017-06-15 20:21:28');
INSERT INTO `t_sys_log` VALUES ('301', '1008', 'fhy2', 'fhy2', '第二考站考生检录：1149', '2017-06-15 20:30:22');
INSERT INTO `t_sys_log` VALUES ('302', '1001', 'jly', 'jly', '检录考生：1150', '2017-06-15 20:30:36');
INSERT INTO `t_sys_log` VALUES ('303', '1001', 'jly', 'jly', '检录考生进站：1150', '2017-06-15 20:30:37');
INSERT INTO `t_sys_log` VALUES ('304', '1008', 'fhy2', 'fhy2', '第二考站考生进入考试：1149', '2017-06-15 20:41:39');
INSERT INTO `t_sys_log` VALUES ('305', '1008', 'fhy2', 'fhy2', '第二考站考生检录：1149', '2017-06-15 20:41:59');
INSERT INTO `t_sys_log` VALUES ('306', '1008', 'fhy2', 'fhy2', '第二考站考生检录：1150', '2017-06-15 20:42:22');
INSERT INTO `t_sys_log` VALUES ('307', '1008', 'fhy2', 'fhy2', '第二考站考生进入考试：1150', '2017-06-15 20:42:24');
INSERT INTO `t_sys_log` VALUES ('308', '1011', 'fhy3', 'fhy3', '第三考站考生检录：1149', '2017-06-15 21:00:29');
INSERT INTO `t_sys_log` VALUES ('309', '1011', 'fhy3', 'fhy3', '第三考站考生进入考生：1149', '2017-06-15 21:00:32');
INSERT INTO `t_sys_log` VALUES ('310', '1005', 'shy', 'shy', '出口审核1149', '2017-06-15 21:01:42');
INSERT INTO `t_sys_log` VALUES ('311', '1005', 'shy', 'shy', '出口审核1149', '2017-06-15 21:02:27');
INSERT INTO `t_sys_log` VALUES ('312', '1035', 'yjs', '管理员', '初始化系统', '2017-06-15 21:14:59');
INSERT INTO `t_sys_log` VALUES ('313', '1001', 'jly', 'jly', '检录考生：1151', '2017-06-15 21:34:23');
INSERT INTO `t_sys_log` VALUES ('314', '1035', 'yjs', '管理员', '初始化系统', '2017-06-15 21:40:50');
INSERT INTO `t_sys_log` VALUES ('315', '1035', 'yjs', '管理员', '导入考生信息', '2017-06-15 21:41:13');
INSERT INTO `t_sys_log` VALUES ('316', '1035', 'yjs', '管理员', '初始化系统', '2017-06-15 21:42:56');
INSERT INTO `t_sys_log` VALUES ('317', '1035', 'yjs', '管理员', '导入考生信息', '2017-06-15 21:43:05');
INSERT INTO `t_sys_log` VALUES ('318', '1001', 'jly', 'jly', '检录考生：2144', '2017-06-15 22:06:55');
INSERT INTO `t_sys_log` VALUES ('319', '1001', 'jly', 'jly', '检录考生：3070', '2017-06-15 22:07:08');
INSERT INTO `t_sys_log` VALUES ('320', '1001', 'jly', 'jly', '检录考生进站：2144', '2017-06-15 22:07:12');
INSERT INTO `t_sys_log` VALUES ('321', '1001', 'jly', 'jly', '检录考生进站：3070', '2017-06-15 22:07:23');
INSERT INTO `t_sys_log` VALUES ('322', '1003', 'fhy1', 'fhy1', '第一考站考生检录：3070', '2017-06-15 22:07:45');
INSERT INTO `t_sys_log` VALUES ('323', '1003', 'fhy1', 'fhy1', '第一考站考生检录：2144', '2017-06-15 22:09:34');
INSERT INTO `t_sys_log` VALUES ('324', '1003', 'fhy1', 'fhy1', '第一考站考生进入考试：3070', '2017-06-15 22:09:51');
INSERT INTO `t_sys_log` VALUES ('325', '1003', 'fhy1', 'fhy1', '第一考站考生进入考试：2144', '2017-06-15 22:09:52');
INSERT INTO `t_sys_log` VALUES ('326', '1008', 'fhy2', 'fhy2', '第二考站考生检录：2144', '2017-06-15 22:11:05');
INSERT INTO `t_sys_log` VALUES ('327', '1008', 'fhy2', 'fhy2', '第二考站考生检录：3070', '2017-06-15 22:11:30');
INSERT INTO `t_sys_log` VALUES ('328', '1008', 'fhy2', 'fhy2', '第二考站考生进入考试：3070', '2017-06-15 22:12:03');
INSERT INTO `t_sys_log` VALUES ('329', '1008', 'fhy2', 'fhy2', '第二考站考生进入考试：2144', '2017-06-15 22:12:04');
INSERT INTO `t_sys_log` VALUES ('330', '1011', 'fhy3', 'fhy3', '第三考站考生检录：3070', '2017-06-15 22:12:57');
INSERT INTO `t_sys_log` VALUES ('331', '1011', 'fhy3', 'fhy3', '第三考站考生检录：2144', '2017-06-15 22:13:18');
INSERT INTO `t_sys_log` VALUES ('332', '1011', 'fhy3', 'fhy3', '第三考站考生进入考生：3070', '2017-06-15 22:13:38');
INSERT INTO `t_sys_log` VALUES ('333', '1011', 'fhy3', 'fhy3', '第三考站考生进入考生：2144', '2017-06-15 22:13:38');
INSERT INTO `t_sys_log` VALUES ('334', '1005', 'shy', 'shy', '出口审核2144', '2017-06-15 22:14:55');
INSERT INTO `t_sys_log` VALUES ('335', '1005', 'shy', 'shy', '出口审核3070', '2017-06-15 22:15:28');
INSERT INTO `t_sys_log` VALUES ('336', '1001', 'jly', 'jly', '检录考生：2145', '2017-06-15 22:17:20');

-- ----------------------------
-- View structure for v_doctor_score
-- ----------------------------
DROP VIEW IF EXISTS `v_doctor_score`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_doctor_score` AS select `t2`.`id` AS `id`,`t1`.`name` AS `name`,`t1`.`sex` AS `sex`,`t1`.`nation` AS `nation`,`t1`.`birthday` AS `birthday`,`t1`.`card` AS `card`,`t1`.`ksh` AS `ksh`,`t1`.`exam_type` AS `exam_type`,`t2`.`serial_number` AS `serial_number`,`t2`.`score_1` AS `score_1`,`t2`.`score_2` AS `score_2`,`t2`.`score_3` AS `score_3`,`t2`.`score_count` AS `score_count`,`t2`.`entry_dt` AS `entry_dt`,`t2`.`insert_dt` AS `insert_dt` from (`t_doctor_info` `t1` join `t_doctor_score` `t2`) where (`t1`.`id` = `t2`.`id`) ;

-- ----------------------------
-- View structure for v_error_doctor
-- ----------------------------
DROP VIEW IF EXISTS `v_error_doctor`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_error_doctor` AS select `t1`.`id` AS `id`,`t1`.`name` AS `name`,`t1`.`sex` AS `sex`,`t1`.`nation` AS `nation`,`t1`.`birthday` AS `birthday`,`t1`.`card` AS `card`,`t1`.`ksh` AS `ksh`,`t1`.`exam_type` AS `exam_type` from `t_doctor_info` `t1` where `t1`.`id` in (select `t_inspect`.`id` from `t_inspect` where (not(`t_inspect`.`id` in (select `t_exit_verify`.`id` from `t_exit_verify`)))) ;

-- ----------------------------
-- View structure for v_exit_verify
-- ----------------------------
DROP VIEW IF EXISTS `v_exit_verify`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_exit_verify` AS select `t2`.`id` AS `id`,`t1`.`name` AS `name`,`t1`.`sex` AS `sex`,`t1`.`nation` AS `nation`,`t1`.`birthday` AS `birthday`,`t1`.`card` AS `card`,`t1`.`ksh` AS `ksh`,`t1`.`exam_type` AS `exam_type`,`t2`.`flag` AS `flag`,`t2`.`serial_number` AS `serial_number`,`t2`.`insert_dt` AS `insert_dt` from (`t_doctor_info` `t1` join `t_exit_verify` `t2`) where (`t1`.`id` = `t2`.`id`) ;

-- ----------------------------
-- View structure for v_inspect
-- ----------------------------
DROP VIEW IF EXISTS `v_inspect`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_inspect` AS select `t2`.`id` AS `id`,`t1`.`name` AS `name`,`t1`.`sex` AS `sex`,`t1`.`nation` AS `nation`,`t1`.`birthday` AS `birthday`,`t1`.`card` AS `card`,`t1`.`ksh` AS `ksh`,`t1`.`exam_type` AS `exam_type`,`t2`.`flag` AS `flag`,`t2`.`topic1` AS `topic1`,`t2`.`topic2` AS `topic2`,`t2`.`topic3` AS `topic3`,`t2`.`topic4` AS `topic4`,`t2`.`topic5` AS `topic5`,`t2`.`topic6` AS `topic6`,`t2`.`serial_number` AS `serial_number`,`t2`.`insert_dt` AS `insert_dt` from (`t_doctor_info` `t1` join `t_inspect` `t2`) where (`t1`.`id` = `t2`.`id`) ;

-- ----------------------------
-- View structure for v_station_1
-- ----------------------------
DROP VIEW IF EXISTS `v_station_1`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_station_1` AS select `t2`.`id` AS `id`,`t1`.`name` AS `name`,`t1`.`sex` AS `sex`,`t1`.`nation` AS `nation`,`t1`.`birthday` AS `birthday`,`t1`.`card` AS `card`,`t1`.`ksh` AS `ksh`,`t1`.`exam_type` AS `exam_type`,`t2`.`flag` AS `flag`,`t2`.`topic` AS `topic`,`t2`.`serial_number` AS `serial_number`,`t2`.`exam_group` AS `exam_group`,`t2`.`insert_dt` AS `insert_dt` from (`t_doctor_info` `t1` join `t_station_1` `t2`) where (`t1`.`id` = `t2`.`id`) ;

-- ----------------------------
-- View structure for v_station_1_score
-- ----------------------------
DROP VIEW IF EXISTS `v_station_1_score`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_station_1_score` AS select `t2`.`id` AS `id`,`t1`.`name` AS `name`,`t1`.`sex` AS `sex`,`t1`.`nation` AS `nation`,`t1`.`birthday` AS `birthday`,`t1`.`card` AS `card`,`t1`.`ksh` AS `ksh`,`t1`.`exam_type` AS `exam_type`,`t2`.`topic` AS `topic`,`t2`.`serial_number` AS `serial_number`,`t2`.`score` AS `score`,`t2`.`count_1` AS `count_1`,`t2`.`topic_1_1` AS `topic_1_1`,`t2`.`topic_1_2` AS `topic_1_2`,`t2`.`topic_1_3` AS `topic_1_3`,`t2`.`topic_1_4` AS `topic_1_4`,`t2`.`topic_1_5` AS `topic_1_5`,`t2`.`topic_1_6` AS `topic_1_6`,`t2`.`topic_1_7` AS `topic_1_7`,`t2`.`topic_1_8` AS `topic_1_8`,`t2`.`count_2` AS `count_2`,`t2`.`topic_2_1` AS `topic_2_1`,`t2`.`topic_2_2` AS `topic_2_2`,`t2`.`topic_2_3` AS `topic_2_3`,`t2`.`topic_2_4` AS `topic_2_4`,`t2`.`topic_2_5` AS `topic_2_5`,`t2`.`topic_2_6` AS `topic_2_6`,`t2`.`topic_2_7` AS `topic_2_7`,`t2`.`topic_2_8` AS `topic_2_8`,`t2`.`count_3` AS `count_3`,`t2`.`topic_3_1` AS `topic_3_1`,`t2`.`topic_3_2` AS `topic_3_2`,`t2`.`topic_3_3` AS `topic_3_3`,`t2`.`topic_3_4` AS `topic_3_4`,`t2`.`topic_3_5` AS `topic_3_5`,`t2`.`topic_3_6` AS `topic_3_6`,`t2`.`topic_3_7` AS `topic_3_7`,`t2`.`topic_3_8` AS `topic_3_8`,`t2`.`count_4` AS `count_4`,`t2`.`topic_4_1` AS `topic_4_1`,`t2`.`topic_4_2` AS `topic_4_2`,`t2`.`topic_4_3` AS `topic_4_3`,`t2`.`topic_4_4` AS `topic_4_4`,`t2`.`topic_4_5` AS `topic_4_5`,`t2`.`topic_4_6` AS `topic_4_6`,`t2`.`topic_4_7` AS `topic_4_7`,`t2`.`topic_4_8` AS `topic_4_8`,`t2`.`count_5` AS `count_5`,`t2`.`topic_5_1` AS `topic_5_1`,`t2`.`topic_5_2` AS `topic_5_2`,`t2`.`topic_5_3` AS `topic_5_3`,`t2`.`topic_5_4` AS `topic_5_4`,`t2`.`topic_5_5` AS `topic_5_5`,`t2`.`topic_5_6` AS `topic_5_6`,`t2`.`topic_5_7` AS `topic_5_7`,`t2`.`topic_5_8` AS `topic_5_8`,`t2`.`count_6` AS `count_6`,`t2`.`topic_6_1` AS `topic_6_1`,`t2`.`topic_6_2` AS `topic_6_2`,`t2`.`topic_6_3` AS `topic_6_3`,`t2`.`topic_6_4` AS `topic_6_4`,`t2`.`topic_6_5` AS `topic_6_5`,`t2`.`topic_6_6` AS `topic_6_6`,`t2`.`topic_6_7` AS `topic_6_7`,`t2`.`topic_6_8` AS `topic_6_8`,`t2`.`entry_dt` AS `entry_dt`,`t2`.`insert_dt` AS `insert_dt` from (`t_doctor_info` `t1` join `t_station_1_score` `t2`) where (`t1`.`id` = `t2`.`id`) ;

-- ----------------------------
-- View structure for v_station_2
-- ----------------------------
DROP VIEW IF EXISTS `v_station_2`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_station_2` AS select `t2`.`id` AS `id`,`t1`.`name` AS `name`,`t1`.`sex` AS `sex`,`t1`.`nation` AS `nation`,`t1`.`birthday` AS `birthday`,`t1`.`card` AS `card`,`t1`.`ksh` AS `ksh`,`t1`.`exam_type` AS `exam_type`,`t2`.`flag` AS `flag`,`t2`.`topic` AS `topic`,`t2`.`serial_number` AS `serial_number`,`t2`.`exam_group` AS `exam_group`,`t2`.`insert_dt` AS `insert_dt` from (`t_doctor_info` `t1` join `t_station_2` `t2`) where (`t1`.`id` = `t2`.`id`) ;

-- ----------------------------
-- View structure for v_station_2_score
-- ----------------------------
DROP VIEW IF EXISTS `v_station_2_score`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_station_2_score` AS select `t2`.`id` AS `id`,`t1`.`name` AS `name`,`t1`.`sex` AS `sex`,`t1`.`nation` AS `nation`,`t1`.`birthday` AS `birthday`,`t1`.`card` AS `card`,`t1`.`ksh` AS `ksh`,`t1`.`exam_type` AS `exam_type`,`t2`.`topic` AS `topic`,`t2`.`serial_number` AS `serial_number`,`t2`.`score` AS `score`,`t2`.`count_1` AS `count_1`,`t2`.`topic_1_1` AS `topic_1_1`,`t2`.`topic_1_2` AS `topic_1_2`,`t2`.`topic_1_3` AS `topic_1_3`,`t2`.`topic_1_4` AS `topic_1_4`,`t2`.`topic_1_5` AS `topic_1_5`,`t2`.`topic_1_6` AS `topic_1_6`,`t2`.`topic_1_7` AS `topic_1_7`,`t2`.`topic_1_8` AS `topic_1_8`,`t2`.`count_2` AS `count_2`,`t2`.`topic_2_1` AS `topic_2_1`,`t2`.`topic_2_2` AS `topic_2_2`,`t2`.`topic_2_3` AS `topic_2_3`,`t2`.`topic_2_4` AS `topic_2_4`,`t2`.`topic_2_5` AS `topic_2_5`,`t2`.`topic_2_6` AS `topic_2_6`,`t2`.`topic_2_7` AS `topic_2_7`,`t2`.`topic_2_8` AS `topic_2_8`,`t2`.`count_3` AS `count_3`,`t2`.`topic_3_1` AS `topic_3_1`,`t2`.`topic_3_2` AS `topic_3_2`,`t2`.`topic_3_3` AS `topic_3_3`,`t2`.`topic_3_4` AS `topic_3_4`,`t2`.`topic_3_5` AS `topic_3_5`,`t2`.`topic_3_6` AS `topic_3_6`,`t2`.`topic_3_7` AS `topic_3_7`,`t2`.`topic_3_8` AS `topic_3_8`,`t2`.`count_4` AS `count_4`,`t2`.`topic_4_1` AS `topic_4_1`,`t2`.`topic_4_2` AS `topic_4_2`,`t2`.`topic_4_3` AS `topic_4_3`,`t2`.`topic_4_4` AS `topic_4_4`,`t2`.`topic_4_5` AS `topic_4_5`,`t2`.`topic_4_6` AS `topic_4_6`,`t2`.`topic_4_7` AS `topic_4_7`,`t2`.`topic_4_8` AS `topic_4_8`,`t2`.`count_5` AS `count_5`,`t2`.`topic_5_1` AS `topic_5_1`,`t2`.`topic_5_2` AS `topic_5_2`,`t2`.`topic_5_3` AS `topic_5_3`,`t2`.`topic_5_4` AS `topic_5_4`,`t2`.`topic_5_5` AS `topic_5_5`,`t2`.`topic_5_6` AS `topic_5_6`,`t2`.`topic_5_7` AS `topic_5_7`,`t2`.`topic_5_8` AS `topic_5_8`,`t2`.`count_6` AS `count_6`,`t2`.`topic_6_1` AS `topic_6_1`,`t2`.`topic_6_2` AS `topic_6_2`,`t2`.`topic_6_3` AS `topic_6_3`,`t2`.`topic_6_4` AS `topic_6_4`,`t2`.`topic_6_5` AS `topic_6_5`,`t2`.`topic_6_6` AS `topic_6_6`,`t2`.`topic_6_7` AS `topic_6_7`,`t2`.`topic_6_8` AS `topic_6_8`,`t2`.`entry_dt` AS `entry_dt`,`t2`.`insert_dt` AS `insert_dt` from (`t_doctor_info` `t1` join `t_station_2_score` `t2` on((`t1`.`id` = `t2`.`id`))) ;

-- ----------------------------
-- View structure for v_station_3
-- ----------------------------
DROP VIEW IF EXISTS `v_station_3`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_station_3` AS select `t2`.`id` AS `id`,`t1`.`name` AS `name`,`t1`.`sex` AS `sex`,`t1`.`nation` AS `nation`,`t1`.`birthday` AS `birthday`,`t1`.`card` AS `card`,`t1`.`ksh` AS `ksh`,`t1`.`exam_type` AS `exam_type`,`t2`.`flag` AS `flag`,`t2`.`topic` AS `topic`,`t2`.`serial_number` AS `serial_number`,`t2`.`exam_group` AS `exam_group`,`t2`.`insert_dt` AS `insert_dt` from (`t_doctor_info` `t1` join `t_station_3` `t2`) where (`t1`.`id` = `t2`.`id`) ;

-- ----------------------------
-- View structure for v_station_3_score
-- ----------------------------
DROP VIEW IF EXISTS `v_station_3_score`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_station_3_score` AS select `t2`.`id` AS `id`,`t1`.`name` AS `name`,`t1`.`sex` AS `sex`,`t1`.`nation` AS `nation`,`t1`.`birthday` AS `birthday`,`t1`.`card` AS `card`,`t1`.`ksh` AS `ksh`,`t1`.`exam_type` AS `exam_type`,`t2`.`topic` AS `topic`,`t2`.`serial_number` AS `serial_number`,`t2`.`score` AS `score`,`t2`.`count_1` AS `count_1`,`t2`.`topic_1_1` AS `topic_1_1`,`t2`.`topic_1_2` AS `topic_1_2`,`t2`.`topic_1_3` AS `topic_1_3`,`t2`.`topic_1_4` AS `topic_1_4`,`t2`.`topic_1_5` AS `topic_1_5`,`t2`.`topic_1_6` AS `topic_1_6`,`t2`.`topic_1_7` AS `topic_1_7`,`t2`.`topic_1_8` AS `topic_1_8`,`t2`.`count_2` AS `count_2`,`t2`.`topic_2_1` AS `topic_2_1`,`t2`.`topic_2_2` AS `topic_2_2`,`t2`.`topic_2_3` AS `topic_2_3`,`t2`.`topic_2_4` AS `topic_2_4`,`t2`.`topic_2_5` AS `topic_2_5`,`t2`.`topic_2_6` AS `topic_2_6`,`t2`.`topic_2_7` AS `topic_2_7`,`t2`.`topic_2_8` AS `topic_2_8`,`t2`.`count_3` AS `count_3`,`t2`.`topic_3_1` AS `topic_3_1`,`t2`.`topic_3_2` AS `topic_3_2`,`t2`.`topic_3_3` AS `topic_3_3`,`t2`.`topic_3_4` AS `topic_3_4`,`t2`.`topic_3_5` AS `topic_3_5`,`t2`.`topic_3_6` AS `topic_3_6`,`t2`.`topic_3_7` AS `topic_3_7`,`t2`.`topic_3_8` AS `topic_3_8`,`t2`.`count_4` AS `count_4`,`t2`.`topic_4_1` AS `topic_4_1`,`t2`.`topic_4_2` AS `topic_4_2`,`t2`.`topic_4_3` AS `topic_4_3`,`t2`.`topic_4_4` AS `topic_4_4`,`t2`.`topic_4_5` AS `topic_4_5`,`t2`.`topic_4_6` AS `topic_4_6`,`t2`.`topic_4_7` AS `topic_4_7`,`t2`.`topic_4_8` AS `topic_4_8`,`t2`.`count_5` AS `count_5`,`t2`.`topic_5_1` AS `topic_5_1`,`t2`.`topic_5_2` AS `topic_5_2`,`t2`.`topic_5_3` AS `topic_5_3`,`t2`.`topic_5_4` AS `topic_5_4`,`t2`.`topic_5_5` AS `topic_5_5`,`t2`.`topic_5_6` AS `topic_5_6`,`t2`.`topic_5_7` AS `topic_5_7`,`t2`.`topic_5_8` AS `topic_5_8`,`t2`.`count_6` AS `count_6`,`t2`.`topic_6_1` AS `topic_6_1`,`t2`.`topic_6_2` AS `topic_6_2`,`t2`.`topic_6_3` AS `topic_6_3`,`t2`.`topic_6_4` AS `topic_6_4`,`t2`.`topic_6_5` AS `topic_6_5`,`t2`.`topic_6_6` AS `topic_6_6`,`t2`.`topic_6_7` AS `topic_6_7`,`t2`.`topic_6_8` AS `topic_6_8`,`t2`.`entry_dt` AS `entry_dt`,`t2`.`insert_dt` AS `insert_dt` from (`t_doctor_info` `t1` join `t_station_3_score` `t2`) where (`t1`.`id` = `t2`.`id`) ;

-- ----------------------------
-- View structure for v_station_info
-- ----------------------------
DROP VIEW IF EXISTS `v_station_info`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_station_info` AS select `t2`.`id` AS `id`,`t1`.`name` AS `name`,`t1`.`sex` AS `sex`,`t1`.`nation` AS `nation`,`t1`.`birthday` AS `birthday`,`t1`.`card` AS `card`,`t1`.`ksh` AS `ksh`,`t1`.`exam_type` AS `exam_type`,`t2`.`flag` AS `flag`,`t2`.`topic` AS `topic`,`t2`.`serial_number` AS `serial_number`,`t2`.`exam_group` AS `exam_group`,`t2`.`station` AS `station`,`t2`.`insert_dt` AS `insert_dt` from (`t_station_info` `t2` left join `t_doctor_info` `t1` on((`t2`.`id` = `t1`.`id`))) ;

-- ----------------------------
-- View structure for v_station_score
-- ----------------------------
DROP VIEW IF EXISTS `v_station_score`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_station_score` AS select `t2`.`id` AS `id`,`t1`.`name` AS `name`,`t1`.`sex` AS `sex`,`t1`.`nation` AS `nation`,`t1`.`birthday` AS `birthday`,`t1`.`card` AS `card`,`t1`.`ksh` AS `ksh`,`t1`.`exam_type` AS `exam_type`,`t2`.`topic` AS `topic`,`t2`.`serial_number` AS `serial_number`,`t2`.`score` AS `score`,`t2`.`count_1` AS `count_1`,`t2`.`topic_1_1` AS `topic_1_1`,`t2`.`topic_1_2` AS `topic_1_2`,`t2`.`topic_1_3` AS `topic_1_3`,`t2`.`topic_1_4` AS `topic_1_4`,`t2`.`topic_1_5` AS `topic_1_5`,`t2`.`topic_1_6` AS `topic_1_6`,`t2`.`topic_1_7` AS `topic_1_7`,`t2`.`topic_1_8` AS `topic_1_8`,`t2`.`count_2` AS `count_2`,`t2`.`topic_2_1` AS `topic_2_1`,`t2`.`topic_2_2` AS `topic_2_2`,`t2`.`topic_2_3` AS `topic_2_3`,`t2`.`topic_2_4` AS `topic_2_4`,`t2`.`topic_2_5` AS `topic_2_5`,`t2`.`topic_2_6` AS `topic_2_6`,`t2`.`topic_2_7` AS `topic_2_7`,`t2`.`topic_2_8` AS `topic_2_8`,`t2`.`count_3` AS `count_3`,`t2`.`topic_3_1` AS `topic_3_1`,`t2`.`topic_3_2` AS `topic_3_2`,`t2`.`topic_3_3` AS `topic_3_3`,`t2`.`topic_3_4` AS `topic_3_4`,`t2`.`topic_3_5` AS `topic_3_5`,`t2`.`topic_3_6` AS `topic_3_6`,`t2`.`topic_3_7` AS `topic_3_7`,`t2`.`topic_3_8` AS `topic_3_8`,`t2`.`count_4` AS `count_4`,`t2`.`topic_4_1` AS `topic_4_1`,`t2`.`topic_4_2` AS `topic_4_2`,`t2`.`topic_4_3` AS `topic_4_3`,`t2`.`topic_4_4` AS `topic_4_4`,`t2`.`topic_4_5` AS `topic_4_5`,`t2`.`topic_4_6` AS `topic_4_6`,`t2`.`topic_4_7` AS `topic_4_7`,`t2`.`topic_4_8` AS `topic_4_8`,`t2`.`count_5` AS `count_5`,`t2`.`topic_5_1` AS `topic_5_1`,`t2`.`topic_5_2` AS `topic_5_2`,`t2`.`topic_5_3` AS `topic_5_3`,`t2`.`topic_5_4` AS `topic_5_4`,`t2`.`topic_5_5` AS `topic_5_5`,`t2`.`topic_5_6` AS `topic_5_6`,`t2`.`topic_5_7` AS `topic_5_7`,`t2`.`topic_5_8` AS `topic_5_8`,`t2`.`count_6` AS `count_6`,`t2`.`topic_6_1` AS `topic_6_1`,`t2`.`topic_6_2` AS `topic_6_2`,`t2`.`topic_6_3` AS `topic_6_3`,`t2`.`topic_6_4` AS `topic_6_4`,`t2`.`topic_6_5` AS `topic_6_5`,`t2`.`topic_6_6` AS `topic_6_6`,`t2`.`topic_6_7` AS `topic_6_7`,`t2`.`topic_6_8` AS `topic_6_8`,`t2`.`entry_dt` AS `entry_dt`,`t2`.`insert_dt` AS `insert_dt`,`t2`.`station` AS `station` from (`t_doctor_info` `t1` join `t_station_score` `t2` on((`t1`.`id` = `t2`.`id`))) ;

-- ----------------------------
-- Procedure structure for pr_error_doctor_score
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_error_doctor_score`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_error_doctor_score`(out p_result int,
	p_user_id int)
proc_start:begin 
/*
* 描述：给异常考生添加成绩，成功返回0， 考生不存在返回-101；
*/
	declare $topic varchar(5);
	declare $score_1 float;
	declare $score_2 float;
	declare $score_3 float;
	declare $entry_dt datetime;
	declare $score_count float;

	set p_result = 0;

	if exists (select 1 from t_inspect where id=p_user_id)
	then
		select topic into $topic from t_inspect where id=p_user_id;
		if not exists (select 1 from t_station_1_score where id=p_user_id)
		then 
		insert into t_station_1_score values(p_user_id,topic,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,now(),now());
		end if;

		if not exists (select 1 from t_station_1_score where id=p_user_id)
		then 
		insert into t_station_2_score values(p_user_id,topic,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,now(),now());
		end if;

		if not exists (select 1 from t_station_1_score where id=p_user_id)
		then 
		insert into t_station_3_score values(p_user_id,topic,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,now(),now());
		end if;
		
		select insert_dt into $entry_dt from t_inspect where id=p_user_id;
		select score into $score_1 from t_station_1_score where id=p_user_id;
		select score into $score_2 from t_station_2_score where id=p_user_id;
		select score into $score_3 from t_station_3_score where id=p_user_id;
		set $score_count = $score_1 + $score_2 + $score_3;
		insert into t_doctor_score values(p_user_id,$topic,$score_1,$score_2,$score_3,$score_count,$entry_dt,now());
	else
		set p_result = -101; 
	end if;

	leave proc_start;

/*
test code
call pr_error_doctor_score(@ret,1);
select @ret;
*/
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for pr_exam_score_update
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_exam_score_update`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_exam_score_update`(out p_result int,
	p_user_id int)
proc_start:begin 
/*
* 描述：更新考试成绩，考生信息不存在返回-101，成功返回1
*/
	declare $score_1 float;
	declare $score_2 float;
	declare $score_3 float;
  declare $score_4 float;
  declare $score_5 float;
  declare $score_6 float;

	declare $score_count float;

	set p_result = 1;

	if exists (select 1 from t_doctor_score where id=p_user_id)
	then		
		select score into $score_1 from t_station_1_score where id=p_user_id;
		select score into $score_2 from t_station_2_score where id=p_user_id;
		select score into $score_3 from t_station_3_score where id=p_user_id;
		
		select score into $score_4 from t_station_score where id=p_user_id and station=4;
		select score into $score_5 from t_station_score where id=p_user_id and station=5;
		select score into $score_6 from t_station_score where id=p_user_id and station=6;
		set $score_count = $score_1 + $score_2 + $score_3 + $score_4 + $score_5 + $score_6;
		if $score_count > 100
		then
			set p_result = -101;
    else
			update t_doctor_score set score_1=$score_1,score_2=$score_2,score_3=$score_3,score_count=$score_count where id=p_user_id;
    end if;
		-- modify by yjs at 2016-07-01 end
	end if;

	leave proc_start;

/*
test code
call pr_exam_score_update(@ret,1);
select @ret;
*/
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for pr_exit_inspect
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_exit_inspect`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_exit_inspect`(out p_result int,
	p_user_id int)
proc_start:begin 
/*
* 描述：出口检录，考生信息不存在返回-101，已检录-102，成功返回0
*/
	set p_result=0;

	if exists (select 1 from t_exit_verify where id=p_user_id)
	then
		set p_result = -102; 
	else
		if exists(select 1 from t_inspect where id=p_user_id)
		then
			insert into t_exit_verify
			select 
				ti.id,
				0,
				ti.topic,
				now()
			from 
				t_inspect ti 
			where ti.id=p_user_id;
		else 
			set p_result = -101;
		end if;
	end if;

	-- modified by yjs at 2016-06-25 end

	leave proc_start;
	
/*
test code
call pr_exit_inspect(@ret,1);
select @ret;
*/
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for pr_exit_verify
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_exit_verify`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_exit_verify`(out p_result int, out p_result_1 int,
 out p_result_2 int, out p_result_3 int, out p_result_4 int, out p_result_5 int, out p_result_6 int, p_user_id int)
proc_start:begin 
/*
* 描述：出口审核
* 1）全部通过返回0及各站考生情况；
* 2）未完成返回1及各站考生情况；
* 3）分数之和大于100返回2及各站考生情况
*/
	declare $serial_number varchar(5);
	declare $score_1 float;
	declare $score_2 float;
	declare $score_3 float;
	declare $score_4 float;
	declare $score_5 float;
	declare $score_6 float;
  declare $entry_dt datetime;
	declare $score_count float;

	set p_result = 1;

	select flag into p_result_1 from t_station_1 where id=p_user_id;
	select flag into p_result_2 from t_station_2 where id=p_user_id;
	select flag into p_result_3 from t_station_3 where id=p_user_id;
	select flag into p_result_4 from t_station_info where id=p_user_id and station=4;
	select flag into p_result_5 from t_station_info where id=p_user_id and station=5;
	select flag into p_result_6 from t_station_info where id=p_user_id and station=6;

	if not exists (select 1 from t_exit_verify where id=p_user_id)
	then
		-- 插入数据
		insert into t_exit_verify
		select 
			ti.id,
			0,
			ti.serial_number,
			now()
		from 
			t_inspect ti 
		where ti.id=p_user_id;
  end if;

  if p_result_1 = 3 and p_result_2 = 3 and p_result_3 = 3 and p_result_4 = 3 and p_result_5 = 3 and p_result_6 = 3 
	then
		set p_result = 0;
		select insert_dt, serial_number into $entry_dt, $serial_number from t_inspect where id=p_user_id;
		select score into $score_1 from t_station_1_score where id=p_user_id;
		select score into $score_2 from t_station_2_score where id=p_user_id;
		select score into $score_3 from t_station_3_score where id=p_user_id;
		select score into $score_4 from t_station_score where id=p_user_id and station=4;
		select score into $score_5 from t_station_score where id=p_user_id and station=5;
		select score into $score_6 from t_station_score where id=p_user_id and station=6;
		set $score_count = $score_1 + $score_2 + $score_3 + $score_4 + $score_5 + $score_6;
		if $score_count > 100
		then
			set p_result = 2;
		else
			insert into t_doctor_score values(p_user_id, $serial_number, $score_1, $score_2, $score_3, $score_4, $score_5, $score_6, $score_count, date_format($entry_dt,'%y-%m-%d %H:%i:%s'),now());
			update t_exit_verify set flag=1 where id=p_user_id;
		end if;
	end if;

/*
	declare $flag_1 tinyint;
	declare $flag_2 tinyint;
	declare $flag_3 tinyint;
	declare $topic varchar(5);
	declare $score_1 float;
	declare $score_2 float;
	declare $score_3 float;
  declare $entry_dt datetime;
	declare $score_count float;

	set p_result = 0;

	if not exists (select 1 from t_exit_verify where id=p_user_id)
		then 
			if exists(select 1 from t_inspect where id=p_user_id)
			then
				insert into t_exit_verify
				select 
					ti.id,
					0,
					ti.serial_number,
					now()
				from 
					t_inspect ti 
				where ti.id=p_user_id;
			else 
				set p_result = -101;
				leave proc_start;
			end if;
	end if;

	-- 校验
	select flag, serial_number into $flag_1,$topic from t_station_1 where id=p_user_id;
	select flag into $flag_2 from t_station_2 where id=p_user_id;
	select flag into $flag_3 from t_station_3 where id=p_user_id;
	if $flag_1 is null or $flag_1 !=2
		then 
			if $flag_2=2
				then 
					if $flag_3=2
						then
							set p_result = -102; -- 一站未完，二站考完， 三站考完
					else
						set p_result = -103; -- 一站未完， 二站考完，三站未完
					end if;
			else
				if $flag_3=2
					then
						set p_result = -104; -- 一站未完，二站未完， 三站考完
				else
					set p_result = -105; -- 一站未完， 二站未完，三站未完
				end if;
			end if;
		else
			if $flag_2=2
				then 
					if $flag_3=2
						then
							update t_exit_verify set flag=2 where id=p_user_id;
							select insert_dt into $entry_dt from t_inspect where id=p_user_id;
							select score into $score_1 from t_station_1_score where id=p_user_id;
							select score into $score_2 from t_station_2_score where id=p_user_id;
							select score into $score_3 from t_station_3_score where id=p_user_id;
							set $score_count = $score_1 + $score_2 + $score_3;
							-- modified by yjs at 2016-07-01 begin
							if $score_count > 100
								then
									set p_result = -109;
								else
									insert into t_doctor_score values(p_user_id,$topic,$score_1,$score_2,$score_3,$score_count,date_format($entry_dt,'%y-%m-%d %H:%i:%s'),now());
								end if;
							-- modified by yjs at 2016-07-01 end
					else
						set p_result = -106; -- 一站考完， 二站考完，三站未完
					end if;
			else
				if $flag_3=2
					then
						set p_result = -107; -- 一站考完，二站未完， 三站考完
				else
					set p_result = -108; -- 一站考完， 二站未完，三站未完
				end if;
			end if;
	end if;*/


	leave proc_start;

/*
test code
call pr_exit_verify(@ret,1);
select @ret;
*/
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for pr_station1_exit
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_station1_exit`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_station1_exit`(out p_result int,
	p_user_id int)
proc_start:begin 
/*
* 描述：第一站出站，更新标志
* 1）考生信息不存在:-101
* 2）考试未完成：-102
* 3）已审核:-103
* 4）成功返回0
*/
	-- declare $topic varchar(5);
	declare $flag tinyint;
	set p_result = 0;

  -- modified by yjs at 2016-06-25 begin
	/*if exists (select 1 from t_station_1 where id=p_user_id)
	then 
		select flag,topic into $flag,$topic from t_station_1 where id=p_user_id;
		if $flag = 2
		then 
			update t_station_1 set flag = 3 where id=p_user_id;
			insert into t_station_2 values(p_user_id, 0, $topic, '', now());
		elseif $flag = 3 then
			set p_result = -103;
		else 
			set p_result = -102;
		end if;
	else
		set p_result = -101;
	end if;*/

	if exists (select 1 from t_station_1 where id=p_user_id)
	then 
		select flag into $flag from t_station_1 where id=p_user_id;
		if $flag = 2
		then 
			update t_station_1 set flag = 3 where id=p_user_id;
		elseif $flag = 3 then
			set p_result = -103;
		else 
			set p_result = -102;
		end if;
	else
		set p_result = -101;
	end if;
	-- modified by yjs at 2016-06-25 end

	leave proc_start;

/*
test code
call pr_station1_exit(@ret,1);
select @ret;
*/
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for pr_station1_inspect
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_station1_inspect`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_station1_inspect`(out p_result int,
	p_user_id int)
proc_start:begin 
/*
* 描述：第一站入口检录，考生信息未检录返回-101，已检录-102，其他考站检录未完成-103，成功返回0
*/
	declare $flag tinyint;
  declare $inspect_flag tinyint;
	set p_result=0;
	
  -- 首先判断是否检录，已允许进站
	if exists (select 1 from t_inspect where id=p_user_id)
  then
		select flag into $inspect_flag from t_inspect where id=p_user_id;
    if $inspect_flag = 0
			then 
				set p_result = -101;
        leave proc_start;
		end if;
	else
		set p_result = -101; 
		leave proc_start;
  end if;

	-- 先判断是否在其他考站检录，并考试结束，未结束的话返回-103
	if exists (select 1 from t_station_2 where id=p_user_id)
  then
		select flag into $flag from t_station_2 where id=p_user_id;
		if $flag !=3
			then
				set p_result = -103;
				leave proc_start;
    end if;
	end if;

	if exists (select 1 from t_station_3 where id=p_user_id)
  then
		select flag into $flag from t_station_3 where id=p_user_id;
		if $flag !=3
			then
				set p_result = -103;
				leave proc_start;
    end if;
	end if;

	-- 判断当前考站
	if exists (select 1 from t_station_1 where id=p_user_id)
	then
		set p_result = -102; 
	else
		if exists(select 1 from t_inspect where id=p_user_id)
		then
			insert into t_station_1
			select 
				ti.id,
				0,
				ti.topic1,
				ti.serial_number,
				'',
				now()
			from 
				t_inspect ti 
			where ti.id=p_user_id;
			update t_inspect set flag=2 where id=p_user_id;
		else 
			set p_result = -101;
		end if;
	end if;

	-- modified by yjs at 2016-06-25 end

	leave proc_start;
	
/*
test code
call pr_station1_inspect(@ret,1);
select @ret;
*/
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for pr_station2_exit
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_station2_exit`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_station2_exit`(out p_result int,
	p_user_id int)
proc_start:begin 
/*
* 描述：第二站出站，更新标志
* 1）未检录:-101
* 2）未考试：-102
* 3）已出站:-103
* 4）成功返回0
*/
	-- declare $topic varchar(5);
	declare $flag tinyint;
	set p_result = 0;

  -- modified by yjs at 2016-06-25 begin
	/*if exists (select 1 from t_station_2 where id=p_user_id)
	then 
		select flag,topic into $flag,$topic from t_station_2 where id=p_user_id;
		if $flag = 2
		then 
			update t_station_2 set flag = 3 where id=p_user_id;
			insert into t_station_3 values(p_user_id, 0, $topic, '', now());
		elseif $flag = 3 then
			set p_result = -103;
		else 
			set p_result = -102;
		end if;
	else
		set p_result = -101;
	end if;*/

	if exists (select 1 from t_station_2 where id=p_user_id)
	then 
		select flag into $flag from t_station_2 where id=p_user_id;
		if $flag = 2
		then 
			update t_station_2 set flag = 3 where id=p_user_id;
		elseif $flag = 3 then
			set p_result = -103;
		else 
			set p_result = -102;
		end if;
	else
		set p_result = -101;
	end if;
	-- modified by yjs at 2016-06-25 end

	leave proc_start;

/*
test code
call pr_station2_exit(@ret,1);
select @ret;
*/
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for pr_station2_inspect
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_station2_inspect`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_station2_inspect`(out p_result int,
	p_user_id int)
proc_start:begin 
/*
* 描述：第一站入口检录，考生信息未检录返回-101，已检录-102，其他考站检录未完成-103，成功返回0
*/
	declare $flag tinyint;
	declare $inspect_flag tinyint;
	set p_result=0;

	if exists (select 1 from t_inspect where id=p_user_id)
  then
		select flag into $inspect_flag from t_inspect where id=p_user_id;
    if $inspect_flag = 0
			then 
				set p_result = -101;
        leave proc_start;
		end if;
	else
		set p_result = -101; 
		leave proc_start;
  end if;

	-- 先判断是否在其他考站检录，并考试结束，未结束的话返回-103
	if exists (select 1 from t_station_1 where id=p_user_id)
  then
		select flag into $flag from t_station_1 where id=p_user_id;
		if $flag !=3
			then
				set p_result = -103;
				leave proc_start;
    end if;
	end if;

	if exists (select 1 from t_station_3 where id=p_user_id)
  then
		select flag into $flag from t_station_3 where id=p_user_id;
		if $flag !=3
			then
				set p_result = -103;
				leave proc_start;
    end if;
	end if;

	-- 判断当前考站
	if exists (select 1 from t_station_2 where id=p_user_id)
	then
		set p_result = -102; 
	else
		if exists(select 1 from t_inspect where id=p_user_id)
		then
			insert into t_station_2
			select 
				ti.id,
				0,
				ti.topic2,
				ti.serial_number,
				'',
				now()
			from 
				t_inspect ti 
			where ti.id=p_user_id;
      update t_inspect set flag=2 where id=p_user_id;
		else 
			set p_result = -101;
		end if;
	end if;

	-- modified by yjs at 2016-06-25 end

	leave proc_start;
	
/*
test code
call pr_station1_inspect(@ret,1);
select @ret;
*/
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for pr_station3_exit
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_station3_exit`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_station3_exit`(out p_result int,
	p_user_id int)
proc_start:begin 
/*
* 描述：第三站出站，更新标志
* 1）未检录:-101
* 2）未考试：-102
* 3）已出站:-103
* 4）成功返回0
*/
	-- declare $topic varchar(5);
	declare $flag tinyint;
	set p_result = 0;

  -- modified by yjs at 2016-06-25 begin
	/*if exists (select 1 from t_station_3 where id=p_user_id)
	then 
		select flag,topic into $flag,$topic from t_station_3 where id=p_user_id;
		if $flag = 2
		then 
			update t_station_3 set flag = 3 where id=p_user_id;
			insert into t_exit_verify values(p_user_id, 0, $topic, now());
		elseif $flag = 3 then
			set p_result = -103;
		else 
			set p_result = -102;
		end if;
	else
		set p_result = -101;
	end if;*/

	if exists (select 1 from t_station_3 where id=p_user_id)
	then 
		select flag into $flag from t_station_3 where id=p_user_id;
		if $flag = 2
		then 
			update t_station_3 set flag = 3 where id=p_user_id;
		elseif $flag = 3 then
			set p_result = -103;
		else 
			set p_result = -102;
		end if;
	else
		set p_result = -101;
	end if;
	-- modified by yjs at 2016-06-25 end

	leave proc_start;

/*
test code
call pr_station3_exit(@ret,1);
select @ret;
*/
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for pr_station3_inspect
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_station3_inspect`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_station3_inspect`(out p_result int,
	p_user_id int)
proc_start:begin 
/*
* 描述：第三站入口检录，考生信息未检录返回-101，已检录-102，其他考站检录未完成-103，成功返回0
*/
	declare $flag tinyint;
  declare $inspect_flag tinyint;
	set p_result=0;

	if exists (select 1 from t_inspect where id=p_user_id)
  then
		select flag into $inspect_flag from t_inspect where id=p_user_id;
    if $inspect_flag = 0
			then 
				set p_result = -101;
        leave proc_start;
		end if;
	else
		set p_result = -101; 
		leave proc_start;
  end if;

	-- 先判断是否在其他考站检录，并考试结束，未结束的话返回-103
	if exists (select 1 from t_station_1 where id=p_user_id)
  then
		select flag into $flag from t_station_1 where id=p_user_id;
		if $flag !=3
			then
				set p_result = -103;
				leave proc_start;
    end if;
	end if;

	if exists (select 1 from t_station_2 where id=p_user_id)
  then
		select flag into $flag from t_station_2 where id=p_user_id;
		if $flag !=3
			then
				set p_result = -103;
				leave proc_start;
    end if;
	end if;

	-- 判断当前考站
	if exists (select 1 from t_station_3 where id=p_user_id)
	then
		set p_result = -102; 
	else
		if exists(select 1 from t_inspect where id=p_user_id)
		then
			insert into t_station_3
			select 
				ti.id,
				0,
				ti.topic3,
        ti.serial_number,
				'',
				now()
			from 
				t_inspect ti 
			where ti.id=p_user_id;
			update t_inspect set flag=2 where id=p_user_id;
		else 
			set p_result = -101;
		end if;
	end if;

	leave proc_start;
	
/*
test code
call pr_station3_inspect(@ret,1);
select @ret;
*/
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for pr_station_exit
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_station_exit`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_station_exit`(out p_result int, p_user_id int, p_station int)
proc_start:begin 
	/*
	* 描述：出站，更新标志，
	* 1)成功返回0
	* 2)考站未检录:-101
	* 3)考站未考试：-102
	* 4)考站已出站:-103
	*/

	declare $flag tinyint;
	set p_result = 0;

	if exists (select 1 from t_station_info where id=p_user_id and station=p_station)
	then 
		select flag into $flag from t_station_info where id=p_user_id and station=p_station;
		if $flag = 2
		then 
			update t_station_info set flag = 3 where id=p_user_id and station=p_station;
		elseif $flag = 3 then
			set p_result = -103;
		else 
			set p_result = -102;
		end if;
	else
		set p_result = -101;
	end if;

	leave proc_start;

/*
test code
call pr_station_exit(@ret, 1, 4);
select @ret;
*/
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for pr_station_inspect
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_station_inspect`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_station_inspect`(out p_result int, p_user_id int, p_station int)
proc_start:begin 
/*
* 描述：考站检录
* 1）入口未检录返回-101
* 2）当前考站已检录返回-102
* 3）其他考站已检录，但是未完成考试返回-103
* 4）其他错误返回-104
* 5）成功返回0
*/
	declare $flag tinyint;
	declare $inspect_flag tinyint;
  declare $other_station varchar(100);
	set p_result=0;

	if exists (select 1 from t_inspect where id=p_user_id)
  then
		select flag into $inspect_flag from t_inspect where id=p_user_id;
    if $inspect_flag = 0
			then 
				set p_result = -101;
        leave proc_start;
		end if;
	else
		set p_result = -101;
		leave proc_start;
  end if;


	-- 先判断是否在其他考站检录，并考试结束，未结束的话返回-103
	if exists (select 1 from t_station_1 where id=p_user_id)
  then
		select flag into $flag from t_station_1 where id=p_user_id;
		if $flag !=3
			then
				set p_result = -103;
				leave proc_start;
    end if;
	end if;

	if exists (select 1 from t_station_2 where id=p_user_id)
  then
		select flag into $flag from t_station_2 where id=p_user_id;
		if $flag !=3
			then
				set p_result = -103;
				leave proc_start;
    end if;
	end if;

	if exists (select 1 from t_station_3 where id=p_user_id)
  then
		select flag into $flag from t_station_3 where id=p_user_id;
		if $flag !=3
			then
				set p_result = -103;
				leave proc_start;
    end if;
	end if;

  if p_station=4 
		then 
			if exists (select 1 from t_station_info where id=p_user_id and flag!=3 and (station in (5, 6)))
			then
				set p_result = -103;
				leave proc_start;
			end if;
	elseif p_station=5 
		then 
			if exists (select 1 from t_station_info where id=p_user_id and flag!=3 and (station in (4, 6)))
			then
				set p_result = -103;
				leave proc_start;
			end if;
  elseif p_station=6 
		then 
			if exists (select 1 from t_station_info where id=p_user_id and flag!=3 and (station in (4, 5)))
			then
				set p_result = -103;
				leave proc_start;
			end if;
	else 
		set p_result = -104; -- 其他错误
		leave proc_start;
	end if;

	-- 判断当前考站
	if exists (select 1 from t_station_info where id=p_user_id and station=p_station)
	then
		set p_result = -102; -- 该考生当前考站已检录
		leave proc_start;
	else
			if p_station=4
				then
					insert into t_station_info select ti.id, 0, ti.topic4, ti.serial_number, '', p_station, now() from t_inspect ti where ti.id=p_user_id;
			elseif p_station=5
				then 
					insert into t_station_info select ti.id, 0, ti.topic5, ti.serial_number, '', p_station, now() from t_inspect ti where ti.id=p_user_id;
			elseif p_station=6
				then 
					insert into t_station_info select ti.id, 0, ti.topic6, ti.serial_number, '', p_station, now() from t_inspect ti where ti.id=p_user_id;
      end if;
			update t_inspect set flag=2 where id=p_user_id;
	end if;
 
	leave proc_start;
	
/*
test code
call pr_station_inspect(@ret,1);
select @ret;
*/
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for pr_sys_clear
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_sys_clear`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_sys_clear`(out p_result int)
proc_start:begin 
/*
* 描述：系统数据初始化，清除相应表的相应数据
*/
	set p_result = 1;
	
	-- 清除考生信息
	delete from t_doctor_info;
	-- 清除检录数据
	delete from t_inspect;
	-- 清除第一考站数据
	delete from t_station_1;
	delete from t_station_1_score;
	-- 清除第二考站数据
	delete from t_station_2;
	delete from t_station_2_score;
	-- 清除第三考站数据
	delete from t_station_3;
	delete from t_station_3_score;
	-- 清除审核数据
	delete from t_exit_verify;
	delete from t_doctor_score;
  
	leave proc_start;

/*
test code
call pr_sys_clear(@ret);
select @ret;
*/
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for pr_sys_init
-- ----------------------------
DROP PROCEDURE IF EXISTS `pr_sys_init`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pr_sys_init`(out p_result int)
proc_start:begin 
/*
* 描述：系统数据初始化，清除相应表的相应数据
*/
	set p_result = 1;
	
	-- 清除检录数据
	delete from t_inspect;
	-- 清除第一考站数据
	delete from t_station_1;
	-- delete from t_station_1_score;
	-- 清除第二考站数据
	delete from t_station_2;
	-- delete from t_station_2_score;
	-- 清除第三考站数据
	delete from t_station_3;
	-- delete from t_station_3_score;
	
	-- 清除第4、5、6考站的数据
	delete from t_station_info;
  -- delete from t_station_score;

	-- 清除审核数据
	delete from t_exit_verify;
	-- delete from t_doctor_score;

	leave proc_start;

/*
test code
call pr_sys_init(@ret);
select @ret;
*/
end
;;
DELIMITER ;
