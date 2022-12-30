SELECT *
from student;

SELECT *
from student
where age between 12 and 14;

SELECT name
from student;

SELECT *
from student
where name like '%о%';

SELECT *
from student
where age < student.id;

SELECT *
from  student
order by age;