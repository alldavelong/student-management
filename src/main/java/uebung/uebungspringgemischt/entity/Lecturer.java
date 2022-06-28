package uebung.uebungspringgemischt.entity;

import javax.persistence.Entity;

@Entity
public class Lecturer extends Person {
    public Lecturer(int id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    public Lecturer() {}
}
