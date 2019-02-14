package br.com.cateno.auth.credential;

import lombok.Value;

@Value
public class ClientCredentials {

  private final String id;
  private final String secret;

  public ClientCredentials(final String id, final String secret) {
    this.id = id;
    this.secret = secret;
  }
}
