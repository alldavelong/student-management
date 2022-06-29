package uebung.uebungspringgemischt.entity;

import uebung.uebungspringgemischt.controller.GradeOutOfRangeException;
import uebung.uebungspringgemischt.controller.TooManyGradesException;

import javax.persistence.*;

@Entity
public class Grade {
    public static final int LOWEST_GRADE = 1;
    public static final int HIGHEST_GRADE = 5;
    public static final int MAX_GRADES_PER_COURSE = 3;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int grade;
    @ManyToOne
    @JoinColumn(name = "student_semester_to_course_id")
    private StudentSemesterCourse studentSemesterCourse;

    public Grade(int grade, StudentSemesterCourse studentSemesterCourse) throws GradeOutOfRangeException, TooManyGradesException {
        this.studentSemesterCourse = studentSemesterCourse;
        if (studentSemesterCourse.getGrades().size() >= Grade.MAX_GRADES_PER_COURSE) {
            throw new TooManyGradesException();
        }
        setGrade(grade);
    }

    public Grade() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) throws GradeOutOfRangeException {
        if (grade < LOWEST_GRADE || grade > HIGHEST_GRADE) {
            throw new GradeOutOfRangeException();
        }
        this.grade = grade;
    }

    public StudentSemesterCourse getStudentSemesterCourse() {
        return studentSemesterCourse;
    }

    public void setStudentSemesterCourse(StudentSemesterCourse studentSemesterCourse) {
        this.studentSemesterCourse = studentSemesterCourse;
    }
}
