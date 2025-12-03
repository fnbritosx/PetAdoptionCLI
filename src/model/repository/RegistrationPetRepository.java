package src.model.repository;

import src.model.entity.Pet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class RegistrationPetRepository {
    private final List<String> responsesUser = new ArrayList<>();
    private static final File pathForm = new File("C:\\Users\\14994165718\\Documents\\PetAdoptionCLI\\core\\form\\form.txt");
    private final List<String> subQuestions = List.of(
            "Número da casa:",
            "Rua:",
            "Cidade:"
    );

    public List<String> getSubQuestions(){
        return subQuestions;
    }

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
