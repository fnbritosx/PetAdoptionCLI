package controller;

import model.entity.Pet;
import model.exception.ChangePetException;
import model.exception.ResponseFormException;
import model.repository.PetRepository;
import model.service.ChangePetService;
import model.service.PetService;
import view.ChangePetView;

import java.io.IOException;
import java.util.Map;


public class ChangePetController {
    private final PetRepository repository;
    private final ChangePetView view;
    private final ChangePetService service;
    private final PetService petService;

    public ChangePetController() {
        this.repository = new PetRepository();
        this.view = new ChangePetView();
        this.service = new ChangePetService();
        this.petService = new PetService();
    }


    public void start() throws IOException {

        Pet pet;
        String numberPet;
        while (true) {
            try {
                for (String line : repository.getAllPetsLines()) {
                    view.readerAllPets(line);
                }

                numberPet = view.whichPet();
                service.validateWhichPet(numberPet);
                System.out.println();

                pet = repository.findPetByNumber(numberPet);

                break;
            } catch (IOException e) {
                System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m" + "\n");
                return;
            } catch (ChangePetException e) {
                System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m" + "\n");
            }
        }

        String oldLine = null;
        for (String line : repository.getAllPetsLines()) {
            if (line.startsWith(numberPet + " - ")) {
                oldLine = line;
                break;
            }
        }


        boolean continueEditing = true;

        while (continueEditing) {
            String numberAttribute = "";
            while (true) {
                try {
                    numberAttribute = view.petAttributes();
                    service.validateAttribute(numberAttribute);
                    System.out.println();
                    break;
                } catch (ChangePetException e) {
                    System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m" + "\n");
                }
            }

            while (true) {
                try {
                    String responseChangePet = view.newPetAttribute(numberAttribute);
                    System.out.println();
                    switch (numberAttribute) {
                        case "1":
                            pet.setName(petService.validateNameAndLastName(responseChangePet));
                            break;
                        case "2":
                            pet.setStreet(petService.validateStreet(responseChangePet));
                            break;
                        case "3":
                            pet.setHouseNumber(petService.validateHouseNumber(responseChangePet));
                            break;
                        case "4":
                            pet.setCity(petService.validateCity(responseChangePet));
                            break;
                        case "5":
                            pet.setWeight(petService.validateWeight(responseChangePet));
                            break;
                        case "6":
                            pet.setBreed(petService.validateBreed(responseChangePet));
                            break;
                    }
                    break;
                } catch (ResponseFormException e) {
                    System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m" + "\n");
                }
            }


            while (true) {
                try {
                    String proceedAttributes = view.proceedPetAttributes();
                    continueEditing = service.validateProceedAttributes(proceedAttributes);
                    System.out.println();
                    break;
                } catch (ChangePetException e) {
                    System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
                }
            }

            Map.Entry<String, String> result = repository.changePet(numberPet, pet);

            System.out.println("\u001B[31m" + "Antes: " + "\n" + result.getKey() + "\u001B[0m" + "\n");
            System.out.println("\u001B[32m" + "Depois: " + "\n" + result.getValue() + "\u001B[0m" + "\n");
        }
    }
}