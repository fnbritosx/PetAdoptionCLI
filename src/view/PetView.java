package src.view;

import java.util.List;
import java.util.Scanner;

public class PetView {
    Scanner scannerResponseUser = new Scanner(System.in);

    public void readerLineForm(String linesForm){
        System.out.println(linesForm);
    }

    public String responseUser (){
        System.out.print("R: ");
        return scannerResponseUser.nextLine();
    }
    private final List<String> subQuestions = List.of(
            "i. Número da casa",
            "ii. Rua",
            "iii. Cidade"
    );

    public List<String> getSubQuestions(){
        return subQuestions;
    }
}
