package br.com.cateno.sdk.domain.establishment;

import br.com.cateno.sdk.util.AuthenticatedStageEnvTest;
import br.com.cateno.sdk.util.CNPJCreator;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.io.IOException;
import java.util.Locale;

public class EstablishmentRequestMock implements AuthenticatedStageEnvTest {

   public EstablishmentRequest establismentRequestMock(){

        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("pt-BR"), new RandomService());

        ExtraInfo extraInfo = new ExtraInfo();
        String email = fakeValuesService.bothify("????##@gmail.com");
        String mainPhone = "11" + fakeValuesService.regexify("[1-9]{8}");
        String backupPhone = "11" + fakeValuesService.regexify("[1-9]{8}");
        String establishmentName = fakeValuesService.bothify("establishment??????");

        extraInfo.setMainPhone(mainPhone);
        extraInfo.setBackupPhone(backupPhone);
        extraInfo.setEmail(email);

        EstablishmentRequest establishmentRequest = new EstablishmentRequest();

        establishmentRequest.setCnpj(CNPJCreator.featchCNPJWithOutDigit());
        establishmentRequest.setExtraInfo(extraInfo);
        establishmentRequest.setName(establishmentName);

        return establishmentRequest;
    }

    String returnEstablishmentIdWithAMachine() throws IOException {

      EstablishmentApiClient establishmentApiClient = this.getAuthenticatedRetrofit().create(EstablishmentApiClient.class);
      EstablishmentService establishmentService = new EstablishmentService(establishmentApiClient);

      Establishment establishmentCreateResponse = establishmentService.create(establismentRequestMock());

      MachineApiClient machineApiClient = this.getAuthenticatedRetrofit().create(MachineApiClient.class);
      MachineService machineService = new MachineService(machineApiClient);

       FakeValuesService fakeValuesService = new FakeValuesService(
               new Locale("pt-BR"), new RandomService());


       String number = fakeValuesService.regexify("[1-9]{6}");
       String label = "11" + fakeValuesService.bothify("Machine????##");

       MachineRequest machineRequest = new MachineRequest();

       String establishmentId;
       establishmentId = establishmentCreateResponse.getId();

       machineRequest.setEstablishmentId(establishmentId);
       machineRequest.setLabel(label);
       machineRequest.setNumber(number);

       machineService.create(machineRequest);

      return establishmentId;
   }
}
