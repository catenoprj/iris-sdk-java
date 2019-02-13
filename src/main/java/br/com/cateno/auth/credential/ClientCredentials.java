package br.com.cateno.auth.credential;

import lombok.Value;

import static org.glassfish.jersey.internal.guava.Preconditions.checkNotNull;

@Value
public class ClientCredentials {

  private final String id;
  private final String secret;

  public ClientCredentials(final String id, final String secret) {
    checkNotNull(id);
    checkNotNull(secret);

    this.id = id;
    this.secret = secret;
  }
}
