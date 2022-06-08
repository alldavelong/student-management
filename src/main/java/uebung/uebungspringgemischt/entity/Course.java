package uebung.uebungspringgemischt.entity;

import uebung.uebungspringgemischt.controller.TooManyGradesException;

import java.util.List;

public class Course {
    private int id;
    private String name;
    private Lecturer lecturer;
    private List<Grade> grades;
    private static final int MAX_GRADES = 3;

    public Course(int id, String name, Lecturer lecturer, List<Grade> grades) {
        this.id = id;
        this.name = name;
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

    public void addGrade(Grade grade) throws TooManyGradesException {
        if (this.grades.size() >= MAX_GRADES) {
            throw new TooManyGradesException();
        }
        this.grades.add(grade);
    }
}
