package br.com.cateno.sdk.core;

import br.com.cateno.sdk.domain.user.UserApiClient;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

import javax.inject.Named;
import java.util.logging.Logger;

@Module
public class UserModule {

    private static final Logger LOGGER = Logger.getLogger(UserModule.class.getName());

    UserModule() {
        LOGGER.info("loading new Authentication module");
    }

    @Provides
    UserApiClient provideUserApiClient(@Named("authenticated") final Retrofit retrofit) {
        LOGGER.info("providing new oAuth api client");
        return retrofit.create(UserApiClient.class);
    }
}
