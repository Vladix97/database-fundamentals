package massdefect.parsers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import massdefect.ios.interfaces.FileIO;
import massdefect.parsers.interfaces.FileParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component(value = "JSONParser")
public class JSONParser implements FileParser {

    private Gson gson;

    private final FileIO fileIO;

    @Autowired
    public JSONParser(FileIO fileIO) {
        this.gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
        this.fileIO = fileIO;
    }

    @Override
    public <T> T read(Class<T> objectClass, String filePath) throws IOException {
        String jsonContent = this.fileIO.read(filePath);
        T object = this.gson.fromJson(jsonContent, objectClass);
        return object;
    }

    @Override
    public <T> void write(T object, String filePath) throws IOException {
        String jsonContent = this.gson.toJson(object);
        this.fileIO.write(jsonContent, filePath);
    }
}
