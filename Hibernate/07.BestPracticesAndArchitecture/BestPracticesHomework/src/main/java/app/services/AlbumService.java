package app.services;

import app.domains.Album;

public interface AlbumService {

    void persist(Album album);

    Album findByName(String name);
}
