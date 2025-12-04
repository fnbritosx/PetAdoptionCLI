package src.controller;

import exception.ResponseFormException;
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

    public RegistrationPetController() {
        this.registrationPetService = new RegistrationPetService();
        this.registrationPetView = new RegistrationPetView();
        this.registrationPetRepository = new RegistrationPetRepository();
    }

    private List<String> askAddress() {
        List<String> responses = new ArrayList<>();

        for (String question : registrationPetView.getSubQuestions()) {
            while (true) {
                registrationPetView.readerLineForm(question);
                try {
                    String response = registrationPetView.responseUser();

                    if (question.startsWith("i.")) {
                        response = registrationPetService.validateHouseNumber(response);
                    }
                    if (question.startsWith("ii.")) {
                        registrationPetService.validateRoad(response);
                    }
                    if (question.startsWith("iii.")) {
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


    public void start() throws IOException {
        int count = 0;
        String response = null;

        for (String lines : registrationPetRepository.getQuestionsForm()) {

            while (true) {
                registrationPetView.readerLineForm(lines);
                try {


                    switch (count) {
                        case 0:
                            response = registrationPetView.responseUser();
                            response = registrationPetService.validateName(response);
                            registrationPetRepository.saveResponse(response);
                            break;
                        case 1:
                            response = registrationPetView.responseUser();
                            registrationPetService.validateType(response);
                            registrationPetRepository.saveResponse(response);
                            break;
                        case 2:
                            response = registrationPetView.responseUser();
                            registrationPetService.validateSex(response);
                            registrationPetRepository.saveResponse(response);
                            break;

                        case 3:
                            List<String> addressResponses = askAddress();
                            for (String r : addressResponses) {
                                registrationPetRepository.saveResponse(r);
                            }
                            break;
                    }
                    break;
                } catch (ResponseFormException e) {
                    System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
                }
            }
            count++;
        }
        System.out.println(registrationPetRepository.getListResponseUser());
    }
}


