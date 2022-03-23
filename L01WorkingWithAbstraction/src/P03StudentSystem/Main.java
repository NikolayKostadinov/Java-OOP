package P03StudentSystem;

public class Main {
    public static void main(String[] args) {
        CommandHandler handler = new CommandHandler(new StudentRepository());
        StudentSystem studentSystem = new StudentSystem(handler);
        studentSystem.start();
    }
}
