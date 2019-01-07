package com.example.andreare.bonus_re_andrea;

import java.util.ArrayList;

/*Factory di utenti
 * I soli utenti iscritti all'ipotetico "portale" sono presenti in questa factory
 */

public class UserFactory {
    //uso un singleton
    private static UserFactory instance;
    private ArrayList <User> usersList = new ArrayList<>();

    private UserFactory() {
        User u1 = new User();
        u1.setUsername("mariorossi");
        u1.setPassword("mario1234");

        User u2 = new User();
        u2.setUsername("lucabianchi");
        u2.setPassword("luca1234");

        User u3 = new User();
        u3.setUsername("andreaneri");
        u3.setPassword("andrea1234");

        usersList.add(u1);
        usersList.add(u2);
        usersList.add(u3);
    }

    public static UserFactory getInstance() {
        //metodo che restituisce l'istanza della factory
        if(instance == null)
            instance = new UserFactory();
        return instance;
    }

    public boolean isIn (User x) {
        boolean result = usersList.contains(x);
        //metodo che restituisce se un utente è presente o meno nella factory
        return result;
    }

}
