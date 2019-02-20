package br.com.cateno.sdk.core;

import br.com.cateno.sdk.domain.establishment.EstablishmentApiClient;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

import javax.inject.Named;
import java.util.logging.Logger;

@Module
class EstablishmentModule {

  private static final Logger LOGGER = Logger.getLogger(EstablishmentModule.class.getName());

  EstablishmentModule() {
    LOGGER.info("loading new establishment module");
  }

  @Provides
  EstablishmentApiClient provideEstablishmentApiClient(@Named("authenticated") final Retrofit retrofit) {
    LOGGER.info("providing new establishment api client");
    return retrofit.create(EstablishmentApiClient.class);
  }
}
