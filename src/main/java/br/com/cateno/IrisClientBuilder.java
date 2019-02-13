package br.com.cateno;

import br.com.cateno.auth.Authentication;
import br.com.cateno.auth.Authenticator;
import br.com.cateno.auth.credential.ClientCredentials;
import br.com.cateno.auth.credential.UserCredentials;

import static org.glassfish.jersey.internal.guava.Preconditions.checkNotNull;

public class IrisClientBuilder {

  private ClientCredentials clientCredentials;
  private UserCredentials userCredentials;

  private IrisClientBuilder() {
  }

  public static IrisClientBuilder standard() {
    return new IrisClientBuilder();
  }

  public DefaultIrisClient build() {
    checkNotNull(this.clientCredentials);
    checkNotNull(this.userCredentials);

    final Authentication authentication = new Authenticator(this.clientCredentials, this.userCredentials).login();
    return new DefaultIrisClient(authentication);
  }

  public IrisClientBuilder withClientCredentials(final ClientCredentials clientCredentials) {
    this.clientCredentials = clientCredentials;
    return this;
  }

  public IrisClientBuilder withUserCredentials(final UserCredentials userCredentials) {
    this.userCredentials = userCredentials;
    return this;
  }
}
