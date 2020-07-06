/*1.
获取有奖金的员工相关信息。
CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`));
CREATE TABLE `dept_emp` (
`emp_no` int(11) NOT NULL,
`dept_no` char(4) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`dept_no`));
create table emp_bonus(
emp_no int not null,
received datetime not null,
btype smallint not null);
CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL, PRIMARY KEY (`emp_no`,`from_date`));
给出emp_no、first_name、last_name、奖金类型btype、对应的当前薪水情况salary以及奖金金额bonus。 
bonus类型btype为1其奖金为薪水salary的10%，btype为2其奖金为薪水的20%，其他类型均为薪水的30%。
 当前薪水表示to_date='9999-01-01'
*/
select e.emp_no, e.first_name, e.last_name, b.btype, s.salary,
((b.btype * s.salary)/10.0)
from employees as e inner join emp_bonus as b on e.emp_no = b.emp_no
inner join salaries as s on e.emp_no = s.emp_no and s.to_date = '9999-01-01' 



-----------------------------------------------------------------------------------------------------

/*
2.
使用含有关键字exists查找未分配具体部门的员工的所有信息。
CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`));
CREATE TABLE `dept_emp` (
`emp_no` int(11) NOT NULL,
`dept_no` char(4) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`dept_no`));

*/

select * from employees as e 
where not exists (SELECT emp_no FROM dept_emp WHERE emp_no = e.emp_no)
--或者
select * from employees as e where e.emp_no not in (SELECT emp_no FROM dept_emp)

/*exists表示后面的语句的判断是否存在，in可以判断某一列是否存在
EXISTS(包括 NOT EXISTS )子句的返回值是一个BOOL值。 EXISTS内部有一个子查询语句(SELECT ... FROM...)，
我将其称为EXIST的内查询语句。其内查询语句返回一个结果集。 
EXISTS子句根据其内查询语句的结果集空或者非空，返回一个布尔值。
将外查询表的每一行，代入内查询作为检验，如果内查询返回的结果取非空值，
则EXISTS子句返回TRUE，这一行行可作为外查询的结果行，否则不能作为结果。
EXISTS与IN的使用效率的问题，通常情况下采用exists要比in效率高，因为IN不走索引，但要看实际情况具体使用：
IN适合于外表大而内表小的情况；EXISTS适合于外表小而内表大的情况。
*/

-----------------------------------------------------------------------------------------------------
/* 
3.
获取所有员工的emp_no、部门编号dept_no以及对应的bonus类型btype和received，没有分配奖金的员工不显示对应的bonus类型btype和received
CREATE TABLE `dept_emp` (
`emp_no` int(11) NOT NULL,
`dept_no` char(4) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`dept_no`));

CREATE TABLE `emp_bonus`(
emp_no int(11) NOT NULL,
received datetime NOT NULL,
btype smallint(5) NOT NULL);

CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`));
*/
select d.emp_no,d.dept_no,b.btype,b.received from dept_emp as d
inner join employees e on e.emp_no = d.emp_no 
left join emp_bonus b on b.emp_no = e.emp_no

---------------------------------------------------------------------
/*
4.
分页查询employees表，每5行一页，返回第2页的数据
CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`));*/
select * from employees limit 5,5

-------------------------------------------------------------------------
/*
5.
查找排除最大、最小salary之后的当前(to_date = '9999-01-01' )员工的平均工资avg_salary。
CREATE TABLE `salaries` ( `emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));
如：
INSERT INTO salaries VALUES(10001,85097,'2001-06-22','2002-06-22');
INSERT INTO salaries VALUES(10001,88958,'2002-06-22','9999-01-01');
INSERT INTO salaries VALUES(10002,72527,'2001-08-02','9999-01-01');
INSERT INTO salaries VALUES(10003,43699,'2000-12-01','2001-12-01');
INSERT INTO salaries VALUES(10003,43311,'2001-12-01','9999-01-01');
INSERT INTO salaries VALUES(10004,70698,'2000-11-27','2001-11-27');
INSERT INTO salaries VALUES(10004,74057,'2001-11-27','9999-01-01');
*/
select avg(salary) from salaries 
where to_date = '9999-01-01'
and salary not in ( select max(salary) from salaries  where to_date = '9999-01-01')
and  salary not in ( select min(salary) from salaries  where to_date = '9999-01-01')

----------------------------------------------------------------------------------------------------
 /*
 6.
 按照dept_no进行汇总，属于同一个部门的emp_no按照逗号进行连接，结果给出dept_no以及连接出的结果employees
CREATE TABLE `dept_emp` (
`emp_no` int(11) NOT NULL,
`dept_no` char(4) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`dept_no`));*/
select d.dept_no,group_concat(emp_no) from dept_emp d 
group by d.dept_no
/*
group_concat(X，Y)函数返回X的非null值的连接后的字符串。如果给出了参数Y，将会在每个X之间用Y作为分隔符。
如果省略了Y，“，”将作为默认的分隔符。每个元素连接的顺序是随机的。
*/

--------------------------------------------------------------------------------------------------------
/*
7.
获取Employees中的first_name，查询按照first_name最后两个字母，按照升序进行排列
CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`));
*/
select first_name from employees
order by substr(first_name,-2)
--或者
select first_name from employees
order by substr(first_name,length(first_name)-1,2);
/*
题考查 substr(X,Y,Z) 或 substr(X,Y) 函数的使用。其中X是要截取的字符串。
Y是字符串的起始位置（注意第一个字符的位置为1，而不为0），取值范围是±(1~length(X))，
当Y等于length(X)时，则截取最后一个字符；当Y等于负整数-n时，则从倒数第n个字符处截取。
Z是要截取字符串的长度，取值范围是正整数，若Z省略，则从Y处一直截取到字符串末尾；
若Z大于剩下的字符串长度，也是截取到字符串末尾为止。
*/
----------------------------------------------------------------------------------------
/*
8.
查找字符串'10,A,B' 中逗号','出现的次数cnt。
*/
SELECT (length("10,A,B")-length(replace("10,A,B",",","")))/length(",") AS cnt
/*
replace(s,a,b)在s中将a替换为b
本题把，替换为null串，然后使用length的结果相减
*/
---------------------------------------------------------------------------------------------
/*
9.
将employees表中的所有员工的last_name和first_name通过(')连接起来。(不支持concat，请用||实现)
CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`));
*/

select concat(last_name, '''', first_name) as name from employees; --Mysql
SELECT last_name || "'" || first_name AS name FROM employees;      --Sqlite

-------------------------------------------------------------------------------------------
/*
10.
请你写出更新语句，将所有获取奖金的员工当前的(salaries.to_date='9999-01-01')薪水增加10%。(emp_bonus里面的emp_no都是当前获奖的所有员工)
create table emp_bonus(
emp_no int not null,
btype smallint not null);
CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL, PRIMARY KEY (`emp_no`,`from_date`));
如：
INSERT INTO emp_bonus VALUES (10001,1);
INSERT INTO salaries VALUES(10001,85097,'2001-06-22','2002-06-22');
INSERT INTO salaries VALUES(10001,88958,'2002-06-22','9999-01-01');

*/
update salaries set salary = salary * 1.1 
where salaries.emp_no in (select emp_no from emp_bonus) 
and salaries.to_date = '9999-01-01'

-----------------------------------------------------------------------------------------------


















