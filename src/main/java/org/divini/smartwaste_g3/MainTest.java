package org.divini.smartwaste_g3;

import java.io.PrintStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

import org.divini.smartwaste_g3.database.CassonettoDAO;
import org.divini.smartwaste_g3.database.ConnessioneDatabase;
import org.divini.smartwaste_g3.model.Carta;
import org.divini.smartwaste_g3.model.ElencoCassonetti;
import org.divini.smartwaste_g3.model.Indifferenziata;
import org.divini.smartwaste_g3.model.Organico;
import org.divini.smartwaste_g3.model.Plastica;
import org.divini.smartwaste_g3.model.Vetro;
import org.divini.smartwaste_g3.service.GestoreCassonetti;
import org.divini.smartwaste_g3.service.GestoreCassonettiList;

public class MainTest {
    public static void main(String[] args) {
        ElencoCassonetti elenco = new ElencoCassonetti();
        Organico org = new Organico("1", 43.23, 13.12, LocalDate.now(), LocalTime.now(), 50.0);
        org.aggiorna(48.0);

        GestoreCassonetti gestore = new GestoreCassonettiList();

        gestore.aggiungi(org);

        System.out.println("Cassonetti da svuotare:");
        gestore.getCassonettiDaSvuotare().forEach(System.out::println);
    }
}

