package br.com.cateno.issuer;

import br.com.cateno.DefaultIrisClient;
import br.com.cateno.IrisClientBuilder;
import br.com.cateno.auth.credential.ClientCredentials;
import br.com.cateno.auth.credential.UserCredentials;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Dealing with Issuer")
class IssuerDataTest {

    private static final String CLIENT_ID = "c8da779c-304f-3204-b5db-67bab9d32871";
    private static final String CLIENT_SECRET = "3a984afc-dc55-3cb5-bc2e-9c2fc4ba7204";
    private static final String USERNAME = "00000000000";
    private static final String PASSWORD = "Guilherme#123";
    private Issuer issuerCreateResponse;
    private Issuer issuer;


    DefaultIrisClient authorize(){
        return  IrisClientBuilder.standard()
                .withClientCredentials(new ClientCredentials(CLIENT_ID, CLIENT_SECRET))
                .withUserCredentials(new UserCredentials(USERNAME, PASSWORD))
                .build();
    }

    @Nested
    @DisplayName("Should create a new Issuer")
    class WhenCreateNewIssuer {

        @Test
        @DisplayName("Should create a new Issuer")
        void createIssuer() {

            issuerCreateResponse = authorize().createIssuer(IssuerRequestMock.issuerRequestMock());
            assertThat(issuerCreateResponse.getId()).isNotNull();
        }
    }


    @Nested
    @DisplayName("Should search a new Issuer by your ID")
    class WhenSearchNewIssuerById {

        @Test
        @DisplayName("Should create a new Issuer and search by your ID")
        void searchIssuerById() {
            issuerCreateResponse = authorize().createIssuer(IssuerRequestMock.issuerRequestMock());

            issuer = authorize().fetchIssuer(issuerCreateResponse.getId());
            assertThat(issuer.getId()).isNotNull();
        }
    }

    @Nested
    @DisplayName("Should search a list Issuer")
    class WhenSearchListIssuer {

        @Test
        @DisplayName("Should create some Issuer and search list Issuers")
        void searchIssuers() {
            issuerCreateResponse = authorize().createIssuer(IssuerRequestMock.issuerRequestMock());
            Issuer issuerCreateResponse2 = authorize().createIssuer(IssuerRequestMock.issuerRequestMock());

            List<Issuer> issuers = authorize().listIssuers();
            assertThat(issuers).contains(issuerCreateResponse, issuerCreateResponse2);
        }
    }

    @Nested
    @DisplayName("Should update a Issuer")
    class WhenUpdateIssuer {

        @Test
        @DisplayName("Should update a Issuer")
        void searchIssuers() {
            issuerCreateResponse = authorize().createIssuer(IssuerRequestMock.issuerRequestMock());

            IssuerRequest issuerUpdate = IssuerRequestMock.issuerRequestMock();

            FakeValuesService fakeValuesService = new FakeValuesService(
                    new Locale("pt-BR"), new RandomService());

            String issuerName = fakeValuesService.bothify("issuer??????");

            issuerUpdate.setName(issuerName);

            issuer = authorize().updateIssuer(issuerCreateResponse.getId(), issuerUpdate);

            assertThat(issuer.getName()).contains(issuerName);
        }
    }

}
