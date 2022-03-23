package P03SayHello;

public class Bulgarian implements Person {

    private String name;

    @Override
    public String getName() {
        return name;
    }

    public Bulgarian(String name) {
        this.name = name;
    }

    public String sayHello() {
        return "Здравей";
    }
}
