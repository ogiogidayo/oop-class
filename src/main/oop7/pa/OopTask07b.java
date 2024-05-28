package pa;

import my2d.MyVector2;

public class OopTask07b {
    public static void main(String[] args) {
        MyVector2 vector = new MyVector2(1, 2);
        vector.rotate(Math.PI / 6);
        System.out.println(vector);
    }
}