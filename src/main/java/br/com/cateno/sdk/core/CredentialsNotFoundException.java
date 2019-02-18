package br.com.cateno.sdk.core;

public class CredentialsNotFoundException extends RuntimeException {

  public CredentialsNotFoundException() {
    super("The credentials where not provided");
  }
}
