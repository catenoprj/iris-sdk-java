package br.com.cateno.sdk.domain.claim;

import br.com.cateno.sdk.domain.establishment.Machine;
import br.com.cateno.sdk.domain.establishment.MachineApiClient;
import br.com.cateno.sdk.domain.establishment.MachineRequestMock;
import br.com.cateno.sdk.domain.establishment.MachineService;
import br.com.cateno.sdk.domain.issuer.Issuer;
import br.com.cateno.sdk.domain.issuer.IssuerApiClient;
import br.com.cateno.sdk.domain.issuer.IssuerService;
import br.com.cateno.sdk.domain.user.*;
import br.com.cateno.sdk.util.AuthenticatedStageEnvTest;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Locale;

class ClaimRequestMock implements AuthenticatedStageEnvTest {

     ClaimCreateRequest claimRequestMock() throws IOException {

         FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("pt-BR"), new RandomService());

         MachineRequestMock machineMock = new MachineRequestMock();

         MachineApiClient machineApiClient = this.getAuthenticatedRetrofit().create(MachineApiClient.class);
         MachineService machineService = new MachineService(machineApiClient);

         IssuerApiClient issuerApiClient = this.getAuthenticatedRetrofit().create(IssuerApiClient.class);
         IssuerService issuerService = new IssuerService(issuerApiClient);

         Machine machineCreateResponse = machineService.create(machineMock.machineRequestMock());

         UserApiClient userApiClient = this.getAuthenticatedRetrofit().create(UserApiClient.class);
         UserService userService = new UserService(userApiClient);

         UserRequestMock userMock = new UserRequestMock();
         User userCreateResponse = userService.create(userMock.userRequestMock(UserType.EMISSOR));

         Issuer issuerResponse = issuerService.fetch(userCreateResponse.getIssuerIds().get(0));

         String cardNumber = fakeValuesService.regexify("[1-9]{16}");
         ZonedDateTime authorizationDate = ZonedDateTime.now();
         String authorizationValue = fakeValuesService.regexify("[1-9]{3}");
         String authorizationNumber = fakeValuesService.regexify("[1-9]{3}");

         ClaimCreateRequest claimRequest = new ClaimCreateRequest();

         claimRequest.setAuthorizationDate(authorizationDate);
         claimRequest.setAuthorizationNumber(authorizationNumber);
         claimRequest.setAuthorizationValue(new BigDecimal(authorizationValue));
         claimRequest.setCardNumber(cardNumber);
         claimRequest.setIssuerCode(issuerResponse.getIssuerCode());
         claimRequest.setMachine(machineCreateResponse.getNumber());
         /*claimRequest.setReference("123");
         claimRequest.setIndustry("222");
         claimRequest.setTransactionReference("5555");*/

         return claimRequest;
    }
}
