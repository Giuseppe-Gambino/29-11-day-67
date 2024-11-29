package it.epicode;

import it.epicode.catalogo.*;
import it.epicode.catalogo.Enum.Periodicita;
import it.epicode.catalogo.eccezioni.ISBNAlreadyExisting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Scanner;

import static it.epicode.catalogo.Catalogo.stampaStatistiche;

public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Books.class);

    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {


        boolean continua = true;

        while (continua) {
            Archivio.stampaMenu();
            System.out.println("inserisci input: ");
            int scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    aggiungiLibro();
                    break;
                case 2:
                    aggiungiRivista();
                    break;
                case 3:
                    Catalogo.stampaCatalogo();
                    break;
                case 4:
                    filtraPerAutore();
                    break;
                case 5:
                    filtraPerData();
                    break;
                case 6:
                    cercaPerIsbn();
                    break;
                case 7:
                    modificaTitolo();
                    break;
                case 8:
                    Catalogo.stampaStatistiche();
                    break;
                case 0:
                    continua = false;
                    System.out.println("Uscita dal programma. Arrivederci!");
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }






    }

    private static void cercaPerIsbn() {
        System.out.println("Inserisci ISBN: ");
        int isbn = scanner.nextInt();

        Archivio.getContentByISBN(isbn);

    }

    private static void filtraPerData() {

        System.out.println("Inserisci anno di pubblicazione: ");
        int anno = scanner.nextInt();

        System.out.println("Inserisci mese di pubblicazione: ");
        int mese = scanner.nextInt();

        System.out.println("Inserisci giorno di pubblicazione: ");
        int giorno = scanner.nextInt();

        LocalDate annoPubblicazione = LocalDate.of(anno, mese, giorno);

        System.out.println(Archivio.filterContentByDate(annoPubblicazione));
    }

    private static void modificaTitolo() {

        System.out.println("Inserisci ISBN: ");
        int isbn = scanner.nextInt();

        System.out.println("inserisci nuovo titolo: ");
        String titolo = scanner.next();

        Archivio.modificaTitolo(isbn, titolo);
    }

    private static void filtraPerAutore() {
        System.out.println("inserisci Autore da cercare: ");
        String autore = scanner.next();
        System.out.println(Archivio.filterContentByAutore(autore));
    }


    private static void aggiungiRivista() {


            System.out.println("\n--- Aggiungi Rivista ---");

            System.out.println("Inserisci ISBN: ");
            int isbn = scanner.nextInt();

            System.out.println("Inserisci titolo: ");
            String titolo = scanner.next();

            System.out.println("Inserisci anno di pubblicazione: ");
            int anno = scanner.nextInt();

            System.out.println("Inserisci mese di pubblicazione: ");
            int mese = scanner.nextInt();

            System.out.println("Inserisci giorno di pubblicazione: ");
            int giorno = scanner.nextInt();

            LocalDate annoPubblicazione = LocalDate.of(anno, mese, giorno);

            System.out.println("Inserisci numero di pagine: ");
            int pages = scanner.nextInt();

            System.out.println("Inserisci periodicità (Es. Settimanale, Mensile, Annuale): ");
            String periodicita = scanner.next();

            // Creazione dell'oggetto Magazine: il costruttore si occuperà di aggiungerlo al catalogo
            Magazine nuovaRivista = new Magazine(isbn, titolo, annoPubblicazione, pages, periodicita);

            System.out.println("Rivista aggiunta con successo!");

    }


    private static void aggiungiLibro() {
       
            System.out.println("\n--- Aggiungi Libro ---");

            System.out.println("Inserisci ISBN: ");
            int isbn = scanner.nextInt();

            System.out.println("Inserisci titolo: ");
            String titolo = scanner.next();

            System.out.println("Inserisci anno di pubblicazione: ");
            int anno = scanner.nextInt();

            System.out.println("Inserisci mese di pubblicazione: ");
            int mese = scanner.nextInt();

            System.out.println("Inserisci giorno di pubblicazione: ");
            int giorno = scanner.nextInt();


            LocalDate annoPubblicazione = LocalDate.of(anno, mese, giorno);

            System.out.println("Inserisci numero di pagine: ");
            int pages = scanner.nextInt();

            System.out.println("Inserisci autore: ");
            String autore = scanner.next();

            System.out.println("Inserisci genere: ");
            String genere = scanner.next();

            // Creazione dell'oggetto Book: il costruttore si occuperà di aggiungerlo al catalogo
            Books nuovoLibro = new Books(isbn, titolo, annoPubblicazione, pages, autore, genere);

            System.out.println("Libro aggiunto con successo!");

        
    }

}
