package uebung.uebungspringgemischt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uebung.uebungspringgemischt.entity.Course;
import uebung.uebungspringgemischt.entity.Grade;
import uebung.uebungspringgemischt.entity.Student;
import uebung.uebungspringgemischt.persistence.MockData;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class RootController {

    @Autowired
    private MockData mockData;

    @GetMapping("/student")
    public Student getStudent(@RequestParam(value = "id") int studentId) {
        return mockData.getStudents().stream().filter(s -> s.getId() == studentId).collect(Collectors.toList()).get(0);
    }

    @GetMapping("/courses")
    public Set<Course> getCourses(
            @RequestParam(value = "student") int studentId,
            @RequestParam(value = "semester") int semester
    ) {
        return mockData.getStudents().stream().filter(s -> s.getId() == studentId).collect(Collectors.toList()).get(0)
                .getCourses().stream().filter(c -> c.getSemester() == semester).collect(Collectors.toSet());
    }

    @PostMapping("/grade")
    public Course setGrade(
            @RequestParam(value = "student") int studentId,
            @RequestParam(value = "course") int courseId,
            @RequestBody Integer grade
    ) {
        Course course = mockData.getStudents().stream().filter(s -> s.getId() == studentId).collect(Collectors.toList()).get(0)
                .getCourses().stream().filter(c -> c.getId() == courseId).collect(Collectors.toList()).get(0);
        course.addGrade(new Grade(grade));
        return course;
    }
}
