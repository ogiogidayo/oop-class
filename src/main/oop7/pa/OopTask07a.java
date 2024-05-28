package pa;

import my2d.MyVector;

public class OopTask07a {
    public static void main(String[] args) {
        MyVector vec2 = new MyVector(1, 2);
        System.out.println(vec2.norm());
        my3d.MyVector vec3 = new my3d.MyVector(1, 2, 3);
        System.out.println(vec3.norm());
    }
}
