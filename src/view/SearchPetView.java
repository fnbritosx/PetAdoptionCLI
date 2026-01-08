package view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class SearchPetView {
    private final Scanner scanner;
    private final Map<Integer, String> hashMapType = new HashMap<>();
    public final Map<Integer, String> hashMapCriteria = new HashMap<>();
    private final Map<Integer, String> hashMapProceedCriteria = new HashMap<>();
    private final Map<Integer, String> mapAddress = new HashMap<>();

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

        mapAddress.put(1, "Rua");
        mapAddress.put(2, "Número");
        mapAddress.put(3, "Cidade");

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

        return scanner.nextLine();
    }


    public String newMenuCriteria(String responseFirstCriteria) {
        System.out.println("Escolha um novo critério");

        Map<Integer, String> criteriaCopy = new HashMap<>(hashMapCriteria);

        int choiceFirstCriteria = Integer.parseInt(responseFirstCriteria);
        criteriaCopy.remove(choiceFirstCriteria);

        for (int key : criteriaCopy.keySet()) {
            System.out.println(key + " - " + hashMapCriteria.get(key));
        }

        System.out.print("R: ");
        return scanner.nextLine();
    }


    public String getQuestion(String response, String numberAddress) {
        int responseInt = Integer.parseInt(response);

        int intNumberAddress = Integer.parseInt(numberAddress);

        String value = mapAddress.get(intNumberAddress);

        if (responseInt == 6){
        System.out.print(hashMapCriteria.get(responseInt) + " - " + value + ": ");
        } else {
            System.out.print(hashMapCriteria.get(responseInt) + ": ");
        }

        return scanner.nextLine();
    }

    public String address(){
        System.out.println("Digite o subtipo do endereço: ");
        for (Map.Entry<Integer, String> address : mapAddress.entrySet()){
            System.out.println(address.getKey() + " - " + address.getValue());
        }

        System.out.print("R: ");

        return scanner.nextLine();
    }
}
