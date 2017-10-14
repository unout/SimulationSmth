package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Controller {

    public static final double GRAVITATIONAL_CONSTANT = 6.67408 / 1;

    public AnchorPane mainPane;
    private Particle[] particles = new Particle[1];
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
//            PhysicsObject particle = particles[i];
            mainPane.getChildren().add(particles[i].getEllipse());
        }

        Particle target = new Particle(0, new Vector(x0, y0, 0), 16);
        mainPane.getChildren().add(target.getEllipse());


        final ArrayList<Particle> attractors = new ArrayList<>();
        mainPane.setOnMouseClicked(event -> {
//                    click[0] = event.getX();
//                    click[1] = event.getY();
            attractors.add(new Particle(1, new Vector(event.getX(), event.getY(), 0), 10));
            mainPane.getChildren().add(attractors.get(attractors.size() - 1).getEllipse());
//                    mainPane.getChildren().add(p.getEllipse());
        });

        AnimationTimer at = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if ((particles[0].position.getX() >= target.position.getX()) || (particles[0].position.getY() >= target.position.getY())) {
                    System.out.println("YOU WIN");
                }
//                for (int i = 0; i < particles.length; i++) {
//                    if (particles[i].getVelocity().getY() + particles[i].getPosition().getY() > scene.getHeight() * 3 / 4) {
//                    double x = -(particles[i].position.getX() - x0);
//                    double y = -(particles[i].position.getY() - y0);
//                    double r = Math.sqrt(x * x + y * y);
//                    particles[i].applyForce(new Vector(x, y, 0).rxMultiply(1. / (r * r)));
//                    particles[i].move();
//                    mainPane.getChildren().add(particles[i].getEllipse());
//                }
//                final double[] click = new double[2];

                if (attractors.size() > 0) {
                    for (int i = 0; i < attractors.size(); i++) {
                        Particle a = attractors.get(i);
                        double x = -(particles[0].position.getX() - a.position.getX());
                        double y = -(particles[0].position.getY() - a.position.getY());
                        double r = Math.sqrt(x * x + y * y);
                        particles[0].applyForce(new Vector(x, y, 0)
                                .rxMultiply(a.getMass() * particles[0].getMass() * GRAVITATIONAL_CONSTANT / (r * r)));
                        particles[0].move();
                        mainPane.getChildren().add(particles[0].getEllipse());

                    }
                }
            }
        };
        at.start();

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
