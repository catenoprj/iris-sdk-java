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

@DisplayName("Given a Profile service")
class ProfileServiceTest implements AuthenticatedStageEnvTest {

    private final ProfileService service;

    ProfileServiceTest() {
        final ProfileApiClient profileApiClient = this.getAuthenticatedRetrofit().create(ProfileApiClient.class);
        this.service = new ProfileService(profileApiClient);
    }

    @Nested
    @DisplayName("When create a new Profile")
    class WhenCreateNewProfile {

        @Test
        @DisplayName("Then return the resource Profile generated with Id")
        void thenReturnTheResourceProfileGeneratedWithId() throws IOException {
            ProfileRequestMock profileMock = new ProfileRequestMock();

            Profile profileCreateResponse = service.create(profileMock.profileRequestMock());
            assertThat(profileCreateResponse.getId()).isNotNull();
        }
    }

    @Nested
    @DisplayName("When search a new Profile by your ID")
    class WhenSearchNewProfileById {

        @Test
        @DisplayName("Then return the related resource with the same ID")
        void thenReturnTheRelatedResourceWithTheSameId() throws IOException {
            ProfileRequestMock profileMock = new ProfileRequestMock();

            Profile profileCreateResponse = service.create(profileMock.profileRequestMock());

            Profile profile = service.fetch(profileCreateResponse.getId());
            assertThat(profile.getId()).isNotNull();
        }
    }

    @Nested
    @DisplayName("When search a list Profiles")
    class WhenSearchListProfiles {

        @Test
        @DisplayName("Then return a list of Profiles containing the last two above Profiles")
        void thenReturnAListOfProfilesContainingTheLastTwoAboveProfiles() throws IOException {

            ProfileRequestMock profileMock = new ProfileRequestMock();

            Profile profileCreateResponse = service.create(profileMock.profileRequestMock());
            Profile profileCreateResponse2 = service.create(profileMock.profileRequestMock());

            List<Profile> profiles = service.list();
            assertThat(profiles).contains(profileCreateResponse, profileCreateResponse2);
        }
    }

    @Nested
    @DisplayName("When create and request to update an Profile")
    class WhenCreateAndRequestToUpdateAnProfile {

        @Test
        @DisplayName("Then update it properly")
        void thenUpdateItProperly() throws IOException {

            ProfileRequestMock profileMock = new ProfileRequestMock();

            ProfileRequest profileRequest = profileMock.profileRequestMock();

            Profile profileCreateResponse = service.create(profileRequest);


            FakeValuesService fakeValuesService = new FakeValuesService(
                    new Locale("pt-BR"), new RandomService());

            String name = fakeValuesService.bothify("profile-cateno??????");

            profileRequest.setName(name);

            Profile profile = service.update(profileCreateResponse.getId(), profileRequest);

            assertThat(profile.getName()).contains(name);
        }
    }
}
