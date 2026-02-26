package controller;

import model.repository.PetRepository;
import model.service.DeletePetService;
import view.DeletePetView;

import java.util.ArrayList;
import java.util.List;

public class DeletePetController {
    private final PetRepository repository;
    private final DeletePetView view;
    private final DeletePetService service;


    public DeletePetController() {
        this.repository = new PetRepository();
        this.view = new DeletePetView();
        this.service = new DeletePetService();
    }

    public void start() {

        while (true) {
            try {
                List<String> allLines = repository.getAllPetsLines();

                if (allLines.isEmpty()) {
                    formattedRed("Não há pets cadastrados.");
                    return;
                }

                for (String line : allLines) {
                    view.readerLine(line);
                }

                String idForDelete = view.askDeleteLine();
                System.out.println();

                String selectedLine = null;
                for (String line : allLines) {
                    if (line.startsWith(idForDelete + " - ")) {
                        selectedLine = line;
                        break;
                    }
                }

                if (selectedLine == null) {
                    formattedRed("ID não encontrado!" + "\n");
                    continue;
                }


                String confirm = service.validateConfirm(view.confirmDeleteLine(selectedLine));


                if (confirm.equals("2")) {
                    System.out.println();
                    formattedGreen("Operação cancelada.");
                    continue;
                }

                if (confirm.equals("1")) {

                    List<String> newList = new ArrayList<>();

                    int novoId = 1;

                    for (String line : allLines) {
                        if (!line.startsWith(idForDelete + " - ")) {

                            String datePet = line.substring(line.indexOf(" - ") + 3);

                            newList.add(novoId + " - " + datePet);
                            novoId++;
                        }
                    }

                    repository.updateFileAfterDelete(newList);

                    formattedGreen("Pet deletado com sucesso!");
                    break;
                }
            } catch (Throwable e) {
                System.out.println();
                System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m " + "\n");
            }
        }
    }

    private void formattedRed(String e) {
        System.out.println("\u001B[1m\u001B[31m" + e + "\u001B[0m " + "\n");
    }

    private void formattedGreen(String e) {
        System.out.println("\u001B[1m\u001B[32m" + e + "\u001B[0m " + "\n");
    }
}
