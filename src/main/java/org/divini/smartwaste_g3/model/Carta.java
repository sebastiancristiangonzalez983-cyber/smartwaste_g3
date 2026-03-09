package org.divini.smartwaste_g3.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Carta extends Volume {

    public Carta(int codice, double latitudine, double longitudine, LocalDate dataInstallazione, LocalTime oraInstallazione, LocalDate dataSvuotamento, LocalTime oraSvuotamento, double capacita) {
        super(codice, latitudine, longitudine, dataInstallazione, oraInstallazione, dataSvuotamento, oraSvuotamento, capacita);
    }
}
