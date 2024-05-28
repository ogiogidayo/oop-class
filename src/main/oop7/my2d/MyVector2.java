package my2d;

public class MyVector2 extends MyVector{
    public MyVector2(double x, double y){
        super(x, y);
    }

    public void rotate(double theta){
        double xa = x * Math.cos(theta) - y * Math.sin(theta);
        double ya = x * Math.sin(theta) + y * Math.cos(theta);
        this.x = xa;
        this.y = ya;
    }
}
