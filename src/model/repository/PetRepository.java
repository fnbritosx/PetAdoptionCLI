package model.repository;

import model.entity.Pet;
import model.entity.PetSex;
import model.entity.PetType;
import model.exception.ChangePetException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class PetRepository {

    private static final File pathRepository = new File("C:\\Users\\14994165718\\Documents\\PetAdoptionCLI\\src\\model\\repository");

    private static final File pathForm = new File(pathRepository + "\\form\\form.txt");

    private static final File pathRegisteredPets = new File(pathRepository + "\\pets");

    private static final File dirAllPets = new File(pathRepository + "\\allpets");

    private static final File fileAllPets = new File(dirAllPets + "\\allPets.txt");

    private static final String dirFilterPet = pathRepository + "\\petscadastrados";

    private static final String fileFilterPet = dirFilterPet + "\\pets_filtrados.txt";


    public List<String> getQuestionsForm() throws IOException {
        return Files.readAllLines(pathForm.toPath());
    }


    public List<String> getAllPetsLines() {
        try {
            return Files.readAllLines(fileAllPets.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Erro ao achar os pets.");
        }
    }


    public String getFilterPet() {
        return fileFilterPet;
    }


    public List<Pet> findAll() throws IOException {
        List<String> lines = Files.readAllLines(fileAllPets.toPath());
        List<Pet> pets = new ArrayList<>();

        for (String line : lines) {
            pets.add(petFromLine(line));
        }

        return pets;
    }


    public File createdFile(String petName) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
        String dateFormated = localDateTime.format(dateTimeFormatter);

        if (!pathRegisteredPets.exists()) {
            pathRegisteredPets.mkdirs();
        }

        File file = new File(
                pathRegisteredPets + "\\" +
                        dateFormated + "-" +
                        petName.toUpperCase().replaceAll("\\s+", "") + ".txt"
        );

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


    public Map.Entry<String, String> changePet(String numberPet, Pet updatedPet) {

        List<String> updatedLines = new ArrayList<>();
        String oldLine = null;
        String newLine = null;

        for (String line : getAllPetsLines()) {

            if (line.startsWith(numberPet + " - ")) {
                oldLine = line;
                newLine = numberPet + " - " + updatedPet.formattedAllPets();
                updatedLines.add(newLine);
            } else {
                updatedLines.add(line);
            }
        }

        if (oldLine == null) {
            throw new ChangePetException("Pet não encontrado.");
        }

        try {
            Files.write(fileAllPets.toPath(), updatedLines);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao atualizar o pet.", e);
        }

        return Map.entry(oldLine, newLine);
    }


    public void writeAllPetToFile(String response) throws IOException {

        if (!dirAllPets.exists()) {
            dirAllPets.mkdirs();
        }

        if (!fileAllPets.exists()) {
            fileAllPets.createNewFile();
        }

        long totalLinesFile;

        try (Stream<String> lines = Files.lines(fileAllPets.toPath())) {
            totalLinesFile = lines.count() + 1;
        }

        try (FileWriter fileWriter = new FileWriter(fileAllPets, true)) {
            fileWriter.write(totalLinesFile + " - " + response + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException(
                    "Erro ao escrever no arquivo " + dirAllPets.getAbsolutePath(), e
            );
        }
    }


    public void saveFilteredPets(List<Pet> pets) throws IOException {

        File directory = new File(dirFilterPet);
        if (!directory.exists()) {
            directory.mkdir();
        }

        List<String> lines = new ArrayList<>();
        int counter = 1;

        for (Pet pet : pets) {
            lines.add(counter + " - " + pet.formattedAllPets());
            counter++;
        }

        Path path = Paths.get(fileFilterPet);
        Files.write(path, lines);
    }


    public static Pet petFromLine(String line) {

        String withoutNumber = line.substring(line.indexOf(" - ") + 3);
        String[] parts = withoutNumber.split(" - ");

        Pet pet = new Pet();
        pet.setName(parts[0]);
        pet.setType(PetType.fromFormatted(parts[1]));
        pet.setSex(PetSex.fromFormatted(parts[2]));

        String[] address = parts[3].split(", ");
        pet.setStreet(address[0]);
        pet.setHouseNumber(address[1]);

        pet.setCity(parts[4]);
        pet.setAge(parts[5]);
        pet.setWeight(parts[6]);
        pet.setBreed(parts[7]);

        return pet;
    }


    public Pet findPetByNumber(String numberPet) {
        for (String line : getAllPetsLines()) {
            if (line.startsWith(numberPet.trim() + " - ")) {
                return petFromLine(line);
            }
        }
        throw new ChangePetException("Pet não encontrado.");
    }
}
