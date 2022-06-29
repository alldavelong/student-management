package uebung.uebungspringgemischt.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Lecturer extends Person {
    @OneToMany(mappedBy = "lecturer")
    private List<Course> courses;

    public Lecturer() {}

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
