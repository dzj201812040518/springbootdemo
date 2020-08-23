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

 Date: 24/08/2020 07:06:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for common_insert
-- ----------------------------
DROP TABLE IF EXISTS `common_insert`;
CREATE TABLE `common_insert`  (
  `common_insert_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '新增接口id',
  `common_insert_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '请求URL',
  `common_insert_field` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '新增字段',
  `common_insert_table` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '插入表名',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志（1删除）',
  `createby` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updateby` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `updatetime` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `description` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '描述',
  PRIMARY KEY (`common_insert_id`) USING BTREE,
  UNIQUE INDEX `common_query_url`(`common_insert_url`) USING BTREE COMMENT 'url唯一'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '公共接口查询表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of common_insert
-- ----------------------------
INSERT INTO `common_insert` VALUES (1, 'insertStudent', 's_id,s_name,s_birth,s_sex', 'demo.student', '0', NULL, NULL, NULL, NULL, '插入学生数据');
INSERT INTO `common_insert` VALUES (2, 'insertTime', 'time:datetime', 'demo.time', '0', NULL, NULL, NULL, NULL, '插入时间数据');

-- ----------------------------
-- Table structure for common_query
-- ----------------------------
DROP TABLE IF EXISTS `common_query`;
CREATE TABLE `common_query`  (
  `common_query_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '查询接口id',
  `common_query_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '请求URL',
  `common_query_sql` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '查询SQL',
  `common_query_conditions` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'SQL条件',
  `common_query_additional` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'SQL条件之后的附加条件',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志（1删除）',
  `createby` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updateby` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `updatetime` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `description` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '描述',
  PRIMARY KEY (`common_query_id`) USING BTREE,
  UNIQUE INDEX `common_query_url`(`common_query_url`) USING BTREE COMMENT 'url唯一'
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '公共接口查询表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of common_query
-- ----------------------------
INSERT INTO `common_query` VALUES (1, 'selectStudentAll', 'SELECT\n	s_id id,\n	s_name NAME,\n	s_birth birth,\n	s_sex sex,\n	NOW() nowTime \nFROM\n	student', 'id={id} AnD name like \'{name}\' oR sex>{sex}', 'ORDER BY id desc', '0', 'xiaojie', '2020-08-22 15:13:43', 'xiaojie', '2020-08-22 15:13:49', '查询所有学生');
INSERT INTO `common_query` VALUES (2, 'selectTime', 'SELECT time FROM time', NULL, NULL, '0', 'xiaojie', '2020-08-22 19:55:43', 'xiaojie', '2020-08-22 19:55:49', '查询时间');

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
INSERT INTO `student` VALUES ('01', '赵雷', '', '0');
INSERT INTO `student` VALUES ('02', '钱电', '', '0');
INSERT INTO `student` VALUES ('03', '孙风', '', '0');
INSERT INTO `student` VALUES ('04', '李云', '', '0');
INSERT INTO `student` VALUES ('05', '周梅', '', '1');
INSERT INTO `student` VALUES ('06', '吴兰', '', '1');
INSERT INTO `student` VALUES ('07', '郑竹', '', '1');
INSERT INTO `student` VALUES ('08', '王菊', '', '1');

-- ----------------------------
-- Table structure for time
-- ----------------------------
DROP TABLE IF EXISTS `time`;
CREATE TABLE `time`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of time
-- ----------------------------
INSERT INTO `time` VALUES (1, '2020-08-22 19:54:33');
INSERT INTO `time` VALUES (2, '2020-08-05 19:54:37');
INSERT INTO `time` VALUES (3, '2020-08-16 23:59:59');

SET FOREIGN_KEY_CHECKS = 1;
