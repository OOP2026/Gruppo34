package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class SedutaLaurea {
    private String idSeduta;
    private LocalDate dataSeduta;
    private LocalTime orarioInizio;
    private String aula;
    private Integer postiDisponibili;

    public SedutaLaurea(String idSeduta, LocalDate dataSeduta, LocalTime orarioInizio, String aula, Integer postiDisponibili) {
        this.idSeduta = idSeduta;
        this.dataSeduta = dataSeduta;
        this.orarioInizio = orarioInizio;
        this.aula = aula;
        this.postiDisponibili = postiDisponibili;
    }

    public boolean verificaDisponibilita() {
        return postiDisponibili > 0;
    }

    public void decrementaPosti() {
        if (postiDisponibili > 0) {
            postiDisponibili--;
        }
    }

    public String getIdSeduta() {
        return idSeduta;
    }

    public LocalDate getDataSeduta() {
        return dataSeduta;
    }

    public LocalTime getOrarioInizio() {
        return orarioInizio;
    }

    public String getAula() {
        return aula;
    }

    public Integer getPostiDisponibili() {
        return postiDisponibili;
    }

    public void setIdSeduta(String idSeduta) {
        this.idSeduta = idSeduta;
    }

    public void setDataSeduta(LocalDate dataSeduta) {
        this.dataSeduta = dataSeduta;
    }

    public void setOrarioInizio(LocalTime orarioInizio) {
        this.orarioInizio = orarioInizio;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public void setPostiDisponibili(Integer postiDisponibili) {
        this.postiDisponibili = postiDisponibili;
    }
}
