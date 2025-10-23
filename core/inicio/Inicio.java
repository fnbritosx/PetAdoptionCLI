package core.inicio;

import exception.InicioExceptionCaractere;
import exception.InicioExceptionNumero;
import exception.InicioNullException;

import java.util.Scanner;

public class Inicio {
    public static void main(String[] args) throws InicioNullException, InicioExceptionCaractere, InicioExceptionNumero{
        try {
            InicioTerminal();
        } catch (InicioNullException e) {
            throw new InicioNullException();
        } catch (InicioExceptionCaractere e) {
            throw new InicioExceptionCaractere();
        } catch (InicioExceptionNumero e) {
            throw new InicioExceptionNumero();
        }
    }

    public static void InicioTerminal() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Cadastrar um novo pet");
        System.out.println("2. Alterar os dados do pet cadastrado");
        System.out.println("3. Deletar um pet cadastrado");
        System.out.println("4. Listar todos os pets cadastrados");
        System.out.println("5. Listar pets por algum critério (idade, nome, raça)");
        System.out.println("6. Sair");

        System.out.println("Digite um número: ");
        String respostaUsuario = scanner.nextLine();

        if (respostaUsuario.isEmpty()) {
            throw new InicioNullException();
        }

//        if (respostaUsuario.charAt(0)) {
//            throw new InicioExceptionCaractere();
//        }
//        if (respostaUsuario) {
//            throw new InicioExceptionNumero();
//        }
    }
}
