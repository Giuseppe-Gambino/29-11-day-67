package it.epicode.catalogo;

import it.epicode.catalogo.astratta.AbstracContent;
import it.epicode.catalogo.eccezioni.ISBNAlreadyExisting;

import java.time.LocalDate;


public class Magazine extends AbstracContent {

    private String Periodicita;



    public Magazine(int ISBN, String titolo, LocalDate annoPublicazione, int pages, String periodicita) {
        super(ISBN, titolo, annoPublicazione, pages);
        Periodicita = periodicita;


        if (Archivio.controlloEsistenza(ISBN)) {
            throw new ISBNAlreadyExisting("Il libro/Magazine con ISBN " + ISBN + " esiste già nel catalogo.");
        } else {
            Catalogo.aggiungiElemento(this);
        }
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "ISBN=" + getISBN() +
                ", titolo='" + getTitolo() + '\'' +
                ", annoPubblicazione=" + getAnnoPublicazione() +
                ", pages=" + getPages() +
                ", periodicita=" + Periodicita +
                '}';
    }

}
