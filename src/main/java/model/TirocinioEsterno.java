package model;

public class TirocinioEsterno extends Tirocinio {
    private String aziendaSeguita;
    private String referenteAziendale;

    public TirocinioEsterno(String idTirocinio, String argomento, Integer totaleOre, Docente docenteProponente,
                            String aziendaSeguita, String referenteAziendale) {
        super(idTirocinio, argomento, totaleOre, docenteProponente);
        this.aziendaSeguita = aziendaSeguita;
        this.referenteAziendale = referenteAziendale;
    }

    public String getAziendaSeguita() {
        return aziendaSeguita;
    }

    public String getReferenteAziendale() {
        return referenteAziendale;
    }

    public void setAziendaSeguita(String aziendaSeguita) {
        this.aziendaSeguita = aziendaSeguita;
    }

    public void setReferenteAziendale(String referenteAziendale) {
        this.referenteAziendale = referenteAziendale;
    }
}
