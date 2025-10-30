package core.methods_responseUser;


import pet.Pet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class RegistrationPet {
    public static void registrationPet() {
        File file = new File("C:\\Users\\febne\\OneDrive\\Documentos\\PetAdoptionCLI\\core\\form\\form.txt");

        try (FileReader fileReader = new FileReader(file); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);

                if (line.startsWith("1")) {
                    ResponseQuestionOne.responseQuestionOne();
                }

                if (line.startsWith("2")) {
                    ResponseQuestionTwo.responseQuestionTwo();
                }

                if (line.startsWith("3")) {
                    ResponseQuestionThree.responseQuestionThree();
                }
            }

            System.out.println(Pet.getResponseUserForm());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
