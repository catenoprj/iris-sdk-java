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
    @DisplayName("Should create a new User ADMINISTRADOR")
    class WhenCreateNewUserAdministrador {

        @Test
        @DisplayName("When create a new User ADMINISTRADOR")
        void createUserAdministrador() throws IOException {
            UserRequestMock userMock = new UserRequestMock();
            User userCreateResponse = service.create(userMock.userRequestMock(UserType.ADMINISTRADOR));

            assertThat(userCreateResponse.getId()).isNotNull();

        }
    }

    @Nested
    @DisplayName("Should create a new User Issuer")
    class WhenCreateNewUserIssuer {

        @Test
        @DisplayName("When create a new User Issuer")
        void createUserIssuer() throws IOException {

            UserRequestMock userMock = new UserRequestMock();

            User userCreateResponse = service.create(userMock.userRequestMock(UserType.EMISSOR));
            assertThat(userCreateResponse.getId()).isNotNull();

        }
    }

    @Nested
    @DisplayName("Should search a new User by your ID")
    class WhenSearchUserById {

        @Test
        @DisplayName("When search a new User by your ID")
        void searchUserById() throws IOException {

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
        @DisplayName("When create some Users and search list of Users")
        void searchUser() throws IOException {

            UserRequestMock userMock = new UserRequestMock();

            User userCreateResponse = service.create(userMock.userRequestMock(UserType.ADMINISTRADOR));
            User userCreateResponse2 = service.create(userMock.userRequestMock(UserType.ADMINISTRADOR));

            List<User> users = service.list();
            assertThat(users).contains(userCreateResponse, userCreateResponse2);
        }
    }

    @Nested
    @DisplayName("Should delete a User")
    class WhenDeleteUser {

        @Test
        @DisplayName("When create a User and delete User")
        void deleteUser() throws IOException {

            UserRequestMock userMock = new UserRequestMock();
            User userCreateResponse = service.create(userMock.userRequestMock(UserType.ADMINISTRADOR));

            service.delete(userCreateResponse.getId());

            List<User> userList = service.list();

            assertThat(userList).doesNotContain(userCreateResponse);
        }
    }


    @Nested
    @DisplayName("Should update a new User")
    class WhenUpdateUser {

        @Test
        @DisplayName("When update a new User")
        void updateUser() throws IOException {

            UserRequestMock userMock = new UserRequestMock();
            User userCreateResponse = service.create(userMock.userRequestMock(UserType.ADMINISTRADOR));

            UserUpdateRequest userRequest = new UserUpdateRequest();

            FakeValuesService fakeValuesService = new FakeValuesService(
                    new Locale("pt-BR"), new RandomService());

            String userName = fakeValuesService.bothify("user??????");
            String cpf = fakeValuesService.regexify("[1-9]{11}");

            userRequest.setName(userName);
            userRequest.setCpf(cpf);

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
