package br.com.cateno.sdk.domain.auth;

import br.com.cateno.sdk.core.IrisClientBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Dealing with authentication")
class AuthServiceTest {

  private static final String CLIENT_ID = "c8da779c-304f-3204-b5db-67bab9d32871";
  private static final String CLIENT_SECRET = "3a984afc-dc55-3cb5-bc2e-9c2fc4ba7204";
  private static final String USERNAME = "00000000000";
  private static final String PASSWORD = "Guilherme#123";

  private AuthService service;

  @BeforeEach
  void init() {
    final ClientCredentials client = new ClientCredentials(CLIENT_ID, CLIENT_SECRET);
    final UserCredentials user = new UserCredentials(USERNAME, PASSWORD);
//    Retrofit retrofit = new Retrofit.Builder()
//        .baseUrl("https://api-cateno.sensedia.com/hlg/iris/v1/")
//        .addConverterFactory(JacksonConverterFactory.create(new ObjectMapper()))
//        .build();
//    final OAuthApiClient apiClient = retrofit.create(OAuthApiClient.class);
//    service = new AuthService(client, user, apiClient);
    service = IrisClientBuilder.standard()
        .withClientCredentials(client)
        .withUserCredentials(user)
        .build()
        .loadAuthService();
  }

  @Nested
  @DisplayName("When login into the API")
  class WhenLoginIntoTheApi {

    @Test
    @DisplayName("Should authenticate properly")
    void shouldAuthenticateProperly() throws IOException {
      final Authorization authorization = service.askForAuthorization();
      assertThat(authorization).isNotNull();
    }
  }
}