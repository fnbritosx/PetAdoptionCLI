package src.model.repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class RegistrationPetRepository {
    private final List<String> responsesUser = new ArrayList<>();
    private List<String> questionsForm = new ArrayList<>();


    public File getFormFile() {
        return new File ("C:\\Users\\febne\\OneDrive\\Documentos\\PetAdoptionCLI\\core\\form\\form.txt");
    }

    public List<String> getQuestionsForm(File path) throws IOException {
        return questionsForm = Files.readAllLines(path.toPath());
    }

    public List<String> storeResponse(String response){
        responsesUser.add(response);

        return responsesUser;
    }
}
