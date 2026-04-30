package model;

public class Tirocinio {
    private String idTirocinio;
    private String argomento;
    private Integer totaleOre;
    private Docente docenteProponente;

    public Tirocinio(String idTirocinio, String argomento, Integer totaleOre, Docente docenteProponente) {
        this.idTirocinio = idTirocinio;
        this.argomento = argomento;
        this.totaleOre = totaleOre;
        this.docenteProponente = docenteProponente;
    }

    public String getDettagliTirocinio() {
        return "Tirocinio[" +
                "id=" + idTirocinio +
                ", argomento=" + argomento +
                ", ore=" + totaleOre +
                ", docente=" + docenteProponente.getNome() + " " + docenteProponente.getCognome() +
                "]";
    }

    public String getIdTirocinio() {
        return idTirocinio;
    }

    public String getArgomento() {
        return argomento;
    }

    public Integer getTotaleOre() {
        return totaleOre;
    }

    public Docente getDocenteProponente() {
        return docenteProponente;
    }

    public void setIdTirocinio(String idTirocinio) {
        this.idTirocinio = idTirocinio;
    }

    public void setArgomento(String argomento) {
        this.argomento = argomento;
    }

    public void setTotaleOre(Integer totaleOre) {
        this.totaleOre = totaleOre;
    }

    public void setDocenteProponente(Docente docenteProponente) {
        this.docenteProponente = docenteProponente;
    }
}
