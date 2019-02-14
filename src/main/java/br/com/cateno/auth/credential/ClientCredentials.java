package br.com.cateno.auth.credential;

import lombok.NonNull;
import lombok.Value;

@Value
public class ClientCredentials {

  private final String id;
  private final String secret;

  public ClientCredentials(final @NonNull String id, final @NonNull String secret) {
    this.id = id;
    this.secret = secret;
  }
}
