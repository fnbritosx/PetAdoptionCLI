package view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChangePetView {
    Scanner scanner;
    private final HashMap<Integer, String> mapAttributes = new HashMap<>();

    public ChangePetView() {
        scanner = new Scanner(System.in);

        mapAttributes.put(1, "Nome");
        mapAttributes.put(2, "Rua");
        mapAttributes.put(3, "Número");
        mapAttributes.put(4, "Cidade");
        mapAttributes.put(5, "Peso");
        mapAttributes.put(6, "Raça");
    }


    public void readerAllPets(String linesForm) {
        System.out.println(linesForm);
    }

    public String whichPet() {
        System.out.println("Qual pet deseja alterar?");

        System.out.print("R: ");
        return scanner.nextLine();
    }


    public String petAttributes() {
        System.out.println("Qual atributo do pet deseja alterar?");

        for (Map.Entry<Integer, String> values : mapAttributes.entrySet()) {
            System.out.println(values.getKey() + " - " + values.getValue());
        }

        System.out.print("R: ");
        return scanner.nextLine();
    }


    public String newPetAttribute(String response) {
        int numberResponse = Integer.parseInt(response);

        System.out.print(mapAttributes.get(numberResponse) + ": ");
        return scanner.nextLine();
    }


    public String proceedPetAttributes() {
        System.out.println("Deseja continuar as alterações no pet?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");

        System.out.print("R: ");
        return scanner.nextLine();
    }
}
