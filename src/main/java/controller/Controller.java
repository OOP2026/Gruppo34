package controller;

import java.time.LocalDate;
import java.time.Year;
import model.Utente;
import model.Studente;
import model.Docente;
import model.UtenteManager;

import java.time.LocalDate;
import java.time.Year;

public class Controller {

	public Controller(){
		Studente s1 = new Studente(
				"Brando",
				"Di Palma",
				LocalDate.of(2003, 12, 21),
				"brandodipalma03@gmail.com",
				"Brando",
				"Test",
				"DE1000284",
				"Informatica",
				3,
				60,
				Year.of(2023)
		);
		UtenteManager.registraUtente(s1);
	}

	public Utente login(String login, String password) {
		Utente user = UtenteManager.trovaPerLogin(login);
		if (user != null && user.effettuaLogin(password)) {
			return user;
		}
		return null;
	}
	
}
