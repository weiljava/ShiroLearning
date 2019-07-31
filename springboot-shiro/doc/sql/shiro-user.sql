
CREATE  DATABASE shiro_learning;

USE shiro_learning;



DROP TABLE IF EXISTS `tb_user_info`;

CREATE TABLE `tb_user_info` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `login_name` VARCHAR(30) DEFAULT NULL COMMENT '登陆账号名',
  `password` VARCHAR(50) DEFAULT NULL COMMENT '密码',
  `cn_name` VARCHAR(50) DEFAULT NULL COMMENT '中文名',
  `mobile_phone` VARCHAR(12) DEFAULT NULL COMMENT '手机号',
  `email` VARCHAR(100) DEFAULT NULL COMMENT '电子邮箱',
  `account_status` INT(2) DEFAULT NULL COMMENT '账户状态 -1:删除 0:失效 1:有效',
  `login_type` INT(2) DEFAULT NULL COMMENT '登陆类型1:手机密码 2账号密码',
  `user_type` INT(2) DEFAULT NULL COMMENT '用户类型 0:超级管理员 1:二级管理员 2:普通用户员',
  `create_user` INT(10) DEFAULT NULL COMMENT '创建者',
  `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  `update_user` INT(10) DEFAULT NULL COMMENT '更新者',
  `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
  `salt` VARCHAR(10) DEFAULT NULL COMMENT '密码密钥',
  `remark` VARCHAR(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='用户表';




INSERT INTO tb_user_info(login_name,PASSWORD) VALUES('dinghuawei','123456');


SELECT * FROM tb_user_info ;