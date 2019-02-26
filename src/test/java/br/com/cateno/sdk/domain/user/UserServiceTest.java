package br.com.cateno.sdk.domain.user;

import br.com.cateno.sdk.util.AuthenticatedStageEnvTest;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

 class UserServiceTest implements AuthenticatedStageEnvTest {

    private final UserService service;

    UserServiceTest() {
        final UserApiClient userApiClient = this.getAuthenticatedRetrofit().create(UserApiClient.class);
        this.service = new UserService(userApiClient);
    }


    @Nested
    @DisplayName("Should create a new User of Type ADMINISTRADOR")
    class WhenCreateNewUserOfTypeAdministrador {

        @Test
        @DisplayName("Should return the resource User of type Administrator generated with Id")
        void shouldReturnTheResourceUserOfTypeAdministradorGeneratedWithId() throws IOException {
            UserRequestMock userMock = new UserRequestMock();
            User userCreateResponse = service.create(userMock.userRequestMock(UserType.ADMINISTRADOR));

            assertThat(userCreateResponse.getId()).isNotNull();

        }
    }

    @Nested
    @DisplayName("Should create a new User of type Issuer")
    class WhenCreateNewUserOfTypeIssuer {

        @Test
        @DisplayName("Should return the resource User of type Issuer generated with Id")
        void shouldReturnTheResourceUserOfTypeIssuerGeneratedWithId() throws IOException {

            UserRequestMock userMock = new UserRequestMock();

            User userCreateResponse = service.create(userMock.userRequestMock(UserType.EMISSOR));
            assertThat(userCreateResponse.getId()).isNotNull();

        }
    }

    @Nested
    @DisplayName("Should search a new User by your ID")
    class WhenSearchUserById {

        @Test
        @DisplayName("Should return the related resource with the same ID")
        void shouldReturnTheRelatedResourceWithTheSameId() throws IOException {

            UserRequestMock userMock = new UserRequestMock();
            User userCreateResponse = service.create(userMock.userRequestMock(UserType.ADMINISTRADOR));

            User userRequestResponse = service.fetch(userCreateResponse.getId());

            assertThat(userRequestResponse.getId()).isNotNull();
        }
    }

    @Nested
    @DisplayName("Should search a list Users")
    class WhenSearchListUser {

        @Test
        @DisplayName("Should return a list of Users containing the last two above Users")
        void shouldReturnAListOfUsersContainingTheLastTwoAboveUsers() throws IOException {

            UserRequestMock userMock = new UserRequestMock();

            User userCreateResponse = service.create(userMock.userRequestMock(UserType.ADMINISTRADOR));
            User userCreateResponse2 = service.create(userMock.userRequestMock(UserType.ADMINISTRADOR));

            List<User> users = service.list();
            assertThat(users).contains(userCreateResponse, userCreateResponse2);
        }
    }

     @Nested
     @DisplayName("When create and request to delete an User")
     class WhenCreateAndRequestToDeleteAnUser {

         @Test
         @DisplayName("Should delete it properly")
         void shouldDeleteItProperly() throws IOException {

            UserRequestMock userMock = new UserRequestMock();
            User userCreateResponse = service.create(userMock.userRequestMock(UserType.ADMINISTRADOR));

            service.delete(userCreateResponse.getId());

            List<User> userList = service.list();

            assertThat(userList).doesNotContain(userCreateResponse);
        }
    }


     @Nested
     @DisplayName("When create and request to update an User")
     class WhenCreateAndRequestToUpdateAnUser {

         @Test
         @DisplayName("Should update it properly")
         void shouldUpdateItProperly() throws IOException {

            UserRequestMock userMock = new UserRequestMock();
            User userCreateResponse = service.create(userMock.userRequestMock(UserType.ADMINISTRADOR));

            UserUpdateRequest userRequest = new UserUpdateRequest();

            FakeValuesService fakeValuesService = new FakeValuesService(
                    new Locale("pt-BR"), new RandomService());

            String userName = fakeValuesService.bothify("user??????");
            String cpf = fakeValuesService.regexify("[1-9]{11}");

            userRequest.setName(userName);
            userRequest.setCpf(cpf);
            userRequest.setExtraInfo(userCreateResponse.getExtraInfo());
            userRequest.setProfileId(userCreateResponse.getProfileId().toString());
            userRequest.setUserType(userCreateResponse.getUserType());

            User userUpdateResponse = service.update(userCreateResponse.getId(),userRequest);

            assertThat(userUpdateResponse.getName()).isNotEqualTo(userCreateResponse.getName());
            assertThat(userUpdateResponse.getCpf()).isNotEqualTo(userCreateResponse.getCpf());
        }
    }

    @Nested
    @DisplayName("Should partial update a new User")
    class WhenPartialUpdateUser {

        @Test
        @DisplayName("When partial update a new User")
        void partialUpdateUser() throws IOException {

            UserRequestMock userMock = new UserRequestMock();
            User userCreateResponse = service.create(userMock.userRequestMock(UserType.ADMINISTRADOR));

            UserUpdateRequest userRequest = new UserUpdateRequest();

            FakeValuesService fakeValuesService = new FakeValuesService(
                    new Locale("pt-BR"), new RandomService());

            String userName = fakeValuesService.bothify("user??????");

            userRequest.setName(userName);

            User userpartialUpdateResponse = service.partialUpdate(userCreateResponse.getId(),userRequest);

            assertThat(userpartialUpdateResponse.getName()).isNotEqualTo(userCreateResponse.getName());
        }
    }
}
