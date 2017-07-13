/*
Navicat MySQL Data Transfer

Source Server         : qinjian
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : qikan

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-07-13 12:25:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `time` date DEFAULT NULL,
  `content` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', 'huang', '我爱你', '2015-10-06', '我爱你');
INSERT INTO `article` VALUES ('3', 'liu', '你爱我', '2017-07-03', '你爱我');
INSERT INTO `article` VALUES ('4', 'liu', '我爱她', '2017-07-03', '我爱她');
INSERT INTO `article` VALUES ('11', 'admin', '更新', '2017-07-11', '<p>更新的文章</p>甲乙');

-- ----------------------------
-- Table structure for article_detail
-- ----------------------------
DROP TABLE IF EXISTS `article_detail`;
CREATE TABLE `article_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `articleid` int(11) NOT NULL,
  `editorname` varchar(11) NOT NULL,
  `editordetail` varchar(255) NOT NULL,
  `editortime` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_detail
-- ----------------------------
INSERT INTO `article_detail` VALUES ('4', '11', 'admin', '<p>更新的文章</p>甲乙', '2017-07-11');
INSERT INTO `article_detail` VALUES ('5', '4', 'sasww', 'sasasasw', '2017-07-12');

-- ----------------------------
-- Table structure for article_idea
-- ----------------------------
DROP TABLE IF EXISTS `article_idea`;
CREATE TABLE `article_idea` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `articleid` int(11) DEFAULT NULL,
  `expertname` varchar(255) DEFAULT NULL,
  `expertidea` varchar(255) DEFAULT NULL,
  `experttime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_idea
-- ----------------------------
INSERT INTO `article_idea` VALUES ('6', '4', '44', '444', '2017-06-06');
INSERT INTO `article_idea` VALUES ('8', '3', 'admin', '请输入审批意见', '2017-07-13');

-- ----------------------------
-- Table structure for author
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of author
-- ----------------------------
INSERT INTO `author` VALUES ('1', 'qin', '123');
INSERT INTO `author` VALUES ('2', 'jian', '123');
INSERT INTO `author` VALUES ('5', 'liu', '123');
INSERT INTO `author` VALUES ('6', 'wen', '123');
INSERT INTO `author` VALUES ('8', 'admin', 'admin');
INSERT INTO `author` VALUES ('9', 'you', '123');

-- ----------------------------
-- Table structure for editor
-- ----------------------------
DROP TABLE IF EXISTS `editor`;
CREATE TABLE `editor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of editor
-- ----------------------------
INSERT INTO `editor` VALUES ('1', 'qin', '123');
INSERT INTO `editor` VALUES ('3', 'huang', '456');
INSERT INTO `editor` VALUES ('6', 'jian', '456');
INSERT INTO `editor` VALUES ('12', 'admin', 'admin');

-- ----------------------------
-- Table structure for expert
-- ----------------------------
DROP TABLE IF EXISTS `expert`;
CREATE TABLE `expert` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of expert
-- ----------------------------
INSERT INTO `expert` VALUES ('1', 'qin', '123');
INSERT INTO `expert` VALUES ('2', 'chen', '123');
INSERT INTO `expert` VALUES ('3', 'han', '123');
INSERT INTO `expert` VALUES ('4', 'admin', 'admin');
