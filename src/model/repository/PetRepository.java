package model.repository;

import model.entity.Pet;
import model.entity.PetSex;
import model.entity.PetType;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    private static final String dirFilterPet= "C:\\Users\\14994165718\\Documents\\PetAdoptionCLI\\src\\model\\repository\\petscadastrados";
    private static final String fileFilterPet = dirFilterPet + "/pets_filtrados.txt";


    public List<String> getQuestionsForm() throws IOException {
        return Files.readAllLines(pathForm.toPath());
    }

    public List<String> getAllPets() throws IOException {
        return Files.readAllLines(fileAllPets.toPath());
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

    public Pet getAllPets(String line) {

        String withoutNumber = line.substring(line.indexOf(" - ") + 3);
        String[] fields = withoutNumber.split(" - ");

        Pet pet = new Pet();

        pet.setName(fields[0]);
        pet.setType(PetType.valueOf(fields[1].toUpperCase()));
        pet.setSex(PetSex.valueOf(fields[2].toUpperCase()));

        String address = fields[3];
        int commaPosition = address.indexOf(",");

        String street = address.substring(0, commaPosition).trim();
        pet.setStreet(street);

        String houseNumber = address.substring(commaPosition + 1).trim();
        pet.setHouseNumber(houseNumber);

        pet.setCity(fields[4]);
        pet.setAge(fields[5]);
        pet.setWeight(fields[6]);
        pet.setBreed(fields[7]);

        return pet;
    }

    public List<Pet> getAllPetsFromFile() throws IOException {
        List<String> lines = Files.readAllLines(fileAllPets.toPath());
        List<Pet> pets = new ArrayList<>();

        for (String line : lines) {
            Pet pet = getAllPets(line);
            pets.add(pet);
        }

        return pets;
    }


    public void saveFilteredPets(List<Pet> pets) throws IOException {

        File directory = new File(dirFilterPet);
        if (!directory.exists()) {
            directory.mkdir();
        }

        List<String> lines = new ArrayList<>();

        int counter = 1;
        for (Pet pet : pets) {
            String line = counter + " - " + pet.formattedAllPets();
            lines.add(line);
            counter++;
        }

        Path path = Paths.get(fileFilterPet);
        Files.write(path, lines);
    }


    public void displayFilteredPets() throws IOException {
        Path path = Paths.get(fileFilterPet);
        List<String> lines = Files.readAllLines(path);

        System.out.println("\n=== PETS ENCONTRADOS ===\n");
        for (String line : lines) {
            System.out.println(line);
        }
    }
}

