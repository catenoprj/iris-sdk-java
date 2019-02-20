package br.com.cateno.sdk.core;

import br.com.cateno.sdk.domain.auth.AuthService;
import br.com.cateno.sdk.domain.auth.ClientCredentials;
import br.com.cateno.sdk.domain.auth.OAuthApiClient;
import br.com.cateno.sdk.domain.auth.UserCredentials;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

import java.util.logging.Logger;

@Module
class AuthModule {

  private static final Logger LOGGER = Logger.getLogger(AuthModule.class.getName());

  private final ClientCredentials client;
  private final UserCredentials user;

  AuthModule(final ClientCredentials client, final UserCredentials user) {
    LOGGER.info("loading new Authentication module");
    this.client = client;
    this.user = user;
  }

  @Provides
  AuthService provideAuthService(final OAuthApiClient apiClient) {
    LOGGER.info("provide new auth service");
    return new AuthService(this.client, this.user, apiClient);
  }

  @Provides
  OAuthApiClient provideOAuthApiClient(final Retrofit retrofit) {
    LOGGER.info("providing new oAuth api client");
    return retrofit.create(OAuthApiClient.class);
  }
}
