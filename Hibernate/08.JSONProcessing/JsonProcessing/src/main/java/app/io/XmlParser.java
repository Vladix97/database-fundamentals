package app.io;

import com.sun.jmx.remote.internal.Unmarshal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

@Component
public class XmlParser {

    private final FileParser fileParser;

    private JAXBContext jaxbContext;

    @Autowired
    public XmlParser(FileParser fileParser) {
        this.fileParser = fileParser;
    }

    public <T> T importXml(Class<T> clazz, String filePath) throws IOException, JAXBException {
        this.jaxbContext = JAXBContext.newInstance(clazz);
        T object = null;

        try (
                InputStream inputStream = new FileInputStream(filePath);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))
        ) {
            Unmarshaller unmarshaller = this.jaxbContext.createUnmarshaller();
            object = (T) unmarshaller.unmarshal(bufferedReader);
        }

        return object;
    }

    public <T> void exportXML(T object, String filePath) throws JAXBException, IOException {
        this.jaxbContext = JAXBContext.newInstance(object.getClass());

        try (
                OutputStream outputStream = new FileOutputStream(filePath);
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        ) {
            Marshaller marshaller = this.jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(object, bufferedWriter);
        }
    }
}
