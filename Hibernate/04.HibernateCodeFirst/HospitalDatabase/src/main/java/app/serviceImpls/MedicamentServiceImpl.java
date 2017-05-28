package app.serviceImpls;

import app.daos.MedicamentDao;
import app.entities.Medicament;
import app.services.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicamentServiceImpl implements MedicamentService {

    private final MedicamentDao medicamentDao;

    @Autowired
    public MedicamentServiceImpl(MedicamentDao medicamentDao) {
        this.medicamentDao = medicamentDao;
    }

    @Override
    public void persist(Medicament medicament) {
        this.medicamentDao.saveAndFlush(medicament);
    }
}
