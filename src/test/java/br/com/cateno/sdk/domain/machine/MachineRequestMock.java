package br.com.cateno.sdk.domain.machine;

import br.com.cateno.sdk.domain.establishment.*;
import br.com.cateno.sdk.util.CNPJCreator;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

public class MachineRequestMock {

        MachineRequest machineMock(){

        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("pt-BR"), new RandomService());

                EstablishmentRequestMock establishmentMock = new EstablishmentRequestMock();

                Establishment establishmentCreateResponse = service.create(establishmentMock.establismentRequestMock());

        MachineRequest machineRequest = new MachineRequest();

        machineRequest.setEstablishmentId();
        return machineRequest;
    }
}
