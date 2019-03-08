package br.com.cateno.sdk.core;

import br.com.cateno.sdk.domain.auth.AuthorizationInterceptor;
import br.com.cateno.sdk.infra.ZonedDateTimeDeserializer;
import br.com.cateno.sdk.infra.ZonedDateTimeSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import javax.inject.Named;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static com.fasterxml.jackson.databind.DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE;
import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

@Module
class RetrofitModule {

  private static final DateTimeFormatter ZONED_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
  private static final Logger LOGGER = Logger.getLogger(RetrofitModule.class.getName());
  private static final String DEFAULT_BASE_URL = "https://api-cateno.sensedia.com/hlg/iris/v1/";

  RetrofitModule() {
    LOGGER.info("loading new IRIS module");
  }

  @Reusable
  @Provides
  @Named("authenticated")
  OkHttpClient provideAuthenticatedHttpClient(final AuthorizationInterceptor interceptor) {
    LOGGER.info("providing new authenticated http client");
    return new OkHttpClient().newBuilder()
        .addInterceptor(interceptor)
        .build();
  }

  @Reusable
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

  @Reusable
  @Provides
  Converter.Factory provideConverterFactory(final ObjectMapper objectMapper) {
    LOGGER.info("providing new converter factory");
    return JacksonConverterFactory.create(objectMapper);
  }

  @Reusable
  @Provides
  OkHttpClient provideHttpClient() {
    LOGGER.info("providing new http client");
    return new OkHttpClient().newBuilder()
        .build();
  }

  @Reusable
  @Provides
  ObjectMapper provideObjectMapper() {
    LOGGER.info("providing new object mapper");
    final JavaTimeModule javaTimeModule = new JavaTimeModule();
    javaTimeModule.addSerializer(ZonedDateTime.class, new ZonedDateTimeSerializer(ZONED_DATE_TIME_FORMATTER));
    javaTimeModule.addDeserializer(ZonedDateTime.class, new ZonedDateTimeDeserializer(ZONED_DATE_TIME_FORMATTER));
    return new ObjectMapper()
        .disable(ADJUST_DATES_TO_CONTEXT_TIME_ZONE)
        .disable(FAIL_ON_UNKNOWN_PROPERTIES)
        .disable(WRITE_DATES_AS_TIMESTAMPS)
        .registerModule(javaTimeModule)
        .findAndRegisterModules()
        .setSerializationInclusion(NON_NULL);
  }

  @Reusable
  @Provides
  Retrofit provideRetrofit(final Converter.Factory factory) {
    LOGGER.info("providing new retrofit");
    return new Retrofit.Builder()
        .baseUrl(DEFAULT_BASE_URL)
        .addConverterFactory(factory)
        .build();
  }
}
