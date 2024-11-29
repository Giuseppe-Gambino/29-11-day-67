package it.epicode.catalogo;

import it.epicode.catalogo.astratta.AbstracContent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Catalogo {
    private static List<AbstracContent> totProdotti = new ArrayList<>();


    public static void aggiungiElemento(AbstracContent elemento) {
        totProdotti.add(elemento);
    }

    public static void removeElemento(AbstracContent elemento) {
        totProdotti.remove(elemento);
    }



    public static List<AbstracContent> getTotProdotti() {
        return totProdotti;
    }

    public static void stampaCatalogo() {
        System.out.println("Ecco il nostro Catalogo di Contenuti:");
        for (AbstracContent elemento : totProdotti) {
            System.out.println(elemento);
        }
    }

    public static void stampaStatistiche() {
        // Contare il numero di libri e riviste
        long numeroLibri = totProdotti.stream()
                .filter(elemento -> elemento instanceof Books)
                .count();

        long numeroRiviste = totProdotti.stream()
                .filter(elemento -> elemento instanceof Magazine)
                .count();

        // Trovare l'elemento con il massimo numero di pagine
        Optional<AbstracContent> elementoConMaxPagine = totProdotti.stream()
                .max(Comparator.comparing(AbstracContent::getPages));

        // Calcolare la media del numero di pagine
        double mediaPagine = totProdotti.stream()
                .mapToInt(AbstracContent::getPages)
                .average()
                .orElse(0.0);

        // Stampare i risultati
        System.out.println("Statistiche del catalogo:");
        System.out.println("Numero totale di libri: " + numeroLibri);
        System.out.println("Numero totale di riviste: " + numeroRiviste);
        elementoConMaxPagine.ifPresentOrElse(
                elemento -> System.out.println("Elemento con il massimo numero di pagine: " + elemento.getTitolo() + " (" + elemento.getPages() + " pagine)"),
                () -> System.out.println("Nessun elemento nel catalogo.")
        );
        System.out.println("Media del numero di pagine: " + mediaPagine);
    }



}
