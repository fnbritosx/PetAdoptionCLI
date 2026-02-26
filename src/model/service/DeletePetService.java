package model.service;

import model.exception.DeletePetException;

public class DeletePetService {
    public String validateConfirm(String confirm) {
        if (!confirm.matches("^[12]$")) {
            throw new DeletePetException("Entrada inválida: digite 1 ou 2.");
        }
        return confirm;
    }
}
