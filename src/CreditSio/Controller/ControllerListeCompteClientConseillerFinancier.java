package CreditSio.Controller;

import CreditSio.metier.Client;
import CreditSio.metier.CompteCourant;
import CreditSio.metier.CompteEpargne;
import CreditSio.modele.ClientDAO;
import CreditSio.modele.CompteCourantDAO;
import CreditSio.modele.CompteEpargneDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ControllerListeCompteClientConseillerFinancier {
    @FXML
    private Button reveniraumenu;
    @FXML
    private TableView tableview;
    @FXML
    private ComboBox combobox;
    @FXML
    private Button btnexit;

    public void actionreveniraumenu(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../vue/MenuConseillerFinancier.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Menu Conseiller Financier");
        stage.setScene(scene);
        stage.show();
        Stage oldstage = (Stage) btnexit.getScene().getWindow();
        oldstage.close();
    }

    public void actiontableview(SortEvent<TableView> tableViewSortEvent) {
    }

    CompteCourantDAO compteCourantDAO1 = new CompteCourantDAO();
    ArrayList<CompteCourant> comptesCourants = compteCourantDAO1.findAll();

    CompteEpargneDAO compteEpargneDAO = new CompteEpargneDAO();
    ArrayList<CompteEpargne> compteEpargnes = compteEpargneDAO.findAll();

    public void initialize() {
        for (CompteCourant compteCourant : comptesCourants) {
            combobox.getItems().addAll(compteCourant.getNumero());
        }
        for (CompteEpargne compteEpargne : compteEpargnes) {
            combobox.getItems().addAll(compteEpargne.getNumero());
        }
    }

    public void actionbtnexit(ActionEvent actionEvent) {
    }

    public void actioncombobox(ActionEvent actionEvent) {
    }
}
