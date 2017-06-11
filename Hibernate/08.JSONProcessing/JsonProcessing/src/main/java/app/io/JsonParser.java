package app.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JsonParser {

    private final FileParser fileParser;

    private Gson gson;

    @Autowired
    public JsonParser(FileParser fileParser) {
        this.gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
        this.fileParser = fileParser;
    }

    public <T> T importJson(Class<T> clazz, String filePath) throws IOException {
        T object = null;
        String file = this.fileParser.readFile(filePath);
        object = this.gson.fromJson(file, clazz);

        return object;
    }

    public <T> void exportJson(T object, String filePath) throws IOException {
        String content = this.gson.toJson(object);
        this.fileParser.writeFile(filePath, content);
    }
}
