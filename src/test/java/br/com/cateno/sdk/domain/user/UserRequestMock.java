package br.com.cateno.sdk.domain.user;

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
import java.util.UUID;

public class UserRequestMock implements AuthenticatedStageEnvTest {


    public UserCreateRequest userRequestMock(UserType userType) throws IOException {

        IssuerApiClient issuerApiClient = this.getAuthenticatedRetrofit().create(IssuerApiClient.class);
        IssuerService issuerService = new IssuerService(issuerApiClient);

        MachineApiClient machineApiClient = this.getAuthenticatedRetrofit().create(MachineApiClient.class);
        MachineService machineService = new MachineService(machineApiClient);

        EstablishmentApiClient establishmentApiClient = this.getAuthenticatedRetrofit().create(EstablishmentApiClient.class);
        EstablishmentService establishmentService = new EstablishmentService(establishmentApiClient);
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("pt-BR"), new RandomService());

        ExtraInfo extraInfo = new ExtraInfo();

        String email = fakeValuesService.bothify("????##@gmail.com");
        String mainPhone = "11" + fakeValuesService.regexify("[1-9]{8}");
        String cpf = fakeValuesService.regexify("[1-9]{11}");
        String backupPhone = "11" + fakeValuesService.regexify("[1-9]{8}");
        String userName = fakeValuesService.bothify("user??????");
        List<UUID> issuerIds = new ArrayList<>();
        List<br.com.cateno.sdk.domain.user.Machine> listMachines = new ArrayList<>();

        br.com.cateno.sdk.domain.user.Machine userMachine =  new br.com.cateno.sdk.domain.user.Machine();

        extraInfo.setMainPhone(mainPhone);
        extraInfo.setBackupPhone(backupPhone);
        extraInfo.setEmail(email);

        UserCreateRequest userRequest = new UserCreateRequest();

        userRequest.setCpf(cpf);
        userRequest.setExtraInfo(extraInfo);
        userRequest.setName(userName);
        userRequest.setUserType(userType);

        userRequest.setProfileId(UUID.fromString("593f21e7-8485-434b-84ba-d486a63a770e"));


        if (userType.equals(UserType.EMISSOR)) {

            IssuerRequestMock issuerMock = new IssuerRequestMock();
            Issuer issuerCreateResponse = issuerService.create(issuerMock.issuerRequestMock());

            issuerIds.add(issuerCreateResponse.getId());

            userRequest.setIssuerIds(issuerIds);

        } else if (userType.equals(UserType.CATENO)) {

            IssuerRequestMock issuerMock = new IssuerRequestMock();
            Issuer issuerCreateResponse = issuerService.create(issuerMock.issuerRequestMock());

            issuerIds.add(issuerCreateResponse.getId().toString());

            userRequest.setIssuerIds(issuerIds);

            MachineRequestMock machineMock = new MachineRequestMock();
            Machine machineCreateResponse = machineService.create(machineMock.machineRequestMock());

            userMachine.setId(machineCreateResponse.getId().toString());
            userMachine.setLabel(machineCreateResponse.getLabel());
            userMachine.setNumber(machineCreateResponse.getNumber());

            Establishment establishment = machineCreateResponse.getEstablishment();

            userMachine.setEstablishmentId(establishment.getId().toString());

            listMachines.add(userMachine);

            userRequest.setMachines(listMachines);

        } else if (userType.equals(UserType.ESTABELECIMENTO)) {

            MachineRequestMock machineMock = new MachineRequestMock();
            Machine machineCreateResponse = machineService.create(machineMock.machineRequestMock());

            userMachine.setId(machineCreateResponse.getId().toString());
            userMachine.setLabel(machineCreateResponse.getLabel());
            userMachine.setNumber(machineCreateResponse.getNumber());

            Establishment establishment = machineCreateResponse.getEstablishment();

            userMachine.setEstablishmentId(establishment.getId().toString());

            listMachines.add(userMachine);

            userRequest.setMachines(listMachines);
        }

        return userRequest;
    }
}
