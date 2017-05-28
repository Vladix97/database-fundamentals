package app.serviceImpls;

import app.daos.DiagnoseDao;
import app.entities.Diagnose;
import app.services.DiagnoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiagnoseServiceImpl implements DiagnoseService{

    private final DiagnoseDao diagnoseDao;

    @Autowired
    public DiagnoseServiceImpl(DiagnoseDao diagnoseDao) {
        this.diagnoseDao = diagnoseDao;
    }

    @Override
    public void persist(Diagnose diagnose) {
        this.diagnoseDao.saveAndFlush(diagnose);
    }
}
