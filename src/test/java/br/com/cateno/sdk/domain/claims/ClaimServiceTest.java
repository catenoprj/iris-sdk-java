package br.com.cateno.sdk.domain.claims;

import br.com.cateno.sdk.domain.claim.Claim;
import br.com.cateno.sdk.domain.claim.ClaimApiClient;
import br.com.cateno.sdk.domain.claim.ClaimService;
import br.com.cateno.sdk.util.AuthenticatedStageEnvTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DisplayName("Given a Claim service")
class ClaimServiceTest implements AuthenticatedStageEnvTest {

    private final ClaimService service;

    ClaimServiceTest() {
        final ClaimApiClient claimApiClient = this.getAuthenticatedRetrofit().create(ClaimApiClient.class);
        this.service = new ClaimService(claimApiClient);
    }

    //TO DO CREATE A NEW CLAIM

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
}
