package br.com.cateno.sdk.domain.issuer;

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

@DisplayName("Dealing with Issuer")
class IssuerServiceTest implements AuthenticatedStageEnvTest {

    private final IssuerService service;

    IssuerServiceTest() {
        final IssuerApiClient issuerApiClient = this.getAuthenticatedRetrofit().create(IssuerApiClient.class);
        this.service = new IssuerService(issuerApiClient);
    }

    @Nested
    @DisplayName("When create a new Issuer")
    class WhenCreateANewIssuer {

        @Test
        @DisplayName("Should return the resource Issuer generated with Id")
        void shouldReturnTheResourceIssuerGeneratedWithId() throws IOException {

            IssuerRequestMock issuerMock = new IssuerRequestMock();
            Issuer issuerCreateResponse = service.create(issuerMock.issuerRequestMock());

            assertThat(issuerCreateResponse.getId()).isNotNull();
        }
    }


    @Nested
    @DisplayName("When search a Issuer by your ID")
    class WhenSearchAIssuerByYourId {

        @Test
        @DisplayName("Should return the related resource with the same ID")
        void shouldReturnTheRelatedResourceWithTheSameId() throws IOException {
            IssuerRequestMock issuerMock = new IssuerRequestMock();
            Issuer issuerCreateResponse = service.create(issuerMock.issuerRequestMock());

            Issuer issuer = service.fetch(issuerCreateResponse.getId());
            assertThat(issuer.getId()).isNotNull();
        }
    }

    @Nested
    @DisplayName("When search a list of Issuers")
    class WhenSearchAListOfIssuers {

        @Test
        @DisplayName("Should return a list of Issuers containing the last two above Issuers")
        void shouldReturnAListOfIssuersContainingTheLastTwoAboveIssuers() throws IOException {
            IssuerRequestMock issuerMock = new IssuerRequestMock();
            Issuer issuerCreateResponse = service.create(issuerMock.issuerRequestMock());
            Issuer issuerCreateResponse2 = service.create(issuerMock.issuerRequestMock());

            List<Issuer> issuers = service.list();
            assertThat(issuers).contains(issuerCreateResponse, issuerCreateResponse2);
        }
    }

    @Nested
    @DisplayName("When create and request to update an Issuer")
    class WhenCreateAndRequestToUpdateAnIssuer {

        @Test
        @DisplayName("Should update it properly")
        void shouldUpdateItProperly() throws IOException {
            IssuerRequestMock issuerMock = new IssuerRequestMock();
            Issuer issuerCreateResponse = service.create(issuerMock.issuerRequestMock());

            IssuerRequest issuerUpdate = issuerMock.issuerRequestMock();

            FakeValuesService fakeValuesService = new FakeValuesService(
                    new Locale("pt-BR"), new RandomService());

            String issuerName = fakeValuesService.bothify("issuer??????");

            issuerUpdate.setName(issuerName);

            Issuer issuer = service.update(issuerCreateResponse.getId(), issuerUpdate);

            assertThat(issuer.getName()).contains(issuerName);
        }
    }

}
