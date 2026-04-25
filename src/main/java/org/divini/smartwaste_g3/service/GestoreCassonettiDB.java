package org.divini.smartwaste_g3.service;

import org.divini.smartwaste_g3.database.CassonettoDAO;
import org.divini.smartwaste_g3.database.ConnessioneDatabase;
import org.divini.smartwaste_g3.model.Cassonetto;
import org.divini.smartwaste_g3.model.TipologiaRifiuto;

import java.util.List;

public class GestoreCassonettiDB implements GestoreCassonetti {

    private CassonettoDAO dao;

    public GestoreCassonettiDB(ConnessioneDatabase conn) {
        this.dao = new CassonettoDAO(conn);
    }

    @Override
    public void aggiungi(Cassonetto cassonetto) {
        dao.inserisci(cassonetto);
    }

    @Override
    public boolean elimina(int codice) {
        return dao.elimina(codice);
    }

    @Override
    public Cassonetto cercaPerCodice(int codice) {
        return dao.cerca(codice);
    }

    @Override
    public List<Cassonetto> getTutti() {
        return dao.getTutti();
    }

    @Override
    public List<Cassonetto> getPerTipologia(TipologiaRifiuto tipo) {
        return dao.getPerTipologia(tipo);
    }

    @Override
    public List<Cassonetto> getCassonettiDaSvuotare() {
        return dao.getCassonettiDaSvuotare();
    }

    @Override
    public int contaCassonetti() {
        return dao.getTutti().size();
    }
}
