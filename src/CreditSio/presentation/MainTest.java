package CreditSio.presentation;

import java.sql.*;

public class MainTest {

    public static void main(String[] args) {
        String driverName ="org.mariadb.jdbc.Driver";
        String dbUrl = "jdbc:mariadb://localhost:3306/creditsiov2";

        String user = "root";
        String pass = "";

        Connection myConn = null;
        try {
            //Etape 1. Charger le pilote
            Class.forName(driverName);
            //Etape 2. Se connecter à la base
            myConn = DriverManager.getConnection(dbUrl, user, pass);
            //Etape 3. Créer et executer un ordre SQL
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("SELECT CLIENTNUM, CLIENTNOM FROM client ");
            //Etape 4. Traiter le ResultSet
            while (myRs.next()) {
                System.out.println(myRs.getString("CLIENTNUM"));
                System.out.println(myRs.getString("CLIENTNOM"));
            }
        } catch (SQLException exc){
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
            }
        }
    }
}
