package uebung.uebungspringgemischt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import uebung.uebungspringgemischt.entity.Course;
import uebung.uebungspringgemischt.entity.Grade;
import uebung.uebungspringgemischt.entity.Student;
 import uebung.uebungspringgemischt.persistence.StudentJsonDataService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class RootController {

    @Autowired
    private StudentJsonDataService studentJsonDataService;

    @GetMapping("/students")
    public String getStudents(Model uiModel) {
        uiModel.addAttribute("students", studentJsonDataService.getStudents());
        return "students";
    }

    @GetMapping("/student")
    public String getStudent(@RequestParam(value = "id") int studentId, Model uiModel) {
        Student student = studentJsonDataService.getStudents().stream().filter(s -> s.getId() == studentId).collect(Collectors.toList()).get(0);
        uiModel.addAttribute("student",student);
        return "student";
    }

    @GetMapping("/courses")
    public String getCourses(
            @RequestParam(value = "student") int studentId,
            @RequestParam(value = "semester") int semester,
            Model uiModel
    ) {
        List<Course> courses = studentJsonDataService.getStudents().stream().filter(s -> s.getId() == studentId).collect(Collectors.toList()).get(0)
                .getCourses().stream().filter(c -> c.getSemester() == semester).collect(Collectors.toList());
        uiModel.addAttribute("courses", courses);
        uiModel.addAttribute("studentId", studentId);
        return "courses";
    }

    @PostMapping("/grade")
    public RedirectView setGrade(
            @RequestParam(value = "student") int studentId,
            @RequestParam(value = "course") int courseId,
            @RequestParam(value = "grade") Integer grade
    ) {
        Set<Student> students = studentJsonDataService.getStudents();
        Course course = students.stream().filter(s -> s.getId() == studentId).collect(Collectors.toList()).get(0)
                .getCourses().stream().filter(c -> c.getId() == courseId).collect(Collectors.toList()).get(0);
        course.addGrade(new Grade(grade));
        studentJsonDataService.saveStudents(students);
        return new RedirectView("/student?id=" + studentId);
    }
}
