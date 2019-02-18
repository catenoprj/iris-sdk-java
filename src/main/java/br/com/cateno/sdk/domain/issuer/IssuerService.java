package br.com.cateno.sdk.domain.issuer;

import br.com.cateno.sdk.domain.auth.AuthService;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

import static org.glassfish.jersey.internal.guava.Preconditions.checkNotNull;

public class IssuerService {

  private static final String ISSUER_REST_URI = "https://api-cateno.sensedia.com/hlg/iris/v1/issuers/";
  private final AuthService authService;
  private final Client webClient;

  @Inject
  public IssuerService(final AuthService authService, final Client webClient) {
    this.authService = authService;
    this.webClient = webClient;
  }

  public Issuer create(final IssuerRequest issuer) {
    checkNotNull(issuer);

    return this.webClient
        .target(ISSUER_REST_URI)
        .request(MediaType.APPLICATION_JSON)
        .headers(this.authService.requestHeaders())
        .post(Entity.entity(issuer, MediaType.APPLICATION_JSON), Issuer.class);
  }

  public Issuer fetch(final UUID id) {
    checkNotNull(id);

    return this.webClient
        .target(ISSUER_REST_URI)
        .path(id.toString())
        .request(MediaType.APPLICATION_JSON)
        .headers(this.authService.requestHeaders())
        .get(Issuer.class);
  }

  public List<Issuer> list() {
    return this.webClient
        .target(ISSUER_REST_URI)
        .request(MediaType.APPLICATION_JSON)
        .headers(this.authService.requestHeaders())
        .get(new GenericType<List<Issuer>>() {});
  }

  public Issuer update(final UUID id, final IssuerRequest issuer) {
    checkNotNull(id);
    checkNotNull(issuer);

    return this.webClient
        .target(ISSUER_REST_URI)
        .path(id.toString())
        .request(MediaType.APPLICATION_JSON)
        .headers(this.authService.requestHeaders())
        .put(Entity.entity(issuer, MediaType.APPLICATION_JSON), Issuer.class);
  }
}
