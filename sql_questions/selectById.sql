SELECT * FROM CITY WHERE ID = 1661

SELECT * FROM CITY WHERE COUNTRYCODE = "JPN"

SELECT NAME FROM CITY WHERE COUNTRYCODE = "JPN"

SELECT CITY, STATE FROM STATION

-- Find unique CITY entries with even id number in the table.
SELECT DISTINCT(CITY) FROM STATION WHERE MOD(ID, 2) = 0;

-- Find the difference between the total number of CITY entries in the table and the number of distinct CITY entries in the table.
SELECT (COUNT(CITY) - COUNT(DISTINCT CITY)) FROM STATION;

-- Query the two cities in STATION with the shortest and longest CITY names, as well as their respective lengths (i.e.: number of characters in the name). If there is more than one smallest or largest city, choose the one that comes first when ordered alphabetically.
select city, length(city) from station
order by length(city),city asc
limit 1;
select city, length(city) from station
order by length(city) desc
limit 1;

-- Query the list of CITY names starting with vowels (i.e., a, e, i, o, or u) from STATION. Your result cannot contain duplicates.
SELECT DISTINCT city FROM station WHERE LOWER(SUBSTR(CITY,1,1)) in ('a','e','i','o','u');

-- Query the list of CITY names ending with vowels (a, e, i, o, u) from STATION. Your result cannot contain duplicates.
SELECT DISTINCT CITY FROM STATION WHERE LOWER(SUBSTR(CITY,LENGTH(CITY),1)) IN ('a','e','i','o','u');

-- Query the list of CITY names from STATION which have vowels (i.e., a, e, i, o, and u) as both their first and last characters. Your result cannot contain duplicates.
SELECT DISTINCT CITY 
FROM STATION 
WHERE LOWER(SUBSTR(CITY,LENGTH(CITY),1)) IN ('a','e','i','o','u') 
AND LOWER(SUBSTR(CITY,1,1)) IN ('a','e','i','o','u');

-- Query the list of CITY names from STATION that do not start with vowels. Your result cannot contain duplicates.
SELECT DISTINCT city FROM station WHERE LOWER(SUBSTR(CITY,1,1)) not in ('a','e','i','o','u');

-- Query the list of CITY names from STATION that either do not start with vowels or do not end with vowels. Your result cannot contain duplicates.
SELECT DISTINCT CITY 
FROM STATION 
WHERE LOWER(SUBSTR(CITY,LENGTH(CITY),1)) NOT IN ('a','e','i','o','u') 
OR LOWER(SUBSTR(CITY,1,1)) NOT IN ('a','e','i','o','u');