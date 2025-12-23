package view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SearchPetView {
    private final Scanner scanner;
    private final Map<Integer, String> hashMapType = new HashMap<>();
    public final Map<Integer, String> hashMapCriteria = new HashMap<>();
    private final Map<Integer, String> hashMapProceedCriteria = new HashMap<>();

    public SearchPetView() {
        this.scanner = new Scanner(System.in);

        hashMapType.put(1, "Cachorro");
        hashMapType.put(2, "Gato");

        hashMapCriteria.put(1, "Nome ou Sobrenome");
        hashMapCriteria.put(2, "Sexo");
        hashMapCriteria.put(3, "Idade");
        hashMapCriteria.put(4, "Peso");
        hashMapCriteria.put(5, "Raça");
        hashMapCriteria.put(6, "Endereço");

        hashMapProceedCriteria.put(1, "Sim");
        hashMapProceedCriteria.put(2, "Não");

    }


    public String menuType() {
        System.out.println("Escolha o tipo de animal");
        for (Map.Entry<Integer, String> entry : hashMapType.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        System.out.print("R: ");
        return scanner.nextLine();
    }


    public String menuCriteria() {
        System.out.println("Escolha o primeiro critério de busca");
        for (Map.Entry<Integer, String> entry : hashMapCriteria.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        System.out.print("R: ");
        return scanner.nextLine();
    }


    public String proceedCriterion() {
        System.out.println("Deseja selecionar mais um critério?");
        for (Map.Entry<Integer, String> proceedCriterion : hashMapProceedCriteria.entrySet()) {
            System.out.println(proceedCriterion.getKey() + " - " + proceedCriterion.getValue());
        }

        System.out.print("R: ");
        String response = scanner.nextLine();

        int responseInt = Integer.parseInt(response);
        return hashMapProceedCriteria.get(responseInt).toLowerCase();
    }


    public String newMenuCriteria(String responseFirstCriteria) {
        System.out.println("Escolha um novo critério");

        int choiceFirstCriteria = Integer.parseInt(responseFirstCriteria);
        hashMapCriteria.remove(choiceFirstCriteria);

        for (int key : hashMapCriteria.keySet()) {
            System.out.println(key + " - " + hashMapCriteria.get(key));
        }

        System.out.print("R: ");
        return scanner.nextLine();
    }


    public String getQuestionOne(String response) {
        int responseInt = Integer.parseInt(response);
        return hashMapCriteria.get(responseInt);
    }


    public String getQuestionTwo(String response) {
        int responseInt = Integer.parseInt(response);
        return hashMapCriteria.get(responseInt);
    }
}
