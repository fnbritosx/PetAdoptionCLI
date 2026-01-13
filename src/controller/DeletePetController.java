package controller;

import model.repository.PetRepository;
import model.service.DeletePetService;
import view.DeletePetView;

import java.util.ArrayList;
import java.util.List;

public class DeletePetController {
    private final PetRepository repository;
    private final DeletePetService service;
    private final DeletePetView view;

    public DeletePetController() {
        this.repository = new PetRepository();
        this.service = new DeletePetService();
        this.view = new DeletePetView();
    }

    public static void main(String[] args) {
        DeletePetController deletePetController = new DeletePetController();

        deletePetController.start();
    }

    public void start() {

        while (true) {
            for (String line : repository.getAllPetsLines()) {
                view.readerLine(line);
            }

            String lineForDelete = view.askDeleteLine();

            String confirmDeleteLine = "";
            for (String line : repository.getAllPetsLines()) {
                if (line.startsWith(lineForDelete + " - ")) {
                    confirmDeleteLine = view.confirmDeleteLine(line);
                }
            }

            if (confirmDeleteLine.equals("2")) {
                System.out.println();


                continue;
            }


            List<String> newListAllPets = new ArrayList<>();

            for (String line : repository.getAllPetsLines()) {
                newListAllPets.add(line);
                if (line.startsWith(lineForDelete + " - ")) {
                    newListAllPets.remove(line);
                }
            }
            System.out.println(newListAllPets);
            break;
        }
    }
}