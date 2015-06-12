package com.eowebtesting.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.eowebtesting.beans.User;
import com.eowebtesting.dao.DAOFactory;
import com.eowebtesting.dao.UserDao;
import com.eowebtesting.forms.InscriptionForm;
/**
 * Created by oussama.elbouzi on 07/06/2015.
 */
@WebServlet(name = "Signup")
public class Signup extends HttpServlet {
    public static final String CONF_DAO_FACTORY = "daofactory";
    public static final String ATT_USER = "user";
    public static final String ATT_FORM = "form";
    public static final String VUE = "/WEB-INF/signup.jsp";

    private UserDao     utilisateurDao;

    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Utilisateur */
        this.utilisateurDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUtilisateurDao();
    }

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Préparation de l'objet formulaire */
        InscriptionForm form = new InscriptionForm( utilisateurDao );


        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
        User user = form.inscrireUtilisateur( request );

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_USER, user );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}
