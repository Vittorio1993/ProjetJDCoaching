/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import model.Utilisateur;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RHAW
 */
public class Bd {
    /**
     * Connexion.
     */
    private static Connection cx;

    //données de connexion
    private final static String url="jdbc:mysql://np903346ltnyr11z:dsbumc5602c2y8ky@m60mxazb4g6sb4nn.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/fupu8i1nlz5lkcc8";

    /**
     * BD Connexion.
     * @throws Exception Exception
     */
    private static void connexion() throws Exception {

        //Chargement du driver JDBC
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new Exception("Problème de chargement du driver - "
                    + ex.getMessage());
        }

        //Création de la connexion
        try {
        Bd.cx = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            throw new Exception("Problème de connexion à la BD - "
                    + ex.getMessage());
        }

    }


    /**
     * Saisir un utilisateur.
     * @param u utilisateur
     */
     public final void saisirUtilisateur(final Utilisateur u) throws Exception {

        if (Bd.cx == null) {
            Bd.connexion();
        }
         /**
          * Statement.
          */
        Statement st = null;
        try {
            st = cx.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            st.executeUpdate("insert into utilisateur(CODEU,NOMU,PRENOMU,DATEDENAISSANCEU,EMAILU,TELU,STATUTS,PASSWORD,TYPE) values('"
                    + u.getCodeu()
                    + "','"
                    + u.getNomu()
                    + "','"
                    + u.getPrenomu()
                    + "','"
                    + u.getDatenaissanceu()
                    + "','"
                    + u.getEmailu()
                    + "','"
                    + u.getTelu()
                    + "','"
                    + u.getStatus()
                    + "','"
                    + u.getPassword()
                    + "','"
                    + u.getType()
                    + "')");
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     /**
      * Retour d'un admin.
      * @param mail mail du user
      * @param pwd password du user
      * @return boolean
      * @throws Exception Exception
      */
    public static boolean getAdmin(final String mail, final String pwd)
            throws Exception {

        if (Bd.cx == null) {
            Bd.connexion();
        }
        // Statement to handle query
        Statement statement;
         //Ouverture de la connexion
        try {
            cx = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Erreur ouverture connexion" + ex.getMessage());
        }
        try {
            statement = cx.createStatement();
        } catch (SQLException error) {
            throw new Exception("Problème avec création du statement : "
                    + error.getMessage());
        }
        boolean requestOK = false;
        String query = "SELECT COUNT(*) as rowcount "
                + "FROM UTILISATEUR "
                + "WHERE EMAILU='"
                + mail
                + "'"
                + "AND PASSWORD='"
                + pwd
                + "'"
                + "AND TYPE='admin'"
                + ";";

        /* Execution de la requête */
            try {
                    ResultSet rs = statement.executeQuery(query);
                    while (rs.next()) {
                        if (rs.getInt("rowcount") == 1) {
                            requestOK = true;
                        }
                    }
                    rs.close();
                    statement.close();
                    cx.close();
                } catch (SQLException ex) {
                    System.out.println("Problème avec récupération de la requête : "
                            + ex.getMessage());
                }
        return requestOK;
    }

    /**
     * Changement de mail Admin.
     * @param mailadmin ancien mail
     * @param newmailadmin new mail
     * @return booléen
     * @throws Exception Exception
     */
    public static boolean changementMailAdmin(final String newmailadmin)
            throws Exception {

        if (Bd.cx == null) {
            Bd.connexion();
        }
        // Statement pour effectuer la requête
        Statement statement;
         //Ouverture de la connexion
        try {
            cx = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Erreur ouverture connexion" + ex.getMessage());
        }
        try {
            statement = cx.createStatement();
        } catch (SQLException error) {
            throw new Exception("Problème avec création du statement : "
                    + error.getMessage());
        }
        boolean requestOK = false;

        /* Requête */
        String sqlupdate = "UPDATE UTILISATEUR SET EMAILU = '"
                            + newmailadmin
                            + "' "
                            + "WHERE TYPE='admin'";

        try {
            Statement st = cx.createStatement();
            /* Execution de la requête */
            try {
                st.executeUpdate(sqlupdate);
                requestOK = true;
                st.close();
                cx.close();
            } catch (SQLException ex) {
                    System.out.println("Erreur execution requête "
                            + ex.getMessage());
                }
        } catch (SQLException ex) {
                System.out.println("Erreur de SQL statement "
                        + ex.getMessage());
        }
        return requestOK;
    }
    // Request test
    /*public static void main(String[] args)
        throws ClassNotFoundException, SQLException, Exception {

        Bd unebd = new Bd();
        boolean admin = unebd.getAdmin("admin@admin.com", "123");
        System.out.println(admin);
    }*/
}
