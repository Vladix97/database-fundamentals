package app.serviceImpls;

import app.domains.Album;
import app.repositories.AlbumRepository;
import app.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;

    @Autowired
    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public void persist(Album album) {
        this.albumRepository.save(album);
    }

    @Override
    public Album findByName(String name) {
        return this.albumRepository.findByName(name);
    }
}
