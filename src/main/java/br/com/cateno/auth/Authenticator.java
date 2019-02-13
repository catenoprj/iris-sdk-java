package br.com.cateno.auth;

import br.com.cateno.auth.authenticator.AuthorizationHeaders;
import br.com.cateno.auth.credential.ClientCredentials;
import br.com.cateno.auth.credential.UserCredentials;
import lombok.extern.java.Log;
import org.glassfish.jersey.logging.LoggingFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import java.util.logging.Level;

import static org.glassfish.jersey.internal.guava.Preconditions.checkNotNull;

@Log
public class Authenticator {

  private static final String REST_URI = "https://api-cateno.sensedia.com/hlg/iris/v1/oauth/login";
  private final Client client = ClientBuilder.newClient();

  private final ClientCredentials credentials;
  private final UserCredentials userCredentials;

  public Authenticator(final ClientCredentials clientCredentials, final UserCredentials userCredentials) {
    checkNotNull(clientCredentials);
    checkNotNull(userCredentials);

    final Feature feature = new LoggingFeature(log, Level.INFO, null, null);
    this.client.register(feature);
    this.credentials = clientCredentials;
    this.userCredentials = userCredentials;
  }

  public Authentication login() {
    return this.client
        .target(REST_URI)
        .request(MediaType.APPLICATION_JSON)
        .headers(AuthorizationHeaders.of(this.credentials))
        .post(this.form(), Authentication.class);
  }

  private Entity<Form> form() {
    final String username = this.userCredentials.getUsername();
    final String password = this.userCredentials.getPassword();

    final Form form = new Form();
    form.param("username", username);
    form.param("password", password);

    return Entity.form(form);
  }
}
