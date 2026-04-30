package model;

import java.time.LocalDate;
import java.time.Year;

public class Studente extends Utente {
    private String matricola;
    private String corsoDiLaurea;
    private Integer cfuMaturati;
    private Integer cfuDaMaturare;
    private Year annoImmatricolazione;

    public Studente(String nome, String cognome, LocalDate dataDiNascita, String email, String login, String password,
                    String matricola, String corsoDiLaurea, Integer cfuMaturati, Integer cfuDaMaturare, Year annoImmatricolazione) {
        super(nome, cognome, dataDiNascita, email, login, password);
        this.matricola = matricola;
        this.corsoDiLaurea = corsoDiLaurea;
        this.cfuMaturati = cfuMaturati;
        this.cfuDaMaturare = cfuDaMaturare;
        this.annoImmatricolazione = annoImmatricolazione;
    }

    public RichiestaTirocinio richiediTirocinio(Tirocinio t) {
        RichiestaTirocinio richiesta = new RichiestaTirocinio(this, t);
        return richiesta;
    }

    public void caricaTesi(Tesi t) {
        // Logica per caricare una tesi
    }

    public PrenotazioneSeduta prenotaSedutaLaurea(SedutaLaurea s) {
        PrenotazioneSeduta prenotazione = new PrenotazioneSeduta(this, s);
        return prenotazione;
    }

    public String getMatricola() {
        return matricola;
    }

    public String getCorsoDiLaurea() {
        return corsoDiLaurea;
    }

    public Integer getCfuMaturati() {
        return cfuMaturati;
    }

    public Integer getCfuDaMaturare() {
        return cfuDaMaturare;
    }

    public Year getAnnoImmatricolazione() {
        return annoImmatricolazione;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public void setCorsoDiLaurea(String corsoDiLaurea) {
        this.corsoDiLaurea = corsoDiLaurea;
    }

    public void setCfuMaturati(Integer cfuMaturati) {
        this.cfuMaturati = cfuMaturati;
    }

    public void setCfuDaMaturare(Integer cfuDaMaturare) {
        this.cfuDaMaturare = cfuDaMaturare;
    }

    public void setAnnoImmatricolazione(Year annoImmatricolazione) {
        this.annoImmatricolazione = annoImmatricolazione;
    }
}
