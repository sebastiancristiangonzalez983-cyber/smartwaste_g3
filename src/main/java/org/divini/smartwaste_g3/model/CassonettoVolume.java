package org.divini.smartwaste_g3.model;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class CassonettoVolume extends Cassonetto {
    protected double volume = 0.0;

    public CassonettoVolume(String codice, double latitudine, double longitudine, LocalDate dataInstallazione, LocalTime oraInstallazione, double capacita) {
        super(codice, latitudine, longitudine, dataInstallazione, oraInstallazione, capacita);
    }

    public double getPercentualeRiempimento() {
        return this.volume / this.capacita * 100.0;
    }

    public void aggiorna(double valore) {
        if (valore < 0.0) {
            valore = 0.0;
        }

        if (valore > this.capacita) {
            valore = this.capacita;
        }

        this.volume = valore;
    }
}