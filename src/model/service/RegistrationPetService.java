package src.model.service;

import exception.ResponseFormException;
import src.model.entity.RegistrationEnum;
import src.model.entity.PetSex;
import src.model.entity.PetType;

import java.util.regex.Pattern;

public class RegistrationPetService {

    public String validateName(String nameInput) {

        if (nameInput == null|| nameInput.isBlank()) {
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

    public PetType validateType(String typeInput) {
        try {
            return PetType.valueOf(typeInput.toUpperCase().trim());
        } catch (IllegalArgumentException e) {
            throw new ResponseFormException("Tipo inválido! Digite 'CACHORRO' ou 'GATO'.");
        }
    }

    public PetSex validateSex(String sexInput) {
        try {
            return PetSex.valueOf(sexInput.toUpperCase().trim());
        } catch (IllegalArgumentException e) {
            throw new ResponseFormException("Tipo inválido! Digite 'MACHO' ou 'FÊMEA'.");
        }
    }

    public String validateHouseNumber(String houseNumber) {
        if (houseNumber.isBlank()) {
            return RegistrationEnum.NAO_INFORMADO;
        }

        String regexNumberHouse = "^[0-9]{1,5}$";
        if (!Pattern.matches(regexNumberHouse, houseNumber) && !houseNumber.equals(RegistrationEnum.NAO_INFORMADO)) {
            throw new ResponseFormException("Entrada inválida: Digite um número de até 5 dígitos.");
        }

        return houseNumber;
    }

    public void validateCity(String city) {
        city = city.trim().replaceAll("\\s", "");

        if (city.length() < 2 || city.length() > 40) {
            throw new ResponseFormException("Entrada inválida: A cidade deve ter entre 2 e 40 caracteres.");
        }

        if (!city.matches("^[A-Za-zÀ-ÿ]+(?: [A-Za-zÀ-ÿ]+)*$")) {
            throw new ResponseFormException("Entrada inválida: Digite uma cidade válida.");
        }

        if (!city.matches(".*[aeiouAEIOUáéíóúÁÉÍÓÚ].*")) {
            throw new ResponseFormException("Entrada inválida: O nome da cidade não é inválido.");
        }
    }


    public void validateRoad(String road) {
        road = road.trim().replaceAll("\\s", "");

        if (road.length() < 3) {
            throw new ResponseFormException("Entrada inválida: Nome da rua muito curto.");
        }

        if (!road.matches("^[A-Za-zÀ-ÿ ]+(\\d{1,5})?$")) {
            throw new ResponseFormException("Entrada inválida: Informe um nome de rua válido.");
        }

        String namePart = road.replaceAll("\\d", "").trim();
        if (!namePart.matches(".*[aeiouAEIOUáéíóúÁÉÍÓÚ].*")) {
            throw new ResponseFormException("Entrada inválida: O nome da rua parece inválido.");
        }
    }


    public String validateAge(String age) {
        if (age == null || age.isBlank()) {

            return RegistrationEnum.NAO_INFORMADO;
        }

        String regex = "^[0-9]{1,2}([.,][0-9])?$";

        Pattern pattern = Pattern.compile(regex);
        boolean valid = pattern.matcher(age).matches();

        if (!valid && !age.equals(RegistrationEnum.NAO_INFORMADO)) {
            throw new ResponseFormException(
                    "Entrada inválida: Informe a idade em anos, com 1 ou 2 dígitos e opcionalmente 1 casa decimal. Exemplos: 5, 3.5, 12.");

        }
        return age;
    }

    public String validateWeight(String weight) {
        if (weight == null || weight.isBlank()) {
            return RegistrationEnum.NAO_INFORMADO;
        }

        String regex = "^([0-9]{1,2}|60)([.,][0-9]{1,2})?$";

        boolean valid = Pattern.matches(regex, weight);

        if (!valid) {
            throw new ResponseFormException(
                    "Entrada inválida: Informe o peso entre 0.5 e 60 kg, com no máximo 2 casas decimais. Exemplos: 0.5, 7.25, 12, 60"
            );
        }

        double value = Double.parseDouble(weight.replace(',', '.'));

        if (value < 0.5 || value > 60) {
            throw new ResponseFormException("Peso deve estar entre 0.5 e 60 kg.");
        }

        return weight;
    }


    public String validateBreed(String breed){
        if (breed == null || breed.isBlank()) {
            return RegistrationEnum.NAO_INFORMADO;
        }

        String regex = "^[A-Za-zÀ-ÿ ]+$";
        Pattern pattern = Pattern.compile(regex);
        boolean valid = pattern.matcher(breed).matches();

        if (!valid && !breed.equals(RegistrationEnum.NAO_INFORMADO)) {
            throw new ResponseFormException("Entrada inválida: Digite a raça correta do seu pet.");
        }
        return breed;
    }
}








