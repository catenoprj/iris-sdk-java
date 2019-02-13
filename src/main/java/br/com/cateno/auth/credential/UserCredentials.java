package br.com.cateno.auth.credential;

import lombok.Value;

import static org.glassfish.jersey.internal.guava.Preconditions.checkNotNull;

@Value
public class UserCredentials {

  private final String username;
  private final String password;

  public UserCredentials(final String username, final String password) {
    checkNotNull(username);
    checkNotNull(password);

    this.username = username;
    this.password = password;
  }
}
