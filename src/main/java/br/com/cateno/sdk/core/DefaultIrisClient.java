package br.com.cateno.sdk.core;

import br.com.cateno.sdk.domain.issuer.Issuer;
import br.com.cateno.sdk.domain.issuer.IssuerRequest;
import br.com.cateno.sdk.domain.issuer.IssuerService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.UUID;

@Singleton
public class DefaultIrisClient implements Iris {

  private final IssuerService issuerService;

  @Inject
  public DefaultIrisClient(final IssuerService issuerService) {
    this.issuerService = issuerService;
  }

  @Override
  public Issuer fetchIssuer(UUID id) {
    return this.issuerService.fetch(id);
  }

  @Override
  public List<Issuer> listIssuers() {
    return this.issuerService.list();
  }

  @Override
  public Issuer createIssuer(IssuerRequest issuer) {
    return this.issuerService.create(issuer);
  }

  @Override
  public Issuer updateIssuer(UUID id, IssuerRequest issuer) {
    return this.issuerService.update(id, issuer);
  }
}
