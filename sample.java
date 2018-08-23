package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class sample extends Application {

    @Override
    public void start(Stage primaryStage){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene scene = new Scene(root, 625  , 450);


            //scene.getStylPesheets().add(getClass().getResource("sample.fxml").toExternalForm());
            primaryStage.setTitle("                            ******  SHERIDAN BAGEL STORE ******");

            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}
