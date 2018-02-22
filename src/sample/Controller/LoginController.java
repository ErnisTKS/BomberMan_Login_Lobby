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
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LoginController implements Initializable {

    public Label nameError;
    public TextField nickName;

    public String ivestasVardas;

    private String _host;
    private int _port;
    private String _nickname;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void onPressConnect(ActionEvent event) throws IOException {
        ivestasVardas = nickName.getText();
        if (!ivestasVardas.equals("")) {
            _host = "localhost";
            _port = 12345;
            run();
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

    public void run() throws UnknownHostException, IOException {
        // connect client to server
        Socket client = new Socket(_host, _port);
        System.out.println("Client successfully connected to server!");

        // create a new thread for server messages handling
       // new Thread(new ReceivedMessagesHandler(client.getInputStream())).start();

        // ask for a nickname
        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter a nickname: ");
        _nickname = ivestasVardas;

        // read messages from keyboard and send to server

        sc.close();
        client.close();
    }

    public void onExit(ActionEvent event) {
        System.exit(0);
    }

//    class ReceivedMessagesHandler implements Runnable {
//
//        private InputStream server;
//
//        public ReceivedMessagesHandler(InputStream server) {
//            this.server = server;
//        }
//
//        @Override
//        public void run() {
//            // receive server messages and print out to screen
//            Scanner s = new Scanner(server);
//            while (s.hasNextLine()) {
//                System.out.println(s.nextLine());
//            }
//            s.close();
//        }
//    }
}
