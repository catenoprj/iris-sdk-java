package br.com.cateno.sdk.domain.user;

import dagger.Reusable;
import retrofit2.Call;
import retrofit2.Response;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }

    public Profile fetch(final UUID id) throws IOException {
        checkNotNull(id);

        final Call<Profile> call = this.apiClient.findById(id.toString());
        final Response<Profile> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }

    public List<Profile> list() throws IOException {
        final Call<List<Profile>> call = this.apiClient.findAll();
        final Response<List<Profile>> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }

    public Profile update(final UUID id, final ProfileRequest profile) throws IOException {
        checkNotNull(id);
        checkNotNull(profile);

        final Call<Profile> call = this.apiClient.update(id.toString(), profile);
        final Response<Profile> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }
}
