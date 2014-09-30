insert into mysql.user(Host,User,Password) values("localhost","person",password("stock"));
insert into mysql.user(Host,User,Password) values("%","person",password("smart12306"));
flush privileges;

CREATE DATABASE news_personal CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE DATABASE news_collect CHARACTER SET utf8 COLLATE utf8_general_ci;
grant all privileges on news_personal.* to person@localhost identified by 'stock';
grant all privileges on news_personal.* to person@'%' identified by 'smart12306';
grant select,insert,update,delete,create,drop on news_collect.* to person@'%' identified by 'stock';
grant select,insert,update,delete,create,drop on news_collect.* to person@localhost identified by 'stock';
flush privileges;

USE news_personal;

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
newsInfoContent longtext,
newsInfoTime datetime,
newsAuthor varchar(40),
adminName varchar(20),
newsType text,
primary key(newsInfoId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE admin
(
adminId int NOT NULL,
adminName varchar(40) NOT NULL,
adminPass varchar(32),
adminInfo text,
primary key(adminId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE table
(
tableId int NOT NULL,
tableName varchar(100),
tableAbstract text,
tableRow int,
tableCol int,
tableContent longtext,
primary key(tableId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into admin(adminId,adminName,adminPass,adminInfo) values(1,"330719196804253671","21232F297A57A5A743894A0E4A801FC3","init");

use news_collect;

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
newsInfoContent longtext,
newsInfoTime datetime,
newsAuthor varchar(40),
adminName varchar(20),
newsType text,
primary key(newsInfoId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;