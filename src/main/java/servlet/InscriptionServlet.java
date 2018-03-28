package servlet;

import BD.bd;
import METIER.utilisateur;
import java.io.IOException;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "InscriptionServlet", 
        urlPatterns = {"/inscription"}
    )
public class InscriptionServlet extends HttpServlet {

    @Override
     public void doGet(HttpServletRequest requete,
                      HttpServletResponse reponse) throws ServletException, IOException
    {
        String code, nom,prenom,datenaissance,mail,tel,statuts,password,type;
        RequestDispatcher rd;
        code=requete.getParameter("codeu");
        nom=requete.getParameter("nom");
        prenom=requete.getParameter("prenom");
        datenaissance=requete.getParameter("datenaissance");
        mail=requete.getParameter("mail");
        tel=requete.getParameter("tel");
        statuts=requete.getParameter("statuts");
        password=requete.getParameter("password");
        type=requete.getParameter("type");
        utilisateur m=new utilisateur(code,nom,prenom,datenaissance,mail,tel,statuts,password,type);

       
        bd b=new bd();
        b.saisirUtilisateur(m);
        
        rd=requete.getRequestDispatcher("Confirmation.jsp");
        rd.forward(requete, reponse);
        
    }
    
}
