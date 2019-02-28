package br.com.cateno.sdk.domain.claim;

import br.com.cateno.sdk.util.AuthenticatedStageEnvTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DisplayName("Given a Claim service")
class ClaimServiceTest implements AuthenticatedStageEnvTest {

    private final ClaimService service;

    ClaimServiceTest() {
        final ClaimApiClient claimApiClient = this.getAuthenticatedRetrofit().create(ClaimApiClient.class);
        this.service = new ClaimService(claimApiClient);
    }

    @Nested
    @DisplayName("When create a new Claim")
    class WhenCreateANewClaim {

        @Test
        @DisplayName("Then return the resource Claim generated with Id")
        void thenReturnTheResourceClaimGeneratedWithId() throws IOException {
            ClaimRequestMock claimMock = new ClaimRequestMock();

            Claim claimCreateResponse = service.create(claimMock.claimRequestMock());
            assertThat(claimCreateResponse.getId()).isNotNull();
        }
    }

    @Nested
    @DisplayName("When search by Id a new Claim")
    class whenSearchByIdANewClaim {

        @Test
        @DisplayName("Then return the related resource with the same ID")
        void thenReturnTheRelatedResourceWithTheSameId() throws IOException {

            ClaimRequestMock claimMock = new ClaimRequestMock();

            Claim claimCreateResponse = service.create(claimMock.claimRequestMock());

            Claim claimFetchResponse = service.fetch(UUID.fromString(claimCreateResponse.getId()));
            assertThat(claimFetchResponse.getId()).isNotNull();
        }
    }

    @Nested
    @DisplayName("When count a total Claims")
    class whenCountATotalClaims {

        @Test
        @DisplayName("Then return a total of Claims")
        void thenReturnATotalOfClaims() throws IOException {
            ClaimRequestMock claimMock = new ClaimRequestMock();

            Claim claimCreateResponse = service.create(claimMock.claimRequestMock());
            Claim claimCreateResponse2 = service.create(claimMock.claimRequestMock());

            long claimCountRequest = service.count();

            assertThat(claimCountRequest).isEqualTo(2);
        }
    }

    @Nested
    @DisplayName("When search Claims with parameter Issuer")
    class whenSearchClaimsWithParameterIssuer {

        @Test
        @DisplayName("Then return a total of Claims with parameter Issuer")
        void thenReturnATotalOfClaimsWithParameterIssuer() throws IOException {
            ClaimRequestMock claimMock = new ClaimRequestMock();

            Claim claimCreateResponse = service.create(claimMock.claimRequestMock());
            Claim claimCreateResponse2 = service.create(claimMock.claimRequestMock());

            //Arrumar para colocar Issuer aqui como parametro
            long claimCountRequest = service.count();

            assertThat(claimCountRequest).isEqualTo(2);
        }
    }
}
