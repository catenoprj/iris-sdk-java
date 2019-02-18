package br.com.cateno.sdk.core;

import br.com.cateno.sdk.domain.auth.Authentication;
import br.com.cateno.sdk.domain.auth.Authenticator;
import br.com.cateno.sdk.domain.auth.ClientCredentials;
import br.com.cateno.sdk.domain.auth.UserCredentials;

public class IrisClientBuilder {

  private ClientCredentials clientCredentials;
  private UserCredentials userCredentials;

  private IrisClientBuilder() {
  }

  public static IrisClientBuilder standard() {
    return new IrisClientBuilder();
  }

  public DefaultIrisClient build() {
    if ((this.clientCredentials == null) || (this.userCredentials == null)) throw new CredentialsNotFoundException();
    final Authentication authentication = new Authenticator(this.clientCredentials, this.userCredentials).login();
    return new DefaultIrisClient(authentication, this.clientCredentials.getId());
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
