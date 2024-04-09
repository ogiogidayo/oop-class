package oop01;

public class OopTask {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Student student;
            if (i % 2 == 0)
                student = new Student(i + 1, "Alice");
            else
                student = new Student(i + 1, "Bob");
            student.print();
        }
    }
}
