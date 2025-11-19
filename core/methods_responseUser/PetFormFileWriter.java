package core.methods_responseUser;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PetFormFileWriter {
    public static final String BASE_PATH = "C:\\Users\\febne\\OneDrive\\Documentos\\PetAdoptionCLI\\core\\form\\";
    public static File finalFile = null;

    public static File createdFile(String petName) {
        try {
            new File(BASE_PATH).mkdirs();

            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
            String dateFormated = localDateTime.format(dateTimeFormatter);

            finalFile = new File(BASE_PATH + "\\" + dateFormated + "-" + petName.toUpperCase().replaceAll("\\s+", "") + ".txt");

            if (!finalFile.exists()) {
                finalFile.createNewFile();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return finalFile;
    }

    public static void writerFile(File responseUser, String response) throws IOException {
        try (FileWriter fileWriter = new FileWriter(responseUser, true)) {
            fileWriter.write(response + "\n");
        }
    }
}

