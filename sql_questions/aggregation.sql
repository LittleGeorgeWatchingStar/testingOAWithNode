-- Query a count of the number of cities in CITY having a Population larger than 100000.
SELECT COUNT(ID) FROM CITY WHERE POPULATION > 100000;

-- Query the total population of all cities in CITY where District is California.
SELECT SUM(POPULATION) FROM CITY WHERE DISTRICT = 'California';

-- Query the difference between the maximum and minimum populations in CITY.
SELECT MAX(POPULATION) - MIN(POPULATION)
FROM CITY;

-- Samantha was tasked with calculating the average monthly salaries for all employees in the EMPLOYEES table, but did not realize her keyboard's 0 key was broken until after completing the calculation. She wants your help finding the difference between her miscalculation (using salaries with any zeros removed), and the actual average salary.
-- Write a query calculating the amount of error (i.e.:  average monthly salaries), and round it up to the next integer.
SELECT CAST(CEILING((AVG(CAST(Salary AS Float)) - AVG(CAST(REPLACE(Salary, 0, '')AS Float)))) AS INT)
FROM EMPLOYEES;

-- We define an employee's total earnings to be their monthly salary * months worked, and the maximum total earnings to be the maximum total earnings for any employee in the Employee table. Write a query to find the maximum total earnings for all employees as well as the total number of employees who have maximum total earnings. Then print these values as 2 space-separated integers.
select (salary * months)as earnings ,count(*) from employee group by 1 order by earnings desc limit 1;