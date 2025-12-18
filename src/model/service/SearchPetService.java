package model.service;

import model.exception.SearchPetException;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Pattern;

public class SearchPetService {

    public String validateType(String response){
        Pattern pattern = Pattern.compile("^[12]$");

        if (!pattern.matcher(response).matches()){
            throw new SearchPetException("Entrada inválida: digite 1 ou 2.");
        }
        return response;
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

    public List<String> readerAllDogs(File file) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line;

            while ((line = bufferedReader.readLine()) != null){
                String[] words = line.split(" ");

                for (String word : words){
                    if (word.indexOf(3) == "cachorro"){

                    }
                }

            }
        }catch (IOException e){
            throw new RuntimeException("Erro ao ler o arquivo: " + e.getMessage(), e);
        }
        return null;
    }
}
