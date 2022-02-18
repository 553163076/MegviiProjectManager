尚医疗项目 - 系统管理顶级包
任务：
  子模块：科室管理。。。。。。

子包：
  controller , service, mapper, domain

============sql==============
CREATE TABLE `his_sys_dept` (
  `dept_id` bigint NOT NULL AUTO_INCREMENT COMMENT '科室id',
  `dept_name` varchar(30) DEFAULT '' COMMENT '科室名称',
  `dept_code` varchar(30) DEFAULT '' COMMENT '科室编号',
  `no` bigint DEFAULT 0 COMMENT '挂号量',
  `dept_charge` varchar(20) DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `status` char(1) DEFAULT '0' COMMENT '科室状态（0正常 1停用）',
  `order_num` int DEFAULT '0' COMMENT '显示顺序',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=utf8 COMMENT='科室表';

insert into his_sys_dept values(1,'内科','HIS-NK',1,'北京尚学堂','18612345678',0,1,'admin',now(),'admin',now(),'');
insert into his_sys_dept values(2,'外科','HIS-WK',1,'北京尚学堂','18612345678',0,2,'admin',now(),'admin',now(),'');
insert into his_sys_dept values(3,'骨科','HIS-GK',1,'北京尚学堂','18612345678',0,3,'admin',now(),'admin',now(),'');
insert into his_sys_dept values(4,'儿科','HIS-EK',1,'北京尚学堂','18612345678',0,4,'admin',now(),'admin',now(),'');
insert into his_sys_dept values(5,'妇科','HIS-FK',1,'北京尚学堂','18612345678',0,5,'admin',now(),'admin',now(),'');
insert into his_sys_dept values(6,'泌尿外科','HIS-NK',1,'北京尚学堂','18612345678',0,0,'admin',now(),'admin',now(),'');
insert into his_sys_dept values(7,'心内科','HIS-XK',1,'北京尚学堂','18612345678',0,0,'admin',now(),'admin',now(),'');
insert into his_sys_dept values(8,'血液科','HIS-XYK',1,'北京尚学堂','18612345678',0,0,'admin',now(),'admin',now(),'');
insert into his_sys_dept values(9,'放射科','HIS-FSK',1,'北京尚学堂','18612345678',0,0,'admin',now(),'admin',now(),'');
insert into his_sys_dept values(10,'化验科','HIS-HSK',1,'北京尚学堂','18612345678',0,0,'admin',now(),'admin',now(),'');
insert into his_sys_dept values(11,'精神科','HIS-JSK',1,'北京尚学堂','18612345678',0,0,'admin',now(),'admin',now(),'');