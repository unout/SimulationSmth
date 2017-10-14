package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class Controller {

    private PhysicsObject[] particles = new PhysicsObject[10];
    private Stage stage;

    public void init() {
        for (int i = 0; i < particles.length; i++) {
            particles[i] = new PhysicsObject();
        }

        new Thread(() -> {
            for (int i = 0; i < particles.length; i++) {
                PhysicsObject particle = particles[i];
                Ellipse e = new Ellipse(particle.getPosition().getX(), particle.getPosition().getY(), 10, 10);
                e.setFill(Color.BLACK);
            }
        });

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
