package controller;

import model.entity.Pet;
import model.exception.ResponseFormException;
import model.exception.SearchPetException;
import model.repository.PetRepository;
import model.service.PetService;
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
                System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
            }
        }


        String responseMenuCriteria;
        while (true) {
            try {
                responseMenuCriteria = view.menuCriteria();
                searchService.validateCriteria(responseMenuCriteria);
                break;
            } catch (SearchPetException e) {
                System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
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
                    System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
                }
            }
        }


        String responseProceedCriterion;
        while (true) {
            try {
                String response = view.proceedCriterion();
                responseProceedCriterion = searchService.validateProceed(response);
                break;
            } catch (SearchPetException e) {
                System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
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
                    System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
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
                    System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
                }
            }
        }

        String responseOne;
        while (true) {
            try {
                responseOne = view.getQuestion(responseMenuCriteria, responseAddress != null ? responseAddress : "0");
                break;
            } catch (ResponseFormException e) {
                System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
            }
        }


        String responseTwo = null;
        if (responseNewMenuCriteria != null) {
            while (true) {
                try {
                    responseTwo = view.getQuestion(responseNewMenuCriteria, responseNewAddress != null ? responseNewAddress : "0");
                    break;
                } catch (ResponseFormException e) {
                    System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
                }
            }
        }


        try {
            List<Pet> allPets = repository.getAllPetsFromFile();

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
                System.out.println("\n\u001B[1m\u001B[33mNenhum pet encontrado com os critérios informados.\u001B[0m");
            } else {
                repository.saveFilteredPets(result);
                System.out.println("\n\u001B[1m\u001B[32mArquivo 'pets_filtrados.txt' criado com sucesso!\u001B[0m");

                repository.displayFilteredPets();
            }
        } catch (IOException e) {
            System.out.println("\u001B[1m\u001B[31mErro: " + e.getMessage() + "\u001B[0m");
        }
    }
}

