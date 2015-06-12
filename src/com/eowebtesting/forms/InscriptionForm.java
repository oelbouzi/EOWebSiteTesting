package com.eowebtesting.forms;


import com.eowebtesting.beans.User;
import com.eowebtesting.dao.DAOException;
import com.eowebtesting.dao.UserDao;
import org.jasypt.util.password.ConfigurablePasswordEncryptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by oussama.elbouzi on 08/06/2015.
 */
public class InscriptionForm {
    private UserDao      utilisateurDao;
    private static final String CHAMP_EMAIL  = "email";
    private static final String CHAMP_PASS   = "password";
    private static final String CHAMP_CONF   = "confirmation";
    private static final String CHAMP_NOM    = "name";
    private String              resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();
    private static final String ALGO_CHIFFREMENT = "SHA-256";

    public InscriptionForm( UserDao utilisateurDao ) {
        this.utilisateurDao = utilisateurDao;
    }

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public User inscrireUtilisateur( HttpServletRequest request ) {
        String email = getValeurChamp( request, CHAMP_EMAIL );
        String password = getValeurChamp( request, CHAMP_PASS );
        String confirmation = getValeurChamp( request, CHAMP_CONF );
        String name = getValeurChamp( request, CHAMP_NOM );

        User utilisateur = new User();

        try {
            traiterEmail( email, utilisateur );
            traiterMotsDePasse( password, confirmation, utilisateur );
            traiterName(name, utilisateur);

            if ( erreurs.isEmpty() ) {
                utilisateurDao.creer( utilisateur );
                resultat = "Succès de l'inscription.";
            } else {
                resultat = "Échec de l'inscription.";
            }
        } catch ( DAOException e ) {
            resultat = "Échec de l'inscription : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
            e.printStackTrace();
        }

        return utilisateur;
    }


    private void validationPassword( String password, String confirmation ) throws Exception {
        if ( password != null && confirmation != null ) {
            if ( !password.equals( confirmation ) ) {
                throw new Exception( "Entered passwords are different, thank you to enter them again." );
            } else if ( password.length() < 3 ) {
                throw new Exception( "Passwords must contain at least 3 characters." );
            }
        } else {
            throw new Exception( "Please enter and confirm your password." );
        }
    }

    private void validationName( String name ) throws Exception {
        if ( name != null && name.length() < 3 ) {
            throw new Exception( "The username must contain at least 3 characters." );
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
    private static String getValeurChamp( HttpServletRequest request, String nameChamp ) {
        String valeur = request.getParameter( nameChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }

    /*
 * Appel à la validation de l'adresse email reçue et initialisation de la
 * propriété email du bean
 */
    private void traiterEmail( String email, User utilisateur ) {
        try {
            validationEmail( email );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        utilisateur.setEmail( email );
    }

    /*
     * Appel à la validation des mots de passe reçus, chiffrement du mot de
     * passe et initialisation de la propriété motDePasse du bean
     */
    private void traiterMotsDePasse( String motDePasse, String confirmation, User utilisateur ) {
        try {
            validationPassword(motDePasse, confirmation);
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
            setErreur( CHAMP_CONF, null );
        } catch (Exception e) {
            e.printStackTrace();
        }

    /*
     * Utilisation de la bibliothèque Jasypt pour chiffrer le mot de passe
     * efficacement.
     *
     * L'algorithme SHA-256 est ici utilisé, avec par défaut un salage
     * aléatoire et un grand nombre d'itérations de la fonction de hashage.
     *
     * La String retournée est de longueur 56 et contient le hash en Base64.
     */
        ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
        passwordEncryptor.setAlgorithm( ALGO_CHIFFREMENT );
        passwordEncryptor.setPlainDigest( false );
        String motDePasseChiffre = passwordEncryptor.encryptPassword( motDePasse );

        utilisateur.setPassword(motDePasseChiffre);
    }

    /* Validation de l'adresse email */
    private void validationEmail( String email ) throws FormValidationException {
        if ( email != null ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new FormValidationException( "Merci de saisir une adresse mail valide." );
            } else if ( utilisateurDao.trouver( email ) != null ) {
                throw new FormValidationException( "Cette adresse email est déjà utilisée, merci d'en choisir une autre." );
            }
        } else {
            throw new FormValidationException( "Merci de saisir une adresse mail." );
        }
    }

    /*
     * Appel Ã  la validation du nom reÃ§u et initialisation de la propriÃ©tÃ© nom
     * du bean
     */
    private void traiterName( String name, User utilisateur ) {
        try {
            validationName(name);
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        } catch (Exception e) {
            e.printStackTrace();
        }
        utilisateur.setName(name);
    }
}
