package CreditSio.Controller;

import CreditSio.metier.Client;
import CreditSio.modele.ClientDAO;
import CreditSio.modele.Connexion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.*;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;



public class Controller {
    @FXML
    private Button btnexit;
    @FXML
    private Button btnseconnecter;
    @FXML
    private Label labelconnexion;
    @FXML
    private PasswordField textfieldmdp;
    @FXML
    private TextField textfieldidentifiant;
    @FXML
    private Label labelidentifiant;
    @FXML
    private Label labelmdp;
    Connection con = Connexion.getMyConnection();
    PreparedStatement stat = null;
    ResultSet rs = null;


    public void btnconnexionok(ActionEvent actionEvent) throws Exception {
        if (textfieldidentifiant.getText() != "" && textfieldmdp.getText() != "") {
            String id = textfieldidentifiant.getText();
            String mdp = textfieldmdp.getText();
            ClientDAO clientDAO = new ClientDAO();
            ArrayList<Client> clients = clientDAO.findAll();
            for (Client client : clients) {
                if (client.getNumero().equals(textfieldidentifiant.getText()) && client.getPrenom().equals(textfieldmdp.getText())){
                    //Ouverture de la nouvelle fenêtre
                    Parent root = FXMLLoader.load(getClass().getResource("../vue/Compte.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.setTitle("Menu");
                    stage.setScene(scene);
                    stage.show();
                    Stage oldstage = (Stage) btnexit.getScene().getWindow();
                    oldstage.close();
                 }
                else {
                    textfieldidentifiant.setText("Connexion impossible");
                }
            }
        }

    }
    public void btnexit (ActionEvent actionEvent){
        Stage stage = (Stage) btnexit.getScene().getWindow();
        stage.close();
    }
}
