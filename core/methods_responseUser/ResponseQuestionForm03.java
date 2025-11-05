package core.methods_responseUser;

import exception.NamePetExcepetion;
import pet.Pet;
import pet.SexPet;

import java.util.Scanner;

public class ResponseQuestionForm03 {
    public static void responseQuestionForm03() {
        while (true) {
            try {
                System.out.print("R: ");
                SexPet sexPet = null;

                Scanner scanner = new Scanner(System.in);
                String responseRegistrationPet = scanner.nextLine().toUpperCase().trim();

                try {
                    sexPet = SexPet.valueOf(responseRegistrationPet);
                } catch (IllegalArgumentException e) {
                    throw new NamePetExcepetion("Tipo inválido! Digite 'MACHO' ou 'FÊMEA'.");
                }
                Pet.responseUserForm(responseRegistrationPet);
                break;
            } catch (NamePetExcepetion e) {
                final String RED_BOLD = "\u001B[1m\u001B[31m";
                final String RESET = "\u001B[0m";

                System.out.println(RED_BOLD + e.getMessage() + RESET);
            }
        }
    }
}
