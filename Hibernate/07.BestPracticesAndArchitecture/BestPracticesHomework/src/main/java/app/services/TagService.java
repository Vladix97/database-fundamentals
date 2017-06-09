package app.services;

import app.domains.Tag;

public interface TagService {

    void persist(Tag tag);

    Tag findByName(String name);
}
