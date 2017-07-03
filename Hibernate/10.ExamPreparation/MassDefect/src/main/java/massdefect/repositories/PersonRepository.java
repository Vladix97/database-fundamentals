package massdefect.repositories;

import massdefect.domains.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByName(String name);

    @Query(value = "SELECT p FROM Person as p LEFT JOIN p.anomalies AS a WHERE a IS NULL")
    List<Person> nonVictims();
}
