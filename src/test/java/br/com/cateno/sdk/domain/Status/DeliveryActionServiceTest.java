package br.com.cateno.sdk.domain.Status;

import br.com.cateno.sdk.domain.status.Action;
import br.com.cateno.sdk.domain.status.ActionRequest;
import br.com.cateno.sdk.domain.status.DeliveryActionApiClient;
import br.com.cateno.sdk.domain.status.DeliveryActionService;
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

class DeliveryActionServiceTest implements AuthenticatedStageEnvTest {

    private final DeliveryActionService service;

    DeliveryActionServiceTest() {
        final DeliveryActionApiClient deliveryActionApiClient = this.getAuthenticatedRetrofit().create(DeliveryActionApiClient.class);
        this.service = new DeliveryActionService(deliveryActionApiClient);
    }

    @Nested
    @DisplayName("When create a new Delivery Action")
    class whenCreateANewDeliveryAction {

        @Test
        @DisplayName("Then return the resource Delivery Action generated with Id")
        void thenReturnTheResourceDeliveryActionGeneratedWithId() throws IOException {
            DeliveryActionRequestMock deliveryMock = new DeliveryActionRequestMock();

            Action deliveryCreateResponse = service.create(deliveryMock.deliveryCreateResponse());
            assertThat(deliveryCreateResponse.getId()).isNotNull();
        }
    }

    @Nested
    @DisplayName("When search by Id a new Delivery Action")
    class whenSearchByIdANewDeliveryAction {

        @Test
        @DisplayName("Then return the related resource with the same ID")
        void thenReturnTheRelatedResourceWithTheSameId() throws IOException {

            DeliveryActionRequestMock deliveryMock = new DeliveryActionRequestMock();

            Action deliveryCreateResponse = service.create(deliveryMock.deliveryCreateResponse());

            Action deliveryResponse = service.fetch(deliveryCreateResponse.getId());

            assertThat(deliveryResponse.getId()).isNotNull();
        }
    }

    @Nested
    @DisplayName("When search a list of Delivery Actions")
    class whenSearchAListOfDeliveryAction {

        @Test
        @DisplayName("Then return a list of Delivery Actions containing the last two above Delivery Actions")
        void thenReturnAListOfDeliveryActionsContainingTheLastTwoAboveDeliveryActions() throws IOException {

            DeliveryActionRequestMock deliveryMock = new DeliveryActionRequestMock();

            Action deliveryCreateResponse = service.create(deliveryMock.deliveryCreateResponse());
            Action deliveryCreateResponse2 = service.create(deliveryMock.deliveryCreateResponse());

            List<Action> deliveryList = service.list();
            assertThat(deliveryList).contains(deliveryCreateResponse, deliveryCreateResponse2);
        }
    }

    @Nested
    @DisplayName("When create and request to delete an Delivery Action")
    class WhenCreateAndRequestToDeleteAnDeliveryAction {

        @Test
        @DisplayName("Then delete it properly")
        void thenDeleteItProperly() throws IOException {

            DeliveryActionRequestMock deliveryMock = new DeliveryActionRequestMock();

            Action deliveryCreateResponse = service.create(deliveryMock.deliveryCreateResponse());

            service.delete(deliveryCreateResponse.getId());

            List<Action> deliveryList = service.list();

            assertThat(deliveryList).doesNotContain(deliveryCreateResponse);
        }
    }

    @Nested
    @DisplayName("When create and request to update an Delivery Action")
    class WhenCreateAndRequestToUpdateAnDeliveryAction {

        @Test
        @DisplayName("Then update it properly")
        void thenUpdateItProperly() throws IOException {

            DeliveryActionRequestMock deliveryMock = new DeliveryActionRequestMock();
            Action deliveryCreateResponse = service.create(deliveryMock.deliveryCreateResponse());

            ActionRequest deliveryRequest = new ActionRequest();

            FakeValuesService fakeValuesService = new FakeValuesService(
                    new Locale("pt-BR"), new RandomService());

            String actionDescription = fakeValuesService.bothify("DeliveryAction????##");
            deliveryRequest.setDescription(actionDescription);

            Action deliveryUpdateResponse = service.update(deliveryCreateResponse.getId(),deliveryRequest);

            assertThat(deliveryUpdateResponse.getDescription()).isNotEqualTo(deliveryCreateResponse.getDescription());
        }
    }

}
