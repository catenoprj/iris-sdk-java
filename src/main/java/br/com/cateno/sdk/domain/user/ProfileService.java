package br.com.cateno.sdk.domain.user;

import br.com.cateno.sdk.infra.ApiResponseBody;
import dagger.Reusable;
import retrofit2.Call;
import retrofit2.Response;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Provides the local service for accessing, adding, and updating a Profile
 */
@Reusable
public class ProfileService {

    private final ProfileApiClient apiClient;

    @Inject
    public ProfileService(ProfileApiClient apiClient) {
        checkNotNull(apiClient);
        this.apiClient = apiClient;
    }

    public Profile create(final ProfileRequest profile) throws IOException {
        checkNotNull(profile);

        final Call<Profile> call = this.apiClient.create(profile);
        final Response<Profile> response = call.execute();
        return new ApiResponseBody<>(response).successfulBodyOrThrow();
    }

    public Profile fetch(final String id) throws IOException {
        checkNotNull(id);

        final Call<Profile> call = this.apiClient.findById(id);
        final Response<Profile> response = call.execute();
        return new ApiResponseBody<>(response).successfulBodyOrThrow();
    }

    public List<Profile> list() throws IOException {
        final Call<List<Profile>> call = this.apiClient.findAll();
        final Response<List<Profile>> response = call.execute();
        return new ApiResponseBody<>(response).successfulBodyOrThrow();
    }

    public Profile update(final String id, final ProfileRequest profile) throws IOException {
        checkNotNull(id);
        checkNotNull(profile);

        final Call<Profile> call = this.apiClient.update(id, profile);
        final Response<Profile> response = call.execute();
        return new ApiResponseBody<>(response).successfulBodyOrThrow();
    }
}
