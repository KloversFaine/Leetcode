#sql query
select A.FirstName , A.LastName , B.City , B.State
FROM Person AS A
LEFT JOIN Address AS B
ON A.PersonId = B.PersonId;
