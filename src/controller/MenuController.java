package src.controller;

import exception.MenuNumberException;
import src.model.service.MenuService;
import src.view.MenuView;

import java.io.IOException;

public class MenuController {
    private final MenuView menuView;
    private final MenuService menuService;
    private final RegistrationPetController registrationPetController;

    public MenuController() {
        this.menuView = new MenuView();
        this.menuService = new MenuService();
        this.registrationPetController = new RegistrationPetController();
    }

    public void start() {
        while (true) {
            try {
                String response = menuView.menuView();
                menuService.validateMenuEntry(response);

                int numberResponse = Integer.parseInt(response);
                switch (numberResponse) {
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
                return;
            } catch (MenuNumberException | IOException e) {
                System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
            }
        }
    }
}
