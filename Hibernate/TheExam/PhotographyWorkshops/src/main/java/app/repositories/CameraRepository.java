package app.repositories;

import app.domains.entities.cameras.AbstractCamera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CameraRepository extends JpaRepository<AbstractCamera, Long> {
}
