package app.serviceImpls;

import app.domains.Picture;
import app.repositories.PictureRepository;
import app.services.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public void persist(Picture picture) {
        this.pictureRepository.save(picture);
    }
}
