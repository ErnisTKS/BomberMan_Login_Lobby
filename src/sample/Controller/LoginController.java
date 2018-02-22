package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    public Label nameError;
    public TextField nickName;

    @Override
    public void initialize(URL url, ResourceBundle rb){

    }

    public void onPressConnect(ActionEvent event) throws IOException {
        String ivestasVardas = nickName.getText();
        if (!ivestasVardas.equals("")) {



            Parent lobby = FXMLLoader.load(getClass().getResource("../LobbyScreen.fxml"));
            Scene scene = new Scene(lobby);

            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(scene);
            window.show();
        } else {
            nameError.setText("Iveskite varda!");
        }

    }
}
