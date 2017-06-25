package massdefect.parsers.interfaces;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface FileParser {

    <T> T read(Class<T> objectClass, String filePath) throws IOException, JAXBException;

    <T> void write(T object, String filePath) throws IOException, JAXBException;
}
