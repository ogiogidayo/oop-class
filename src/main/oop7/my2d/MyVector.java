package my2d;

public class MyVector {
    public double x;
    public double y;

    public MyVector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double norm() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public String toString(){
        return "(" + this.x + "," + this.y + ")";
    }
}

