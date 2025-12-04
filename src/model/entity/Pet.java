package src.model.entity;

public class Pet {
    private String name;
    private PetType type;
    private PetSex sex;
    private String houseNumber;
    private String street;
    private String city;
    private double age;
    private double weight;
    private String breed;


    public void setName(String name) {
        this.name = name;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public void setSex(PetSex sex) {
        this.sex = sex;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}

