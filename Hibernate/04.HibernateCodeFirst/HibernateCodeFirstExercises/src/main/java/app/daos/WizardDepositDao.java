package app.daos;

import app.entities.WizardDeposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface WizardDepositDao extends JpaRepository<WizardDeposit, Long> {
}

