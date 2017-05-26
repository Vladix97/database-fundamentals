package app.serviceImpl;

import app.dao.MajorDao;
import app.entities.Major;
import app.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vladix on 5/26/17.
 */

@Service
public class MajorServiceImpl implements MajorService {

    @Autowired
    private MajorDao majorDao;

    @Override
    public void create(Major major) {
        this.majorDao.saveAndFlush(major);
    }

    @Override
    public void deleteByName(String name) {
        this.majorDao.deleteBy(name);
    }
}
