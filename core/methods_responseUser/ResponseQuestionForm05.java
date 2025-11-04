package core.methods_responseUser;

import exception.TerminalExceptionCharacter;
import exception.TerminalExceptionNumber;

import java.util.Scanner;

public class ResponseQuestionForm05 {
    public static void responseQuestionForm05(){
        System.out.println("R: ");
        Scanner scanner = new Scanner(System.in);
        String responseRegistrationPet = scanner.nextLine();
        for (int i = 0; i <responseRegistrationPet.length() ; i++) {
            if (!Character.isDigit(responseRegistrationPet.charAt(i))){
                throw new TerminalExceptionCharacter();
            }
            if (i > 1 && (responseRegistrationPet.charAt(2) != '.' || responseRegistrationPet.charAt(2) != ',')){
                throw new TerminalExceptionNumber();
            }
        }

        int newResponseRegistrationPet = Integer.parseInt(responseRegistrationPet);

        if (newResponseRegistrationPet > 240){
            throw new TerminalExceptionNumber();
        }
        if (newResponseRegistrationPet < 12){
            
        }
    }
}
