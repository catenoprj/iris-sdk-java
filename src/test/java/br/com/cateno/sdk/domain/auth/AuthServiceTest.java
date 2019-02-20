package br.com.cateno.sdk.domain.auth;

import br.com.cateno.sdk.util.StageEnvTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Dealing with authentication")
class AuthServiceTest implements StageEnvTest {

  private final AuthService service;

  AuthServiceTest() {
    final OAuthApiClient oAuthApiClient = this.getRetrofit().create(OAuthApiClient.class);
    this.service = new AuthService(this.getClientCredentials(), this.getUserCredentials(), oAuthApiClient);
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