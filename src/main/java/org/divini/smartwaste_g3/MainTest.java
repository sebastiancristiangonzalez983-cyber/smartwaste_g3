package org.divini.smartwaste_g3;

import org.divini.smartwaste_g3.model.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class MainTest {

    public static void main(String[] args) {

        ElencoCassonetti elenco = new ElencoCassonetti();

        Organico org = new Organico(1, 43.23, 13.12, LocalDate.now(), LocalTime.now(), LocalDate.now(), LocalTime.now(), 50);
        org.aggiorna(48);

        Vetro vet = new Vetro(2, 43.24, 13.11, LocalDate.now(), LocalTime.now(), LocalDate.now(), LocalTime.now(), 100);
        vet.aggiorna(95);

        Carta car = new Carta(3, 43.25, 13.10, LocalDate.now(), LocalTime.now(), LocalDate.now(), LocalTime.now(), 200);
        car.aggiorna(190);

        Plastica pla = new Plastica(4, 43.26, 13.09, LocalDate.now(), LocalTime.now(), LocalDate.now(), LocalTime.now(), 50);
        pla.aggiorna(48);

        Indifferenziata ind = new Indifferenziata(5, 43.27, 13.08, LocalDate.now(), LocalTime.now(), LocalDate.now(), LocalTime.now(), 50);
        ind.aggiorna(48);

        elenco.aggiungi(org);
        elenco.aggiungi(vet);
        elenco.aggiungi(car);
        elenco.aggiungi(pla);
        elenco.aggiungi(ind);

        System.out.println("Organico > 90%");
        elenco.estraiTipo(Organico.class).forEach(System.out::println);

        System.out.println("\nVetro > 90%");
        elenco.estraiTipo(Vetro.class).forEach(System.out::println);

        System.out.println("\nCarta > 90%");
        elenco.estraiTipo(Carta.class).forEach(System.out::println);

        System.out.println("\nPlastica > 90%");
        elenco.estraiTipo(Plastica.class).forEach(System.out::println);

        System.out.println("\nIndifferenziata > 90%");
        elenco.estraiTipo(Indifferenziata.class).forEach(System.out::println);

        /*System.out.println(org);*/

    }
}

