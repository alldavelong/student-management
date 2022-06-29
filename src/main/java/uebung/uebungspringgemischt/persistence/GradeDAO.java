package uebung.uebungspringgemischt.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import uebung.uebungspringgemischt.entity.Grade;

public interface GradeDAO extends JpaRepository<Grade, Integer> {
}
