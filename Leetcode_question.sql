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
