package controller;

import model.exception.SearchPetException;
import model.repository.PetRepository;
import model.service.SearchPetService;
import view.SearchPetView;

public class SearchPetController {

    private final SearchPetView view;
    private final SearchPetService service;
    private final PetRepository repository;

    public SearchPetController() {
        this.view = new SearchPetView();
        this.service = new SearchPetService();
        this.repository = new PetRepository();
    }

    public void start() {

        String responseMenuType = null;
        while (true) {
            try {
                responseMenuType = view.menuType();
                service.validateType(responseMenuType);
                break;
            } catch (SearchPetException e) {
                printError(e);
            }
        }

        String responseMenuCriteria = null;
        while (true) {
            try {
                responseMenuCriteria = view.menuCriteria();
                service.validateCriteria(responseMenuCriteria);
                break;
            } catch (SearchPetException e) {
                printError(e);
            }
        }

        String responseProceedCriterion = null;
        while (true) {
            try {
                responseProceedCriterion = view.proceedCriterion();
                service.validateProceed(responseProceedCriterion);
                break;
            } catch (SearchPetException e) {
                printError(e);
            }
        }

        String responseNewMenuCriteria = null;
        if (responseProceedCriterion.equals("sim")) {
            while (true) {
                try {
                    responseNewMenuCriteria = view.newMenuCriteria(responseMenuCriteria);
                    service.validateNewMenuCriteria(
                            responseNewMenuCriteria,
                            responseMenuCriteria
                    );
                    break;
                } catch (SearchPetException e) {
                    printError(e);
                }
            }
        }

        String responseOne = view.getQuestionOne(responseMenuCriteria);

        String responseTwo = null;
        if (responseNewMenuCriteria != null) {
            responseTwo = view.getQuestionTwo(responseNewMenuCriteria);
        }

    }

    private void printError(SearchPetException e) {
        System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
    }
}
