package org.divini.smartwaste_g3.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Organico extends Cassonetto {
    private double peso = 0.0;

    public Organico(int codice, double latitudine, double longitudine, LocalDate dataInstallazione, LocalTime oraInstallazione, double capacita) {
        super(codice, latitudine, longitudine, dataInstallazione, oraInstallazione, capacita);
    }

    public double getPercentualeRiempimento() {
        return this.peso / this.capacita * 100.0;
    }

    public TipologiaRifiuto getTipologia() {
        return TipologiaRifiuto.Organico;
    }

    public void aggiorna(double valore) {
        if (valore < 0.0) {
            valore = 0.0;
        }

        if (valore > this.capacita) {
            valore = this.capacita;
        }

        this.peso = valore;
    }
}
