package CreditSio.modele;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;


/**
 * Classe Connexion.
 * Gère la connexion et la déconnexion à la db.
 * @author B. Chataing.
 * created on 15/12/2020.
 * modified on 20/12/2020.
 */
public class Connexion {
    /*Les paramètres de connexion sont stockés dans un fichier de configuration (config.properties)
     * Ce fichier est lu par la méthode privée "read".
     * Elle initialise les membres driverName, dbUrl, user et pass*/
    private static String driverName;
    private static String dbUrl;
    private static String user;
    private static String pass;
    private static Connection myConnection = null;

    /**
     * getConnexion.
     * Charge le pilote et se connecte à la db.
     * Methode statique.
     */
    public static Connection getMyConnection() {
       /* driverName = "org.mariadb.jdbc.Driver";
        String dbUrl = "jdbc:mariadb://localhost:3306/creditsiov2";

        String user = "root";
        String pass = "";*/
        readPropertiesroot();
        System.out.println("driverName :" + driverName);
        try {
            Class.forName(driverName);
            myConnection = DriverManager.getConnection(dbUrl, user, pass);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return myConnection;
    }

    public static Connection getMyConnectionclient() {
        /*driverName = "org.mariadb.jdbc.Driver";
        String dbUrl = "jdbc:mariadb://localhost:3306/creditsiov2";

        String user = "root";
        String pass = "";*/
        readPropertiesclient();
        try {
            Class.forName(driverName);
            myConnection = DriverManager.getConnection(dbUrl, user, pass);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return myConnection;
    }

    /**
     * Deconnexion de la db.
     * Méthode statique.
     */
    public void Deconnexion() {
        if (myConnection != null) {
            try {
                myConnection.close();
            } catch (SQLException exc) {
                exc.printStackTrace();
            }
        }
    }

    /**
     * Lecture des données de connexion à la db.
     * Ces données sont stockées dans un fichier de config (config.properties).
     */
    private static void readPropertiesroot() {
        final Properties properties = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("config.properties");

            // load a properties file
            properties.load(input);
            // get the property value
            driverName = properties.getProperty("db.drivername");
            dbUrl = properties.getProperty("db.url");
            user = properties.getProperty("db.username");
            pass = properties.getProperty("db.password");

        } catch (final IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    private static void readPropertiesclient() {
        final Properties propertiesclient = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("client.properties");

            // load a properties file
            propertiesclient.load(input);
            // get the property value
            driverName = propertiesclient.getProperty("db.drivername");
            dbUrl = propertiesclient.getProperty("db.url");
            user = propertiesclient.getProperty("db.username");
            pass = propertiesclient.getProperty("db.password");

        } catch (final IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
