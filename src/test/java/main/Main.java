package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //AnchorPane root = (AnchorPane) FXMLLoader.load(Main.class.getResource("/Views/Arrmory.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("../Views/Arrmory.fxml"));
        primaryStage.setScene(new Scene(root,600,380));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Armory");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
