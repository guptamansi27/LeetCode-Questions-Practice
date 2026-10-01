# Write your MySQL query statement below
-- select product_name, year,price
-- from sales,product where sales.product_id=product.product_id;

#Here, inner join- An SQL INNER JOIN combines rows from two or more database tables based on a shared column, returning only the rows that have matching values in both tables.

select p.product_name, s.year,s.price
from sales s join product p 
on s.product_id=p.product_id;