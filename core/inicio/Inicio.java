package core.inicio;

import java.util.Scanner;

public class Inicio {
    public static void main(String[] args) {
        Scanner respostaInicio = new Scanner(System.in);

        System.out.println("1. Cadastrar um novo pet");
        System.out.println("2. Alterar os dados do pet cadastrado");
        System.out.println("3. Deletar um pet cadastrado");
        System.out.println("4. Listar todos os pets cadastrados");
        System.out.println("5. Listar pets por algum critério (idade, nome, raça)");
        System.out.println("6. Sair");

    }
}
