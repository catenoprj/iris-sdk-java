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
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

 @DisplayName("Given a User service")
 class UserServiceTest implements AuthenticatedStageEnvTest {

    private final UserService service;

    UserServiceTest() {
        final UserApiClient userApiClient = this.getAuthenticatedRetrofit().create(UserApiClient.class);
        this.service = new UserService(userApiClient);
    }

    @Nested
    @DisplayName("When create a new User of Type ADMINISTRADOR")
    class WhenCreateNewUserOfTypeAdministrador {

        @Test
        @DisplayName("Then return the resource User of type Administrator generated with Id")
        void thenReturnTheResourceUserOfTypeAdministradorGeneratedWithId() throws IOException {
            UserRequestMock userMock = new UserRequestMock();
            User userCreateResponse = service.create(userMock.userRequestMock(UserType.ADMINISTRADOR));

            assertThat(userCreateResponse.getId()).isNotNull();

        }
    }

    @Nested
    @DisplayName("When create a new User of type Issuer")
    class WhenCreateNewUserOfTypeIssuer {

        @Test
        @DisplayName("Then return the resource User of type Issuer generated with Id")
        void thenReturnTheResourceUserOfTypeIssuerGeneratedWithId() throws IOException {

            UserRequestMock userMock = new UserRequestMock();

            User userCreateResponse = service.create(userMock.userRequestMock(UserType.EMISSOR));
            assertThat(userCreateResponse.getId()).isNotNull();

        }
    }

    @Nested
    @DisplayName("When create a new User of type Establishment")
    class WhenCreateNewUserOfTypeEstablishment {

        @Test
        @DisplayName("Then return the resource User of type Establishment generated with Id")
        void thenReturnTheResourceUserOfTypeEstablishmentGeneratedWithId() throws IOException {

            UserRequestMock userMock = new UserRequestMock();

            User userCreateResponse = service.create(userMock.userRequestMock(UserType.ESTABELECIMENTO));
            assertThat(userCreateResponse.getId()).isNotNull();

         }
     }

     @Nested
     @DisplayName("When create a new User of type Cateno")
     class WhenCreateNewUserOfTypeCateno {

         @Test
         @DisplayName("Then return the resource User of type Cateno generated with Id")
         void thenReturnTheResourceUserOfTypeCatenoGeneratedWithId() throws IOException {

             UserRequestMock userMock = new UserRequestMock();

             User userCreateResponse = service.create(userMock.userRequestMock(UserType.CATENO));
             assertThat(userCreateResponse.getId()).isNotNull();

         }
     }

    @Nested
    @DisplayName("When search a new User by your ID")
    class WhenSearchUserById {

        @Test
        @DisplayName("Then return the related resource with the same ID")
        void thenReturnTheRelatedResourceWithTheSameId() throws IOException {

            UserRequestMock userMock = new UserRequestMock();
            User userCreateResponse = service.create(userMock.userRequestMock(UserType.ADMINISTRADOR));

            User userRequestResponse = service.fetch(userCreateResponse.getId());

            assertThat(userRequestResponse.getId()).isNotNull();
        }
    }

    @Nested
    @DisplayName("When search a list Users")
    class WhenSearchListUser {

        @Test
        @DisplayName("Then return a list of Users containing the last two above Users")
        void thenReturnAListOfUsersContainingTheLastTwoAboveUsers() throws IOException {

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
         @DisplayName("Then delete it properly")
         void thenDeleteItProperly() throws IOException {

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
         @DisplayName("Then update it properly")
         void thenUpdateItProperly() throws IOException {

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
            userRequest.setProfileId(userCreateResponse.getProfileId());
            userRequest.setUserType(userCreateResponse.getUserType());

            User userUpdateResponse = service.update(userCreateResponse.getId(),userRequest);

            assertThat(userUpdateResponse.getName()).isNotEqualTo(userCreateResponse.getName());
            assertThat(userUpdateResponse.getCpf()).isNotEqualTo(userCreateResponse.getCpf());
        }
    }

    @Nested
    @DisplayName("When partial update a new User")
    class WhenPartialUpdateUser {

        @Test
        @DisplayName("Then partial update a new User")
        void thenPartialUpdateANewUser() throws IOException {

            UUID userId = UUID.fromString("c947262e-2d8d-45e1-9c89-e44dd454325c");

            User userRequestResponse = service.fetch(userId);

            UserUpdateRequest userRequest = new UserUpdateRequest();

            FakeValuesService fakeValuesService = new FakeValuesService(
                    new Locale("pt-BR"), new RandomService());

            String name = fakeValuesService.bothify("user-cateno??????");

            userRequest.setName(name);

            User userpartialUpdateResponse = service.partialUpdate(userId,userRequest);

            assertThat(userpartialUpdateResponse.getName()).isNotEqualTo(userRequestResponse.getName());

            userRequest.setName("User Admin");
            service.partialUpdate(userId,userRequest);
        }
    }

     @Nested
     @DisplayName("When request a list of users types")
     class whenRequestAListOfUsersTypes {

         @Test
         @DisplayName("Then return the list types")
         void thenReturnTheListTypes() throws IOException {

             List<String> userType = service.types();
             assertThat(userType.size()).isEqualTo(4);

         }
     }
}
