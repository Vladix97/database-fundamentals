package app.daos;

import app.entities.Visitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface VisitationDao extends JpaRepository<Visitation, Long> {
}
