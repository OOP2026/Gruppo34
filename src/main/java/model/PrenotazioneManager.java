package model;

/**
 * Manager per la gestione della logica di business relativa alle prenotazioni di sedute di laurea.
 * Responsabile di operazioni come creazione e conferma di prenotazioni.
 */
public class PrenotazioneManager {
    
    /**
     * Crea una prenotazione per una seduta di laurea.
     * 
     * @param studente lo studente che prenota
     * @param seduta la seduta di laurea per cui prenotarsi
     * @return la prenotazione creata
     */
    public PrenotazioneSeduta prenotaSedutaLaurea(Studente studente, SedutaLaurea seduta) {
        if (studente != null && seduta != null) {
            return new PrenotazioneSeduta(studente, seduta);
        }
        return null;
    }
    
    /**
     * Conferma una prenotazione verificando la disponibilità di posti e decrementandoli.
     * 
     * @param prenotazione la prenotazione da confermare
     * @return true se la prenotazione è stata confermata, false se non ci sono posti disponibili
     */
    public boolean confermaPrenotazione(PrenotazioneSeduta prenotazione) {
        if (prenotazione != null) {
            SedutaLaurea seduta = prenotazione.getSeduta();
            if (seduta != null && seduta.verificaDisponibilita()) {
                seduta.decrementaPosti();
                return true;
            }
        }
        return false;
    }
}
