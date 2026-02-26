package model.service;

import model.exception.ChangePetException;
import model.repository.PetRepository;

import java.io.IOException;
import java.util.regex.Pattern;

public class ChangePetService {
    private final PetRepository repository;

    public ChangePetService() {
        this.repository = new PetRepository();
    }

    public void validateWhichPet(String numberStartLine) throws IOException {
        for (String line : repository.getAllPetsLines()) {
            if (!line.startsWith(numberStartLine.trim() + "-")) {
                return;
            }
        }

        throw new ChangePetException("Entrada inválida: digite um número válido.");
    }

    public void validateAttribute(String numberAttribute) {

        if (numberAttribute == null) {
            throw new ChangePetException("Entrada inválida: valor não pode ser nulo.");
        }

        Pattern pattern = Pattern.compile("^[1-6]$");


        if (!pattern.matcher(numberAttribute).matches()) {
            throw new ChangePetException("Entrada inválida: o número que você digitou é inválido.");
        }
    }

    public boolean validateProceedAttributes(String proceedNumberPetAttribute) {

        if (proceedNumberPetAttribute == null) {
            throw new ChangePetException("Entrada inválida.");
        }

        if (proceedNumberPetAttribute.equals("1")) {
            return true;
        }

        if (proceedNumberPetAttribute.equals("2")) {
            return false;
        }

        throw new ChangePetException("Entrada inválida: digite 1 ou 2.");
    }
}

