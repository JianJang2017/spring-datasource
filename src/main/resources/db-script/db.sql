/*
Navicat MySQL Data Transfer

Source Server         : master
Source Server Version : 50173
Source Host           : 192.168.10.101:3306
Source Database       : posdb

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2018-09-27 16:29:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `T_MS_USER`
-- ----------------------------
DROP TABLE IF EXISTS `T_MS_USER`;
CREATE TABLE `T_MS_USER` (
  `Id` int(20) NOT NULL AUTO_INCREMENT COMMENT '编号：yyyyMMdd+12位序列',
  `user_account` varchar(20) DEFAULT NULL COMMENT '账户号：手机号',
  `user_name` varchar(256) DEFAULT NULL COMMENT '用户名称',
  `id_no` varchar(40) DEFAULT NULL COMMENT '身份证号',
  `password` varchar(128) DEFAULT NULL COMMENT '密码：密文',
  `status` varchar(2) DEFAULT NULL COMMENT '用户状态：0-无效；1-正常',
  `create_time` datetime DEFAULT NULL COMMENT '注册时间',
  `create_by` varchar(40) DEFAULT NULL COMMENT '创建人',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `modify_by` varchar(40) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=1021 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of T_MS_USER
-- ----------------------------
INSERT INTO `T_MS_USER` VALUES ('1001', '18121345671', '张三', '181213452710', '123456', '1', '2018-09-27 14:11:38', 'JianJang', null, null);
INSERT INTO `T_MS_USER` VALUES ('1002', '18121345672', '李四', '181213452720', '123456', '1', '2018-09-27 14:11:38', 'JianJang', null, null);
INSERT INTO `T_MS_USER` VALUES ('1003', '18121345673', '王五', '181213452730', '123456', '1', '2018-09-27 14:11:38', 'JianJang', null, null);
INSERT INTO `T_MS_USER` VALUES ('1004', '23232323213', '健健', '31212121', null, '1', '2018-09-27 15:12:03', 'zj', null, null);
INSERT INTO `T_MS_USER` VALUES ('1005', '23232323213', '健健22', '3121212100', null, '1', '2018-09-27 15:15:33', 'zj', null, null);
INSERT INTO `T_MS_USER` VALUES ('1006', '23232323213', '健健25', '31212121001', null, '1', '2018-09-27 15:21:39', 'zj', null, null);
INSERT INTO `T_MS_USER` VALUES ('1007', '23232323213', '健健25', '31212121001', null, '1', '2018-09-27 15:22:42', 'zj', null, null);
INSERT INTO `T_MS_USER` VALUES ('1008', '23232323213', '健健25', '31212121001', null, '1', '2018-09-27 15:28:18', 'zj', null, null);
INSERT INTO `T_MS_USER` VALUES ('1009', '232323232133', '健健250', '31212121001', null, '1', '2018-09-27 15:30:35', 'zj', null, null);
INSERT INTO `T_MS_USER` VALUES ('1010', '232323232133', '健健2580', '31212121001', null, '1', '2018-09-27 15:31:43', 'zj', null, null);
INSERT INTO `T_MS_USER` VALUES ('1011', '232323232133', '健健2580211', '31212121001', null, '1', '2018-09-27 15:39:43', 'zj', null, null);
INSERT INTO `T_MS_USER` VALUES ('1012', '232323232133', '11111', '31212121001', null, '1', '2018-09-27 15:42:01', 'zj', null, null);
INSERT INTO `T_MS_USER` VALUES ('1013', '232323232133', '11111', '31212121001', null, '1', '2018-09-27 15:44:17', 'zj', null, null);
INSERT INTO `T_MS_USER` VALUES ('1014', '232323232133', '22222', '31212121001', null, '1', '2018-09-27 15:48:15', 'zj', null, null);
INSERT INTO `T_MS_USER` VALUES ('1015', '232323232133', '333333', '31212121001', null, '1', '2018-09-27 16:09:08', 'zj', null, null);
INSERT INTO `T_MS_USER` VALUES ('1020', '232323232133', '444444', '31212121001', null, '1', '2018-09-27 16:24:10', 'zj', null, null);

-- ----------------------------
-- Table structure for `test`
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1001');
INSERT INTO `test` VALUES ('1002');
INSERT INTO `test` VALUES ('1003');
INSERT INTO `test` VALUES ('1003');
INSERT INTO `test` VALUES ('1005');
