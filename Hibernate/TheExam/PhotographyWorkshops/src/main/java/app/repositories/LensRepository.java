package app.repositories;

import app.domains.entities.Lens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface LensRepository extends JpaRepository<Lens, Long> {

    Set<Lens> findByIdIn(Set<Long> ids);
}
