package com.eowebtesting.dao;

/**
 * Created by oussama.elbouzi on 10/06/2015.
 */
public class DAOException extends RuntimeException {
    /*
     * Constructeurs
     */
    public DAOException( String message ) {
        super( message );
    }

    public DAOException( String message, Throwable cause ) {
        super( message, cause );
    }

    public DAOException( Throwable cause ) {
        super( cause );
    }
}
