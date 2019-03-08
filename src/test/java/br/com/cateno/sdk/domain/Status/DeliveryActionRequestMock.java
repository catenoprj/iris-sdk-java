package br.com.cateno.sdk.domain.Status;

import br.com.cateno.sdk.domain.status.Action;
import br.com.cateno.sdk.domain.status.ActionRequest;
import br.com.cateno.sdk.domain.status.DeliveryActionApiClient;
import br.com.cateno.sdk.domain.status.DeliveryActionService;
import br.com.cateno.sdk.util.AuthenticatedStageEnvTest;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.io.IOException;
import java.util.Locale;

public class DeliveryActionRequestMock implements AuthenticatedStageEnvTest {

    ActionRequest deliveryCreateResponse()  {


        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("pt-BR"), new RandomService());

        String deliveryActionName = fakeValuesService.bothify("DeliveryAction????##");

        ActionRequest actionRequestDelivery = new ActionRequest();

        actionRequestDelivery.setDescription(deliveryActionName);

        return actionRequestDelivery;
    }

    public Action deliveryCreate() throws IOException {

        DeliveryActionApiClient deliveryApiClient = this.getAuthenticatedRetrofit().create(DeliveryActionApiClient.class);
        DeliveryActionService deliveryService = new DeliveryActionService(deliveryApiClient);

        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("pt-BR"), new RandomService());

        String deliveryActionName = fakeValuesService.bothify("DeliveryAction????##");

        ActionRequest actionRequestDelivery = new ActionRequest();

        actionRequestDelivery.setDescription(deliveryActionName);

        return deliveryService.create(actionRequestDelivery);
    }

}
