package src.model.repository;

import src.model.entity.Pet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RegistrationPetRepository {
    private final List<Pet> pets = new ArrayList<>();
    private static final File pathForm = new File("C:\\Users\\febne\\OneDrive\\Documentos\\PetAdoptionCLI\\core\\form\\form.txt");

    public File getPathForm() {
        return pathForm;
    }

    public List<String> getQuestionsForm() throws IOException {
        return Files.readAllLines(pathForm.toPath());
    }

    public List<Pet> getListResponseUser() {
        return pets;
    }

    public void savePet(Pet pet) {
        pets.add(pet);
    }

        public File createdFile(String petName) {
            File finalFile = null;

            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
            String dateFormated = localDateTime.format(dateTimeFormatter);

            finalFile = new File(pathForm + "\\" + dateFormated + "-" + petName.toUpperCase().replaceAll("\\s+", "") + ".txt");

            return finalFile;
        }
}

