package P03StudentSystem;

public class Student {
    private String name;
    private int age;
    private double grade;
    private String comment;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.setComment();
    }

    public String getName() {
        return this.name;
    }

    private void setComment() {
        if (this.grade >= 5.00) {
            this.comment = " Excellent student.";
        } else if (this.grade < 5.00 && this.grade >= 3.50) {
            this.comment = " Average student.";
        } else {
            this.comment = " Very nice person.";
        }
    }

    public String getInfo() {
        return String.format("%s is %s years old.", this.name, this.age) + this.comment;
    }
}
