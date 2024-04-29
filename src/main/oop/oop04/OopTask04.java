package oop04;

public class OopTask04 {
    public static void main(String[] args) {
        Singable[] singers = new Singable[10];
        for (int i=0; i<10; i++){
            if (i % 2 == 0){
                singers[i] = new KStudent(i, "Ken", i*10);
            } else {
                singers[i] = new Singer();
            }
        }
        for (Singable s : singers){
            s.sing();
        }
        int count = 0;
        for (Singable s : singers){
            if(s instanceof KStudent){
                count++;
            }
        }
        System.out.println("Count: " + count);
    }
}

class Student {
    int id;
    String name;

    public Student(int id, String name){
        this.id=id;
        this.name=name;
    }
}

class KStudent extends Student implements Singable {
    int kid;

    public KStudent(int id, String name, int kid) {
        super(id, name);
        this.kid=kid;
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