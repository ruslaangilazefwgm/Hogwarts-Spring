package ru.hogwarts.school.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import ru.hogwarts.school.repositories.StudentRepository;


import java.util.Collection;
import java.util.List;


@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    Logger logger = LoggerFactory.getLogger(StudentService.class);

    public Student createStudent(Student student) {
        return studentRepository.save(student);

    }

    public Student findStudent(long id) {
        logger.info("Was invoked method for finding students by id");
        return studentRepository.findById(id).get();
    }

    public Student editStudent(Student student) {
        logger.info("Was invoked method for editing students");
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        logger.info("Was invoked method for removing students");
        studentRepository.deleteById(id);
    }

    public Collection<Student> findByAgeBetween(int min, int max) {
        logger.info("Was invoked method for finding students by range of age");
        return studentRepository.findByAgeBetween(min, max);
    }

    public Faculty findFacultyOfStudent(Long id) {
        logger.info("Was invoked method for finding faculty of student");
        Student student = studentRepository.findById(id).get();
        return student.getFaculty();
    }

    public Integer getStudentCount() {
        logger.info("Was invoked method for getting count of students");
        return studentRepository.getCountStudents();
    }

    public Integer getAverageAge() {
        logger.info("Was invoked method for getting average age");
        return studentRepository.getAverageAge();
    }

    public Collection<Student> getLastStudents() {
        logger.info("Was invoked method for getting five last students");
        return studentRepository.getLastStudents();
    }

}
