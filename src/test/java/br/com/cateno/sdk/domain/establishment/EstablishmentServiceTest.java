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
    @DisplayName("When create a new Establishment")
    void create() throws IOException {
      EstablishmentRequestMock establishmentMock = new EstablishmentRequestMock();

      Establishment establishmentCreateResponse = service.create(establishmentMock.establismentRequestMock());
      assertThat(establishmentCreateResponse.getId()).isNotNull();
    }
  }

  @Nested
  @DisplayName("Should search a new Establishment by your ID")
  class WhenSearchNewEstablishmentById {

    @Test
    @DisplayName("When create a new Establishment and search by your ID")
    void searchEstablishmentById() throws IOException {
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
    @DisplayName("When create some Establishments and search list Establishments")
    void searchEstablishment() throws IOException {
      EstablishmentRequestMock establishmentMock = new EstablishmentRequestMock();

      Establishment establishmentCreateResponse = service.create(establishmentMock.establismentRequestMock());
      Establishment establishmentCreateResponse2 = service.create(establishmentMock.establismentRequestMock());

      List<Establishment> establishments = service.list();
      assertThat(establishments).contains(establishmentCreateResponse, establishmentCreateResponse2);
    }
  }

  @Nested
  @DisplayName("Should update a Establishment")
  class WhenUpdateEstablishment {

    @Test
    @DisplayName("When update a Establishment")
    void update() throws IOException {

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
  @DisplayName("Should delete a Establishments")
  class WhenDeleteEstablishment {

    @Test
    @DisplayName("When create a Establishments and delete Establishment")
    void delete() throws IOException {
      EstablishmentRequestMock establishmentMock = new EstablishmentRequestMock();
      Establishment establishmentCreateResponse = service.create(establishmentMock.establismentRequestMock());

      Establishment establishment = service.fetch(establishmentCreateResponse.getId());

      service.delete(establishment.getId());

      List<Establishment> establishments = service.list();

      assertThat(establishments).doesNotContain(establishment);
    }
  }
}
