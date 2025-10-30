package core.methods_responseUser;

import exception.NamePetExcepetion;
import pet.Pet;
import pet.SexPet;
import pet.TypePet;

import java.util.Scanner;

public class ResponseQuestionTwo {
    public static void responseQuestionTwo() {
        System.out.print("R: ");
        TypePet typePet = null;

        Scanner scanner = new Scanner(System.in);
        String responseRegistrationPet = scanner.nextLine().toUpperCase().trim();

        try {
            typePet = TypePet.valueOf(responseRegistrationPet);
        } catch (NamePetExcepetion e) {
            throw new NamePetExcepetion();
        }
        Pet.responseUserForm(responseRegistrationPet);
    }
}
