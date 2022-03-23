package P03BirthdayCelebrations;

public class Pet implements Birthable{
    private String name;
    private String BirthDate;

    public Pet(String name, String birthDate) {
        this.name = name;
        BirthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getBirthDate() {
        return BirthDate;
    }
}
