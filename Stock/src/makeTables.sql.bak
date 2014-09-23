CREATE DATABASE news_all CHARACTER SET utf8 COLLATE utf8_general_ci;

USE news_all;

CREATE TABLE admin
(
adminId int NOT NULL,
adminName varchar(20) NOT NULL,
adminPass varchar(32),
adminInfo text,
primary key(adminId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE users
(
usersId int NOT NULL,
usersName varchar(20) NOT NULL,
usersPass varchar(32),
usersEmail varchar(50),
usersInfo text,
realName varchar(20),
sex varchar(10),
phone varchar(20),
idNumber varchar(30),
primary key(usersId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE newstype
(
newsTypeId int NOT NULL,
newsTypeName varchar(200),
newsTypeDescripe text,
primary key(newsTypeId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE newsinfo
(
newsInfoId int NOT NULL,
newsInfoTitle varchar(100),
newsInfoDescribe text,
newsInfoContent longtext,
newsInfoTime datetime,
newsAuthor varchar(40),
adminId int,
newsType text,
newsInfoState int,
primary key(newsInfoId),
foreign key(adminId) references admin(adminId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE replys
(
replytId int NOT NULL,
replytContent longtext,
replytTime datetime,
usersId int,
newsInfoId int,
primary key(replytId),
foreign key(usersId) references users(usersId),
foreign key(newsInfoId) references newsinfo(newsInfoId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE leavemessage
(
leaveMessageId int NOT NULL,
leaveMessageContent text,
leaveMessageTime datetime,
usersId int,
primary key(leaveMessageId),
foreign key(usersId) references users(usersId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `news_attachment` (
  `attachment_id` int(10) NOT NULL auto_increment,
  `news_id` int(10) default NULL,
  `attachment_name` varchar(50) default NULL,
  `attachment_content` longblob,
  PRIMARY KEY `attachment_id` (`attachment_id`),
  KEY `Relationship_1_FK` (`news_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

CREATE TABLE permission
(
permissionId int NOT NULL,
idNumber varchar(30) NOT NULL,
authenticationId varchar(50) NOT NULL,
permissionLevel int NOT NULL,
cmt text,
primary key(permissionId),
foreign key(idNumber) references users(idNumber)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into admin(adminId,adminName,adminPass,adminInfo) values(1,"admin","21232F297A57A5A743894A0E4A801FC3","init");