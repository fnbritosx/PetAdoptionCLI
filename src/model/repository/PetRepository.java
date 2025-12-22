package model.repository;

import model.entity.Pet;
import model.entity.PetSex;
import model.entity.PetType;

import java.io.*;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PetRepository {
    private static final File pathForm = new File("C:\\Users\\14994165718\\Documents\\PetAdoptionCLI\\src\\model\\repository\\form\\form.txt");
    private static final File pathRegisteredPets = new File("C:\\Users\\14994165718\\Documents\\PetAdoptionCLI\\src\\model\\repository\\pets");
    private static final File dirAllPets = new File("C:\\Users\\14994165718\\Documents\\PetAdoptionCLI\\src\\model\\repository\\allpets");
    private static final File fileAllPets = new File(dirAllPets, "allPets.txt");

    public List<String> getQuestionsForm() throws IOException {
        return Files.readAllLines(pathForm.toPath());
    }

    public File getPathAllPets(){
        return fileAllPets;
    }

    public File createdFile(String petName) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
        String dateFormated = localDateTime.format(dateTimeFormatter);

        if (!pathRegisteredPets.exists()) {
            pathRegisteredPets.mkdirs();
        }

        File file = new File(pathRegisteredPets + "\\" + dateFormated + "-" + petName.toUpperCase().replaceAll("\\s+", "") + ".txt");

        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao criar o arquivo " + file.getAbsolutePath(), e);
        }
        return file;
    }

    public void writePetToFile(File file, String response) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(response);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao escrever no arquivo " + file.getAbsolutePath(), e);
        }
    }

    public void writeAllPetToFile(String response) throws IOException {

        if (!dirAllPets.exists()){
            dirAllPets.mkdirs();
        }

        if (!fileAllPets.exists()){
            try {
                fileAllPets.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        long totalLinesFile;

        try(Stream<String> lines = Files.lines(fileAllPets.toPath())){
            totalLinesFile = lines.count() + 1;
        }

        try (FileWriter fileWriter = new FileWriter(fileAllPets, true)) {
            fileWriter.write(totalLinesFile + " - " + response + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("Erro ao escrever no arquivo " + dirAllPets.getAbsolutePath(), e);
        }
    }

    public List<Pet> getAllPets() throws IOException {
        List<String> reader = Files.readAllLines(fileAllPets.toPath());
        List<Pet> pets = new ArrayList<>();


        for (String line : reader){
            Pet pet = new Pet();
            String[] fields = line.split(" - ");

            pet.setName(fields[1]);
            pet.setType(PetType.valueOf(fields[2]));
            pet.setSex(PetSex.valueOf(fields[3]));

            if(fields[4] != null){
                String[] fieldFour = fields[4].split(",");
                pet.setStreet(fieldFour[0]);
                pet.setHouseNumber(fieldFour[1]);
            }

            pet.setCity(fields[5]);
            pet.setAge(fields[6]);
            pet.setWeight(fields[7]);
            pet.setBreed(fields[8]);

            pets.add(pet);
        }
        return pets;
    }
}

