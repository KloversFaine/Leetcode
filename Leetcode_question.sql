#sql query 175
select A.FirstName , A.LastName , B.City , B.State
FROM Person AS A
LEFT JOIN Address AS B
ON A.PersonId = B.PersonId;

#sql query 176
select MAX(Salary) AS SecondHighestSalary from Employee
where Salary < (select MAX(Salary) from Employee);
