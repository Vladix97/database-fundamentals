package massdefect.repositories;

import massdefect.domains.entities.Anomaly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnomalyRepository extends JpaRepository<Anomaly, Long> {

    @Query(value = "SELECT a " +
            "FROM Anomaly AS a " +
            "INNER JOIN a.people AS v " +
            "GROUP BY a " +
            "ORDER BY COUNT(v) DESC")
    List<Anomaly> anomaliesOrderedByVictimsDesc();

    @Query(value = "SELECT a FROM Anomaly AS a")
    List<Anomaly> findAllAnomalies();
}
