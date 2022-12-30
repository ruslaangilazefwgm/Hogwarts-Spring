package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.FacultyRepository;

import java.util.*;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;
    Logger logger = LoggerFactory.getLogger(FacultyService.class);

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        logger.info("Was invoked method for creating faculties");
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) {
        logger.info("Was invoked method for finding faculties");
        return facultyRepository.findById(id).get();
    }

    public Faculty editFaculty(Faculty faculty) {
        logger.info("Was invoked method for editing faculties");
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
        logger.info("Was invoked method for removing faculties");
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> findByColor(String colour) {
        logger.info("Was invoked method for finding faculties by colour");
        return facultyRepository.findByColour(colour);
    }

    public Collection<Student> findStudentsOfFaculty(Long id) {
        logger.info("Was invoked method for finding students of faculty");
        Faculty faculty = facultyRepository.findById(id).get();
        return faculty.getStudents();
    }

    public Optional<String> getMostLongNameOfFaculty() {
        List<String> list = facultyRepository.findAll()
                .stream().map(Faculty::getName).toList();
        Optional<String> name = list.stream().max(Comparator.comparing(String::length));
        return name;
    }
}
