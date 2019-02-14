package br.com.cateno;

public class CredentialsNotFoundException extends RuntimeException {

  public CredentialsNotFoundException() {
    super("The credentials where not provided");
  }
}
