package model;

/**
 * Manager per la gestione della logica di business relativa alle richieste di tirocinio.
 * Responsabile di operazioni come creazione, valutazione e aggiornamento dello stato.
 */
public class RichiestaTirocinioManager {
    
    /**
     * Crea una nuova richiesta di tirocinio per uno studente.
     * 
     * @param studente lo studente che richiede il tirocinio
     * @param tirocinio il tirocinio richiesto
     * @return la richiesta di tirocinio creata
     */
    public RichiestaTirocinio richiediTirocinio(Studente studente, Tirocinio tirocinio) {
        if (studente != null && tirocinio != null) {
            return new RichiestaTirocinio(studente, tirocinio);
        }
        return null;
    }
    
    /**
     * Valuta una richiesta di tirocinio da parte di un docente.
     * 
     * @param richiesta la richiesta da valutare
     * @param docente il docente che valuta
     * @param esito true per approvazione, false per rifiuto
     */
    public void valutaRichiestaTirocinio(RichiestaTirocinio richiesta, Docente docente, boolean esito) {
        if (richiesta != null && docente != null) {
            String nuovoStato = esito ? "Approvata" : "Respinta";
            richiesta.aggiornaStato(nuovoStato);
        }
    }
}
