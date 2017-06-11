package app.io;

import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class FileParser {

    public String readFile(String filePath) throws IOException {
        StringBuilder fileContent = new StringBuilder();
        try (
                InputStream inputStream = getClass().getResourceAsStream(filePath);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fileContent.append(line);
            }
        }

        return fileContent.toString();
    }

    public void writeFile(String filePath, String content) throws IOException {
        try (
                OutputStream outputStream = new FileOutputStream(filePath);
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream))
        ) {
            bufferedWriter.write(content);
        }
    }
}
