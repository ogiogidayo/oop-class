package oop01;

public class Student {
    String  name;
    int     id;

    public Student(int id, String name) {
        this.id   = id;
        this.name = name;
    }

    public void print() {
        System.out.println(this.name + "(" + this.id + ")");
    }
}
