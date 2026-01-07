package model.service;

import model.entity.Pet;
import model.exception.SearchPetException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SearchPetService {

    public List<Pet> filterByName(List<Pet> allPets, String searchName) {

        List<Pet> foundPets = new ArrayList<>();

        for (Pet pet : allPets) {
            String petName = pet.getName().toLowerCase();
            String nameToSearch = searchName.toLowerCase();

            if (petName.contains(nameToSearch)) {
                foundPets.add(pet);
            }
        }

        return foundPets;
    }

    public List<Pet> filterByType(List<Pet> allPets, String searchType) {
        List<Pet> foundPets = new ArrayList<>();

        for (Pet pet : allPets) {
            String petType = pet.getType().toString();

            if (petType.equalsIgnoreCase(searchType)) {
                foundPets.add(pet);
            }
        }
        return foundPets;
    }

    public List<Pet> filterBySex(List<Pet> allPets, String searchSex) {
        List<Pet> foundPets = new ArrayList<>();

        for (Pet pet : allPets) {
            String petType = pet.getSex().toString();

            if (petType.equalsIgnoreCase(searchSex)) {
                foundPets.add(pet);
            }
        }
        return foundPets;
    }

    public List<Pet> filterByStreet(List<Pet> allPets, String searchStreet) {
        List<Pet> foundPets = new ArrayList<>();

        for (Pet pet : allPets) {
            String petStreet = pet.getStreet().substring(4).toLowerCase();

            if (petStreet.contains(searchStreet.toLowerCase())) {
                foundPets.add(pet);
            }
        }
        return foundPets;
    }

    public List<Pet> filterByHouseNumber(List<Pet> allPets, String searchHouseNumber) {
        List<Pet> foundPets = new ArrayList<>();

        for (Pet pet : allPets) {
            String petHouseNumber = pet.getHouseNumber();

            if (petHouseNumber.equals(searchHouseNumber)) {
                foundPets.add(pet);
            }
        }
        return foundPets;
    }

    public List<Pet> filterByCity(List<Pet> allPets, String searchCity) {
        List<Pet> foundPets = new ArrayList<>();

        for (Pet pet : allPets) {
            String petCity = pet.getCity().toLowerCase();

            if (petCity.contains(searchCity.toLowerCase())) {
                foundPets.add(pet);
            }
        }
        return foundPets;
    }

    public List<Pet> filterByAge(List<Pet> allPets, String searchAge) {
        List<Pet> foundPets = new ArrayList<>();

        for (Pet pet : allPets) {
            String petAge = pet.getAge().replace(" anos", "").trim();

            if (petAge.equals(searchAge.trim())) {
                foundPets.add(pet);
            }
        }
        return foundPets;
    }

    public List<Pet> filterByWeight(List<Pet> allPets, String searchWeight) {
        List<Pet> foundPets = new ArrayList<>();

        for (Pet pet : allPets) {
            String petWeight = pet.getWeight().replace(" kg", "").trim();

            if (petWeight.equals(searchWeight.trim())) {
                foundPets.add(pet);
            }
        }
        return foundPets;
    }

    public List<Pet> filterByBreed(List<Pet> allPets, String searchBreed) {
        List<Pet> foundPets = new ArrayList<>();

        for (Pet pet : allPets) {
            String petBreed = pet.getBreed().toLowerCase();

            if (petBreed.contains(searchBreed.toLowerCase())) {
                foundPets.add(pet);
            }
        }

        return foundPets;
    }

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

    public void validateAddress(String responseAddress) {
        Pattern pattern = Pattern.compile("^[1-3]$");

        if (!pattern.matcher(responseAddress).matches()) {
            throw new SearchPetException("Entrada inválida: digite um número de 1 a 3.");
        }
    }
}
