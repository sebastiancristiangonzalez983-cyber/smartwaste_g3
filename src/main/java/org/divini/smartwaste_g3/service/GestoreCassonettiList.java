package org.divini.smartwaste_g3.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.divini.smartwaste_g3.model.Cassonetto;
import org.divini.smartwaste_g3.model.TipologiaRifiuto;

public class GestoreCassonettiList implements GestoreCassonetti {

    private List<Cassonetto> cassonetti = new ArrayList<>();

    @Override
    public void aggiungi(Cassonetto cassonetto) {
        cassonetti.add(cassonetto);
    }


    @Override
    public Cassonetto cercaPerCodice(int codice) {
        return cassonetti.stream()
                .filter(c -> c.getCodice() == codice)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean elimina(int codice) {
        return cassonetti.removeIf(c -> c.getCodice() == codice);
    }

    @Override
    public List<Cassonetto> getTutti() {
        return new ArrayList<>(cassonetti);
    }


    @Override
    public List<Cassonetto> getPerTipologia(TipologiaRifiuto  tipo) {
        return cassonetti.stream()
                .filter(c -> c.getTipologia() == tipo)
                .collect(Collectors.toList());
    }

    @Override
    public List<Cassonetto> getCassonettiDaSvuotare() {
        return cassonetti.stream()
                .filter(c -> c.getPercentualeRiempimento() > 90)
                .collect(Collectors.toList());
    }

    @Override
    public int contaCassonetti() {
        return cassonetti.size();
    }
}
