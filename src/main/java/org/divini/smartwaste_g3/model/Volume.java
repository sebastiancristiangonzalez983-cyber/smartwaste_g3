package org.divini.smartwaste_g3.model;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Volume extends Cassonetto {

    protected double volume;

    public Volume(int codice, double latitudine, double longitudine, LocalDate dataInstallazione, LocalTime oraInstallazione, LocalDate dataSvuotamento, LocalTime oraSvuotamento, double capacita) {
        super(codice, latitudine, longitudine, dataInstallazione, oraInstallazione, dataSvuotamento, oraSvuotamento, capacita);
    }

    @Override
    public void aggiorna(double volume) {
        this.volume = volume;
    }

    @Override
    public double getPercentuale() {
        return (volume / getCapacita()) * 100.0;
    }

    @Override
    public String toString() {
        return super.toString() + "\nVolume attuale: " + volume;
    }
}
