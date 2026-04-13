package org.divini.smartwaste_g3.model;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Cassonetto {
    protected String codice;
    protected double latitudine;
    protected double longitudine;
    protected LocalDate dataInstallazione;
    protected LocalTime oraInstallazione;
    protected LocalDate dataSvuotamento;
    protected LocalTime oraSvuotamento;
    protected double capacita;

    public Cassonetto(String codice, double latitudine, double longitudine, LocalDate dataInstallazione, LocalTime oraInstallazione, double capacita) {
        this.codice = codice;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
        this.dataInstallazione = dataInstallazione;
        this.oraInstallazione = oraInstallazione;
        this.dataSvuotamento = null;
        this.oraSvuotamento = null;
        this.capacita = capacita;
    }

    public String getCodice() {
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

   /*
    @Override
   public String toString() {
        String var10000 = this.getClass().getSimpleName();
        return var10000 + "\nCodice: " + this.codice + "\nLatitudine: " + this.latitudine + "\nLongitudine: " + this.longitudine + "\nData installazione: " + this.dataInstallazione + "\nOra installazione: " + this.oraInstallazione + "\nData ultimo svuotamento: " + this.dataSvuotamento + "\nOra ultimo svuotamento: " + this.oraSvuotamento + "\nCapacità massima: " + this.capacita + "\nPercentuale riempimento: " + String.format("%.2f", this.getPercentualeRiempimento()) + "%\n";
    }
    */
}
