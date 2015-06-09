package com.eowebtesting.beans;

/**
 * Created by oussama.elbouzi on 08/06/2015.
 */
public class User {

        private String email;
        private String password;
        private String name;

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

}
