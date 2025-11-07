package core.methods_responseUser;

import exception.TerminalExceptionCharacter;
import pet.Pet;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ResponseQuestionForm07 {
    public static void responseQuestionForm07() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("R: ");
                String responseRegistrationPet = scanner.nextLine();

                String regex = "^[A-Za-zÀ-ÿ ]+$";
                Pattern pattern = Pattern.compile(regex);
                boolean valido = pattern.matcher(responseRegistrationPet).matches();

                if (!valido) {
                    throw new TerminalExceptionCharacter("Entrada inválida: digite a raça correta do seu pet.");
                }

                if (responseRegistrationPet.trim().isEmpty()) {
                    responseRegistrationPet = Pet.NAO_INFORMADO;
                }

                Pet.responseUserForm(responseRegistrationPet);
                break;
            } catch (TerminalExceptionCharacter e) {
                System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
            }
        }
    }
}
