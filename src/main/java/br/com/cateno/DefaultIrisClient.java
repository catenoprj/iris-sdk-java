package br.com.cateno;

import br.com.cateno.auth.Authentication;
import br.com.cateno.issuer.Issuer;
import br.com.cateno.issuer.IssuerRequest;
import lombok.NonNull;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.*;
import java.util.List;
import java.util.UUID;

public class DefaultIrisClient implements Iris {

  private final Authentication authentication;
  private final String clientId;

  private Client client = ClientBuilder.newClient();

  public DefaultIrisClient(final @NonNull Authentication authentication, final @NonNull String clientId) {
    this.authentication = authentication;
    this.clientId = clientId;
  }

  private MultivaluedMap<String, Object> enableAccess() {
    final MultivaluedMap<String, Object> args = new MultivaluedHashMap<>();
    args.add("client_id", clientId);
    args.add("access_token", authentication.getAccessToken());
    return args;
  }

  @Override
  public Issuer fetchIssuerById(UUID id) {
    return client
            .target(ISSUER_REST_URI)
            .path(id.toString())
            .request(MediaType.APPLICATION_JSON)
            .headers(enableAccess())
            .get(Issuer.class);
  }

  @Override
  public List<Issuer> listIssuers() {
    return client
            .target(ISSUER_REST_URI)
            .request(MediaType.APPLICATION_JSON)
            .headers(enableAccess())
            .get(new GenericType<List<Issuer>>() {});
  }

  @Override
  public Issuer createIssuer(IssuerRequest issuer) {
    return client
            .target(ISSUER_REST_URI)
            .request(MediaType.APPLICATION_JSON)
            .headers(enableAccess())
            .post(Entity.entity(issuer, MediaType.APPLICATION_JSON), Issuer.class);
  }

  @Override
  public Issuer updateIssuer(UUID id, IssuerRequest issuer) {
    return client
            .target(ISSUER_REST_URI)
            .path(id.toString())
            .request(MediaType.APPLICATION_JSON)
            .headers(enableAccess())
            .put(Entity.entity(issuer, MediaType.APPLICATION_JSON), Issuer.class);
  }

}
