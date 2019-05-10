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
                        
#sql query 196
delete p1 from Person p1 inner join Person p2
where p1.Email = p2.Email and p1.Id > p2.Id
                        
#sql query 197
(A not good answer --> only faster than 9% around by using SUBDATE)                       
select w1.Id from Weather w1, Weather w2
where SUBDATE(w1.RecordDate , 1) = w2.RecordDate and w1.Temperature > w2.Temperature                        
(Another answer --> a better method with a result of over 73% around by using TO_DAYS)
select w1.Id from Weather w1, Weather w2
where TO_DAYS(w1.RecordDate) = TO_DAYS(w2.RecordDate)+ 1 and w1.Temperature > w2.Temperature
(Another answer --> a method with a result of over 56% around using DATEDIFF)
select w1.Id from Weather w1, Weather w2
where DATEDIFF(w1.RecordDate,w2.RecordDate) = 1 and w1.Temperature > w2.Temperature
 
#sql query 262
(the usage of count(*) is the same as sum(1),but count(*) is more efficient)
select t.Request_at Day, ROUND(sum((case when t.Status like 'cancelled%' then 1 else 0 end))/count(*),2) AS 'Cancellation Rate'
from Trips t
inner join Users u on u.Users_Id = t.Client_Id and u.Banned = 'No'
where t.Request_at between '2013-10-01' and '2013-10-03' group by t.Request_at

#sql query 595
select name, population, area
from World 
where area > 3000000 OR population > 25000000

#sql query 596
select class from courses 
group by class
having count(distinct student) >= 5
 
#sql query 601 
select distinct s1.*
from stadium s1, stadium s2, stadium s3
where s1.people >= 100 and s2.people >= 100 and s3.people >= 100
and 
(
    (s1.id + 1 = s2.id and s2.id + 1 = s3.id)
    OR
    (s1.id - 1 = s2.id and s2.id - 1 = s3.id)
    OR
    (s1.id + 1 = s2.id and s1.id - 1 = s3.id)
)
order by s1.id

#sql query 620
 (description <> equals to description !=)
select * 
from cinema
where description != 'boring' and  MOD(id, 2) = 1 
order by rating desc;
