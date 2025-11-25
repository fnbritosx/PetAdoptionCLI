package core.methods_responseUser;

import exception.ResponseFormException;
import pet.Pet;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ResponseQuestionForm07 {
    public static void responseQuestionForm07() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("R: ");
                String responseRegistrationPet = scanner.nextLine();

                if (responseRegistrationPet.isEmpty()) {
                    responseRegistrationPet = Pet.NAO_INFORMADO;
                }

                String regex = "^[A-Za-zÀ-ÿ ]+$";
                Pattern pattern = Pattern.compile(regex);
                boolean valido = pattern.matcher(responseRegistrationPet).matches();

                if (!valido && !responseRegistrationPet.equals(Pet.NAO_INFORMADO)) {
                    throw new ResponseFormException("Entrada inválida: digite a raça correta do seu pet.");
                }

                String breedPet = "7 - " + responseRegistrationPet;
                PetFormFileWriter.writerFile(PetFormFileWriter.finalFile, breedPet);

                break;
            } catch (ResponseFormException | IOException e) {
                System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
            }
        }
    }
}
