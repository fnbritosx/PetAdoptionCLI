package core.methods_responseUser;

import exception.ResponseFormException;
import src.model.entity.PetConstants;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ResponseQuestionForm04 {
    public static void responseQuestionForm04() {
        Scanner scanner = new Scanner(System.in);

        String numberHouse = "";
        while (true) {
            try {
                System.out.print("i. Número da casa: ");
                numberHouse = scanner.nextLine().trim();

                if (numberHouse.isEmpty()) {
                    numberHouse = PetConstants.NAO_INFORMADO;
                }

                String regexNumberHouse = "^[0-9]{1,5}$";
                if (!Pattern.matches(regexNumberHouse, numberHouse) && !numberHouse.equals(PetConstants.NAO_INFORMADO)) {
                    throw new ResponseFormException("Entrada inválida: digite um número de até 5 dígitos.");
                }

                break;
            } catch (ResponseFormException e) {
                System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
            }
        }

        String city = "";
        while (true) {
            try {
                System.out.print("ii. Cidade: ");
                city = scanner.nextLine().trim();

                String regexCity = "^[A-Za-zÀ-ú ]{1,40}$";
                if (!Pattern.matches(regexCity, city)) {
                    throw new ResponseFormException("Entrada inválida: você não digitou uma cidade válida.");
                }
                break;
            } catch (ResponseFormException e) {
                System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
            }
        }

        String road = "";
        while (true) {
            try {
                System.out.print("iii. Rua: ");
                road = scanner.nextLine().trim();

                String regexRua = "^[A-Za-zÀ-ú ]{1,47}[0-9]{0,3}$";
                if (!Pattern.matches(regexRua, road)) {
                    throw new ResponseFormException("Entrada inválida: você não digitou uma rua válida.");
                }

                break;
            } catch (ResponseFormException e) {
                System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
            }
        }

        try {
            String fullAddress = "4 - Rua " + road + ", " + numberHouse + ", " + city;
            PetFormFileWriter.writerFile(PetFormFileWriter.finalFile, fullAddress);
        } catch (IOException e) {
            System.out.println("\u001B[1m\u001B[31mErro ao escrever no arquivo: " + e.getMessage() + "\u001B[0m");
        }
    }
}
