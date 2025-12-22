package controller;

import model.repository.PetRepository;
import model.service.SearchPetService;
import view.SearchPetView;

public class SearchPetController {
    private final SearchPetView view;
    private final SearchPetService service;
    private final PetRepository petRepository;

    public SearchPetController() {
        this.view = new SearchPetView();
        this.service = new SearchPetService();
        this.petRepository = new PetRepository();
    }

    public void start() {

    }
}

