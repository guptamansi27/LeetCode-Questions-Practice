# Write your MySQL query statement below
select unique_id,name from 
Employees left outer join EmployeeUNI on
(employees.id=employeeUNI.id);