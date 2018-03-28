/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import model.Utilisateur;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zhanghuakai
 */
public class Bd {
    private static Connection cx;
    
    //données de connexion
    private static String url="jdbc:mysql://np903346ltnyr11z:dsbumc5602c2y8ky@m60mxazb4g6sb4nn.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/fupu8i1nlz5lkcc8";
    private String login="21514547";
    private String password="Q048F5";
 
    
    //constucteur

    public Bd() {
        //chargement du pilote pour la BD
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException ex){
            System.out.println("not good"+ex.getMessage());
        }
        //ouverture de la connexion
        try{
            this.cx=DriverManager.getConnection(url, login, password);
        }
        catch(SQLException ex){
            System.out.println("Erreur ouverture connextion"+ex.getMessage());
        }
    }
    
     public void saisirUtilisateur(Utilisateur utili){
        Statement st=null;
        try {
            st = cx.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            st.executeUpdate("insert into utilisateur(CODEU,NOMU,PRENOMU,DATEDENAISSANCEU,EMAILU,TELU,STATUTS,PASSWORD,TYPE) values('"+utili.getCodeu()+"','"
                                        +utili.getNomu()+"','"+utili.getPrenomu()+"','"+utili.getDatenaissanceu()+"','"+
                                        utili.getEmailu()+"','"+utili.getTelu()+"','"+utili.getStatuts()+"','"+
                                        utili.getPassword()+"','"+utili.getType()+"')");
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
    public static boolean getUtilisateur(final String mail, final String pwd)
            throws Exception {
        // Statement to handle query
        Statement statement;

        try {
            statement = cx.createStatement();
        } catch (SQLException error) {
            throw new Exception("Problem with the statement creation : "
                    + error.getMessage());
        }
        boolean requestOK;
        String query = "SELECT * "
                + "from UTILISATEUR "
                + "where EMAILU=? "
                + "and PASSWORD=? "
                + "and TYPE='admin'"
                + ";";

        try {
            PreparedStatement pstmt = cx.prepareStatement(query);
            pstmt.setString(1, mail);
            pstmt.setString(2, pwd);
            requestOK = pstmt.execute();
        } catch (SQLException error) {
            throw new Exception("Problem when insert to the table : "
                    + error.getMessage());
        }
        return requestOK;
     }
}
