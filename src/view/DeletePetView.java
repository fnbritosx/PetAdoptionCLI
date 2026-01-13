package view;

import java.util.Scanner;

public class DeletePetView {
    private final Scanner scanner;

    public DeletePetView(){
        this.scanner = new Scanner(System.in);
    }


    public void readerLine(String line){
        System.out.println(line);
    }


    public String askDeleteLine(){
        System.out.println();
        System.out.println("Qual linha deseja deletar? ");

        System.out.print("R: ");

        return scanner.nextLine();
    }


    public String confirmDeleteLine(String line){
        System.out.println();
        System.out.println("Tem certeza de que quer deletar a linha: " + "\n");

        System.out.println(line + "\n");

        System.out.println("1- Sim");
        System.out.println("2 - Não");

        System.out.print("R: ");

        return scanner.nextLine();
    }

}
