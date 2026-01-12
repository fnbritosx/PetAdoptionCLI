package controller;

import model.exception.ResponseFormException;
import model.repository.PetRepository;
import view.AllPetsView;

import java.io.IOException;

public class AllPetsController {
    private final AllPetsView allPetsView;
    private final PetRepository petRepository;

    public AllPetsController() {
        allPetsView = new AllPetsView();
        petRepository = new PetRepository();
    }

    public void start() {
        try {
            for (String line : petRepository.getAllPets()) {
                allPetsView.readerAllPets(line);
            }
        }catch (IOException e){
            System.out.println("Nenhum pet foi cadastrado.");
        }
    }
}

