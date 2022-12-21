package ru.hogwarts.school.service;


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

    public Student createStudent(Student student) {
        return studentRepository.save(student);

    }

    public Student findStudent(long id) {
        return studentRepository.findById(id).get();
    }

    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
         studentRepository.deleteById(id);
    }

    public Collection<Student> findByAgeBetween(int min, int max) {
        return studentRepository.findByAgeBetween(min, max);
    }

    public Faculty findFacultyOfStudent(Long id) {
        Student student = studentRepository.findById(id).get();
        return student.getFaculty();
    }

    public Integer getStudentCount() {
        return studentRepository.getCountStudents();
    }

    public Integer getAverageAge() {
        return studentRepository.getAverageAge();
    }

    public Collection<Student> getLastStudents() {
        return studentRepository.getLastStudents();
    }

}
