select * from student
select * from sc
select * from teacher
select * from course

-- 查询课程1的成绩比课程2的成绩高的所有学生的学号
-- 成绩在哪张表中
-- 什么情况下排序规则不能用？ORDER BY desc 按照某一列进行排序，刚刚忘了写列名
-- from子查询的使用
-- 自连接查询，当做两张表来查询
select score from sc where cno=1
select score from sc where cno=2

SELECT a.sno from 
(select sno,score from sc where cno=1) a,
(select sno,score from sc where cno=2) b
WHERE a.score>b.score and a.sno=b.sno ORDER BY a.sno asc


-- 查询平均成绩大于60分的同学的学号和平均成绩
-- 按照学号进行分组
select sno as '学号',avg(score) as '平均成绩' from sc GROUP BY sno having avg(score)>60 ORDER BY sno;

-- 查询所有同学的学号、姓名、选课数、总成绩
-- 按照什么进行分组
select sc.sno as '学号',student.sname as '姓名',count(*) as '选课数',sum(score) as '总成绩' from sc 
LEFT JOIN student
on sc.sno= student.sno 
group by sc.sno;

-- 查询姓“张”的老师的个数
-- 一般都需要对表起别名，每个字段都要有别名标识
-- 如何去除重复的数据 DISTINCT函数
select count(DISTINCT(tname)) AS '张姓老师个数' from teacher where tname like '张%'

-- 查询同时学过课程1和课程2的同学的学号、姓名
-- 看做两张表，内连接查询，应该很容易实现

select * from sc WHERE cno=1
select * from sc WHERE cno=2
select  from course a INNER JOIN course b
on a.

-- 显示所有的数据引擎
-- 默认使用的是innodb
show engines
show index from student
create index idx_student_name on student(sname(5));
select * from idx_student_name
drop index idx_student_name on student

select sname from student where sage=23 

EXPLAIN select sc.sno as '学号',student.sname as '姓名',count(*) as '选课数',sum(score) as '总成绩' from sc 
LEFT JOIN student
on sc.sno= student.sno 
group by sc.sno;

-- 创建索引，查看索引
create index idx_sc_sno on sc(sno)
create index idx_student_sname on student(sname)
create index idx_sc_score on sc(score)
create index idx_sc_cno on sc(cno)
show index from student
show index from sc

select * from sc

explain select sno as '学号',avg(score) as '平均成绩' from sc GROUP BY sno having avg(score)>60 ORDER BY sno;
show index from sc

explain select count(DISTINCT(tname)) AS '张姓老师个数' from teacher where tname like '张%'
select * from teacher
create index idx_teacher_tname on teacher(tname)

EXPLAIN SELECT a.sno from 
(select sno,score from sc where cno=1) a,
(select sno,score from sc where cno=2) b
WHERE a.score>b.score and a.sno=b.sno ORDER BY a.sno asc
-- 哪些情况下会导致索引失效？

show index from sc

INSERT INTO `staffs` (`id`, `name`, `age`, `pos`, `add_time`) VALUES ('1', '王洪玉', '25', '总经理', '2018-05-22 09:45:44');
INSERT INTO `staffs` (`id`, `name`, `age`, `pos`, `add_time`) VALUES ('2', 'July', '25', '实习生', '2018-05-22 09:45:58');
INSERT INTO `staffs` (`id`, `name`, `age`, `pos`, `add_time`) VALUES ('3', '李四', '20', '实习生', '2018-05-22 09:46:04');
INSERT INTO `staffs` (`id`, `name`, `age`, `pos`, `add_time`) VALUES ('4', '王玉', '21', '老板娘', '2018-05-22 09:46:17');
INSERT INTO `staffs` (`id`, `name`, `age`, `pos`, `add_time`) VALUES ('5', '王五', '22', '服务员', '2018-05-22 09:46:26');
INSERT INTO `staffs` (`id`, `name`, `age`, `pos`, `add_time`) VALUES ('6', '赵六', '80', '传菜生', '2018-05-22 09:46:45');
select * from staffs

create index idx_staffs_name on staffs(name(20))
show index from staffs
-- 查询条件必须要和字段的属性对应
explain select age from staffs where name='July'

-- 创建组合索引
create index idx_staffs_ngp on staffs(name,age,pos);
show index from staffs;
-- 删除索引
drop index idx_staffs_name on staffs 

-- 什么是覆盖索引？查询条件和组合索引一样(在索引中就可以查到结果，是否需要回表中查询数据)
-- extra using index；使用索引即可查询到所有数据
-- using where 在查找使用索引的情况下，需要回表去查询所需的数
-- using index condition：查找使用了索引，但是需要回表查询数据
-- 一定要看懂extra中信息的含义 

explain select * from staffs where name= 'July' 
explain select * from staffs where name= 'July' and age=25
explain select * from staffs where name= 'July' and age=25 and pos='实习生'
-- 三个查询条件都是常量级别的
-- 索引都是有效的
-- 关键查看 type字段和ref字段，实际使用到的索引是null

explain select * from staffs where  age=25 and pos='实习生'
explain select * from staffs where  pos='实习生'
explain select * from staffs where name= 'July' and pos='实习生'

explain select * from staffs where name= 'July' 
explain select * from staffs where left(name,4)= 'July' 

explain select * from staffs where name= 'July' and age=25 and pos='实习生'
explain select * from staffs where name= 'July' and age>25 and pos='实习生'
-- 并不是精确查找，导致后面的索引失效
-- 尽量使用覆盖索引，不要使用select *，否则会导致全表扫描,并且extra的显示信息是：using index condition

explain select * from staffs where name= 'July' and age=25 and pos='实习生'
explain select name,age,pos from staffs where name= 'July' and age=25 and pos='实习生'

-- 使用范围判断条件，索引失效，导致全表扫描
explain select * from staffs where name= 'July'
explain select * from staffs where name!='July'

explain select * from staffs where name is not null

-- like以通配符开头（’%abc…’）索引失效会变成全表扫描

explain select name,age from staffs where name like '%J%'
-- 优化查询的字段，使用覆盖索引

explain select * from staffs where name= 'July' or age=25 

CREATE TABLE `tbla` (
  `id` int(11) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `birth` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

select * from tbla



CREATE INDEX idx_A_ageBirth ON tbla(age,birth);
show index from tbla
select * from tbla

explain select * from tbla where age>20 ORDER BY age;
explain select * from tbla where age>20 ORDER BY age,birth;
explain select * from tbla where age>20 ORDER BY birth;  -- 用到了文件排序
explain select * from tbla where age>20 ORDER BY birth,age;-- 用到了文件排序
-- 索引不失效的规则

SHOW VARIABLES LIKE '%slow_query_log%';
set GLOBAL slow_query_log = 1;
SHOW VARIABLES LIKE 'long_query_time%'
SET GLOBAL long_query_time = 3;
SHOW GLOBAL STATUS LIKE '%Slow_queries%';

select sleep(4)

SHOW VARIABLES LIKE 'profiling'
SET profiling = ON;
SHOW VARIABLES LIKE 'profiling';
show profiles;
show profile cpu,block io for query 9
show status like 'innodb_row_lock%';

-- 查询平均成绩大于60分的同学的学号和平均成绩
select * from sc
-- 如何计算平均成绩
select s.sno as '学号',avg(s.score) as '平均成绩' from sc s group by s.sno having avg(s.score) >60 ORDER by avg(s.score)
explain select s.sno as '学号',avg(s.score) as '平均成绩' from sc s group by s.sno having avg(s.score) >60 ORDER by avg(s.score)
explain select s.sno as '学号',avg(s.score) as '平均成绩' from sc s group by s.sno having avg(s.score) >60 ORDER by s.sno


-- 查询所有同学的学号、姓名、选课数、总成绩
select * from sc
-- 总成绩 SUM()，选课数分组
select stu.sno as '学号',stu.sname as '姓名',count(s.cno) as '选课数', SUM(s.score) as '总成绩' from sc s left join student stu on s.sno=stu.sno group by s.sno
explain select stu.sno as '学号',stu.sname as '姓名',count(s.cno) as '选课数', SUM(s.score) as '总成绩' from sc s left join student stu on s.sno=stu.sno group by s.sno
show index from student
show index from sc
drop index idx_student_name on student
show profiles
show profile cpu,block io for query 114

-- 查询姓“张”的老师的个数
-- 如何进行数据去重？
select * from teacher
select count(DISTINCT(tname)) as '张姓老师个数' from teacher where tname like '张%'
show index from teacher
explain select count(DISTINCT(tname)) as '张姓老师个数' from teacher where tname like '张%'
show profiles
show profile cpu,block io for query 261
explain select count(DISTINCT(tname)) from teacher where tname like '张%'

-- 查询没学过“张三”老师课的同学的学号、姓名
select * from course
select * from teacher
select tno from teacher where tname = '张三'
select cno from course where tno not in (select tno from teacher where tname = '张三')
-- 只有两科不是张三老师教育的
select stu.sno as '学号',stu.sname as '姓名' from sc left join student stu on sc.sno=stu.sno where cno in (select cno from course where tno not in (select tno from teacher where tname = '张三'))
explain select stu.sno as '学号',stu.sname as '姓名' from sc left join student stu on sc.sno=stu.sno where cno in (select cno from course where tno not in (select tno from teacher where tname = '张三'))

-- 查询同时学过课程1和课程2的同学的学号、姓名
select * from sc a LEFT JOIN sc b on a.sno=b.sno where a.cno=1 and b.cno=2
select c.sno from (select a.sno from sc a where a.cno=1) c inner JOIN (select b.sno from sc b where b.cno=2) d where c.sno=d.sno
select a.sno from sc a where a.cno=1
select b.sno  from sc b where b.cno=2

-- 查询同时学过课程1和课程2的同学的学号、姓名
-- 学过课程一的所有学生的sno，
select sno, sname from student
where sno in (select sno from sc where sc.cno = 1)
and sno in (select sno from sc where sc.cno = 2)

-- 查询同时学过课程1和课程2的同学的学号、姓名
-- 学过课程一的所有学生的sno
selectc.sno, c.sname from
(select sno from sc where sc.cno = 1) a,
(select sno from sc where sc.cno = 2) b,
student c
where a.sno = b.sno and a.sno = c.sno

-- 查询学过“李四”老师所教所有课程的所有同学的学号、姓名
select tno from teacher where tname='李四'
select cno from course where tno = (select tno from teacher where tname='李四')
-- 同时学过2,3学科的同学
select cno from course where tno = (select tno from teacher where tname='李四')
select sno from sc where cno in select cno from course where tno = (select tno from teacher where tname='李四')

-- 查询课程编号1的成绩比课程编号2的成绩高的所有同学的学号、姓名
SELECT * from sc
select sno,score from sc where cno=1
select sno,score from sc where cno=2
-- 三张表中，必须都有学生编号，并且存在分数比较
select * from student,
(select sno,score from sc where cno=1) a, 
(select sno,score from sc where cno=2) b 
where student.sno=a.sno=b.sno and a.score>b.score

-- 查询所有课程成绩小于60分的同学的学号、姓名
-- 如果有多科成绩，每科都小于60分
-- 现在不知道有几科成绩啊，这个怎么解决
-- 只要有一科目成绩>60 即可
-- 取反思想特别重要，编写sql的过程中

select DISTINCT(sc.sno) ,stu.sname FROM sc LEFT JOIN student stu on stu.sno=sc.sno where sc.score>60
select sno,sname from student where sno not in (select distinct sno from sc where score > 60)















































