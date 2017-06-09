package app.serviceImpls;

import app.domains.Tag;
import app.repositories.TagRepository;
import app.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public void persist(Tag tag) {
        this.tagRepository.save(tag);
    }

    @Override
    public Tag findByName(String name) {
        return this.tagRepository.findByName(name);
    }
}
