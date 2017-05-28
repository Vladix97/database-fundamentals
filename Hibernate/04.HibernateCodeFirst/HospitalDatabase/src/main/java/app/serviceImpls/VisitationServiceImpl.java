package app.serviceImpls;

import app.daos.VisitationDao;
import app.entities.Visitation;
import app.services.VisitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitationServiceImpl implements VisitationService {

    private final VisitationDao visitationDao;

    @Autowired
    public VisitationServiceImpl(VisitationDao visitationDao) {
        this.visitationDao = visitationDao;
    }

    @Override
    public void persist(Visitation visitation) {
        this.visitationDao.saveAndFlush(visitation);
    }
}
