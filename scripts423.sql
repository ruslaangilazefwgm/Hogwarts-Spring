SELECT student.name, student.age, faculty.name
from student
         inner join faculty ON student.faculty_id = faculty.id;

SELECT student.name, student.age, faculty.name
from student
         right join faculty ON student.faculty_id = faculty.id;