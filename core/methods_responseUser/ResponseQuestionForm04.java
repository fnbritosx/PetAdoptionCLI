package core.methods_responseUser;

import exception.TerminalExceptionCharacter;
import pet.Pet;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ResponseQuestionForm04 {
    public static void main(String[] args) {
        responseQuestionForm04();
    }

    public static void responseQuestionForm04() {
        Scanner scanner = new Scanner(System.in);

        String numeroCasa = "";
        while (true) {
            try {
                System.out.print("i. Número da casa: ");
                numeroCasa = scanner.nextLine().trim();

                String regexNumeroCasa = "^[0-9]{1,5}$";
                if (!Pattern.matches(regexNumeroCasa, numeroCasa)) {
                    throw new TerminalExceptionCharacter("Entrada inválida: digite um número de até 5 dígitos.");
                }

                if (numeroCasa.trim().isEmpty()){
                    numeroCasa = Pet.NAO_INFORMADO;
                }

                break;
            } catch (TerminalExceptionCharacter e) {
                System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
            }
        }

        String cidade = "";
        while (true) {
            try {
                System.out.print("ii. Cidade: ");
                cidade = scanner.nextLine().trim();

                String regexCidade = "^[A-Za-zÀ-ú ]{1,40}$";
                if (!Pattern.matches(regexCidade, cidade)) {
                    throw new TerminalExceptionCharacter("Entrada inválida: você não digitou um caractere válido.");
                }

                break;
            } catch (TerminalExceptionCharacter e) {
                System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
            }
        }

        String rua = "";
        while (true) {
            try {
                System.out.print("iii. Rua: ");
                rua = scanner.nextLine().trim();

                String regexRua = "^[A-Za-zÀ-ú ]{1,47}[0-9]{0,3}$";
                if (!Pattern.matches(regexRua, rua)) {
                    throw new TerminalExceptionCharacter("Entrada inválida: você não digitou um caractere válido.");
                }

                break;
            } catch (TerminalExceptionCharacter e) {
                System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
            }
        }
    }
}
