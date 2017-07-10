package app.repositories;

import app.domains.entities.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkshopRepository extends JpaRepository<Workshop, Long> {
}
