/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : 192.168.1.11:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 22/08/2020 13:58:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `s_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生编号',
  `s_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '学生姓名',
  `s_birth` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '出生年月',
  `s_sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '学生性别',
  PRIMARY KEY (`s_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学生表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('01', '赵雷', '1990-01-01', '0');
INSERT INTO `student` VALUES ('02', '钱电', '1990-12-21', '0');
INSERT INTO `student` VALUES ('03', '孙风', '1990-05-20', '0');
INSERT INTO `student` VALUES ('04', '李云', '1990-08-06', '0');
INSERT INTO `student` VALUES ('05', '周梅', '1991-12-01', '1');
INSERT INTO `student` VALUES ('06', '吴兰', '1992-03-01', '1');
INSERT INTO `student` VALUES ('07', '郑竹', '1989-07-01', '1');
INSERT INTO `student` VALUES ('08', '王菊', '1990-01-20', '1');

SET FOREIGN_KEY_CHECKS = 1;
