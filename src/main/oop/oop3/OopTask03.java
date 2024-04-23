package oop3;

public class OopTask03 {
    public static void main(String[] args) {
        Student[] st = new Student[10];
        int kid = 10;
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0){
                st[i] = new Student(i, "Alice");
            } else {
                st[i] = new KStudent(i,  "Bob", kid);
                kid += 20;
            }
        }
        for (Student s : st){
            s.print();
        }
    }
}

class Student {
    int id;
    String name;

    public Student(int id, String name){
        this.id=id;
        this.name=name;
    }
    public void print(){
        System.out.println(this.id + "," + this.name);
    }
}

class KStudent extends Student{
    int kid;

    public KStudent(int id, String name, int kid) {
        super(id, name);
        this.kid=kid;
    }

    @Override
    public void print() {
        System.out.println(this.id + "," + this.kid + "," + this.name);
    }
}