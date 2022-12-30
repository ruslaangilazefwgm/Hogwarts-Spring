package ru.hogwarts.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;


import java.util.Collection;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findByAgeBetween(int min, int max);

    @Query(value = "SELECT COUNT(*) FROM student", nativeQuery = true)
    Integer getCountStudents();

    @Query(value = "SELECT  AVG(age) FROM student", nativeQuery = true)
    Integer getAverageAge();

    @Query(value = "SELECT * FROM student  order by id DESC LIMIT 5  ", nativeQuery = true)
    Collection<Student> getLastStudents();

    @Query(value = "SELECT name FROM student", nativeQuery = true)
    Collection<String> getAllStudents();

}
