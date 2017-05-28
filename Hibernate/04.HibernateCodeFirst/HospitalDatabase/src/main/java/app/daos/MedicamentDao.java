package app.daos;

import app.entities.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MedicamentDao extends JpaRepository<Medicament, Long> {
}
