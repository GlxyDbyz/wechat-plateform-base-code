SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `realName` varchar(20) NOT NULL,
  `emaill` varchar(50) NOT NULL,
  `password` varchar(32) NOT NULL,
  `uuid` varchar(32) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `wx_plateform_user_info`;
CREATE TABLE `wx_plateform_user_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `subscribe` tinyint(2) DEFAULT NULL,
  `nickName` varchar(20) DEFAULT NULL,
  `openId` varchar(50) DEFAULT NULL,
  `sex` tinyint(2) DEFAULT NULL,
  `language` varchar(10) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `province` varchar(50) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `headImgUrl` varchar(400) DEFAULT NULL,
  `subscribeTime` bigint(20) DEFAULT NULL,
  `unionId` varchar(50) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  `groupId` varchar(10) DEFAULT NULL,
  `infoGetTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

INSERT INTO `sys_user` VALUES ('1', 'sys', 'sys', '845927437@qq.com', 'd792bec0e6a4bf0cdf345eae846f8146', 'dccc42256a07489d90fd281dcfafe0bd', '2015-09-25 22:18:30');

DROP TABLE IF EXISTS `wx_request_xml`;
CREATE TABLE `wx_request_xml` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(5000) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=456 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `wx_response_xml`;
CREATE TABLE `wx_response_xml` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(5000) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=427 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `wx_user`;
CREATE TABLE `wx_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `openId` varchar(50) DEFAULT NULL,
  `bindTime` datetime DEFAULT NULL,
  `cerateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;