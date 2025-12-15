package view;

import java.util.Scanner;

public class SearchPetView {
    private final Scanner scanner;

    public SearchPetView(){
        this.scanner = new Scanner(System.in);
    }

    public String animalType(){
        System.out.println("Escolha o tipo de animal");
        System.out.println("1 - Cachorro");
        System.out.println("2 - Gato");

        System.out.print("R: ");

        return scanner.nextLine();
    }


    public String searchCriteria(){
        System.out.println("Selecione até 2 critérios de busca");
        System.out.println("1 - Nome ou Sobrenome");
        System.out.println("2 - Sexo");
        System.out.println("3 - Idade");
        System.out.println("4 - Peso");
        System.out.println("5 - Raça");
        System.out.println("6 - Endereço");

        System.out.print("R: ");

        return scanner.nextLine();
    }

    public String proceedCriterion(){
        System.out.println("Deseja selecionar mais um critério?");
        System.out.println("1 - SIM");
        System.out.println("2 - NÃO");

        System.out.print("R: ");

        return scanner.nextLine();
    }
}
