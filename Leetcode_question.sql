#sql query 175
select A.FirstName , A.LastName , B.City , B.State
FROM Person AS A
LEFT JOIN Address AS B
ON A.PersonId = B.PersonId;

#sql query 176
select MAX(Salary) AS SecondHighestSalary from Employee
where Salary < (select MAX(Salary) from Employee);

#sql query 177
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
DECLARE M INT;
SET M = N-1;
  RETURN (
      # Write your MySQL query statement below.
      select distinct Salary from Employee 
      order by Salary DESC
      LIMIT M,1
  );
END

#sql query 178
select Score , 
(
select Count(*)
From(
    select distinct Score s 
    from Scores
    )AS tmp
    where s >= Score 
)AS Rank
From Scores
ORDER BY Score DESC

#sql query 180
#make use of SQL join to achieve the goal
select distinct l1.Num ConsecutiveNums 
from Logs l1
left join Logs l2 on l1.Id = l2.Id - 1 
left join Logs l3 on l2.Id = l3.Id - 1
Where l1.Num = l2.Num and l2.Num = l3.Num

