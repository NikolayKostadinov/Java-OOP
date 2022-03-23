package P03StudentSystem;

public class CommandHandler {
    private final StudentRepository repository;

    public CommandHandler(StudentRepository repository) {
        this.repository = repository;
    }


    public String handleCommand(String[] tokens){
        if (tokens[0].equals("Create"))
        {
            var name = tokens[1];
            var age = Integer.parseInt(tokens[2]);
            var grade =Double.parseDouble(tokens[3]);
            Student student = new Student(name, age, grade);
            this.repository.add(student);
            return null;
        }
        else if (tokens[0].equals("Show")) {
            var name = tokens[1];
            Student student = this.repository.getStudent(name);
            return student == null ? "": student.getInfo();
        }

        return tokens[0];
    }
}
