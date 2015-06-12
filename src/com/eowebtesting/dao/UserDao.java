package com.eowebtesting.dao;

import com.eowebtesting.beans.User;

/**
 * Created by oussama.elbouzi on 10/06/2015.
 */
public interface UserDao {

    void creer( User utilisateur ) throws DAOException;

    User trouver( String email ) throws DAOException;
}
