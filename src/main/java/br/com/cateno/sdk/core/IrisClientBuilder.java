package br.com.cateno.sdk.core;

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

  public Iris build() {
    if ((this.clientCredentials == null) || (this.userCredentials == null)) throw new CredentialsNotFoundException();
    final ClientFactory factory = DaggerClientFactory.builder()
        .irisModule(new IrisModule(this.clientCredentials, this.userCredentials))
        .build();
    return factory.buildClient();
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