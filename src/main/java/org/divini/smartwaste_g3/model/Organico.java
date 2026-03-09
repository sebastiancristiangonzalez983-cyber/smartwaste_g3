package org.divini.smartwaste_g3.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Organico extends Cassonetto {

    private double peso;

    public Organico(int codice, double latitudine, double longitudine, LocalDate dataInstallazione, LocalTime oraInstallazione, LocalDate dataSvuotamento, LocalTime oraSvuotamento, double capacita) {
        super(codice, latitudine, longitudine, dataInstallazione, oraInstallazione, dataSvuotamento, oraSvuotamento, capacita);
    }

    @Override
    public void aggiorna(double peso) {
        this.peso = peso;
    }

    @Override
    public double getPercentuale() {
        return (peso / getCapacita()) * 100.0;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Peso attuale: " + peso;
    }

}
