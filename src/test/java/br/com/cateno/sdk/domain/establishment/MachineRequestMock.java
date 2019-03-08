package br.com.cateno.sdk.domain.establishment;

import br.com.cateno.sdk.util.AuthenticatedStageEnvTest;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.io.IOException;
import java.util.Locale;

public class MachineRequestMock implements AuthenticatedStageEnvTest {

    public MachineRequest machineRequestMock() throws IOException {

        EstablishmentApiClient establishmentApiClient = this.getAuthenticatedRetrofit().create(EstablishmentApiClient.class);
        EstablishmentService establishmentService = new EstablishmentService(establishmentApiClient);

        EstablishmentRequestMock establishmentMock = new EstablishmentRequestMock();
        Establishment establishmentCreateResponse = establishmentService.create(establishmentMock.establismentRequestMock());

        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("pt-BR"), new RandomService());


        String number = fakeValuesService.regexify("[1-9]{6}");
        String label = "11" + fakeValuesService.bothify("Machine????##");

        MachineRequest machineRequest = new MachineRequest();

        machineRequest.setEstablishmentId(establishmentCreateResponse.getId());
        machineRequest.setLabel(label);
        machineRequest.setNumber(number);

        return machineRequest;
    }
}
