/*
 *  mysql-v: 5.7.22
 */

-- 创建数据库
-- CREATE DATABASE seckill DEFAULT CHARACTER SET utf8;


DROP TABLE IF EXISTS `seckill`;
DROP TABLE IF EXISTS `seckill_order`;

-- 创建选课课程表
CREATE TABLE `seckill`(
  `seckill_id` bigint NOT NULL AUTO_INCREMENT COMMENT '课程ID',
  `title` varchar (1000) DEFAULT NULL COMMENT '课程名称',
  `image` varchar (1000) DEFAULT NULL COMMENT '课程书籍图片',
  `teacher`  varchar(1000) DEFAULT NULL COMMENT '授课教师',
  `stock_count` bigint DEFAULT NULL COMMENT '课程剩余人数',
  `start_time` timestamp NOT NULL DEFAULT '1970-02-01 00:00:01' COMMENT '选课开始时间',
  `end_time` timestamp NOT NULL DEFAULT '1970-02-01 00:00:01' COMMENT '选课结束时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`seckill_id`),
  KEY `idx_start_time` (`start_time`),
  KEY `idx_end_time` (`end_time`),
  KEY `idx_create_time` (`end_time`)
) CHARSET=utf8 ENGINE=InnoDB COMMENT '选课课程表';

-- 创建选课清单表
CREATE TABLE `seckill_order`(
  `seckill_id` bigint NOT NULL COMMENT '课程ID',
  -- `money` decimal (10, 2) DEFAULT NULL COMMENT '支付金额',
  `user_sno` bigint NOT NULL COMMENT '学号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `state` tinyint NOT NULL DEFAULT -1 COMMENT '状态：-1无效 0成功 1已付款',
  PRIMARY KEY (`seckill_id`, `user_sno`) /*联合主键，保证一个学生只能在一个课程中选一次*/
) CHARSET=utf8 ENGINE=InnoDB COMMENT '选课清单表';


