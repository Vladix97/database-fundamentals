package app.serviceImpls;

import app.daos.LabelDao;
import app.entities.labels.ClassicLabel;
import app.services.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabelServiceImpl implements LabelService {

    private final LabelDao labelDao;

    @Autowired
    public LabelServiceImpl(LabelDao labelDao) {
        this.labelDao = labelDao;
    }

    @Override
    public void persist(ClassicLabel label) {
        this.labelDao.saveAndFlush(label);
    }

    @Override
    public ClassicLabel findBy(long id) {
        return this.labelDao.findOne(id);
    }
}
