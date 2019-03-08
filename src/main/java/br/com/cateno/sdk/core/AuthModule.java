package br.com.cateno.sdk.core;

import br.com.cateno.sdk.domain.auth.*;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import retrofit2.Retrofit;

import javax.inject.Singleton;
import java.util.concurrent.TimeUnit;
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

  @Reusable
  @Provides
  AuthService provideAuthService(final OAuthApiClient apiClient, final Cache<String, Authorization> cache) {
    LOGGER.info("provide new auth service");
    return new AuthService(this.client, this.user, apiClient, cache);
  }

  @Provides
  @Singleton
  Cache<String, Authorization> provideAuthorizationCache() {
    LOGGER.info("providing new cache");
    return Caffeine.newBuilder()
        .expireAfterWrite(59, TimeUnit.MINUTES)
        .maximumSize(1)
        .build();
  }

  @Reusable
  @Provides
  OAuthApiClient provideOAuthApiClient(final Retrofit retrofit) {
    LOGGER.info("providing new oAuth api client");
    return retrofit.create(OAuthApiClient.class);
  }
}
