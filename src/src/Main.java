package src;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("dgn1.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1051.7, 650));
        primaryStage.getIcons().add(new Image("con9.png"));
        primaryStage.show();
    }


    public static void main(String[] args) {
        System.out.println("test branch successful");
        launch(args);
    }
}
