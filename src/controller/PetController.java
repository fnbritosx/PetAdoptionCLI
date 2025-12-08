package src.controller;

import exception.ResponseFormException;
import src.model.entity.Pet;
import src.model.repository.PetRepository;
import src.model.service.PetService;
import src.view.PetView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PetController {
    private final PetService petService;
    private final PetView petView;
    private final PetRepository petRepository;
    private final Pet pet;

    public PetController() {
        this.petService = new PetService();
        this.petView = new PetView();
        this.petRepository = new PetRepository();
        this.pet = new Pet();
    }

    private List<String> askAddress() {
        List<String> responses = new ArrayList<>();

        for (String question : petView.getSubQuestions()) {
            while (true) {
                petView.readerLineForm(question);
                try {
                    String response = null;

                    if (question.startsWith("i.")) {
                        response = petView.responseUser();
                        response = petService.validateHouseNumber(response);
                    }
                    if (question.startsWith("ii.")) {
                        response = petView.responseUser();
                        response = petService.validateRoad(response);
                    }
                    if (question.startsWith("iii.")) {
                        response = petView.responseUser();
                        petService.validateCity(response);
                    }

                    responses.add(response);
                    break;

                } catch (ResponseFormException e) {
                    System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
                }
            }
        }
        return responses;
    }

    private void handleQuestion(int count) throws ResponseFormException {
        String response;
        switch (count) {
            case 0:
                response = petView.responseUser();
                petRepository.createdFile(response);
                pet.setName(petService.validateName(response));
                break;
            case 1:
                response = petView.responseUser();
                pet.setType(petService.validateType(response));
                break;
            case 2:
                response = petView.responseUser();
                pet.setSex(petService.validateSex(response));
                break;
            case 3:
                List<String> address = askAddress();
                pet.setHouseNumber(address.get(0));
                pet.setStreet(address.get(1));
                pet.setCity(address.get(2));
                break;
            case 4:
                response = petView.responseUser();
                pet.setAge((petService.validateAge(response)));
                break;
            case 5:
                response = petView.responseUser();
                pet.setWeight(petService.validateWeight(response));
                break;
            case 6:
                response = petView.responseUser();
                pet.setBreed(petService.validateBreed(response));
                break;
        }
    }

    public void start() throws IOException {
        int count = 0;

        for (String line : petRepository.getQuestionsForm()) {

            while (true) {
                petView.readerLineForm(line);
                try {
                    handleQuestion(count);
                    break;
                } catch (ResponseFormException e) {
                    System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
                }
            }
            count++;
        }
        petRepository.savePet(pet);

        System.out.println(pet);
    }
}


