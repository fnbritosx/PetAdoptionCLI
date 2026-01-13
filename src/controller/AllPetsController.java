package controller;

import model.repository.PetRepository;
import view.AllPetsView;

public class AllPetsController {
    private final AllPetsView allPetsView;
    private final PetRepository petRepository;

    public AllPetsController() {
        allPetsView = new AllPetsView();
        petRepository = new PetRepository();
    }

    public void start() {
        for (String line : petRepository.getAllPetsLines()) {
            allPetsView.readerAllPets(line);
        }
    }
}

