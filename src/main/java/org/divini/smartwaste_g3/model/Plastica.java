package org.divini.smartwaste_g3.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Plastica extends CassonettoVolume {
    public Plastica(int codice, double latitudine, double longitudine, LocalDate dataInstallazione, LocalTime oraInstallazione, double capacita) {
        super(codice, latitudine, longitudine, dataInstallazione, oraInstallazione, capacita);
    }

    public TipologiaRifiuto getTipologia() {
        return TipologiaRifiuto.Plastica;
    }
}
