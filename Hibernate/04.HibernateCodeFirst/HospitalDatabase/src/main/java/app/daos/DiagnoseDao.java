package app.daos;

import app.entities.Diagnose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface DiagnoseDao extends JpaRepository<Diagnose, Long> {
}
