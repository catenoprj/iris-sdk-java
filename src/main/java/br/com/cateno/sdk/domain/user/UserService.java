package br.com.cateno.sdk.domain.user;

import br.com.cateno.sdk.infra.ApiResponseBody;
import dagger.Reusable;
import retrofit2.Call;
import retrofit2.Response;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static dagger.internal.Preconditions.checkNotNull;

@Reusable
public class UserService {

    private final UserApiClient apiClient;

    @Inject
    public UserService(UserApiClient apiClient) {
        checkNotNull(apiClient);
        this.apiClient = apiClient;
    }

    public User create(final UserCreateRequest user) throws IOException {
        checkNotNull(user);

        final Call<User> call = this.apiClient.create(user);
        final Response<User> response = call.execute();
        return new ApiResponseBody<>(response).successfulBodyOrThrow();
    }

    public User fetch(final UUID id) throws IOException {
        checkNotNull(id);

        final Call<User> call = this.apiClient.findById(id.toString());
        final Response<User> response = call.execute();
        return new ApiResponseBody<>(response).successfulBodyOrThrow();
    }

    public List<User> list() throws IOException {
        final Call<List<User>> call = this.apiClient.findAll();
        final Response<List<User>> response = call.execute();
        return new ApiResponseBody<>(response).successfulBodyOrThrow();
    }

    public User update(final UUID id, final UserUpdateRequest user) throws IOException {
        checkNotNull(id);
        checkNotNull(user);

        final Call<User> call = this.apiClient.update(id.toString(), user);
        final Response<User> response = call.execute();
        return new ApiResponseBody<>(response).successfulBodyOrThrow();
    }

    public User partialUpdate(final UUID id, final UserUpdateRequest user) throws IOException {
        checkNotNull(id);
        checkNotNull(user);

        final Call<User> call = this.apiClient.partialUpdate(id.toString(), user);
        final Response<User> response = call.execute();
        return new ApiResponseBody<>(response).successfulBodyOrThrow();
    }

    public void delete(final UUID id) throws IOException {
        checkNotNull(id);

        final Call<Void> call = this.apiClient.delete(id.toString());
        Response<Void> response = call.execute();
        new ApiResponseBody<>(response).successfulBodyOrThrow();
    }

    public List<String> types() throws IOException {
        final Call<List<String>> call = this.apiClient.types();
        final Response<List<String>> response = call.execute();
        return new ApiResponseBody<>(response).successfulBodyOrThrow();
    }
}
