package uebung.uebungspringgemischt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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

    @GetMapping(value = {"/", "/login"})
    public String login() {
        return "login";
    }

    @GetMapping("/admin")
    public String getStudents(Model uiModel) {
        uiModel.addAttribute("students", studentJsonDataService.getStudents());
        return "students";
    }

    @GetMapping("/me")
    public String getStudent(Model uiModel, @AuthenticationPrincipal UserDetails user) {
        uiModel.addAttribute("student",studentJsonDataService.getStudentByMatriculationNumber(user.getUsername()));
        return "student";
    }

    @GetMapping("/courses")
    public String getCourses(
            @RequestParam(value = "semester") int semesterId,
            Model uiModel,
            @AuthenticationPrincipal UserDetails user
    ) {
        Student student = studentJsonDataService.getStudentByMatriculationNumber(user.getUsername());
        List<Course> courses = student
                .getSemesters().stream().filter(s -> s.getId() == semesterId)
                .collect(Collectors.toList()).get(0)
                .getCourses();
        uiModel.addAttribute("courses", courses);
        uiModel.addAttribute("student", student);
        uiModel.addAttribute("semesterId", semesterId);
        return "courses";
    }

    @PostMapping("/grade")
    public RedirectView setGrade(
            @RequestParam(value = "semester") int semesterId,
            @RequestParam(value = "course") int courseId,
            @RequestParam(value = "grade") Integer grade,
            @AuthenticationPrincipal UserDetails user,
            RedirectAttributes redirectAttributes
    ) {
        int studentId = studentJsonDataService.getStudentByMatriculationNumber(user.getUsername()).getId();
        Set<Student> students = studentJsonDataService.getStudents();
        Course course = students.stream().filter(s -> s.getId() == studentId).collect(Collectors.toList()).get(0)
                .getSemesters().stream().filter(s -> s.getId() == semesterId).collect(Collectors.toList()).get(0)
                .getCourses().stream().filter(c -> c.getId() == courseId).collect(Collectors.toList()).get(0);
        try {
            course.addGrade(new Grade(grade));
        } catch (TooManyGradesException e) {
            redirectAttributes.addFlashAttribute("maxGradesError",
                    "Hinzufügen nicht möglich. " + e.getMessage());
        }
        studentJsonDataService.saveStudents(students);
        return new RedirectView("/courses?student=" + studentId + "&semester=" + semesterId);
    }
}
