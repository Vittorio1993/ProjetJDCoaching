/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import database.Bd;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alexandre
 */
@WebServlet(name = "ParametrageMail", urlPatterns = {"/ParametrageMail"})
public class ParametrageMail extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(final HttpServletRequest request,
            final HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(true);
        String ancienmail = (String) session.getAttribute("mail");
        System.out.println(ancienmail);
        String mail = request.getParameter("mail");
        System.out.println(mail);
        boolean changementMail = false;
        boolean error = false;

        //Test sur les champs de mail et de password
        if (mail == null || mail.length() == 0) {
            error = true;
        }

        //Renvoi page de connexion
        if (error) {
            request.setAttribute("mail", mail);
            if ("".equals(mail)) {
            request.setAttribute("erreur",
                    "<p class=\"alert alert-danger\">Le mail doit être renseigné.</p>");
            RequestDispatcher rd = request
                        .getRequestDispatcher("parametragemail.jsp");
            rd.forward(request, response);
            }
        } else {
            try {
                //Test Changement Mail Admin
                changementMail = Bd.getAdmin(ancienmail, mail);
                if (changementMail) {
                    RequestDispatcher rd = request
                            .getRequestDispatcher("parametragemaildone.jsp");
                    rd.forward(request, response);
                }
            } catch (Exception e) {
                RequestDispatcher rd = request
                        .getRequestDispatcher("parametragemail.jsp");
                rd.forward(request, response);
            }
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods.
    // Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(final HttpServletRequest request,
            final HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(final HttpServletRequest request,
            final HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Vérification Admin";
    }
}
