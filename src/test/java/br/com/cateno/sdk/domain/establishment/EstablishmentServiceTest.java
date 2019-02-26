package br.com.cateno.sdk.domain.establishment;

import br.com.cateno.sdk.util.AuthenticatedStageEnvTest;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Dealing with Establishment")
class EstablishmentServiceTest implements AuthenticatedStageEnvTest {

  private final EstablishmentService service;

  EstablishmentServiceTest() {
    final EstablishmentApiClient establishmentApiClient = this.getAuthenticatedRetrofit().create(EstablishmentApiClient.class);
    this.service = new EstablishmentService(establishmentApiClient);
  }

  @Nested
  @DisplayName("Should create a new Establishment")
  class WhenCreateNewEstablishment {

    @Test
    @DisplayName("Should return the resource Establishment generated with Id")
    void shouldReturnTheResourceEstablishmentGeneratedWithId() throws IOException {
      EstablishmentRequestMock establishmentMock = new EstablishmentRequestMock();

      Establishment establishmentCreateResponse = service.create(establishmentMock.establismentRequestMock());
      assertThat(establishmentCreateResponse.getId()).isNotNull();
    }
  }

  @Nested
  @DisplayName("Should search a new Establishment by your ID")
  class WhenSearchNewEstablishmentById {

    @Test
    @DisplayName("Should return the related resource with the same ID")
    void shouldReturnTheRelatedResourceWithTheSameId() throws IOException {
      EstablishmentRequestMock establishmentMock = new EstablishmentRequestMock();

      Establishment establishmentCreateResponse = service.create(establishmentMock.establismentRequestMock());

      Establishment establishment = service.fetch(establishmentCreateResponse.getId());
      assertThat(establishment.getId()).isNotNull();
    }
  }

  @Nested
  @DisplayName("Should search a list Establishments")
  class WhenSearchListEstablishment {

    @Test
    @DisplayName("Should return a list of Establihments containing the last two above Establihments")
    void shouldReturnAListOfEstablishmentsContainingTheLastTwoAboveEstablishments() throws IOException {
      EstablishmentRequestMock establishmentMock = new EstablishmentRequestMock();

      Establishment establishmentCreateResponse = service.create(establishmentMock.establismentRequestMock());
      Establishment establishmentCreateResponse2 = service.create(establishmentMock.establismentRequestMock());

      List<Establishment> establishments = service.list();
      assertThat(establishments).contains(establishmentCreateResponse, establishmentCreateResponse2);
    }
  }

  @Nested
  @DisplayName("When create and request to update an Establishment")
  class WhenCreateAndRequestToUpdateAnEstablishment {

    @Test
    @DisplayName("Should update it properly")
    void shouldUpdateItProperly() throws IOException {

      EstablishmentRequestMock establishmentMock = new EstablishmentRequestMock();
      Establishment establishmentCreateResponse = service.create(establishmentMock.establismentRequestMock());

      EstablishmentRequest establishmentUpdate = establishmentMock.establismentRequestMock();

      FakeValuesService fakeValuesService = new FakeValuesService(
          new Locale("pt-BR"), new RandomService());

      String establishmentName = fakeValuesService.bothify("establishment??????");

      establishmentUpdate.setName(establishmentName);

      Establishment establishment = service.update(establishmentCreateResponse.getId(), establishmentUpdate);

      assertThat(establishment.getName()).contains(establishmentName);
    }
  }

  @Nested
  @DisplayName("When create and request to delete an Establishment")
  class WhenCreateAndRequestToDeleteAnEstablishment {

    @Test
    @DisplayName("Should delete it properly")
    void shouldDeleteItProperly() throws IOException {

      EstablishmentRequestMock establishmentMock = new EstablishmentRequestMock();
      Establishment establishmentCreateResponse = service.create(establishmentMock.establismentRequestMock());

      Establishment establishment = service.fetch(establishmentCreateResponse.getId());

      service.delete(establishment.getId());

      List<Establishment> establishments = service.list();

      assertThat(establishments).doesNotContain(establishment);
    }
  }
}
