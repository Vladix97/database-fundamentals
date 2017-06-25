package massdefect.ios;

import massdefect.ios.interfaces.ConsoleIO;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class ConsoleIOImpl implements ConsoleIO {

    private BufferedReader reader;

    public ConsoleIOImpl() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void write(String string) {
        System.out.println(string);
    }

    @Override
    public String read() throws IOException {
        return this.reader.readLine();
    }
}
