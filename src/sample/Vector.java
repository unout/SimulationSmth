package sample;

public class Vector {

    private double x;
    private double y;
    private double z;

    public Vector() {}

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getAngleBetweenOX() {
        return x != 0 ? Math.atan(y / x) : Math.PI / 2;
    }

    public Vector multiply(double n) {
        return new Vector(x * n, y * n, z * n);
    }

    public void add(Vector v) {
        x += v.getX();
        y += v.getY();
        z += v.getZ();
    }

    public void sub(Vector v) {
        x -= v.getX();
        y -= v.getY();
        z -= v.getZ();
    }

    public double dotProduct(Vector v) {
        return x * v.getX() + y * v.getY() + z * v.getZ();
    }

    public double getModule() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public Vector crossProduct(Vector v) {
        return new Vector(
                y * v.getZ() - z * v.getY(),
                z * v.getX() - x * v.getZ(),
                x * v.getY() - y * v.getX());
    }
}
