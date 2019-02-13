package br.com.cateno;

import br.com.cateno.auth.*;
import br.com.cateno.auth.credential.ClientCredentials;
import br.com.cateno.auth.credential.UserCredentials;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Dealing with Establishments")
class EstablishmentsTest {

  @Nested
  @DisplayName("When credential are valid")
  class WhenCredentialsAreValid {

    private static final String CLIENT_ID = "c8da779c-304f-3204-b5db-67bab9d32871";
    private static final String CLIENT_SECRET = "3a984afc-dc55-3cb5-bc2e-9c2fc4ba7204";
    private static final String USERNAME = "00000000000";
    private static final String PASSWORD = "Guilherme#123";

    @Test
    @DisplayName("Should respond a list of establishments")
    void ShouldRespondAListOfEstablishments() {
      final Iris iris = IrisClientBuilder.standard()
          .withClientCredentials(new ClientCredentials(CLIENT_ID, CLIENT_SECRET))
          .withUserCredentials(new UserCredentials(USERNAME, PASSWORD))
          .build();
      final List<Establishment> establishments = iris.listEstablishments();
      assertThat(establishments).isNotEmpty();
    }
  }
}