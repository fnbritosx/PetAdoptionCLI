package core.methods_responseUser;

import exception.TerminalExceptionNumber;
import pet.Pet;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ResponseQuestionForm06 {
    public static void responseQuestionForm06() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("R: ");
                String responseRegistrationPet = scanner.nextLine();

                String regex = "^(?:[0-9]|1[0-9]|20)$";
                Pattern pattern = Pattern.compile(regex);
                boolean valido = pattern.matcher(responseRegistrationPet).matches();

                if (!valido) {
                    throw new TerminalExceptionNumber("Entrada inválida: digite um valor de 0 a 20.");
                }

                if (responseRegistrationPet.trim().isEmpty()){
                    responseRegistrationPet = Pet.NAO_INFORMADO;
                }

                break;
            } catch (TerminalExceptionNumber e) {
                System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
            }
        }
    }
}
