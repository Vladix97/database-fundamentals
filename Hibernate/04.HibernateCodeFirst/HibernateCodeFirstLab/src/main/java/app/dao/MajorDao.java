package app.dao;

import app.entities.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by vladix on 5/26/17.
 */

@Repository
@Transactional
public interface MajorDao extends JpaRepository<Major, Long> {

    void deleteBy(String name);
}
