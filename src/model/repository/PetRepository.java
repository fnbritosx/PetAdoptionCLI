package model.repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

public class PetRepository {
    private static final File pathForm = new File("C:\\Users\\14994165718\\Documents\\PetAdoptionCLI\\src\\model\\repository\\form\\form.txt");
    private static final File pathRegisteredPets = new File("C:\\Users\\14994165718\\Documents\\PetAdoptionCLI\\src\\model\\repository\\pets");
    private static final File dirAllPets = new File("C:\\Users\\14994165718\\Documents\\PetAdoptionCLI\\src\\model\\repository\\allpets");
    private static final File fileAllPets = new File(dirAllPets, "allPets.txt");

    public List<String> getQuestionsForm() throws IOException {
        return Files.readAllLines(pathForm.toPath());
    }

    public File createdFile(String petName) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
        String dateFormated = localDateTime.format(dateTimeFormatter);

        if (!pathRegisteredPets.exists()) {
            pathRegisteredPets.mkdirs();
        }

        File file = new File(pathRegisteredPets + "\\" + dateFormated + "-" + petName.toUpperCase().replaceAll("\\s+", "") + ".txt");

        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao criar o arquivo " + file.getAbsolutePath(), e);
        }
        return file;
    }

    public void writePetToFile(File file, String response) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(response);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao escrever no arquivo " + file.getAbsolutePath(), e);
        }
    }

    public void writeAllPetToFile(String response) throws IOException {

        if (!dirAllPets.exists()){
            dirAllPets.mkdirs();
        }

        if (!fileAllPets.exists()){
            try {
                fileAllPets.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        long totalLinesFile;

        try(Stream<String> lines = Files.lines(fileAllPets.toPath())){
            totalLinesFile = lines.count() + 1;
        }

        try (FileWriter fileWriter = new FileWriter(fileAllPets, true)) {
            fileWriter.write(totalLinesFile + " - " + response + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("Erro ao escrever no arquivo " + dirAllPets.getAbsolutePath(), e);
        }
    }
}

