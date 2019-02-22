package br.com.cateno.sdk.core;

import br.com.cateno.sdk.domain.claim.ClaimApiClient;
import br.com.cateno.sdk.domain.claim.ReportApiClient;
import br.com.cateno.sdk.domain.establishment.EstablishmentApiClient;
import br.com.cateno.sdk.domain.establishment.MachineApiClient;
import br.com.cateno.sdk.domain.issuer.IssuerApiClient;
import br.com.cateno.sdk.domain.status.DeliveryActionApiClient;
import br.com.cateno.sdk.domain.status.FinanceActionApiClient;
import br.com.cateno.sdk.domain.uploader.UploaderApiClient;
import br.com.cateno.sdk.domain.user.OperationApiClient;
import br.com.cateno.sdk.domain.user.PasswordApiClient;
import br.com.cateno.sdk.domain.user.ProfileApiClient;
import br.com.cateno.sdk.domain.user.UserApiClient;
import br.com.cateno.sdk.domain.user.UserTypeApiClient;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import retrofit2.Retrofit;
import br.com.cateno.sdk.domain.messenger.MessageApiClient;

import javax.inject.Named;
import java.util.logging.Logger;

@Module
class ApiClientModule {

  private static final Logger LOGGER = Logger.getLogger(ApiClientModule.class.getName());

  ApiClientModule() {
    LOGGER.info("loading new api client module");
  }

  @Reusable
  @Provides
  ClaimApiClient provideClaimApiClient(@Named("authenticated") final Retrofit retrofit) {
    LOGGER.info("providing new claim api client");
    return retrofit.create(ClaimApiClient.class);
  }

  @Reusable
  @Provides
  DeliveryActionApiClient provideDeliveryActionApiClient(@Named("authenticated") final Retrofit retrofit) {
    LOGGER.info("providing new delivery action api client");
    return retrofit.create(DeliveryActionApiClient.class);
  }

  @Reusable
  @Provides
  EstablishmentApiClient provideEstablishmentApiClient(@Named("authenticated") final Retrofit retrofit) {
    LOGGER.info("providing new establishment api client");
    return retrofit.create(EstablishmentApiClient.class);
  }

  @Reusable
  @Provides
  FinanceActionApiClient provideFinanceActionApiClient(@Named("authenticated") final Retrofit retrofit) {
    LOGGER.info("providing new finance action api client");
    return retrofit.create(FinanceActionApiClient.class);
  }

  @Reusable
  @Provides
  IssuerApiClient provideIssuerApiClient(@Named("authenticated") final Retrofit retrofit) {
    LOGGER.info("providing new issuer api client");
    return retrofit.create(IssuerApiClient.class);
  }

  @Reusable
  @Provides
  MachineApiClient provideMachineApiClient(@Named("authenticated") final Retrofit retrofit) {
    LOGGER.info("providing new machine api client");
    return retrofit.create(MachineApiClient.class);
  }

  @Provides
  MessageApiClient provideMessageApiClient(@Named("authenticated") final Retrofit retrofit) {
    LOGGER.info("providing new machine api client");
    return retrofit.create(MessageApiClient.class);
  }

  @Reusable
  @Provides
  OperationApiClient provideOperationApiClient(@Named("authenticated") final Retrofit retrofit) {
    LOGGER.info("providing new operation api client");
    return retrofit.create(OperationApiClient.class);
  }

  @Reusable
  @Provides
  PasswordApiClient providePasswordApiClient(final Retrofit retrofit) {
    LOGGER.info("providing new password api client");
    return retrofit.create(PasswordApiClient.class);
  }

  @Reusable
  @Provides
  ProfileApiClient provideProfileApiClient(@Named("authenticated") final Retrofit retrofit) {
    LOGGER.info("providing new profile api client");
    return retrofit.create(ProfileApiClient.class);
  }

  @Provides
  ReportApiClient provideReportApiClient(@Named("authenticated") final Retrofit retrofit) {
    LOGGER.info("providing new report api client");
    return retrofit.create(ReportApiClient.class);
  }

  @Reusable
  @Provides
  UploaderApiClient provideUploaderApiClient(@Named("authenticated") final Retrofit retrofit) {
    LOGGER.info("providing new operation api client");
    return retrofit.create(UploaderApiClient.class);
  }

  @Reusable
  @Provides
  UserApiClient provideUserApiClient(@Named("authenticated") final Retrofit retrofit) {
    LOGGER.info("providing new user api client");
    return retrofit.create(UserApiClient.class);
  }

  @Provides
  UserTypeApiClient provideUserTypeApiClient(@Named("authenticated") final Retrofit retrofit) {
    LOGGER.info("providing new user type api client");
    return retrofit.create(UserTypeApiClient.class);
  }
}
