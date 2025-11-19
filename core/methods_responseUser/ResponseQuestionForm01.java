package core.methods_responseUser;

import exception.TerminalExceptionCharacter;
import pet.Pet;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ResponseQuestionForm01 {
    public static void responseQuestionForm01() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("R: ");
                String responseRegistrationPet = scanner.nextLine().trim();

                if (responseRegistrationPet.isEmpty()) {
                    responseRegistrationPet = Pet.NAO_INFORMADO;
                }

                String regex = "^[A-Za-zÀ-ÿ]+(?: [A-Za-zÀ-ÿ]+)*$";
                Pattern pattern = Pattern.compile(regex);

                boolean valido = pattern.matcher(responseRegistrationPet).matches();

                if (!valido && !responseRegistrationPet.equals(Pet.NAO_INFORMADO)) {
                    throw new TerminalExceptionCharacter("Entrada inválida: digite o nome correto do seu pet.");
                }

                File filePath = PetFormFileWriter.createdFile(responseRegistrationPet);

                String namePet = "1 - " + responseRegistrationPet;
                PetFormFileWriter.writerFile(filePath, namePet);

                break;
            } catch (TerminalExceptionCharacter | IOException e) {
                System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
            }
        }
    }
}
