package P03SayHello;

public class European implements Person {

    private String name;

    @Override
    public String getName() {
        return name;
    }

    public European(String name) {
        this.name = name;
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
