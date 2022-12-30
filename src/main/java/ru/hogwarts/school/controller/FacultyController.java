package ru.hogwarts.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;


@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public Faculty addFaculty(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @GetMapping("{id}")
    public ResponseEntity<Faculty> getFacultyInfo(@PathVariable Long id) {
        Faculty faculty = facultyService.findFaculty(id);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @PutMapping
    public ResponseEntity<Faculty> editFaculty(@RequestBody Faculty faculty) {
        Faculty foundFaculty = facultyService.editFaculty(faculty);
        if (foundFaculty == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundFaculty);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Faculty> removeFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/colour")
    public ResponseEntity<Collection<Faculty>> findFaculties(@RequestParam String colour) {
        if (colour != null && !colour.isBlank()) {
            return ResponseEntity.ok(facultyService.findByColor(colour));
        }
        return ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping("/studentsOfFaculty")
    public ResponseEntity<Collection<Student>> findStudentsOfFaculty(@RequestParam Long id) {
        Collection<Student> students = facultyService.findStudentsOfFaculty(id);
        if (students.isEmpty()) {
            return ResponseEntity.ok(Collections.emptyList());
        }
        return ResponseEntity.ok(students);
    }

    @GetMapping("/Most-long-name-of-faculty")
    public ResponseEntity<Optional<String>> findMostLongNameOfFaculty() {
        Optional<String> name = facultyService.getMostLongNameOfFaculty();
        return ResponseEntity.ok(name);
    }
}
