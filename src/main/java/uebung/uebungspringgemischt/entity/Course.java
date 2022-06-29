package uebung.uebungspringgemischt.entity;

import uebung.uebungspringgemischt.controller.TooManyGradesException;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {
    public static final int MAX_GRADES = 3;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "lecturer_id")
    private Lecturer lecturer;
    @OneToMany(mappedBy = "course") // TODO: ändert sich auch mit Dreieck student_semester_course
    private List<Grade> grades;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Semester semester;

    public Course() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public boolean hasGrade() {
        return !this.grades.isEmpty();
    }

    public void addGrade(Grade grade) throws TooManyGradesException {
        if (this.grades.size() >= MAX_GRADES) {
            throw new TooManyGradesException();
        }
        this.grades.add(grade);
    }
}
