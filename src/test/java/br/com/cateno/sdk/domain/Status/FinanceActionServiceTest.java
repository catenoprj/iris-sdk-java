package br.com.cateno.sdk.domain.Status;

import br.com.cateno.sdk.domain.status.Action;
import br.com.cateno.sdk.domain.status.ActionRequest;
import br.com.cateno.sdk.domain.status.FinanceActionApiClient;
import br.com.cateno.sdk.domain.status.FinanceActionService;
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

class FinanceActionServiceTest implements AuthenticatedStageEnvTest {

    private final FinanceActionService service;

    FinanceActionServiceTest() {
        final FinanceActionApiClient financeActionApiClient = this.getAuthenticatedRetrofit().create(FinanceActionApiClient.class);
        this.service = new FinanceActionService(financeActionApiClient);
    }

    @Nested
    @DisplayName("When create a new Finance Action")
    class whenCreateANewFinanceAction {

        @Test
        @DisplayName("Then return the resource Finance Action generated with Id")
        void thenReturnTheResourceFinanceActionGeneratedWithId() throws IOException {
            FinanceActionRequestMock financeMock = new FinanceActionRequestMock();

            Action financeCreateResponse = service.create(financeMock.financeCreateResponse());
            assertThat(financeCreateResponse.getId()).isNotNull();
        }
    }

    @Nested
    @DisplayName("When search by Id a new Finance Action")
    class whenSearchByIdANewFinanceAction {

        @Test
        @DisplayName("Then return the related resource with the same ID")
        void thenReturnTheRelatedResourceWithTheSameId() throws IOException {

            FinanceActionRequestMock financeMock = new FinanceActionRequestMock();

            Action financeCreateResponse = service.create(financeMock.financeCreateResponse());

            Action financeResponse = service.fetch(financeCreateResponse.getId());

            assertThat(financeResponse.getId()).isNotNull();
        }
    }

    @Nested
    @DisplayName("When search a list of Finance Actions")
    class whenSearchAListOfFinanceAction {

        @Test
        @DisplayName("Then return a list of Finance Actions containing the last two above Finance Actions")
        void thenReturnAListOfFinanceActionsContainingTheLastTwoAboveFinanceActions() throws IOException {

            FinanceActionRequestMock financeMock = new FinanceActionRequestMock();

            Action financeCreateResponse = service.create(financeMock.financeCreateResponse());
            Action financeCreateResponse2 = service.create(financeMock.financeCreateResponse());

            List<Action> financeList = service.list();
            assertThat(financeList).contains(financeCreateResponse, financeCreateResponse2);
        }
    }

    @Nested
    @DisplayName("When create and request to delete an Finance Action")
    class WhenCreateAndRequestToDeleteAnFinanceAction {

        @Test
        @DisplayName("Then delete it properly")
        void thenDeleteItProperly() throws IOException {

            FinanceActionRequestMock financeMock = new FinanceActionRequestMock();
            Action financeCreateResponse = service.create(financeMock.financeCreateResponse());

            service.delete(financeCreateResponse.getId());

            List<Action> financeList = service.list();

            assertThat(financeList).doesNotContain(financeCreateResponse);
        }
    }

    @Nested
    @DisplayName("When create and request to update an Finance Action")
    class WhenCreateAndRequestToUpdateAnFinanceAction {

        @Test
        @DisplayName("Then update it properly")
        void thenUpdateItProperly() throws IOException {

            FinanceActionRequestMock financeMock = new FinanceActionRequestMock();
            Action financeCreateResponse = service.create(financeMock.financeCreateResponse());

            ActionRequest financeRequest = new ActionRequest();

            FakeValuesService fakeValuesService = new FakeValuesService(
                    new Locale("pt-BR"), new RandomService());

            String actionDescription = fakeValuesService.bothify("FinanceAction????##");
            financeRequest.setDescription(actionDescription);

            Action financeUpdateResponse = service.update(financeCreateResponse.getId(),financeRequest);

            assertThat(financeUpdateResponse.getDescription()).isNotEqualTo(financeCreateResponse.getDescription());
        }
    }
}
