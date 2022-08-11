-- Query the Name of any student in STUDENTS who scored higher than  Marks. Order your output by the last three characters of each name. If two or more students both have names ending in the same last three characters (i.e.: Bobby, Robby, etc.), secondary sort them by ascending ID.
select name
from students 
where marks>75
order by SUBSTR(name, LENGTH(name)-2, 3) , id asc;

-- Write a query that prints a list of employee names (i.e.: the name attribute) from the Employee table in alphabetical order.
select name
from employee 
order by name asc;

-- Write a query that prints a list of employee names (i.e.: the name attribute) for employees in Employee having a salary greater than 2000 per month who have been employees for less than  months. Sort your result by ascending employee_id.
select name
from employee
where salary > 2000 AND months < 10
order by employee_id asc;