package CreditSio.Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllerMenuConseillerFinancier {

    @FXML
    private AnchorPane BouttonEspaceConnexion;
    @FXML
    private Button boutonclient;
    @FXML
    private Button BoutonComptes;
    @FXML
    private Button Modifierdesfichesclients;
    @FXML
    private Button btnexit;



    public void actionBouttonEspaceConnexion(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../vue/Connexion.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Espace Connexion");
        stage.setScene(scene);
        stage.show();
        Stage oldstage = (Stage) btnexit.getScene().getWindow();
        oldstage.close();
    }

    public void actionboutonclient(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../vue/ListeClientConseillerFinancier.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Liste des Clients");
        stage.setScene(scene);
        stage.show();
        Stage oldstage = (Stage) btnexit.getScene().getWindow();
        oldstage.close();
    }

    public void actionBoutonComptes(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../vue/ListeCompteClientConseillerFinancier.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Liste des Comptes");
        stage.setScene(scene);
        stage.show();
        Stage oldstage = (Stage) btnexit.getScene().getWindow();
        oldstage.close();
    }

    public void actionModifierdesfichesclients(ActionEvent actionEvent) {
    }

    public void actionmodifiercomptes(ActionEvent actionEvent) {

    }

    public void actionbtnexit(ActionEvent actionEvent) {
        Stage stage = (Stage) btnexit.getScene().getWindow();
        stage.close();
    }
}
