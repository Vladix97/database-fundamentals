package app.serviceImpls;

import app.domains.AlbumRole;
import app.repositories.AlbumRoleRepository;
import app.services.AlbumRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumRoleServiceImpl implements AlbumRoleService {

    private final AlbumRoleRepository albumRoleRepository;

    @Autowired
    public AlbumRoleServiceImpl(AlbumRoleRepository albumRoleRepository) {
        this.albumRoleRepository = albumRoleRepository;
    }

    @Override
    public void persist(AlbumRole albumRole) {
        this.albumRoleRepository.save(albumRole);
    }
}
