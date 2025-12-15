package model.service;

import model.exception.SearchPetException;

import java.util.regex.Pattern;

public class SearchPetService {

    public void validateType(String response){
        Pattern pattern = Pattern.compile("^[12]$");

        if (!pattern.matcher(response).matches()){
            throw new SearchPetException("Entrada inválida: digite 1 ou 2.");
        }
    }

    public void validateCriteria(String response){
        Pattern pattern = Pattern.compile("^[1-6]$");

        if (!pattern.matcher(response).matches()){
            throw new SearchPetException("Entrada inválida: digite um número de 1 a 6.");
        }
    }

    public void validateProceed(String response){
        Pattern pattern = Pattern.compile("^[12]$");

        if (!pattern.matcher(response).matches()){
            throw new SearchPetException("Entrada inválida: digite 1 ou 2.");
        }
    }

}
