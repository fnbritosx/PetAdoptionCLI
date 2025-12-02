package core.methods_responseUser;

import exception.ResponseFormException;
import src.model.entity.TypePet;

import java.io.IOException;
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
                    throw new ResponseFormException("Tipo inválido! Digite 'CACHORRO' ou 'GATO'.");
                }

                String typePetResponse = "2 - " + responseRegistrationPet;
                PetFormFileWriter.writerFile(PetFormFileWriter.finalFile, typePetResponse);

                break;
            } catch (ResponseFormException | IOException e) {
                System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
            }
        }
    }
}
