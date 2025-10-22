package core.formulario.test;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FormularioTest01 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\febne\\OneDrive\\Documentos\\PetAdoptionCLI\\core\\formulario\\main\\formulario.txt");
        try (FileReader fileReader = new FileReader(file)) {
            int i;
            while ((i = fileReader.read()) != -1)
                System.out.print((char) i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
