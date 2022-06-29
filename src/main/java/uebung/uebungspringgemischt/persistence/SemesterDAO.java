package uebung.uebungspringgemischt.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import uebung.uebungspringgemischt.entity.Semester;

public interface SemesterDAO extends JpaRepository<Semester, Integer> {
}
