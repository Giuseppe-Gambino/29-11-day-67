package it.epicode.catalogo.astratta;

import java.time.LocalDate;

 public abstract class AbstracContent {

    private int ISBN;
    private String titolo;
    private LocalDate annoPublicazione;
    private int pages;


     public AbstracContent(int ISBN, String titolo, LocalDate annoPublicazione, int pages) {
         this.ISBN = ISBN;
         this.titolo = titolo;
         this.annoPublicazione = annoPublicazione;
         this.pages = pages;
     }

     public void setTitolo(String titolo) {
         this.titolo = titolo;
     }

     public void setAnnoPublicazione(LocalDate annoPublicazione) {
         this.annoPublicazione = annoPublicazione;
     }

     public void setPages(int pages) {
         this.pages = pages;
     }

     public int getISBN() {
         return ISBN;
     }

     public String getTitolo() {
         return titolo;
     }

     public LocalDate getAnnoPublicazione() {
         return annoPublicazione;
     }

     public int getPages() {
         return pages;
     }

     public void setISBN(int ISBN) {
         this.ISBN = ISBN;
     }

     public String getAutore() {
         return null;
     }

     @Override
     public String toString() {
         return "AbstracContent{" +
                 "ISBN=" + ISBN +
                 ", titolo='" + titolo + '\'' +
                 ", annoPublicazione=" + annoPublicazione +
                 ", pages=" + pages +
                 '}';
     }
 }
