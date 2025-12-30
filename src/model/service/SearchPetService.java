package model.service;

import model.exception.SearchPetException;

import java.util.regex.Pattern;

public class SearchPetService {

    public String validateType(String response) {
        Pattern pattern = Pattern.compile("^[12]$");

        if (!pattern.matcher(response.trim()).matches()) {
            throw new SearchPetException("Entrada inválida: digite 1 ou 2.");
        }
        return response;
    }


    public void validateCriteria(String response) {
        Pattern pattern = Pattern.compile("^[1-6]$");

        if (!pattern.matcher(response.trim()).matches()) {
            throw new SearchPetException("Entrada inválida: digite um número de 1 a 6.");
        }
    }


    public void validateProceed(String response) {
        Pattern pattern = Pattern.compile("^(?i)(sim|não)$", Pattern.CASE_INSENSITIVE);

        if (!pattern.matcher(response.trim()).matches()) {
            throw new SearchPetException("Entrada inválida: digite 1 ou 2.");
        }
    }


    public void validateNewMenuCriteria(String response, String previousCriterAnswer) {
        Pattern pattern = Pattern.compile("^[1-6]$");
        if (!pattern.matcher(response.trim()).matches()) {
            throw new SearchPetException("Entrada inválida: digite um número de 1 a 6.");
        }

        if (response.equals(previousCriterAnswer)) {
            throw new SearchPetException("Entrada inválida: digite um valor diferente de um já escolhido.");
        }
    }
    public void validateAddress(String responseAddress){
        Pattern pattern = Pattern.compile("^[1-3]$");

        if (!pattern.matcher(responseAddress).matches()){
            throw new SearchPetException("Entrada inválida: digite um número de 1 a 3.");
        }
    }
}
