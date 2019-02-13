package br.com.cateno;

import br.com.cateno.client.ClientCredentials;
import br.com.cateno.client.Establishment;
import br.com.cateno.client.Iris;
import br.com.cateno.client.IrisClientBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Dealing with Iris client")
class ClientTest {

  @Nested
  @DisplayName("When credentials are valid")
  class WhenCredentialsAreValid {

    private static final String CLIENT_ID = "c8da779c-304f-3204-b5db-67bab9d32871";
    private static final String CLIENT_SECRET = "3a984afc-dc55-3cb5-bc2e-9c2fc4ba7204";

    @Test
    @DisplayName("Should respond a list of establishments")
    void ShouldRespondAListOfEstablishments() {
      final Iris iris = IrisClientBuilder.standard()
          .withCredentials(new ClientCredentials(CLIENT_ID, CLIENT_SECRET))
          .build();
      final List<Establishment> establishments = iris.listEstablishments();
      assertThat(establishments).isNotEmpty();
    }
  }
}