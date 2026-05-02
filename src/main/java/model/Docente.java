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
