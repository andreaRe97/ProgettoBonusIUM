package com.example.andreare.bonus_re_andrea;

import java.io.Serializable;

/*Classe che identifica un Utente:
 *  Ciascun utente è identificato da un username e una password
 */
public class User implements Serializable {

    private String username;
    private String password;

    public User() {
        this.username = "";
        this.password = "";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return username;
    }

    @Override
    public boolean equals (Object x) {
        boolean r = false;
        if (x instanceof User) {
            User u = (User) x;
            r = (u.getPassword().equals(this.getPassword())) && (u.getUsername().equals(this.getUsername()));
        }
        return r;
    }

}
