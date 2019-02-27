package br.com.cateno.sdk.domain.claims;

import br.com.cateno.sdk.domain.claim.ClaimApiClient;
import br.com.cateno.sdk.domain.claim.ClaimRequest;
import br.com.cateno.sdk.domain.claim.ClaimService;
import br.com.cateno.sdk.util.AuthenticatedStageEnvTest;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.io.IOException;
import java.util.Locale;

public class ClaimRequestMock implements AuthenticatedStageEnvTest {

    public ClaimRequest claimRequestMock() throws IOException {

        ClaimApiClient claimApiClient = this.getAuthenticatedRetrofit().create(ClaimApiClient.class);
        ClaimService claimService = new ClaimService(claimApiClient);

        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("pt-BR"), new RandomService());

        /*String email = fakeValuesService.bothify("????##@gmail.com");
        String mainPhone = "11" + fakeValuesService.regexify("[1-9]{8}");
        String cpf = fakeValuesService.regexify("[1-9]{11}");
        String backupPhone = "11" + fakeValuesService.regexify("[1-9]{8}");
        String userName = fakeValuesService.bothify("user??????");*/

        ClaimRequest claimRequest = new ClaimRequest();

        return claimRequest;
    }
}
