package org.divini.smartwaste_g3.model;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Cassonetto {
    protected int codice;
    protected double latitudine;
    protected double longitudine;
    protected LocalDate dataInstallazione;
    protected LocalTime oraInstallazione;
    protected LocalDate dataSvuotamento;
    protected LocalTime oraSvuotamento;
    protected double capacita;

    public Cassonetto(int codice, double latitudine, double longitudine, LocalDate dataInstallazione, LocalTime oraInstallazione, double capacita) {
        this.codice = codice;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
        this.dataInstallazione = dataInstallazione;
        this.oraInstallazione = oraInstallazione;
        this.dataSvuotamento = null;
        this.oraSvuotamento = null;
        this.capacita = capacita;
    }

    public int getCodice() {
        return this.codice;
    }

    public double getLatitudine() {
        return this.latitudine;
    }

    public double getLongitudine() {
        return this.longitudine;
    }

    public double getCapacita() {
        return this.capacita;
    }

    public void svuota() {
        this.dataSvuotamento = LocalDate.now();
        this.oraSvuotamento = LocalTime.now();
    }

    public abstract double getPercentualeRiempimento();

    public abstract TipologiaRifiuto getTipologia();

    public abstract void aggiorna(double var1);

    /* */@Override
    public String toString() {
        return getClass().getSimpleName() + " [" + codice + "] - Riempimento: "
                + String.format("%.2f", getPercentualeRiempimento()) + "%";
    }
}
