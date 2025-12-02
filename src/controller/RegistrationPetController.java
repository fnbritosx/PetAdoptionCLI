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

    public void start() throws IOException {
        int index = 0;

        for (String lines : registrationPetRepository.getQuestionsForm()) {
            registrationPetView.readerLineForm(lines);
            while (true) {
                try {
                    String response = registrationPetView.responseUser();

                    switch (index) {
                        case 0:
                            registrationPetService.validateName(response);
                            break;
                        case 1:
                            break;
                        case 2:
                            break;
                    }
                    registrationPetRepository.saveResponse(response);
                    break;
                } catch (ResponseFormException e) {
                    System.out.println(e.getMessage());
                }
            }
            index++;
        }
        System.out.println(registrationPetRepository.getListResponseUser());
    }
}

