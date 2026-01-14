package controller;

import model.entity.Pet;
import model.exception.SearchPetException;
import model.repository.PetRepository;
import model.service.SearchPetService;
import view.SearchPetView;

import java.io.IOException;
import java.util.List;

public class SearchPetController {

    private final SearchPetView view;
    private final SearchPetService searchService;
    private final PetRepository repository;

    public SearchPetController() {
        this.view = new SearchPetView();
        this.searchService = new SearchPetService();
        this.repository = new PetRepository();
    }

    public void start() {

        String responseMenuType;
        while (true) {
            try {
                responseMenuType = view.menuType();
                searchService.validateType(responseMenuType);
                break;
            } catch (SearchPetException e) {
                formattedRed(e.getMessage());
            }
        }


        String responseMenuCriteria;
        while (true) {
            try {
                responseMenuCriteria = view.menuCriteria();
                searchService.validateCriteria(responseMenuCriteria);
                break;
            } catch (SearchPetException e) {
               formattedRed(e.getMessage());
            }
        }

        String responseAddress = null;
        if (responseMenuCriteria.equals("6")) {
            while (true) {
                try {
                    responseAddress = view.address();
                    searchService.validateAddress(responseAddress);
                    break;
                } catch (SearchPetException e) {
                    formattedRed(e.getMessage());
                }
            }
        }

        String responseOne;
        while (true) {
            try {
                responseOne = view.getQuestion(responseMenuCriteria, responseAddress != null ? responseAddress : "0");
                searchService.validateResponse(responseMenuCriteria, responseOne);
                break;
            } catch (SearchPetException e) {
                System.out.println();
                formattedRed(e.getMessage());
            }
        }


        String responseProceedCriterion;
        while (true) {
            try {
                String response = view.proceedCriterion();
                responseProceedCriterion = searchService.validateProceed(response);
                break;
            } catch (SearchPetException e) {
               formattedRed(e.getMessage());
            }
        }


        String responseNewMenuCriteria = null;
        String responseNewAddress = null;
        if (responseProceedCriterion.equals("sim")) {
            while (true) {
                try {
                    responseNewMenuCriteria = view.newMenuCriteria(responseMenuCriteria);
                    searchService.validateNewMenuCriteria(responseNewMenuCriteria, responseMenuCriteria);
                    break;
                } catch (SearchPetException e) {
                  formattedRed(e.getMessage());
                }
            }
        }

        if (responseProceedCriterion.equals("sim") && responseNewMenuCriteria.equals("6")) {
            while (true) {
                try {
                    responseNewAddress = view.address();
                    searchService.validateAddress(responseNewAddress);
                    break;
                } catch (SearchPetException e) {
                    System.out.println();
                    formattedRed(e.getMessage());
                }
            }
        }


        String responseTwo = null;
        if (responseNewMenuCriteria != null) {
            while (true) {
                try {
                    responseTwo = view.getQuestion(responseNewMenuCriteria, responseNewAddress != null ? responseNewAddress : "0");
                    searchService.validateResponse(responseNewMenuCriteria, responseTwo);
                    break;
                } catch (SearchPetException e) {
                   formattedRed(e.getMessage());
                }
            }
        }


        try {
            List<Pet> allPets = repository.findAll();

            String typeFormatted = responseMenuType.equals("1") ? "CACHORRO" : "GATO";
            List<Pet> filteredByType = searchService.filterByType(allPets, typeFormatted);


            List<Pet> result = searchService.filterByCriteria(
                    filteredByType,
                    responseMenuCriteria,
                    responseOne,
                    responseAddress != null ? responseAddress : "0");


            if (responseNewMenuCriteria != null) {
                result = searchService.filterByCriteria(
                        result,
                        responseNewMenuCriteria,
                        responseTwo,
                        responseNewAddress != null ? responseNewAddress : "0");
            }


            if (result.isEmpty()) {
                System.out.println();
                formattedRed("Nenhum pet encontrado com os critérios informados.");
            } else {
                repository.saveFilteredPets(result);
                System.out.println();
                formattedGreen("Arquivo 'pets_filtrados.txt' criado com sucesso!");

                view.displayFilteredPets();
            }
        } catch (IOException e) {
           formattedRed(e.getMessage());
        }
    }

    private void formattedRed(String e){
        System.out.println("\u001B[1m\u001B[31m" + e + "\u001B[0m " + "\n");
    }

    private void formattedGreen(String e){
        System.out.println("\u001B[1m\u001B[32m" + e + "\u001B[0m " + "\n");
    }
}

