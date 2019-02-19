package br.com.cateno.sdk.domain.establishment;

import br.com.cateno.sdk.domain.establishment.EstablishmentRequest;
import br.com.cateno.sdk.domain.establishment.ExtraInfo;
import br.com.cateno.util.CNPJCreator;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

 class EstablishmentRequestMock {

    static EstablishmentRequest establismentRequestMock(){

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
}
