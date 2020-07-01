/* 1.
https://www.nowcoder.com/practice/32c53d06443346f4a2f2ca733c19660c?tpId=82&&tqId=29762&rp=1&ru=/ta/sql&qru=/ta/sql/question-ranking
题目描述
获取所有非manager的员工emp_no
CREATE TABLE `dept_manager` (
`dept_no` char(4) NOT NULL,
`emp_no` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`dept_no`));
CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`));
*/
select e.emp_no from employees e 
where e.emp_no not in (
    select m.emp_no from dept_manager m 
	);
	
-----------------------------------------------------------
/*2.
https://www.nowcoder.com/practice/ae51e6d057c94f6d891735a48d1c2397?tpId=82&tags=&title=&diffculty=0&judgeStatus=0&rp=1&ru=/ta/sql&qru=/ta/sql/question-ranking
找出所有员工当前(to_date='9999-01-01')具体的薪水salary情况，对于相同的薪水只显示一次,并按照逆序显示
CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));
*/

--法一
select salary from salaries
where to_date = '9999-01-01' 
group by salary 
order by salary desc
-- 法二
select distinct salary from salaries
where to_date = '9999-01-01'
order by salary desc
-----------------------------------
/*3.
https://www.nowcoder.com/practice/23142e7a23e4480781a3b978b5e0f33a?tpId=82&tags=&title=&diffculty=0&judgeStatus=0&rp=1&ru=%2Fta%2Fsql&qru=%2Fta%2Fsql%2Fquestion-ranking
查找所有员工入职时候的薪水情况，给出emp_no以及salary， 并按照emp_no进行逆序(请注意，一个员工可能有多次涨薪的情况)
CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`));
CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));
*/
select e.emp_no, s.salary from employees e 
inner join salaries s on e.emp_no = s.emp_no
group by s.emp_no having min(s.from_date)
order by e.emp_no desc

----------------------------------------------
/*4.
https://www.nowcoder.com/practice/dbfafafb2ee2482aa390645abd4463bf?tpId=82&tags=&title=&diffculty=0&judgeStatus=0&rp=1&ru=/ta/sql&qru=/ta/sql/question-ranking
题目描述
查找所有员工的last_name和first_name以及对应部门编号dept_no，也包括暂时没有分配具体部门的员工(请注意输出描述里各个列的前后顺序)
CREATE TABLE `dept_emp` (
`emp_no` int(11) NOT NULL,
`dept_no` char(4) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`dept_no`));
CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`));*/

select e.last_name, e.first_name, d.dept_no from employees e 
left join dept_emp d on e.emp_no = d.emp_no;
--------------------------------------------------------------------------------
/* 5.
https://www.nowcoder.com/practice/c63c5b54d86e4c6d880e4834bfd70c3b?tpId=82&tags=&title=&diffculty=0&judgeStatus=0&rp=1&ru=%2Fta%2Fsql&qru=%2Fta%2Fsql%2Fquestion-ranking
查找各个部门当前(dept_manager.to_date='9999-01-01')领导当前(salaries.to_date='9999-01-01')薪水详情以及其对应部门编号dept_no
(注:请以salaries表为主表进行查询，输出结果以salaries.emp_no升序排序，并且请注意输出结果里面dept_no列是最后一列)
CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL, -- '员工编号',
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));
CREATE TABLE `dept_manager` (
`dept_no` char(4) NOT NULL, -- '部门编号'
`emp_no` int(11) NOT NULL, --  '员工编号'
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`dept_no`));*/
select s.*,m.dept_no from salaries s
inner join dept_manager m on s.emp_no = m.emp_no
where s.to_date = '9999-01-01'
and m.to_date = '9999-01-01'
group by m.dept_no
order by s.emp_no asc

---------------------------------------------
/* 6.
查找入职员工时间排名倒数第三的员工所有信息，为了减轻入门难度，目前所有的数据里员工入职的日期都不是同一天
CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`));
*/
select * from employees 
order by hire_date desc limit 2,1
--limit 的第一个参数表示偏移，从0开始，第二个参数表示取几行数据
--------------------------------------------
/* 7.
https://www.nowcoder.com/practice/e3cf1171f6cc426bac85fd4ffa786594?tpId=82&tags=&title=&diffculty=0&judgeStatus=0&rp=1&ru=/ta/sql&qru=/ta/sql/question-ranking
对于employees表中，输出first_name排名(按first_name升序排序)为奇数的first_name
CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`));*/
select e1.first_name from employees e1 where
(SELECT count(*) FROM employees e2
WHERE e1.first_name >=e2.first_name)%2=1;
