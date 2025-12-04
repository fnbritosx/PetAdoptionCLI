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
    private final List<Pet> responsesUser = new ArrayList<>();
    private static final File pathForm = new File("C:\\Users\\14994165718\\Documents\\PetAdoptionCLI\\core\\form\\form.txt");

    public File getPathForm() {
        return pathForm;
    }

    public List<String> getQuestionsForm() throws IOException {
        return Files.readAllLines(pathForm.toPath());
    }

    public List<Pet> getListResponseUser() {
        return responsesUser;
    }

    public void saveResponse(Pet pet) {
        responsesUser.add(pet);
    }

        public static File createdFile(String petName) throws IOException {
            File finalFile = null;

            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
            String dateFormated = localDateTime.format(dateTimeFormatter);

            finalFile = new File(pathForm + "\\" + dateFormated + "-" + petName.toUpperCase().replaceAll("\\s+", "") + ".txt");

            if (!finalFile.exists()) {
                finalFile.createNewFile();
            }
            return finalFile;
        }
}

