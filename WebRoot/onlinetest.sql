/*
MySQL Data Transfer
Source Host: localhost
Source Database: onlinetest
Target Host: localhost
Target Database: onlinetest
Date: 2015/6/8 14:27:30
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for message
-- ----------------------------
CREATE TABLE `message` (
  `messageId` varchar(50) NOT NULL,
  `content` text NOT NULL,
  `userName` varchar(20) NOT NULL,
  `teacherId` varchar(50) NOT NULL,
  `time` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`messageId`),
  KEY `teacherId` (`teacherId`),
  CONSTRAINT `message_ibfk_1` FOREIGN KEY (`teacherId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for question
-- ----------------------------
CREATE TABLE `question` (
  `questionId` varchar(50) NOT NULL,
  `content` text NOT NULL,
  `answer` varchar(255) NOT NULL,
  `type` varchar(10) NOT NULL,
  PRIMARY KEY  (`questionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for record
-- ----------------------------
CREATE TABLE `record` (
  `recordId` varchar(50) NOT NULL,
  `userId` varchar(50) NOT NULL,
  `mark` varchar(255) NOT NULL,
  `time` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`recordId`),
  KEY `userId` (`userId`),
  CONSTRAINT `record_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
CREATE TABLE `user` (
  `userId` varchar(50) NOT NULL,
  `userName` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `type` varchar(10) NOT NULL,
  PRIMARY KEY  (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
