package br.com.cateno.auth.credential;

import lombok.NonNull;
import lombok.Value;

@Value
public class UserCredentials {

  private final String username;
  private final String password;

  public UserCredentials(final @NonNull String username, final @NonNull String password) {
    this.username = username;
    this.password = password;
  }
}
