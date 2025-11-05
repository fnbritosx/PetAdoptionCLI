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
                    ResponseQuestionForm01.responseQuestionForm01();
                }

                if (line.startsWith("2")) {
                    ResponseQuestionForm02.responseQuestionForm02();
                }

                if (line.startsWith("3")) {
                    ResponseQuestionForm03.responseQuestionForm03();
                }

                if (line.startsWith("4")) {
                    ResponseQuestionForm04.responseQuestionForm04();
                }

                if (line.startsWith("5")){
                    ResponseQuestionForm05.responseQuestionForm05();
                }
            }

            System.out.println(Pet.getResponseUserForm());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
