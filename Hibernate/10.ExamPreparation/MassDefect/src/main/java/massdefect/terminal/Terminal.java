package massdefect.terminal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Terminal implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("** LIVE ***");
        System.out.println("** LIVE ***");
        System.out.println("** LIVE ***");
    }
}
