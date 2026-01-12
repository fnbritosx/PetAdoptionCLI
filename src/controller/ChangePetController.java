package controller;

import model.entity.Pet;
import model.repository.PetRepository;
import view.ChangePetView;

import java.io.IOException;


public class ChangePetController {
    private final PetRepository repository;
    private final ChangePetView view;
    private final Pet pet;

    public ChangePetController() {
        this.repository = new PetRepository();
        this.view = new ChangePetView();
        this.pet = new Pet();
    }


    public void start() {
        while (true) {
            try {
                for (String line : repository.getAllPets()) {
                    view.readerAllPets(line);
                }
            } catch (IOException e) {
                System.out.println("Nenhum pet foi cadastrado.");
                return;
            }


            String numberPet = view.whichPet();


            try {
                boolean found = false;

                for (String line : repository.getAllPets()) {
                    if (line.startsWith(numberPet + " - ")) {
                        String numberAttribute = view.petAttributes();

                        String responseChangePet = view.newPetAttribute(numberAttribute);

                        switch (numberAttribute){
                            case "1":
                                pet.setName(responseChangePet);
                                break;
                            case "2":
                                pet.setStreet(responseChangePet);
                                break;
                            case "3":
                                pet.setHouseNumber(responseChangePet);
                                break;
                            case "4":
                                pet.setCity(responseChangePet);
                            case "5":
                                pet.setWeight(responseChangePet);
                            case "6":
                                pet.setBreed(responseChangePet);
                        }

                        String proceedPetAttribute = view.proceedPetAttributes();



                        found = true;
                        break;
                    }
                }




                if (!found) {
                    System.out.println("Número inválido. Tente novamente.");
                    continue;
                }


                break;
            } catch (IOException e) {
                System.out.println("Erro ao buscar pet.");
                return;
            }
        }

    }
}