package br.com.cateno.sdk.domain.issuer;

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

@DisplayName("Dealing with Issuer")
class IssuerServiceTest {

    private static final String CLIENT_ID = "c8da779c-304f-3204-b5db-67bab9d32871";
    private static final String CLIENT_SECRET = "3a984afc-dc55-3cb5-bc2e-9c2fc4ba7204";
    private static final String USERNAME = "00000000000";
    private static final String PASSWORD = "Guilherme#123";

    private IssuerService service;

    @BeforeEach
    void init() {
        final Client webClient = ClientBuilder.newClient();
        final ClientCredentials client = new ClientCredentials(CLIENT_ID, CLIENT_SECRET);
        final UserCredentials user = new UserCredentials(USERNAME, PASSWORD);
        final AuthService authService = new AuthService(webClient, client, user);
        this.service = new IssuerService(authService, webClient);
    }

    @Nested
    @DisplayName("Should create a new Issuer")
    class WhenCreateNewIssuer {

        @Test
        @DisplayName("When create a new Issuer")
        void createIssuer() {

            Issuer issuerCreateResponse = service.create(IssuerRequestMock.issuerRequestMock());
            assertThat(issuerCreateResponse.getId()).isNotNull();
        }
    }


    @Nested
    @DisplayName("Should search a new Issuer by your ID")
    class WhenSearchNewIssuerById {

        @Test
        @DisplayName("When create a new Issuer and search by your ID")
        void searchIssuerById() {
            Issuer issuerCreateResponse = service.create(IssuerRequestMock.issuerRequestMock());

            Issuer issuer = service.fetch(issuerCreateResponse.getId());
            assertThat(issuer.getId()).isNotNull();
        }
    }

    @Nested
    @DisplayName("Should search a list of Issuers")
    class WhenSearchListIssuer {

        @Test
        @DisplayName("When create some Issuers and search list Issuers")
        void searchIssuers() throws InterruptedException {
            Issuer issuerCreateResponse = service.create(IssuerRequestMock.issuerRequestMock());
            Issuer issuerCreateResponse2 = service.create(IssuerRequestMock.issuerRequestMock());

            List<Issuer> issuers = service.list();
            assertThat(issuers).contains(issuerCreateResponse, issuerCreateResponse2);
        }
    }

    @Nested
    @DisplayName("Should update a Issuer")
    class WhenUpdateIssuer {

        @Test
        @DisplayName("When update a Issuer")
        void updateIssuers() {
            Issuer issuerCreateResponse = service.create(IssuerRequestMock.issuerRequestMock());

            IssuerRequest issuerUpdate = IssuerRequestMock.issuerRequestMock();

            FakeValuesService fakeValuesService = new FakeValuesService(
                    new Locale("pt-BR"), new RandomService());

            String issuerName = fakeValuesService.bothify("issuer??????");

            issuerUpdate.setName(issuerName);

            Issuer issuer = service.update(issuerCreateResponse.getId(), issuerUpdate);

            assertThat(issuer.getName()).contains(issuerName);
        }
    }

}
