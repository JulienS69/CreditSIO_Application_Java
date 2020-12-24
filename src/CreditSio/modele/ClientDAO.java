package CreditSio.modele;

import CreditSio.metier.Client;
import java.sql.*;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Classe ClientDAO.
 * Classe d'accès aux données de la table client.
 * Transforme ces données en objets métiers.
 * Implémentation des méthodes du CRUD pour la table client dans la db.
 * Implémente l'interface IDao.
 * @author B. Chataing.
 * created on 15/12/2020.
 * modified on 18/12/2020.
 * @see Client
 */

public class ClientDAO implements IDao {
    private Connection myConnection;
    private Statement stmt = null;
    private ResultSet rs = null;
    private ArrayList<Client> clients = null;

    /**
     * Constructeur.
     * Connecte l'application à la db.
     * Selectionne tous les clients de la table, les stocke dans la collection.
     */
    public ClientDAO() {
        myConnection = Connexion.getMyConnection();
        read("select * from client");
    }

    /**
     * Effectue un insert into client.
     * @param req : la requete SQL (insert into).
     * @return : le nombre de lignes affectées dans la table.
     */
    @Override
    public int create(String req) {
        return 0;
    }

    /**
     * Selectionne tous les clients, les ajoute dans la collection.
     * Coupe ensuite la connexion à la base.
     * @param req : la requete (select * from client).
     */
    @Override
    public void read(String req) {
        try {
            clients = new ArrayList<>();
            stmt = myConnection.createStatement();
            rs = stmt.executeQuery(req);
            while(rs.next()){
                clients.add(new Client(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
                myConnection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int update(String req) {
        return 0;
    }

    @Override
    public int delete(String req) {
        return 0;
    }

    /**
     * @return la collection de clients.
     */
    public ArrayList<Client> findAll()
    {

        return clients;
    }

    /**
     *
     * @param index indice du client dans la collection.
     * @return le client ayant l'indice index dans la collection.
     */
    public Client findByIndex(int index) {
        return clients.get(index);
    }
}
