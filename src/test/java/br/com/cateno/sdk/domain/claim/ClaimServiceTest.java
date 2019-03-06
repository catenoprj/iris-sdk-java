package br.com.cateno.sdk.domain.claim;

import br.com.cateno.sdk.util.AuthenticatedStageEnvTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
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

            Claim claimFetchResponse = service.fetch(UUID.fromString(claimCreateResponse.getId().toString()));
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

            service.create(claimMock.claimRequestMock());
            service.create(claimMock.claimRequestMock());

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

            Pagination pagination = Pagination.with(1, 0);
            ClaimFilters clamFiltes = ClaimFilters.builder().issuer(claimCreateResponse.getIssuerId()).build();

            List<Claim> claim = service.list(clamFiltes, pagination);

            assertThat(claim).contains(claimCreateResponse);
        }
    }

    @Nested
    @DisplayName("When search Claims with parameter Establishment")
    class whenSearchClaimsWithParameterEstablishment {

        @Test
        @DisplayName("Then return a total of Claims with parameter Establishment")
        void thenReturnATotalOfClaimsWithParameterEstablishment() throws IOException {
            ClaimRequestMock claimMock = new ClaimRequestMock();

            Claim claimCreateResponse = service.create(claimMock.claimRequestMock());

            Pagination pagination = Pagination.with(1, 0);
            ClaimFilters clamFiltes = ClaimFilters.builder().establishment(claimCreateResponse.getCompanyCode()).build();

            List<Claim> claim = service.list(clamFiltes, pagination);

            assertThat(claim).contains(claimCreateResponse);
        }
    }

    @Nested
    @DisplayName("When search Claims with parameter Search Term")
    class whenSearchClaimsWithParameterSearchTerm {

        @Test
        @DisplayName("Then return a total of Claims with parameter Search Term")
        void thenReturnATotalOfClaimsWithParameterSearchTerm() throws IOException {
            ClaimRequestMock claimMock = new ClaimRequestMock();

            Claim claimCreateResponse = service.create(claimMock.claimRequestMock());

            String searchTerm = claimCreateResponse.getIssuerName();

            Pagination pagination = Pagination.with(1, 0);
            ClaimFilters clamFiltes = ClaimFilters.builder().term(searchTerm).build();

            List<Claim> claim = service.list(clamFiltes, pagination);

            assertThat(claim).contains(claimCreateResponse);
        }
    }


    @Nested
    @DisplayName("When search Claims with parameter Status")
    class whenSearchClaimsWithParameterStatus {

        @Test
        @DisplayName("Then return a total of Claims with parameter Status")
        void thenReturnATotalOfClaimsWithParameterStatus() throws IOException {
            ClaimRequestMock claimMock = new ClaimRequestMock();

            service.create(claimMock.claimRequestMock());

            Pagination pagination = Pagination.with(10, 0);
            ClaimFilters clamFiltes = ClaimFilters.builder().status("a").build();

            List<Claim> claim = service.list(clamFiltes, pagination);

            assertThat(claim).isNotEmpty();
        }
    }

    @Nested
    @DisplayName("When search Claims with parameter Authorization Value")
    class whenSearchClaimsWithParameterAuthorizationValue {

        @Test
        @DisplayName("Then return a total of Claims with parameter Authorization Value")
        void thenReturnATotalOfClaimsWithParameterAuthorizationValue() throws IOException {
            ClaimRequestMock claimMock = new ClaimRequestMock();

            Claim claimCreateResponse = service.create(claimMock.claimRequestMock());

            Pagination pagination = Pagination.with(10, 0);
            ValueRange authorizationValue = ValueRange.between(claimCreateResponse.getAuthorizationValue(), claimCreateResponse.getAuthorizationValue());


            ClaimFilters clamFiltes = ClaimFilters.builder().value(authorizationValue).build();

            List<Claim> claim = service.list(clamFiltes, pagination);

            assertThat(claim).contains(claimCreateResponse);
        }
    }

    @Nested
    @DisplayName("When search Claims with parameter Purchase Date")
    class whenSearchClaimsWithParameterPurchaseDate {

        @Test
        @DisplayName("Then return a total of Claims with parameter Purchase Date")
        void thenReturnATotalOfClaimsWithParameterPurchaseDate() throws IOException {
            ClaimRequestMock claimMock = new ClaimRequestMock();

            Claim claimCreateResponse = service.create(claimMock.claimRequestMock());

            Pagination pagination = Pagination.with(10, 0);
            PurchaseDateRange purchaseDateRangeDateRange = PurchaseDateRange.between(claimCreateResponse.getAuthorizationDate(), claimCreateResponse.getAuthorizationDate());

            ClaimFilters clamFiltes = ClaimFilters.builder().purchaseDate(purchaseDateRangeDateRange).build();

            List<Claim> claim = service.list(clamFiltes, pagination);

            assertThat(claim).contains(claimCreateResponse);
        }
    }

    @Nested
    @DisplayName("When search Claims with parameter Close Date")
    class whenSearchClaimsWithParameterCloseDate {

        @Test
        @DisplayName("Then return a total of Claims with parameter Close Date")
        void thenReturnATotalOfClaimsWithParameterCloseDate() throws IOException {
            ClaimRequestMock claimMock = new ClaimRequestMock();

            Claim claimCreateResponse = service.create(claimMock.claimRequestMock());

            //tratar claims aqui
            Pagination pagination = Pagination.with(10, 0);
            CloseDateRange closeDateRange = CloseDateRange.between(claimCreateResponse.getCloseDate(), claimCreateResponse.getCloseDate());

            ClaimFilters clamFiltes = ClaimFilters.builder().closeDate(closeDateRange).build();

            List<Claim> claim = service.list(clamFiltes, pagination);

            assertThat(claim).contains(claimCreateResponse);
        }
    }


    @Nested
    @DisplayName("When update Claims Status")
    class whenUpdateClaimsStatus {

        @Test
        @DisplayName("Then return a status of done Claims")
        void thenReturnAStatusOfDoneClaims() throws IOException {
            ClaimRequestMock claimMock = new ClaimRequestMock();

            Claim claimCreateResponse = service.create(claimMock.claimRequestMock());

            ClaimUpdateRequest claimUpdateRequest = new ClaimUpdateRequest();

            claimUpdateRequest.setClaimStatus("Em análise");

            service.update(UUID.fromString(claimCreateResponse.getId()), claimUpdateRequest);

            Claim claim = service.fetch(UUID.fromString(claimCreateResponse.getId()));

            //claimUpdateRequest.setClaimStatusDescription();
            //claimUpdateRequest.setDeliveryStatusId();
            //claimUpdateRequest.setFinanceStatusId();

            /*service.update(UUID.fromString(claimCreateResponse.getId()), claimUpdateRequest);

            Claim claim = service.fetch(UUID.fromString(claimCreateResponse.getId()))*/;

            assertThat(claim.getDeliveryStatusDescription()).isNotEmpty();
        }
    }


}
