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

    public Cassonetto(int codice, double latitudine, double longitudine, LocalDate dataInstallazione, LocalTime oraInstallazione, LocalDate dataSvuotamento, LocalTime oraSvuotamento, double capacita) {

        this.codice = codice;
        this.latitudine = latitudine;
        this.longitudine = longitudine;

        this.dataInstallazione = dataInstallazione;
        this.oraInstallazione = oraInstallazione;

        this.dataSvuotamento = dataSvuotamento;
        this.oraSvuotamento = oraSvuotamento;

        this.capacita = capacita;
    }

    public int getCodice() { return codice; }
    public double getLatitudine() { return latitudine; }
    public double getLongitudine() { return longitudine; }
    public double getCapacita() { return capacita; }

    public void svuota() {
        this.dataSvuotamento = LocalDate.now();
        this.oraSvuotamento = LocalTime.now();
    }

    public abstract double getPercentuale();
    public abstract void aggiorna(double valore);

    /* */@Override
    public String toString() {
        return getClass().getSimpleName() + " [" + codice + "] - Riempimento: "
                + String.format("%.2f", getPercentuale()) + "%";
    }

   /*
    @Override
    public String toString() {
        return  getClass().getSimpleName() + "\n" +
                "Codice: " + codice + "\n" +
                "Latitudine: " + latitudine + "\n" +
                "Longitudine: " + longitudine + "\n" +
                "Data installazione: " + dataInstallazione + "\n" +
                "Ora installazione: " + oraInstallazione + "\n" +
                "Data ultimo svuotamento: " + dataSvuotamento + "\n" +
                "Ora ultimo svuotamento: " + oraSvuotamento + "\n" +
                "Capacità massima: " + capacita + "\n" +
                "Percentuale riempimento: " + String.format("%.2f", getPercentuale()) + "%";
    }
    */
}
