package utilities;

import br.com.cateno.client.issuer.model.ExtraInfoRequest;
import br.com.cateno.client.issuer.model.IssuerRequest;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

public class IssuerRequestMock {

    public static IssuerRequest issuerRequestMock(){

        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());

        ExtraInfoRequest extraInfo = new ExtraInfoRequest();

        String issuercode = fakeValuesService.regexify("[1-9]{6}");
        String email = fakeValuesService.bothify("????##@gmail.com");
        String mainphone = "11" + fakeValuesService.regexify("[1-9]{8}");
        String backupphone = "11" + fakeValuesService.regexify("[1-9]{8}");
        String issuername = fakeValuesService.bothify("issuer??????");

        extraInfo.setMainPhone(mainphone);
        extraInfo.setBackupPhone(backupphone);
        extraInfo.setEmail(email);

        IssuerRequest issuer_request = new IssuerRequest();

        issuer_request.setCnpj(CNPJCreator.featchCNPJWithOutDigit());
        issuer_request.setExtraInfo(extraInfo);
        issuer_request.setIssuerCode(issuercode);
        issuer_request.setName(issuername);

        return issuer_request;
    }
}
