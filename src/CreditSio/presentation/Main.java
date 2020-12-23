package CreditSio.presentation;


import CreditSio.metier.Client;
import CreditSio.metier.CompteCourant;
import CreditSio.metier.CompteEpargne;
import CreditSio.modele.ClientDAO;
import CreditSio.modele.CompteCourantDAO;
import CreditSio.modele.CompteEpargneDAO;
import java.util.ArrayList;
import java.sql.* ;


public class Main {

    public static void main(String[] args) {
        // write your code here
        /*String driverName = "org.mariadb.jdbc.Driver";
        String dbUrl = "jdbc:mariadb://localhost:3306/creditsiov2";
        String user = "root";
        String pass = "";

        Connection myConn = null;
        try {
            // Étape 1.  Charger le pilote
            Class.forName(driverName);
            // Étape 2.  Se connecter à la base
            myConn = DriverManager.getConnection(dbUrl, user, pass);
            // Étape 3.  Créer et exécuter un ordre SQL
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("SELECT CLIENTNUM, CLIENTNOM from client ");
            // Étape 4:  Traiter le ResultSet
            while (myRs.next()) {
                System.out.println(myRs.getString("CLIENTNUM"));
                System.out.println(myRs.getString("CLIENTNOM"));
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        } catch (ClassNotFoundException exc) {
            exc.printStackTrace();
        } finally {
            if (myConn != null) {
                try {
                    myConn.close();
                } catch (SQLException exc) {
                    exc.printStackTrace();
                }
            }*/
           ClientDAO clientDAO = new ClientDAO();
            ArrayList<Client> clients = clientDAO.findAll();
            for (Client client : clients) {
                System.out.println(client.getNumero() + " " + client.getNom() + " " + client.getPrenom());
            }
            CompteCourantDAO compteCourantDAO = new CompteCourantDAO();
            ArrayList<CompteCourant> courants = compteCourantDAO.findAll();
            for (CompteCourant courant : courants) {
                System.out.println(courant.getNumero() + " " + courant.getSolde() + " " + courant.getDecouvertAutorise());
            }
            CompteEpargneDAO compteEpargneDAO = new CompteEpargneDAO();
            ArrayList<CompteEpargne> epargnes = compteEpargneDAO.findAll();
            for (CompteEpargne epargne : epargnes) {
                System.out.println(epargne.getNumero() + " " + epargne.getSolde() + " " + epargne.getTauxInteret());
            }
        }
    }
//}
