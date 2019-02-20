package br.com.cateno.sdk.core;

import br.com.cateno.sdk.domain.establishment.EstablishmentApiClient;
import br.com.cateno.sdk.domain.establishment.MachineApiClient;
import br.com.cateno.sdk.domain.issuer.IssuerApiClient;
import br.com.cateno.sdk.domain.user.UserApiClient;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

import javax.inject.Named;
import java.util.logging.Logger;

@Module
class ApiClientModule {

  private static final Logger LOGGER = Logger.getLogger(ApiClientModule.class.getName());

  ApiClientModule() {
    LOGGER.info("loading new api client module");
  }

  @Provides
  EstablishmentApiClient provideEstablishmentApiClient(@Named("authenticated") final Retrofit retrofit) {
    LOGGER.info("providing new establishment api client");
    return retrofit.create(EstablishmentApiClient.class);
  }

  @Provides
  IssuerApiClient provideIssuerApiClient(@Named("authenticated") final Retrofit retrofit) {
    LOGGER.info("providing new issuer api client");
    return retrofit.create(IssuerApiClient.class);
  }

  @Provides
  UserApiClient provideUserApiClient(@Named("authenticated") final Retrofit retrofit) {
    LOGGER.info("providing new user api client");
    return retrofit.create(UserApiClient.class);
  }

  @Provides
  MachineApiClient provideMachineApiClient(@Named("authenticated") final Retrofit retrofit) {
    LOGGER.info("providing new machine api client");
    return retrofit.create(MachineApiClient.class);
  }
}
