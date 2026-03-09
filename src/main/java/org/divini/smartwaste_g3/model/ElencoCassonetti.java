package org.divini.smartwaste_g3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ElencoCassonetti {

    private final List<Cassonetto> cassonetti = new ArrayList<>();

    public void aggiungi(Cassonetto c) {
        cassonetti.add(c);
    }

    public <T extends Cassonetto> List<T> estraiTipo(Class<T> tipo) {
        return cassonetti.stream()
                .filter(tipo::isInstance)              // solo cassonetti del tipo richiesto
                .map(tipo::cast)                       // converto al tipo corretto
                .filter(c -> c.getPercentuale() > 90)  // solo quelli oltre il 90%
                .collect(Collectors.toList());         // restituisco la lista
    }
}