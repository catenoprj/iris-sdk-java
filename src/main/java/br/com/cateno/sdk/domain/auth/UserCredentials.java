package br.com.cateno.sdk.domain.auth;

import static org.glassfish.jersey.internal.guava.Preconditions.checkNotNull;

public class UserCredentials {

  private final String username;
  private final String password;

  public UserCredentials(final String username, final String password) {
    checkNotNull(username);
    checkNotNull(password);

    this.username = username;
    this.password = password;
  }

  public boolean equals(final Object o) {
    if (o == this) return true;
    if (!(o instanceof UserCredentials)) return false;
    final UserCredentials other = (UserCredentials) o;
    final Object this$username = this.getUsername();
    final Object other$username = other.getUsername();
    if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
    final Object this$password = this.getPassword();
    final Object other$password = other.getPassword();
    if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
    return true;
  }

  public String getPassword() {
    return this.password;
  }

  public String getUsername() {
    return this.username;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $username = this.getUsername();
    result = result * PRIME + ($username == null ? 43 : $username.hashCode());
    final Object $password = this.getPassword();
    result = result * PRIME + ($password == null ? 43 : $password.hashCode());
    return result;
  }

  public String toString() {
    return "UserCredentials(username=" + this.getUsername() + ", password=" + this.getPassword() + ")";
  }
}
