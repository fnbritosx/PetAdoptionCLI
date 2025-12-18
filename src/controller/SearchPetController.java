package controller;

import model.exception.SearchPetException;
import model.service.SearchPetService;
import view.SearchPetView;

public class SearchPetController {
    private final SearchPetView view;
    private final SearchPetService service;

    public SearchPetController() {
        this.view = new SearchPetView();
        this.service = new SearchPetService();
    }

    public void start() {
        String criteria;
        int criteriaInt;

        while (true) {
            try {
                criteria = service.validateType(view.animalType());
                criteriaInt = Integer.parseInt(criteria);

                switch (criteriaInt){
                    case 1:
                        break;
                    case 2:
                        break;
                }

                break;
            } catch (SearchPetException e) {
                System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
            }
        }

        while (true) {
            try {
                service.validateCriteria(view.searchCriteria());
                break;
            } catch (SearchPetException e) {
                System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
            }
        }

        while (true) {
            try {
                service.validateProceed(view.proceedCriterion());
                break;
            } catch (SearchPetException e) {
                System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
            }
        }
    }

}
