package it.epicode.catalogo.eccezioni;

public class ISBNAlreadyExisting extends RuntimeException {
  public ISBNAlreadyExisting(String message) {
    super(message);
  }
}
