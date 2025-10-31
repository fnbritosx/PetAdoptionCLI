package core.methods_responseUser;

import exception.TerminalExceptionCharacter;
import pet.Pet;

import java.util.Scanner;

public class ResponseQuestionForm04 {
    public static void responseQuestionForm04() {
        System.out.print("i. Número da casa: ");
        Scanner scanner = new Scanner(System.in);
        String responseRegistrationPet = scanner.nextLine();

        for (int i = 0; i < responseRegistrationPet.length(); i++) {
            if (!Character.isDigit(responseRegistrationPet.charAt(i))) {
                throw new TerminalExceptionCharacter();
            }
        }
        Pet.responseUserForm(responseRegistrationPet);

        System.out.print("ii. Cidade: ");
        responseRegistrationPet = scanner.nextLine();

        for (int i = 0; i < responseRegistrationPet.length(); i++) {
            if (!Character.isLetter(responseRegistrationPet.charAt(i)) &&
                    (!responseRegistrationPet.contains(" "))) {
                throw new TerminalExceptionCharacter("Entrada inválida: você não digitou um caractere válido.");
            }
        }
        Pet.responseUserForm(responseRegistrationPet);

        System.out.print("iii. Rua: ");
        responseRegistrationPet = scanner.nextLine();

        for (int i = 0; i < responseRegistrationPet.length(); i++) {
            if (!Character.isLetterOrDigit(responseRegistrationPet.charAt(i)) &&
                    (!responseRegistrationPet.contains(" "))) {
                throw new TerminalExceptionCharacter("Entrada inválida: você não digitou um caractere válido. haha");
            }
        }
        Pet.responseUserForm(responseRegistrationPet);
    }
}

