package br.com.cateno.client;

import lombok.Data;

@Data
public class ClientCredentials {

  private final String id;
  private final String secret;

  public ClientCredentials(final String id, final String secret) {
    this.id = id;
    this.secret = secret;
  }
}
