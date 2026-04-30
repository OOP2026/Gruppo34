package model;

import java.time.LocalDate;

public class PrenotazioneSeduta {
    private String idPrenotazione;
    private Studente studente;
    private SedutaLaurea seduta;
    private LocalDate dataPrenotazione;

    public PrenotazioneSeduta(Studente studente, SedutaLaurea seduta) {
        this.idPrenotazione = "PREN-" + System.currentTimeMillis();
        this.studente = studente;
        this.seduta = seduta;
        this.dataPrenotazione = LocalDate.now();
    }

    public PrenotazioneSeduta(String idPrenotazione, Studente studente, SedutaLaurea seduta, LocalDate dataPrenotazione) {
        this.idPrenotazione = idPrenotazione;
        this.studente = studente;
        this.seduta = seduta;
        this.dataPrenotazione = dataPrenotazione;
    }

    public boolean confermaPrenotazione() {
        if (seduta.verificaDisponibilita()) {
            seduta.decrementaPosti();
            return true;
        }
        return false;
    }

    public String getIdPrenotazione() {
        return idPrenotazione;
    }

    public Studente getStudente() {
        return studente;
    }

    public SedutaLaurea getSeduta() {
        return seduta;
    }

    public LocalDate getDataPrenotazione() {
        return dataPrenotazione;
    }

    public void setIdPrenotazione(String idPrenotazione) {
        this.idPrenotazione = idPrenotazione;
    }

    public void setStudente(Studente studente) {
        this.studente = studente;
    }

    public void setSeduta(SedutaLaurea seduta) {
        this.seduta = seduta;
    }

    public void setDataPrenotazione(LocalDate dataPrenotazione) {
        this.dataPrenotazione = dataPrenotazione;
    }
}
