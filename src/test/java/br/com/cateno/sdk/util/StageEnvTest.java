package br.com.cateno.sdk.util;

import br.com.cateno.sdk.domain.auth.ClientCredentials;
import br.com.cateno.sdk.domain.auth.UserCredentials;
import br.com.cateno.sdk.infra.ZonedDateTimeDeserializer;
import br.com.cateno.sdk.infra.ZonedDateTimeSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static com.fasterxml.jackson.databind.DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE;
import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

public interface StageEnvTest {

  String BASE_URL = "https://api-cateno.sensedia.com/hlg/iris/v1/";
  DateTimeFormatter ZONED_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

  default ClientCredentials getClientCredentials() {
    return new ClientCredentials("c8da779c-304f-3204-b5db-67bab9d32871", "3a984afc-dc55-3cb5-bc2e-9c2fc4ba7204");
  }

  default UserCredentials getUserCredentials() {
    return new UserCredentials("00000000000", "Guilherme#123");
  }

  default Converter.Factory getConverterFactory() {
    return JacksonConverterFactory.create(this.getObjectMapper());
  }

  default ObjectMapper getObjectMapper() {
    final JavaTimeModule javaTimeModule = new JavaTimeModule();
    javaTimeModule.addSerializer(ZonedDateTime.class, new ZonedDateTimeSerializer(ZONED_DATE_TIME_FORMATTER));
    javaTimeModule.addDeserializer(ZonedDateTime.class, new ZonedDateTimeDeserializer(ZONED_DATE_TIME_FORMATTER));
    return new ObjectMapper()
        .disable(ADJUST_DATES_TO_CONTEXT_TIME_ZONE)
        .disable(FAIL_ON_UNKNOWN_PROPERTIES)
        .disable(WRITE_DATES_AS_TIMESTAMPS)
        .findAndRegisterModules()
        .registerModule(javaTimeModule)
        .setSerializationInclusion(NON_NULL);
  }

  default Retrofit getRetrofit() {
    return new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(this.getConverterFactory())
        .build();
  }
}
