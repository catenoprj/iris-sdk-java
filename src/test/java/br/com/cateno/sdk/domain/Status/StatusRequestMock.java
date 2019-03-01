package br.com.cateno.sdk.domain.Status;

import br.com.cateno.sdk.domain.status.*;
import br.com.cateno.sdk.util.AuthenticatedStageEnvTest;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.io.IOException;
import java.util.Locale;

public class StatusRequestMock implements AuthenticatedStageEnvTest {

    public void actionRequestMock() throws IOException {


        DeliveryActionApiClient deliveryApiClient = this.getAuthenticatedRetrofit().create(DeliveryActionApiClient.class);
        DeliveryActionService deliveryService = new DeliveryActionService(deliveryApiClient);

        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("pt-BR"), new RandomService());

        String deliveryActionName = fakeValuesService.bothify("deliveryAction????##");

        ActionRequest actionRequestDelivery = new ActionRequest();

        actionRequestDelivery.setDescription(deliveryActionName);

        deliveryService.create(actionRequestDelivery);


        FinanceActionApiClient financeApiClient = this.getAuthenticatedRetrofit().create(FinanceActionApiClient.class);
        FinanceActionService financeService = new FinanceActionService(financeApiClient);

        String financeActionName = fakeValuesService.bothify("financeAction????##");

        ActionRequest actionRequestFinance = new ActionRequest();

        actionRequestFinance.setDescription(financeActionName);

        financeService.create(actionRequestFinance);

    }
}
