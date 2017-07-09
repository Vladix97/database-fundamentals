package app.ios.interfaces;

import java.io.IOException;

public interface ConsoleIO {

    void write(String string);

    String read() throws IOException;
}
