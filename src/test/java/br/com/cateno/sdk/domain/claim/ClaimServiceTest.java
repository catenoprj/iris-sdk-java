package br.com.cateno.sdk.domain.claim;

import br.com.cateno.sdk.domain.Status.DeliveryActionRequestMock;
import br.com.cateno.sdk.domain.Status.FinanceActionRequestMock;
import br.com.cateno.sdk.domain.status.Action;
import br.com.cateno.sdk.util.AuthenticatedStageEnvTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.stream.Stream;

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

            Claim claimFetchResponse = service.fetch(claimCreateResponse.getId());
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

            assertThat(claimCountRequest).isGreaterThanOrEqualTo(2);
        }
    }

    @Nested
    @DisplayName("When search Claims with parameter Issuer")
    class whenSearchClaimsWithParameterIssuer {

        @Test
        @DisplayName("Then return a total of Claims with parameter Issuer")
        void thenReturnATotalOfClaimsWithParameterIssuer() throws IOException, InterruptedException {
            ClaimRequestMock claimMock = new ClaimRequestMock();

            Claim claimCreateResponse = service.create(claimMock.claimRequestMock());
            Thread.sleep(2000);

            String expectedId = claimCreateResponse.getId();

            Pagination pagination = Pagination.with(1, 0);
            ClaimFilters claimFilters = ClaimFilters.builder().issuer(claimCreateResponse.getIssuerId().toString()).build();

            String foundId = service.list(claimFilters, pagination)
                    .stream()
                    .findAny()
                    .map(Claim::getId)
                    .get();

            assertThat(foundId).isEqualTo(expectedId);
        }
    }

    @Nested
    @DisplayName("When search Claims with parameter Establishment")
    class whenSearchClaimsWithParameterEstablishment {

        @Test
        @DisplayName("Then return a total of Claims with parameter Establishment")
        void thenReturnATotalOfClaimsWithParameterEstablishment() throws IOException, InterruptedException {
            ClaimRequestMock claimMock = new ClaimRequestMock();

            Claim claimCreateResponse = service.create(claimMock.claimRequestMock());
            Thread.sleep(2000);

            String expectedId = claimCreateResponse.getId();

            Pagination pagination = Pagination.with(1, 0);
            ClaimFilters claimFilters = ClaimFilters.builder().establishment(claimCreateResponse.getCompanyCode()).build();

            String foundId = service.list(claimFilters, pagination)
                    .stream()
                    .findAny()
                    .map(Claim::getId)
                    .get();

            assertThat(foundId).isEqualTo(expectedId);
        }
    }

    @Nested
    @DisplayName("When search Claims with parameter Search Term")
    class whenSearchClaimsWithParameterSearchTerm {

        @Test
        @DisplayName("Then return a total of Claims with parameter Search Term")
        void thenReturnATotalOfClaimsWithParameterSearchTerm() throws IOException, InterruptedException {
            ClaimRequestMock claimMock = new ClaimRequestMock();

            Claim claimCreateResponse = service.create(claimMock.claimRequestMock());
            Thread.sleep(2000);

            String expectedId = claimCreateResponse.getId();
            String searchTerm = claimCreateResponse.getCompanyName();

            Pagination pagination = Pagination.with(1, 0);
            ClaimFilters claimFilters = ClaimFilters.builder().term(searchTerm).build();

            String foundId = service.list(claimFilters, pagination)
                    .stream()
                    .findAny()
                    .map(Claim::getId)
                    .get();

            assertThat(foundId).isEqualTo(expectedId);
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
            ClaimFilters claimFilters = ClaimFilters.builder().status("a").build();

            String claims = service.list(claimFilters, pagination)
                    .stream()
                    .findAny()
                    .map(Claim::getId)
                    .get();

            assertThat(claims).isNotEmpty();
        }
    }

    @Nested
    @DisplayName("When search Claims with parameter Authorization Value")
    class whenSearchClaimsWithParameterAuthorizationValue {

        @Test
        @DisplayName("Then return a total of Claims with parameter Authorization Value")
        void thenReturnATotalOfClaimsWithParameterAuthorizationValue() throws IOException, InterruptedException {
            ClaimRequestMock claimMock = new ClaimRequestMock();

            Claim claimCreateResponse = service.create(claimMock.claimRequestMock());

            Thread.sleep(2000);
            String expectedId = claimCreateResponse.getId();

            Pagination pagination = Pagination.with(30, 0);
            ValueRange authorizationValue = ValueRange.between(claimCreateResponse.getAuthorizationValue(), claimCreateResponse.getAuthorizationValue());

            ClaimFilters claimFilters = ClaimFilters.builder().value(authorizationValue).build();

            Stream<Claim> found = service.list(claimFilters, pagination)
                    .stream()
                    .filter(claim -> claim.getId().equals(expectedId));

            assertThat(found.count()).isGreaterThan(0);
        }
    }

    @Nested
    @DisplayName("When search Claims with parameter Purchase Date")
    class whenSearchClaimsWithParameterPurchaseDate {

        @Test
        @DisplayName("Then return a total of Claims with parameter Purchase Date")
        void thenReturnATotalOfClaimsWithParameterPurchaseDate() throws IOException, InterruptedException {
            ClaimRequestMock claimMock = new ClaimRequestMock();

            Claim claimCreateResponse = service.create(claimMock.claimRequestMock());

            Thread.sleep(2000);
            String expectedId = claimCreateResponse.getId();

            Claim claimFetchResponse = service.fetch(claimCreateResponse.getId());

            Pagination pagination = Pagination.with(100, 0);
            PurchaseDateRange purchaseDateRangeDateRange = PurchaseDateRange.between(claimFetchResponse.getAuthorizationDate(), claimFetchResponse.getAuthorizationDate());

            ClaimFilters claimFilters = ClaimFilters.builder().purchaseDate(purchaseDateRangeDateRange).build();

            Stream<Claim> found = service.list(claimFilters, pagination)
                    .stream()
                    .filter(claim -> claim.getId().equals(expectedId));

            assertThat(found.count()).isGreaterThan(0);


        }
    }

    @Nested
    @DisplayName("When search Claims with parameter Close Date")
    class whenSearchClaimsWithParameterCloseDate {

        @Test
        @DisplayName("Then return a total of Claims with parameter Close Date")
        void thenReturnATotalOfClaimsWithParameterCloseDate() throws IOException, InterruptedException {
            ClaimRequestMock claimMock = new ClaimRequestMock();

            Claim claimCreateResponse = service.create(claimMock.claimRequestMock());

            Thread.sleep(2000);
            String expectedId = claimCreateResponse.getId();

            DeliveryActionRequestMock deliveryMock = new DeliveryActionRequestMock();
            Action deliveryAction = deliveryMock.deliveryCreate();

            FinanceActionRequestMock financeMock = new FinanceActionRequestMock();
            Action financeAction = financeMock.financeCreate();

            ClaimUpdateRequest claimUpdateRequest =  new ClaimUpdateRequest();
            claimUpdateRequest.setClaimStatusDescription("Concluido");
            claimUpdateRequest.setClaimStatus("C");
            claimUpdateRequest.setDeliveryStatusId(deliveryAction.getId());
            claimUpdateRequest.setFinanceStatusId(financeAction.getId());

            service.update(claimCreateResponse.getId(), claimUpdateRequest);
            Thread.sleep(2000);

            Claim claimFetchResponse = service.fetch(claimCreateResponse.getId());

            Pagination pagination = Pagination.with(30, 0);
            CloseDateRange closeDateRange = CloseDateRange.between(claimFetchResponse.getCloseDate(), claimFetchResponse.getCloseDate());

            ClaimFilters claimFilters = ClaimFilters.builder().closeDate(closeDateRange).build();

            Stream<Claim> found = service.list(claimFilters, pagination)
                    .stream()
                    .filter(claim -> claim.getId().equals(expectedId));

            assertThat(found.count()).isGreaterThan(0);
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

            claimUpdateRequest.setClaimStatusDescription("Em análise");
            claimUpdateRequest.setClaimStatus("E");

            service.update(claimCreateResponse.getId(), claimUpdateRequest);

            Claim claim = service.fetch(claimCreateResponse.getId());

            assertThat(claim.getClaimStatusDescription()).isEqualTo("Em análise");
        }
    }


}
