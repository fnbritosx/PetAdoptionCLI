package controller;

import model.exception.ResponseFormException;
import model.exception.SearchPetException;
import model.repository.PetRepository;
import model.service.PetService;
import model.service.SearchPetService;
import view.SearchPetView;

public class SearchPetController {

    private final SearchPetView view;
    private final SearchPetService searchService;
    private final PetService petService;
    private final PetRepository repository;

    public SearchPetController() {
        this.view = new SearchPetView();
        this.searchService = new SearchPetService();
        this.repository = new PetRepository();
        this.petService = new PetService();
    }

    public void start() {

        String responseMenuType = null;
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
                responseProceedCriterion = view.proceedCriterion();
                searchService.validateProceed(responseProceedCriterion);
                break;
            } catch (SearchPetException e) {
                System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
            }
        }


        String responseNewMenuCriteria = null;
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
                    responseAddress = view.address();
                    searchService.validateAddress(responseAddress);
                    break;
                } catch (SearchPetException e) {
                    System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
                }
            }
        }

        String responseOne;
        while (true) {
            try {
                responseOne = view.getQuestion(responseMenuCriteria, responseAddress);
                petService.validateQuestions(responseMenuCriteria, responseOne, responseAddress);
                break;
            } catch (ResponseFormException e) {
                System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
            }
        }


        String responseTwo;
        if (responseNewMenuCriteria != null) {
            while (true) {
                try {
                    responseTwo = view.getQuestion(responseNewMenuCriteria, responseMenuCriteria);
                    petService.validateQuestions(responseNewMenuCriteria, responseTwo, responseAddress);
                    break;
                } catch (ResponseFormException e) {
                    System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
                }
            }
        }
    }
}
