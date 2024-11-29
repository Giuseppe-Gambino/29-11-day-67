package it.epicode.catalogo;

import it.epicode.catalogo.astratta.AbstracContent;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Archivio {

    private static List<AbstracContent> totProdotti = Catalogo.getTotProdotti();

    public static boolean controlloEsistenza(int ISBN) {

        Optional<AbstracContent> prodotto = totProdotti.stream()
                .filter(item -> item.getISBN() == ISBN)
                .findAny();


        return prodotto.isPresent();
    }

    public static void getContentByISBN(int ISBN) {
        boolean found = false;

        for (AbstracContent content : totProdotti) {
            if (content.getISBN() == ISBN) {
                System.out.println("Ecco quello che cercavi: " + content);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Contenuto non trovato");
        }
    }

    public static void removeContentByISBN(int ISBN) {
        boolean found = false;

        for (AbstracContent content : totProdotti) {
            if (content.getISBN() == ISBN) {
                System.out.println("Elemento che hai eliminato dal catagolo: " + content);
                Catalogo.removeElemento(content);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Contenuto non trovato");
        }
    }

    public static List<AbstracContent> filterContentByDate(LocalDate startDate) {
        return totProdotti.stream().filter(prod -> prod.getAnnoPublicazione().equals(startDate) )
                .collect(Collectors.toList());
    }


    public static List<AbstracContent> filterContentByAutore(String autore) {
        return totProdotti.stream()
                .filter(prod -> prod instanceof Books && ((Books) prod).getAutore().equals(autore))
                .collect(Collectors.toList());
    }

    public static boolean modificaTitolo( int isbn, String titolo) {
        for (AbstracContent elemento : totProdotti) {
            if (elemento.getISBN() == isbn) {
                elemento.setTitolo(titolo);
                return true;
            }
        }
        return false;
    }


    public static void stampaMenu() {
        System.out.println("\n--- Menu Catalogo ---");
        System.out.println("1. Aggiungi un libro");
        System.out.println("2. Aggiungi una rivista");
        System.out.println("3. Visualizza catalogo");
        System.out.println("4. Filtra elementi per autore");
        System.out.println("5. Filtra elementi per data");
        System.out.println("6. Cerca elemento per (ISBN)");
        System.out.println("7. Modifica il titolo dell' elemento (ISBN)");
        System.out.println("8. Visualizza statistiche");
        System.out.println("0. Esci");
    }


}
