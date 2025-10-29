package pet;

import java.util.ArrayList;

public class Pet {
    public String nameAndLastName;
    public TypePet typePet;
    public SexPet sexPet;
    public String address;
    public int age;
    public double weight;
    public String breed;
    public static ArrayList<String> responseUserForm = new ArrayList<>();

    public static void responseUserForm(String response){
        responseUserForm.add(response);
    }

    public static ArrayList<String> getResponseUserForm() {
        return responseUserForm;
    }
}
