package core.methods_responseUser;

import exception.NamePetExcepetion;
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

                break;
            } catch (NamePetExcepetion e) {
                System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
            }
        }
    }
}
