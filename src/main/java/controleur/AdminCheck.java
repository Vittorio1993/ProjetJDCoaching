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

/**
 *
 * @author Alexandre
 */
@WebServlet(name = "Connexion", urlPatterns = {"/Connecter"})
public class AdminCheck extends HttpServlet {
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
        RequestDispatcher requestDError = request.
                getRequestDispatcher("");
        request.setCharacterEncoding("UTF-8");
        String mail = request.getParameter("mail").trim();
        String password = request.getParameter("password").trim();
        boolean error = false;

        if (mail == null || mail.length() == 0) {
            request.setAttribute("errorPseudo", true);
            error = true;
        }

        if (password == null || password.length() == 0) {
            request.setAttribute("errorTextMessage", true);
            error = true;
        }

        if (error) {
            request.setAttribute("mail", mail);
            request.setAttribute("password", password);
            requestDError.forward(request, response);
        } else {
            try {
                boolean admin = Bd.getUtilisateur(mail, password);
                response.sendRedirect("/livreor/messages");
            } catch (Exception e) {
                request.setAttribute("mail", mail);
                request.setAttribute("password", password);
                request.setAttribute("error", e.getMessage());
                requestDError.forward(request, response);
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
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
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
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
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
        return "Short description";
    }
}
