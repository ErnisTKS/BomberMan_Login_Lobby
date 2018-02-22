package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.io.PrintStream;
import java.net.URL;
import java.util.ResourceBundle;

public class LobbyController implements Initializable {

    public Button joinGame;
    public TextField msgField;
    public TextArea msgArea;
    public ListView playerList;
    public ListView gameRooms;


    @FXML
    private AnchorPane rootPane;

    @Override
    public void initialize(URL url, ResourceBundle rb){

    }


    public void onJoinGame(ActionEvent event) {
    }

    public void onExit(ActionEvent event) {
        System.exit(0);
    }

    public void onSendMessage(ActionEvent event) {
        PrintStream output = new PrintStream(client.getOutputStream());
        while (sc.hasNextLine()) {
            output.println(_nickname + ": " + sc.nextLine());
        }

        output.close();
    }
}
