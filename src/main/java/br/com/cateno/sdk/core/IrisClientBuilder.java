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

  public IrisClient build() {
    if ((this.clientCredentials == null) || (this.userCredentials == null)) throw new CredentialsNotFoundException();
    return DaggerIrisClient.builder()
        .irisModule(new IrisModule())
        .authModule(new AuthModule(this.clientCredentials, this.userCredentials))
        .build();
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
