package model.service;


import model.exception.MenuNumberException;

public class MenuService {

    public void validateMenuEntry(String response) {
        checkBlank(response);
        checkDigit(response);
        checkNumber(response);
    }

    public void checkBlank(String response) {
        if (response.isBlank()) {
            throw new MenuNumberException();
        }
    }

    public void checkDigit(String response) {
        for (int i = 0; i < response.length(); i++) {
            if (!Character.isDigit(response.charAt(i))) {
                throw new MenuNumberException();
            }
        }
    }

    public void checkNumber(String response) {
        int responseInt = Integer.parseInt(response);

        if (responseInt > 6 || responseInt <= 0) {
            throw new MenuNumberException();
        }
    }
}

