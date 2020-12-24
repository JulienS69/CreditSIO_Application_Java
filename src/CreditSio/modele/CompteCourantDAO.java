package CreditSio.modele;

import CreditSio.metier.Client;
import CreditSio.metier.CompteCourant;
import java.sql.*;
import java.util.ArrayList;

/**
 * Classe CompteCourantDAO.
 * Classe d'accès aux données de la table comptecourant.
 * Transforme ces données en objets métiers.
 * Implémentation des méthodes du CRUD pour la table comptecourant dans la db.
 * Implémente l'interface IDao.
 * @author B. Chataing.
 * created on 15/12/2020.
 * modified on 18/12/2020.
 * @see CompteCourant
 */
public class CompteCourantDAO implements IDao {
    private Connection myConnection;
    private Statement stmt = null;
    private ResultSet rs = null;
    private ArrayList<CompteCourant> courants = null;
    /**
     * Constructeur.
     * Connecte l'application à la db.
     * Selectionne tous les clients de la table, les stocke dans la collection.
     */
    public CompteCourantDAO() {
        myConnection = Connexion.getMyConnection();
        read("select * from comptecourant cc " +
                "join compte c on cc.comptenum=c.comptenum " + "join client ct on c.clientnum=ct.clientnum");
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
     * Selectionne tous les comptes courants, les ajoute dans la collection.
     * Coupe ensuite la connexion à la base.
     * @param req : la requete (select *).
     */
    @Override
    public void read(String req) {
        try {
            courants = new ArrayList<>();
            stmt = myConnection.createStatement();
            rs = stmt.executeQuery(req);
            while(rs.next()){
                Client client = new Client(rs.getString(6), rs.getString(7),rs.getString(8),rs.getString(9),
                        rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13));
                courants.add(new CompteCourant(rs.getString(1),client,rs.getDouble(4),rs.getDouble(2)));
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
     * @return la collection de comptes courants.
     */
    public ArrayList<CompteCourant> findAll(){
        return courants;
    }

    /**
     *
     * @param index indice du compte dans la collection.
     * @return le compte courant ayant l'indice index dans la collection.
     */
    public CompteCourant findByIndex(int index) {
        return courants.get(index);
    }
}
