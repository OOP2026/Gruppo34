package model;

public class Tesi {
    private String idTesi;
    private String titolo;
    private String percorsoFile;
    private Studente autore;
    private Docente relatore;
    private String statoApprovazione;

    public Tesi(String idTesi, String titolo, String percorsoFile, Studente autore, Docente relatore) {
        this.idTesi = idTesi;
        this.titolo = titolo;
        this.percorsoFile = percorsoFile;
        this.autore = autore;
        this.relatore = relatore;
        this.statoApprovazione = "Bozza";
    }

    public Tesi(String idTesi, String titolo, String percorsoFile, Studente autore, Docente relatore, String statoApprovazione) {
        this.idTesi = idTesi;
        this.titolo = titolo;
        this.percorsoFile = percorsoFile;
        this.autore = autore;
        this.relatore = relatore;
        this.statoApprovazione = statoApprovazione;
    }

    public void richiediRevisione() {
        if (this.statoApprovazione.equals("Bozza")) {
            this.statoApprovazione = "Revisione";
        }
    }

    public void approvaTesi() {
        this.statoApprovazione = "Approvata";
    }

    public String getIdTesi() {
        return idTesi;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getPercorsoFile() {
        return percorsoFile;
    }

    public Studente getAutore() {
        return autore;
    }

    public Docente getRelatore() {
        return relatore;
    }

    public String getStatoApprovazione() {
        return statoApprovazione;
    }

    public void setIdTesi(String idTesi) {
        this.idTesi = idTesi;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setPercorsoFile(String percorsoFile) {
        this.percorsoFile = percorsoFile;
    }

    public void setAutore(Studente autore) {
        this.autore = autore;
    }

    public void setRelatore(Docente relatore) {
        this.relatore = relatore;
    }

    public void setStatoApprovazione(String statoApprovazione) {
        this.statoApprovazione = statoApprovazione;
    }
}
