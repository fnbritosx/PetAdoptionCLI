package src.controller;

import src.model.service.MenuService;
import src.view.MenuView;

public class MenuController {
    private final MenuView menuView;
    private final MenuService menuService;
    private final RegistrationPetController registrationPetController;
    boolean proceed = true;

    public MenuController() {
        this.menuView = new MenuView();
        this.menuService = new MenuService();
        this.registrationPetController = new RegistrationPetController();
    }

    public void start() {
        while (proceed) {
            String response = menuView.menuView();
            menuService.validateMenuEntry(response);

            int numberResponse = Integer.parseInt(response);
            switch (numberResponse){
                case 1:
                    registrationPetController.start();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("Encerrando o programa...");
                    break;
            }
        }
    }

}
