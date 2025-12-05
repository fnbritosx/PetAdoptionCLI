package src.model.entity;

public class Pet {
    private String name;
    private PetType type;
    private PetSex sex;
    private String houseNumber;
    private String street;
    private String city;
    private String age;
    private String weight;
    private String breed;


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  "1 - " + name +  "\n" +
                "2 - " + type + "\n" +
                "3 - " + sex + "\n" +
                "5 - Rua " + street +", " + houseNumber + ", " + city + "\n" +
                "6 - " + age + " anos" + "\n" +
                "7 - " + weight + "kg" + "\n" +
                "8 - " + breed + "\n";
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

    public void setAge(String age) {
        this.age = age;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}

