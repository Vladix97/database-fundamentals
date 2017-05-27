package app.serviceImpls;

import app.daos.WizardDepositDao;
import app.entities.WizardDeposit;
import app.services.WizardDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WizardDepositServiceImpl implements WizardDepositService {

    @Autowired
    private WizardDepositDao wizardDepositDao;

    @Override
    public void persist(WizardDeposit wizardDeposit) {
        this.wizardDepositDao.saveAndFlush(wizardDeposit);
    }


}
