# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.18)
# Database: union
# Generation Time: 2019-07-23 01:58:24 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table PDMAN_DB_VERSION
# ------------------------------------------------------------

DROP TABLE IF EXISTS `PDMAN_DB_VERSION`;

CREATE TABLE `PDMAN_DB_VERSION` (
  `DB_VERSION` varchar(256) DEFAULT NULL,
  `VERSION_DESC` varchar(1024) DEFAULT NULL,
  `CREATED_TIME` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table t_class
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_class`;

CREATE TABLE `t_class` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '班级名称',
  `class_id` int(11) DEFAULT NULL COMMENT '班级id',
  `course_count` int(11) DEFAULT NULL COMMENT '班级招生人数',
  `course_total_count` int(11) DEFAULT NULL COMMENT '班级招生总人数',
  `person_count` int(11) DEFAULT NULL COMMENT '报名人数',
  `person_total_count` int(11) DEFAULT NULL COMMENT '报名总人数',
  `begin_time` timestamp NULL DEFAULT NULL COMMENT '上课时间',
  `end_time` timestamp NULL DEFAULT NULL COMMENT '上课结束时间',
  `status` int(11) DEFAULT NULL COMMENT '招生状态',
  `up_time` int(11) DEFAULT NULL COMMENT '上架时间',
  `delete_status` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table t_class_supplier
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_class_supplier`;

CREATE TABLE `t_class_supplier` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `class_id` int(11) DEFAULT NULL COMMENT '班级id',
  `supplier_id` int(11) DEFAULT NULL COMMENT '教师id',
  `goods_id` int(11) DEFAULT NULL COMMENT '课程商品id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table t_goods
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_goods`;

CREATE TABLE `t_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_code` varchar(11) DEFAULT NULL COMMENT '视频Code',
  `goods_name` varchar(255) NOT NULL COMMENT '视频标题',
  `status` int(11) DEFAULT '0' COMMENT '视频上架状态',
  `delete_status` tinyint(1) DEFAULT '0' COMMENT '视频删除状态0为未删除，1为删除',
  `goods_url` varchar(255) DEFAULT 'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3' COMMENT '视频url链接',
  `goods_desc` varchar(255) DEFAULT NULL COMMENT '视频描述',
  `supplier_id` int(11) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `sale_price` decimal(10,0) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `grade_id` int(11) DEFAULT NULL COMMENT '年级',
  `subject_id` int(11) DEFAULT NULL COMMENT '科目',
  `start_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `end_time` timestamp NULL DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_goods` WRITE;
/*!40000 ALTER TABLE `t_goods` DISABLE KEYS */;

INSERT INTO `t_goods` (`id`, `goods_code`, `goods_name`, `status`, `delete_status`, `goods_url`, `goods_desc`, `supplier_id`, `price`, `sale_price`, `img`, `grade_id`, `subject_id`, `start_time`, `update_time`, `end_time`, `create_time`)
VALUES
	(1,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数',2,799,799,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:41:45','2019-07-15 14:44:28','2019-07-13 23:41:45','2019-07-15 14:44:28'),
	(2,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数',2,799,799,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:41:45','2019-07-13 23:41:45','2019-07-13 23:41:45','2019-07-13 23:41:45'),
	(3,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',2,799,799,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:41:45','2019-07-13 23:41:45','2019-07-13 23:41:45','2019-07-13 23:41:45'),
	(4,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',2,799,799,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:41:45','2019-07-13 23:41:45','2019-07-13 23:41:45','2019-07-13 23:41:45'),
	(5,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',2,799,799,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:41:45','2019-07-13 23:41:45','2019-07-13 23:41:45','2019-07-13 23:41:45'),
	(6,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',2,799,799,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:41:45','2019-07-13 23:41:45','2019-07-13 23:41:45','2019-07-13 23:41:45'),
	(7,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',2,799,799,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:41:45','2019-07-13 23:41:45','2019-07-13 23:41:45','2019-07-13 23:41:45'),
	(8,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',2,799,799,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:41:45','2019-07-13 23:41:45','2019-07-13 23:41:45','2019-07-13 23:41:45'),
	(9,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',2,799,799,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:41:45','2019-07-13 23:41:45','2019-07-13 23:41:45','2019-07-13 23:41:45'),
	(10,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',2,799,799,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:41:45','2019-07-13 23:41:45','2019-07-13 23:41:45','2019-07-13 23:41:45'),
	(11,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',2,799,799,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:41:45','2019-07-13 23:41:45','2019-07-13 23:41:45','2019-07-13 23:41:45'),
	(12,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',2,799,799,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:41:45','2019-07-13 23:41:45','2019-07-13 23:41:45','2019-07-13 23:41:45'),
	(13,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',2,799,799,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27'),
	(14,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',2,799,799,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27'),
	(15,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',2,799,799,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27'),
	(16,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',2,799,799,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27'),
	(17,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',2,799,799,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27'),
	(18,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',2,799,799,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27'),
	(19,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',2,799,799,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27'),
	(20,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',2,799,799,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27'),
	(21,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',2,799,799,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27'),
	(22,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',2,799,799,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27'),
	(23,NULL,'圆锥曲线',0,1,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',1,599,599,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',2,1,'2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27'),
	(24,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',1,599,599,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27'),
	(25,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',1,599,599,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27'),
	(26,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',1,599,599,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27'),
	(27,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',1,599,599,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',2,2,'2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27'),
	(28,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',1,599,599,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27'),
	(29,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',1,599,599,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27'),
	(30,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',1,599,599,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27'),
	(31,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',1,599,599,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27'),
	(32,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',1,599,599,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27'),
	(33,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',1,599,599,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27'),
	(34,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',1,599,599,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27'),
	(35,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',1,599,599,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27'),
	(36,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',1,599,599,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27'),
	(37,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',1,599,599,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27'),
	(38,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',1,599,599,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27'),
	(39,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',1,599,599,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27'),
	(40,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',1,599,599,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27'),
	(41,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',1,599,599,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27'),
	(42,NULL,'三角函数',0,0,'http://220.194.238.108/13/j/r/y/q/jryqujooljwzxpmyjumfuarxoguwld/hc.yinyuetai.com/81E9016B6454B2ADD09AE8853E6A7824.mp4?sc=ef957d6fd8824b68&br=779&vid=3386199&aid=39878&area=ML&vst=3','三角函数描述',1,599,599,'https://pics1.baidu.com/feed/810a19d8bc3eb135a61aecec3949a4d6fc1f4460.jpeg?token=bdc1255e05eba4ce9f590b8d7fcdf4d2&s=67222BE74B481B511AF0A917030060C3',1,1,'2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27','2019-07-13 23:16:27');

/*!40000 ALTER TABLE `t_goods` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_grade
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_grade`;

CREATE TABLE `t_grade` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '年级',
  `delete_status` tinyint(1) DEFAULT '0' COMMENT '0为未删除，1为删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_grade` WRITE;
/*!40000 ALTER TABLE `t_grade` DISABLE KEYS */;

INSERT INTO `t_grade` (`id`, `name`, `delete_status`)
VALUES
	(1,'初一',0),
	(2,'初二',0),
	(3,'初三',0),
	(4,'高一',0),
	(5,'高二',0),
	(6,'高三',0),
	(7,'成人',0);

/*!40000 ALTER TABLE `t_grade` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_image
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_image`;

CREATE TABLE `t_image` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `img_path` varchar(255) DEFAULT NULL,
  `delete_status` tinyint(1) DEFAULT '0',
  `create_time` timestamp NULL DEFAULT NULL,
  `img_name` varchar(255) DEFAULT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_image` WRITE;
/*!40000 ALTER TABLE `t_image` DISABLE KEYS */;

INSERT INTO `t_image` (`id`, `img_path`, `delete_status`, `create_time`, `img_name`, `file_path`)
VALUES
	(1,'/video/d1ac3acc-79e1-4c35-a3c0-0e3925178a6a.jpg',0,'2019-07-06 07:31:33','d1ac3acc-79e1-4c35-a3c0-0e3925178a6a.jpg','/video/'),
	(2,'/video/14c636c0-0d1c-4ba8-90a2-fc2168a683b6.jpg',0,'2019-07-06 07:31:49','14c636c0-0d1c-4ba8-90a2-fc2168a683b6.jpg','/video/'),
	(3,'/video/e3b93fa6-c686-476c-b54e-008a3afa8429.jpg',0,'2019-07-06 07:38:06','e3b93fa6-c686-476c-b54e-008a3afa8429.jpg','/video/'),
	(4,'/video/7596b20c-b76d-4408-a78b-ac9e2a7808c8.jpg',0,'2019-07-06 07:41:20','7596b20c-b76d-4408-a78b-ac9e2a7808c8.jpg','/video/');

/*!40000 ALTER TABLE `t_image` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_permission
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_permission`;

CREATE TABLE `t_permission` (
  `id` int(11) NOT NULL,
  `menu_code` varchar(255) DEFAULT NULL,
  `menu_name` varchar(255) DEFAULT NULL,
  `permission_code` varchar(255) DEFAULT NULL,
  `permission_name` varchar(255) DEFAULT NULL,
  `required_permission` tinyint(1) DEFAULT '1' COMMENT '是否本菜单必选权限, 1.必选 2非必选 通常是"列表"权限是必选',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_permission` WRITE;
/*!40000 ALTER TABLE `t_permission` DISABLE KEYS */;

INSERT INTO `t_permission` (`id`, `menu_code`, `menu_name`, `permission_code`, `permission_name`, `required_permission`)
VALUES
	(101,'goods','商品管理','goods:list','列表',1),
	(102,'goods','商品管理','goods:add','新增',1),
	(103,'goods','商品管理','goods:update','修改',1),
	(201,'classify','类型管理','classify:list','列表',1),
	(202,'classify','类型管理','classify:add','新增',1),
	(203,'classify','类型管理','classify:update','修改',1),
	(701,'role','角色权限','role:list','列表',1),
	(702,'role','角色权限','role:add','新增',1),
	(703,'role','角色权限','role:update','修改',1),
	(704,'role','角色权限','role:delete','删除',1);

/*!40000 ALTER TABLE `t_permission` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `delete_status` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_role` WRITE;
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;

INSERT INTO `t_role` (`id`, `role_name`, `create_time`, `update_time`, `delete_status`)
VALUES
	(1,'管理员','2019-06-24 02:58:46','2019-06-24 02:58:46',0),
	(2,'教师','2019-06-24 02:59:57','2019-06-24 02:59:57',0);

/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_role_permission
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_role_permission`;

CREATE TABLE `t_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `delete_status` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_role_permission` WRITE;
/*!40000 ALTER TABLE `t_role_permission` DISABLE KEYS */;

INSERT INTO `t_role_permission` (`id`, `role_id`, `permission_id`, `create_time`, `update_time`, `delete_status`)
VALUES
	(1,2,101,'2019-06-24 04:40:09','2019-06-24 04:40:09',0),
	(2,2,102,'2019-06-24 04:40:47','2019-06-24 04:40:47',0),
	(3,2,103,'2019-06-24 04:41:21','2019-06-24 04:41:21',0);

/*!40000 ALTER TABLE `t_role_permission` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_shopping_order
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_shopping_order`;

CREATE TABLE `t_shopping_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `status` int(11) DEFAULT '10001',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `delete_status` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_shopping_order` WRITE;
/*!40000 ALTER TABLE `t_shopping_order` DISABLE KEYS */;

INSERT INTO `t_shopping_order` (`id`, `user_id`, `status`, `create_time`, `update_time`, `delete_status`)
VALUES
	(1,2,10001,'2019-07-06 07:31:33','2019-07-14 09:52:57',1),
	(2,2,10001,'2019-07-14 08:36:06','2019-07-14 08:36:06',1),
	(3,3,10001,'2019-07-14 08:44:49','2019-07-16 21:01:59',0),
	(4,4,10001,'2019-07-14 09:49:34','2019-07-14 09:49:34',0),
	(5,5,10001,'2019-07-14 09:50:23','2019-07-14 09:50:23',0),
	(6,6,10001,'2019-07-16 19:24:20','2019-07-16 19:51:08',0);

/*!40000 ALTER TABLE `t_shopping_order` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_shopping_son_order
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_shopping_son_order`;

CREATE TABLE `t_shopping_son_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) NOT NULL,
  `status` int(11) DEFAULT '0',
  `shopping_order_id` int(11) DEFAULT NULL,
  `delete_status` tinyint(1) DEFAULT '0',
  `count` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_shopping_son_order` WRITE;
/*!40000 ALTER TABLE `t_shopping_son_order` DISABLE KEYS */;

INSERT INTO `t_shopping_son_order` (`id`, `goods_id`, `status`, `shopping_order_id`, `delete_status`, `count`)
VALUES
	(1,1,0,1,1,1),
	(2,2,0,1,1,1),
	(3,4,0,1,1,1),
	(4,5,0,1,1,1),
	(5,6,0,1,1,1),
	(6,8,0,1,1,1),
	(7,26,0,1,1,1),
	(8,26,0,3,0,5),
	(9,25,0,3,1,1),
	(10,27,0,3,0,1),
	(11,28,0,3,0,1),
	(12,9,0,7,0,2),
	(13,10,0,5,0,1),
	(14,10,0,1,1,1),
	(15,8,0,8,0,3),
	(16,9,0,9,0,1),
	(17,9,0,6,0,2),
	(18,8,0,6,0,3),
	(19,25,0,3,0,2);

/*!40000 ALTER TABLE `t_shopping_son_order` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_status
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_status`;

CREATE TABLE `t_status` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `delete_status` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_status` WRITE;
/*!40000 ALTER TABLE `t_status` DISABLE KEYS */;

INSERT INTO `t_status` (`id`, `name`, `delete_status`)
VALUES
	(10000,'已支付',0),
	(10001,'待支付',0),
	(10002,'已取消',0),
	(10003,'已完成',0),
	(20000,'上架',0),
	(20001,'下架',0),
	(30001,'用户不存在',0),
	(30002,'用户已注销',0),
	(30003,'用户已冻结',0),
	(40000,'系列课',0),
	(40001,'公开课',0),
	(40002,'过期课',0),
	(50000,'未开始',0),
	(50001,'已开始',0),
	(50002,'已结束',0),
	(60000,'未上架',0),
	(60001,'停止招生',0),
	(60002,'正在招生',0);

/*!40000 ALTER TABLE `t_status` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_subject
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_subject`;

CREATE TABLE `t_subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '科目',
  `delete_status` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_subject` WRITE;
/*!40000 ALTER TABLE `t_subject` DISABLE KEYS */;

INSERT INTO `t_subject` (`id`, `name`, `delete_status`)
VALUES
	(1,'语文',0),
	(2,'数学',0),
	(3,'英语',0),
	(4,'化学',0),
	(5,'物理',0),
	(6,'生物',0);

/*!40000 ALTER TABLE `t_subject` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_supplier
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_supplier`;

CREATE TABLE `t_supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `status` int(11) DEFAULT '0',
  `phone_number` int(11) DEFAULT NULL,
  `delete_status` tinyint(1) DEFAULT '0',
  `role_id` int(11) DEFAULT NULL,
  `supplier_token` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_supplier` WRITE;
/*!40000 ALTER TABLE `t_supplier` DISABLE KEYS */;

INSERT INTO `t_supplier` (`id`, `name`, `password`, `status`, `phone_number`, `delete_status`, `role_id`, `supplier_token`)
VALUES
	(1,'wudaming','5f4dcc3b5aa765d61d8327deb882cf99',1,NULL,0,1,'115c4c8f-e0d8-4fb3-ba08-9a33ceec87e9'),
	(2,'test','5f4dcc3b5aa765d61d8327deb882cf99',1,NULL,0,2,'3d96dda5-fa58-4c97-9853-fcff02ba25a0');

/*!40000 ALTER TABLE `t_supplier` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_supplier_order
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_supplier_order`;

CREATE TABLE `t_supplier_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `supplier_id` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT '0',
  `delete_status` tinyint(1) DEFAULT '0',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `supplier_order_id` bigint(20) DEFAULT NULL,
  `time_status` int(11) DEFAULT '0',
  `total_price` decimal(10,0) DEFAULT NULL,
  `pay_status` int(11) DEFAULT '10001',
  `end_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_supplier_order` WRITE;
/*!40000 ALTER TABLE `t_supplier_order` DISABLE KEYS */;

INSERT INTO `t_supplier_order` (`id`, `user_id`, `supplier_id`, `status`, `delete_status`, `create_time`, `update_time`, `supplier_order_id`, `time_status`, `total_price`, `pay_status`, `end_time`)
VALUES
	(1,2,2,40000,0,'2019-06-28 09:41:30','2019-06-28 09:41:30',1144616819307716607,50000,1598,10001,'2019-07-28 09:41:30'),
	(2,2,2,40000,0,'2019-06-28 09:41:30','2019-06-28 09:41:30',1144616819307716608,50000,2397,10001,'2019-07-28 09:41:30'),
	(3,2,2,40000,0,'2019-07-15 19:07:26','2019-07-15 19:07:26',1150723541072613376,50000,799,10001,'2019-07-15 19:07:26'),
	(4,3,NULL,40000,0,'2019-07-15 23:11:32','2019-07-15 23:11:32',1150784971603976192,50000,3196,10001,'2019-07-15 23:11:32'),
	(5,3,NULL,40000,0,'2019-07-15 23:20:35','2019-07-15 23:20:35',1150787245493305344,50000,3196,10001,'2019-07-15 23:20:35'),
	(6,3,NULL,40000,0,'2019-07-15 23:25:56','2019-07-15 23:25:56',1150788595317284864,50000,3196,10001,'2019-07-15 23:25:56'),
	(7,2,NULL,40000,0,'2019-07-15 23:33:04','2019-07-15 23:33:04',1150790387693506560,50000,5593,10001,'2019-07-15 23:33:04');

/*!40000 ALTER TABLE `t_supplier_order` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_supplier_son_order
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_supplier_son_order`;

CREATE TABLE `t_supplier_son_order` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT '0',
  `price` decimal(11,0) DEFAULT NULL,
  `count` int(11) DEFAULT '1',
  `supplier_order_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_supplier_son_order` WRITE;
/*!40000 ALTER TABLE `t_supplier_son_order` DISABLE KEYS */;

INSERT INTO `t_supplier_son_order` (`id`, `goods_id`, `status`, `price`, `count`, `supplier_order_id`)
VALUES
	(1,1,0,799,1,1144616819307716608),
	(2,2,0,799,1,1144616819307716608),
	(3,3,0,799,1,1144616819307716608),
	(4,5,0,799,1,1144616819307716607),
	(5,6,0,799,1,1144616819307716607),
	(6,5,0,799,1,1150723541072613376),
	(7,26,0,799,1,1150784971603976192),
	(8,25,0,799,1,1150784971603976192),
	(9,27,0,799,1,1150784971603976192),
	(10,28,0,799,1,1150784971603976192),
	(11,26,0,799,1,1150787245493305344),
	(12,25,0,799,1,1150787245493305344),
	(13,27,0,799,1,1150787245493305344),
	(14,28,0,799,1,1150787245493305344),
	(15,26,0,799,1,1150788595317284864),
	(16,25,0,799,1,1150788595317284864),
	(17,27,0,799,1,1150788595317284864),
	(18,28,0,799,1,1150788595317284864),
	(19,1,0,799,1,1150790387693506560),
	(20,2,0,799,1,1150790387693506560),
	(21,4,0,799,1,1150790387693506560),
	(22,5,0,799,1,1150790387693506560),
	(23,6,0,799,1,1150790387693506560),
	(24,8,0,799,1,1150790387693506560),
	(25,26,0,799,1,1150790387693506560);

/*!40000 ALTER TABLE `t_supplier_son_order` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mobile` varchar(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `wx_id` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT '0',
  `delete_status` tinyint(1) DEFAULT '0',
  `user_token` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;

INSERT INTO `t_user` (`id`, `mobile`, `name`, `password`, `nickname`, `wx_id`, `status`, `delete_status`, `user_token`)
VALUES
	(1,'18010479518','樊亚风','e16b2ab8d12314bf4efbd6203906ea6c','昵称',NULL,0,0,'024ab75a1ddb4926883f08e334e8512c'),
	(2,'18010479516','测试','5f4dcc3b5aa765d61d8327deb882cf99','测试昵称',NULL,0,0,'caff4ebd310a49d19059e01511f52569');

/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_video
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_video`;

CREATE TABLE `t_video` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `video_path` varchar(255) DEFAULT NULL,
  `delete_status` tinyint(1) DEFAULT '0',
  `create_time` timestamp NULL DEFAULT NULL,
  `video_name` varchar(255) DEFAULT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
