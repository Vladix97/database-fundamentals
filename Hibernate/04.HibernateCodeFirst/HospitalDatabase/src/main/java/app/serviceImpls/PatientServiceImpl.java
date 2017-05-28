package app.serviceImpls;

import app.daos.PatientDao;
import app.entities.Patient;
import app.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientDao patientDao;

    @Autowired
    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public void persist(Patient patient) {
        this.patientDao.saveAndFlush(patient);
    }
}
