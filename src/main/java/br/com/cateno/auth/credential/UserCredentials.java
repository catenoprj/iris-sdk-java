package br.com.cateno.auth.credential;

import lombok.Value;

@Value
public class UserCredentials {

  private final String username;
  private final String password;

  public UserCredentials(final String username, final String password) {
    this.username = username;
    this.password = password;
  }
}
