/*
 Navicat MySQL Data Transfer

 Source Server         : 本地环境
 Source Server Version : 50709
 Source Host           : localhost
 Source Database       : common-service

 Target Server Version : 50709
 File Encoding         : utf-8

 Date: 06/29/2016 00:34:48 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `dcs_resource`
-- ----------------------------
DROP TABLE IF EXISTS `dcs_resource`;
CREATE TABLE `dcs_resource` (
  `id` varchar(20) NOT NULL,
  `name` varchar(128) NOT NULL,
  `type` varchar(64) NOT NULL,
  `max_lock` int(11) NOT NULL,
  `utc_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `utc_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name-type-key` (`name`,`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `dcs_resource_lock`
-- ----------------------------
DROP TABLE IF EXISTS `dcs_resource_lock`;
CREATE TABLE `dcs_resource_lock` (
  `id` varchar(20) NOT NULL,
  `unique_biz_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `resource_id` varchar(20) NOT NULL,
  `lock_name` varchar(128) NOT NULL,
  `lock_type` varchar(16) NOT NULL,
  `owner` varchar(64) NOT NULL,
  `utc_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `expired_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `utc_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_biz_id` (`unique_biz_id`),
  KEY `resource_fk` (`resource_id`),
  CONSTRAINT `resource_fk` FOREIGN KEY (`resource_id`) REFERENCES `dcs_resource` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `sequence`
-- ----------------------------
DROP TABLE IF EXISTS `sequence`;
CREATE TABLE `sequence` (
  `table_name` varchar(64) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=299 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
