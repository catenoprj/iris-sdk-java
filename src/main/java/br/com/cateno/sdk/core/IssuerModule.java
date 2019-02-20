package br.com.cateno.sdk.core;

import br.com.cateno.sdk.domain.issuer.IssuerApiClient;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

import javax.inject.Named;
import java.util.logging.Logger;

@Module
class IssuerModule {

  private static final Logger LOGGER = Logger.getLogger(IssuerModule.class.getName());

  IssuerModule() {
    LOGGER.info("loading new issuer module");
  }

  @Provides
  IssuerApiClient provideIssuerApiClient(@Named("authenticated") final Retrofit retrofit) {
    LOGGER.info("providing new issuer api client");
    return retrofit.create(IssuerApiClient.class);
  }
}
