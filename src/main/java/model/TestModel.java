package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;

public class TestModel {

	public static void main(String[] args) {
		// Istanziazione delle Entità
		Docente docente = new Docente("Mario", "Rossi", LocalDate.of(1970, 5, 15),
				"mario.rossi@university.it", "mrossi", "password123", "DOC001", true);

		Studente studente = new Studente("Luca", "Bianchi", LocalDate.of(2002, 3, 20),
				"luca.bianchi@university.it", "lbianchi", "pass456",
				"MAT123456", "Informatica", 90, 30, Year.of(2021));

		Tirocinio tirocinio = new Tirocinio("TIR001", "Sviluppo Backend Java",
				300, docente);

		TirocinioEsterno tirocinioEsterno = new TirocinioEsterno("TIR002", "Sviluppo Frontend React",
				250, docente, "TechCorp S.p.A.", "Giovanni Neri");

		// Test autenticazione (metodo su Entità)
		System.out.println("Login valido: " + docente.effettuaLogin("password123"));
		System.out.println("Login non valido: " + docente.effettuaLogin("wrongpassword"));

		// ===== Gestione Tirocini =====
		TirocinioManager tirocinioManager = new TirocinioManager();
		System.out.println("\n--- Test TirocinioManager ---");
		System.out.println("Pubblicazione tirocinio: " + tirocinioManager.pubblicaArgomentoTirocinio(docente, tirocinio));

		// ===== Gestione Richieste Tirocinio =====
		RichiestaTirocinioManager richiestaTirocinioManager = new RichiestaTirocinioManager();
		RichiestaTirocinio richiesta = richiestaTirocinioManager.richiediTirocinio(studente, tirocinio);
		System.out.println("\n--- Test RichiestaTirocinioManager ---");
		System.out.println("Richiesta tirocinio creata:");
		System.out.println("ID Richiesta: " + richiesta.getIdRichiesta());
		System.out.println("Stato: " + richiesta.getStatoRichiesta());
		
		richiestaTirocinioManager.valutaRichiestaTirocinio(richiesta, docente, true);
		System.out.println("Dopo valutazione: " + richiesta.getStatoRichiesta());

		// ===== Gestione Tesi =====
		Tesi tesi = new Tesi("TESI001", "Architetture Microservizi", "/path/to/thesis.pdf",
				studente, docente, "Bozza");
		TesiManager tesiManager = new TesiManager();
		System.out.println("\n--- Test TesiManager ---");
		System.out.println("Tesi creata:");
		System.out.println("Titolo: " + tesi.getTitolo());
		System.out.println("Stato: " + tesi.getStatoApprovazione());

		System.out.println("Caricamento tesi: " + tesiManager.caricaTesi(studente, tesi));
		
		System.out.println("Revisione richiesta: " + tesiManager.richiediRevisione(tesi));
		System.out.println("Stato dopo revisione: " + tesi.getStatoApprovazione());
		
		System.out.println("Approvazione tesi: " + tesiManager.approvaTesi(tesi, docente));
		System.out.println("Stato finale: " + tesi.getStatoApprovazione());

		// ===== Gestione Prenotazioni =====
		SedutaLaurea seduta = new SedutaLaurea("SED001", LocalDate.of(2024, 6, 15),
				LocalTime.of(9, 30), "Aula Magna", 50);
		PrenotazioneManager prenotazioneManager = new PrenotazioneManager();
		System.out.println("\n--- Test PrenotazioneManager ---");
		System.out.println("Seduta di laurea creata:");
		System.out.println("Data: " + seduta.getDataSeduta());
		System.out.println("Posti disponibili: " + seduta.getPostiDisponibili());
		System.out.println("Disponibilità: " + seduta.verificaDisponibilita());

		PrenotazioneSeduta prenotazione = prenotazioneManager.prenotaSedutaLaurea(studente, seduta);
		System.out.println("\nPrenotazione confermata: " + prenotazioneManager.confermaPrenotazione(prenotazione));
		System.out.println("Posti rimasti: " + seduta.getPostiDisponibili());

		// ===== Dettagli Tirocini =====
		System.out.println("\n--- Dettagli Tirocini ---");
		System.out.println("Dettagli tirocinio: " + tirocinio.getDettagliTirocinio());
		System.out.println("Dettagli tirocinio esterno: " + tirocinioEsterno.getDettagliTirocinio());
	}

}
