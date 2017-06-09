package app.core;


import app.ios.Reader;
import app.ios.Writer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Engine implements CommandLineRunner {

    private final CommandDispatcher commandDispatcher;

    private final Reader reader;

    private final Writer writer;

    @Autowired
    public Engine(CommandDispatcher commandDispatcher, Reader reader, Writer writer) {
        this.commandDispatcher = commandDispatcher;
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void run(String... strings) throws Exception {

        System.out.println("### LIVE ###");
        System.out.println("### LIVE ###");
        System.out.println("### LIVE ###");

        while (true) {
            try {
                String input = this.reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                String result = this.commandDispatcher
                        .dispatchCommand(commandName, data)
                        .execute();
                this.writer.writeLine(result);
            } catch (Exception e) {
                this.writer.writeLine(e.getMessage());
            }
        }
    }
}

