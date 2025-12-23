package controller;

import model.repository.PetRepository;
import model.service.SearchPetService;
import view.SearchPetView;

public class SearchPetController {
    private final SearchPetView view;
    private final SearchPetService service;
    private final PetRepository petRepository;

    public SearchPetController() {
        this.view = new SearchPetView();
        this.service = new SearchPetService();
        this.petRepository = new PetRepository();
    }

    public void start() {
        String responseMenuType = view.menuType();
        service.validateType(responseMenuType);

        String responseMenuCriteria = view.menuCriteria();
        service.validateCriteria(responseMenuCriteria);

        String responseProceedCriterion = view.proceedCriterion();
        service.validateProceed(responseProceedCriterion);

        String responseNewMenuCriteria = null;
        if (responseProceedCriterion.equals("sim")) {
            responseNewMenuCriteria = view.newMenuCriteria(responseMenuCriteria);
            service.validateNewMenuCriteria(responseNewMenuCriteria, responseMenuCriteria);
        }

        view.getQuestionOne(responseMenuCriteria);

        if (responseProceedCriterion.equals("sim")) {
            view.getQuestionTwo(responseNewMenuCriteria);
        }
    }
}

