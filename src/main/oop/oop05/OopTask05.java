package oop05;

import java.util.ArrayList;
import java.util.HashMap;

public class OopTask05 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(new Student(11, "Ken"));
        list.add(new Student(22, "Alice"));
        list.add(new Student(33, "Bob"));
        list.add(new Student(44, "Mike"));
        list.add(new Student(55, "Keiko"));

        for (Student s: list) s.print();

        HashMap<String, Student> map = new HashMap<String, Student>();
        for (Student s: list){
            map.put(s.name, s);
        }
        map.get("Alice").print();
    }
}

class Student{
    int     id;
    String  name;

    public Student(int id, String name){
        this.id = id;
        this.name = name;
    }

    public void print(){
        System.out.println("id: "+ this.id + ", name: " + this.name);
    }
}
