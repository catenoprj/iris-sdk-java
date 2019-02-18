package br.com.cateno.sdk.core;

public class CredentialsNotFoundException extends RuntimeException {

  CredentialsNotFoundException() {
    super("The credentials where not provided");
  }
}
