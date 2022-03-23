package P03StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentRepository {
    private final Map<String, Student> data;

    public StudentRepository() {
        this.data = new HashMap<>();
    }

    public void add(Student student) {
        this.data.putIfAbsent(student.getName(), student);
    }

    public Student getStudent(String name) {
        return this.data.get(name);
    }
}
