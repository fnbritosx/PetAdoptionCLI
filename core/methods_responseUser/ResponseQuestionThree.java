package core.methods_responseUser;

import exception.NamePetExcepetion;
import pet.Pet;
import pet.SexPet;

import java.util.Scanner;

public class ResponseQuestionThree {
    public static void responseQuestionThree() {
        System.out.print("R: ");
        SexPet sexPet = null;

        Scanner scanner = new Scanner(System.in);
        String responseRegistrationPet = scanner.nextLine().toUpperCase().trim();

        try {
            sexPet = SexPet.valueOf(responseRegistrationPet);
        } catch (NamePetExcepetion e) {
            throw new NamePetExcepetion();
        }
        Pet.responseUserForm(responseRegistrationPet);
    }
}
