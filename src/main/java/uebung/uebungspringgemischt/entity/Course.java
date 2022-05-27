package uebung.uebungspringgemischt.entity;

import java.util.List;

public class Course {
    private int id;
    private String name;
    private int semester;
    private Lecturer lecturer;
    private List<Grade> grades;

    public Course(int id, String name, int semester, Lecturer lecturer, List<Grade> grades) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.lecturer = lecturer;
        this.grades = grades;
    }

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

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
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

    public boolean hasGrade() {
        return !this.grades.isEmpty();
    }

    public void addGrade(Grade grade) {
        this.grades.add(grade);
    }
}
