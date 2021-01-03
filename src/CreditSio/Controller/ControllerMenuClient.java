package CreditSio.Controller;

import CreditSio.vue.MainApp;
import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControllerMenuClient {

    @FXML
    private Button visualisercompteclient;
    @FXML
    private Button effectuerundepot;
    @FXML
    private Button Quitter;

    private String idClient = MainApp.idClient;


    public void actioneffectuerundepot(ActionEvent actionEvent) {
    }

    public void actionquitterapplication(ActionEvent actionEvent) {
    }

    public void actionvisualisercompteclient(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../vue/CompteClient.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Compte(s)");
        stage.setScene(scene);
        stage.show();
        Stage oldstage = (Stage) Quitter.getScene().getWindow();
        oldstage.close();
    }

    public void actionQuitter(ActionEvent actionEvent) {
    }
}
