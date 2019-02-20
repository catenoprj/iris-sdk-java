package br.com.cateno.sdk.util;

import br.com.cateno.sdk.domain.auth.ClientCredentials;
import br.com.cateno.sdk.domain.auth.OAuthApiClient;
import br.com.cateno.sdk.domain.auth.UserCredentials;
import com.fasterxml.jackson.databind.ObjectMapper;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public interface StageEnvTest {

  String BASE_URL = "https://api-cateno.sensedia.com/hlg/iris/v1/";

  default ClientCredentials getClientCredentials() {
    return new ClientCredentials("c8da779c-304f-3204-b5db-67bab9d32871", "3a984afc-dc55-3cb5-bc2e-9c2fc4ba7204");
  }

  default UserCredentials getUserCredentials() {
    return new UserCredentials("00000000000", "Guilherme#123");
  }

  default Converter.Factory getConverterFactory() {
    return JacksonConverterFactory.create(new ObjectMapper());
  }

  default Retrofit getRetrofit() {
    return new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(this.getConverterFactory())
        .build();
  }
}
