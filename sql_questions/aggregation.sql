-- Query a count of the number of cities in CITY having a Population larger than 100000.
SELECT
    COUNT(ID)
FROM
    CITY
WHERE
    POPULATION > 100000;

-- Query the total population of all cities in CITY where District is California.
SELECT
    SUM(POPULATION)
FROM
    CITY
WHERE
    DISTRICT = 'California';

-- Query the difference between the maximum and minimum populations in CITY.
SELECT
    MAX(POPULATION) - MIN(POPULATION)
FROM
    CITY;

-- Samantha was tasked with calculating the average monthly salaries for all employees in the EMPLOYEES table, but did not realize her keyboard's 0 key was broken until after completing the calculation. She wants your help finding the difference between her miscalculation (using salaries with any zeros removed), and the actual average salary.
-- Write a query calculating the amount of error (i.e.:  average monthly salaries), and round it up to the next integer.
SELECT
    CAST(
        CEILING(
            (
                AVG(CAST(Salary AS Float)) - AVG(CAST(REPLACE(Salary, 0, '') AS Float))
            )
        ) AS INT
    )
FROM
    EMPLOYEES;

-- We define an employee's total earnings to be their monthly salary * months worked, and the maximum total earnings to be the maximum total earnings for any employee in the Employee table. Write a query to find the maximum total earnings for all employees as well as the total number of employees who have maximum total earnings. Then print these values as 2 space-separated integers.
select
    (salary * months) as earnings,
    count(*)
from
    employee
group by
    1
order by
    earnings desc
limit
    1;

-- Query the following two values from the STATION table:
-- The sum of all values in LAT_N rounded to a scale of 2 decimal places.
-- The sum of all values in LONG_W rounded to a scale of 2 decimal places.
select
    ROUND(SUM(LAT_N), 2),
    ROUND(SUM(LONG_W), 2)
from
    STATION;

-- Query the sum of Northern Latitudes (LAT_N) from STATION having values greater than 38.7880 and less than 137.2345. Truncate your answer to  decimal places.
SELECT
    ROUND(SUM(Lat_N), 4)
FROM
    STATION
WHERE
    Lat_N > 38.7880
    AND Lat_N < 137.2345;

-- Query the greatest value of the Northern Latitudes (LAT_N) from STATION that is less than 137.2345. Truncate your answer to 4 decimal places.
select
    truncate(max(lat_n), 4)
from
    station
where
    lat_n < 137.2345;

SELECT
    round(max(lat_n), 4)
FROM
    STATION
WHERE
    lat_n < 137.2345;

-- Query the Western Longitude (LONG_W) for the largest Northern Latitude (LAT_N) in STATION that is less than 137.2345. Round your answer to 4 decimal places.
select
    round(LONG_W, 4)
from
    station
where
    LAT_N < 137.2345
order by
    LAT_N desc
LIMIT
    1;

-- Query the smallest Northern Latitude (LAT_N) from STATION that is greater than 38.7780. Round your answer to 4 decimal places.
SELECT
    ROUND(LAT_N, 4)
FROM
    STATION
WHERE
    LAT_N > 38.7780
ORDER BY
    LAT_N ASC
LIMIT
    1;

-- P1 (a, b) P2 (c, d)
--  a happens to equal the minimum value in Northern Latitude (LAT_N in STATION).
--  b happens to equal the minimum value in Western Longitude (LONG_W in STATION).
--  c happens to equal the maximum value in Northern Latitude (LAT_N in STATION).
--  d happens to equal the maximum value in Western Longitude (LONG_W in STATION).
-- Query the Manhattan Distance between points p1 and p2 and round it to a scale of 4 decimal places.
select
    round(
        abs(min(lat_n) - max(lat_n)) + abs(min(long_w) - max(long_w)),
        4
    )
from
    station;

-- Query the Euclidean Distance between points P1 nad p2
SELECT
    ROUND(
        SQRT(
            POWER(MAX(LAT_N) - MIN(LAT_N), 2) + POWER(MAX(LONG_W) - MIN(LONG_W), 2)
        ),
        4
    )
FROM
    STATION;

-- A median is defined as a number separating the higher half of a data set from the lower half. Query the median of the Northern Latitudes (LAT_N) from STATION and round your answer to  decimal places.
Select
    round(S.LAT_N, 4) mediam
from
    station S
where
    (
        select
            count(Lat_N)
        from
            station
        where
            Lat_N < S.LAT_N
    ) = (
        select
            count(Lat_N)
        from
            station
        where
            Lat_N > S.LAT_N
    )