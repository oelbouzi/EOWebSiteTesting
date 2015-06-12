package com.eowebtesting.beans;

import java.sql.Timestamp;

/**
 * Created by oussama.elbouzi on 08/06/2015.
 */
public class User {
        private Long      id;
        private String email;
        private String password;
        private String name;
        private Timestamp dateSingUp;

        public void setEmail(String email) {
            this.email = email;
        }

        public String getEmail() {
            return email;
        }

        public void setPassword(String motDePasse) {
            this.password = motDePasse;
        }

        public String getPassword() {
            return password;
        }

        public void setName(String nom) {
            this.name = nom;
        }

        public String getName() {
            return name;
        }

        public Timestamp getDateSingUp() {
            return dateSingUp;
        }

        public void setDateSingUp(Timestamp dateSingUp) {
            this.dateSingUp = dateSingUp;
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
