package com.eowebtesting;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by oussama.elbouzi on 07/06/2015.
 */
@WebServlet(name = "Signup")
public class Signup extends HttpServlet {
    public static final String VUE = "/WEB-INF/signup.jsp";
    public static final String CHAMP_EMAIL = "email";
    public static final String CHAMP_PASS = "password";
    public static final String CHAMP_CONF = "confirmation";
    public static final String CHAMP_NOM = "name";
    public static final String ATT_ERREURS  = "erreurs";
    public static final String ATT_RESULTAT = "resultat";


    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        String resultat;
        Map<String, String> erreurs = new HashMap<String, String>();

        /* Récupération des champs du formulaire. */
        String email = request.getParameter( CHAMP_EMAIL );
        String password = request.getParameter( CHAMP_PASS );
        String confirmation = request.getParameter( CHAMP_CONF );
        String name = request.getParameter( CHAMP_NOM );

        /* Validation du champ email. */
        try {
            validationEmail( email );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_EMAIL, e.getMessage() );
        }

        /* Validation des champs mot de passe et confirmation. */
        try {
            validationPassword( password, confirmation );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_PASS, e.getMessage() );
        }

        /* Validation du champ nom. */
        try {
            validationName(name);
        } catch ( Exception e ) {
            erreurs.put( CHAMP_NOM, e.getMessage() );
        }

        /* Initialisation du résultat global de la validation. */
        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'inscription.";
        } else {
            resultat = "Échec de l'inscription.";
        }

        /* Stockage du résultat et des messages d'erreur dans l'objet request */
        request.setAttribute( ATT_ERREURS, erreurs );
        request.setAttribute( ATT_RESULTAT, resultat );

        /* Transmission de la paire d'objets request/response à notre JSP */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    /**
     * Valide l'adresse mail saisie.
     */
    private void validationEmail( String email ) throws Exception {
        if ( email != null && email.trim().length() != 0 ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }
        } else {
            throw new Exception( "Please enter an email." );
        }
    }

    /**
     * Valide les mots de passe saisis.
     */
    private void validationPassword( String password, String confirmation ) throws Exception{
        if (password != null && password.trim().length() != 0 && confirmation != null && confirmation.trim().length() != 0) {
            if (!password.equals(confirmation)) {
                throw new Exception("Entered passwords are different, thank you to enter them again.");
            } else if (password.trim().length() < 3) {
                throw new Exception("Passwords must contain at least 3 characters.");
            }
        } else {
            throw new Exception("Please enter and confirm your password.");
        }
    }

    /**
     * Valide le nom d'utilisateur saisi.
     */
    private void validationName( String name ) throws Exception {
        if ( name != null && name.trim().length() < 3 ) {
            throw new Exception( "Username must contain at least 3 characters." );
        }
    }
}
