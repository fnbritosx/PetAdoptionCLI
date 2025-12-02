package src.model.service;

import exception.ResponseFormException;
import src.model.entity.Pet;

import java.util.regex.Pattern;

public class RegistrationPetService {

    public String validateName(String name) {

        if (name == null || name.isBlank()) {
            return Pet.NAO_INFORMADO;
        }

        name = name.trim().replaceAll("\\s+", " ");

        Pattern WORD = Pattern.compile("^[A-Za-zÀ-ÿ]+$");

        String[] parts = name.split(" ");
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

        return name;
    }
}




