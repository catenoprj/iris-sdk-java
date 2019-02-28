package br.com.cateno.sdk.domain.auth;

import br.com.cateno.sdk.util.StageEnvTest;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.catchThrowable;

@DisplayName("Dealing with authentication")
class AuthServiceTest implements StageEnvTest {

  private final AuthService service;

  AuthServiceTest() {
    final OAuthApiClient oAuthApiClient = this.getRetrofit().create(OAuthApiClient.class);
    this.service = new AuthService(this.getClientCredentials(), this.getUserCredentials(), oAuthApiClient, Caffeine.newBuilder().build());
  }

  @Nested
  @DisplayName("When login into the API")
  class WhenLoginIntoTheApi {

    @Test
    @DisplayName("Then authenticate properly")
    void thenAuthenticateProperly() {
      final Authorization authorization = service.askForAuthorization();
      assertThat(authorization).isNotNull();
    }
  }

  @Nested
  @DisplayName("When login into the API with invalid Client Id Credential")
  class whenLoginIntoTheApiWithInvalidClientIdCredentials {

    @Test
    @DisplayName("Then unauthorized credentials properly")
    void thenUnauthorizedCredentialsProperly() {
      final OAuthApiClient oAuthApiClient = getRetrofit().create(OAuthApiClient.class);

      final ClientCredentials wrongClient = new ClientCredentials("222a779c-304f-2222-b511-67bab9d32871", "3a984afc-dc55-3cb5-bc2e-9c2fc4ba7204");
      final UserCredentials wrongUser = new UserCredentials("00000000000", "Guilherme#123");

      final AuthService service = new AuthService(wrongClient, wrongUser, oAuthApiClient, Caffeine.newBuilder().build());
      final Throwable exception = catchThrowable(() -> service.askForAuthorization());
      assertThat(exception).isInstanceOf(RuntimeException.class);
    }
  }

  @Nested
  @DisplayName("When login into the API with invalid Username credential")
  class whenLoginIntoTheApiWithInvalidUsernameCredential {

    @Test
    @DisplayName("Then unauthorized credentials properly")
    void thenUnauthorizedCredentialsProperly() {
      final OAuthApiClient oAuthApiClient = getRetrofit().create(OAuthApiClient.class);

      final ClientCredentials wrongClient = new ClientCredentials("c8da779c-304f-3204-b5db-67bab9d32871", "3a984afc-dc55-3cb5-bc2e-9c2fc4ba7204");
      final UserCredentials wrongUser = new UserCredentials("aaaaaaaaaaaaa", "Testee#123");

      final AuthService service = new AuthService(wrongClient, wrongUser, oAuthApiClient, Caffeine.newBuilder().build());
      final Throwable exception = catchThrowable(() -> service.askForAuthorization());
      assertThat(exception).isInstanceOf(RuntimeException.class);
    }
  }




}