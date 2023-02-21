-- Occupations
-- Pivot the Occupation column in OCCUPATIONS so that each Name is sorted alphabetically and displayed underneath its corresponding Occupation. The output column headers should be Doctor, Professor, Singer, and Actor, respectively.

-- Note: Print NULL when there are no more names corresponding to an occupation.

-- Input Format

-- The OCCUPATIONS table is described as follows:
/*
Enter your query here.
*/
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


    /*
Enter your query here.
*/
select 
Doctor,Professor,Singer,Actor 
from( 
    (select name as Doctor, row_number()over(order by name)as n 
     from occupations where occupation = 'Doctor')d 
    right join 
    (select name as Professor, row_number()over(order by name) as n from occupations where occupation = 'Professor')p 
    on d.n = p.n 
    left join 
    (select name as Singer, row_number()over(order by name) 
     as n from occupations where occupation = 'Singer')s on p.n=s.n 
    left join 
    (select name as Actor, row_number()over(order by name) 
     as n 
     from occupations where occupation = 'Actor')a 
    on p.n=a.n)