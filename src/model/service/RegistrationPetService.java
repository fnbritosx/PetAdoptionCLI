package src.model.service;

import exception.ResponseFormException;
import src.model.entity.Pet;
import src.model.entity.PetSex;
import src.model.entity.PetType;

import java.util.regex.Pattern;

public class RegistrationPetService {

    public String validateName(String nameInput) {
        nameInput = nameInput.trim().replaceAll("\\s+", " ");

        if (nameInput.isEmpty() ) {
            return Pet.NAO_INFORMADO;
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

    public PetType validateType(String typeInput){
        PetType petType = null;

        try {
            petType = PetType.valueOf(typeInput.toUpperCase().trim());
        } catch (IllegalArgumentException  e) {
            throw new ResponseFormException("Tipo inválido! Digite 'CACHORRO' ou 'GATO'.");
        }
        return petType;
    }

    public PetSex validateSex(String sexInput){
        PetSex petSex = null;

        try {
            petSex = PetSex.valueOf(sexInput.toUpperCase().trim());
        } catch (IllegalArgumentException e) {
            throw new ResponseFormException("Tipo inválido! Digite 'MACHO' ou 'FÊMEA'.");
        }
        return petSex;
    }

}




