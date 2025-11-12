package core.methods_responseUser;

import exception.TerminalExceptionCharacter;
import pet.Pet;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ResponseQuestionForm01 {
    public static void responseQuestionForm01() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("R: ");
                String responseRegistrationPet = scanner.nextLine().trim();

                if (responseRegistrationPet.isEmpty()){
                    responseRegistrationPet = Pet.NAO_INFORMADO;
                }

                String responseRegistrationPetUper = responseRegistrationPet.toUpperCase().replaceAll("\\s", "");
                String regex = "^[A-Za-zÀ-ÿ]+(?: [A-Za-zÀ-ÿ]+)*$";
                Pattern pattern = Pattern.compile(regex);
                boolean valido = pattern.matcher(responseRegistrationPet).matches();

                if (!valido && !responseRegistrationPet.equals(Pet.NAO_INFORMADO)) {
                    throw new TerminalExceptionCharacter("Entrada inválida: digite o nome correto do seu pet.");
                }

                // Preciso colocar a criação do arquivo em outra classe.
                // Essa nova classe precisa conversar essa classe para respeitar os requisitos de negócio.
                LocalDateTime localDateTime = LocalDateTime.now();
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
                String dateFormated = localDateTime.format(dateTimeFormatter);

                File folder = new File("C:\\Users\\febne\\OneDrive\\Documentos\\PetAdoptionCLI\\core\\form\\");

                File file = new File(folder + "\\" + dateFormated + "-" + responseRegistrationPetUper + ".txt");

                try (FileWriter fileWriter = new FileWriter(file)) {
                    fileWriter.write("1. " + responseRegistrationPet);
                }

                break;
            }catch (TerminalExceptionCharacter | IOException e){
                System.out.println("\u001B[1m\u001B[31m" + e.getMessage() + "\u001B[0m");
            }
        }
    }
}
