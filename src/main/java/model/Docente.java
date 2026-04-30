package model;

import java.time.LocalDate;

public class Docente extends Utente {
    private String idDocente;
    private Boolean isCoordinatore;

    public Docente(String nome, String cognome, LocalDate dataDiNascita, String email, String login, String password,
                   String idDocente, Boolean isCoordinatore) {
        super(nome, cognome, dataDiNascita, email, login, password);
        this.idDocente = idDocente;
        this.isCoordinatore = isCoordinatore;
    }

    public void pubblicaArgomentoTirocinio(Tirocinio t) {
        // Logica per pubblicare un argomento di tirocinio
    }

    public void valutaRichiestaTirocinio(RichiestaTirocinio r, boolean esito) {
        // Logica per valutare una richiesta di tirocinio
    }

    public void valutaTesi(Tesi t, boolean approvata) {
        // Logica per valutare una tesi
    }

    public String getIdDocente() {
        return idDocente;
    }

    public Boolean getIsCoordinatore() {
        return isCoordinatore;
    }

    public void setIdDocente(String idDocente) {
        this.idDocente = idDocente;
    }

    public void setIsCoordinatore(Boolean isCoordinatore) {
        this.isCoordinatore = isCoordinatore;
    }
}
