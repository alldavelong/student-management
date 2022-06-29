package uebung.uebungspringgemischt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import uebung.uebungspringgemischt.entity.Grade;
import uebung.uebungspringgemischt.entity.Student;
import uebung.uebungspringgemischt.entity.StudentSemester;
import uebung.uebungspringgemischt.entity.StudentSemesterCourse;
import uebung.uebungspringgemischt.persistence.GradeDAO;
import uebung.uebungspringgemischt.persistence.StudentDAO;
import uebung.uebungspringgemischt.persistence.StudentSemesterCourseDAO;
import uebung.uebungspringgemischt.persistence.StudentSemesterDAO;

import java.util.List;
import java.util.Optional;

@Controller
public class RootController {

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private StudentSemesterCourseDAO studentSemesterCourseDAO;

    @Autowired
    private StudentSemesterDAO studentSemesterDAO;

    @Autowired
    private GradeDAO gradeDAO;

    @GetMapping(value = {"/", "/login"})
    public String login() {
        return "login";
    }

    @GetMapping("/admin")
    public String getStudents(Model uiModel) {
        uiModel.addAttribute("students", studentDAO.findAll());
        return "students";
    }

    @GetMapping("/me")
    public String getStudent(Model uiModel, @AuthenticationPrincipal UserDetails user) {
        Optional<Student> optionalStudent = studentDAO.findByMatriculationNumber(user.getUsername());
        if (optionalStudent.isEmpty()) {
            throw new IllegalArgumentException();
        }

        uiModel.addAttribute("student", optionalStudent.get());
        return "student";
    }

    @GetMapping("/courses")
    public String getCourses(
            @RequestParam(value = "studentSemester") int studentSemesterId,
            Model uiModel,
            @AuthenticationPrincipal UserDetails user
    ) {
        Optional<StudentSemester> optionalStudentSemester = studentSemesterDAO.findById(studentSemesterId);
        if (optionalStudentSemester.isEmpty()) {
            throw new IllegalArgumentException();
        }

        uiModel.addAttribute("semester", optionalStudentSemester.get());
        return "courses";
    }

    @PostMapping("/grade")
    public RedirectView setGrade(
            @RequestParam(value = "course") int courseId,
            @RequestParam(value = "semester") int semesterId,
            @RequestParam(value = "grade") Integer grade,
            @AuthenticationPrincipal UserDetails user,
            RedirectAttributes redirectAttributes
    ) {
        Optional<StudentSemesterCourse> optionalStudentSemesterCourse = studentSemesterCourseDAO.findById(courseId);
        if (optionalStudentSemesterCourse.isEmpty()) {
            throw new IllegalArgumentException();
        }
        StudentSemesterCourse studentSemesterCourse = optionalStudentSemesterCourse.get();

        try {
            Grade newGrade = new Grade(grade, studentSemesterCourse);
            gradeDAO.save(newGrade);
        } catch (TooManyGradesException | GradeOutOfRangeException e) {
            redirectAttributes.addFlashAttribute("gradeAddingError",
                    "Hinzufügen nicht möglich. " + e.getMessage());
        }

        boolean isAdmin = user.getAuthorities().stream().anyMatch(ga -> ga.getAuthority().equals("ROLE_ADMIN"));
        if (isAdmin) {
            return new RedirectView("/admin");
        }

        return new RedirectView("/courses?studentSemester=" + semesterId);
    }
}
