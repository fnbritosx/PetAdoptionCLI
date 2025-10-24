package core.start;

import exception.TerminalExceptionCharacter;
import exception.TerminalExceptionNumber;
import exception.TerminalNullException;

import java.util.Scanner;

public class StartCLI {
    public static void main(String[] args) throws TerminalNullException, TerminalExceptionCharacter, TerminalExceptionNumber {
        try {
            StartTerminal();
        } catch (TerminalNullException e) {
            throw new TerminalNullException();
        } catch (TerminalExceptionCharacter e) {
            throw new TerminalExceptionCharacter();
        } catch (TerminalExceptionNumber e) {
            throw new TerminalExceptionNumber();
        }
    }

    public static void StartTerminal() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Cadastrar um novo pet");
        System.out.println("2. Alterar os dados do pet cadastrado");
        System.out.println("3. Deletar um pet cadastrado");
        System.out.println("4. Listar todos os pets cadastrados");
        System.out.println("5. Listar pets por algum critério (idade, nome, raça)");
        System.out.println("6. Sair");

        System.out.println("Digite um número: ");
        String responseUser = scanner.nextLine();

        if (responseUser.isBlank()) {
            throw new TerminalNullException();
        }

//        if (responseUser.charAt(0)) {
//            throw new TerminalExceptionCharacter();
//        }
//        if (responseUser) {
//            throw new TerminalExceptionNumber();
//        }
    }
}
