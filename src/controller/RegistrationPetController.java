package src.controller;

import src.model.repository.RegistrationPetRepository;
import src.model.service.RegistrationPetService;
import src.view.RegistrationPetView;

import java.io.IOException;;


public class RegistrationPetController {
    private final RegistrationPetService registrationPetService;
    private final RegistrationPetView registrationPetView;
    private final RegistrationPetRepository registrationPetRepository;

    public RegistrationPetController(RegistrationPetRepository registrationPetRepository) {
        this.registrationPetService = new RegistrationPetService();
        this.registrationPetView = new RegistrationPetView();
        this.registrationPetRepository = new RegistrationPetRepository();
    }

    public void start() throws IOException {
        for(String lines : registrationPetRepository.getQuestionsForm(registrationPetRepository.getFormFile())){
            registrationPetView.readerLineForm(lines);
            registrationPetRepository.storeResponse(registrationPetView.responseUser());
        }
    }
}
