package com.eowebtesting;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by oussama.elbouzi on 27/05/2015.
 */
@WebServlet(name = "Login")
public class Login extends HttpServlet {

    private static final long serialVersionUID = 1L;



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Récupérer les données reçues du formulaire
        String loginEntered = (String) request.getParameter("login");
        String passwordEntered = (String) request.getParameter("password");

        // Si l'un des champs est vide
        if ("".equals(loginEntered) || "".equals(passwordEntered)) {
            request.setAttribute("erreur", "Vous devez remplir les deux champs.");
            // Redirection vers le formulaire form.jsp
            getServletContext().getRequestDispatcher("/login.jsp")
                    .forward(request, response);
        }

        // Sinon
        else {
            request.setAttribute("login", loginEntered);
            request.setAttribute("password", passwordEntered);
            // Redirection vers la page Home.jsp
            getServletContext().getRequestDispatcher("/Home.jsp")
                    .forward(request, response);
        }
    }

}
