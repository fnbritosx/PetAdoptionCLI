package core.methods_responseUser;

import exception.ResponseFormException;
import src.model.entity.SexPet;

import java.io.IOException;
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
                    throw new ResponseFormException("Tipo inválido! Digite 'MACHO' ou 'FÊMEA'.");
                }

                String sexPetResponse = "3 - " + responseRegistrationPet;
                PetFormFileWriter.writerFile(PetFormFileWriter.finalFile, sexPetResponse);
                break;
            } catch (ResponseFormException| IOException e) {
                System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
            }
        }
    }
}
