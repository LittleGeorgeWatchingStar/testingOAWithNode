-- You are given a table, BST, containing two columns: N and P, where N represents the value of a node in Binary Tree, and P is the parent of N.
-- Write a query to find the node type of Binary Tree ordered by the value of the node. Output one of the following for each node:

-- Root: If node is root node.
-- Leaf: If node is leaf node.
-- Inner: If node is neither root nor leaf node.
/*
Enter your query here.
*/
select N,
    (
    CASE 
        WHEN P is NULL THEN 'Root'
        WHEN N in (SELECT P from BST) THEN 'Inner'
        ELSE 'Leaf'
    END)
 from BST Order by N;

SELECT a.N,
CASE WHEN b.N is NULL THEN 'Leaf'
WHEN a.P is NULL THEN 'Root'
ELSE 'Inner'
END
FROM BST a LEFT JOIN BST b
ON a.N = b.P
group by a.N
order by a.N;