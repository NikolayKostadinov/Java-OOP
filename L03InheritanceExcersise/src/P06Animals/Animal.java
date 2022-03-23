package P06Animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        validateInput(name);
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("Invalid input!");
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        validateInput(gender);
        this.gender = gender;
    }

    public String produceSound(){
        return null;
    }

    private void validateInput(String input){
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getAnimalType()).append(System.lineSeparator());
        sb.append(String.format("%s %d %s", this.name, this.age, this.gender)).append(System.lineSeparator());
        sb.append(this.produceSound());
        return sb.toString();
    }

    public String getAnimalType(){
        return this.getClass().getSimpleName();
    }
}
