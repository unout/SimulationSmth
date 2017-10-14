package sample;

import java.util.Random;

public class Vector {

    private double x;
    private double y;
    private double z;

    public Vector() {}

    public Vector(int minValue, int maxValue) {
        Random r = new Random();
        this.x = r.nextDouble() * maxValue + minValue;
        this.y = r.nextDouble() * maxValue + minValue;
        this.z = r.nextDouble() * maxValue + minValue;
    }

    public Vector(int maxValue) {
        Random r = new Random();
        this.x = r.nextDouble() * maxValue;
        this.y = r.nextDouble() * maxValue;
        this.z = r.nextDouble() * maxValue;
    }

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector rxSetRandom() {
        Random r = new Random();
        this.x = r.nextDouble();
        this.y = r.nextDouble();
        this.z = r.nextDouble();
        return new Vector(x, y, z);
    }

    public void setRandom() {
        this.x = new Random().nextDouble();
        this.y = new Random().nextDouble();
        this.z = new Random().nextDouble();
    }

    public double getX() {
        return x;
    }

    public Vector rxSetX(double x) {
        this.x = x;
        return this;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public Vector rxSetY(double y) {
        this.y = y;
        return this;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public Vector rxSetZ(double z) {
        this.z = z;
        return this;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getAngleBetweenOX() {
        return x != 0 ? Math.atan(y / x) : Math.PI / 2;
    }

    public Vector rxMultiply(double n) {
        return new Vector(x * n, y * n, z * n);
    }

    public void multiply(double n) {
        x *= n;
        y *= n;
        z *= n;
    }

    public Vector rxAdd(Vector v) {
        x += v.getX();
        y += v.getY();
        z += v.getZ();
        return this;
    }

    public void add(Vector v) {
        x += v.getX();
        y += v.getY();
        z += v.getZ();
    }

    public Vector rxSub(Vector v) {
        x -= v.getX();
        y -= v.getY();
        z -= v.getZ();
        return this;
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
