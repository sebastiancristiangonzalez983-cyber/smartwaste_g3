package org.divini.smartwaste_g3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ElencoCassonetti {
    private final List<Cassonetto> cassonetti = new ArrayList();

    public ElencoCassonetti() {
    }

    public void aggiungi(Cassonetto c) {
        this.cassonetti.add(c);
    }

    public <T extends Cassonetto> List<T> estraiTipo(Class<T> tipo) {
        return cassonetti.stream()
                .filter(tipo::isInstance)
                .map(tipo::cast)
                .filter(c -> c.getPercentualeRiempimento() > 90.0)
                .collect(Collectors.toList());
    }
}