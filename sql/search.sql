/*
 Navicat Premium Data Transfer

 Source Server         : Dorian
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : search

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 26/02/2021 11:07:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `c_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '寻物类别' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '文具类');
INSERT INTO `category` VALUES (2, '化妆品');
INSERT INTO `category` VALUES (3, '现金类');

-- ----------------------------
-- Table structure for electronic
-- ----------------------------
DROP TABLE IF EXISTS `electronic`;
CREATE TABLE `electronic`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `photo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  `number` int(255) NULL DEFAULT NULL COMMENT '联系方式',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '物品名称',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of electronic
-- ----------------------------
INSERT INTO `electronic` VALUES (1, '张三', '1.png', 122334234, '手机', '2021-01-29 18:39:55', '2021-01-29 18:39:55');
INSERT INTO `electronic` VALUES (2, '李四', '2.png', 12434353, '笔', '2021-01-29 18:40:22', '2021-01-29 18:40:22');
INSERT INTO `electronic` VALUES (3, '王五', '3.png', 4567888, '鼠标', '2021-01-29 18:40:54', '2021-01-29 18:40:54');
INSERT INTO `electronic` VALUES (4, '赵六', '4.png', 45366456, '键盘', '2021-01-29 18:41:03', '2021-01-29 18:41:03');

-- ----------------------------
-- Table structure for find_list
-- ----------------------------
DROP TABLE IF EXISTS `find_list`;
CREATE TABLE `find_list`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `fl_id` int(11) UNSIGNED NOT NULL COMMENT '索引',
  `fl_imgurl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '详情页图片地址',
  `fl_imgdesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片描述',
  `fl_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '物品状态',
  `fl_createTime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '发布时间',
  `version` int(11) NOT NULL DEFAULT 1 COMMENT '乐观锁',
  `fl_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '招领人',
  `fl_contact` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系方式',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `find_list_s_find_id_fk`(`fl_id`) USING BTREE,
  CONSTRAINT `find_list_s_find_id_fk` FOREIGN KEY (`fl_id`) REFERENCES `s_find` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '待招领物品详情表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of find_list
-- ----------------------------
INSERT INTO `find_list` VALUES (1, 1, 'http://localhost:8091/0a4bb137-1926-4068-9070-fb3b7ad08a31.jpg', '白色有线耳机', '待招领', '2021-02-23 15:00:23', 1, '赵六', '13245675432');

-- ----------------------------
-- Table structure for goods_detail
-- ----------------------------
DROP TABLE IF EXISTS `goods_detail`;
CREATE TABLE `goods_detail`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `d_imgurl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '新增图片信息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '物品详情页信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_detail
-- ----------------------------
INSERT INTO `goods_detail` VALUES (1, 'http://localhost:8091/9f7dcf02-9eda-4fbf-8752-70f1fa1e1680.jpg');
INSERT INTO `goods_detail` VALUES (2, 'http://localhost:8091/5df3d325-1e42-4549-ba03-76fac3b7ed4e.jpg');
INSERT INTO `goods_detail` VALUES (3, 'http://localhost:8091/7360fc5a-97ed-4ed7-ac33-feaca8e5f60b.jpg');

-- ----------------------------
-- Table structure for goodsfirst
-- ----------------------------
DROP TABLE IF EXISTS `goodsfirst`;
CREATE TABLE `goodsfirst`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `g_id` int(11) UNSIGNED NOT NULL COMMENT '索引',
  `imgurl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片地址',
  `imgname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片名称',
  `imgdesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片描述',
  `status` varchar(52) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片状态',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '发布时间',
  `version` int(11) NULL DEFAULT 1 COMMENT '乐观锁',
  `lostname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '遗失者姓名',
  `contact` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系方式',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `goodsfirst_goods_detail_id_fk`(`g_id`) USING BTREE,
  CONSTRAINT `goodsfirst_category_id_fk` FOREIGN KEY (`g_id`) REFERENCES `category` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `goodsfirst_goods_detail_id_fk` FOREIGN KEY (`id`) REFERENCES `goods_detail` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '首页展示的物品信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goodsfirst
-- ----------------------------
INSERT INTO `goodsfirst` VALUES (1, 1, 'http://localhost:8091/e57bddd4-b8d6-4521-9eea-b659a5cb52cc.jpg', 'U盘', 'U盘遗失在教室', '未找到', '2021-02-25 11:55:47', 1, '李四', '12323454323');
INSERT INTO `goodsfirst` VALUES (2, 2, 'http://localhost:8091/5d2f6ba2-f186-480e-b3c3-8790fafc77cc.jpg', 'mac口红', 'mac口红遗失在教室', '未找到', '2021-02-25 19:46:03', 1, '张三', '15252526257');

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP',
  `ipAddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP来源',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `browser` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '浏览器',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES (1, 'admin', '120.242.231.142', '中国|安徽省|移动', '	\r\n上传文件', '	\r\nChrome 8', '2021-01-29 13:55:08', 0);
INSERT INTO `log` VALUES (2, 'admin', '120.242.231.142', '	\r\n中国|辽宁省|沈阳市|联通', '	\r\n新增用户', 'Chrome 8', '2021-01-29 13:55:52', 0);
INSERT INTO `log` VALUES (3, 'admin', '120.242.231.142', '	\r\n中国|江西省|上饶市|电信', '	\r\n下载文件', '	\r\nChrome 8', '2021-01-29 13:56:26', 0);
INSERT INTO `log` VALUES (4, '	\r\nadmin', '	\r\n182.86.114.225', '	\r\n中国|江西省|上饶市|电信', '	\r\n上传文件', '	\r\nChrome 8', '2021-01-29 13:56:52', 0);
INSERT INTO `log` VALUES (5, 'admin', '120.242.231.142', '中国|江西省|上饶市|电信', '查询信息', 'Chrome 8', '2021-01-29 13:57:34', 0);

-- ----------------------------
-- Table structure for s_find
-- ----------------------------
DROP TABLE IF EXISTS `s_find`;
CREATE TABLE `s_find`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '物品编号',
  `f_click` int(11) NULL DEFAULT 1 COMMENT '浏览次数',
  `f_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '首页图片信息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '招领信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_find
-- ----------------------------
INSERT INTO `s_find` VALUES (1, 1, 'http://localhost:8091/cc2a1ac9-6aa8-4a9a-8946-00c353288bba.jpg');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名(登录名)',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码',
  `position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职位',
  `phoneNum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话号码',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `version` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, '张老师', '1212411', '辅导员', '1212121', 0, 4, '2021-01-28 08:00:00', '2021-01-29 13:32:57');
INSERT INTO `teacher` VALUES (2, '王老师', '1233231', '高数', '2131321', 0, 1, '2021-01-29 15:03:20', '2021-01-29 15:03:20');
INSERT INTO `teacher` VALUES (3, '李老师', '231313123', '英语', '12313213', 0, 1, '2021-01-29 15:05:29', '2021-01-29 15:05:29');
INSERT INTO `teacher` VALUES (4, '陈老师', '2343242', '工程师', '45324342', 0, 1, '2021-01-29 15:06:00', '2021-01-29 15:06:00');
INSERT INTO `teacher` VALUES (5, '高老师', '34242342', '辅导员', '32424234', 0, 1, '2021-01-29 15:06:30', '2021-01-29 15:06:30');
INSERT INTO `teacher` VALUES (6, '', '11', '111', '111', 1, 0, '2021-02-24 10:35:02', '2021-02-24 10:35:02');
INSERT INTO `teacher` VALUES (7, '1', '1', '1', '1', 1, 1, '2021-02-24 10:46:04', '2021-02-24 10:46:04');
INSERT INTO `teacher` VALUES (8, '1', '2', '1', '1', 1, 1, '2021-02-24 12:42:23', '2021-02-24 12:42:23');
INSERT INTO `teacher` VALUES (9, '1', '1', '1', '1', 1, 1, '2021-02-24 12:42:54', '2021-02-24 12:42:54');

-- ----------------------------
-- Table structure for unbo
-- ----------------------------
DROP TABLE IF EXISTS `unbo`;
CREATE TABLE `unbo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `imgUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '存储图片的地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 140 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '首页轮播图' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of unbo
-- ----------------------------
INSERT INTO `unbo` VALUES (17, 'http://localhost:8091/f0bbbb4d-bdb8-4d42-a8ee-f848d6bd94eb.jpg');
INSERT INTO `unbo` VALUES (18, 'http://localhost:8091/2a8829f7-98c9-421c-ac4e-a11c507627e8.jpg');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名(登录名)',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码',
  `profession` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专业',
  `article` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '物品名',
  `phoneNum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话号码',
  `version` int(10) NULL DEFAULT 1 COMMENT '乐观锁',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `deleted` int(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 108 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '张三1', '23234', '软件', '手机', '234342', 3, '2021-01-29 03:46:55', '2021-01-29 13:16:08', 1);
INSERT INTO `user` VALUES (2, '李四', '1211', '软件技术', '手表', '12123213', 1, '2021-01-26 18:58:08', '2021-01-26 18:58:11', 1);
INSERT INTO `user` VALUES (3, '王五', '2323', '计算机网络', '笔', '12121232', 1, '2021-01-26 18:58:45', '2021-01-26 18:58:48', 0);
INSERT INTO `user` VALUES (4, '赵六', '5465', '计算机应用', '鼠标', '12312312321', 1, '2021-01-26 18:59:20', '2021-01-26 18:59:24', 1);
INSERT INTO `user` VALUES (5, '张三', '456', '会计', 'U盘', '1213232131', 1, '2021-01-26 19:00:52', '2021-01-26 19:00:55', 0);
INSERT INTO `user` VALUES (6, '小红', '8768', '财商', '本子', '123421321', 1, '2021-01-26 19:01:37', '2021-01-26 19:01:40', 0);
INSERT INTO `user` VALUES (7, '阿雯', '3453', '计算机网络', '键盘', '2342134', 1, '2021-01-26 19:02:26', '2021-01-26 19:02:29', 0);
INSERT INTO `user` VALUES (8, '冲哥', '2121', '计算机应用', '鼠标', '23423', 1, '2021-01-26 19:33:28', '2021-01-26 19:33:32', 0);
INSERT INTO `user` VALUES (9, '阿强', '432', '建工', '尺子', '3242', 1, '2021-01-26 19:34:26', '2021-01-26 19:34:28', 0);
INSERT INTO `user` VALUES (10, '阿珍', '876678', '医护', '钥匙', '4325', 1, '2021-01-26 19:35:10', '2021-01-26 19:35:13', 0);
INSERT INTO `user` VALUES (51, '赵千', '12143431', '计算机应用技术', '手机', '12123443232', 3, '2021-01-29 00:00:00', '2021-01-29 13:12:04', 0);
INSERT INTO `user` VALUES (52, '张没', '12121', '软件工程', '电脑', '121212323', 2, '2021-01-29 05:11:01', '2021-01-29 13:11:51', 0);
INSERT INTO `user` VALUES (99, 'aaa', 'aaaa', '专业', '这个', '12121', 1, '2021-01-31 12:07:21', '2021-01-31 12:07:21', 0);
INSERT INTO `user` VALUES (100, 'aaa', 'aaaa', '专业', '这个', '12121', 1, '2021-01-31 12:12:28', '2021-01-31 12:12:28', 0);
INSERT INTO `user` VALUES (101, 'aaa', 'aaaa', '专业', '这个', '12121', 1, '2021-01-31 12:15:14', '2021-01-31 12:15:14', 0);
INSERT INTO `user` VALUES (102, 'demoData', 'demoData', 'demoData', 'demoData', 'demoData', 0, '2021-02-09 20:14:06', '2021-02-09 20:14:06', 0);
INSERT INTO `user` VALUES (103, 'aaa', 'aaaa', '专业', '这个', '12121', 1, '2021-02-09 20:22:12', '2021-02-09 20:22:12', 0);
INSERT INTO `user` VALUES (104, 'aaa', 'aaaa', '专业', '这个', '12121', 1, '2021-02-09 20:22:34', '2021-02-09 20:22:34', 0);
INSERT INTO `user` VALUES (105, 'aaa', 'aaaa', '专业', '这个', '12121', 1, '2021-02-09 20:24:00', '2021-02-09 20:24:00', 0);
INSERT INTO `user` VALUES (106, 'aaa', 'aaaa', '专业', '这个', '12121', 1, '2021-02-10 10:47:18', '2021-02-10 10:47:18', 0);
INSERT INTO `user` VALUES (107, 'demoData', 'demoData', 'demoData', 'demoData', 'demoData', 0, '2021-02-11 13:30:04', '2021-02-11 13:30:04', 0);

SET FOREIGN_KEY_CHECKS = 1;
