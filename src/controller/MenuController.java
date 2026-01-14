package controller;

import model.exception.MenuNumberException;
import model.service.MenuService;
import view.MenuView;

import java.io.IOException;

public class MenuController {
    private final MenuView menuView;
    private final MenuService menuService;
    private final PetController petController;
    private final SearchPetController searchPetController;
    private final AllPetsController allPetsController;
    private final ChangePetController changePetController;
    private final DeletePetController deletePetController;

    public MenuController() {
        this.menuView = new MenuView();
        this.menuService = new MenuService();
        this.petController = new PetController();
        this.searchPetController = new SearchPetController();
        this.allPetsController = new AllPetsController();
        this.changePetController = new ChangePetController();
        this.deletePetController = new DeletePetController();
    }

    public void start() {
        while (true) {
            try {
                String response = menuView.menuView();
                menuService.validateMenuEntry(response);
                System.out.println();

                int numberResponse = Integer.parseInt(response);
                switch (numberResponse) {
                    case 1:
                        petController.start();
                        break;
                    case 2:
                        changePetController.start();
                        break;
                    case 3:
                        deletePetController.start();
                        break;
                    case 4:
                        allPetsController.start();
                        break;
                    case 5:
                        searchPetController.start();
                        break;
                    case 6:
                        System.out.println("Encerrando o programa...");
                        break;
                }
                return;
            } catch (MenuNumberException | IOException e) {
                System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
            }
        }
    }
}
