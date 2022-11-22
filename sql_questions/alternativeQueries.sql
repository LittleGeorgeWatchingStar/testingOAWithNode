-- P(R) represents a pattern drawn by Julia in R rows. The following pattern represents P(5):
-- * * * * *
-- * * * * 
-- * * * 
-- * * 
-- * 
set @number = 21;
select repeat('* ', @number := @number - 1) 
from information_schema.tables;

-- P(R) represents a pattern drawn by Julia in R rows. The following pattern represents P(5):
-- * 
-- * * 
-- * * * 
-- * * * * 
-- * * * * *
set @row := 0;
select repeat('* ', @row := @row + 1) 
from information_schema.tables 
where @row < 20