package model;

import java.time.LocalDate;

public class RichiestaTirocinio {
    private String idRichiesta;
    private Studente studenteRichiedente;
    private Tirocinio tirocinioRichiesto;
    private LocalDate dataInizio;
    private String statoRichiesta;

    public RichiestaTirocinio(Studente studenteRichiedente, Tirocinio tirocinioRichiesto) {
        this.idRichiesta = "REQ-" + System.currentTimeMillis();
        this.studenteRichiedente = studenteRichiedente;
        this.tirocinioRichiesto = tirocinioRichiesto;
        this.dataInizio = LocalDate.now();
        this.statoRichiesta = "In Attesa";
    }

    public RichiestaTirocinio(String idRichiesta, Studente studenteRichiedente, Tirocinio tirocinioRichiesto,
                              LocalDate dataInizio, String statoRichiesta) {
        this.idRichiesta = idRichiesta;
        this.studenteRichiedente = studenteRichiedente;
        this.tirocinioRichiesto = tirocinioRichiesto;
        this.dataInizio = dataInizio;
        this.statoRichiesta = statoRichiesta;
    }

    public void aggiornaStato(String nuovoStato) {
        if (nuovoStato.equals("In Attesa") || nuovoStato.equals("Approvata") || nuovoStato.equals("Respinta")) {
            this.statoRichiesta = nuovoStato;
        }
    }

    public String getIdRichiesta() {
        return idRichiesta;
    }

    public Studente getStudenteRichiedente() {
        return studenteRichiedente;
    }

    public Tirocinio getTirocinioRichiesto() {
        return tirocinioRichiesto;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public String getStatoRichiesta() {
        return statoRichiesta;
    }

    public void setIdRichiesta(String idRichiesta) {
        this.idRichiesta = idRichiesta;
    }

    public void setStudenteRichiedente(Studente studenteRichiedente) {
        this.studenteRichiedente = studenteRichiedente;
    }

    public void setTirocinioRichiesto(Tirocinio tirocinioRichiesto) {
        this.tirocinioRichiesto = tirocinioRichiesto;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public void setStatoRichiesta(String statoRichiesta) {
        this.statoRichiesta = statoRichiesta;
    }
}
