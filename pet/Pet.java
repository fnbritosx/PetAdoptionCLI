package pet;

import java.util.ArrayList;

public class Pet {
    public static ArrayList<String> responseUserForm = new ArrayList<>();

    public static void responseUserForm(String response){
        responseUserForm.add(response);
    }

    public static ArrayList<String> getResponseUserForm() {
        return responseUserForm;
    }
}
