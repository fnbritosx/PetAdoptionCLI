package src.model.repository;

import src.model.entity.Pet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PetRepository {
    private final List<Pet> pets = new ArrayList<>();
    private static final File pathForm = new File("C:\\Users\\febne\\OneDrive\\Documentos\\PetAdoptionCLI\\core\\form\\form.txt");
    private static final File pathRegisteredPets = new File("C:\\Users\\14994165718\\Documents\\PetAdoptionCLI\\src\\model\\repository\\registeredPets");

    public List<String> getQuestionsForm() throws IOException {
        return Files.readAllLines(pathForm.toPath());
    }


    public void savePet(Pet pet) {
        pets.add(pet);
    }

    public void createdFile(String petName) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
        String dateFormated = localDateTime.format(dateTimeFormatter);

        File finalFile = new File(pathRegisteredPets + "\\" + dateFormated + "-" + petName.toUpperCase().replaceAll("\\s+", "") + ".txt");
    }
}

