package core.methods_responseUser;


import exception.NamePetExcepetion;
import pet.Pet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class RegistrationPet {
    public static void registrationPet() {
        Scanner scanner = new Scanner(System.in);

        File file = new File("C:\\Users\\febne\\OneDrive\\Documentos\\PetAdoptionCLI\\core\\form\\form.txt");
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                System.out.print("R: ");
                String responseRegistrationPet = scanner.nextLine();
                for (int i = 0; i < responseRegistrationPet.length(); i++) {
                    if (!Character.isLetterOrDigit((responseRegistrationPet.charAt(i))) || responseRegistrationPet.isBlank()
                            || Character.isDigit(responseRegistrationPet.charAt(i)) || !responseRegistrationPet.contains(" ")) {
                        throw new NamePetExcepetion();
                    }
                }

                Pet.responseUserForm(responseRegistrationPet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
