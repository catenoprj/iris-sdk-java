package br.com.cateno.sdk.domain.Status;

import br.com.cateno.sdk.domain.status.Action;
import br.com.cateno.sdk.domain.status.ActionRequest;
import br.com.cateno.sdk.domain.status.FinanceActionApiClient;
import br.com.cateno.sdk.domain.status.FinanceActionService;
import br.com.cateno.sdk.util.AuthenticatedStageEnvTest;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.io.IOException;
import java.util.Locale;

public class FinanceActionRequestMock implements AuthenticatedStageEnvTest {

    ActionRequest financeCreateResponse() {


        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("pt-BR"), new RandomService());

        String financeActionName = fakeValuesService.bothify("FinanceAction????##");

        ActionRequest actionRequestFinance = new ActionRequest();
        actionRequestFinance.setDescription(financeActionName);

        return actionRequestFinance;
    }

    public Action financeCreate() throws IOException {

        FinanceActionApiClient financeApiClient = this.getAuthenticatedRetrofit().create(FinanceActionApiClient.class);
        FinanceActionService financeService = new FinanceActionService(financeApiClient);

        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("pt-BR"), new RandomService());

        String financeActionName = fakeValuesService.bothify("FinanceAction????##");

        ActionRequest actionRequestFinance = new ActionRequest();

        actionRequestFinance.setDescription(financeActionName);

        return financeService.create(actionRequestFinance);
    }
}
