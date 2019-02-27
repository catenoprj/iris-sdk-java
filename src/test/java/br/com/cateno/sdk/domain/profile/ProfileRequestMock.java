package br.com.cateno.sdk.domain.profile;

import br.com.cateno.sdk.domain.user.Operation;
import br.com.cateno.sdk.domain.user.ProfileRequest;
import br.com.cateno.sdk.domain.user.UserType;
import br.com.cateno.sdk.util.AuthenticatedStageEnvTest;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class ProfileRequestMock implements AuthenticatedStageEnvTest {

    ProfileRequest profileRequestMock() {

        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("pt-BR"), new RandomService());

        String name = fakeValuesService.bothify("profile-cateno??????");

        ProfileRequest profileRequest = new ProfileRequest();
        List<Operation> operations = new ArrayList<>();

        operations.add(Operation.ACTION_CREATE);
        operations.add(Operation.CLAIM_CREATE);
        operations.add(Operation.USER_READ);
        operations.add(Operation.ESTABLISHMENT_READ);
        operations.add(Operation.ISSUER_READ);

        profileRequest.setName(name);
        profileRequest.setOperations(operations);
        profileRequest.setUserType(UserType.CATENO);

        return profileRequest;
    }
}
