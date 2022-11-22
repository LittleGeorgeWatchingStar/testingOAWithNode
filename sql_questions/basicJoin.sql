-- Given the CITY and COUNTRY tables, query the sum of the populations of all cities where the CONTINENT is 'Asia'.
select
    sum(city.population)
from
    city
    inner join country on city.countrycode = country.code
where
    country.continent = 'Asia';

select
    sum(city.population)
from
    city
    left join country on city.countrycode = country.code
where
    country.continent = 'Asia';

-- Given the CITY and COUNTRY tables, query the names of all cities where the CONTINENT is 'Africa'.
-- Note: CITY.CountryCode and COUNTRY.Code are matching key columns.
select
    city.name
from
    city
    left join country on city.countrycode = country.code
where
    country.continent = 'Africa';

-- Given the CITY and COUNTRY tables, query the names of all the continents (COUNTRY.Continent) 
-- and their respective average city populations (CITY.Population) rounded down to the nearest integer.
-- Note: CITY.CountryCode and COUNTRY.Code are matching key columns.
SELECT
    COUNTRY.CONTINENT,
    FLOOR(AVG(CITY.POPULATION))
FROM
    CITY
    INNER JOIN COUNTRY ON CITY.COUNTRYCODE = COUNTRY.CODE
GROUP BY
    COUNTRY.CONTINENT;

-- Ketty gives Eve a task to generate a report containing three columns: Name, Grade and Mark. 
-- Ketty doesn't want the NAMES of those students who received a grade lower than 8. 
-- The report must be in descending order by grade -- i.e. higher grades are entered first. 
-- If there is more than one student with the same grade (8-10) assigned to them, 
-- order those particular students by their name alphabetically. 
-- Finally, if the grade is lower than 8, use "NULL" as their name and list them by their grades in descending order. 
-- If there is more than one student with the same grade (1-7) assigned to them, 
-- order those particular students by their marks in ascending order.
SELECT IF(GRADE < 8, NULL, NAME), GRADE, MARKS
FROM STUDENTS JOIN GRADES
WHERE MARKS BETWEEN MIN_MARK AND MAX_MARK
ORDER BY GRADE DESC, NAME;

-- Julia just finished conducting a coding contest, and she needs your help assembling the leaderboard! 
-- Write a query to print the respective hacker_id and name of hackers who achieved full scores for more than one challenge. 
-- Order your output in descending order by the total number of challenges in which the hacker earned a full score. 
-- If more than one hacker received full scores in same number of challenges, then sort them by ascending hacker_id.

-- Hackers: The hacker_id is the id of the hacker, and name is the name of the hacker.

-- Difficulty: The difficult_level is the level of difficulty of the challenge, and score is the score of the challenge for the difficulty level. 

-- Challenges: The challenge_id is the id of the challenge, the hacker_id is the id of the hacker who created the challenge, and difficulty_level is the level of difficulty of the challenge.

-- Submissions: The submission_id is the id of the submission, hacker_id is the id of the hacker who made the submission, challenge_id is the id of the challenge that the submission belongs to, and score is the score of the submission. 

select h.hacker_id, h.name
from submissions s
inner join challenges c
on s.challenge_id = c.challenge_id
inner join difficulty d
on c.difficulty_level = d.difficulty_level 
inner join hackers h
on s.hacker_id = h.hacker_id
where s.score = d.score and c.difficulty_level = d.difficulty_level
group by h.hacker_id, h.name
having count(s.hacker_id) > 1
order by count(s.hacker_id) desc, s.hacker_id asc

-- You did such a great job helping Julia with her last coding contest challenge that she wants you to work on this one, too!

-- The total score of a hacker is the sum of their maximum scores for all of the challenges. Write a query to print the hacker_id, name, and total score of the hackers ordered by the descending score. If more than one hacker achieved the same total score, then sort the result by ascending hacker_id. Exclude all hackers with a total score of 0 from your result.

select h.hacker_id, name, sum(score) as total_score
from
hackers as h inner join
/* find max_score*/
(select hacker_id,  max(score) as score from submissions group by challenge_id, hacker_id) max_score

on h.hacker_id=max_score.hacker_id
group by h.hacker_id, name

/* don't accept hackers with total_score=0 */
having total_score > 0

/* finally order as required */
order by total_score desc, h.hacker_id