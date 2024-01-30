package org.masonord.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.masonord.model.Tickets;
import java.io.*;
import java.nio.file.Files;

public class FileUtil {
    private static final String FILE_NAME = "results.txt";
    private static final String DEFAULT_PATH = "src/main/resources/tickets.json";

    public static void writeToFile(String content) throws IOException {
        File f = new File(FILE_NAME);

        if (!f.exists()) {
            Files.createFile(f.toPath());
        }

        FileWriter fw = new FileWriter(FILE_NAME, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);
        bw.newLine();
        bw.close();
    }

    public static Tickets readFromTicketFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(DEFAULT_PATH);

        return objectMapper.readValue(file, Tickets.class);
    }
}
