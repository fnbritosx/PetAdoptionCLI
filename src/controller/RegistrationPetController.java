package src.controller;

import exception.ResponseFormException;
import src.model.repository.RegistrationPetRepository;
import src.model.service.RegistrationPetService;
import src.view.RegistrationPetView;

import java.io.IOException;


public class RegistrationPetController {
    private final RegistrationPetService registrationPetService;
    private final RegistrationPetView registrationPetView;
    private final RegistrationPetRepository registrationPetRepository;

    public RegistrationPetController() {
        this.registrationPetService = new RegistrationPetService();
        this.registrationPetView = new RegistrationPetView();
        this.registrationPetRepository = new RegistrationPetRepository();
    }

    private void askAddress() {
        for (String question : registrationPetRepository.getSubQuestions()) {
            registrationPetView.readerLineForm(question);

            while (true) {
                try {
                    String resposta = registrationPetView.responseUser();
                    registrationPetRepository.saveResponse(resposta);
                    break;
                } catch (ResponseFormException e) {
                    System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
                }
            }
        }
    }

    public void start() throws IOException {
        int count = 0;

        for (String lines : registrationPetRepository.getQuestionsForm()) {
            registrationPetView.readerLineForm(lines);

            while (true) {

                try {
                    String response = registrationPetView.responseUser();

                    switch (count) {
                        case 0:
                            response = registrationPetService.validateName(response);
                            break;
                        case 1:
                            response = String.valueOf(registrationPetService.validateType(response));
                            break;
                        case 2:
                            response = String.valueOf(registrationPetService.validateSex(response));
                            break;
                        case 3:
                            response ="";
                            askAddress();
                            break;
                    }

                    registrationPetRepository.saveResponse(response);
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


