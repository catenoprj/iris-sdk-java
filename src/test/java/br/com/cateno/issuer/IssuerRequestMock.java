package br.com.cateno.issuer;

import br.com.cateno.util.CNPJCreator;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import java.util.Locale;

class IssuerRequestMock {


    static IssuerRequest issuerRequestMock(){

        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("pt-BR"), new RandomService());

        ExtraInfo extraInfo = new ExtraInfo();

        String issuerCode = fakeValuesService.regexify("[1-9]{6}");
        String email = fakeValuesService.bothify("????##@gmail.com");
        String mainPhone = "11" + fakeValuesService.regexify("[1-9]{8}");
        String backupPhone = "11" + fakeValuesService.regexify("[1-9]{8}");
        String issuerName = fakeValuesService.bothify("issuer??????");

        extraInfo.setMainPhone(mainPhone);
        extraInfo.setBackupPhone(backupPhone);
        extraInfo.setEmail(email);

        IssuerRequest issuerRequest = new IssuerRequest();

        issuerRequest.setCnpj(CNPJCreator.featchCNPJWithOutDigit());
        issuerRequest.setExtraInfo(extraInfo);
        issuerRequest.setIssuerCode(issuerCode);
        issuerRequest.setName(issuerName);

        return issuerRequest;
    }
}
