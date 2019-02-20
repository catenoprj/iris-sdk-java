package br.com.cateno.sdk.domain.user;

import br.com.cateno.sdk.domain.establishment.EstablishmentApiClient;
import br.com.cateno.sdk.domain.establishment.EstablishmentService;
import br.com.cateno.sdk.domain.issuer.Issuer;
import br.com.cateno.sdk.domain.issuer.IssuerApiClient;
import br.com.cateno.sdk.domain.issuer.IssuerRequestMock;
import br.com.cateno.sdk.domain.issuer.IssuerService;
import br.com.cateno.sdk.util.AuthenticatedStageEnvTest;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UserRequestMock implements AuthenticatedStageEnvTest {


    public UserCreateRequest userRequestMock(UserType userType) throws IOException {

        IssuerApiClient issuerApiClient = this.getAuthenticatedRetrofit().create(IssuerApiClient.class);
        IssuerService issuerService = new IssuerService(issuerApiClient);

        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("pt-BR"), new RandomService());

        ExtraInfo extraInfo = new ExtraInfo();

        String email = fakeValuesService.bothify("????##@gmail.com");
        String mainPhone = "11" + fakeValuesService.regexify("[1-9]{8}");
        String cpf = fakeValuesService.regexify("[1-9]{11}");
        String backupPhone = "11" + fakeValuesService.regexify("[1-9]{8}");
        String userName = fakeValuesService.bothify("user??????");
        List<String> issuerIds = new ArrayList<>();

        extraInfo.setMainPhone(mainPhone);
        extraInfo.setBackupPhone(backupPhone);
        extraInfo.setEmail(email);

        UserCreateRequest userRequest = new UserCreateRequest();

        userRequest.setCpf(cpf);
        userRequest.setExtraInfo(extraInfo);
        userRequest.setName(userName);
        userRequest.setUserType(userType);

        userRequest.setProfileId("593f21e7-8485-434b-84ba-d486a63a770e");


        if (userType.equals(UserType.EMISSOR)) {

            IssuerRequestMock issuerMock = new IssuerRequestMock();
            Issuer issuerCreateResponse = issuerService.create(issuerMock.issuerRequestMock());

            issuerIds.add(issuerCreateResponse.getId().toString());

            userRequest.setIssuerIds(issuerIds);
        }

        return userRequest;
    }
}
