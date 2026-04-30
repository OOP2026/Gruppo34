package model;

import java.time.LocalDate;

public abstract class Utente {
    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;
    private String email;
    private String login;
    private String password;

    public Utente(String nome, String cognome, LocalDate dataDiNascita, String email, String login, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public boolean effettuaLogin(String password) {
        return password.equals(this.password);
    }

    public void modificaPassword(String nuovaPassword) {
        this.password = nuovaPassword;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
