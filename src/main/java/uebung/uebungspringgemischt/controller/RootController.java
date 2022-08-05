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
import uebung.uebungspringgemischt.entity.*;
import uebung.uebungspringgemischt.persistence.*;

import java.util.Optional;

@Controller
public class RootController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private StudentSemesterCourseDAO studentSemesterCourseDAO;

    @Autowired
    private StudentSemesterDAO studentSemesterDAO;

    @Autowired
    private GradeDAO gradeDAO;

    private boolean isUserAdmin(UserDetails user) {
        return user.getAuthorities().stream().anyMatch(ga -> ga.getAuthority().equals("ROLE_ADMIN"));
    }

    private Student retrieveStudent(UserDetails user) {
        Optional<User> optionalUser = userDAO.findByUsername(user.getUsername());
        if (optionalUser.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return optionalUser.get().getStudent();
    }

    @GetMapping(value = { "/login"})
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public RedirectView redirectRoot(@AuthenticationPrincipal UserDetails user) {
        if (isUserAdmin(user)) {
            return new RedirectView("/admin");
        }
        return new RedirectView("/me");
    }

    @GetMapping("/admin")
    public String getStudents(Model uiModel) {
        uiModel.addAttribute("students", studentDAO.findAll());
        return "students";
    }

    @GetMapping("/me")
    public String getStudent(Model uiModel, @AuthenticationPrincipal UserDetails user) {
        uiModel.addAttribute("student", retrieveStudent(user));
        return "student";
    }

    @GetMapping("/courses")
    public String getCourses(
            @RequestParam(value = "semesterSeason") String semesterSeason,
            @RequestParam(value = "semesterStartYear") int semesterStartYear,
            Model uiModel,
            @AuthenticationPrincipal UserDetails user
    ) {

        Optional<StudentSemester> optionalStudentSemester = studentSemesterDAO.findByStudentAndSemester(
                retrieveStudent(user),
                semesterSeason, semesterStartYear
        );
        if (optionalStudentSemester.isEmpty()) {
            throw new IllegalArgumentException();
        }

        uiModel.addAttribute("semester", optionalStudentSemester.get());
        return "courses";
    }

    @PostMapping("/grade")
    public RedirectView setGrade(
            @RequestParam(value = "course") int courseId,
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

        if (isUserAdmin(user)) {
            return new RedirectView("/admin");
        }

        Semester s = studentSemesterCourse.getStudentSemester().getSemester();
        return new RedirectView("/courses?semesterSeason=" + s.getSeason() + "&semesterStartYear=" + s.getStartYear());
    }
}
