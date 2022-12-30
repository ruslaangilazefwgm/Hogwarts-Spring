package ru.hogwarts.school.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import ru.hogwarts.school.repositories.StudentRepository;


import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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

    public List<String> getAllStudentsName() {
        Collection<String> students = studentRepository.getAllStudents();
        Predicate<String> fn;
        fn = (str) -> {
            if (str.charAt(0) == 'Г')
                return true;
            return false;
        };
        Stream<String> studentStream = students.stream();
        Stream<String> stream = studentStream
                .filter(fn)
                .sorted()
                .map(String::toUpperCase);
        return stream.collect(Collectors.toList());
    }

    public Double getAverageAgeWithStream() {
        Double age = studentRepository.findAll().stream().collect(Collectors.averagingInt(Student::getAge));
        return age;
    }

    public void getAllStudentsWithThreads() {
        List<Student> list = studentRepository.findAll();
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        new Thread(() -> {
            System.out.println(list.get(2));
            System.out.println(list.get(3));
        }).start();
        new Thread(() -> {
            System.out.println(list.get(4));
            System.out.println(list.get(5));
        }).start();
    }
    public void getAllStudentsWithSynhronisedThreads() {
        List<Student> list = studentRepository.findAll();
        System.out.println("original: " + list);
        synhronisedThread(list.get(0));
        synhronisedThread(list.get(1));
        new Thread(() -> {
            synhronisedThread(list.get(2));
            synhronisedThread(list.get(3));
        }).start();
        new Thread(() -> {
            synhronisedThread(list.get(4));
            synhronisedThread(list.get(5));
        }).start();

    }
    public synchronized void synhronisedThread(Student student) {
        System.out.println(student);
    }

}
