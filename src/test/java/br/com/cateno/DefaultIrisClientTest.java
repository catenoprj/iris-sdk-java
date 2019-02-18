package br.com.cateno;

import br.com.cateno.sdk.core.CredentialsNotFoundException;
import br.com.cateno.sdk.core.Iris;
import br.com.cateno.sdk.core.IrisClientBuilder;
import br.com.cateno.sdk.domain.auth.ClientCredentials;
import br.com.cateno.sdk.domain.auth.UserCredentials;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

@DisplayName("Dealing with Iris Client")
class DefaultIrisClientTest {

  @Nested
  @DisplayName("When credential are valid")
  class WhenCredentialsAreValid {

    private static final String CLIENT_ID = "c8da779c-304f-3204-b5db-67bab9d32871";
    private static final String CLIENT_SECRET = "3a984afc-dc55-3cb5-bc2e-9c2fc4ba7204";
    private static final String USERNAME = "00000000000";
    private static final String PASSWORD = "Guilherme#123";

    @Test
    @DisplayName("Should respond with an instance")
    void shouldRespondWithAnInstance() {
      final Iris iris = IrisClientBuilder.standard()
          .withClientCredentials(new ClientCredentials(CLIENT_ID, CLIENT_SECRET))
          .withUserCredentials(new UserCredentials(USERNAME, PASSWORD))
          .build();
      assertThat(iris).isNotNull();
    }
  }

  @Nested
  @DisplayName("When credential are not informed")
  class WhenCredentialAreNotInformed {

    @Test
    @DisplayName("Should thrown error")
    void ShouldThrownError() {
      assertThatExceptionOfType(CredentialsNotFoundException.class)
          .isThrownBy(() -> IrisClientBuilder.standard().build())
          .withNoCause();
    }
  }
}