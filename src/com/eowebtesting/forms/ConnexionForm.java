package com.eowebtesting.forms;

/**
 * Created by oussama.elbouzi on 09/06/2015.
 */

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.eowebtesting.beans.User;

public final class ConnexionForm {
    private static final String CHAMP_EMAIL  = "email";
    private static final String CHAMP_PASS   = "password";

    private String              resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public User connecterUtilisateur( HttpServletRequest request ) {
        /* Récupération des champs du formulaire */
        String email = getValeurChamp( request, CHAMP_EMAIL );
        String password = getValeurChamp( request, CHAMP_PASS );

        User utilisateur = new User();

        /* Validation du champ email. */
        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        utilisateur.setEmail( email );

        /* Validation du champ mot de passe. */
        try {
            validationPassword(password);
        } catch ( Exception e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
        }
        utilisateur.setPassword(password);

        /* Initialisation du résultat global de la validation. */
        if ( erreurs.isEmpty() ) {
            resultat = "Successful connexion.";
        } else {
            resultat = "Failed connexion.";
        }

        return utilisateur;
    }

    /**
     * Valide l'adresse email saisie.
     */
    private void validationEmail( String email ) throws Exception {
        if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new Exception( "Please enter a valid email." );
        }
    }

    /**
     * Valide le mot de passe saisi.
     */
    private void validationPassword( String password ) throws Exception {
        if ( password != null ) {
            if ( password.length() < 3 ) {
                throw new Exception( "Passwords must contain at least 3 characters." );
            }
        } else {
            throw new Exception( "Please enter your password." );
        }
    }

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}
