package app.terminal;

import app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Terminal implements CommandLineRunner {

    private final PersonService personService;

    @Autowired
    public Terminal(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public void run(String... strings) throws Exception {

    }
}
