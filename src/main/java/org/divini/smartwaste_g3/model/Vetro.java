package org.divini.smartwaste_g3.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Vetro extends Cassonetto {
    private int bottiglie = 0;

    public Vetro(int codice, double latitudine, double longitudine, LocalDate dataInstallazione, LocalTime oraInstallazione, int capacitaMassimaBottiglie) {
        super(codice, latitudine, longitudine, dataInstallazione, oraInstallazione, (double)capacitaMassimaBottiglie);
    }

    public double getPercentualeRiempimento() {
        return (double)this.bottiglie / this.capacita * 100.0;
    }

    public TipologiaRifiuto getTipologia() {
        return TipologiaRifiuto.Vetro;
    }

    public void aggiorna(double valore) {
        if (valore < 0.0) {
            valore = 0.0;
        }

        if (valore > this.capacita) {
            valore = this.capacita;
        }

        this.bottiglie = (int)valore;
    }
}
