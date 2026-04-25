package org.divini.smartwaste_g3;

import org.divini.smartwaste_g3.database.ConnessioneDatabase;
import org.divini.smartwaste_g3.model.*;
import org.divini.smartwaste_g3.service.GestoreCassonetti;
import org.divini.smartwaste_g3.service.GestoreCassonettiDB;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class MainTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GestoreCassonetti gestore = new GestoreCassonettiDB(new ConnessioneDatabase());

        int scelta;

        do {
            System.out.println("\n=== MENU SMARTWASTE ===");
            System.out.println("1) Inserisci cassonetto ORGANICO");
            System.out.println("2) Inserisci cassonetto VETRO");
            System.out.println("3) Inserisci cassonetto CARTA");
            System.out.println("4) Inserisci cassonetto PLASTICA");
            System.out.println("5) Inserisci cassonetto INDIFFERENZIATA");
            System.out.println("6) Mostra tutti i cassonetti");
            System.out.println("7) Cassonetti da svuotare (>90%)");
            System.out.println("0) Esci");
            System.out.print("Scelta: ");

            scelta = Integer.parseInt(scanner.nextLine());

            switch (scelta) {

                case 1 -> inserisci(scanner, gestore, TipologiaRifiuto.Organico);
                case 2 -> inserisci(scanner, gestore, TipologiaRifiuto.Vetro);
                case 3 -> inserisci(scanner, gestore, TipologiaRifiuto.Carta);
                case 4 -> inserisci(scanner, gestore, TipologiaRifiuto.Plastica);
                case 5 -> inserisci(scanner, gestore, TipologiaRifiuto.Indifferenziata);

                case 6 -> gestore.getTutti().forEach(System.out::println);

                case 7 -> gestore.getCassonettiDaSvuotare().forEach(System.out::println);

                case 0 -> System.out.println("Uscita...");
                default -> System.out.println("Scelta non valida.");
            }

        } while (scelta != 0);

        scanner.close();
    }

    private static void inserisci(Scanner scanner, GestoreCassonetti gestore, TipologiaRifiuto tipo) {

        System.out.println("\n=== Inserimento " + tipo + " ===");

        System.out.print("Codice: ");
        int codice = Integer.parseInt(scanner.nextLine());

        System.out.print("Latitudine: ");
        double lat = Double.parseDouble(scanner.nextLine());

        System.out.print("Longitudine: ");
        double lon = Double.parseDouble(scanner.nextLine());

        System.out.print("Capacità massima: ");
        double capacita = Double.parseDouble(scanner.nextLine());

        System.out.print("Valore attuale (peso/volume/bottiglie): ");
        double valore = Double.parseDouble(scanner.nextLine());

        Cassonetto c = switch (tipo) {
            case Organico -> new Organico(codice, lat, lon, LocalDate.now(), LocalTime.now(), capacita);
            case Vetro -> new Vetro(codice, lat, lon, LocalDate.now(), LocalTime.now(), (int) capacita);
            case Carta -> new Carta(codice, lat, lon, LocalDate.now(), LocalTime.now(), capacita);
            case Plastica -> new Plastica(codice, lat, lon, LocalDate.now(), LocalTime.now(), capacita);
            case Indifferenziata -> new Indifferenziata(codice, lat, lon, LocalDate.now(), LocalTime.now(), capacita);
        };

        c.aggiorna(valore);

        gestore.aggiungi(c);

        System.out.println("✔ Cassonetto inserito!");
    }
}
