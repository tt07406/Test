一、系统说明
本程序用的是J2EE技术，MVC框架，TOMCAT服务器和MySQL数据库。
二、系统移植步骤
1、在MyEclipse中导入工程，可以通过Eclipse中的菜单File→Import→Existing Projects intoWorkspace中选择Project；
2、启动MySQL数据库，在MySQL中创建数据库，使用MySQL Control Center执行src目录下的MakeTables.sql数据库脚本文件创建数据库SQL语句创建数据库和表及数据；
3、设置数据库连接配置，修改src/org/news/utils目录下的Pools.java文件，将其中的数据库用户名和密码设置为实际的用户名和密码；
4、在Eclipse中编译工程代码，部署到Tomcat（也可以直接将MVCNews.war文件拷贝到tomcat的webapp目录中）。启动Tomcat，在浏览器输入http://localhost:8080/MVCNews/login.jsp访问，管理台输入http://localhost:8080/MVCNews/manage/login.jsp访问。
5、初始管理员用户名和密码都是admin，添加新闻前先添加新闻分类
6、网站采用编码格式为UTF-8,log放在D盘log目录下
7、以后每次使用时都要启动数据库和服务器
