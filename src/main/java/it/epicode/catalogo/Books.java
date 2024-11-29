package it.epicode.catalogo;

import it.epicode.catalogo.astratta.AbstracContent;
import it.epicode.catalogo.eccezioni.ISBNAlreadyExisting;

import java.time.LocalDate;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;




public class Books extends AbstracContent {

    private static final Logger LOGGER = LoggerFactory.getLogger(Books.class);

    private String autore;
    private String genere;


    public Books(int ISBN, String titolo, LocalDate annoPublicazione, int pages, String autore, String genere) {
        super(ISBN, titolo, annoPublicazione, pages);
        this.autore = autore;
        this.genere = genere;

        LOGGER.info("Verifica in corso della presenza del libro " + titolo);
        if (Archivio.controlloEsistenza(ISBN)) {
            throw new ISBNAlreadyExisting("Il libro/Magazine con ISBN " + ISBN + " esiste già nel catalogo.");
        } else {
            Catalogo.aggiungiElemento(this);
            LOGGER.info("Libro " + titolo + " con ISBN " + ISBN + " Aggiunto con successo!");
        }

    }

    public void stampBook() {
        System.out.println(this);
    }

    @Override
    public String getAutore() {
        return autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Books{" +
                "ISBN=" + getISBN() +  // Assicurati di avere un metodo getter per ISBN
                ", titolo='" + getTitolo() + '\'' +  // Assicurati di avere un metodo getter per titolo
                ", annoPubblicazione=" + getAnnoPublicazione() +  // Assicurati di avere un metodo getter per anno di pubblicazione
                ", pages=" + getPages() +  // Assicurati di avere un metodo getter per il numero di pagine
                ", autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }


}
