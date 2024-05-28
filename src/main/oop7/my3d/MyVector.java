package my3d;

public class MyVector {
    public double x;
    public double y;
    public double z;

    public MyVector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double norm() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }
}
