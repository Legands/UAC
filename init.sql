DROP TABLE IF EXISTS `Sys_User`;
CREATE TABLE `Sys_User` (
 `id` BIGINT ( 20 ) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
 `username` VARCHAR ( 256 ) NOT NULL COMMENT '用户名',
 `password` VARCHAR ( 256 ) NOT NULL COMMENT '密码',
 `nick_name` VARCHAR ( 256 ) DEFAULT NULL COMMENT '昵称',
 `icon` VARCHAR ( 256 ) DEFAULT NULL COMMENT '头像',
 `qr_code` VARCHAR ( 256 ) DEFAULT NULL COMMENT '二维码',
 `full_name` VARCHAR ( 256 ) DEFAULT NULL COMMENT '姓名',
 `birthday` datetime DEFAULT NULL COMMENT '生日',
 `gender` TINYINT ( 4 ) DEFAULT NULL COMMENT '性别',
 `nation` VARCHAR ( 256 ) DEFAULT NULL COMMENT '国籍',
 `mother_tongue` VARCHAR ( 256 ) DEFAULT NULL COMMENT '母语',
 `address` VARCHAR ( 256 ) DEFAULT NULL COMMENT '地址',
 `phone_number` VARCHAR ( 256 ) DEFAULT NULL COMMENT '手机号',
 `id_card` BIGINT ( 20 ) DEFAULT NULL COMMENT '身份证',
 `last_login_time` datetime DEFAULT NULL COMMENT '上次登录时间',
 `last_login_ip` VARCHAR ( 256 ) DEFAULT NULL COMMENT '上次登录ip',
 `open_id` VARCHAR ( 256 ) DEFAULT NULL COMMENT '合作id',
 `company` VARCHAR ( 256 ) DEFAULT NULL COMMENT '单位/公司',
 `business_number` VARCHAR ( 256 ) DEFAULT NULL COMMENT '工号',
 `professional_title` VARCHAR ( 256 ) DEFAULT NULL COMMENT '职称',
 `email` VARCHAR ( 256 ) DEFAULT NULL COMMENT 'e-mail',
 `social_account` VARCHAR ( 256 ) DEFAULT NULL COMMENT '社交账号',
 `status` INT ( 4 ) NOT NULL COMMENT '账号状态',
 `reservation1` INT ( 4 ) DEFAULT NULL COMMENT '保留字段1',
 `reservation2` INT ( 4 ) DEFAULT NULL COMMENT '保留字段2',
 `create_date` datetime DEFAULT NULL COMMENT '创建时间',
 `create_user` VARCHAR ( 128 ) DEFAULT NULL COMMENT '创建用户',
 `update_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
 `update_user` VARCHAR ( 128 ) DEFAULT NULL COMMENT '更新人',
 PRIMARY KEY ( `id` ),
 KEY `idx_username` ( `username` ),
 KEY `idx_last_login_time` ( `last_login_time` ) 
 ) ENGINE = INNODB AUTO_INCREMENT = 0 DEFAULT CHARSET = utf8 COMMENT = '用户表';

DROP TABLE IF EXISTS `Sys_Role`;
CREATE TABLE `Sys_Role`(
`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
`name` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `Sys_permission`;
CREATE TABLE `Sys_permission`(
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `description` VARCHAR(200) DEFAULT NULL,
  `url` VARCHAR(200) NOT NULL,
  `pid` BIGINT DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


DROP TABLE IF EXISTS `Sys_role_user`;
CREATE TABLE `Sys_role_user`(
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `sys_user_id` BIGINT UNSIGNED NOT NULL,
  `sys_role_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


DROP TABLE IF EXISTS `Sys_permission_role`;
CREATE TABLE `Sys_permission_role`(
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `role_id` BIGINT UNSIGNED NOT NULL,
  `permission_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

insert into Sys_User (id,username, password, status) values (1,'admin', 'admin', 0);
insert into Sys_User (id,username, password, status) values (2,'abel', 'abel', 0);

insert into Sys_Role(id,name) values(1,'ROLE_ADMIN');
insert into Sys_Role(id,name) values(2,'ROLE_USER');

insert into Sys_role_user(SYS_USER_ID,sys_role_id) values(1,1);
insert into Sys_role_user(SYS_USER_ID,sys_role_id) values(2,2);

INSERT INTO `Sys_permission` VALUES ('1', 'ROLE_HOME', 'home', '/', null), ('2', 'ROLE_ADMIN', 'ABel', '/admin', null);
INSERT INTO `Sys_permission_role` VALUES ('1', '1', '1'), ('2', '1', '2'), ('3', '2', '1');
