package model;

import java.util.ArrayList;
import java.util.List;

public class UtenteManager {
    private static List<Utente> utenti = new ArrayList<>();

    public static void registraUtente(Utente utente) {
        utenti.add(utente);
    }

    public Utente trovaPerEmail(String email) {
        for(Utente u : utenti){
            if(u.getEmail().equals(email)){
                return u;
            }
        }
        return null;
    }

    public static Utente trovaPerLogin(String login) {
        for(Utente u : utenti){
            if(u.getLogin().equals(login)){
                return u;
            }
        }
        return null;
    }

    public static List<Utente> getUtenti() {
        return utenti;
    }
}