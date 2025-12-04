package src.model.service;

import exception.ResponseFormException;
import src.model.entity.RegistrationEnum;
import src.model.entity.PetSex;
import src.model.entity.PetType;

import java.util.regex.Pattern;

public class RegistrationPetService {

    public String validateName(String nameInput) {
        nameInput = nameInput.trim().replaceAll("\\s+", " ");

        if (nameInput.isEmpty()) {
            return RegistrationEnum.NAO_INFORMADO;
        }


        Pattern WORD = Pattern.compile("^[A-Za-zÀ-ÿ]+$");

        String[] parts = nameInput.split(" ");
        int count = parts.length;

        if (count < 2) {
            throw new ResponseFormException("Entrada inválida: informe nome e sobrenome.");
        }

        if (count > 3) {
            throw new ResponseFormException("Entrada inválida: máximo de 3 palavras.");
        }

        for (String p : parts) {
            if (!WORD.matcher(p).matches()) {
                throw new ResponseFormException("Entrada inválida: somente letras são permitidas.");
            }
        }

        if (count == 3) {
            String middle = parts[1];
            if (middle.length() > 3) {
                throw new ResponseFormException("Entrada inválida: o nome do meio deve ter no máximo 3 letras.");
            }
        }

        return nameInput;
    }

    public void validateType(String typeInput) {
        PetType petType = null;

        try {
            petType = PetType.valueOf(typeInput.toUpperCase().trim());
        } catch (IllegalArgumentException e) {
            throw new ResponseFormException("Tipo inválido! Digite 'CACHORRO' ou 'GATO'.");
        }
    }

    public void validateSex(String sexInput) {
        PetSex petSex = null;

        try {
            petSex = PetSex.valueOf(sexInput.toUpperCase().trim());
        } catch (IllegalArgumentException e) {
            throw new ResponseFormException("Tipo inválido! Digite 'MACHO' ou 'FÊMEA'.");
        }
    }

    public String validateHouseNumber(String houseNumber) {

        try {
            if (houseNumber.isEmpty()) {
                return RegistrationEnum.NAO_INFORMADO;
            }

            String regexNumberHouse = "^[0-9]{1,5}$";
            if (!Pattern.matches(regexNumberHouse, houseNumber) && !houseNumber.equals(RegistrationEnum.NAO_INFORMADO)) {
                throw new ResponseFormException("Entrada inválida: digite um número de até 5 dígitos.");
            }

        } catch (ResponseFormException e) {
            System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
        }
        return houseNumber;
    }

    public void validateCity(String city) {

        String regexCity = "^[A-Za-zÀ-ú ]{1,40}$";
        if (!Pattern.matches(regexCity, city)) {
            throw new ResponseFormException("Entrada inválida: você não digitou uma cidade válida.");
        }
    }


    public void validateRoad(String road) {

        String regexRua = "^[A-Za-zÀ-ú ]{1,47}[0-9]{0,3}$";
        if (!Pattern.matches(regexRua, road)) {
            throw new ResponseFormException("Entrada inválida: você não digitou uma rua válida.");
        }
    }
}








