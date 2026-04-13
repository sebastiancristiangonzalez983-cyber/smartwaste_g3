package org.divini.smartwaste_g3.service;

import org.divini.smartwaste_g3.model.Cassonetto;
import org.divini.smartwaste_g3.model.TipologiaRifiuto;
import java.util.List;

/**
 * Interfaccia per la gestione dei cassonetti intelligenti.
 * Definisce le operazioni CRUD e le richieste specifiche di dominio.
 */
public interface GestoreCassonetti {

    /**
     * Aggiunge un nuovo cassonetto al sistema.
     * @param cassonetto il cassonetto da aggiungere
     */
    void aggiungi(Cassonetto cassonetto);

    /**
     * Elimina un cassonetto dal sistema, dato il suo codice.
     * @param codice il codice univoco del cassonetto
     * @return true se eliminato, false se non trovato
     */
    boolean elimina(String codice);

    /**
     * Cerca un cassonetto per codice.
     * @param codice il codice da cercare
     * @return il cassonetto trovato, oppure null
     */
    Cassonetto cercaPerCodice(String codice);

    boolean elimina(int codice);

    Cassonetto cercaPerCodice(int codice);

    /**
     * Restituisce tutti i cassonetti.
     * @return lista di tutti i cassonetti
     */
    List<Cassonetto> getTutti();

    /**
     * Restituisce i cassonetti di una specifica tipologia.
     * @param tipo la tipologia di rifiuto
     * @return lista di cassonetti filtrata per tipologia
     */
    List<Cassonetto> getPerTipologia(TipologiaRifiuto tipo);

    List<Cassonetto> getPerTipologia(String tipo);

    /**
     * Restituisce i cassonetti che richiedono svuotamento (riempimento > 90%).
     * @return lista di cassonetti da svuotare
     */
    List<Cassonetto> getCassonettiDaSvuotare();

    /**
     * Conta il numero totale di cassonetti.
     * @return numero di cassonetti nel sistema
     */
    int contaCassonetti();
}
