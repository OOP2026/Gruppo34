package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;

public class TestModel {

	public static void main(String[] args) {
		Docente docente = new Docente("Mario", "Rossi", LocalDate.of(1970, 5, 15),
				"mario.rossi@university.it", "mrossi", "password123", "DOC001", true);

		Studente studente = new Studente("Luca", "Bianchi", LocalDate.of(2002, 3, 20),
				"luca.bianchi@university.it", "lbianchi", "pass456",
				"MAT123456", "Informatica", 90, 30, Year.of(2021));

		Tirocinio tirocinio = new Tirocinio("TIR001", "Sviluppo Backend Java",
				300, docente);

		TirocinioEsterno tirocinioEsterno = new TirocinioEsterno("TIR002", "Sviluppo Frontend React",
				250, docente, "TechCorp S.p.A.", "Giovanni Neri");

		System.out.println("Login valido: " + docente.effettuaLogin("password123"));
		System.out.println("Login non valido: " + docente.effettuaLogin("wrongpassword"));

		RichiestaTirocinio richiesta = studente.richiediTirocinio(tirocinio);
		System.out.println("\nRichiesta tirocinio creata:");
		System.out.println("ID Richiesta: " + richiesta.getIdRichiesta());
		System.out.println("Stato: " + richiesta.getStatoRichiesta());

		Tesi tesi = new Tesi("TESI001", "Architetture Microservizi", "/path/to/thesis.pdf",
				studente, docente);
		System.out.println("\nTesi creata:");
		System.out.println("Titolo: " + tesi.getTitolo());
		System.out.println("Stato: " + tesi.getStatoApprovazione());

		tesi.richiediRevisione();
		System.out.println("Dopo revisione: " + tesi.getStatoApprovazione());

		SedutaLaurea seduta = new SedutaLaurea("SED001", LocalDate.of(2024, 6, 15),
				LocalTime.of(9, 30), "Aula Magna", 50);
		System.out.println("\nSeduta di laurea creata:");
		System.out.println("Data: " + seduta.getDataSeduta());
		System.out.println("Posti disponibili: " + seduta.getPostiDisponibili());
		System.out.println("Disponibilità: " + seduta.verificaDisponibilita());

		PrenotazioneSeduta prenotazione = studente.prenotaSedutaLaurea(seduta);
		System.out.println("\nPrenotazione confermata: " + prenotazione.confermaPrenotazione());
		System.out.println("Posti rimasti: " + seduta.getPostiDisponibili());

		System.out.println("\nDettagli tirocinio: " + tirocinio.getDettagliTirocinio());
		System.out.println("Dettagli tirocinio esterno: " + tirocinioEsterno.getDettagliTirocinio());
	}

}
