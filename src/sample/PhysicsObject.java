package sample;

public class PhysicsObject {

    private double mass;
    private Vector position;
    private Vector vel;
    private Vector acc;
    private Vector force;

    public void update() {
        acc = force.multiply(1 / mass);
        vel.add(acc);
        position.add(vel);
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public Vector getVel() {
        return vel;
    }

    public Vector getAcc() {
        return acc;
    }

    public Vector getForce() {
        return force;
    }

    public void applyForce(Vector force) {
        this.force.add(force);
    }

}
