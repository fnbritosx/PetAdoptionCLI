package src.model.repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class RegistrationPetRepository {
    private final List<String> responsesUser = new ArrayList<>();
    private static final File pathForm = new File("C:\\Users\\febne\\OneDrive\\Documentos\\PetAdoptionCLI\\core\\form\\form.txt");

    public File getPathForm() {
        return pathForm;
    }

    public List<String> getQuestionsForm() throws IOException {
        return Files.readAllLines(pathForm.toPath());
    }

    public List<String> getListResponseUser() {
        return responsesUser;
    }

    public void saveResponse(String response) {
        responsesUser.add(response);
    }
}
