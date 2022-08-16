-- Write a query identifying the type of each record in the TRIANGLES table using its three side lengths. Output one of the following statements for each record in the table:
-- Equilateral: It's a triangle with  sides of equal length.
-- Isosceles: It's a triangle with  sides of equal length.
-- Scalene: It's a triangle with  sides of differing lengths.
-- Not A Triangle: The given values of A, B, and C don't form a triangle.
SELECT
    CASE
        WHEN A + B > C
        AND B + C > A
        AND A + C > B THEN CASE
            WHEN A = B
            AND B = C THEN 'Equilateral'
            WHEN A = B
            OR B = C
            OR A = C THEN 'Isosceles'
            ELSE 'Scalene'
        END
        ELSE 'Not A Triangle'
    END
FROM
    TRIANGLES;

-- Pivot the Occupation column in OCCUPATIONS so that each Name is sorted alphabetically and displayed underneath its corresponding Occupation.
-- The output column headers should be Doctor, Professor, Singer, and Actor, respectively.
-- The first column is an alphabetically ordered list of Doctor names.
-- The second column is an alphabetically ordered list of Professor names.
-- The third column is an alphabetically ordered list of Singer names.
-- The fourth column is an alphabetically ordered list of Actor names.
-- The empty cell data for columns with less than the maximum number of names per occupation (in this case, the Professor and Actor columns) are filled with NULL values.
set
    @r1 = 0,
    @r2 = 0,
    @r3 = 0,
    @r4 = 0;

select
    min(Doctor),
    min(Professor),
    min(Singer),
    min(Actor)
from
(
        select
            case
                when Occupation = 'Doctor' then (@r1 := @r1 + 1)
                when Occupation = 'Professor' then (@r2 := @r2 + 1)
                when Occupation = 'Singer' then (@r3 := @r3 + 1)
                when Occupation = 'Actor' then (@r4 := @r4 + 1)
            end as RowNumber,
            case
                when Occupation = 'Doctor' then Name
            end as Doctor,
            case
                when Occupation = 'Professor' then Name
            end as Professor,
            case
                when Occupation = 'Singer' then Name
            end as Singer,
            case
                when Occupation = 'Actor' then Name
            end as Actor
        from
            OCCUPATIONS
        order by
            Name
    ) temp
group by
    RowNumber;

-- Generate the following two result sets:

-- 1 Query an alphabetically ordered list of all names in OCCUPATIONS, 
-- immediately followed by the first letter of each profession as a parenthetical (i.e.: enclosed in parentheses). 
-- For example: AnActorName(A), ADoctorName(D), AProfessorName(P), and ASingerName(S).
-- 2 Query the number of ocurrences of each occupation in OCCUPATIONS. Sort the occurrences in ascending order, 
-- and output them in the following format:
-- There are a total of [occupation_count] [occupation]s.
select concat(Name, '(' , Substring(Occupation, 1, 1), ')') from OCCUPATIONS order by Name asc;
select concat(Name, '(' , LEFT(Occupation, 1), ')') from OCCUPATIONS order by Name asc;

select concat('There are a total of ', count(Occupation), ' ', Lower(Occupation), 's.') from OCCUPATIONS group by Occupation order by count(Occupation), Occupation asc;


-- You are given a table, BST, containing two columns: N and P, where N represents the value of a node in Binary Tree, and P is the parent of N.
SELECT CASE
    WHEN P IS NULL THEN CONCAT(N, ' Root')
    WHEN N IN (SELECT DISTINCT P FROM BST) THEN CONCAT(N, ' Inner')
    ELSE CONCAT(N, ' Leaf')
    END
FROM BST
ORDER BY N ASC;
