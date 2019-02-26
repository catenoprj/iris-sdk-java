package br.com.cateno.sdk.core;

import br.com.cateno.sdk.domain.auth.AuthorizationInterceptor;
import com.fasterxml.jackson.databind.ObjectMapper;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import javax.inject.Named;
import java.util.logging.Logger;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

@Module
class RetrofitModule {

  private static final String DEFAULT_BASE_URL = "https://api-cateno.sensedia.com/hlg/iris/v1/";
  private static final Logger LOGGER = Logger.getLogger(RetrofitModule.class.getName());

  RetrofitModule() {
    LOGGER.info("loading new IRIS module");
  }

  @Provides
  @Named("authenticated")
  OkHttpClient provideAuthenticatedHttpClient(final AuthorizationInterceptor interceptor) {
    LOGGER.info("providing new authenticated http client");
    return new OkHttpClient().newBuilder()
        .addInterceptor(interceptor)
        .build();
  }

  @Provides
  @Named("authenticated")
  Retrofit provideAuthenticatedRetrofit(@Named("authenticated") final OkHttpClient httpClient, final Converter.Factory factory) {
    LOGGER.info("providing new authenticated retrofit");
    return new Retrofit.Builder()
        .baseUrl(DEFAULT_BASE_URL)
        .addConverterFactory(factory)
        .client(httpClient)
        .build();
  }

  @Provides
  Converter.Factory provideConverterFactory(final ObjectMapper objectMapper) {
    LOGGER.info("providing new converter factory");
    return JacksonConverterFactory.create(objectMapper);
  }

  @Provides
  OkHttpClient provideHttpClient() {
    LOGGER.info("providing new http client");
    return new OkHttpClient().newBuilder()
        .build();
  }

  @Provides
  ObjectMapper provideObjectMapper() {
    LOGGER.info("providing new object mapper");
    return new ObjectMapper().configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

  @Provides
  Retrofit provideRetrofit(final Converter.Factory factory) {
    LOGGER.info("providing new retrofit");
    return new Retrofit.Builder()
        .baseUrl(DEFAULT_BASE_URL)
        .addConverterFactory(factory)
        .build();
  }
}
