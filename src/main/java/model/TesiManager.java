package model;

/**
 * Manager per la gestione della logica di business relativa alle tesi.
 * Responsabile di operazioni come richiesta revisione, approvazione e caricamento.
 */
public class TesiManager {
    
    /**
     * Carica una tesi proposta da uno studente.
     * 
     * @param studente lo studente autore della tesi
     * @param tesi la tesi da caricare
     * @return true se il caricamento ha successo, false altrimenti
     */
    public boolean caricaTesi(Studente studente, Tesi tesi) {
        if (studente != null && tesi != null && tesi.getAutore().equals(studente)) {
            // Logica per il caricamento della tesi
            // (in una applicazione reale, verrebbe salvata in un storage)
            return true;
        }
        return false;
    }
    
    /**
     * Richiede una revisione della tesi.
     * La tesi deve essere in stato "Bozza" per poter richiedere revisione.
     * 
     * @param tesi la tesi da sottoporre a revisione
     * @return true se la revisione è stata richiesta, false altrimenti
     */
    public boolean richiediRevisione(Tesi tesi) {
        if (tesi != null && tesi.getStatoApprovazione().equals("Bozza")) {
            tesi.setStatoApprovazione("Revisione");
            return true;
        }
        return false;
    }
    
    /**
     * Approva una tesi dopo la revisione.
     * 
     * @param tesi la tesi da approvare
     * @param docente il docente relatore che approva
     * @return true se l'approvazione ha successo, false altrimenti
     */
    public boolean approvaTesi(Tesi tesi, Docente docente) {
        if (tesi != null && docente != null && tesi.getRelatore().equals(docente)) {
            tesi.setStatoApprovazione("Approvata");
            return true;
        }
        return false;
    }
}
