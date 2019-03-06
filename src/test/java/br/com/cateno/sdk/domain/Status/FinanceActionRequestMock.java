package br.com.cateno.sdk.domain.Status;

import br.com.cateno.sdk.domain.status.*;
import br.com.cateno.sdk.util.AuthenticatedStageEnvTest;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.io.IOException;
import java.util.Locale;

public class FinanceActionRequestMock implements AuthenticatedStageEnvTest {

    public ActionRequest financeCreateResponse() throws IOException {


        FinanceActionApiClient financeApiClient = this.getAuthenticatedRetrofit().create(FinanceActionApiClient.class);
        FinanceActionService financeService = new FinanceActionService(financeApiClient);

        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("pt-BR"), new RandomService());

        String financeActionName = fakeValuesService.bothify("FinanceAction????##");

        ActionRequest actionRequestFinance = new ActionRequest();

        actionRequestFinance.setDescription(financeActionName);

        return actionRequestFinance;

    }
}
