package sample;

public class PhysicsObject {

    protected double mass;
    protected Vector position;
    protected Vector velocity;
    protected Vector acc;
    protected Vector force;

    protected void update() {
        acc = force.rxMultiply(1. / mass);
        velocity.add(acc);
        position.add(velocity);
    }

    public double getMass() {
        return mass;
    }

    public PhysicsObject rxSetMass(double mass) {
        this.mass = mass;
        return this;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public Vector getPosition() {
        return position;
    }

    public PhysicsObject rxSetPosition(Vector position) {
        this.position = position;
        return this;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public Vector getVelocity() {
        return velocity;
    }

    public Vector getAcc() {
        return acc;
    }

    public Vector getForce() {
        return force;
    }

    public PhysicsObject rxApplyForce(Vector force) {
        this.force = new Vector().rxAdd(force);
        return this;
    }

    public void applyForce(Vector force) {
        this.force = new Vector().rxAdd(force);
    }

}
