package org.divini.smartwaste_g3.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Vetro extends Cassonetto {

    private int bottiglie;

    public Vetro(int codice, double latitudine, double longitudine, LocalDate dataInstallazione, LocalTime oraInstallazione, LocalDate dataSvuotamento, LocalTime oraSvuotamento, double capacita) {
        super(codice, latitudine, longitudine, dataInstallazione, oraInstallazione, dataSvuotamento, oraSvuotamento, capacita);
    }

    @Override
    public void aggiorna(double bottiglie) {
        this.bottiglie = (int) bottiglie;
    }

    @Override
    public double getPercentuale() {
        return (bottiglie / getCapacita()) * 100.0;
    }

    @Override
    public String toString() {
        return super.toString() + "\nNumero bottiglie: " + bottiglie;
    }

}
