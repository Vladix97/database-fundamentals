package app.ios.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileIO {

    String read(String filePath) throws IOException;

    void write(String content, String filePath) throws IOException;
}
