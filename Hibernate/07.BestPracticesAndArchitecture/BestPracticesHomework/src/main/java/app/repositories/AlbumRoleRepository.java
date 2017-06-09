package app.repositories;

import app.domains.AlbumRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRoleRepository extends CrudRepository<AlbumRole, Integer>{
}
