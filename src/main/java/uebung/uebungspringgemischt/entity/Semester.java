package uebung.uebungspringgemischt.entity;

import java.util.List;

public class Semester {
    private int id;
    private List<Course> courses;

    public Semester(int id, List<Course> courses) {
        this.id = id;
        this.courses = courses;
    }

    public Semester() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
