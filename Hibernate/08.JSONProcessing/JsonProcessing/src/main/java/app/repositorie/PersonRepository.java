package app.repositorie;

import app.domain.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PersonRepository extends JpaRepository<Person, Long> {
}
