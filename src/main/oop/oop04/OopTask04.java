package oop04;

public class OopTask04 {
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

class KStudent extends Student implements Singable {
    int kid;

    public KStudent(int id, String name, int kid) {
        super(id, name);
        this.kid=kid;
    }

    @Override
    public void print() {
        System.out.println(this.id + "," + this.kid + "," + this.name);
    }

    @Override
    public void sing(){
        System.out.println("Lalala");
    }

}

class Singer implements Singable{
    @Override
    public void sing() {
        System.out.println("Rururu");
    }
}

interface Singable
{
    public void sing();
}