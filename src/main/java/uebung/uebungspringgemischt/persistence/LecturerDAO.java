package uebung.uebungspringgemischt.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import uebung.uebungspringgemischt.entity.Lecturer;

public interface LecturerDAO extends JpaRepository<Lecturer, Integer> {
}
