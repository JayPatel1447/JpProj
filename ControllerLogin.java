package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.prefs.Preferences;

public class ControllerLogin {

    @FXML
    private Label SignIn;

    @FXML
    private TextField UserName;

    @FXML
    private PasswordField Password;

    @FXML
    private Button Login;

    @FXML
    private CheckBox Remember;

    @FXML
    private Hyperlink Forgot;
    @FXML
    private TextField Patel943;

    Preferences preferences;



    public void LogIn(javafx.event.ActionEvent e) throws Exception {


        /*
            Setting password and user name for login
        */
        if(Patel943.getText().equals("") && Password.getText().equals(""))
        {

            SignIn.setText("Success");

            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Scene scene = new Scene(root , 750 , 510);
            // scene.getStylesheets().add(getClass().getResource("sample.fxml").toExternalForm());
            primaryStage.setTitle("                                                   ******  SHERIDAN BAGEL STORE ******");

            primaryStage.setScene(scene);
            primaryStage.show();
            Login.setVisible(false);
        }
        else
        {
            SignIn.setText("Failed");
        }

    }

    public void RememberMe(ActionEvent event)
    {
        if(Remember.isSelected())
        {
            preferences.put("UserName" , UserName.getText());
            preferences.put("Password" , Password.getText());
        }
        else
        {
            preferences.put("UserName" , "");
            preferences.put("Password" , "");
        }
    }



}