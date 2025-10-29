package core.start;

import core.methods_responseUser.RegistrationPet;
import exception.TerminalExceptionCharacter;
import exception.TerminalExceptionNumber;
import exception.TerminalNullException;

import java.util.Scanner;

public class StartCLI {

    public static void main(String[] args) throws InterruptedException {
        startTerminal();
    }

    public static void startTerminal() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n--- MENU ---");
                System.out.println("1. Cadastrar um novo pet");
                System.out.println("2. Alterar os dados do pet cadastrado");
                System.out.println("3. Deletar um pet cadastrado");
                System.out.println("4. Listar todos os pets cadastrados");
                System.out.println("5. Listar pets por algum critério (idade, nome, raça)");
                System.out.println("6. Sair");
                System.out.print("Digite um número: ");

                String responseUser = scanner.nextLine();

                if (responseUser.isBlank()) {
                    throw new TerminalNullException();
                }

                for (int i = 0; i < responseUser.length(); i++) {
                    if (!Character.isDigit(responseUser.charAt(i))) {
                        throw new TerminalExceptionCharacter();
                    }
                }

                int responseUserInt = Integer.parseInt(responseUser);

                if (responseUserInt > 6 || responseUserInt <= 0) {
                    throw new TerminalExceptionNumber();
                }

                if (responseUserInt == 6) {
                    System.out.println("Encerrando o programa...");
                    break;
                }
                if (responseUserInt == 1){
                    RegistrationPet.registrationPet();
                    break;
                }

            } catch (TerminalNullException | TerminalExceptionCharacter | TerminalExceptionNumber e) {
                System.out.println(e.getMessage());
                Thread.sleep(1000);
            }
        }
        scanner.close();
    }
}
