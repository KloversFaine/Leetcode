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

#sql query 181
(A not good answer --> only faster than 6% around)
select Name AS Employee
from Employee E1 
where E1.Salary > (
    select Salary from Employee E2 
    where E1.managerId = E2.Id
)
(Another answer --> a better method with a result of over 66% around) 
 # Write your MySQL query statement below
select Worker.Name AS Employee
from Employee As Worker , Employee As Manager
where Worker.Salary > Manager.Salary and Worker.ManagerId = Manager.Id
 
#sql query 182
(A not good answer --> only faster than 19% around)
select distinct P1.Email 
from Person AS P1 , Person AS P2
where P1.Email = P2.Email and P1.Id != P2.Id
(Another answer --> a better method with a result of over 70% around)
(make use of group by && having)
select Email
from Person 
group by Email
having count(Email)>1

#sql query 183
(A not good answer --> only faster than 16% around) 
select C1.Name AS Customers
from Customers C1
left join Orders O1 on C1.Id = O1.CustomerId
where CustomerId is null
(Another answer --> a better method with a result of over 87% around)
select name AS Customers
from Customers
where Id not in
(
select C.Id from Customers AS C , Orders
where C.Id = Orders.CustomerId
)

#sql query 184
 (An acceptable answer for me)
select D1.Name AS Department , E1.Name AS Employee , E1.Salary 
from Employee AS E1 join Department AS D1 on E1.DepartmentId = D1.Id
where (D1.Id , E1.Salary) in
(select DepartmentId , max(Salary) 
 from (select * from Employee order by Salary desc) AS Query
 group by DepartmentId)
 
#sql query 185
select D1.Name AS Department , E1.Name AS Employee , E1.Salary 
from Employee AS E1 join Department AS D1 on E1.DepartmentId = D1.Id
where 3 > (select count(distinct(E2.Salary)) from Employee E2 
           where E1.DepartmentId = E2.DepartmentId and E2.Salary > E1.Salary
          )
Order by DepartmentId ASC 
