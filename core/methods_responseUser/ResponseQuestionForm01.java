package core.methods_responseUser;

import exception.NamePetExcepetion;
import pet.Pet;

import java.util.Scanner;

public class ResponseQuestionForm01 {
    public static void responseQuestionForm01() {
        System.out.print("R: ");
        Scanner scanner = new Scanner(System.in);
        String responseRegistrationPet = scanner.nextLine();
        for (int i = 0; i < responseRegistrationPet.length(); i++) {
            if (responseRegistrationPet.isBlank() || Character.isDigit(responseRegistrationPet.charAt(i))
                    || !responseRegistrationPet.contains(" ")) {
                throw new NamePetExcepetion();
            }
        }
        Pet.responseUserForm(responseRegistrationPet);
    }
}
