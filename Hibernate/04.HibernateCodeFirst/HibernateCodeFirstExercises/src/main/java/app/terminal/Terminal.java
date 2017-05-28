package app.terminal;

import app.entities.User;
import app.entities.WizardDeposit;
import app.services.UserService;
import app.services.WizardDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.util.Calendar;
import java.util.Date;

@Component
public class Terminal implements CommandLineRunner {

    private final WizardDepositService wizardDepositService;

    private final UserService userService;

    @Autowired
    public Terminal(WizardDepositService wizardDepositService, UserService userService) {
        this.wizardDepositService = wizardDepositService;
        this.userService = userService;
    }

    @Override
    public void run(String... strings) throws Exception {
        WizardDeposit wizardDeposit = new WizardDeposit();
        wizardDeposit.setFirstName("Albus");
        wizardDeposit.setLastName("Dumbledore");
        wizardDeposit.setAge(150);
        wizardDeposit.setMagicWandCreator("Antoich Pevell");
        wizardDeposit.setMagicWandSize(15);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, Calendar.NOVEMBER, 20);
        wizardDeposit.setDepositStartDate(calendar.getTime());
        calendar.set(2020, Calendar.NOVEMBER, 20);
        wizardDeposit.setDepositExpirationDate(calendar.getTime());
        wizardDeposit.setDepositAmount(2000.24);
        wizardDeposit.setDepositCharge(0.2);
        wizardDeposit.setDepositExpired(false);

        this.wizardDepositService.persist(wizardDeposit);

        // ########################################################3
        // ########################################################3
        // ########################################################3

        User user = new User();
        user.setUsername("root");
        user.setPassword("Aa#242dsa34");
        user.setEmail("pesho@abv.bg");

        File picture = new File("res/pic2.jpg");
        byte[] pictureBytes = new byte[(int) picture.length()];
        FileInputStream fis = new FileInputStream(picture);
        fis.read(pictureBytes);
        fis.close();
        user.setProfilePicture(pictureBytes);

        user.setRegisteredOn(new Date());
        user.setLastTimeLoggedIn(new Date());
        user.setAge(12);
        user.setDeleted(false);

        this.userService.persist(user);

    }
}
