package CreditSio.Controller;

import CreditSio.metier.Client;
import CreditSio.modele.ClientDAO;
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

public class ControllerListeClientConseillerFinancier {
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

    public void actioncombobox(ActionEvent actionEvent) {
    }

    ClientDAO ClientDao1 = new ClientDAO();
    ArrayList<Client> clients = ClientDao1.findAll();

    public void initialize(){
        for (Client client : clients) {
            combobox.getItems().addAll(client.getNumero());
        }
    }

    public void actionbtnexit(ActionEvent actionEvent) {
    }
}
