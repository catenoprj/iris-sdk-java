package br.com.cateno.auth.credential;

import static org.glassfish.jersey.internal.guava.Preconditions.checkNotNull;

public class ClientCredentials {

  private final String id;
  private final String secret;

  public ClientCredentials(final String id, final String secret) {
    checkNotNull(id);
    checkNotNull(secret);

    this.id = id;
    this.secret = secret;
  }

  public boolean equals(final Object o) {
    if (o == this) return true;
    if (!(o instanceof ClientCredentials)) return false;
    final ClientCredentials other = (ClientCredentials) o;
    final Object this$id = this.getId();
    final Object other$id = other.getId();
    if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
    final Object this$secret = this.getSecret();
    final Object other$secret = other.getSecret();
    if (this$secret == null ? other$secret != null : !this$secret.equals(other$secret)) return false;
    return true;
  }

  public String getId() {
    return this.id;
  }

  public String getSecret() {
    return this.secret;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $id = this.getId();
    result = result * PRIME + ($id == null ? 43 : $id.hashCode());
    final Object $secret = this.getSecret();
    result = result * PRIME + ($secret == null ? 43 : $secret.hashCode());
    return result;
  }

  public String toString() {
    return "ClientCredentials(id=" + this.getId() + ", secret=" + this.getSecret() + ")";
  }
}
