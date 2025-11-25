package core.methods_responseUser;

import exception.MenuNumberException;
import exception.ResponseFormException;
import pet.Pet;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ResponseQuestionForm05 {
    public static void responseQuestionForm05() {
        while (true) {
            try {
                System.out.print("R: ");
                Scanner scanner = new Scanner(System.in);
                String responseRegistrationPet = scanner.nextLine();

                if (responseRegistrationPet.isEmpty()){
                    responseRegistrationPet = Pet.NAO_INFORMADO;
                }

                String regex = "^[0-9]{1,2}([.,][0-9]{1,2})?$";

                Pattern pattern = Pattern.compile(regex);
                boolean valido = pattern.matcher(responseRegistrationPet).matches();

                if (!valido && !responseRegistrationPet.equals(Pet.NAO_INFORMADO)) {
                    throw new ResponseFormException("Entrada inválida: digite a idade do pet em anos, com até 2 dígitos e opcionalmente até 2 decimais (ex: 5, 3.5, 12.25).");
                }

                String agePet = "5 - " + responseRegistrationPet + " anos";
                PetFormFileWriter.writerFile(PetFormFileWriter.finalFile, agePet);

                break;
            }catch (ResponseFormException | IOException e){
                System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
            }
        }
    }
}
