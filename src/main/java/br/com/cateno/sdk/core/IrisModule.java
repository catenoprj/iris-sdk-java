package br.com.cateno.sdk.core;

import br.com.cateno.sdk.domain.auth.AuthService;
import br.com.cateno.sdk.domain.auth.ClientCredentials;
import br.com.cateno.sdk.domain.auth.UserCredentials;
import br.com.cateno.sdk.domain.establishment.EstablishmentService;
import br.com.cateno.sdk.domain.issuer.IssuerService;
import br.com.cateno.sdk.domain.user.UserService;
import dagger.Module;
import dagger.Provides;
import org.glassfish.jersey.logging.LoggingFeature;

import javax.inject.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.util.logging.Level;
import java.util.logging.Logger;

@Module
class IrisModule {

  private static final Logger LOGGER = Logger.getLogger(IrisModule.class.getName());

  private final ClientCredentials client;
  private final UserCredentials user;

  IrisModule(final ClientCredentials client, final UserCredentials user) {
    LOGGER.info("loading new Iris module");
    this.client = client;
    this.user = user;
  }

  @Provides
  AuthService provideAuthService(final Client webClient) {
    LOGGER.info("providing new auth service");
    return new AuthService(webClient, this.client, this.user);
  }

  @Provides
  @Singleton
  Iris provideIrisClient(final IssuerService issuerService,
                         final EstablishmentService establishmentService,
                         final UserService userService) {
    LOGGER.info("providing new default iris client");
    return new DefaultIrisClient(issuerService, establishmentService, userService);
  }

  @Provides
  @Singleton
  Client provideWebClient() {
    LOGGER.info("providing new web client");
    final Client webClient = ClientBuilder.newClient();
    final Logger logger = Logger.getLogger(webClient.getClass().getName());
    webClient.register(new LoggingFeature(logger, Level.FINEST, null, null));
    return webClient;
  }
}
