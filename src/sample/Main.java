package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(loader.load(), 800, 600);

        primaryStage.setTitle("Scene");
        primaryStage.setScene(scene);
        primaryStage.show();
        Ellipse e = new Ellipse(421, 400, 10, 10);


        Controller controller = loader.getController();
        controller.setStage(primaryStage);
        controller.init();
    }


    public static void main(String[] args) {
        launch(args);
    }
}