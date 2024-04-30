package oop02;

public class OopTask02{
    public static void main(String[] args){
        for (int i = 0; i < 100; i++) {
            Student st = new Student(10, "student");
            System.out.println(st.toString());
        }
    }
}

class Student{
    public int id;
    public String name;
    public static int count = 0;

    public Student(int id, String name){
        this.id = id;
        this.name = name;
        ++count;
    }

    public String toString() {
        return "id: " + this.id + ", name: " + this.name + ", count: " + this.count;
    }
}