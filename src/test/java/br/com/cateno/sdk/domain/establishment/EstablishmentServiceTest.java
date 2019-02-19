package br.com.cateno.sdk.domain.establishment;

import br.com.cateno.sdk.domain.auth.AuthService;
import br.com.cateno.sdk.domain.auth.ClientCredentials;
import br.com.cateno.sdk.domain.auth.UserCredentials;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Dealing with Establishment")
class EstablishmentServiceTest {

    private static final String CLIENT_ID = "c8da779c-304f-3204-b5db-67bab9d32871";
    private static final String CLIENT_SECRET = "3a984afc-dc55-3cb5-bc2e-9c2fc4ba7204";
    private static final String USERNAME = "00000000000";
    private static final String PASSWORD = "Guilherme#123";

    private EstablishmentService service;

    @BeforeEach
    void init() {
        final Client webClient = ClientBuilder.newClient();
        final ClientCredentials client = new ClientCredentials(CLIENT_ID, CLIENT_SECRET);
        final UserCredentials user = new UserCredentials(USERNAME, PASSWORD);
        final AuthService authService = new AuthService(webClient, client, user);
        this.service = new EstablishmentService(authService, webClient);
    }

    @Nested
    @DisplayName("Should create a new Establishment")
    class WhenCreateNewEstablishment {

        @Test
        @DisplayName("When create a new Establishment")
        void create() {

            Establishment establishmentCreateResponse = service.create(EstablishmentRequestMock.establismentRequestMock());
            assertThat(establishmentCreateResponse.getId()).isNotNull();
        }
    }


    @Nested
    @DisplayName("Should search a new Establishment by your ID")
    class WhenSearchNewEstablishmentById {

        @Test
        @DisplayName("When create a new Establishment and search by your ID")
        void searchEstablishmentById() {
            Establishment establishmentCreateResponse = service.create(EstablishmentRequestMock.establismentRequestMock());

            Establishment establishment = service.fetch(establishmentCreateResponse.getId());
            assertThat(establishment.getId()).isNotNull();
        }
    }

    @Nested
    @DisplayName("Should search a list Establishments")
    class WhenSearchListEstablishment {

        @Test
        @DisplayName("When create some Establishments and search list Establishments")
        void searchEstablishment() {
            Establishment establishmentCreateResponse = service.create(EstablishmentRequestMock.establismentRequestMock());
            Establishment establishmentCreateResponse2 = service.create(EstablishmentRequestMock.establismentRequestMock());

            List<Establishment> establishments = service.list();
            assertThat(establishments).contains(establishmentCreateResponse, establishmentCreateResponse2);
        }
    }


    @Nested
    @DisplayName("Should update a Establishment")
    class WhenUpdateEstablishment {

        @Test
        @DisplayName("When update a Establishment")
        void update() {
            Establishment establishmentCreateResponse = service.create(EstablishmentRequestMock.establismentRequestMock());

            EstablishmentRequest establishmentUpdate = EstablishmentRequestMock.establismentRequestMock();

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
        void delete() {
            Establishment establishmentCreateResponse = service.create(EstablishmentRequestMock.establismentRequestMock());

            Establishment establishment = service.fetch(establishmentCreateResponse.getId());

            service.delete(establishment.getId());

            List<Establishment> establishments = service.list();

            assertThat(establishments).doesNotContain(establishmentCreateResponse, establishmentCreateResponse);

        }
    }

}
