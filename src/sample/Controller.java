package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller {

    public static final double GRAVITATIONAL_CONSTANT = 9.81;

    public AnchorPane mainPane;
    private Particle[] particles = new Particle[10];
    private Stage stage;
    private double x0;
    private double y0;

    public void init() {
        Scene scene = stage.getScene();
        x0 = scene.getWidth() / 2;
        y0 = scene.getHeight() / 2;
//        Line line = new Line(0, scene.getHeight() * 3 / 4, scene.getWidth(), scene.getHeight() * 3 / 4);
//        mainPane.getChildren().rxAdd(line);

        for (int i = 0; i < particles.length; i++) {
            particles[i] = new Particle().rxSetPosition(new Vector((int) scene.getHeight()));
//            particles[i].applyForce(new Vector(0, particles[i].mass * GRAVITATIONAL_CONSTANT, 0));
            double x = (particles[i].position.getX() - x0) / (x0 + x0);
            double y = (particles[i].position.getY() - y0) / (y0 + y0);
            particles[i].applyForce(new Vector(x, y, 0));
//            PhysicsObject particle = particles[i];
            mainPane.getChildren().add(particles[i].getEllipse());
        }

        AnimationTimer at = new AnimationTimer() {
            @Override
            public void handle(long now) {
                for (int i = 0; i < particles.length; i++) {
//                    if (particles[i].getVelocity().getY() + particles[i].getPosition().getY() > scene.getHeight() * 3 / 4) {
                    double x = -(particles[i].position.getX() - x0) / (x0 + x0);
                    double y = -(particles[i].position.getY() - y0) / (y0 + y0);
                    particles[i].applyForce(new Vector(x, y, 0));
                    particles[i].move();
                    mainPane.getChildren().add(particles[i].getEllipse());
                }
            }
        };
        at.start();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
