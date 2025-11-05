package core.methods_responseUser;

import exception.NamePetExcepetion;
import pet.Pet;

import java.util.Scanner;

public class ResponseQuestionForm01 {
    public static void responseQuestionForm01() {
        while (true) {
            try {
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
                break;
            }catch (NamePetExcepetion e){
                final String RED_BOLD = "\u001B[1m\u001B[31m";
                final String RESET = "\u001B[0m";
                System.out.println(RED_BOLD + e.getMessage() + RESET);
            }
        }
    }
}
