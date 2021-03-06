insert into mysql.user(Host,User,Password) values("localhost","person",password("stock"));
insert into mysql.user(Host,User,Password) values("%","person",password("smart12306"));
flush privileges;

CREATE DATABASE news_personal CHARACTER SET utf8 COLLATE utf8_general_ci;
grant all privileges on news_personal.* to person@localhost identified by 'stock';
grant select,insert,update,delete on news_personal.* to person@'%' identified by 'smart12306';
grant select on news_all.* to person@'%' identified by 'smart12306';
grant select on news_all.* to person@localhost identified by 'stock';
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
