package app.io;

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


    @Autowired
    public XmlParser(FileParser fileParser) {
        this.fileParser = fileParser;
    }

    public <T> T importXml(Class<T> clazz, String filePath) throws IOException, JAXBException {
        T object = null;

        File file = new File(filePath);
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        object = (T) unmarshaller.unmarshal(file);

        return object;
    }

    public <T> void writeXML(T object, String filePath) throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        OutputStream outputStream = new FileOutputStream(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        marshaller.marshal(object, bufferedWriter);
    }
}
