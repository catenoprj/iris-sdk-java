package br.com.cateno.sdk.domain.auth;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import java.util.logging.Logger;

import static org.glassfish.jersey.internal.guava.Preconditions.checkNotNull;

public class AuthService {

  private static final String REST_URI = "https://api-cateno.sensedia.com/hlg/iris/v1/oauth/login";
  private static final Logger LOGGER = Logger.getLogger(AuthService.class.getName());

  private final ClientCredentials client;
  private final UserCredentials user;
  private final Client webClient;

  public AuthService(final Client webClient, final ClientCredentials client, final UserCredentials user) {
    checkNotNull(webClient);
    checkNotNull(client);
    checkNotNull(user);

    this.webClient = webClient;
    this.client = client;
    this.user = user;
  }

  public AuthorizationHeaders requestHeaders() {
    LOGGER.info("getting request authorization headers");
    final Authentication authentication = this.login();
    return AuthorizationHeaders.of(this.client, authentication);
  }

  private Entity<Form> form() {
    final String username = this.user.getUsername();
    final String password = this.user.getPassword();

    final Form form = new Form();
    form.param("username", username);
    form.param("password", password);

    return Entity.form(form);
  }

  private Authentication login() {
    LOGGER.info("login into the API");
    return this.webClient
        .target(REST_URI)
        .request(MediaType.APPLICATION_JSON)
        .headers(AuthorizationHeaders.of(this.client))
        .post(this.form(), Authentication.class);
  }
}
