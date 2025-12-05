package src.controller;

import exception.ResponseFormException;
import src.model.entity.Pet;
import src.model.repository.RegistrationPetRepository;
import src.model.service.RegistrationPetService;
import src.view.RegistrationPetView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class RegistrationPetController {
    private final RegistrationPetService registrationPetService;
    private final RegistrationPetView registrationPetView;
    private final RegistrationPetRepository registrationPetRepository;
    private final Pet pet;

    public RegistrationPetController() {
        this.registrationPetService = new RegistrationPetService();
        this.registrationPetView = new RegistrationPetView();
        this.registrationPetRepository = new RegistrationPetRepository();
        this.pet = new Pet();
    }

    private List<String> askAddress() {
        List<String> responses = new ArrayList<>();

        for (String question : registrationPetView.getSubQuestions()) {
            while (true) {
                registrationPetView.readerLineForm(question);
                try {
                    String response = null;

                    if (question.startsWith("i.")) {
                        response = registrationPetView.responseUser();
                        response = registrationPetService.validateHouseNumber(response);
                    }
                    if (question.startsWith("ii.")) {
                        response = registrationPetView.responseUser();
                        registrationPetService.validateRoad(response);
                    }
                    if (question.startsWith("iii.")) {
                        response = registrationPetView.responseUser();
                        registrationPetService.validateCity(response);
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
                response = registrationPetView.responseUser();
                registrationPetRepository.createdFile(response);
                pet.setName(registrationPetService.validateName(response));
                break;
            case 1:
                response = registrationPetView.responseUser();
                pet.setType(registrationPetService.validateType(response));
                break;
            case 2:
                response = registrationPetView.responseUser();
                pet.setSex(registrationPetService.validateSex(response));
                break;
            case 3:
                List<String> address = askAddress();
                pet.setHouseNumber(address.get(0));
                pet.setStreet(address.get(1));
                pet.setCity(address.get(2));
                break;
            case 4:
                response = registrationPetView.responseUser();
                pet.setAge((registrationPetService.validateAge(response)));
                break;
            case 5:
                response = registrationPetView.responseUser();
                pet.setWeight(registrationPetService.validateWeight(response));
                break;
            case 6:
                response = registrationPetView.responseUser();
                pet.setBreed(registrationPetService.validateBreed(response));
                break;
        }
    }

    public void start() throws IOException {
        int count = 0;

        for (String line : registrationPetRepository.getQuestionsForm()) {
            registrationPetView.readerLineForm(line);

            while (true) {
                try {
                    handleQuestion(count);
                    break;
                } catch (ResponseFormException e) {
                    System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
                }
            }
            count++;
        }
        registrationPetRepository.savePet(pet);

        System.out.println(pet);
    }
}


