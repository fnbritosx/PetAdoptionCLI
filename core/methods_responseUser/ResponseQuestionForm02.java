package core.methods_responseUser;

import exception.NamePetExcepetion;
import pet.Pet;
import pet.TypePet;

import java.util.Scanner;

public class ResponseQuestionForm02 {
    public static void responseQuestionForm02() {
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
