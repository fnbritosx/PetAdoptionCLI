package src.view;

import java.util.Scanner;

public class RegistrationPetView {
    Scanner scannerResponseUser = new Scanner(System.in);

    public void readerLineForm(String linesForm){
        System.out.println(linesForm);
    }

    public String responseUser (){
        System.out.print("R: ");
        return scannerResponseUser.nextLine();
    }

    public void questionFourForm(){
        System.out.println("i. Número da casa");
        System.out.println("ii. Cidade");
        System.out.println("iii. Rua");
    }
}
