package CreditSio.Controller;

import CreditSio.metier.Client;
import CreditSio.metier.Compte;
import CreditSio.metier.CompteCourant;
import CreditSio.metier.CompteEpargne;
import CreditSio.modele.ClientDAO;
import CreditSio.modele.CompteCourantDAO;
import CreditSio.modele.CompteEpargneDAO;
import CreditSio.vue.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.ArrayList;

public class ControllerCompteClient  {
    public ComboBox comboboxcompte;
    public TextField textfieldtypecompte;
    public TextField textfieldsolde;
    public Button quitterappli;
    public Button reveniraumenu;
    public Button btnretirer;
    public Button btndeposer;
    public TextField textfieldsomme;
    public ListView NomClient;
    private String idClient = MainApp.idClient;
    private CompteCourantDAO compteCourantDAO = new CompteCourantDAO();
    private ClientDAO clientDAO = new ClientDAO();

    public void actionsommeadeposerouretirer(ActionEvent actionEvent) {
    }

    public void actionbtndeposer(ActionEvent actionEvent) {
    }

    public void actionbtnretirer(ActionEvent actionEvent) {
    }

    public void actionreveniraumenu(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../vue/MenuClient.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Compte(s)");
        stage.setScene(scene);
        stage.show();
        Stage oldstage = (Stage) quitterappli.getScene().getWindow();
        oldstage.close();
    }

    public void actionquitterappli(ActionEvent actionEvent) {
        Stage stage = (Stage) quitterappli.getScene().getWindow();
        stage.close();
    }

    public void actionsoldeducompte(ActionEvent actionEvent) {
    }

    public void actiontypecompte(ActionEvent actionEvent) {
    }


    public void actioncomboboxcompte(ActionEvent actionEvent) {

    }

    CompteCourantDAO compteCourantDAO1 = new CompteCourantDAO();
    ArrayList<CompteCourant> comptesCourants = compteCourantDAO1.findAll();

    CompteEpargneDAO compteEpargneDAO = new CompteEpargneDAO();
    ArrayList<CompteEpargne> compteEpargnes = compteEpargneDAO.findAll();


    public void initialize() {
            for (CompteCourant compteCourant : comptesCourants) {
                comboboxcompte.getItems().addAll(compteCourant.getNumero());
            }

        for (CompteEpargne compteEpargne : compteEpargnes) {
            comboboxcompte.getItems().addAll(compteEpargne.getNumero());
        }

        }

    public void ActionNomClient(ListView.EditEvent editEvent) {
        for (CompteCourant compteCourant : comptesCourants) {
            NomClient.getItems().addAll(compteCourant.getTitulaire());
        }
    }


   /* public void initialize(){
        Client c = null;
        for(Client client : clientDAO.findAll()){
            if(client.getNumero().equals(idClient)) {
                c = client;
            }
        }

        for(CompteCourant courant : compteCourantDAO.findAll()){
            if(courant.getTitulaire() == c){
                comboboxcompte.getItems().add(courant.getNumero().toString());
            }
        }

        Client c = null;
        for(Client client : clientDAO.findAll()){
            if(client.getNumero().equals(idClient)) {
                c = client;
            }
        }

        for(CompteCourant courant : compteCourantDAO.findAll()){
            if(courant.getTitulaire() == c){
                comboboxcompte.getItems().add(courant.getNumero().toString());
            }
        }
    }

    */
}
