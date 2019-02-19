package br.com.cateno.establishment;

import br.com.cateno.sdk.core.Iris;
import br.com.cateno.sdk.core.IrisClientBuilder;
import br.com.cateno.sdk.domain.auth.ClientCredentials;
import br.com.cateno.sdk.domain.auth.UserCredentials;
import br.com.cateno.sdk.domain.establishment.Establishment;
import br.com.cateno.sdk.domain.establishment.EstablishmentRequest;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Dealing with Establishment")
class EstablishmentDataTest {

    private static final String CLIENT_ID = "c8da779c-304f-3204-b5db-67bab9d32871";
    private static final String CLIENT_SECRET = "3a984afc-dc55-3cb5-bc2e-9c2fc4ba7204";
    private static final String USERNAME = "00000000000";
    private static final String PASSWORD = "Guilherme#123";


    Iris authorize(){
        return  IrisClientBuilder.standard()
                .withClientCredentials(new ClientCredentials(CLIENT_ID, CLIENT_SECRET))
                .withUserCredentials(new UserCredentials(USERNAME, PASSWORD))
                .build();
    }

    @Nested
    @DisplayName("Should create a new Establishment")
    class WhenCreateNewEstablishment {

        @Test
        @DisplayName("When create a new Establishment")
        void createEstablishment() {

            Establishment establishmentCreateResponse = authorize().createEstablishment(EstablishmentRequestMock.establismentRequestMock());
            assertThat(establishmentCreateResponse.getId()).isNotNull();
        }
    }


    @Nested
    @DisplayName("Should search a new Establishment by your ID")
    class WhenSearchNewEstablishmentById {

        @Test
        @DisplayName("When create a new Establishment and search by your ID")
        void searchEstablishmentById() {
            Establishment establishmentCreateResponse = authorize().createEstablishment(EstablishmentRequestMock.establismentRequestMock());

            Establishment establishment = authorize().fetchEstablishment(establishmentCreateResponse.getId());
            assertThat(establishment.getId()).isNotNull();
        }
    }

    @Nested
    @DisplayName("Should search a list Establishments")
    class WhenSearchListEstablishment {

        @Test
        @DisplayName("When create some Establishments and search list Establishments")
        void searchEstablishment() {
            Establishment establishmentCreateResponse = authorize().createEstablishment(EstablishmentRequestMock.establismentRequestMock());
            Establishment establishmentCreateResponse2 = authorize().createEstablishment(EstablishmentRequestMock.establismentRequestMock());

            List<Establishment> establishments = authorize().listEstablishments();
            assertThat(establishments).contains(establishmentCreateResponse, establishmentCreateResponse2);
        }
    }


    @Nested
    @DisplayName("Should update a Establishment")
    class WhenUpdateEstablishment {

        @Test
        @DisplayName("When update a Establishment")
        void updateEstablishment() {
            Establishment establishmentCreateResponse = authorize().createEstablishment(EstablishmentRequestMock.establismentRequestMock());

            EstablishmentRequest establishmentUpdate = EstablishmentRequestMock.establismentRequestMock();

            FakeValuesService fakeValuesService = new FakeValuesService(
                    new Locale("pt-BR"), new RandomService());

            String establishmentName = fakeValuesService.bothify("establishment??????");

            establishmentUpdate.setName(establishmentName);

            Establishment establishment = authorize().updateEstablishment(establishmentCreateResponse.getId(), establishmentUpdate);

            assertThat(establishment.getName()).contains(establishmentName);
        }
    }


    @Nested
    @DisplayName("Should delete a Establishments")
    class WhenDeleteEstablishment {

        @Test
        @DisplayName("When create a Establishments and delete Establishment")
        void deleteEstablishment() {
            Establishment establishmentCreateResponse = authorize().createEstablishment(EstablishmentRequestMock.establismentRequestMock());

            Establishment establishment = authorize().fetchEstablishment(establishmentCreateResponse.getId());

            authorize().deleteEstablishment(establishment.getId());

            List<Establishment> establishments = authorize().listEstablishments();

            assertThat(establishments).doesNotContain(establishmentCreateResponse, establishmentCreateResponse);

        }
    }

}
