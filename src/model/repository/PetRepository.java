package src.model.repository;

import src.model.entity.Pet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PetRepository {
    private final List<Pet> registeredPets = new ArrayList<>();
    private static final File pathForm = new File("C:\\Users\\14994165718\\Documents\\PetAdoptionCLI\\src\\model\\repository\\form\\form.txt");
    private static final File pathRegisteredPets = new File("C:\\Users\\14994165718\\Documents\\PetAdoptionCLI\\src\\model\\repository\\pets");

    public List<String> getQuestionsForm() throws IOException {
        return Files.readAllLines(pathForm.toPath());
    }

    public List<Pet> savePet(Pet pet) {
        registeredPets.add(pet);
        return registeredPets;
    }

    public File createdFile(String petName) throws IOException {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
        String dateFormated = localDateTime.format(dateTimeFormatter);

        if (!pathRegisteredPets.exists()) {
            pathRegisteredPets.mkdirs();
        }

        File file = new File(pathRegisteredPets + "\\" + dateFormated + "-" + petName.toUpperCase().replaceAll("\\s+", "") + ".txt");

        file.createNewFile();
        return file;
    }

    public void writePetToFile(File file, String response) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(response);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao escrever no arquivo " + file.getAbsolutePath(), e);
        }
    }
}

