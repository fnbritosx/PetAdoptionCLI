package core.methods_responseUser;

import exception.NamePetExcepetion;
import pet.Pet;
import pet.TypePet;

import java.util.Scanner;

public class ResponseQuestionForm02 {
    public static void responseQuestionForm02() {
        while (true) {
            try {
                System.out.print("R: ");
                TypePet typePet = null;

                Scanner scanner = new Scanner(System.in);
                String responseRegistrationPet = scanner.nextLine().toUpperCase().trim();

                try {
                    typePet = TypePet.valueOf(responseRegistrationPet);
                } catch (IllegalArgumentException  e) {
                    throw new NamePetExcepetion("Tipo inválido! Digite 'CACHORRO' ou 'GATO'.");
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
