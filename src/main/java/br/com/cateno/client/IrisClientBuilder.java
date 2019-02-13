package br.com.cateno.client;

public class IrisClientBuilder {

  private ClientCredentials credentials;

  private IrisClientBuilder() {
  }

  public static IrisClientBuilder standard() {
    return new IrisClientBuilder();
  }

  public DefaultIrisClient build() {
    return new DefaultIrisClient(this.credentials);
  }

  public IrisClientBuilder withCredentials(final ClientCredentials credentials) {
    this.credentials = credentials;
    return this;
  }
}
